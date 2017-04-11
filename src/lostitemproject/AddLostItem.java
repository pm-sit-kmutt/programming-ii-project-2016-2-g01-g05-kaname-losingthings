/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author POOM
 */
public class AddLostItem {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        String name,des,date,imgName;
        int owner,cate,location,accountId=1,itemId;
        DBManagement dbm = new DBManagement();
        
        try {
            System.out.print("Enter name : ");
            name=sc.nextLine();
            System.out.print("Enter Description : ");
            des=sc.nextLine();
            System.out.println("===category list===\n1.device\n2.costume\n3.Bag\n4.Key\n5.Other");
            System.out.print("Enter Item category (number) : ");
            cate=sc.nextInt();
            System.out.println("===location list===");
            dbm.createConnection();
            String locateList[] = dbm.queryLocation();
            dbm.disconnect();
            for(int i=0;i<locateList.length;i++){
                System.out.println((i+1)+"."+locateList[i]);
            }
            System.out.print("Enter location (number) : ");
            location=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Lost Date(YYYY-MM-DD) : ");
            date=sc.nextLine();
            System.out.println("choose image file to upload...");
            imgName = Picture.uploadImg();
            dbm.createConnection();           
            itemId = dbm.insertItem(name,des,accountId,cate,date);
            dbm.insertStatus(location, itemId, accountId,1);
            if(imgName!=null){
                dbm.insertImage(imgName, itemId);
            }
            dbm.disconnect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
