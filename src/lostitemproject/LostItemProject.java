package lostitemproject;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LostItemProject {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        JFrame jframe = new JFrame();        
        jframe.setSize(860, 590);
        //=========test background=========
//        File downloadFile = new File("D:/Download/expired");
//        try {
//            Image img = ImageIO.read(downloadFile);
//            if(img==null){
//                downloadFile=new File("D:/Download/expired");
//                img = ImageIO.read(downloadFile);
//            }
//            jframe.setContentPane(new JLabel(new ImageIcon(img)));
//            jframe.setLayout(new GridBagLayout());
//            
//        }catch (IOException ex) {
//            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //=========test background=========
        
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

        //================= TEST ==================

    }
    
}
