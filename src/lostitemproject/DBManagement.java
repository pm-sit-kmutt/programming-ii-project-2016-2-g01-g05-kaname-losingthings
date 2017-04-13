/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author POOM
 */
public class DBManagement {
    Connection conn;

    public DBManagement() {
        conn=null;
    }
    
    
    public void createConnection()
            throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db?user=root&password=&characterEncoding=UTF-8");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db?useUnicode=yes&characterEncoding=utf-8","root","");
    }
    public int insertItem(String itemName, String itemDesc,int ownerId,int itemCate,String date)
                throws SQLException{ 
        Statement stm=null;
        int itemId=-1;
        stm = conn.createStatement();
        stm.execute("insert into item (itemName,itenmDes,DateStart,Accout_userID,Cate_cateId) "
                + "value ('"+itemName+"','"+itemDesc+"','"+date+"','"+ownerId+"','"+itemCate+"')",Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        while(rs.next()){
            itemId=rs.getInt(1);  
        }
             
        return itemId;
    }
    
    public LostItem[] queryItem(String filter,String orderBy) 
            throws SQLException{ 
        ArrayList<LostItem> allLostItem = new ArrayList<LostItem>(); 
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select item.itemId ,cate.cateName ,accout.userName ,item.itemName "
                + ",item.itenmDes ,accout.userID as OwnerId ,accout.userName as Owner_name ,item.DateStart"
                + ",item.DateEnd ,itemstatus.itemStatusDate ,picture.picturePath from item"
                + " INNER JOIN cate ON item.Cate_cateId=cate.cateId"
                + " INNER JOIN itemstatus ON itemstatus.Item_itemId=item.itemId"
                + " INNER JOIN accout ON itemstatus.Accout_userID=accout.userID"                
                + " INNER JOIN location ON itemstatus.Location_locationId=location.locationId"
                + " LEFT JOIN picture ON picture.Item_itemId=item.itemId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate)"
                + " IN (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) "+filter
                + " ORDER BY itemstatus.itemStatusDate "+orderBy);                
        while(rs.next()){
            LostItem tmp = new LostItem();
            tmp.setItemId(rs.getInt("itemId"));
            tmp.setCate(rs.getString("cateName"));
            tmp.setItemName(rs.getString("itemName"));
            tmp.setItemDescription(rs.getString("itenmDes"));
            tmp.setDateStart(rs.getDate("dateStart"));
            tmp.setDateEnd(rs.getDate("dateEnd"));
            tmp.setOwnerName(rs.getString("Owner_name"));
            tmp.setOwnerId(rs.getInt("OwnerId"));
            String imgName = rs.getString("picturePath");
            if(imgName==null){
                imgName="noImg";
            }
            tmp.setImg(Picture.getImg(imgName));
            allLostItem.add(tmp);
        }
        if(conn!=null)
            conn.close();
         
        return allLostItem.toArray(new LostItem[allLostItem.size()]);
    } 
    
    public void insertStatus(int location,int itemId,int accountId,int status)
                throws SQLException,ClassNotFoundException{        
        Statement stm=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String statusDate = sdf.format(new Date());
        stm = conn.createStatement();
        stm.executeUpdate("insert into itemstatus (itemStatusDate,Location_locationId,Item_itemId,Accout_userID,Status_statusID)"
                + "value ('"+statusDate+"',"+location+","+itemId+","+accountId+","+status+")");
    }
    
    public ItemStatus queryStatus(int itemId)
            throws SQLException{
        ItemStatus stat = new ItemStatus(); 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate as lastUpdate"
                + ",location.locationId,location.locationName,itemstatus.Item_itemId,accout.userName"
                + ",status.statusName from itemstatus INNER JOIN location ON itemstatus.Location_locationId=location.locationId"
                + " INNER JOIN accout ON itemstatus.Accout_userID=accout.userID"
                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate) IN"
                + " (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) AND itemstatus.Item_itemId="+itemId);
        
        rs.next();
        stat.setStatusId(rs.getInt("itemStatusId"));
        stat.setLastUpdate(rs.getDate("lastUpdate"));
        stat.setLocationName(rs.getString("locationName"));
        stat.setItemId(rs.getInt("Item_itemId"));
        stat.setOwnerName(rs.getString("userName"));
        stat.setStatusName(rs.getString("statusName"));
        stat.setLocationId(rs.getInt("locationId"));
        
         
        return stat;
    }
    
    public void insertImage(String imgName,int ItemId)
                throws SQLException{ 
        Statement stm=null;
        stm = conn.createStatement();
        stm.executeUpdate("insert into Picture (picturePath,Item_itemId) "
                + "value ('"+imgName+"',"+ItemId+")");             
    }
    
    public String[] queryImage(int itemId)
            throws SQLException{
        String[] imgName=null;
        ArrayList<String> temp = new ArrayList<String>(); 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("SELECT picture.picturePath FROM picture WHERE picture.Item_itemId="+itemId);
        
        while(rs.next()){
            temp.add(rs.getString("picturePath"));
        }
        
        if(temp.size()>0){
            imgName=temp.toArray(new String[temp.size()]);
        }
         
        return imgName;
    }
    
    public String[] queryLocation() throws SQLException{
        ArrayList<String> temp = new ArrayList<String>();
        String[] allLocate = null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT location.locationName FROM location");       
        while(rs.next()){
            temp.add(rs.getString("locationName"));
        }
        
        if(temp.size()>0){
            allLocate=temp.toArray(new String[temp.size()]);
        }
        
        return allLocate;
    }
    
    public   Account login(String username,String password) throws SQLException {
        Account acc=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM accout WHERE userName='"+username+"' AND password='"+password+"'");
        if(rs.next()){
            acc=new Account();
            acc.setAccId(rs.getInt("userID"));
            acc.setAccType(rs.getInt("AccountType_accTypeID"));
            acc.setUsername(username);
            acc.setPassword(password);
            acc.setEmail(rs.getString("userEmail"));
            acc.setPhone(rs.getString("userPhone"));
            acc.setLine(rs.getString("userLine"));
        }
        return acc;
    }
    
    public boolean disconnect() throws SQLException{
        if(conn!=null){
            conn.close();
            conn=null;
            return true;
        }
        return false;
    }
    
    public Connection getCn() {
        return conn;
    }

    public void setCn(Connection cn) {
        this.conn = conn;
    }
    
}
