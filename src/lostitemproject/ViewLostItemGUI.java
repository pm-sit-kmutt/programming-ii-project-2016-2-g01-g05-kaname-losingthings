/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.Component;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author POOM
 */
public class ViewLostItemGUI extends javax.swing.JPanel {
//    private JPanel subPanel;
    private LostItem focusItem;
    private EachItemGUI[] allItemShow;
    private String pageToGo;
    private Account acc;
    private DBManagement dbm;
    /**
     * Creates new form ViewLostItemGUI
     */
    public ViewLostItemGUI(Account acc) throws InterruptedException, ClassNotFoundException, SQLException {
        dbm = new DBManagement();
        dbm.createConnection();      
        LostItem[] item = dbm.queryItem("","DESC");
        this.acc = acc;
        
        allItemShow = new EachItemGUI[item.length];
        JPanel subPanel = new JPanel();
        subPanel.setSize(500, item.length*120);
        for(int i=0;i<item.length;i++){
            EachItemGUI each = new EachItemGUI(item[i]);
            subPanel.add(each);
            allItemShow[i]=each;
        }
        subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
        initComponents();
        ScrollItemList.setViewportView(subPanel);
        ScrollItemList.getVerticalScrollBar().setUnitIncrement(16);
        
//        while(pageToGo==null){
//            Thread.sleep(1000);
//        }
//        ScrollItemList.revalidate();
//        ScrollItemList.repaint();
        
        
    }

    public String getPageToGo() {
        return pageToGo;
    }

    public void setPageToGo(String pageToGo) {
        this.pageToGo = pageToGo;
    }

    public LostItem getFocusItem() {
        return focusItem;
    }

    public void setFocusItem(LostItem focusItem) {
        this.focusItem = focusItem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollItemList = new javax.swing.JScrollPane();
        searchBtn = new javax.swing.JButton();
        cateList = new javax.swing.JComboBox<>();
        locateList = new javax.swing.JComboBox<>();
        statusList = new javax.swing.JComboBox<>();
        orderByList = new javax.swing.JComboBox<>();
        addLostItembtn = new javax.swing.JButton();

        ScrollItemList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollItemList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchBtn.setText("ค้นหา");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        cateList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "อุปกรณ์อิเล็กทรอนิกส์", "เครื่องแต่งกาย", "กระเป๋า", "กุญแจ", "อื่นๆ" }));

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

        statusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "กำลังหา", "พบแล้ว", "ได้รับคืนแล้ว" }));

        orderByList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ใหม่-เก่า", "เก่า-ใหม่" }));

        addLostItembtn.setText("แจ้งของหาย");
        addLostItembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLostItembtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(ScrollItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cateList, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(locateList, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(statusList, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orderByList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addLostItembtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(addLostItembtn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn)
                    .addComponent(orderByList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(ScrollItemList, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            dbm.createConnection();
            String condition = "";
            if(cateList.getSelectedIndex()!=0){
                condition+=" AND Cate_cateId="+cateList.getSelectedIndex();
            }
            if(locateList.getSelectedIndex()!=0){        
                condition+=" AND Location_locationId="+locateList.getSelectedIndex();                   
            }
            if(statusList.getSelectedIndex()!=0){
                condition+=" AND itemstatus.Status_statusId="+statusList.getSelectedIndex();
            }
            String orderBy=(orderByList.getSelectedIndex()==0?"DESC":"ASC");
            LostItem[] item = dbm.queryItem(condition,orderBy);
            this.acc = acc;
            
            allItemShow = new EachItemGUI[item.length];
            JPanel subPanel = new JPanel();
            subPanel.setSize(500, item.length*120);
            for(int i=0;i<item.length;i++){
                EachItemGUI each = new EachItemGUI(item[i]);
                subPanel.add(each);
                allItemShow[i]=each;
            }
            subPanel.setLayout(new BoxLayout(subPanel,BoxLayout.Y_AXIS));
            ScrollItemList.setViewportView(subPanel);
            ScrollItemList.revalidate();
            ScrollItemList.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewLostItemGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void addLostItembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLostItembtnActionPerformed
        pageToGo="addLostItem";
    }//GEN-LAST:event_addLostItembtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollItemList;
    private javax.swing.JButton addLostItembtn;
    private javax.swing.JComboBox<String> cateList;
    private javax.swing.JComboBox<String> locateList;
    private javax.swing.JComboBox<String> orderByList;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> statusList;
    // End of variables declaration//GEN-END:variables

    public void update() {
        for(int i=0;i<allItemShow.length;i++){
            if(allItemShow[i]==null){
                System.out.println("data changed abort update!");
                break;
            }
            if(allItemShow[i].getPageToGo()!=null){
                pageToGo="viewDetails";
                focusItem=allItemShow[i].getItem();
                break;
            }
        }
    }
}
