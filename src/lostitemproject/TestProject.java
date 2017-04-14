/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import com.mysql.jdbc.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author POOM
 */
public class TestProject {

    public static void main(String[] args){
//        AddLostItem.run();
//        ViewLostItem.run();
        
        
        
        /*Connection conn=null;
        Statement stm=null;
        //int itemId=1,dateId=1,statusId=1;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load Driver Success.");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaname_db","root","");
            System.out.println("Connect Successful.");
            stm = conn.createStatement();
//            stm.execute("insert into item (itemName,itenmDes,Accout_userID,Date_dateId,Cate_cateId) "
//                    + "value ('pant','long pant with black color','0','0','1')");
//            System.out.println("insert pant success.");
//            stm.execute("insert into item (itemName,itenmDes,Accout_userID,Date_dateId,Cate_cateId) "
//                    + "value ('notebook','white color,have dog sticker on top','0','0','0')");
//            System.out.println("insert โน้ตบุ๊ค success.");
//            ResultSet rs = stm.executeQuery("select * from item,accout,cate where Cate_cateId='1'");
            ResultSet rs = stm.executeQuery("select item.*,cate.cateName from item INNER JOIN cate ON item.Cate_cateId=cate.cateId");
            
            while(rs.next()){
                System.out.println("item Id = "+rs.getInt("itemId"));
                System.out.println("item category = "+rs.getString("cateName"));
                System.out.println("item Name = "+rs.getString("itemName"));
                System.out.println("item Description = "+rs.getString("itenmDes"));
                //System.out.println("report date = "+rs.getDate("dateStart"));
                //System.out.println("item owner = "+rs.getString("userName"));
                System.out.println("------------------");
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{            
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }*/
    }
}
