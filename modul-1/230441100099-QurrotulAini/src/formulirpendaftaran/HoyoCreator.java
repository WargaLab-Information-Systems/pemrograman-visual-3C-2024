package formulirpendaftaran;

import javax.swing.JOptionPane;

public class HoyoCreator extends javax.swing.JFrame {
    
    String Nama, Asal, TmptLahir, Gender, Email, Platform, Followers;
    public HoyoCreator() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        asal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tmptLahir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gender1 = new javax.swing.JRadioButton();
        gender2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        platform = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        followers = new javax.swing.JTextField();
        konfirmasi = new javax.swing.JCheckBox();
        batal = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        simpan = new javax.swing.JButton();

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
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 170, -1));
        jPanel2.add(asal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel7.setText("TETALA :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));
        jPanel2.add(tmptLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel8.setText("JENIS KELAMIN :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        gender.add(gender1);
        gender1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        gender1.setText("LAKI-LAKI");
        gender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender1ActionPerformed(evt);
            }
        });
        jPanel2.add(gender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        gender.add(gender2);
        gender2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        gender2.setText("PEREMPUAN");
        gender2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender2ActionPerformed(evt);
            }
        });
        jPanel2.add(gender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel9.setText("E-MAIL           :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 140, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel10.setText("PLATFORM    :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        platform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "TikTok", "Instagram", "X" }));
        jPanel2.add(platform, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 140, -1));

        jLabel11.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel11.setText("FOLLOWERS :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 30));
        jPanel2.add(followers, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, -1));

        konfirmasi.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        konfirmasi.setText("Data yang saya masukkan sudah benar");
        jPanel2.add(konfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 26, 270, 310));

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        jPanel1.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel1.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender1ActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void gender2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender2ActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (!konfirmasi.isSelected()) {
            JOptionPane.showMessageDialog(null, "Anda harus menyetujui bahwa data sudah benar.");
        }
        else{
            String Nama = nama.getText();
            String Asal = asal.getText();
            String TmptLahir = tmptLahir.getText();
            String Gender = "";
            if(gender1.isSelected()){
                    Gender = "Laki-laki";
                }
            else if (gender2.isSelected()){
                    Gender = "Perempuan";
                }
            String Email = email.getText();
            String Platform = platform.getSelectedItem().toString();
            String Followers = followers.getText();
            
            
            //buat objek dari frame kedua dengan parameter yang diambil
            Tampilan tmpln = new Tampilan();
            //nampilin data yang sudah diisi tadi sesuai variabel yang digunakan
            tmpln.setData(Nama, Asal, TmptLahir, Gender, Email, Platform, Followers);
            //nampilin frame kedua tadi
            tmpln.setVisible(true);
            //nutup frame saat ini
            dispose();
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        nama.setText("");
        tmptLahir.setText("");
        asal.setText("");
        gender.clearSelection();
        email.setText("");
        platform.setSelectedIndex(0);
        followers.setText("");
        konfirmasi.setSelected(false);
    }//GEN-LAST:event_resetActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        int batal = JOptionPane.showConfirmDialog(null,"Terima kasih sudah mendaftar!","Batal",JOptionPane.YES_NO_OPTION);
        if (batal == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_batalActionPerformed

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
            java.util.logging.Logger.getLogger(HoyoCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoyoCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoyoCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoyoCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoyoCreator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asal;
    private javax.swing.JButton batal;
    private javax.swing.JTextField email;
    private javax.swing.JTextField followers;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JRadioButton gender1;
    private javax.swing.JRadioButton gender2;
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
    private javax.swing.JCheckBox konfirmasi;
    private javax.swing.JTextField nama;
    private javax.swing.JComboBox<String> platform;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField tmptLahir;
    // End of variables declaration//GEN-END:variables
}
