
package modul3_lanny;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lanny aprilia
 */
public class Pertanyaan_2 extends javax.swing.JFrame {
    private ArrayList<String> daftarBulanLunas = new ArrayList<>();
    /**
     * Creates new form Pertanyaan_2
     */
    public Pertanyaan_2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
   
        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        chbbulan1 = new javax.swing.JCheckBox();
        chbbulan2 = new javax.swing.JCheckBox();
        chbbulan3 = new javax.swing.JCheckBox();
        chbbulan4 = new javax.swing.JCheckBox();
        chbbulan5 = new javax.swing.JCheckBox();
        chbbulan6 = new javax.swing.JCheckBox();
        chbbulan7 = new javax.swing.JCheckBox();
        chbbulan8 = new javax.swing.JCheckBox();
        chbbulan9 = new javax.swing.JCheckBox();
        chbbulan10 = new javax.swing.JCheckBox();
        chbbulan11 = new javax.swing.JCheckBox();
        chbbulan12 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtjumlahspp = new javax.swing.JTextField();
        txttotalpembayaran = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnhitung = new javax.swing.JButton();
        btncek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txariwayat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\bahan modul 3\\p2-1.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 6, 114, -1));

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 0, 36)); // NOI18N
        jLabel2.setText("Lan's Pembayaran SPP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 371, -1));

        jLabel3.setFont(new java.awt.Font("Pristina", 0, 18)); // NOI18N
        jLabel3.setText("- Pembayaran Mudah, Aman, dan Terjamin -");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\bahan modul 3\\p2-2.png")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 120));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nama");

        jLabel6.setText(":       ");

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 700, 50));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.GridLayout(2, 6));

        chbbulan1.setText("Januari");
        chbbulan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbbulan1ActionPerformed(evt);
            }
        });
        jPanel3.add(chbbulan1);

        chbbulan2.setText("Februari");
        chbbulan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbbulan2ActionPerformed(evt);
            }
        });
        jPanel3.add(chbbulan2);

        chbbulan3.setText("Maret");
        jPanel3.add(chbbulan3);

        chbbulan4.setText("April");
        jPanel3.add(chbbulan4);

        chbbulan5.setText("Mei");
        jPanel3.add(chbbulan5);

        chbbulan6.setText("Juni");
        jPanel3.add(chbbulan6);

        chbbulan7.setText("Juli");
        jPanel3.add(chbbulan7);

        chbbulan8.setText("Agustus");
        jPanel3.add(chbbulan8);

        chbbulan9.setText("September");
        jPanel3.add(chbbulan9);

        chbbulan10.setText("Oktober");
        jPanel3.add(chbbulan10);

        chbbulan11.setText("November");
        jPanel3.add(chbbulan11);

        chbbulan12.setText("Desember");
        jPanel3.add(chbbulan12);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 171, 550, 90));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Bulan");

        jLabel8.setText(":       ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, 90));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Jumlah SPP");

        jLabel10.setText(":      ");

        txtjumlahspp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahsppActionPerformed(evt);
            }
        });

        txttotalpembayaran.setEditable(false);
        txttotalpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalpembayaranActionPerformed(evt);
            }
        });

        jLabel12.setText("Total Pembayaran :");

        jLabel11.setText("Status");

        jLabel13.setText(":      ");

        txtstatus.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txttotalpembayaran, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtjumlahspp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(txtstatus))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtjumlahspp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txttotalpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 264, 700, 110));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        jPanel6.add(btnhitung, gridBagConstraints);

        btncek.setText("Reset");
        btncek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 17, 0, 0);
        jPanel6.add(btncek, gridBagConstraints);

        txariwayat.setEditable(false);
        txariwayat.setColumns(20);
        txariwayat.setRows(5);
        jScrollPane1.setViewportView(txariwayat);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 61;
        gridBagConstraints.insets = new java.awt.Insets(4, 23, 0, 0);
        jPanel6.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 700, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtjumlahsppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahsppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahsppActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void chbbulan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbbulan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbbulan2ActionPerformed

    private void chbbulan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbbulan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbbulan1ActionPerformed
    
    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        if (txtnama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!(chbbulan1.isSelected() || chbbulan2.isSelected() || chbbulan3.isSelected() || chbbulan4.isSelected() ||
                    chbbulan5.isSelected() || chbbulan6.isSelected() || chbbulan7.isSelected() || chbbulan8.isSelected() ||
                    chbbulan9.isSelected() || chbbulan10.isSelected() || chbbulan11.isSelected() || chbbulan12.isSelected())) {
                JOptionPane.showMessageDialog(this, "Pilih setidaknya satu bulan yang harus dibayar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }
        
        if (!isSppValid()) {
            JOptionPane.showMessageDialog(this, "Jumlah SPP harus berupa angka yang valid dan tidak boleh negatif.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        double spp = Double.parseDouble(txtjumlahspp.getText());
        daftarBulanLunas.clear();

        StringBuilder riwayat = new StringBuilder("Bulan yang sudah dibayar:\n");
        StringBuilder bulanBelumDibayar = new StringBuilder("\n\nBulan yang belum dibayar:\n");
        int jumlahBulanDipilih = 0; 
        int jumlahBulanBelumDibayar = 0; 

        if (chbbulan1.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Januari - Lunas\n");
            daftarBulanLunas.add("Januari");
            chbbulan1.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Januari\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan2.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Februari - Lunas\n");
            daftarBulanLunas.add("Februari");
            chbbulan2.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Februari\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan3.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Maret - Lunas\n");
            daftarBulanLunas.add("Maret");
            chbbulan3.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Maret\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan4.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("April - Lunas\n");
            daftarBulanLunas.add("April");
            chbbulan4.setEnabled(false);
        } else {
            bulanBelumDibayar.append("April\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan5.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Mei - Lunas\n");
            daftarBulanLunas.add("Mei");
            chbbulan5.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Mei\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan6.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Juni - Lunas\n");
            daftarBulanLunas.add("Juni");
            chbbulan6.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Juni\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan7.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Juli - Lunas\n");
            daftarBulanLunas.add("Juli");
            chbbulan7.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Juli\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan8.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Agustus - Lunas\n");
            daftarBulanLunas.add("Agustus");
            chbbulan8.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Agustus\n");
            jumlahBulanBelumDibayar++;
        }
        if (chbbulan9.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("September - Lunas\n");
            daftarBulanLunas.add("September");
            chbbulan9.setEnabled(false);
        } else {
            bulanBelumDibayar.append("September\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan10.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Oktober - Lunas\n");
            daftarBulanLunas.add("Oktober");
            chbbulan10.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Oktober\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan11.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("November - Lunas\n");
            daftarBulanLunas.add("November");
            chbbulan11.setEnabled(false);
        } else {
            bulanBelumDibayar.append("November\n");
            jumlahBulanBelumDibayar++;
        }
        
        if (chbbulan12.isSelected()) {
            jumlahBulanDipilih++;
            riwayat.append("Desember - Lunas\n");
            daftarBulanLunas.add("Desember");
            chbbulan12.setEnabled(false);
        } else {
            bulanBelumDibayar.append("Desember\n");
            jumlahBulanBelumDibayar++;
        }

        double totalPembayaran = jumlahBulanDipilih * spp; 

        if (jumlahBulanBelumDibayar == 0) { 
            txtstatus.setText("Sudah Lunas");
        } else {
            txtstatus.setText("Menunggak");
            riwayat.append(bulanBelumDibayar.toString());
        }

        txttotalpembayaran.setText("Rp " + totalPembayaran);
        txariwayat.setText(riwayat.toString());

        tampilkanDaftarBulanLunas();
    }//GEN-LAST:event_btnhitungActionPerformed
    
    private boolean isSppValid() {
        try {
            double spp = Double.parseDouble(txtjumlahspp.getText());
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
    
    private void btncekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncekActionPerformed

        int pilihan = JOptionPane.showConfirmDialog(this, "Apakah kamu yakin ingin menghapus riwayat pembayaran?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (pilihan == JOptionPane.YES_OPTION) {
            txtnama.setText("");
            chbbulan1.setSelected(false);
            chbbulan2.setSelected(false);
            chbbulan3.setSelected(false);
            chbbulan4.setSelected(false);
            chbbulan5.setSelected(false);
            chbbulan6.setSelected(false);
            chbbulan7.setSelected(false);
            chbbulan8.setSelected(false);
            chbbulan9.setSelected(false);
            chbbulan10.setSelected(false);
            chbbulan11.setSelected(false);
            chbbulan12.setSelected(false);
            chbbulan1.setEnabled(true);
            chbbulan2.setEnabled(true);
            chbbulan3.setEnabled(true);
            chbbulan4.setEnabled(true);
            chbbulan5.setEnabled(true);
            chbbulan6.setEnabled(true);
            chbbulan7.setEnabled(true);
            chbbulan8.setEnabled(true);
            chbbulan9.setEnabled(true);
            chbbulan10.setEnabled(true);
            chbbulan11.setEnabled(true);
            chbbulan12.setEnabled(true);
            txariwayat.setText("");
            txtjumlahspp.setText("");
            txttotalpembayaran.setText("");
            txtstatus.setText("");
        }
    }//GEN-LAST:event_btncekActionPerformed

    private void txttotalpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalpembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalpembayaranActionPerformed

        
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
            java.util.logging.Logger.getLogger(Pertanyaan_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pertanyaan_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pertanyaan_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncek;
    private javax.swing.JButton btnhitung;
    private javax.swing.JCheckBox chbbulan1;
    private javax.swing.JCheckBox chbbulan10;
    private javax.swing.JCheckBox chbbulan11;
    private javax.swing.JCheckBox chbbulan12;
    private javax.swing.JCheckBox chbbulan2;
    private javax.swing.JCheckBox chbbulan3;
    private javax.swing.JCheckBox chbbulan4;
    private javax.swing.JCheckBox chbbulan5;
    private javax.swing.JCheckBox chbbulan6;
    private javax.swing.JCheckBox chbbulan7;
    private javax.swing.JCheckBox chbbulan8;
    private javax.swing.JCheckBox chbbulan9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txariwayat;
    private javax.swing.JTextField txtjumlahspp;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttotalpembayaran;
    // End of variables declaration//GEN-END:variables
}
