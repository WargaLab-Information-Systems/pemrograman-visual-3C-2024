package javaapplication21;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class frame1 extends javax.swing.JFrame {
        boolean pilihanmenu = false;
        boolean pilihantoping = false;

        public void hitungkembalian(){
            try{
                int totalHarga = Integer.parseInt(txttotal.getText());
                int Masuk = Integer.parseInt(txtmasuk.getText());
                int Kembalian = Masuk - totalHarga;
               
                txtkembalian.setText(String.valueOf(Kembalian));
            }catch(NumberFormatException ex){
                txtkembalian.setText("");
            }
        
    }
    public frame1() {
        initComponents();
        txtjmlh.setText("0");
        txtjmlh.setEditable(false);
        txttotal.setEditable(false);
        txtkembalian.setEditable(false);
//        menu.setEnabled(false);
//        topping.setEnabled(false);

        txtmasuk.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                hitungkembalian();
            }
            public void removeUpdate(DocumentEvent e) {
                hitungkembalian();
            }
            public void changedUpdate(DocumentEvent e) {
                hitungkembalian();
            }
                });
        
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.ButtonGroup();
        topping = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        riset = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        toping3 = new javax.swing.JRadioButton();
        toping5 = new javax.swing.JRadioButton();
        toping1 = new javax.swing.JRadioButton();
        menu1 = new javax.swing.JRadioButton();
        menu2 = new javax.swing.JRadioButton();
        menu3 = new javax.swing.JRadioButton();
        menu4 = new javax.swing.JRadioButton();
        menu5 = new javax.swing.JRadioButton();
        menu6 = new javax.swing.JRadioButton();
        menu7 = new javax.swing.JRadioButton();
        menu8 = new javax.swing.JRadioButton();
        menu9 = new javax.swing.JRadioButton();
        menu10 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tambah = new javax.swing.JButton();
        txtjmlh = new javax.swing.JTextField();
        total = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        kurang = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtmasuk = new javax.swing.JTextField();
        txtkembalian = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        toping2 = new javax.swing.JRadioButton();
        toping4 = new javax.swing.JRadioButton();
        toping6 = new javax.swing.JRadioButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel3.setText("Vin'S Bakery");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication21/Bakery__1_-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 170, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("JL.Mohammad Arifin No.18");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel18.setText("Telp 082312523425");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 90));

        riset.setBackground(new java.awt.Color(255, 51, 51));
        riset.setForeground(new java.awt.Color(255, 255, 255));
        riset.setText("RISET");
        riset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                risetActionPerformed(evt);
            }
        });
        jPanel1.add(riset, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, -1, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 51));
        jLabel14.setText("TOPPING");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        topping.add(toping3);
        toping3.setText("Oreo 5.000");
        toping3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping3ActionPerformed(evt);
            }
        });
        jPanel1.add(toping3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        topping.add(toping5);
        toping5.setText("Keju 5.000");
        toping5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping5ActionPerformed(evt);
            }
        });
        jPanel1.add(toping5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        topping.add(toping1);
        toping1.setText("Kacang 5.000");
        toping1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping1ActionPerformed(evt);
            }
        });
        jPanel1.add(toping1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        menu.add(menu1);
        menu1.setText("50.000");
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });
        jPanel1.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 70, -1));

        menu.add(menu2);
        menu2.setText("35.000");
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });
        jPanel1.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 70, -1));

        menu.add(menu3);
        menu3.setText("40.000");
        jPanel1.add(menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 70, -1));

        menu.add(menu4);
        menu4.setText("50.000");
        menu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu4ActionPerformed(evt);
            }
        });
        jPanel1.add(menu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 70, -1));

        menu.add(menu5);
        menu5.setText("35.000");
        menu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu5ActionPerformed(evt);
            }
        });
        jPanel1.add(menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 70, -1));

        menu.add(menu6);
        menu6.setText("60.000");
        jPanel1.add(menu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 70, -1));

        menu.add(menu7);
        menu7.setText("50.000");
        jPanel1.add(menu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 70, -1));

        menu.add(menu8);
        menu8.setText("35.000");
        menu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu8ActionPerformed(evt);
            }
        });
        jPanel1.add(menu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 70, -1));

        menu.add(menu9);
        menu9.setText("50.000");
        jPanel1.add(menu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 70, -1));

        menu.add(menu10);
        menu10.setText("100.000");
        menu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu10ActionPerformed(evt);
            }
        });
        jPanel1.add(menu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 70, -1));

        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setText("BLACK QUARE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setText("STRAWBERRY SQUARE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setText("TIRAMISU SQUARE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setText("BLACK FOREST");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setText("RED CAKE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel9.setText("RED VELVET");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel10.setForeground(new java.awt.Color(51, 0, 51));
        jLabel10.setText("BLACK FOREST LOVE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabel11.setForeground(new java.awt.Color(51, 0, 51));
        jLabel11.setText("STARBERRY GLAZE LOVE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabel12.setForeground(new java.awt.Color(51, 0, 51));
        jLabel12.setText("PANDAN CHIFON LAYER");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel13.setForeground(new java.awt.Color(51, 0, 51));
        jLabel13.setText("ENGAGEMENT CAKE");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        txtjmlh.setEditable(false);
        txtjmlh.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        txtjmlh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlhActionPerformed(evt);
            }
        });

        total.setText("TOTAL");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        txttotal.setEditable(false);
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("STZhongsong", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("jumlah");

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(kurang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtjmlh, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tambah)
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tambah)
                        .addComponent(kurang))
                    .addComponent(txtjmlh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total)
                .addGap(18, 18, 18)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 210, 180));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setForeground(new java.awt.Color(102, 0, 102));

        txtmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmasukActionPerformed(evt);
            }
        });
        txtmasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmasukKeyReleased(evt);
            }
        });

        txtkembalian.setEditable(false);
        txtkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalianActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Kembalian");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Cash");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 210, 130));

        topping.add(toping2);
        toping2.setText("Almond 5.000");
        toping2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping2ActionPerformed(evt);
            }
        });
        jPanel1.add(toping2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        topping.add(toping4);
        toping4.setText("Mesis 5.000");
        toping4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping4ActionPerformed(evt);
            }
        });
        jPanel1.add(toping4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        topping.add(toping6);
        toping6.setText("Edible Flower 5.000");
        toping6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toping6ActionPerformed(evt);
            }
        });
        jPanel1.add(toping6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        back.setBackground(new java.awt.Color(255, 51, 51));
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("KEMBALI");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmasukActionPerformed
        
    }//GEN-LAST:event_txtmasukActionPerformed

    private void toping5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping5ActionPerformed

    }//GEN-LAST:event_toping5ActionPerformed

    private void toping1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping1ActionPerformed

    }//GEN-LAST:event_toping1ActionPerformed

    private void txtjmlhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlhActionPerformed

    }//GEN-LAST:event_txtjmlhActionPerformed

    private void menu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu10ActionPerformed

    }//GEN-LAST:event_menu10ActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        // Tombol Kurang
        if(Integer.parseInt(txtjmlh.getText()) > 0){
        int jumlah = Integer.parseInt(txtjmlh.getText());
        jumlah -= 1;
        txtjmlh.setText(String.valueOf(jumlah));
        }else{
            txtjmlh.setText("0");
        }
    }//GEN-LAST:event_kurangActionPerformed

    private void toping3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping3ActionPerformed

    }//GEN-LAST:event_toping3ActionPerformed

    private void menu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu4ActionPerformed
        
    }//GEN-LAST:event_menu4ActionPerformed

    private void toping2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping2ActionPerformed
        
    }//GEN-LAST:event_toping2ActionPerformed

    private void toping4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping4ActionPerformed
        
    }//GEN-LAST:event_toping4ActionPerformed

    private void toping6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toping6ActionPerformed
        
    }//GEN-LAST:event_toping6ActionPerformed

    private void txtkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalianActionPerformed
        // Hasil Kembalian
        int Masuk = Integer.parseInt(txtmasuk.getText());
        int jumlah = Integer.parseInt(total.getText());
        int Kembalian = Integer.parseInt(txtkembalian.getText());
        Kembalian = Masuk - jumlah;
        txtkembalian.setText(String.valueOf(Kembalian));
    }//GEN-LAST:event_txtkembalianActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed

    }//GEN-LAST:event_menu1ActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed
        
    }//GEN-LAST:event_menu2ActionPerformed

    private void menu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu5ActionPerformed

    }//GEN-LAST:event_menu5ActionPerformed

    private void menu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu8ActionPerformed

    }//GEN-LAST:event_menu8ActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // Tombol tambah
        int tambah = Integer.parseInt(txtjmlh.getText());
        tambah += 1;
        txtjmlh.setText(String.valueOf(tambah));
    }//GEN-LAST:event_tambahActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TombolKembali
        JOptionPane.showMessageDialog(null, "Apakah Anda Yakin Ingin Keluar?");
        System.exit(0);
    }//GEN-LAST:event_backActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // Tombol total
        int Jumlah = Integer.parseInt(txtjmlh.getText());
        int totalmenu = 0;
        int totaltopping  = 0;

        if (menu1.isSelected()){
            totalmenu += Jumlah *50000;
            pilihanmenu = true;
        }if (menu2.isSelected()){
            totalmenu += Jumlah *35000;
            pilihanmenu = true;
        }if (menu3.isSelected()){
            totalmenu += Jumlah *40000;
            pilihanmenu = true;
        }if (menu4.isSelected()) {
            totalmenu += Jumlah *50000;
            pilihanmenu = true;
        }if (menu5.isSelected()){
            totalmenu += Jumlah *35000;
            pilihanmenu = true;
        }if (menu6.isSelected()){
            totalmenu += Jumlah *60000;
            pilihanmenu = true;
        }if (menu7.isSelected()){
            totalmenu += Jumlah *50000;
            pilihanmenu = true;
        }if (menu8.isSelected()){
            totalmenu += Jumlah *35000;
            pilihanmenu = true;
        }if (menu9.isSelected()){
            totalmenu += Jumlah *50000;
            pilihanmenu = true;
        }if (menu10.isSelected()){
            totalmenu += Jumlah *100000;
            pilihanmenu = true;
        }if (toping1.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }if (toping2.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }if (toping3.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }if (toping4.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }if (toping5.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }if (toping6.isSelected()){
            totaltopping += Jumlah *5000;
            pilihantoping = true;
        }txttotal.setText(String.valueOf(totaltopping +totalmenu ));
        if (pilihanmenu ==false){
            JOptionPane.showMessageDialog(this, "pilih salah satu menunya!", "Ingatt!!!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }if (pilihantoping == false){
            JOptionPane.showMessageDialog(this, "pilih salah satu toppingnya!", "Ingatt!!!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        double hasil = totalmenu + totaltopping;
        if (hasil > 100000){
            double diskon = hasil * 0.05;
            double hasill = hasil - diskon;
            
            JOptionPane.showMessageDialog(this, "Yeyyy, Kamu dapet diskon 5% nih ^^");
            txttotal.setText(String.valueOf(hasill));
        }else{
            {JOptionPane.showMessageDialog(null, "Tolong Pilih Total Menu");}
            txttotal.setText(String.valueOf(hasil));
        }
    }//GEN-LAST:event_totalActionPerformed

    private void risetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_risetActionPerformed
        // Tombol Riset
        menu.clearSelection();
        topping.clearSelection();
        txtjmlh.setText("0");
        txttotal.setText("");
        txtmasuk.setText("");
        txtkembalian.setText("");
    }//GEN-LAST:event_risetActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        
    }//GEN-LAST:event_txttotalActionPerformed

    private void txtmasukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmasukKeyReleased

        double Total = Double.parseDouble(txttotal.getText());
        int Masuk = Integer.parseInt(txtmasuk.getText());
        if(Masuk<Total){
            txtkembalian.setText("uangmu kurang");
        }
        else{
        int Kembalian = (int)(Masuk-Total);
        txtkembalian.setText(String.valueOf(Kembalian));
        }
    }//GEN-LAST:event_txtmasukKeyReleased

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
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JButton kurang;
    public javax.swing.ButtonGroup menu;
    private javax.swing.JRadioButton menu1;
    private javax.swing.JRadioButton menu10;
    private javax.swing.JRadioButton menu2;
    private javax.swing.JRadioButton menu3;
    private javax.swing.JRadioButton menu4;
    private javax.swing.JRadioButton menu5;
    private javax.swing.JRadioButton menu6;
    private javax.swing.JRadioButton menu7;
    private javax.swing.JRadioButton menu8;
    private javax.swing.JRadioButton menu9;
    private javax.swing.JButton riset;
    private javax.swing.JButton tambah;
    private javax.swing.JRadioButton toping1;
    private javax.swing.JRadioButton toping2;
    private javax.swing.JRadioButton toping3;
    private javax.swing.JRadioButton toping4;
    private javax.swing.JRadioButton toping5;
    private javax.swing.JRadioButton toping6;
    public javax.swing.ButtonGroup topping;
    private javax.swing.JButton total;
    public javax.swing.JTextField txtjmlh;
    private javax.swing.JTextField txtkembalian;
    private javax.swing.JTextField txtmasuk;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

        }
