package formulirpendaftaran;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tampilan extends javax.swing.JFrame {

    public Tampilan() {
        initComponents();
        this.setLocationRelativeTo(null);
        nama1.setEditable(false);
        asal1.setEditable(false);
        tmptLahir1.setEditable(false);
        gender1.setEditable(false);
        email1.setEditable(false);
        platform1.setEditable(false);
        followers1.setEditable(false);
    }
    
    public void setData(String nama, String asal, String tmptLahir, String gender, String email, String platform, String followers){
        nama1.setText(nama);
        asal1.setText(asal);
        tmptLahir1.setText(tmptLahir);
        gender1.setText(gender);
        email1.setText(email);
        platform1.setText(platform);
        followers1.setText(followers);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama1 = new javax.swing.JTextField();
        asal1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tmptLahir1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        followers1 = new javax.swing.JTextField();
        gender1 = new javax.swing.JTextField();
        platform1 = new javax.swing.JTextField();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(232, 232, 232));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\hoyoverse-game-logo-png-3.png")); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 90, 30));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel1.setText("FORMULIR PENDAFTARAN");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 180, 30));

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 12)); // NOI18N
        jLabel3.setText("HOYOCREATOR");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\PEMVISSS\\WhatsApp_Image_2024-09-27_at_15.46.20-removebg-preview(1).png")); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 100));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 90));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(232, 232, 232));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel6.setText("NAMA    :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel5.setText("ASAL      :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 30));

        nama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama1ActionPerformed(evt);
            }
        });
        jPanel2.add(nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 170, -1));
        jPanel2.add(asal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel7.setText("TETALA :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));
        jPanel2.add(tmptLahir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel8.setText("JENIS KELAMIN :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel9.setText("E-MAIL                :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        email1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email1ActionPerformed(evt);
            }
        });
        jPanel2.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel10.setText("PLATFORM         :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 40));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel11.setText("FOLLOWERS      :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 40));
        jPanel2.add(followers1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 130, -1));
        jPanel2.add(gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, -1));
        jPanel2.add(platform1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 26, 270, 240));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel1.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email1ActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        HoyoCreator F1 = new HoyoCreator();
        F1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void nama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asal1;
    private javax.swing.JTextField email1;
    private javax.swing.JTextField followers1;
    private javax.swing.JTextField gender1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nama1;
    private javax.swing.JTextField platform1;
    private javax.swing.JTextField tmptLahir1;
    // End of variables declaration//GEN-END:variables
}
