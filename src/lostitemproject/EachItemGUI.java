/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostitemproject;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author POOM
 */
public class EachItemGUI extends javax.swing.JPanel {
    private LostItem item;
    String pageToGo;
    /**
     * Creates new form EachItemGUI
     */
    public EachItemGUI(LostItem item) {
        this.item = item;
        initComponents();
        imgLabel.setIcon(new ImageIcon(item.getImg().getScaledInstance(139, 116, Image.SCALE_SMOOTH)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewDetailBtn = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(489, 116));

        viewDetailBtn.setText("Detail");
        viewDetailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(viewDetailBtn)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(viewDetailBtn)
                .addGap(43, 43, 43))
            .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailBtnActionPerformed
        pageToGo="details";
        
    }//GEN-LAST:event_viewDetailBtnActionPerformed

    public LostItem getItem() {
        return item;
    }

    public void setItem(LostItem item) {
        this.item = item;
    }

    public String getPageToGo() {
        return pageToGo;
    }

    public void setPageToGo(String pageToGo) {
        this.pageToGo = pageToGo;
    }

    public JButton getViewDetailBtn() {
        return viewDetailBtn;
    }

    public void setViewDetailBtn(JButton viewDetailBtn) {
        this.viewDetailBtn = viewDetailBtn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton viewDetailBtn;
    // End of variables declaration//GEN-END:variables
}