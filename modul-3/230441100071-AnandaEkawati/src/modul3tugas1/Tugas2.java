package modul3tugas1;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Tugas2 extends javax.swing.JFrame {

    public Tugas2() {
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
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb10 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        rb7 = new javax.swing.JRadioButton();
        rb8 = new javax.swing.JRadioButton();
        rb9 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        rb11 = new javax.swing.JRadioButton();
        rb12 = new javax.swing.JRadioButton();
        btnstatus = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btntotal = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        txtbayar = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 80));

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

        rb1.setText("Januari");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 13, 0, 11);
        jPanel2.add(rb1, gridBagConstraints);

        rb2.setText("Februari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel2.add(rb2, gridBagConstraints);

        rb5.setText("Mei");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 16);
        jPanel2.add(rb5, gridBagConstraints);

        rb3.setText("Maret");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 25);
        jPanel2.add(rb3, gridBagConstraints);

        rb10.setText("Oktober");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 0, 0);
        jPanel2.add(rb10, gridBagConstraints);

        rb4.setText("April");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel2.add(rb4, gridBagConstraints);

        rb7.setText("Juli");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 40);
        jPanel2.add(rb7, gridBagConstraints);

        rb8.setText("Agustus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 14);
        jPanel2.add(rb8, gridBagConstraints);

        rb9.setText("September");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 26, 0, 0);
        jPanel2.add(rb9, gridBagConstraints);

        rb6.setText("Juni");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 22);
        jPanel2.add(rb6, gridBagConstraints);

        rb11.setText("November");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPanel2.add(rb11, gridBagConstraints);

        rb12.setText("Desember");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        jPanel2.add(rb12, gridBagConstraints);

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 530, 260));

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
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1ActionPerformed

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatusActionPerformed
        // TODO add your handling code here:
        if (table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Silahkan Bayar Terlebih Dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika tabel kosong
        }else{
            String status = "Lunas";
            String bulanBelumDibayar = "";

            // Cek status setiap checkbox untuk bulan
            if (!rb1.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Januari\n";
            }
            if (!rb2.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Februari\n";
            }
            if (!rb3.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Maret\n";
            }
            if (!rb4.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "April\n";
            }
            if (!rb5.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Mei\n";
            }
            if (!rb6.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Juni\n";
            }
            if (!rb7.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Juli\n";
            }
            if (!rb8.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Agustus\n";
            }
            if (!rb9.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "September\n";
            }
            if (!rb10.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "Oktober\n";
            }
            if (!rb11.isSelected()) {
                status = "Menunggak";
                bulanBelumDibayar = bulanBelumDibayar + "November\n";
            }
            if (!rb12.isSelected()) {
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
    if (rb1.isSelected()) { bulanDetail += "Januari, "; bulanTerpilih++; }
    if (rb2.isSelected()) { bulanDetail += "Februari, "; bulanTerpilih++; }
    if (rb3.isSelected()) { bulanDetail += "Maret, "; bulanTerpilih++; }
    if (rb4.isSelected()) { bulanDetail += "April, "; bulanTerpilih++; }
    if (rb5.isSelected()) { bulanDetail += "Mei, "; bulanTerpilih++; }
    if (rb6.isSelected()) { bulanDetail += "Juni, "; bulanTerpilih++; }
    if (rb7.isSelected()) { bulanDetail += "Juli, "; bulanTerpilih++; }
    if (rb8.isSelected()) { bulanDetail += "Agustus, "; bulanTerpilih++; }
    if (rb9.isSelected()) { bulanDetail += "September, "; bulanTerpilih++; }
    if (rb10.isSelected()) { bulanDetail += "Oktober, "; bulanTerpilih++; }
    if (rb11.isSelected()) { bulanDetail += "November, "; bulanTerpilih++; }
    if (rb12.isSelected()) { bulanDetail += "Desember, "; bulanTerpilih++; }
    
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

        if (rb1.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Januari";
        }
        if (rb2.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Februari";
        }
        if (rb3.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Maret";
        }
        if (rb4.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "April";
        }
        if (rb5.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Mei";
        }
        if (rb6.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Juni";
        }
        if (rb7.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Juli";
        }
        if (rb8.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Agustus";
        }
        if (rb9.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "September";
        }
        if (rb10.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "Oktober";
        }
        if (rb11.isSelected()) {
            totalPembayaran += 500000;
            hitung++;
            bulanDetail += "November";
        }
        if (rb12.isSelected()) {
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
        rb1.setSelected(false);
        rb2.setSelected(false);
        rb3.setSelected(false);
        rb4.setSelected(false);
        rb5.setSelected(false);
        rb6.setSelected(false);
        rb7.setSelected(false);
        rb8.setSelected(false);
        rb9.setSelected(false);
        rb10.setSelected(false);
        rb11.setSelected(false);
        rb12.setSelected(false);

        // Fokuskan kembali pada field nama agar pengguna dapat mulai mengisi dari awal
        txtnama.requestFocus();                            
    }//GEN-LAST:event_btnresetActionPerformed

    private void txtkaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkaliActionPerformed

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
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnstatus;
    private javax.swing.JButton btntotal;
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
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb10;
    private javax.swing.JRadioButton rb11;
    private javax.swing.JRadioButton rb12;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    private javax.swing.JRadioButton rb7;
    private javax.swing.JRadioButton rb8;
    private javax.swing.JRadioButton rb9;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtkali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
