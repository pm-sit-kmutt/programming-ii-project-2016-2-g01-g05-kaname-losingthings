package lostitemproject;

import java.awt.Component;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ViewLostItemGUI extends javax.swing.JPanel {
//    private JPanel subPanel;
    private EachItemGUI[] allItemShow;
    private DBManagement dbm;
    private Account user;
    private LostItemFrame mainFrame;

    public JButton getLogoutBtn() {
        return logoutBtn;
    }

    public void setLogoutBtn(JButton logoutBtn) {
        this.logoutBtn = logoutBtn;
    }

    public JButton getAddLostItembtn() {
        return addLostItembtn;
    }

    public void setAddLostItembtn(JButton addLostItembtn) {
        this.addLostItembtn = addLostItembtn;
    }

    public EachItemGUI[] getAllItemShow() {
        return allItemShow;
    }

    public void setAllItemShow(EachItemGUI[] allItemShow) {
        this.allItemShow = allItemShow;
    }
    
    
    
    public ViewLostItemGUI(Account acc,LostItemFrame mainFrame) throws InterruptedException, ClassNotFoundException, SQLException {
        user=acc;
        this.mainFrame=mainFrame;
        dbm = new DBManagement();
        dbm.createConnection();      
        LostItem[] item = dbm.queryItem("","DESC","");
//        this.acc = acc;
        
        allItemShow = new EachItemGUI[item.length];
        JPanel subPanel = new JPanel();
        subPanel.setSize(700, item.length*140);
        for(int i=0;i<item.length;i++){
            EachItemGUI each = new EachItemGUI(item[i]);
            subPanel.add(each);
            allItemShow[i]=each;
        }
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
        initComponents();
        ScrollItemList.setViewportView(subPanel);
        ScrollItemList.getVerticalScrollBar().setUnitIncrement(16);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        ScrollItemList = new javax.swing.JScrollPane();
        searchBtn = new javax.swing.JButton();
        cateList = new javax.swing.JComboBox<>();
        locateList = new javax.swing.JComboBox<>();
        statusList = new javax.swing.JComboBox<>();
        orderByList = new javax.swing.JComboBox<>();
        addLostItembtn = new javax.swing.JButton();
        searchMyItem = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        ScrollItemList.setBackground(new java.awt.Color(255, 255, 255));
        ScrollItemList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollItemList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollItemList.setMaximumSize(new java.awt.Dimension(708, 326));
        ScrollItemList.setMinimumSize(new java.awt.Dimension(708, 326));
        add(ScrollItemList);
        ScrollItemList.setBounds(70, 160, 708, 326);

        searchBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchBtn.setText("ค้นหา");
        searchBtn.setMaximumSize(new java.awt.Dimension(65, 25));
        searchBtn.setMinimumSize(new java.awt.Dimension(65, 25));
        searchBtn.setName(""); // NOI18N
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        add(searchBtn);
        searchBtn.setBounds(290, 500, 120, 33);

        cateList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "อุปกรณ์อิเล็กทรอนิกส์", "เครื่องแต่งกาย", "กระเป๋า", "กุญแจ", "อื่นๆ" }));
        add(cateList);
        cateList.setBounds(140, 120, 157, 22);

        DBManagement dbm = new DBManagement();
        try{
            dbm.createConnection();
            String[] locate = dbm.queryLocation();
            locateList.setMaximumRowCount(60);
            String[] temp = new String[locate.length+1];
            temp[0]="ทั้งหมด";
            for(int i=1;i<temp.length;i++){
                temp[i]=locate[i-1];
            }
            locateList.setModel(new javax.swing.DefaultComboBoxModel<>(temp));
            dbm.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
        add(locateList);
        locateList.setBounds(360, 120, 110, 22);

        statusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "กำลังหา", "พบแล้ว", "ได้รับคืนแล้ว" }));
        add(statusList);
        statusList.setBounds(530, 120, 112, 22);

        orderByList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ใหม่-เก่า", "เก่า-ใหม่" }));
        add(orderByList);
        orderByList.setBounds(700, 120, 72, 22);

        addLostItembtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addLostItembtn.setText("แจ้งของหาย");
        addLostItembtn.setMaximumSize(new java.awt.Dimension(65, 25));
        addLostItembtn.setMinimumSize(new java.awt.Dimension(65, 25));
        addLostItembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLostItembtnActionPerformed(evt);
            }
        });
        add(addLostItembtn);
        addLostItembtn.setBounds(600, 500, 120, 33);

        searchMyItem.setText("ค้นหาของหายฉัน");
        searchMyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMyItemActionPerformed(evt);
            }
        });
        add(searchMyItem);
        searchMyItem.setBounds(440, 500, 123, 40);

        logoutBtn.setText("LOGOUT");
        add(logoutBtn);
        logoutBtn.setBounds(140, 500, 120, 33);

        jLabel1.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("หมวดหมู่");
        add(jLabel1);
        jLabel1.setBounds(80, 120, 80, 20);

        jLabel2.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("สถานที่");
        add(jLabel2);
        jLabel2.setBounds(310, 120, 60, 20);

        jLabel3.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("สถานะ");
        add(jLabel3);
        jLabel3.setBounds(480, 120, 50, 20);

        jLabel4.setFont(new java.awt.Font("supermarket", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ลำดับ");
        add(jLabel4);
        jLabel4.setBounds(660, 120, 40, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/ฟอน5.png"))); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(180, 10, 490, 100);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/พื้นหลังหน้าอื่น.png"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 850, 550);

        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(0, 110, 850, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            dbm.createConnection();
            String condition = "";
            String locationFilter = "";
            if(cateList.getSelectedIndex()!=0){
                condition+=" AND Cate_cateId="+cateList.getSelectedIndex();
            }
            if(locateList.getSelectedIndex()!=0){       
                
                locationFilter+=" AND itemlocation.Location_locationId="+locateList.getSelectedIndex();                   
            }
            if(statusList.getSelectedIndex()!=0){
                condition+=" AND itemstatus.Status_statusId="+statusList.getSelectedIndex();
            }
            String orderBy=(orderByList.getSelectedIndex()==0?"DESC":"ASC");
            LostItem[] item = dbm.queryItem(condition,orderBy,locationFilter);
//            this.acc = acc;
            
            allItemShow = new EachItemGUI[item.length];
            JPanel subPanel = new JPanel();
            subPanel.setSize(500, item.length*120);
            for(int i=0;i<item.length;i++){
                EachItemGUI each = new EachItemGUI(item[i]);
                subPanel.add(each);
                allItemShow[i]=each;
                allItemShow[i].getViewDetailBtn().addActionListener(
                        new ChangePanelListener(mainFrame,ChangePanelListener.DETAIL,allItemShow[i].getItem())); 
            }

            subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
            ScrollItemList.setViewportView(subPanel);
            ScrollItemList.revalidate();
            ScrollItemList.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addLostItembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLostItembtnActionPerformed

    }//GEN-LAST:event_addLostItembtnActionPerformed

    private void searchMyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMyItemActionPerformed
        try {
            dbm.createConnection();
            String condition = " AND item.Account_userId="+user.getAccId();
            String locationFilter = "";
            if(cateList.getSelectedIndex()!=0){
                condition+=" AND Cate_cateId="+cateList.getSelectedIndex();
            }
            if(locateList.getSelectedIndex()!=0){       
                
                locationFilter+=" AND itemlocation.Location_locationId="+locateList.getSelectedIndex();                   
            }
            if(statusList.getSelectedIndex()!=0){
                condition+=" AND itemstatus.Status_statusId="+statusList.getSelectedIndex();
            }
            String orderBy=(orderByList.getSelectedIndex()==0?"DESC":"ASC");
            LostItem[] item = dbm.queryItem(condition,orderBy,locationFilter);
//            this.acc = acc;
            
            allItemShow = new EachItemGUI[item.length];
            JPanel subPanel = new JPanel();
            subPanel.setSize(500, item.length*120);
            for(int i=0;i<item.length;i++){
                EachItemGUI each = new EachItemGUI(item[i]);
                subPanel.add(each);
                allItemShow[i]=each;
                allItemShow[i].getViewDetailBtn().addActionListener(
                        new ChangePanelListener(mainFrame,ChangePanelListener.DETAIL,allItemShow[i].getItem())); 
            }
            subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
            ScrollItemList.setViewportView(subPanel);
            ScrollItemList.revalidate();
            ScrollItemList.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchMyItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollItemList;
    private javax.swing.JButton addLostItembtn;
    private javax.swing.JComboBox<String> cateList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JComboBox<String> locateList;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JComboBox<String> orderByList;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchMyItem;
    private javax.swing.JComboBox<String> statusList;
    // End of variables declaration//GEN-END:variables

//    public void update() {
//        for(int i=0;i<allItemShow.length;i++){
//            if(allItemShow[i]==null){
//                System.out.println("data changed abort update!");
//                break;
//            }
//            if(allItemShow[i].getPageToGo()!=null){
//                pageToGo="viewDetails";
//                focusItem=allItemShow[i].getItem();
//                break;
//            }
//        }
//    }
}
