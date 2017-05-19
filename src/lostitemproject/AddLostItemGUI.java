/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.Icon;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Kimmy
 */
public class AddLostItemGUI extends javax.swing.JPanel {
    private Account acc;
    private String userName;
    private String imgName;
    private javax.swing.JScrollPane ScrollItemList;
    private LocationChoicePanel lcp;
//    private String[] locationList;

    /**
     * Creates new form AddLostItemGUI
     */
    public AddLostItemGUI(Account acc) throws SQLException, ClassNotFoundException {
         
            
        initComponents();
        userNameText.setText(acc.getUsername()); 
        this.acc=acc;
        ScrollItemList = new javax.swing.JScrollPane();
        ScrollItemList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollItemList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        lcp = new LocationChoicePanel();
        
    }

    public LocationChoicePanel getLcp() {
        return lcp;
    }

    public void setLcp(LocationChoicePanel lcp) {
        this.lcp = lcp;
    }


    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getBtnConfirm() {
        return BtnConfirm;
    }

    public void setBtnConfirm(JButton BtnConfirm) {
        this.BtnConfirm = BtnConfirm;
    }
    
    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public JLabel getPath() {
        return Path;
    }

    public void setPath(JLabel Path) {
        this.Path = Path;
    }

    public JTextArea getTextDescription() {
        return TextDescription;
    }

    public void setTextDescription(JTextArea TextDescription) {
        this.TextDescription = TextDescription;
    }

    public JTextField getTextName() {
        return TextName;
    }

    public void setTextName(JTextField TextName) {
        this.TextName = TextName;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getUserNameText() {
        return userNameText;
    }

    public void setUserNameText(JLabel userNameText) {
        this.userNameText = userNameText;
    }

    public JComboBox<String> getComboLostItem() {
        return ComboLostItem;
    }

    public void setComboLostItem(JComboBox<String> ComboLostItem) {
        this.ComboLostItem = ComboLostItem;
    }

    public DateTimePicker getDateTimePicker1() {
        return dateTimePicker1;
    }

    public void setDateTimePicker1(DateTimePicker dateTimePicker1) {
        this.dateTimePicker1 = dateTimePicker1;
    }

    public JButton getLocationBtn() {
        return locationBtn;
    }

    public void setLocationBtn(JButton locationBtn) {
        this.locationBtn = locationBtn;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboLostItem = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Pic = new javax.swing.JLabel();
        BtnUpload = new javax.swing.JButton();
        BtnConfirm = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Path = new javax.swing.JLabel();
        userNameText = new javax.swing.JLabel();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        locationBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel10.setText("jLabel10");

        setPreferredSize(new java.awt.Dimension(800, 550));
        setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/111.png"))); // NOI18N
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(10, 10, 260, 50);

        jLabel2.setText("ชื่อของหาย");
        jLabel2.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel2);
        jLabel2.setBounds(170, 80, 80, 30);
        add(TextName);
        TextName.setBounds(310, 80, 320, 22);

        jLabel3.setText("คำอธิบาย");
        jLabel3.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel3);
        jLabel3.setBounds(170, 110, 70, 30);

        TextDescription.setColumns(20);
        TextDescription.setRows(5);
        jScrollPane1.setViewportView(TextDescription);

        add(jScrollPane1);
        jScrollPane1.setBounds(310, 110, 320, 123);

        jLabel4.setText("วันที่ของหาย");
        jLabel4.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel4);
        jLabel4.setBounds(160, 240, 90, 30);

        jLabel5.setText("หมวดหมู่");
        jLabel5.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel5);
        jLabel5.setBounds(270, 40, 60, 20);

        ComboLostItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "อุปกรณ์อิเล็กทรอนิกส์", "เครื่องแต่งกาย", "กระเป๋า", "กุญแจ", "อื่นๆ" }));
        ComboLostItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboLostItemActionPerformed(evt);
            }
        });
        add(ComboLostItem);
        ComboLostItem.setBounds(330, 40, 143, 22);

        jLabel6.setText("สถานที่");
        jLabel6.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel6);
        jLabel6.setBounds(490, 40, 60, 30);

        jLabel7.setText("อัพโหลดรูปภาพ");
        jLabel7.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        add(jLabel7);
        jLabel7.setBounds(160, 280, 110, 30);

        Pic.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add(Pic);
        Pic.setBounds(310, 310, 310, 168);

        BtnUpload.setText("อัพโหลดรูปภาพ");
        BtnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUploadActionPerformed(evt);
            }
        });
        add(BtnUpload);
        BtnUpload.setBounds(500, 280, 130, 25);

        BtnConfirm.setText("ยืนยัน");
        BtnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmActionPerformed(evt);
            }
        });
        add(BtnConfirm);
        BtnConfirm.setBounds(360, 490, 92, 33);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/user (2).png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel11.setMinimumSize(new java.awt.Dimension(32, 32));
        add(jLabel11);
        jLabel11.setBounds(680, 10, 48, 40);

        Path.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Path.setForeground(new java.awt.Color(255, 255, 255));
        add(Path);
        Path.setBounds(310, 280, 180, 25);

        userNameText.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        userNameText.setForeground(new java.awt.Color(255, 255, 255));
        add(userNameText);
        userNameText.setBounds(720, 20, 110, 25);
        add(dateTimePicker1);
        dateTimePicker1.setBounds(310, 240, 320, 23);

        locationBtn.setText("เลือกสถานที่");
        locationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationBtnActionPerformed(evt);
            }
        });
        add(locationBtn);
        locationBtn.setBounds(540, 40, 120, 25);

        backBtn.setText("ย้อนกลับ");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(460, 490, 92, 33);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/พื้นหลังหน้าอื่น.png"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(0, 0, 850, 550);

        jLabel9.setText("jLabel9");
        jLabel9.setPreferredSize(new java.awt.Dimension(32, 32));
        add(jLabel9);
        jLabel9.setBounds(32, 10, 32, 32);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboLostItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboLostItemActionPerformed
        //int a = ComboLostItem.getSelectedIndex();
        //JOptionPane.showMessageDialog(this, String.valueOf(a));
    }//GEN-LAST:event_ComboLostItemActionPerformed

    private void BtnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmActionPerformed
        /*DBManagement dbm = new DBManagement();
        int itemId;
        
        
        try {           
            dbm.createConnection();
            String name,des;
            int accId,cate,locationInt;
            String date;
            name=TextName.getText();
            des=TextDescription.getText();
            accId=acc.getAccId();
            cate=ComboLostItem.getSelectedIndex()+1;
            locationInt=location.getSelectedIndex()+1;
            date=TextDate.getText();
            if(!(name.equals("")||date.equals(""))){
                itemId = dbm.insertItem(name,des,accId,cate,date);
                dbm.insertStatus(locationInt, itemId, accId,1);

                if(imgName!=null){
                    dbm.insertImage(imgName, itemId);
                }
                dbm.disconnect();
//                mainFrame.toViewPage();
            }else{
                JOptionPane.showMessageDialog(this, "ใส่ข้อมูลไม่ครบ");
            }
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(this, "ใส่ข้อมูลไม่ครบ");
            ex.printStackTrace();
            System.out.println("SQL Exception!");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        //itemId = dbm.insertItem(name,des,accountId,cate,date);
        */
    }//GEN-LAST:event_BtnConfirmActionPerformed

    private void BtnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUploadActionPerformed
        FTPClient ftpClient = new FTPClient();
        InputStream is = null;
        BufferedInputStream bis=null;
        FileOutputStream os=null;
        BufferedOutputStream bos=null;
        String pathStr = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        BtnUpload.setText("กำลังอัพโหลด..");
        BtnConfirm.setEnabled(false);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            BtnUpload.setText("กำลังอัพโหลด..");
            BtnConfirm.setEnabled(false);
            pathStr = chooser.getSelectedFile().toString();
            File picFile = new File(pathStr);
            Path.setText(pathStr);//เป็นการให้แสดงpath ที่เราได้มาจาก chooser.getSelectedFile().toString();
            ImageIcon imageStr = new ImageIcon(pathStr);
            Image image = imageStr.getImage().getScaledInstance(302, 168, Image.SCALE_SMOOTH);//ให้แสดงรูปภาพบนlabelมีการเซตขนาดรูปให้พอดีกรอบ และเซตรูปให้SMOOTH
            Pic.setIcon(new ImageIcon(image));
            
            try {

                ftpClient.connect("93.188.160.226", 21);
                ftpClient.login("u782694326", "kamkam1234");
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                
                is = new FileInputStream(picFile);
                bis=new BufferedInputStream(is);
                
                
                imgName = UUID.randomUUID().toString();
                System.out.println("uploading...");
                if (ftpClient.storeFile(imgName, bis)) {
                    JOptionPane.showMessageDialog(this, "Upload Successful");
                    os=new FileOutputStream("D:/Download/"+imgName);
                    bos=new BufferedOutputStream(os);
                    is = new FileInputStream(picFile);
                    bis=new BufferedInputStream(is);
                    int data;
                    while((data = bis.read()) != -1){
                        bos.write(data);
                    }
                    
                    bos.close();

                } else {
                    JOptionPane.showMessageDialog(this, "Upload Failed\nServer อาจจะเกิดปัญหา ขออภัยในความไม่สะดวกค่ะ");
                    imgName = null;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    bis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
        }
        BtnUpload.setText("อัพโหลดรูปภาพ");
        BtnConfirm.setEnabled(true);
    }//GEN-LAST:event_BtnUploadActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
//        pageToGo="viewAll";
    }//GEN-LAST:event_backBtnActionPerformed

    private void locationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationBtnActionPerformed

            JScrollPane jsp = new JScrollPane();
            jsp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jsp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            jsp.setPreferredSize(new Dimension( 200, 100 ));
            jsp.setSize(100, 200);
            jsp.setViewportView(lcp);
            jsp.getVerticalScrollBar().setUnitIncrement(16);
            //========

            UIManager.put("OptionPane.minimumSize",new Dimension(100,200));
            JOptionPane.showMessageDialog(null,jsp,"เลือกสถานที่",JOptionPane.PLAIN_MESSAGE);
            locationBtn.setText("เลือกแล้ว");
            UIManager.put("OptionPane.minimumSize",new Dimension(100,20));
    }//GEN-LAST:event_locationBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirm;
    private javax.swing.JButton BtnUpload;
    private javax.swing.JComboBox<String> ComboLostItem;
    private javax.swing.JLabel Path;
    private javax.swing.JLabel Pic;
    private javax.swing.JTextArea TextDescription;
    private javax.swing.JTextField TextName;
    private javax.swing.JButton backBtn;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton locationBtn;
    private javax.swing.JLabel userNameText;
    // End of variables declaration//GEN-END:variables
}
