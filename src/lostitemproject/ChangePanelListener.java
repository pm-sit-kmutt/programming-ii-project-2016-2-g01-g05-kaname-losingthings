/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author POOM
 */
public class ChangePanelListener implements ActionListener{
    
    public static int BACKTO_HOMEPAGE=0;
    public static int DETAIL=1;
    public static int ADD_LOSTITEM=2;
    public static int CONFIRM_ADDITEM=3;
    public static int CONFIRM_CHANGE_STATUS=4;
    public static int LOGIN=5;
    public static int LOGOUT=6;
    
    private LostItemFrame mainFrame;
    private int buttonCase;
    private LostItem bindingItem;
    

    public ChangePanelListener(LostItemFrame mainFrame,int buttonCase) {
        this.mainFrame = mainFrame;
        this.buttonCase = buttonCase;
    }
    
    public ChangePanelListener(LostItemFrame mainFrame,int buttonCase,LostItem item) {
        this.mainFrame = mainFrame;
        this.buttonCase = buttonCase;
        this.bindingItem = item;
    }

     
    public LostItemFrame getMainFrame(LostItemFrame frame) {
        return mainFrame;
    }

    public void setMainFrame(LostItemFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DBManagement dbm = new DBManagement();
        switch(buttonCase){
            case 0:
                mainFrame.toViewPage();
                break;
                
            case 1:
                mainFrame.setFocusItem(bindingItem);
                mainFrame.toDetailPage();
                break;
            case 2:
                mainFrame.toAddItemPage();
                break;
                
                
            case 3:
                int itemId;
                try {           
                    dbm.createConnection();
                    String name,des;
                    int accId,cate,locationInt;
                    String date,dateNew;
                    name=mainFrame.getAddItemPage().getTextName().getText();
                    des=mainFrame.getAddItemPage().getTextDescription().getText();
                    accId=mainFrame.getUser().getAccId();
                    cate=mainFrame.getAddItemPage().getComboLostItem().getSelectedIndex()+1;
                    locationInt=mainFrame.getAddItemPage().getLocationCombo().getSelectedIndex()+1;
                    date=mainFrame.getAddItemPage().getDateTimePicker1().getDatePicker().getDateStringOrEmptyString()
                            +" "+mainFrame.getAddItemPage().getDateTimePicker1().getTimePicker().getTimeStringOrEmptyString();
                    dateNew=mainFrame.getDetailPage().getCsp().getDateTimePickerStatus().getDatePicker().getDateStringOrEmptyString()
                            +" "+mainFrame.getDetailPage().getCsp().getDateTimePickerStatus().getTimePicker().getTimeStringOrEmptyString();
                    
                    System.out.println("date = "+date);
                    if(!(name.equals("")||date.equals(" "))){
                        itemId = dbm.insertItem(name,des,accId,cate,date);
                        dbm.insertStatus(locationInt, itemId, accId,1);

                        if(mainFrame.getAddItemPage().getImgName()!=null){
                            dbm.insertImage(mainFrame.getAddItemPage().getImgName(), itemId);
                        }
                        dbm.disconnect();
                        JOptionPane.showMessageDialog(mainFrame, "แจ้งของหายเรียบร้อยแล้ว.");
                        mainFrame.toViewPage();
                    }else{
                        JOptionPane.showMessageDialog(mainFrame, "ใส่ข้อมูลไม่ครบ");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "โปรดตรวจสอบการเชื่อมต่ออินเทอร์เน็ต");
                    ex.printStackTrace();
                    System.out.println("SQL Exception!");
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
                
            case 4:
                
                
                break;
            case 5:
                try {
//                    mainFrame.getLoginPage().getLoginBtn().setText("กำลัง LOGIN..");
                    mainFrame.getLoginPage().getLoginBtn().setEnabled(false);
                    dbm.createConnection();
                    String user = mainFrame.getLoginPage().getTextUsername().getText();
                    String pass = new String(mainFrame.getLoginPage().getTextPassword().getPassword());
                    mainFrame.setUser(dbm.login(user,pass));
                    if(mainFrame.getUser()!=null){
                        mainFrame.toViewPage();
                    }else{
//                        mainFrame.getLoginPage().getLoginBtn().setText("LOGIN");
                        mainFrame.getLoginPage().getLoginBtn().setEnabled(true);
                        JOptionPane.showMessageDialog(mainFrame, "username หรือ password ไม่ถูกต้อง!");
                    }
                    dbm.disconnect();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(mainFrame, "ไม่สามารถติดต่อกับ Server ได้!");
//                    mainFrame.getLoginPage().getLoginBtn().setText("LOGIN");
                    mainFrame.getLoginPage().getLoginBtn().setEnabled(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                break;
            case 6:
                mainFrame.toLoginPage();
                mainFrame.setUser(null);
                
                break;
            
        }
        
    }
    
}
