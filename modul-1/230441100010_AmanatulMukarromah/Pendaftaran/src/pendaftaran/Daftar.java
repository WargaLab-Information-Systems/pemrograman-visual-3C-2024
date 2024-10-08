/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pendaftaran;
import javax.swing.JOptionPane;

public class Daftar extends javax.swing.JFrame {
    public Daftar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Form = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        tempatlahir = new javax.swing.JTextField();
        tanggallahir = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        telpon = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        prodi = new javax.swing.JTextField();
        rbl = new javax.swing.JRadioButton();
        rbp = new javax.swing.JRadioButton();
        batal = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        ComboBoxFakultas = new javax.swing.JComboBox<>();
        pilih = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nama :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 20));

        jLabel5.setText("Tempat Lahir :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 40));

        jLabel6.setText("Tanggal Lahir :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, 30));

        jLabel7.setText("Jenis Kelamin :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, 20));

        jLabel8.setText("Alamat :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel9.setText("No. Telp :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel10.setText("Email :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        jLabel11.setText("Prodi :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jLabel12.setText("Fakultas :");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 2, 330, 30));
        jPanel2.add(tempatlahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 38, 330, -1));
        jPanel2.add(tanggallahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 330, -1));
        jPanel2.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 330, -1));
        jPanel2.add(telpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 330, -1));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 330, -1));

        prodi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodiActionPerformed(evt);
            }
        });
        jPanel2.add(prodi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 330, -1));

        Form.add(rbl);
        rbl.setText("Laki - laki");
        jPanel2.add(rbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, 20));

        Form.add(rbp);
        rbp.setText("Perempuan");
        jPanel2.add(rbp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        batal.setBackground(new java.awt.Color(255, 204, 204));
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        jPanel2.add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        reset.setBackground(new java.awt.Color(255, 204, 204));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, -1, -1));

        simpan.setBackground(new java.awt.Color(255, 204, 204));
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel2.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, -1));

        ComboBoxFakultas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "TEKNIK", "KEISLAMAN", "KEDOKTERAN", "PENDIDIKAN" }));
        ComboBoxFakultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxFakultasActionPerformed(evt);
            }
        });
        jPanel2.add(ComboBoxFakultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 330, -1));

        pilih.setText("data yang saya masukkan sudah benar");
        jPanel2.add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\icon6.JPG")); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 0, 20, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\icon6.JPG")); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("UNIVERSITAS TRUNOJOYO MADURA");

        jLabel3.setText("JL. Raya Telang, PO. Box. 2 Kamal - Bangkalan");

        jLabel4.setText("Telp 23 0444 227828020");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("FORMULIR PENDAFTARAN LOMBA FASHION");

        jLabel14.setIcon(new javax.swing.ImageIcon("D:\\semester 3\\pemrograman visual\\Capture.JPG")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
       
    }//GEN-LAST:event_nameActionPerformed

    private void prodiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodiActionPerformed

    }//GEN-LAST:event_prodiActionPerformed

    private void ComboBoxFakultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxFakultasActionPerformed
      
    }//GEN-LAST:event_ComboBoxFakultasActionPerformed

    //ngisi nilai yang akan ditampilkan di frame final
    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (Daftar.name.getText().isEmpty() || 
            Daftar.tempatlahir.getText().isEmpty() ||
            Daftar.tanggallahir.getText().isEmpty() || 
            Daftar.alamat.getText().isEmpty() ||
            Daftar.telpon.getText().isEmpty() || 
            Daftar.email.getText().isEmpty() ||
            Daftar.prodi.getText().isEmpty()) {

        JOptionPane.showMessageDialog(this, "Silahkan isi seluruh data sebelum menyimpan", "Warning", JOptionPane.WARNING_MESSAGE);
        return; // Menghentikan proses jika ada field yang kosong
        }
        // Validasi jenis kelamin
        if (ComboBoxFakultas.getSelectedIndex()==0 ) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih fakultas", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // Menghentikan proses jika tidak ada jenis kelamin yang dipilih
        }
        
         if (!rbl.isSelected() && !rbp.isSelected()) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih jenis kelamin", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // Menghentikan proses jika tidak ada jenis kelamin yang dipilih
        }

        Final fn = new Final();
        Final.fnnama.setText(Daftar.name.getText());
        Final.fntempat.setText(Daftar.tempatlahir.getText());
        Final.fntanggal.setText(Daftar.tanggallahir.getText());
        Final.fnalamat.setText(Daftar.alamat.getText());
        Final.fntelpon.setText(Daftar.telpon.getText());
        Final.fnemail.setText(Daftar.email.getText());
        Final.fnprodi.setText(Daftar.prodi.getText());
        Final.fnfakultas.setText(Daftar.ComboBoxFakultas.getSelectedItem().toString());
        if (!pilih.isSelected()) {
            JOptionPane.showMessageDialog(this, "Silahkan centang jika data sudah benar", "Warning", JOptionPane.WARNING_MESSAGE);
        } else { 
            fn.setVisible(true);
        }
        if (rbl.isSelected()){
            Final.fnkelamin.setText("Laki-laki");
        }else if (rbp.isSelected()== true){
            Final.fnkelamin.setText("perempuan");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        name.setText("");
        tempatlahir.setText("");
        tanggallahir.setText("");
        Form.clearSelection();
        alamat.setText("");
        telpon.setText("");
        email.setText("");
        prodi.setText("");
        pilih.setSelected(false);
        ComboBoxFakultas.setSelectedIndex(0);
    }//GEN-LAST:event_resetActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        System.exit(0);
    }//GEN-LAST:event_batalActionPerformed

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
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> ComboBoxFakultas;
    private javax.swing.ButtonGroup Form;
    public static javax.swing.JTextField alamat;
    private javax.swing.JButton batal;
    public static javax.swing.JTextField email;
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
    public static javax.swing.JTextField name;
    private javax.swing.JCheckBox pilih;
    public static javax.swing.JTextField prodi;
    private javax.swing.JRadioButton rbl;
    private javax.swing.JRadioButton rbp;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    public static javax.swing.JTextField tanggallahir;
    public static javax.swing.JTextField telpon;
    public static javax.swing.JTextField tempatlahir;
    // End of variables declaration//GEN-END:variables
}
