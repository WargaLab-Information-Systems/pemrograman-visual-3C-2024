package coba2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PembayaranSPP extends javax.swing.JFrame {
     private ArrayList<String> daftarBulanLunas = new ArrayList<>();
     
     private DefaultTableModel tableModel;
     
    public PembayaranSPP() {
        initComponents();
        this.setLocationRelativeTo(null);
        total.setEditable(false);
        status.setEditable(false);
        
        tableModel = new DefaultTableModel(new String[]{"Nama", "Bulan", "Jumlah SPP", "Status"}, 0);
        tabelData.setModel(tableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        januari = new javax.swing.JCheckBox();
        februari = new javax.swing.JCheckBox();
        maret = new javax.swing.JCheckBox();
        april = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        juni = new javax.swing.JCheckBox();
        juli = new javax.swing.JCheckBox();
        agustus = new javax.swing.JCheckBox();
        september = new javax.swing.JCheckBox();
        oktober = new javax.swing.JCheckBox();
        november = new javax.swing.JCheckBox();
        desember = new javax.swing.JCheckBox();
        hitung = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelData = new javax.swing.JTable();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(86, 28, 36));
        jPanel1.setPreferredSize(new java.awt.Dimension(677, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 216, 196));
        jLabel1.setText("PEMBAYARAN SPP 2024");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 290, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba2/duit.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba2/bayar.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 100));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(199, 183, 163));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(232, 216, 196));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(109, 41, 50)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nama             :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 40));

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel3.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 180, -1));

        jLabel3.setText("Jumlah SPP   :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));
        jPanel3.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 180, -1));

        januari.setText("Januari");
        januari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                januariActionPerformed(evt);
            }
        });
        jPanel3.add(januari, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        februari.setText("Februari");
        jPanel3.add(februari, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        maret.setText("Maret");
        maret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maretActionPerformed(evt);
            }
        });
        jPanel3.add(maret, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        april.setText("April");
        april.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprilActionPerformed(evt);
            }
        });
        jPanel3.add(april, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 50, -1));

        mei.setText("Mei");
        jPanel3.add(mei, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        juni.setText("Juni");
        jPanel3.add(juni, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        juli.setText("Juli");
        jPanel3.add(juli, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 50, 20));

        agustus.setText("Agustus");
        jPanel3.add(agustus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        september.setText("September");
        jPanel3.add(september, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        oktober.setText("Oktober");
        jPanel3.add(oktober, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 70, -1));

        november.setText("November");
        jPanel3.add(november, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 90, -1));

        desember.setText("Desember");
        jPanel3.add(desember, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        jPanel3.add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 580, 240));

        jPanel4.setBackground(new java.awt.Color(199, 183, 163));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Total :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 9, 3, 7);
        jPanel4.add(jLabel5, gridBagConstraints);

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.weightx = 1.5;
        gridBagConstraints.weighty = 1.8;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 2, 46);
        jPanel4.add(total, gridBagConstraints);

        jLabel6.setText("Status :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7, 38, 7, 9);
        jPanel4.add(jLabel6, gridBagConstraints);

        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 101;
        gridBagConstraints.insets = new java.awt.Insets(4, 8, 4, 8);
        jPanel4.add(status, gridBagConstraints);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 430, 50));

        tabelData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Bulan", "Total Bayar", "Status"
            }
        ));
        jScrollPane1.setViewportView(tabelData);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 500, 140));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel2.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, -1, -1));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        jPanel2.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 510, -1, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void januariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_januariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_januariActionPerformed

    private void maretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maretActionPerformed

    private void aprilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aprilActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        if(nama.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
    }
        else if(jumlah.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Masukkan jumlah spp terlebih dahulu", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else if(!(januari.isSelected() || februari.isSelected() || maret.isSelected() || 
                april.isSelected() || mei.isSelected() || juni.isSelected() || juli.isSelected() ||
                agustus.isSelected() || september.isSelected() || oktober.isSelected() ||
                november.isSelected() || desember.isSelected())){
            JOptionPane.showMessageDialog(this, "Pilih setidaknya satu bulan yang harus dibayar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        
        if (!isSppValid()) {
            JOptionPane.showMessageDialog(this, "Jumlah SPP harus berupa angka yang valid dan tidak boleh negatif.", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
        String namaInput = nama.getText();
    double spp = Double.parseDouble(jumlah.getText());
    daftarBulanLunas.clear();
    
    StringBuilder bulanLunas = new StringBuilder();
    int jumlahBulanDipilih = 0;
        
        if (januari.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Januari, ");
            daftarBulanLunas.add("Januari");
            januari.setEnabled(false);
        }
        if (februari.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Februari, ");
            daftarBulanLunas.add("Februari");
            februari.setEnabled(false);
        } 
        if (maret.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Maret, ");
            daftarBulanLunas.add("Maret");
            maret.setEnabled(false);
        } 
        if (april.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("April, ");
            daftarBulanLunas.add("April");
            april.setEnabled(false);
        }
        if (mei.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Mei, ");
            daftarBulanLunas.add("Mei");
            mei.setEnabled(false);
        }
        if (juni.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Juni, ");
            daftarBulanLunas.add("Juni");
            juni.setEnabled(false);
        }
        if (juli.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Juli, ");
            daftarBulanLunas.add("Juli");
            juli.setEnabled(false);
        }
        if (agustus.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Agustus, ");
            daftarBulanLunas.add("Agustus");
            agustus.setEnabled(false);
        }
        if (september.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("September, ");
            daftarBulanLunas.add("September");
            september.setEnabled(false);
        }
        if (oktober.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Oktober, ");
            daftarBulanLunas.add("Oktober");
            oktober.setEnabled(false);
        }
        if (november.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("November, ");
            daftarBulanLunas.add("November");
            november.setEnabled(false);
        }
        if (desember.isSelected()) {
            jumlahBulanDipilih++;
            bulanLunas.append("Desember, ");
            daftarBulanLunas.add("Desember");
            desember.setEnabled(false);
        }
        if (bulanLunas.length() > 0) {
        bulanLunas.setLength(bulanLunas.length() - 2);
    }
        
        double totalPembayaran = jumlahBulanDipilih * spp; 

        String statusPembayaran = jumlahBulanDipilih == 12 ? "Lunas" : "Menunggak";
        
        boolean namaDitemukan = false;
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 0).equals(namaInput)) {
            // Jika nama ditemukan, update data
            tableModel.setValueAt(bulanLunas.toString(), i, 1);
            tableModel.setValueAt(totalPembayaran, i, 2);
            tableModel.setValueAt(statusPembayaran, i, 3);
            namaDitemukan = true;
            break;
        }
    }
        if (!namaDitemukan) {
        tableModel.addRow(new Object[]{namaInput, bulanLunas.toString(), totalPembayaran, statusPembayaran});
    }

        total.setText(String.format("Rp %.0f", totalPembayaran));
        status.setText(statusPembayaran);

        tampilkanDaftarBulanLunas();
    }//GEN-LAST:event_hitungActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        januari.setSelected(false);
    januari.setEnabled(true);
    
    februari.setSelected(false);
    februari.setEnabled(true);
    
    maret.setSelected(false);
    maret.setEnabled(true);
    
    april.setSelected(false);
    april.setEnabled(true);
    
    mei.setSelected(false);
    mei.setEnabled(true);
    
    juni.setSelected(false);
    juni.setEnabled(true);
    
    juli.setSelected(false);
    juli.setEnabled(true);
    
    agustus.setSelected(false);
    agustus.setEnabled(true);
    
    september.setSelected(false);
    september.setEnabled(true);
    
    oktober.setSelected(false);
    oktober.setEnabled(true);
    
    november.setSelected(false);
    november.setEnabled(true);
    
    desember.setSelected(false);
    desember.setEnabled(true);

        nama.setText("");
        jumlah.setText("");
        total.setText("");
        status.setText("");

        tableModel.setRowCount(0);
    }//GEN-LAST:event_resetActionPerformed
    
     private boolean isSppValid() {
        try {
            double spp = Double.parseDouble(jumlah.getText());
            return spp >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
     private void tampilkanDaftarBulanLunas() {
        StringBuilder daftarLunas = new StringBuilder("=================================\nDaftar Bulan yang Sudah Dibayar\n=================================\n");
        for (String bulan : daftarBulanLunas) {
            daftarLunas.append("| "+bulan +" (Lunas)"+ "\n-----------------------------------\n");
        }
            JOptionPane.showMessageDialog(this, daftarLunas.toString(), "Riwayat Pembayaran", JOptionPane.INFORMATION_MESSAGE);
    }
    
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
            java.util.logging.Logger.getLogger(PembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembayaranSPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PembayaranSPP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agustus;
    private javax.swing.JCheckBox april;
    private javax.swing.JCheckBox desember;
    private javax.swing.JCheckBox februari;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox januari;
    private javax.swing.JCheckBox juli;
    private javax.swing.JTextField jumlah;
    private javax.swing.JCheckBox juni;
    private javax.swing.JButton keluar;
    private javax.swing.JCheckBox maret;
    private javax.swing.JCheckBox mei;
    private javax.swing.JTextField nama;
    private javax.swing.JCheckBox november;
    private javax.swing.JCheckBox oktober;
    private javax.swing.JButton reset;
    private javax.swing.JCheckBox september;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabelData;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
