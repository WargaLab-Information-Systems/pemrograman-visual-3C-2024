package coba;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ngetest extends javax.swing.JFrame {

    public ngetest() {
        initComponents();
        this.setLocationRelativeTo(null);
        jumlah.setEditable(false);
        total.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BGObat = new javax.swing.ButtonGroup();
        pAtas = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pKanan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        buy = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        kurang = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pTengah = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        iBodrex = new javax.swing.JLabel();
        iHufagrip = new javax.swing.JLabel();
        iSucralfate = new javax.swing.JLabel();
        iBetason = new javax.swing.JLabel();
        bodrex = new javax.swing.JRadioButton();
        hufagrip = new javax.swing.JRadioButton();
        sucralfate = new javax.swing.JRadioButton();
        betason = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        iStimuno = new javax.swing.JLabel();
        stimuno = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        iEntrostop = new javax.swing.JLabel();
        iSanadryl = new javax.swing.JLabel();
        iBufect = new javax.swing.JLabel();
        iNebacetin = new javax.swing.JLabel();
        entrostop = new javax.swing.JRadioButton();
        sanadryl = new javax.swing.JRadioButton();
        bufect = new javax.swing.JRadioButton();
        nebacetin = new javax.swing.JRadioButton();
        iDiapet = new javax.swing.JLabel();
        diapet = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pAtas.setBackground(new java.awt.Color(98, 111, 71));

        jLabel21.setFont(new java.awt.Font("Bookshelf Symbol 7", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 204));
        jLabel21.setText("jLabel21dghdrwwwwwww");
        pAtas.add(jLabel21);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APOTEK MINI");
        pAtas.add(jLabel1);

        jLabel22.setFont(new java.awt.Font("Bookshelf Symbol 7", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 204));
        jLabel22.setText("jLabel21dghdrhdasgsh");
        pAtas.add(jLabel22);

        getContentPane().add(pAtas, java.awt.BorderLayout.PAGE_START);

        pKanan.setBackground(new java.awt.Color(121, 134, 69));
        pKanan.setMinimumSize(new java.awt.Dimension(252, 443));
        pKanan.setPreferredSize(new java.awt.Dimension(200, 398));
        pKanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jumlah");
        pKanan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 51, 21));

        jumlah.setText("0");
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        pKanan.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        jLabel3.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");
        pKanan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rp.");
        pKanan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 191, -1, 20));

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        pKanan.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 191, 120, -1));

        buy.setText("Buy");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });
        pKanan.add(buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 80, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        pKanan.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 371, -1, -1));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        pKanan.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 371, -1, -1));

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });
        pKanan.add(kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        pKanan.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/apoteker.png"))); // NOI18N
        pKanan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 231, -1, 170));

        getContentPane().add(pKanan, java.awt.BorderLayout.LINE_END);

        pTengah.setBackground(new java.awt.Color(204, 204, 204));
        pTengah.setMinimumSize(new java.awt.Dimension(800, 100));
        pTengah.setPreferredSize(new java.awt.Dimension(500, 100));
        pTengah.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setBackground(new java.awt.Color(242, 238, 215));
        jPanel4.setMinimumSize(new java.awt.Dimension(514, 121));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 191));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        iBodrex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/bodrex.png"))); // NOI18N
        iBodrex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBodrexMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iBodrex, gridBagConstraints);

        iHufagrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/hufagrip.png"))); // NOI18N
        iHufagrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iHufagripMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iHufagrip, gridBagConstraints);

        iSucralfate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/sucralfate.png"))); // NOI18N
        iSucralfate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSucralfateMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iSucralfate, gridBagConstraints);

        iBetason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/betason.png"))); // NOI18N
        iBetason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBetasonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iBetason, gridBagConstraints);

        BGObat.add(bodrex);
        bodrex.setText("Bodrex->8.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(bodrex, gridBagConstraints);

        BGObat.add(hufagrip);
        hufagrip.setText("Hufagrip->18.000");
        hufagrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hufagripActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(hufagrip, gridBagConstraints);

        BGObat.add(sucralfate);
        sucralfate.setText("Sucralfate->15.000");
        sucralfate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucralfateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(sucralfate, gridBagConstraints);

        BGObat.add(betason);
        betason.setText("Betason->13.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(betason, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel5.setText("Tablet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel8.setText("Kapsul");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel9.setText("Sirup");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel10.setText("Suspensi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel10, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel20.setText("Salep");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel20, gridBagConstraints);

        iStimuno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/stimuno.png"))); // NOI18N
        iStimuno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iStimunoMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iStimuno, gridBagConstraints);

        BGObat.add(stimuno);
        stimuno.setText("Stimuno->25.000");
        stimuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stimunoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(stimuno, gridBagConstraints);

        pTengah.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(254, 250, 224));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        iEntrostop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/entrostop.png"))); // NOI18N
        iEntrostop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iEntrostopMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iEntrostop, gridBagConstraints);

        iSanadryl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/sanadryl.png"))); // NOI18N
        iSanadryl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSanadrylMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iSanadryl, gridBagConstraints);

        iBufect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/bufect.png"))); // NOI18N
        iBufect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBufectMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iBufect, gridBagConstraints);

        iNebacetin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/nebacetin.png"))); // NOI18N
        iNebacetin.setPreferredSize(new java.awt.Dimension(105, 90));
        iNebacetin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iNebacetinMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iNebacetin, gridBagConstraints);

        BGObat.add(entrostop);
        entrostop.setText("Entrostop->9.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(entrostop, gridBagConstraints);

        BGObat.add(sanadryl);
        sanadryl.setText("Sanadryl->18.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(sanadryl, gridBagConstraints);

        BGObat.add(bufect);
        bufect.setText("Bufect->22.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(bufect, gridBagConstraints);

        BGObat.add(nebacetin);
        nebacetin.setText("Nebacetin->24.000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(nebacetin, gridBagConstraints);

        iDiapet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/diapet.png"))); // NOI18N
        iDiapet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iDiapetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iDiapet, gridBagConstraints);

        BGObat.add(diapet);
        diapet.setText("Diapet->4.000");
        diapet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diapetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(diapet, gridBagConstraints);

        pTengah.add(jPanel5);

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diapetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diapetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diapetActionPerformed

    private void stimunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stimunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stimunoActionPerformed

    private void hufagripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hufagripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hufagripActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void sucralfateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucralfateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sucralfateActionPerformed

    private void iBodrexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBodrexMouseClicked
        ImageIcon Bodrex = new ImageIcon(getClass().getResource("bodrex.png"));
        JOptionPane.showMessageDialog(null, "Obat bebas yang digunakan untuk meredakan gejala \n"
                + "sakit kepala, demam, dan nyeri ringan. \n"
                + "Direkomendasikan untuk penggunaan jangka pendek.", 
                "Bodrex", JOptionPane.WIDTH,Bodrex);
    }//GEN-LAST:event_iBodrexMouseClicked

    private void iStimunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iStimunoMouseClicked
        ImageIcon Stimuno = new ImageIcon(getClass().getResource("stimuno.png"));
        JOptionPane.showMessageDialog(null, "Suplemen herbal yang berfungsi meningkatkan daya tahan tubuh. \n"
                + "Membantu memperkuat sistem imun dengan merangsang produksi antibodi, \n"
                + "Aman digunakan untuk jangka panjang sesuai anjuran.", 
                "Stimuno", JOptionPane.WIDTH,Stimuno);
    }//GEN-LAST:event_iStimunoMouseClicked

    private void iHufagripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iHufagripMouseClicked
        ImageIcon Hufagrip = new ImageIcon(getClass().getResource("hufagrip.png"));
        JOptionPane.showMessageDialog(null, "Obat ini tersedia dalam beberapa varian, \n"
                + "seperti Hufagrip Flu dan Batuk, Hufagrip Pilek, serta Hufagrip BP (Batuk Pilek). \n"
                + "Cocok untuk meredakan gejala flu pada anak-anak.", 
                "Hufagrip", JOptionPane.WIDTH,Hufagrip);
    }//GEN-LAST:event_iHufagripMouseClicked

    private void iSucralfateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSucralfateMouseClicked
        ImageIcon Sucralfate = new ImageIcon(getClass().getResource("sucralfate.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk mengobati dan mencegah \n"
                + "tukak lambung serta tukak usus. Obat ini biasanya tersedia dalam \n"
                + "bentuk tablet atau suspensi cair dan dikonsumsi sebelum makan.", 
                "Sucralfate", JOptionPane.WIDTH,Sucralfate);
    }//GEN-LAST:event_iSucralfateMouseClicked

    private void iBetasonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBetasonMouseClicked
        ImageIcon Betason = new ImageIcon(getClass().getResource("betason.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk mengobati kondisi peradangan pada kulit, \n"
                + "seperti eksim, dermatitis, atau psoriasis. Betason tersedia dalam bentuk krim atau salep \n"
                + "untuk penggunaan topikal, dan harus digunakan sesuai petunjuk dokter untuk menghindari efek samping.", 
                "Betason", JOptionPane.WIDTH,Betason);
    }//GEN-LAST:event_iBetasonMouseClicked

    private void iNebacetinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iNebacetinMouseClicked
        ImageIcon Nebacetin = new ImageIcon(getClass().getResource("nebacetin.png"));
        JOptionPane.showMessageDialog(null, "Salep antibiotik yang mengandung neomycin dan bacitracin. Untuk mengobati \n"
                + "infeksi kulit ringan, seperti luka kecil, luka bakar, dan luka lecet. \n"
                + "Nebacetin dioleskan langsung pada area yang terinfeksi. \n"
                + "Biasanya diresepkan untuk penggunaan jangka pendek sesuai anjuran dokter.", 
                "Nebacetin", JOptionPane.WIDTH,Nebacetin);
    }//GEN-LAST:event_iNebacetinMouseClicked

    private void iBufectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBufectMouseClicked
        ImageIcon Bufect = new ImageIcon(getClass().getResource("bufect.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk meredakan nyeri ringan hingga sedang, \n"
                + "seperti sakit kepala, nyeri otot, nyeri haid, serta meredakan demam. \n"
                + "Tersedia dalam bentuk tablet atau sirup, dan dosisnya harus disesuaikan dengan usia dan kondisi pasien.", 
                "Bufect", JOptionPane.WIDTH,Bufect);
    }//GEN-LAST:event_iBufectMouseClicked

    private void iSanadrylMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSanadrylMouseClicked
        ImageIcon Sanadryl = new ImageIcon(getClass().getResource("sanadryl.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk meredakan gejala alergi, seperti bersin, \n"
                + "Sanadryl tersedia dalam bentuk tablet atau sirup, \n"
                + "dan dapat menyebabkan kantuk, sehingga disarankan untuk menghindari \n"
                + "aktivitas yang membutuhkan konsentrasi tinggi setelah mengonsumsinya.", 
                "Sanadryl", JOptionPane.WIDTH,Sanadryl);
    }//GEN-LAST:event_iSanadrylMouseClicked

    private void iDiapetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iDiapetMouseClicked
        ImageIcon Diapet = new ImageIcon(getClass().getResource("diapet.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk mengatasi diare. \n"
                + "Diapet tersedia dalam bentuk kapsul dan tablet, \n"
                + "serta aman untuk penggunaan jangka pendek sesuai anjuran.", 
                "Diapet", JOptionPane.WIDTH,Diapet);
    }//GEN-LAST:event_iDiapetMouseClicked

    private void iEntrostopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iEntrostopMouseClicked
        ImageIcon Entrostop = new ImageIcon(getClass().getResource("entrostop.png"));
        JOptionPane.showMessageDialog(null, "Entrostop adalah obat diare yang mengandung kombinasi bahan aktif \n"
                + "yang menyerap racun dan zat berbahaya di usus, serta \n"
                + "meredakan iritasi pada saluran pencernaan. Entrostop digunakan untuk mengurangi \n"
                + "frekuensi buang air besar akibat diare, dan \n"
                + "tersedia dalam bentuk tablet atau serbuk.", 
                "Entrostop", JOptionPane.WIDTH,Entrostop);
    }//GEN-LAST:event_iEntrostopMouseClicked

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        BGObat.clearSelection();
        jumlah.setText("0");
        total.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        if(Jumlah <= 0){
            JOptionPane.showMessageDialog(null, "jumlah tidak boleh kurang dari 0");
        }
        else{
            Jumlah--;
        }
        
        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_kurangActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        Jumlah++;
        
        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_tambahActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
        if(BGObat.getSelection() == null){
            JOptionPane.showMessageDialog(null, "Mohon pilih salah satu obat terlebih dahulu!");
        }
        else if(jumlah.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Mohon masukkan jumlah obat yang ingin dipesan!");
        }
        else{
            int Jumlah = Integer.parseInt(jumlah.getText());
            
            int Obat = 0;
            if(bodrex.isSelected()){
                Obat = 8000;
            }
            else if(stimuno.isSelected()){
                Obat = 25000;
            }
            else if(hufagrip.isSelected()){
                Obat = 18000;
            }
            else if(sucralfate.isSelected()){
                Obat = 15000;
            }
            else if(betason.isSelected()){
                Obat = 13000;
            }
            else if(nebacetin.isSelected()){
                Obat = 24000;
            }
            else if(bufect.isSelected()){
                Obat = 22000;
            }
            else if(sanadryl.isSelected()){
                Obat = 18000;
            }
            else if(diapet.isSelected()){
                Obat = 4000;
            }
            else if(entrostop.isSelected()){
                Obat = 9000;
            }
            
            int Total = Obat*Jumlah;
            total.setText(String.valueOf(Total));
            
        }
    }//GEN-LAST:event_buyActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

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
            java.util.logging.Logger.getLogger(ngetest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ngetest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ngetest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ngetest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ngetest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGObat;
    private javax.swing.JRadioButton betason;
    private javax.swing.JRadioButton bodrex;
    private javax.swing.JRadioButton bufect;
    private javax.swing.JButton buy;
    private javax.swing.JRadioButton diapet;
    private javax.swing.JRadioButton entrostop;
    private javax.swing.JRadioButton hufagrip;
    private javax.swing.JLabel iBetason;
    private javax.swing.JLabel iBodrex;
    private javax.swing.JLabel iBufect;
    private javax.swing.JLabel iDiapet;
    private javax.swing.JLabel iEntrostop;
    private javax.swing.JLabel iHufagrip;
    private javax.swing.JLabel iNebacetin;
    private javax.swing.JLabel iSanadryl;
    private javax.swing.JLabel iStimuno;
    private javax.swing.JLabel iSucralfate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kurang;
    private javax.swing.JRadioButton nebacetin;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pKanan;
    private javax.swing.JPanel pTengah;
    private javax.swing.JButton reset;
    private javax.swing.JRadioButton sanadryl;
    private javax.swing.JRadioButton stimuno;
    private javax.swing.JRadioButton sucralfate;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
