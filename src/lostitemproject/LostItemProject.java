/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.FlowLayout;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author POOM
 */
public class LostItemProject {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        JFrame jframe = new JFrame();        
        jframe.setSize(890, 590);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null); 
        String pageToGo="login";
        LostItem itemToShow=null;
        Account acc=null;
        //================= TEST ==================
        ViewLostItemGUI viewGUI;
        LoginGUI loginGUI;
        AddLostItemGUI addItemGUI;
        while(!"exit".equals(pageToGo)){
            switch (pageToGo) {
                case "login":
                    loginGUI = new LoginGUI();
                    jframe.add(loginGUI);
                    jframe.setVisible(true);
                    jframe.revalidate();
                    while(loginGUI.getPageToGo()==null){
                        Thread.sleep(1000);                       
                    }
                    pageToGo=loginGUI.getPageToGo();
                    acc = loginGUI.getAccount();
                    jframe.remove(loginGUI);
                    break;
                case "viewAll":
                    viewGUI = new ViewLostItemGUI(acc);
                    jframe.add(viewGUI);
                    jframe.revalidate();
                    while(viewGUI.getPageToGo()==null){
                        viewGUI.update();
                        Thread.sleep(1000);
                    }
                    itemToShow=viewGUI.getFocusItem();
                    pageToGo=viewGUI.getPageToGo();
                    jframe.remove(viewGUI);
                    break;
                case "viewDetails":
//                    jframe.revalidate();
                    
                    
                    
                    break;
                case "addLostItem":
                    addItemGUI = new AddLostItemGUI(acc);
                    jframe.add(addItemGUI);
                    jframe.revalidate();       
                    while(addItemGUI.getPageToGo()==null){
                        Thread.sleep(1000);
                    }
                    pageToGo=addItemGUI.getPageToGo();
                    jframe.remove(addItemGUI);
                    break;
                case "myLostItem":
                    
                    
                    
                    break;
                case "changeStatus":
                    
                    
                    
                    break;
            }
        }
        
        
        
//        System.out.println(item[0]);
//        EachItemGUI itemGUI = new EachItemGUI(item[0]);
        


//        jframe.add(itemGUI);

        //================= TEST ==================
        

        
    }
    
}
