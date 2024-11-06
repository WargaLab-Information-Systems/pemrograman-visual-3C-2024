/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pendaftaran;
public class Final extends javax.swing.JFrame {
    public Final() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fnkelamin = new javax.swing.JTextField();
        fntanggal = new javax.swing.JTextField();
        fntempat = new javax.swing.JTextField();
        fnnama = new javax.swing.JTextField();
        fnalamat = new javax.swing.JTextField();
        fntelpon = new javax.swing.JTextField();
        fnemail = new javax.swing.JTextField();
        fnprodi = new javax.swing.JTextField();
        fnfakultas = new javax.swing.JTextField();
        balek = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nama :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel5.setText("Tempat Lahir :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        jLabel6.setText("Tanggal Lahir :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel7.setText("Jenis Kelamin :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel8.setText("Alamat :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel9.setText("No. Telp :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel10.setText("Email :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel11.setText("Prodi :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel12.setText("Fakultas");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        fnkelamin.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fnkelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 280, -1));

        fntanggal.setBackground(new java.awt.Color(255, 204, 204));
        fntanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fntanggalActionPerformed(evt);
            }
        });
        jPanel2.add(fntanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 280, -1));

        fntempat.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fntempat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 280, -1));

        fnnama.setBackground(new java.awt.Color(255, 204, 204));
        fnnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnnamaActionPerformed(evt);
            }
        });
        jPanel2.add(fnnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 280, -1));

        fnalamat.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fnalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 280, -1));

        fntelpon.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fntelpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 280, -1));

        fnemail.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fnemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 280, -1));

        fnprodi.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fnprodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 280, -1));

        fnfakultas.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.add(fnfakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 280, -1));

        balek.setBackground(new java.awt.Color(255, 204, 204));
        balek.setText("Keluar");
        balek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balekActionPerformed(evt);
            }
        });
        jPanel2.add(balek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\Capture9.JPG")); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("UNIERSITAS TRUNOJOYO MADURA");

        jLabel2.setText("JL. Raya Telang, PO. Box. 2 Kamal - Bangkalan");

        jLabel3.setText("Telp 23 0444 227828020");

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\Capture.JPG")); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\Capture.JPG")); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\Capture10.JPG")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(49, 49, 49))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(102, 102, 102)))
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void balekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balekActionPerformed
      Daftar df = new Daftar();
      df.setVisible(true);
//      setVisible(true);
      dispose();
    }//GEN-LAST:event_balekActionPerformed

    private void fnnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnnamaActionPerformed

    private void fntanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fntanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fntanggalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Final().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton balek;
    public static javax.swing.JTextField fnalamat;
    protected static javax.swing.JTextField fnemail;
    public static javax.swing.JTextField fnfakultas;
    public static javax.swing.JTextField fnkelamin;
    public static javax.swing.JTextField fnnama;
    public static javax.swing.JTextField fnprodi;
    public static javax.swing.JTextField fntanggal;
    public static javax.swing.JTextField fntelpon;
    public static javax.swing.JTextField fntempat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
