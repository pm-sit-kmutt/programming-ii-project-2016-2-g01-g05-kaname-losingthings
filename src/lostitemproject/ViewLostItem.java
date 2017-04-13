/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POOM
 */
public class ViewLostItem {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        int input;
        Account acc=null;
        DBManagement dbm = new DBManagement();
        try {
            while(acc==null){
                System.out.print("Enter username : ");
                String username=sc.nextLine();
                System.out.print("Enter password : ");
                String pass=sc.nextLine();
                dbm.createConnection();
                acc=dbm.login(username, pass);
                if(acc==null){
                    System.out.println("invalid username or password");
                }
                dbm.disconnect();
            }
            String condition = "";
            System.out.println("1 - View my item\n2 - View all item");
            System.out.print("Choose (number) : ");
            input=sc.nextInt();
            if(input==1){
                condition="AND item.Accout_userID="+acc.getAccId();
            }else{
                System.out.println("===category list===\n0 - All Category\n1 - device\n2 - costume\n3 - Bag\n4 - Key\n5 - Other");
                System.out.print("Enter Item category (number) : ");
                input = sc.nextInt();              
                if(input!=0){
                    condition="AND Cate_cateId="+input;
                }

                System.out.println("===location list===\n0.All Location");
                dbm.createConnection();
                String locateList[] = dbm.queryLocation();
                dbm.disconnect();
                for(int i=0;i<locateList.length;i++){
                    System.out.println((i+1)+"."+locateList[i]);
                }
                System.out.print("Enter location (number) : ");
                input = sc.nextInt();
                if(input!=0){        
                    condition+=" AND Location_locationId="+input;                   
                }
            }
            System.out.print("===status list===\n0 - All Status\n1 - Lost.\n2 - Found.\n3 - Received\nChoose (number) : ");
            input=sc.nextInt();
            if(input!=0){
                condition+="AND itemstatus.Status_statusId="+input;
            }
            System.out.print("===Order By===\n1 - Newest First.\n2 - Oldest first.\nChoose (number) : ");
            String orderBy=(sc.nextInt()==1?"DESC":"ASC");
            dbm.createConnection();
            LostItem item[] = dbm.queryItem(condition,orderBy);
            dbm.disconnect();
            for(int i=0;i<item.length;i++){
                System.out.println((i+1)+"."+item[i]);
            }
            System.out.print("Inspect Item (select number) : ");
            int focusItem = sc.nextInt();
            dbm.createConnection();
            ItemStatus stat = dbm.queryStatus(item[focusItem-1].getItemId());
            String[] imgName = dbm.queryImage(item[focusItem-1].getItemId());           
            dbm.disconnect();
            System.out.println(stat);  
            if(imgName!=null){
                System.out.println(Picture.getImg(imgName[0]));
            }
            System.out.println("1 - change status\n2 - back");
            System.out.print("Choose (number) : ");
            input = sc.nextInt();
            while(input==1){                                                
                if(acc.getAccType()==1){
                    System.out.println("1 - Lost\n2 - Found via kaname\n3 - Received\n4 - delete");
                    System.out.print("Choose (number) : ");
                    dbm.createConnection();
                    dbm.insertStatus(stat.getLocationId(), stat.getItemId(), acc.getAccId(),sc.nextInt());  
                    
                    System.out.println("Change Status Completed.");
                    stat = dbm.queryStatus(item[focusItem-1].getItemId());
                    dbm.disconnect();
                    System.out.println(stat);                                
                }else if(item[focusItem-1].getOwnerId()==acc.getAccId()){
                    System.out.println("2 - Found by myself");
                    System.out.print("Choose (number) : ");
                    dbm.createConnection();
                    dbm.insertStatus(stat.getLocationId(), stat.getItemId(), acc.getAccId(),sc.nextInt());  
                    
                    System.out.println("Change Status Completed.");
                    stat = dbm.queryStatus(item[focusItem-1].getItemId());
                    dbm.disconnect();
                    System.out.println(stat);       
                    
                }else{
                    System.out.println("You don't have permission to change status this item.");
                }
                System.out.println("1 - change status\n2 - back");
                System.out.print("Choose (number) : ");
                input = sc.nextInt();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Invalid Input -> Data not found.");
        }
    }
}
