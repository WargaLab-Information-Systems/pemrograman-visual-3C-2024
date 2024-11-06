package modul3tugas1;
import javax.swing.JOptionPane;
public class Tugas1 extends javax.swing.JFrame {

    public Tugas1() {
        initComponents();
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdeskripsi = new javax.swing.JTextArea();
        cbxpenyakit = new javax.swing.JComboBox<>();
        btncari = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        btnbayar = new javax.swing.JButton();
        txtbayar = new javax.swing.JTextField();
        lblfarmasi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnkurang = new javax.swing.JButton();
        txtjumlah = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("APOTEK ANANDA");
        jPanel2.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new java.awt.GridLayout(3, 4, 3, 3));

        btn1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn1.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\2d369fd4-7f9a-4504-ae22-94dec2811c41 (1).jpg")); // NOI18N
        btn1.setText("counterpain");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn1);

        btn2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn2.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Advil Fast Pain Relief 90 Liquid Capsules (1).jpg")); // NOI18N
        btn2.setText("Advil");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn2);

        btn3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn3.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\APOTEK 24 JAM DI JETIS, WA 0821 3592 8716, Obat Ampuh Kolesterol Tinggi di Jetis (1).jpg")); // NOI18N
        btn3.setText("Amepros");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(btn3);

        btn4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn4.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Bepanthen Babyzalf 100g (1).jpg")); // NOI18N
        btn4.setText("Bepanthen");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel3.add(btn4);

        btn5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn5.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Ibuprofen (NSAID) Pain Reliever & Fever Reducer Tablets - 200ct - up&up™ (1).jpg")); // NOI18N
        btn5.setText("Ibuprofen");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel3.add(btn5);

        btn6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn6.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Nodrim Paracetamol 500 mg Tab con 20 (1).jpg")); // NOI18N
        btn6.setText("Paracetamol");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel3.add(btn6);

        btn7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn7.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Nurofen 200mg Caplets X24 _ Targeted Pain Relief For Adults & Children 12+ (1).jpg")); // NOI18N
        btn7.setText("Nurofen");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel3.add(btn7);

        btn8.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn8.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Obat  strepsils.jpg")); // NOI18N
        btn8.setText("Strepsil");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel3.add(btn8);

        btn11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn11.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Panadol 500 mg - 24 Comprimidos Revestidos (1).jpg")); // NOI18N
        btn11.setText("Paradol");
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel3.add(btn11);

        btn12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btn12.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\OBAT\\Pilih Mana_ Rohto atau Insto_ (1).jpg")); // NOI18N
        btn12.setText("Insto");
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel3.add(btn12);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 780, -1));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        txtdeskripsi.setColumns(20);
        txtdeskripsi.setRows(5);
        jScrollPane1.setViewportView(txtdeskripsi);

        cbxpenyakit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pereda nyeri", "pereda rasa sakit", "kolesterol", "perawatan kulit", "penurun demam", "demam dan nyeri", "nyeri akut sedang", "sakit tenggorokan", "mual dan muntah", "obat tetes  mata" }));
        cbxpenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxpenyakitActionPerformed(evt);
            }
        });

        btncari.setText("CARI");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel7.setText("Jenis Gejala");

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });

        txtbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayarActionPerformed(evt);
            }
        });

        lblfarmasi.setText("FARMASI");

        jLabel1.setText("TOTAL");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(lblfarmasi))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncari)
                            .addComponent(cbxpenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbayar)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtbayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addComponent(txttotal, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblfarmasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxpenyakit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 570, 440));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnkurang.setText("-");
        btnkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        jPanel4.add(btnkurang, gridBagConstraints);

        txtjumlah.setText("0");
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 64;
        jPanel4.add(txtjumlah, gridBagConstraints);

        btntambah.setText("+");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel4.add(btntambah, gridBagConstraints);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 230, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("COUNTERPAIN");
        txtdeskripsi.setText(
        "counterpain:\n" +
        "Counterpain mengandung methyl salicylate, menthol, dan eugenol. \n" +
        "Biasanya digunakan untuk meringankan rasa sakit pada otot, nyeri sendi, keseleo, dan nyeri akibat encok.\n" +
        "Harga : Rp 5000");
    }//GEN-LAST:event_btn1ActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbayarActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        int tambah = Integer.parseInt(txtjumlah.getText());
        tambah += 1;
        txtjumlah.setText(String.valueOf(tambah));
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(txtjumlah.getText()) > 0){
        int jumlah = Integer.parseInt(txtjumlah.getText());
        jumlah -= 1;
        txtjumlah.setText(String.valueOf(jumlah));
        }else{
            txtjumlah.setText("0");
        }
    }//GEN-LAST:event_btnkurangActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        // TODO add your handling code here:
        if(txtbayar.getText().isEmpty()||txttotal.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Silahkan Isi Nominal Bayar", "Info", JOptionPane.ERROR_MESSAGE);
         }else{
        int totalPembayaran = Integer.parseInt(txttotal.getText());
        int jumlahUang = Integer.parseInt(txtbayar.getText());
        if (jumlahUang > totalPembayaran) {
        int kembalian = jumlahUang - totalPembayaran;
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Kembalian: " + kembalian, "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jumlahUang == totalPembayaran){
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Uang pas.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Pembayaran gagal! Uang kurang.", "Info", JOptionPane.ERROR_MESSAGE);
        }
        }  
    }//GEN-LAST:event_btnbayarActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        String gejala = (String) cbxpenyakit.getSelectedItem();  // Mendapatkan gejala yang dipilih
        String deskripsi = "";  // Inisialisasi deskripsi

    if (gejala.equals("pereda nyeri")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Counterpain: Untuk mengatasi nyeri \n"
                + "Harga : Rp 5000" ;
    } else if (gejala.equals("pereda rasa sakit")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Advil: Mengatasi rasa sakit \n"
                + "Harga : Rp2000";
    } else if (gejala.equals("kolesterol")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Amepros: Untuk kolesterol \n"
                + "Harga : Rp 4000";
    } else if (gejala.equals("perawatan kulit")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Bepanthen: Untuk perawan kulit sehat \n"
                + "Harga : Rp 8000";
    } else if (gejala.equals("penurun demam")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Ibuprofen: Untuk mengobati Demam \n"
                + "Harga : Rp 6000";
    } else if (gejala.equals("demam dan nyeri")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Paracetamol: Mengurangi demam dan nyeri \n"
                + "Harga : Rp 9000";
    } else if (gejala.equals("nyeri akut sedag")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Nurofen: Untuk nyeri akut sedang, seperti sakit gigi dll. \n"
                + "Harga : Rp 2000";
    } else if (gejala.equals("sakit tenggorokan")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Strepsil: Untuk mengatasi sakit tenggorokan\n"
                + "Harga : Rp 6000";
    } else if (gejala.equals("mual dan muntah")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Paradol: Untuk mengatasi mual dan muntah\n"
                + "Harga : Rp 9000";
    } else if (gejala.equals("obat tetes  mata")) {
        deskripsi = "Obat yang dapat digunakan: \n" +
                    "1. Insto: Untuk obat tetes  mata \n"
                + "Harga : Rp 3000";
    }
    txtdeskripsi.setText(deskripsi);
    }//GEN-LAST:event_btncariActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("ADVIL");
        txtdeskripsi.setText(
        "Advil:\n" +
        "Counterpain mengandung pereda nyeri dalam Advil adalah ibuprofen \n" +
        "Biasanya digunakan untuk Sakit punggung. Kram menstruasi. Flu biasa. Nyeri otot.\n" +
        "Harga : Rp 2000");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("AMEPROS");
        txtdeskripsi.setText(
        "Amepros:\n" +
        "Amepros mengandung minyak ikan salmon (Salmon Oil) dan minyak nabati (Vegetable oil). \n" +
        "Biasanya digunakan untuk mencegah serangan jantung, mengurangi kadar kekentalan darah dll.\n" +
        "Harga : Rp 4000");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("BEPANTHEN");
        txtdeskripsi.setText(
        "Bepanthen:\n" +
        "Bepanthen mengandung Dexpanthenol atau pro vitamin B5 dan juga bahan yg dapat melembabkan kulit. \n" +
        "Biasanya digunakan untuk merawat kulit.\n" +
        "Harga : Rp 8000");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("IBUPROFEN");
        txtdeskripsi.setText(
        "Ibuprofen:\n" +
        "Ibuprofen mengandung obat antiinflamasi nonsteroid (NSAID) yang berasal dari asam propionat. \n" +
        "Biasanya digunakan untuk obat pereda nyeri sehari-hari untuk berbagai rasa sakit dan nyeri.\n" +
        "Harga : Rp 6000");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("PARACETAMOL");
        txtdeskripsi.setText(
        "Paracetamol:\n" +
        "Paracetamol mengandung zat aktif Parasetamol. \n" +
        "Biasanya digunakan untuk meredakan demam dan nyeri, termasuk untuk mengobati nyeri haid hingga sakit gigi.\n" +
        "Harga : Rp 9000");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("NUROFEN");
        txtdeskripsi.setText(
        "Nurofen:\n" +
        "Nurofen mengandung bentuk ibuprofen (sebagai natrium ibuprofen dihidrat). \n" +
        "Biasanya digunakan untuk menurunkan demam pada anak-anak saat flu, pilek.\n" +
        "Harga : Rp 2000");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("STREPSIL");
        txtdeskripsi.setText(
        "Strepsil:\n" +
        "Strepsil mengandung dichlorobenzyl alcohol dan amylmetacresol. \n" +
        "Biasanya digunakan untuk meringankan rasa sakit akibat perlukaan atau lesi di mulut dan tenggorokan serta mengurangi bau mulut.\n" +
        "Harga : Rp 6000");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("PARADOL");
        txtdeskripsi.setText(
        "Paradol:\n" +
        "Paradol mengandung senyawa bioaktif lainnya, seperti gingerol dan shogaol. \n" +
        "Biasanya digunakan untuk menurunkan demam serta meredakan nyeri, seperti sakit kepala, sakit gigi, atau sakit pada otot.\n" +
        "Harga : Rp 9000");
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        // TODO add your handling code here:
        lblfarmasi.setText("INSTO");
        txtdeskripsi.setText(
        "Instol:\n" +
        "Insto mengandung zat aktif Tetrahidrozolin HCl dan Benzalkonium Klorida. \n" +
        "Biasanya digunakan untuk mengatasi mata merah dan rasa perih akibat iritasi mata ringan yang dapat disebabkan karena asap, debu dan lainnya.\n" +
        "Harga : Rp 3000");
    }//GEN-LAST:event_btn12ActionPerformed

    private void cbxpenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxpenyakitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxpenyakitActionPerformed

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
            java.util.logging.Logger.getLogger(Tugas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnkurang;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbxpenyakit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfarmasi;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextArea txtdeskripsi;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
