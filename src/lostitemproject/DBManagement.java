/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        stm.execute("insert into item (itemName,itemDes,DateStart,Account_userID,Cate_cateId) "
                + "value ('"+itemName+"','"+itemDesc+"','"+date+"','"+ownerId+"','"+itemCate+"')",Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        while(rs.next()){
            itemId=rs.getInt(1);  
        }
             
        return itemId;
    }
    
    public LostItem[] queryItem(String filter,String orderBy,String locationFilter) 
            throws SQLException, InterruptedException{ 
        ArrayList<LostItem> allLostItem = new ArrayList<LostItem>(); 
        String locationJOIN = "";
        if(!locationFilter.equals("")){
            locationJOIN=" INNER JOIN itemlocation ON itemlocation.ItemStatus_itemStatusId=itemstatus.itemStatusId";
        }
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select item.itemId ,cate.cateName ,account.userName ,item.itemName "
                + ",item.itemDes ,account.userID as OwnerId ,account.userName as Owner_name ,item.dateStart"
                + ",item.dateEnd ,itemstatus.itemStatusDate ,picture.picturePath from item"
                + " INNER JOIN cate ON item.Cate_cateId=cate.cateId"
                + " INNER JOIN itemstatus ON itemstatus.Item_itemId=item.itemId"
                + " INNER JOIN account ON item.Account_userID=Account.userID"
                + locationJOIN                
                + " LEFT JOIN picture ON picture.Item_itemId=item.itemId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate)"
                + " IN (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) "+filter+locationFilter
                + " ORDER BY itemstatus.itemStatusDate "+orderBy);                
        while(rs.next()){
            LostItem tmp = new LostItem();
            tmp.setItemId(rs.getInt("itemId"));
            tmp.setCate(rs.getString("cateName"));
            tmp.setItemName(rs.getString("itemName"));
            tmp.setItemDescription(rs.getString("itemDes"));
            Timestamp timestamp = rs.getTimestamp("DateStart");
            if(timestamp!=null){
                tmp.setDateStart(new java.util.Date(timestamp.getTime()));
            }
            timestamp = rs.getTimestamp("dateEnd");
            if(timestamp!=null){
                tmp.setDateEnd(new java.util.Date(timestamp.getTime()));
            }
            tmp.setOwnerName(rs.getString("Owner_name"));
            tmp.setOwnerId(rs.getInt("OwnerId"));
            String imgName = rs.getString("picturePath");
            if(imgName==null){
                imgName="noImg";
            }
            tmp.setImg(Picture.getImg(imgName));
            tmp.setStatus(queryStatus(tmp.getItemId()));            
            allLostItem.add(tmp);
        }
        
        return allLostItem.toArray(new LostItem[allLostItem.size()]);
    } 
    
    public void updateItem(LostItem item,String date) throws SQLException{ 
        Statement stm=null;
        stm = conn.createStatement();
        stm.execute("UPDATE item SET DateEnd='"+date+"' WHERE itemId="+item.getItemId());
        
    }
    
    public int insertStatus(int itemId,int accountId,int status)
                throws SQLException,ClassNotFoundException{        
        Statement stm=null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String statusDate = sdf.format(new Date());
        stm = conn.createStatement();
        stm.execute("insert into itemstatus (itemStatusDate,Item_itemId,Account_userID,Status_statusID)"
                + "value ('"+statusDate+"',"+itemId+","+accountId+","+status+")",Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = stm.getGeneratedKeys();
        int statusId=-1;
        while(rs.next()){
            statusId=rs.getInt(1);  
        }
        
        
        return statusId;
    }
    
    
    public ItemStatus queryStatus(int itemId)
            throws SQLException{
        ItemStatus stat = new ItemStatus(); 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate as lastUpdate"
                + ",itemstatus.Item_itemId,account.userName"
                + ",status.statusName from itemstatus"
                + " INNER JOIN account ON itemstatus.Account_userID=account.userID"
                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate) IN"
                + " (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) AND itemstatus.Item_itemId="+itemId);
        
        rs.next();
        stat.setStatusId(rs.getInt("itemStatusId"));
        stat.setLastUpdate(rs.getDate("lastUpdate")); 
        stat.setItemId(rs.getInt("Item_itemId"));
        stat.setOwnerName(rs.getString("userName"));
        stat.setStatusName(rs.getString("statusName"));
        queryItemLocation(stat);
//        stat.setLocationId(rs.getInt("locationId"));
        
         
        return stat;
    }
    
    public ItemStatus queryStatusSpecifyType(int itemId,int statusType)
            throws SQLException{
        ItemStatus stat = null; 
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate"
                + " ,itemstatus.Item_itemId ,status.statusName from itemstatus"
                + " INNER JOIN account ON itemstatus.Account_userID=account.userID"
                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
                + " WHERE itemstatus.Status_statusId="+statusType
                + " AND itemstatus.Item_itemId="+itemId);
        
        while(rs.next()){
            stat = new ItemStatus();
            stat.setStatusId(rs.getInt("itemStatusId"));
            stat.setLastUpdate(rs.getDate("itemStatusDate")); 
            stat.setItemId(rs.getInt("Item_itemId"));
            stat.setStatusName(rs.getString("statusName"));
            queryItemLocation(stat);
        }
        
        return stat;
    }
    
    public void deleteStatusSpecifyType(int itemId,int statusType)
            throws SQLException{
        ItemStatus stat = new ItemStatus(); 
        Statement stm = conn.createStatement();

        stm.executeUpdate("DELETE FROM itemstatus WHERE itemstatus.Status_statusId="+statusType
                + " AND itemstatus.Item_itemId="+itemId);

    }
    
    public void insertItemLocation(ArrayList<Integer> locationIds,int ItemStatusId)
                throws SQLException{ 
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into itemlocation (Location_locationId,ItemStatus_itemStatusId) value (?,?)");
        
        for(int i=0;i<locationIds.size();i++){
            psm.setInt(1, locationIds.get(i)+1);
            psm.setInt(2, ItemStatusId);
            psm.executeUpdate();
        }
    }
    public void insertItemLocation(int locationId,int ItemStatusId)
                throws SQLException{ 
        PreparedStatement psm=null;
        psm = conn.prepareStatement("insert into itemlocation (Location_locationId,ItemStatus_itemStatusId) value (?,?)");
        
        psm.setInt(1, locationId+1);
        psm.setInt(2, ItemStatusId);
        psm.executeUpdate();
        
    }
     public void queryItemLocation(ItemStatus stat)
            throws SQLException{
        String[] location=null;
        ArrayList<String> locationName = new ArrayList<String>(); 
        ArrayList<Integer> locationId = new ArrayList<Integer>();
        Statement stm = conn.createStatement();
        String command = "SELECT Location_locationId,location.locationName FROM itemlocation"
                + " INNER JOIN location ON itemlocation.Location_locationId=location.locationId"
                + " WHERE ItemStatus_itemStatusId="+stat.getStatusId();
        ResultSet rs = stm.executeQuery(command);
        
        while(rs.next()){
            locationName.add(rs.getString("locationName"));
            locationId.add(rs.getInt("Location_locationId"));
        }
        
        if(locationName.size()>0){
            stat.setLocationName(locationName);
            stat.setLocationId(locationId);
            
        }
         
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
    
    public Account queryAccount(int accId) throws SQLException {
        Account acc=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT userName,name,surname,userType,userPhone,"
                + "userEmail,userLine,AccountType_accTypeID FROM account WHERE userID="+accId); 
        if(rs.next()){
                acc=new Account(); 
                acc.setAccId(accId); 
                acc.setAccType(rs.getInt("AccountType_accTypeID")); 
                acc.setName(rs.getString("name"));
                acc.setSurname(rs.getString("surname"));
                acc.setUsername(rs.getString("userName")); 
                acc.setEmail(rs.getString("userEmail")); 
                acc.setPhone(rs.getString("userPhone")); 
                acc.setLine(rs.getString("userLine")); 
                acc.setAccTypeStr(rs.getString("userType"));
        }
        return acc;
    }
    
    public Account login(String username,String password) throws SQLException {
        Account acc=null;
        
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM account WHERE userName='"+username+"'"); 
        if(rs.next()){
            if(password.equals(rs.getString("password"))){ 
                acc=new Account(); 
                acc.setAccId(rs.getInt("userID")); 
                acc.setAccType(rs.getInt("AccountType_accTypeID")); 
                acc.setName(rs.getString("name"));
                acc.setSurname(rs.getString("surname"));
                acc.setUsername(username); 
                acc.setPassword(password); 
                acc.setEmail(rs.getString("userEmail")); 
                acc.setPhone(rs.getString("userPhone")); 
                acc.setLine(rs.getString("userLine")); 
                acc.setAccTypeStr(rs.getString("userType"));
            } 
        }
        return acc;
    }
    
    public void deleteItem(int itemId) throws SQLException{
        Statement stm=null;
        stm = conn.createStatement();
        stm.executeUpdate("DELETE FROM item WHERE itemId = "+itemId);    
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
