package lostitemproject;

import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class LostItem {

    private int itemId;
    private String itemName;
    private String itemDescription;
//    private int itemType;
    private String cate;
    private int ownerId;
    private String ownerName;
    private Date dateStart;
    private Date dateEnd;
    private Image img;
    private ItemStatus status;

    public LostItem() {
    }
    public LostItem(int itemId, String itemName, String itemDescription, String cate, int ownerId){ 
        this.itemId = itemId; 
        this.itemName = itemName; 
        this.itemDescription = itemDescription; 
//        this.itemType = itemType; 
        this.cate = cate;
        this.ownerId = ownerId;
    } 

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }


    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

//    public static int addNewLostItem(String itemName, String itemDesc,int ownerId,int itemCate,String date)
//                throws SQLException,ClassNotFoundException{ 
//        Connection conn=null; 
//        Statement stm=null;
//        int itemId=-1;
//        Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db","root","");
//        stm = conn.createStatement();
//        stm.execute("insert into item (itemName,itenmDes,DateStart,Accout_userID,Cate_cateId) "
//                + "value ('"+itemName+"','"+itemDesc+"','"+date+"','"+ownerId+"','"+itemCate+"')",Statement.RETURN_GENERATED_KEYS);
//        ResultSet rs = stm.getGeneratedKeys();
//        rs.next();
//        itemId=rs.getInt(1);       
//        if(conn!=null)
//            conn.close();
//        return itemId;
//    }
 
    public void setItemName(String itemName) { 
        this.itemName = itemName; 
    } 
 
    public void setItemDescription(String itemDescription) { 
        this.itemDescription = itemDescription; 
    } 
 
    public String getCate() { 
        return cate; 
    } 

//    public void setItemType(int itemType) {
//        this.itemType = itemType;
    public void setCate(String cate) {
        this.cate = cate;
    }

    
    public void setOwnerId(int reporterId) {
        this.ownerId = reporterId;
    }
 
    public int getItemId() { 
        return itemId; 
    } 
 
    public String getItemName() { 
        return itemName; 
    } 
 
    public String getItemDescription() { 
        return itemDescription; 
    } 
 
//    public int getItemType() { 
//        return itemType; 
//    } 

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
 
    public int getOwnerId() { 
        return ownerId; 
    } 

//    public static LostItem[] getAllLostItem(String filter,String orderBy) 
//            throws SQLException,ClassNotFoundException{ 
//        ArrayList<LostItem> allLostItem = new ArrayList<LostItem>(); 
//        Connection conn=null; 
//        Statement stm=null;
//        Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db","root","");
//        stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery("select item.itemId ,cate.cateName ,accout.userName ,item.itemName "
//                + ",item.itenmDes ,accout.userID as OwnerId ,accout.userName as Owner_name ,item.DateStart"
//                + ",item.DateEnd ,itemstatus.itemStatusDate from item"
//                + " INNER JOIN cate ON item.Cate_cateId=cate.cateId"
//                + " INNER JOIN itemstatus ON itemstatus.Item_itemId=item.itemId"
//                + " INNER JOIN accout ON itemstatus.Accout_userID=accout.userID"                
//                + " INNER JOIN location ON itemstatus.Location_locationId=location.locationId"
//                + " WHERE (itemstatus.Item_itemId, itemstatus.itemStatusDate)"
//                + " IN (SELECT itemstatus.Item_itemId, Max(itemstatus.itemStatusDate)"
//                + " FROM itemstatus GROUP BY itemstatus.Item_itemId) "+filter
//                + " ORDER BY itemstatus.itemStatusDate "+orderBy);                
//        while(rs.next()){
//            LostItem tmp = new LostItem();
//            tmp.setItemId(rs.getInt("itemId"));
//            tmp.setCate(rs.getString("cateName"));
//            tmp.setItemName(rs.getString("itemName"));
//            tmp.setItemDescription(rs.getString("itenmDes"));
//            tmp.setDateStart(rs.getDate("dateStart"));
//            tmp.setDateEnd(rs.getDate("dateEnd"));
//            tmp.setOwnerName(rs.getString("Owner_name"));
//            tmp.setOwnerId(rs.getInt("OwnerId"));
//            allLostItem.add(tmp);
//        }
//        if(conn!=null)
//            conn.close();
//         
//        return allLostItem.toArray(new LostItem[allLostItem.size()]);
//    } 

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
     
//    public static ArrayList<LostItem> getAllLostItemByLocate(int locationId) { 
//        ArrayList<LostItem> lostItemFilterLocate = new ArrayList<LostItem>(); 
//        //get db 
//        //mapping
//        ArrayList<LostItem> allItemList = getAllLostItem();
//        ArrayList<ItemStatus> allStatusList = ItemStatus.getAllItemStatus();     
//        for(int i=0;i<allStatusList.size();i++){ 
//            if(allStatusList.get(i).getLocationId()==locationId){
//                lostItemFilterLocate.add(allItemList.get(i));
//            }
//        }
//        return lostItemFilterLocate; 
//    } 
//     
//    public static ArrayList<LostItem> getAllLostItemWithLimit(int limit) { 
//        //int limit = endIndex - startIndex + 1; 
//        ArrayList<LostItem> lostItemWithLimit = new ArrayList<LostItem>();
//        ArrayList<LostItem> allItem = getAllLostItem();
//        for (int i = 0; i < limit; i++) { 
//            lostItemWithLimit.add(allItem.get(i));
//            if(i>=allItem.size()-1){
//                break;
//            }
//        } 
//        return lostItemWithLimit; 
//    } 
// 
//    public static ArrayList<LostItem> getAllLostItemByUser(int accId) { 
//        ArrayList<LostItem> allItem = getAllLostItem();
//        ArrayList<LostItem> lostItemFilterUser = new ArrayList<LostItem>(); 
//        for(int i=0;i<allItem.size();i++){ 
//            if(allItem.get(i).getOwnerId()==accId){
//                lostItemFilterUser.add(allItem.get(i));
//            }
//        }
//        return lostItemFilterUser; 
//    } 

    @Override
    public String toString() {
        return "itemName = " + itemName + "\nitemDescription = " + itemDescription +
                "\ncategory=" + cate + "\nownerName=" + ownerName +"\n";
    }
    
 
} 

