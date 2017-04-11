/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class ItemStatus {
    private int statusId;
//    private boolean statusFound;
    private int locationId;
    private String locationName;
    private Date lastUpdate;
    private int itemId;
    private String statusName;
    private String ownerName;

    public ItemStatus() {
    }

    
    public ItemStatus(int statusId, boolean statusFound, int locationId, Date lastUpdate, int itemId) {
        this.statusId = statusId;
//        this.statusFound = statusFound;
        this.locationId = locationId;
        this.lastUpdate = lastUpdate;
        this.itemId = itemId;
    }
    
    
//    public boolean getStatusFound() {
//        return statusFound;
//    }
//
//    public void setStatusFound(boolean status) {
//        this.statusFound = status;
//    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
     

//    public static void addStatus(int location,int itemId,int accountId,int status)
//                throws SQLException,ClassNotFoundException{        
//        Connection conn=null; 
//        Statement stm=null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String statusDate = sdf.format(new Date());
//        Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db","root","");
//        stm = conn.createStatement();
//        stm.execute("insert into itemstatus (itemStatusDate,Location_locationId,Item_itemId,Accout_userID,Status_statusID)"
//                + "value ('"+statusDate+"',"+location+","+itemId+","+accountId+","+status+")");
//        if(conn!=null)
//            conn.close();
//    }
    
//    public static ItemStatus getItemStatus(int itemId)
//            throws SQLException,ClassNotFoundException{
//        ItemStatus stat = new ItemStatus();
//        Connection conn=null; 
//        Statement stm=null;
//        Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db","root","");
//        stm = conn.createStatement();
//
//        ResultSet rs = stm.executeQuery("select itemstatus.itemStatusId,itemstatus.itemStatusDate as lastUpdate"
//                + ",location.locationId,location.locationName,itemstatus.Item_itemId,accout.userName"
//                + ",status.statusName from itemstatus INNER JOIN location ON itemstatus.Location_locationId=location.locationId"
//                + " INNER JOIN accout ON itemstatus.Accout_userID=accout.userID"
//                + " INNER JOIN status ON itemstatus.Status_statusId=status.statusId"
//                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate) IN"
//                + " (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
//                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) AND itemstatus.Item_itemId="+itemId);
//        
//        rs.next();
//        stat.setStatusId(rs.getInt("itemStatusId"));
//        stat.setLastUpdate(rs.getDate("lastUpdate"));
//        stat.setLocationName(rs.getString("locationName"));
//        stat.setItemId(rs.getInt("Item_itemId"));
//        stat.setOwnerName(rs.getString("userName"));
//        stat.setStatusName(rs.getString("statusName"));
//        stat.setLocationId(rs.getInt("locationId"));
//        
//        if(conn!=null)
//            conn.close();
//         
//        return stat;
//    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "StatusName = "+statusName+"\nlocationName = " + locationName + "\nlastUpdate = " + lastUpdate + "\nitemId = " + itemId+"\n"
                + "Owner status = "+ownerName;
    }
        
    
}
