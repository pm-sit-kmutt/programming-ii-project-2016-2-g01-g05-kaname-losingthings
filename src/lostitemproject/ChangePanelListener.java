/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author POOM
 */
public class ChangePanelListener implements ActionListener{
    
    public static final int BACKTO_HOMEPAGE=0;
    public static final int DETAIL=1;
    public static final int ADD_LOSTITEM=2;
    public static final int CONFIRM_ADDITEM=3;
    public static final int CONFIRM_CHANGE_STATUS=4;
    public static final int LOGIN=5;
    public static final int LOGOUT=6;
    
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
                    ArrayList<Integer> locations = new ArrayList<Integer>();
                    String date,dateNew;
                    boolean isLocationSelected=false;
                    name=mainFrame.getAddItemPage().getTextName().getText();
                    des=mainFrame.getAddItemPage().getTextDescription().getText();
                    accId=mainFrame.getUser().getAccId();
                    cate=mainFrame.getAddItemPage().getComboLostItem().getSelectedIndex()+1;
//                    locationInt=mainFrame.getAddItemPage().getLocationCombo().getSelectedIndex()+1;
                    for(int i=0;i<mainFrame.getAddItemPage().getLcp().getLocationList().length;i++){
                        if(mainFrame.getAddItemPage().getLcp().getAllCheckBox()[i].isSelected()){
                            locations.add(i);
                            isLocationSelected=true;
                        }
                    }
                    
                    date=mainFrame.getAddItemPage().getDateTimePicker1().getDatePicker().getDateStringOrEmptyString()
                            +" "+mainFrame.getAddItemPage().getDateTimePicker1().getTimePicker().getTimeStringOrEmptyString();

                    System.out.println("date = "+date);
                    if(!(name.equals("")||date.equals(" ")||!isLocationSelected)){
                        itemId = dbm.insertItem(name,des,accId,cate,date);
                        int statusId = dbm.insertStatus(itemId, accId,1);
                        if(statusId!=-1){
                            dbm.insertItemLocation(locations, statusId);
                        }

                        if(mainFrame.getAddItemPage().getImgName()!=null){
                            dbm.insertImage(mainFrame.getAddItemPage().getImgName(), itemId);
                        }
                        dbm.disconnect();
                        JOptionPane.showMessageDialog(null, "แจ้งของหายเรียบร้อยแล้ว.");
                        mainFrame.toViewPage();
                    }else{
                        if(!isLocationSelected){
                            mainFrame.getAddItemPage().getLocationBtn().setText("ยังไม่ได้เลือก");
                            JOptionPane.showMessageDialog(null, "กรุณาเลือกอย่างน้อย 1 สถานที่!");
                        }else{
                            JOptionPane.showMessageDialog(null, "ใส่ข้อมูลไม่ครบ");
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "โปรดตรวจสอบการเชื่อมต่ออินเทอร์เน็ต");
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
