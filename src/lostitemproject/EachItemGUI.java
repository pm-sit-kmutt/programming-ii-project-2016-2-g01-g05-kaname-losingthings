package lostitemproject;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EachItemGUI extends javax.swing.JPanel {
    private LostItem item;
    /**
     * Creates new form EachItemGUI
     */
    public EachItemGUI(LostItem item) {
        this.item = item;
        initComponents();
        if(item.getStatus().getStatusName().equals("Found")){
            nameStatusDate.setText("วันที่พบของหาย:");
        }else if(item.getStatus().getStatusName().equals("received")){
            nameStatusDate.setText("วันที่รับของหายคืน:");
        }else if(item.getStatus().getStatusName().equals("Found by myself")){
            nameStatusDate.setText("วันที่ได้รับของคืน:");
        }
      try{
            textUser.setText(item.getOwnerName());
            imgLabel.setIcon(new ImageIcon(item.getImg().getScaledInstance(149, 128, Image.SCALE_SMOOTH)));
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

        jPanel1 = new javax.swing.JPanel();
        viewDetailBtn = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        itemName = new javax.swing.JLabel();
        cate = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        statusDate = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameStatusDate = new javax.swing.JLabel();
        textUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(714, 194));
        setMinimumSize(new java.awt.Dimension(714, 194));

        viewDetailBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewDetailBtn.setText("Detail");
        viewDetailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailBtnActionPerformed(evt);
            }
        });

        imgLabel.setMaximumSize(new java.awt.Dimension(149, 128));
        imgLabel.setMinimumSize(new java.awt.Dimension(149, 128));

        itemName.setFont(new java.awt.Font("supermarket", 0, 16)); // NOI18N
        itemName.setText(item.getItemName());

        cate.setFont(new java.awt.Font("supermarket", 0, 16)); // NOI18N
        cate.setText(item.getCate());

        location.setFont(new java.awt.Font("supermarket", 0, 16)); // NOI18N
        String allLocation = "";
        for(int i=0;i<item.getStatus().getLocationName().size();i++){
            allLocation+=item.getStatus().getLocationName().get(i)+",";
        }
        allLocation=allLocation.substring(0, allLocation.length()-1);
        if(allLocation.length()>=15){
            allLocation=allLocation.substring(0, 14)+"...";
        }
        location.setText(allLocation);

        statusDate.setFont(new java.awt.Font("supermarket", 0, 16)); // NOI18N
        statusDate.setText(item.getStatus().getLastUpdate().toString());

        status.setFont(new java.awt.Font("supermarket", 0, 16)); // NOI18N
        status.setText(item.getStatus().getStatusName());

        jLabel1.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel1.setText("ชื่อ:");

        jLabel2.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel2.setText("หมวดหมู่:");

        jLabel3.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel3.setText("สถานที่:");

        jLabel4.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        jLabel4.setText("สถานะ:");

        nameStatusDate.setFont(new java.awt.Font("supermarket", 1, 16)); // NOI18N
        nameStatusDate.setText("วันที่แจ้งของหาย:");

        textUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lostitemproject.image/user (1).png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel7.setMinimumSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textUser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(nameStatusDate)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemName, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(cate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(statusDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46)))
                .addComponent(viewDetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(viewDetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(nameStatusDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cate, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewDetailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailBtnActionPerformed
//        pageToGo="details";
        
    }//GEN-LAST:event_viewDetailBtnActionPerformed

    public LostItem getItem() {
        return item;
    }

    public void setItem(LostItem item) {
        this.item = item;
    }

    public JButton getViewDetailBtn() {
        return viewDetailBtn;
    }

    public void setViewDetailBtn(JButton viewDetailBtn) {
        this.viewDetailBtn = viewDetailBtn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cate;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel location;
    private javax.swing.JLabel nameStatusDate;
    private javax.swing.JLabel status;
    private javax.swing.JLabel statusDate;
    private javax.swing.JLabel textUser;
    private javax.swing.JButton viewDetailBtn;
    // End of variables declaration//GEN-END:variables
}
