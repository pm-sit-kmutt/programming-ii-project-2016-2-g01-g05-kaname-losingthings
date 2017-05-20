/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.SwingConstants;

/**
 *
 * @author Kimmy
 */
public class ViewDetailGUI extends javax.swing.JPanel {
    private LostItem focusItem;
    private Account account;
    private SimpleDateFormat sdf;
    private ChangeStatusPanel csp;
    private DBManagement dbm;
    /**
     * Creates new form ViewDetailGUI
     */

    ViewDetailGUI(LostItem focusItem,Account account) {
        dbm = new DBManagement();
        this.focusItem = focusItem;
        this.account = account;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        initComponents();
        try{
            userNameText.setText(account.getUsername());
            picture.setIcon(new ImageIcon(focusItem.getImg().getScaledInstance(350, 197, Image.SCALE_SMOOTH)));
        }catch(NullPointerException ex){
            ex.printStackTrace();
            System.out.println("problem : can't find img");
        }
        if(account.getAccType()!=Account.TYPE_ADMIN){
            deleteItemBtn.setVisible(false);
        }
        
        //To change body of generated methods, choose Tools | Templates.
    }

    public ChangeStatusPanel getCsp() {
        return csp;
    }

    public void setCsp(ChangeStatusPanel csp) {
        this.csp = csp;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }


    public JLabel getDateTextStart() {
        return dateTextEnd;
    }

    public void setDateTextStart(JLabel dateTextStart) {
        this.dateTextEnd = dateTextStart;
    }

    public JLabel getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(JLabel descriptionText) {
        this.descriptionText = descriptionText;
    }

    public JLabel getLocationText() {
        return locationFound;
    }

    public void setLocationText(JLabel locationText) {
        this.locationFound = locationText;
    }

    public JLabel getLostItemText() {
        return lostItemText;
    }

    public void setLostItemText(JLabel lostItemText) {
        this.lostItemText = lostItemText;
    }

    public JLabel getNameText() {
        return nameText;
    }

    public void setNameText(JLabel nameText) {
        this.nameText = nameText;
    }

    public JLabel getPicture() {
        return picture;
    }

    public void setPicture(JLabel picture) {
        this.picture = picture;
    }

    public JLabel getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(JLabel userNameText) {
        this.userNameText = userNameText;
    }

    public JButton getStatusBtn() {
        return statusBtn;
    }

    public void setStatusBtn(JButton statusBtn) {
        this.statusBtn = statusBtn;
    }

    public JButton getDeleteItemBtn() {
        return deleteItemBtn;
    }

    public void setDeleteItemBtn(JButton deleteItemBtn) {
        this.deleteItemBtn = deleteItemBtn;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        detail = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        lostItem = new javax.swing.JLabel();
        descriptionText = new javax.swing.JLabel();
        deleteItemBtn = new javax.swing.JButton();
        nameText = new javax.swing.JLabel();
        lostItemText = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        locationFound = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        dateTextEnd = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userNameText = new javax.swing.JLabel();
        statusBtn = new javax.swing.JButton();
        dateTextStart1 = new javax.swing.JLabel();
        date1 = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        location2 = new javax.swing.JLabel();
        statusNow = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        detail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/114.png"))); // NOI18N
        detail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        detail.setForeground(new java.awt.Color(255, 255, 255));
        add(detail);
        detail.setBounds(310, -10, 240, 110);

        description.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setText("คำอธิบาย");
        add(description);
        description.setBounds(440, 300, 56, 14);

        lostItem.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        lostItem.setForeground(new java.awt.Color(255, 255, 255));
        lostItem.setText("หมวดหมู่");
        add(lostItem);
        lostItem.setBounds(60, 340, 70, 20);

        descriptionText.setBackground(new java.awt.Color(255, 255, 255));
        descriptionText.setOpaque(true);
        add(descriptionText);
        descriptionText.setBounds(500, 290, 280, 110);
        descriptionText.setText(focusItem.getItemDescription());
        descriptionText.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionText.setVerticalAlignment(SwingConstants.CENTER);

        deleteItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/rubbish-bin (1).png"))); // NOI18N
        deleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtnActionPerformed(evt);
            }
        });
        add(deleteItemBtn);
        deleteItemBtn.setBounds(790, 490, 40, 40);

        nameText.setBackground(new java.awt.Color(255, 255, 255));
        nameText.setOpaque(true);
        add(nameText);
        nameText.setBounds(190, 290, 230, 28);
        nameText.setText(focusItem.getItemName());
        nameText.setHorizontalAlignment(SwingConstants.CENTER);
        nameText.setVerticalAlignment(SwingConstants.CENTER);

        lostItemText.setBackground(new java.awt.Color(255, 255, 255));
        lostItemText.setOpaque(true);
        add(lostItemText);
        lostItemText.setBounds(190, 330, 230, 28);
        lostItemText.setText(focusItem.getCate());
        lostItemText.setHorizontalAlignment(SwingConstants.CENTER);
        lostItemText.setVerticalAlignment(SwingConstants.CENTER);

        location.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        location.setForeground(new java.awt.Color(255, 255, 255));
        location.setText("สถานที่ที่ทำของหาย");
        add(location);
        location.setBounds(430, 410, 130, 30);

        locationFound.setBackground(new java.awt.Color(255, 255, 255));
        locationFound.setOpaque(true);
        add(locationFound);
        locationFound.setBounds(550, 450, 230, 28);
        String allLocationFound = "";
        ItemStatus statFound=null;
        if(focusItem.getStatus().getStatusName().equalsIgnoreCase("lost")){
            locationFound.setText("-");
        }else{
            try{
                dbm.createConnection();
                statFound = dbm.queryStatusSpecifyType(focusItem.getItemId(), 2);
                if(statFound==null){
                    statFound = dbm.queryStatusSpecifyType(focusItem.getItemId(), 4);
                }
                dbm.disconnect();

            }catch(Exception e){
                e.printStackTrace();
            }
            for(int i=0;i<statFound.getLocationName().size();i++){
                allLocationFound+=statFound.getLocationName().get(i)+",";
            }
            allLocationFound=allLocationFound.substring(0, allLocationFound.length()-1);
            locationFound.setText(allLocationFound);
        }
        locationFound.setHorizontalAlignment(SwingConstants.CENTER);
        locationFound.setVerticalAlignment(SwingConstants.CENTER);
        add(picture);
        picture.setBounds(270, 80, 350, 190);

        date.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("วันที่ได้รับของคืน");
        add(date);
        date.setBounds(60, 450, 100, 20);

        dateTextEnd.setBackground(new java.awt.Color(255, 255, 255));
        dateTextEnd.setOpaque(true);
        add(dateTextEnd);
        dateTextEnd.setBounds(190, 450, 230, 28);
        String dateEndStr;
        if(focusItem.getDateEnd()==null){
            dateTextEnd.setText("-");
        }else{

            //dateEndStr = sdf.format(csp.getDateTimePickerStatus());
            dateEndStr = sdf.format(focusItem.getDateEnd());
            dateTextEnd.setText(dateEndStr);
        }
        dateTextEnd.setHorizontalAlignment(SwingConstants.CENTER);
        dateTextEnd.setVerticalAlignment(SwingConstants.CENTER);

        backBtn.setText("ย้อนกลับ");
        add(backBtn);
        backBtn.setBounds(330, 490, 92, 33);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/user (2).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(32, 32));
        add(jLabel1);
        jLabel1.setBounds(640, 13, 32, 32);

        userNameText.setFont(new java.awt.Font("supermarket", 0, 18)); // NOI18N
        userNameText.setForeground(new java.awt.Color(255, 255, 255));
        add(userNameText);
        userNameText.setBounds(684, 13, 154, 32);

        statusBtn.setText("เปลี่ยนสถานะ");
        statusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBtnActionPerformed(evt);
            }
        });
        add(statusBtn);
        statusBtn.setBounds(440, 490, 120, 33);

        dateTextStart1.setBackground(new java.awt.Color(255, 255, 255));
        dateTextStart1.setOpaque(true);
        String dateStartStr = sdf.format(focusItem.getDateStart());
        add(dateTextStart1);
        dateTextStart1.setBounds(190, 410, 230, 28);
        dateTextStart1.setText(dateStartStr);
        dateTextStart1.setHorizontalAlignment(SwingConstants.CENTER);
        dateTextStart1.setVerticalAlignment(SwingConstants.CENTER);

        date1.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        date1.setForeground(new java.awt.Color(255, 255, 255));
        date1.setText("วันที่ของหาย");
        add(date1);
        date1.setBounds(60, 410, 90, 30);

        statusText.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        statusText.setForeground(new java.awt.Color(255, 255, 255));
        statusText.setText("สถานะปัจจุบัน");
        add(statusText);
        statusText.setBounds(60, 370, 90, 30);

        location2.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        location2.setForeground(new java.awt.Color(255, 255, 255));
        location2.setText("สถานที่ที่พบของหาย");
        add(location2);
        location2.setBounds(430, 450, 120, 30);

        statusNow.setText(focusItem.getStatus().getStatusName());
        statusNow.setBackground(new java.awt.Color(255, 255, 255));
        statusNow.setOpaque(true);
        add(statusNow);
        statusNow.setBounds(190, 370, 230, 28);
        statusNow.setHorizontalAlignment(SwingConstants.CENTER);
        statusNow.setVerticalAlignment(SwingConstants.CENTER);

        name1.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));
        name1.setText("ชื่่อของหาย");
        add(name1);
        name1.setBounds(60, 300, 65, 25);

        locationArea.setColumns(20);
        locationArea.setRows(5);
        locationArea.setBorder(null);
        locationArea.setEnabled(false);
        locationArea.setLineWrap(true);
        jScrollPane1.setViewportView(locationArea);
        String allLocationLost = "";
        ItemStatus statLost=focusItem.getStatus();
        if(!statLost.getStatusName().equalsIgnoreCase("lost")){
            try{
                dbm.createConnection();
                statLost = dbm.queryStatusSpecifyType(statLost.getItemId(), 1);
                dbm.disconnect();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<statLost.getLocationName().size();i++){
            allLocationLost+="   "+statLost.getLocationName().get(i)+"\n";
        }
        allLocationLost=allLocationLost.substring(0, allLocationLost.length()-1);
        locationArea.setText(allLocationLost);

        add(jScrollPane1);
        jScrollPane1.setBounds(550, 410, 230, 30);

        jLabel2.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/พื้นหลังหน้าอื่น.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 850, 550);

        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(30, 20, 810, 16);
    }// </editor-fold>//GEN-END:initComponents
   // ChangeStatusPanel csp;
    private void statusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBtnActionPerformed
//        ImageIcon icon = new ImageIcon(focusItem.getImg().getScaledInstance(302, 197, Image.SCALE_SMOOTH));
        csp=new ChangeStatusPanel(account,focusItem);
        int result=JOptionPane.NO_OPTION;
        if(account.getAccType()==Account.TYPE_ADMIN){
            //csp = new ChangeStatusPanel(account);
            result = JOptionPane.showConfirmDialog(this,csp,"เปลี่ยนสถานะ",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        }else if(account.getAccId()==focusItem.getOwnerId()){
//            csp = new ChangeStatusPanel(account);
            result = JOptionPane.showConfirmDialog(this,csp,"เปลี่ยนสถานะ",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"ไม่มีสิทธิ!");
        }
        
        
        if(result==JOptionPane.YES_OPTION){
            
            int statusChoose = csp.getStatusCombo().getSelectedIndex()+1;
            
            if(csp.getStatusCombo().getSelectedItem().equals("found by myself")){
                statusChoose = 4;
            }
           // String dateEndStr = sdf.format(csp.getDateTimePickerStatus());
            int  locationNew = csp.getLocationComboBox().getSelectedIndex();
            try {
                String locationStr="-";
                String statusStr="";
                DBManagement dbm=new DBManagement();
                dbm.createConnection();
                if(statusChoose==1){
                    dbm.deleteStatusSpecifyType(focusItem.getItemId(), 2);
                    dbm.deleteStatusSpecifyType(focusItem.getItemId(), 3);
                    dbm.deleteStatusSpecifyType(focusItem.getItemId(), 4);
                    statusStr="lost";
                }else{
                    int statusId = dbm.insertStatus(focusItem.getItemId(), account.getAccId(), statusChoose);
                    if(statusId!=-1){
                        dbm.insertItemLocation(locationNew, statusId);
                    }
                    if(statusChoose==3||statusChoose==4){
                        String date=csp.getDateTimePickerStatus().getDatePicker().getDateStringOrEmptyString()
                                +" "+csp.getDateTimePickerStatus().getTimePicker().getTimeStringOrEmptyString();
                        dbm.updateItem(focusItem,date);
                        dateTextEnd.setText(date);
                    }
                    locationStr = csp.getLocationComboBox().getSelectedItem().toString();
                    statusStr = csp.getStatusCombo().getSelectedItem().toString();
                }
                dbm.disconnect();
                

                statusNow.setText(statusStr);
                locationFound.setText(locationStr);
                //dateTextEnd.setText("วันที่ของเจอ");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewDetailGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("การเชื่อมต่อมีปัญหา!");
                Logger.getLogger(ViewDetailGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
                
    }//GEN-LAST:event_statusBtnActionPerformed

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteItemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel date;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel dateTextEnd;
    private javax.swing.JLabel dateTextStart1;
    private javax.swing.JButton deleteItemBtn;
    private javax.swing.JLabel description;
    private javax.swing.JLabel descriptionText;
    private javax.swing.JLabel detail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel location;
    private javax.swing.JLabel location2;
    private javax.swing.JTextArea locationArea;
    private javax.swing.JLabel locationFound;
    private javax.swing.JLabel lostItem;
    private javax.swing.JLabel lostItemText;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel nameText;
    private javax.swing.JLabel picture;
    private javax.swing.JButton statusBtn;
    private javax.swing.JLabel statusNow;
    private javax.swing.JLabel statusText;
    private javax.swing.JLabel userNameText;
    // End of variables declaration//GEN-END:variables
}
