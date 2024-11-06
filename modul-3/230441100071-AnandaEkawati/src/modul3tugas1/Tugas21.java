package modul3tugas1;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Tugas21 extends javax.swing.JFrame {

    public Tugas21() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtkali = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnstatus = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btntotal = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        txtbayar = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        cbx1 = new javax.swing.JCheckBox();
        cbx3 = new javax.swing.JCheckBox();
        cbx2 = new javax.swing.JCheckBox();
        cbx5 = new javax.swing.JCheckBox();
        cbx6 = new javax.swing.JCheckBox();
        cbx7 = new javax.swing.JCheckBox();
        cbx9 = new javax.swing.JCheckBox();
        cbx10 = new javax.swing.JCheckBox();
        cbx11 = new javax.swing.JCheckBox();
        cbx4 = new javax.swing.JCheckBox();
        cbx12 = new javax.swing.JCheckBox();
        cbx8 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("APLIKASI PEMBAYARAN SPP");
        jPanel3.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Nama:");
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        txtkali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkaliActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 6, 12);
        jPanel2.add(txtkali, gridBagConstraints);

        jLabel2.setText("Bulan:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 5, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        btnstatus.setText("Status");
        btnstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(btnstatus, gridBagConstraints);

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        jPanel2.add(btnreset, gridBagConstraints);

        jTextField2.setText("Rp. 500.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 82;
        jPanel2.add(jTextField2, gridBagConstraints);

        jLabel3.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel2.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 54;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 6, 0);
        jPanel2.add(txttotal, gridBagConstraints);

        btntotal.setText("Total");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel2.add(btntotal, gridBagConstraints);

        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel2.add(btnbayar, gridBagConstraints);

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 7, 0);
        jPanel2.add(txtbayar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.insets = new java.awt.Insets(4, 6, 5, 6);
        jPanel2.add(txtnama, gridBagConstraints);

        cbx1.setText("Januari");
        cbx1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 29);
        jPanel2.add(cbx1, gridBagConstraints);

        cbx3.setText("Maret");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 25);
        jPanel2.add(cbx3, gridBagConstraints);

        cbx2.setText("Februari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel2.add(cbx2, gridBagConstraints);

        cbx5.setText("Mei");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 38);
        jPanel2.add(cbx5, gridBagConstraints);

        cbx6.setText("Juni");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 23);
        jPanel2.add(cbx6, gridBagConstraints);

        cbx7.setText("Juli");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 41);
        jPanel2.add(cbx7, gridBagConstraints);

        cbx9.setText("September");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel2.add(cbx9, gridBagConstraints);

        cbx10.setText("Oktober");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        jPanel2.add(cbx10, gridBagConstraints);

        cbx11.setText("November");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPanel2.add(cbx11, gridBagConstraints);

        cbx4.setText("April");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 26);
        jPanel2.add(cbx4, gridBagConstraints);

        cbx12.setText("Desember");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 0);
        jPanel2.add(cbx12, gridBagConstraints);

        cbx8.setText("Agustus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 7);
        jPanel2.add(cbx8, gridBagConstraints);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 610, 260));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Bulan di bayar", "Status", "Total"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatusActionPerformed
        // TODO add your handling code here:
        if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Bayar Terlebih Dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika tabel kosong
        }else{
            String status = "Lunas";
            String bulanBelumDibayar = "";

            // Cek status setiap checkbox untuk bulan
            if (!cbx1.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Januari\n";
            }
            if (!cbx2.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Februari\n";
            }
            if (!cbx3.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Maret\n";
            }
            if (!cbx4.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "April\n";
            }
            if (!cbx5.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Mei\n";
            }
            if (!cbx6.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Juni\n";
            }
            if (!cbx7.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Juli\n";
            }
            if (!cbx8.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Agustus\n";
            }
            if (!cbx9.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "September\n";
            }
            if (!cbx10.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Oktober\n";
            }
            if (!cbx11.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "November\n";
            }
            if (!cbx12.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Desember\n";
            }

            // Tampilkan status dan daftar bulan yang belum dibayar
            if (status.equals("Menunggak")) {
                JOptionPane.showMessageDialog(this,"Status: " + status + "\nBulan yang belum dibayar:\n" + bulanBelumDibayar);
            } else {
                JOptionPane.showMessageDialog(this,"Status: " + status + "\nSemua bulan telah dibayar.");
            }
        }
    }//GEN-LAST:event_btnstatusActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbayarActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        // TODO add your handling code here:
            // Mengambil model tabel
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    String bulanDetail = "";
    String nama = txtnama.getText();
    String totalPembayaranText = txttotal.getText();
    int bulanTerpilih = 0; // Variabel untuk menghitung jumlah bulan yang dipilih

    // Memeriksa apakah checkbox bulan dipilih dan menambahkan detail ke dalam 'bulanDetail'
    if (cbx1.isSelected()) { bulanDetail += "Januari, "; bulanTerpilih++; }
    if (cbx2.isSelected()) { bulanDetail += "Februari, "; bulanTerpilih++; }
    if (cbx3.isSelected()) { bulanDetail += "Maret, "; bulanTerpilih++; }
    if (cbx4.isSelected()) { bulanDetail += "April, "; bulanTerpilih++; }
    if (cbx5.isSelected()) { bulanDetail += "Mei, "; bulanTerpilih++; }
    if (cbx6.isSelected()) { bulanDetail += "Juni, "; bulanTerpilih++; }
    if (cbx7.isSelected()) { bulanDetail += "Juli, "; bulanTerpilih++; }
    if (cbx8.isSelected()) { bulanDetail += "Agustus, "; bulanTerpilih++; }
    if (cbx9.isSelected()) { bulanDetail += "September, "; bulanTerpilih++; }
    if (cbx10.isSelected()) { bulanDetail += "Oktober, "; bulanTerpilih++; }
    if (cbx11.isSelected()) { bulanDetail += "November, "; bulanTerpilih++; }
    if (cbx12.isSelected()) { bulanDetail += "Desember, "; bulanTerpilih++; }
    
    // Menghapus koma terakhir jika ada
    if (!bulanDetail.isEmpty()) {
        bulanDetail = bulanDetail.substring(0, bulanDetail.length() - 2);
    }

    // Kondisi 1: Pastikan semua field (nama, bulan, dan total pembayaran) sudah diisi
    if (nama.isEmpty() || bulanDetail.isEmpty() || totalPembayaranText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pastikan semua field (nama, bulan, dan total pembayaran) sudah diisi!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Parsing total pembayaran
    int totalPembayaran;
    try {
        totalPembayaran = Integer.parseInt(totalPembayaranText); // Mengubah string total pembayaran menjadi angka
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Total pembayaran harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Ambil jumlah uang yang dibayarkan oleh pengguna dari txtbayar
    String jumlahUangText = txtbayar.getText();
    int jumlahUang;
    try {
        jumlahUang = Integer.parseInt(jumlahUangText); // Mengubah string jumlah uang menjadi angka
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Jumlah uang yang dimasukkan harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Menentukan status berdasarkan jumlah bulan yang dipilih
    String status;
    if (bulanTerpilih < 12) {
        status = "Nunggak"; // Jika bulan yang dipilih kurang dari 12, statusnya "Nunggak"
    } else {
        status = "Lunas";   // Jika bulan yang dipilih 12, statusnya "Lunas"
    }

    // Kondisi 6: Cek apakah jumlah uang lebih, kurang, atau pas
    if (jumlahUang < totalPembayaran) {
        JOptionPane.showMessageDialog(this, "Jumlah uang kurang! Pembayaran gagal.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Pembayaran gagal, keluar dari metode
    }

    // Kondisi 2: Cek apakah nama, bulan, dan total telah berubah dari data sebelumnya di tabel
    boolean namaSama = false;
    boolean bulanSama = false;
    boolean totalSama = false;
    
    for (int i = 0; i < model.getRowCount(); i++) {
        String namaDiTabel = (String) model.getValueAt(i, 0);
        String bulanDiTabel = (String) model.getValueAt(i, 1);
        int totalDiTabel = (int) model.getValueAt(i, 3); // Kolom total ada di indeks ke-3
        
        if (nama.equals(namaDiTabel)) {
            namaSama = true;
            if (bulanDetail.equals(bulanDiTabel)) {
                bulanSama = true;
            }
            if (totalPembayaran == totalDiTabel) {
                totalSama = true;
            }
        }
    }

    // Kondisi 2: Jika nama, bulan, dan total tidak berubah
    if (namaSama && bulanSama && totalSama) {
        JOptionPane.showMessageDialog(this, "Nama, bulan, dan total tidak boleh sama dengan data yang sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kondisi 3: Jika nama sama, bulan berubah, tetapi belum ada total
    if (namaSama && !bulanSama && totalPembayaran == 0) {
        JOptionPane.showMessageDialog(this, "Silakan hitung total sebelum melanjutkan!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kondisi 4: Jika nama sama, hanya update bulan dan status di baris tersebut
    if (namaSama) {
        for (int i = 0; i < model.getRowCount(); i++) {
            String namaDiTabel = (String) model.getValueAt(i, 0);
            if (nama.equals(namaDiTabel)) {
                model.setValueAt(bulanDetail, i, 1); // Update bulan di baris yang sama
                model.setValueAt(status, i, 2); // Update status di baris yang sama
                model.setValueAt(totalPembayaran, i, 3);
                break;
            }
        }
    } else {
        // Kondisi 5: Jika nama baru, tambahkan baris baru di tabel
        //tambah baris tabel
        model.addRow(new Object[]{nama, bulanDetail, status, totalPembayaran});
    }

    // Jika jumlah uang lebih dari total, berikan kembalian
    if (jumlahUang > totalPembayaran) {
        int kembalian = jumlahUang - totalPembayaran;
        JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Kembalian: " + kembalian, "Info", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Uang pas.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }


    }//GEN-LAST:event_btnbayarActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        int totalPembayaran = 0;
        int hitung = 0;
        String bulanDetail = "";
        String nama = txtnama.getText();
        String totalPembayaranText = txttotal.getText();

        if (cbx1.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Januari";
        }
        if (cbx2.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Februari";
        }
        if (cbx3.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Maret";
        }
        if (cbx4.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "April";
        }
        if (cbx5.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Mei";
        }
        if (cbx6.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Juni";
        }
        if (cbx7.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Juli";
        }
        if (cbx8.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Agustus";
        }
        if (cbx9.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "September";
        }
        if (cbx10.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Oktober";
        }
        if (cbx11.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "November";
        }
        if (cbx12.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Desember";
        }

        // Menghapus koma terakhir jika ada bulan yang dipilih
        if (nama.isEmpty() || bulanDetail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua field (nama, bulan) sudah diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            txttotal.setText(String.valueOf(totalPembayaran));
            txtkali.setText(String.valueOf(hitung));
        }

    }//GEN-LAST:event_btntotalActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        // Mengosongkan field input nama, total, dan bayar
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setRowCount(0);
        }
        txtnama.setText("");
        txttotal.setText("");
        txtbayar.setText("");
        txtkali.setText("");

        // Uncheck semua checkbox bulan
        cbx1.setSelected(false);
        cbx2.setSelected(false);
        cbx3.setSelected(false);
        cbx4.setSelected(false);
        cbx5.setSelected(false);
        cbx6.setSelected(false);
        cbx7.setSelected(false);
        cbx8.setSelected(false);
        cbx9.setSelected(false);
        cbx10.setSelected(false);
        cbx11.setSelected(false);
        cbx12.setSelected(false);

        // Fokuskan kembali pada field nama agar pengguna dapat mulai mengisi dari awal
        txtnama.requestFocus();                            
    }//GEN-LAST:event_btnresetActionPerformed

    private void txtkaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkaliActionPerformed

    private void cbx1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx1ActionPerformed

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
            java.util.logging.Logger.getLogger(Tugas21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas21.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas21().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnstatus;
    private javax.swing.JButton btntotal;
    private javax.swing.JCheckBox cbx1;
    private javax.swing.JCheckBox cbx10;
    private javax.swing.JCheckBox cbx11;
    private javax.swing.JCheckBox cbx12;
    private javax.swing.JCheckBox cbx2;
    private javax.swing.JCheckBox cbx3;
    private javax.swing.JCheckBox cbx4;
    private javax.swing.JCheckBox cbx5;
    private javax.swing.JCheckBox cbx6;
    private javax.swing.JCheckBox cbx7;
    private javax.swing.JCheckBox cbx8;
    private javax.swing.JCheckBox cbx9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtkali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
