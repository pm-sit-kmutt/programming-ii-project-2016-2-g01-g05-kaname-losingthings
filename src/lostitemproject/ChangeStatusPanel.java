/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Image;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

/**
 *
 * @author Kimmy
 */
public class ChangeStatusPanel extends javax.swing.JPanel {

    private Account account;
    private LostItem lostItem;
   // private SimpleDateFormat sdf;

    /**
     * Creates new form ChangeStatusPanel
     */
    public ChangeStatusPanel(Account account,LostItem lostItem) {
       this.lostItem = lostItem;
        this.account = account;
        //sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        initComponents();
        try{
            userNameText.setText(lostItem.getOwnerName());
            picStatus.setIcon(new ImageIcon(lostItem.getImg().getScaledInstance(302, 197, Image.SCALE_SMOOTH)));
        }catch(NullPointerException ex){
            ex.printStackTrace();
            System.out.println("problem : can't find img");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusCombo = new javax.swing.JComboBox<>();
        locationComboBox = new javax.swing.JComboBox<>();
        picStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLostItem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateTimePickerStatus = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel8 = new javax.swing.JLabel();

        String[] statusChoice;
        if(account.getAccType()==Account.TYPE_ADMIN){
            statusChoice = new String[] {"lost","found","recieved"};
        }else{
            statusChoice = new String[] {"lost","found by myself"};
        }
        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(statusChoice));

        DBManagement dbm = new DBManagement();
        try{
            dbm.createConnection();
            locationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(dbm.queryLocation()));
            dbm.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }

        jLabel2.setText("สถานะปัจจุบัน");
        jLabel2.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N

        jLabel3.setText("สถานที่ที่พบของหาย");
        jLabel3.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/user (1).png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel4.setText("เปลี่ยนสถานะ");
        jLabel4.setFont(new java.awt.Font("supermarket", 1, 24)); // NOI18N

        nameLostItem.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N
        nameLostItem.setText(lostItem.getItemName());

        jLabel7.setText("ชื่อของหาย");
        jLabel7.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N

        jLabel8.setText("วันที่พบของหาย");
        jLabel8.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(picStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(48, 48, 48)
                .addComponent(nameLostItem, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(19, 19, 19)
                .addComponent(dateTimePickerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(14, 14, 14)
                .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(15, 15, 15)
                        .addComponent(picStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLostItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(dateTimePickerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JComboBox<String> getStatusCombo() {
        return statusCombo;
    }

    public void setStatusCombo(JComboBox<String> statusCombo) {
        this.statusCombo = statusCombo;
    }

    public JComboBox<String> getLocationComboBox() {
        return locationComboBox;
    }

    public void setLocationComboBox(JComboBox<String> locationComboBox) {
        this.locationComboBox = locationComboBox;
    }

    public DateTimePicker getDateTimePickerStatus() {
        return dateTimePickerStatus;
    }

    public void setDateTimePickerStatus(DateTimePicker dateTimePickerStatus) {
        this.dateTimePickerStatus = dateTimePickerStatus;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JLabel nameLostItem;
    private javax.swing.JLabel picStatus;
    private javax.swing.JComboBox<String> statusCombo;
    private javax.swing.JLabel userNameText;
    // End of variables declaration//GEN-END:variables
}
