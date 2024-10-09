
package tugas1;

import javax.swing.JOptionPane;


public class pendaftaran extends javax.swing.JFrame {

    public pendaftaran() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnukuran = new javax.swing.ButtonGroup();
        btnpengiriman = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        texsnama = new javax.swing.JTextField();
        texsnotelp = new javax.swing.JTextField();
        texsalamat = new javax.swing.JTextField();
        cbbxjenis = new javax.swing.JComboBox<>();
        rdbtnS = new javax.swing.JRadioButton();
        rdbtnL = new javax.swing.JRadioButton();
        rdbtnXL = new javax.swing.JRadioButton();
        rdbtnXXL = new javax.swing.JRadioButton();
        rdbtnM = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textjmlhbeli = new javax.swing.JTextField();
        comboboxbayar = new javax.swing.JComboBox<>();
        jnt = new javax.swing.JRadioButton();
        jne = new javax.swing.JRadioButton();
        pos = new javax.swing.JRadioButton();
        cbdata = new javax.swing.JCheckBox();
        btnreset = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnbatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(222, 235, 248));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas1/logo1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 21, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Formulir Pemesanan Fashion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Diah’s Pretty in Pink");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Serif", 0, 10)); // NOI18N
        jLabel4.setText("Jl. Raya Basuki Rahmad, PO, Box 3 Tuban Jawa Timur");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Serif", 0, 10)); // NOI18N
        jLabel5.setText("Telp.081387532677, Call Center (209) 082458898");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(248, 223, 223));

        jLabel6.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel6.setText("Nama : ");

        jLabel7.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\phone-rotary1.png")); // NOI18N
        jLabel7.setText("No.Telp :");

        jLabel8.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel8.setText("Alamat :");

        jLabel9.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel9.setText("Jenis Produk :");

        jLabel10.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel10.setText("Ukuran :");

        texsnama.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        texsnama.setToolTipText("Isi Disini");

        texsnotelp.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        texsnotelp.setToolTipText("Isi Disini");
        texsnotelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texsnotelpActionPerformed(evt);
            }
        });

        texsalamat.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        texsalamat.setToolTipText("Isi Disini");

        cbbxjenis.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cbbxjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Kemeja", "Blouse", "Celana/Rok", "Aksesoris", "Sepatu/Sandal" }));
        cbbxjenis.setToolTipText("Pilih Salah Satu");

        btnukuran.add(rdbtnS);
        rdbtnS.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rdbtnS.setText("S");
        rdbtnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnSActionPerformed(evt);
            }
        });

        btnukuran.add(rdbtnL);
        rdbtnL.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rdbtnL.setText("L");

        btnukuran.add(rdbtnXL);
        rdbtnXL.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rdbtnXL.setText("XL");

        btnukuran.add(rdbtnXXL);
        rdbtnXXL.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rdbtnXXL.setText("XXL");

        btnukuran.add(rdbtnM);
        rdbtnM.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rdbtnM.setText("M");

        jLabel11.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel11.setText("Jumlah pembelian :");

        jLabel12.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel12.setText("Pembayaran  :");

        jLabel13.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel13.setText("Pengiriman :");

        textjmlhbeli.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        textjmlhbeli.setToolTipText("Isi Disini");
        textjmlhbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textjmlhbeliActionPerformed(evt);
            }
        });

        comboboxbayar.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        comboboxbayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Trasfer Bank", "Debit", "E-Wallet " }));
        comboboxbayar.setToolTipText("Pilih Salah Satu");
        comboboxbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxbayarActionPerformed(evt);
            }
        });

        btnpengiriman.add(jnt);
        jnt.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jnt.setText("J&T");
        jnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jntActionPerformed(evt);
            }
        });

        btnpengiriman.add(jne);
        jne.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jne.setText("JNE");

        btnpengiriman.add(pos);
        pos.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        pos.setText("POS");

        cbdata.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cbdata.setText("Data Yang Saya Masukan Benar");

        btnreset.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnreset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\trash.png")); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnsimpan.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnsimpan.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\shopping-cart.png")); // NOI18N
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\fashion.png")); // NOI18N

        btnbatal.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnbatal.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\return.png")); // NOI18N
        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbdata)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbxjenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textjmlhbeli)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(rdbtnM)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdbtnS))
                                            .addComponent(jnt))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(rdbtnL)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdbtnXL))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jne)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdbtnXXL)
                                            .addComponent(pos))
                                        .addGap(0, 89, Short.MAX_VALUE))
                                    .addComponent(comboboxbayar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(86, 86, 86)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texsnotelp, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                                    .addComponent(texsnama)
                                    .addComponent(texsalamat)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnbatal)
                                .addGap(111, 111, 111)
                                .addComponent(btnreset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsimpan)))
                        .addGap(30, 112, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(32, 32, 32))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(texsnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(texsnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(texsalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbbxjenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdbtnS)
                    .addComponent(rdbtnXL)
                    .addComponent(rdbtnL)
                    .addComponent(rdbtnXXL)
                    .addComponent(rdbtnM))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textjmlhbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboboxbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jnt)
                            .addComponent(jne)
                            .addComponent(pos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbdata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreset)
                    .addComponent(btnsimpan)
                    .addComponent(btnbatal))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void texsnotelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texsnotelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texsnotelpActionPerformed

    private void rdbtnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnSActionPerformed

    private void jntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jntActionPerformed

    private void textjmlhbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textjmlhbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textjmlhbeliActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        // Mengecek apakah checkbox "Setuju Syarat dan Ketentuan" sudah dicentang
        if (!cbdata.isSelected()) {
            // Tampilkan pesan peringatan jika checkbox belum dicentang
            JOptionPane.showMessageDialog(null, "Apakah Data Yang Anda Masukkan sudah benar? jika sudah klik centang", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
         
            // Mengecek apakah semua TextField sudah terisi
            if (texsnama.getText().isEmpty() || texsnotelp.getText().isEmpty() || texsalamat.getText().isEmpty() ||
                textjmlhbeli.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Penuhi dulu semua data sebelum melanjutkan!", "Input Tidak Lengkap", JOptionPane.WARNING_MESSAGE);

            // Mengecek apakah salah satu radio button ukuran dipilih
            } else if (!rdbtnM.isSelected() && !rdbtnS.isSelected() && !rdbtnL.isSelected() && !rdbtnXL.isSelected() && !rdbtnXXL.isSelected()) {
                JOptionPane.showMessageDialog(null, "Pilih ukuran sebelum melanjutkan!", "Input Tidak Lengkap", JOptionPane.WARNING_MESSAGE);

            // Mengecek apakah combo box jenis produk sudah dipilih
            } else if (cbbxjenis.getSelectedIndex() == -1) { 
               JOptionPane.showMessageDialog(null, "Pilih jenis produk sebelum melanjutkan!", "Input Tidak Lengkap", JOptionPane.WARNING_MESSAGE);

            // Mengecek apakah combo box metode pembayaran sudah dipilih
            } else if (comboboxbayar.getSelectedIndex() == -1) { 
                JOptionPane.showMessageDialog(null,  "Pilih metode pembayaran sebelum melanjutkan!",  "Input Tidak Lengkap",JOptionPane.WARNING_MESSAGE);

            // Mengecek apakah salah satu opsi pengiriman dipilih
            } else if (!jnt.isSelected() && !jne.isSelected() && !pos.isSelected()) {
                JOptionPane.showMessageDialog(null, "Pilih metode pengiriman sebelum melanjutkan!",   "Input Tidak Lengkap",JOptionPane.WARNING_MESSAGE);

            } else {
                // Jika semua input sudah lengkap, lanjutkan menyimpan data ke frame 'Simpan'
                Simpan simpan = new Simpan();
                simpan.texsnama.setText(texsnama.getText());
                simpan.texsnotelp.setText(texsnotelp.getText());
                simpan.texsalamat.setText(texsalamat.getText());
                simpan.textjmlhbeli.setText(textjmlhbeli.getText());

                // Menyimpan data dari combo box
                String jenisproduk = (String) cbbxjenis.getSelectedItem().toString();
                simpan.tfJenisProduk.setText(jenisproduk);

                String pembayaran = (String) comboboxbayar.getSelectedItem().toString();
                simpan.tfPembayaran.setText(pembayaran);

                // Menyimpan pilihan ukuran dari radio button
                if (rdbtnM.isSelected()) {
                    simpan.tfUkuran.setText("M");
                } else if (rdbtnS.isSelected()) {
                    simpan.tfUkuran.setText("S");
                } else if (rdbtnL.isSelected()) {
                    simpan.tfUkuran.setText("L");
                } else if (rdbtnXL.isSelected()) {
                    simpan.tfUkuran.setText("XL");
                } else if (rdbtnXXL.isSelected()) {
                    simpan.tfUkuran.setText("XXL");
                }

                // Menyimpan metode pengiriman dari radio button
                if (jnt.isSelected()) {
                    simpan.tfPengiriman.setText("J&T");
                } else if (jne.isSelected()) {
                    simpan.tfPengiriman.setText("JNE");
                } else if (pos.isSelected()) {
                    simpan.tfPengiriman.setText("POS");
                }

        // Menampilkan frame 'Simpan'
        simpan.setVisible(true);

        // Menyembunyikan frame yang sedang aktif (opsional)
        dispose();
    }
}
        }
        });
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        btnreset.addActionListener(new java.awt.event.ActionListener(){
    public void actionPerformed(java.awt.event.ActionEvent evt) {
//        mengosongkan formulir texsfield
        texsnama.setText("");
        texsnotelp.setText("");
        texsalamat.setText("");
        textjmlhbeli.setText("");
        
        //mengosongkan radiobatton di radiogroup
        btnukuran.clearSelection();
        btnpengiriman.clearSelection();
        
        //mengosongkan combobox
        cbbxjenis.setSelectedIndex(0);
        comboboxbayar.setSelectedIndex(0);
        
        //mengosongkan data yang dicentang
        cbdata.setSelected(false);
        
    }});
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        btnbatal.addActionListener(new java.awt.event.ActionListener(){
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        int batal = JOptionPane.showConfirmDialog(null,"Apakah Anda yakin Ingin Membatalkan","Batal",JOptionPane.YES_NO_OPTION);
        if (batal == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
});
    }//GEN-LAST:event_btnbatalActionPerformed

    private void comboboxbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxbayarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.ButtonGroup btnpengiriman;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    public javax.swing.ButtonGroup btnukuran;
    public javax.swing.JComboBox<String> cbbxjenis;
    private javax.swing.JCheckBox cbdata;
    public javax.swing.JComboBox<String> comboboxbayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JRadioButton jne;
    private javax.swing.JRadioButton jnt;
    public javax.swing.JRadioButton pos;
    public javax.swing.JRadioButton rdbtnL;
    public javax.swing.JRadioButton rdbtnM;
    public javax.swing.JRadioButton rdbtnS;
    public javax.swing.JRadioButton rdbtnXL;
    public javax.swing.JRadioButton rdbtnXXL;
    public javax.swing.JTextField texsalamat;
    public javax.swing.JTextField texsnama;
    public javax.swing.JTextField texsnotelp;
    public javax.swing.JTextField textjmlhbeli;
    // End of variables declaration//GEN-END:variables
}
