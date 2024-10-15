
package tugaspraktikum3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Apotik extends javax.swing.JFrame {
 private int jumlah;
 private int totalHarga;
 
    public Apotik() {
        initComponents();
        tfBayar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                bayar();
        }
        });
    }

private void bayar() {
        try {
            int pembayaran = Integer.parseInt(tfBayar.getText().trim());
            int total = Integer.parseInt(tfTotal.getText().trim());
            int kembalian = pembayaran - total;

            if (pembayaran < total) {
                tfKembalian.setText("Uang Tidak Cukup");
            } else {
                tfKembalian.setText("Rp. "+ kembalian);
            }
        } catch (NumberFormatException e) {
            tfKembalian.setText("Input Tidak Sesuai");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pAtas = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pKiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSakitKepala = new javax.swing.JButton();
        btnNyeri = new javax.swing.JButton();
        btnFlu = new javax.swing.JButton();
        btnBatuk = new javax.swing.JButton();
        btnLambung = new javax.swing.JButton();
        pKanan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfTotal = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfBayar = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfKembalian = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tfJumlah = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pTengah = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbCoughSyrup = new javax.swing.JCheckBox();
        cbParacetamol = new javax.swing.JCheckBox();
        cbIbuprofen = new javax.swing.JCheckBox();
        cbPseudoephedrine = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cbOmeprazole = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Antasida = new javax.swing.JCheckBox();
        cbCoughDrops = new javax.swing.JCheckBox();
        cbPainReliefCream = new javax.swing.JCheckBox();
        cbHeadache = new javax.swing.JCheckBox();
        cbTheraflu = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pAtas.setBackground(new java.awt.Color(255, 255, 255));
        pAtas.setLayout(new java.awt.GridLayout(2, 1));

        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nagieeeta.Apotek");
        pAtas.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Jl.Kalianget-Anget");
        pAtas.add(jLabel14);

        getContentPane().add(pAtas, java.awt.BorderLayout.PAGE_START);

        pKiri.setBackground(new java.awt.Color(51, 102, 255));
        pKiri.setLayout(new java.awt.GridLayout(6, 1, 2, 2));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Rekomen Dasi Obat ");
        pKiri.add(jLabel1);

        btnSakitKepala.setBackground(new java.awt.Color(255, 102, 102));
        btnSakitKepala.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSakitKepala.setForeground(new java.awt.Color(255, 255, 255));
        btnSakitKepala.setText("Obat Sakit Kepala");
        btnSakitKepala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSakitKepalaActionPerformed(evt);
            }
        });
        pKiri.add(btnSakitKepala);

        btnNyeri.setBackground(new java.awt.Color(255, 102, 102));
        btnNyeri.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnNyeri.setForeground(new java.awt.Color(255, 255, 255));
        btnNyeri.setText("Obat Nyeri ");
        btnNyeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyeriActionPerformed(evt);
            }
        });
        pKiri.add(btnNyeri);

        btnFlu.setBackground(new java.awt.Color(255, 102, 102));
        btnFlu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnFlu.setForeground(new java.awt.Color(255, 255, 255));
        btnFlu.setText("Obat Flu");
        btnFlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFluActionPerformed(evt);
            }
        });
        pKiri.add(btnFlu);

        btnBatuk.setBackground(new java.awt.Color(255, 102, 102));
        btnBatuk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBatuk.setForeground(new java.awt.Color(255, 255, 255));
        btnBatuk.setText("Obat Batuk");
        btnBatuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatukActionPerformed(evt);
            }
        });
        pKiri.add(btnBatuk);

        btnLambung.setBackground(new java.awt.Color(255, 102, 102));
        btnLambung.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnLambung.setForeground(new java.awt.Color(255, 255, 255));
        btnLambung.setText("Asam Lambung");
        btnLambung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLambungActionPerformed(evt);
            }
        });
        pKiri.add(btnLambung);

        getContentPane().add(pKiri, java.awt.BorderLayout.LINE_START);

        pKanan.setBackground(new java.awt.Color(51, 102, 255));
        pKanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        tfTotal.setBackground(new java.awt.Color(0, 102, 255));
        tfTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfTotal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Bayar :");

        tfBayar.setBackground(new java.awt.Color(0, 102, 255));
        tfBayar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfBayar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Kembalian :");

        tfKembalian.setBackground(new java.awt.Color(0, 102, 255));
        tfKembalian.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfKembalian.setForeground(new java.awt.Color(255, 255, 255));

        jButton6.setBackground(new java.awt.Color(0, 102, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Reset");

        btnTotal.setBackground(new java.awt.Color(0, 102, 255));
        btnTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotal.setForeground(new java.awt.Color(255, 255, 255));
        btnTotal.setText("Total ");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("JumlahPesan :");

        tfJumlah.setBackground(new java.awt.Color(0, 102, 255));
        tfJumlah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfJumlah.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(29, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(tfTotal)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(btnTotal))
                .addGap(100, 100, 100))
        );

        pKanan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 320, 340));

        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pesan Obat ");
        pKanan.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        getContentPane().add(pKanan, java.awt.BorderLayout.LINE_END);

        pTengah.setBackground(new java.awt.Color(51, 153, 255));
        pTengah.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel2, gridBagConstraints);

        jLabel3.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel3, gridBagConstraints);

        jLabel4.setText("jLabel4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel4, gridBagConstraints);

        jLabel5.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pilihan Obat ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 35;
        pTengah.add(jLabel6, gridBagConstraints);

        cbCoughSyrup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbCoughSyrup.setText("Cough Syrup");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbCoughSyrup, gridBagConstraints);

        cbParacetamol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbParacetamol.setText("Paracetamol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbParacetamol, gridBagConstraints);

        cbIbuprofen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbIbuprofen.setText("Ibuprofen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbIbuprofen, gridBagConstraints);

        cbPseudoephedrine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbPseudoephedrine.setText("Pseudoephedrine");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbPseudoephedrine, gridBagConstraints);

        jLabel7.setText("jLabel7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel7, gridBagConstraints);

        cbOmeprazole.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbOmeprazole.setText("Omeprazole");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbOmeprazole, gridBagConstraints);

        jLabel8.setText("jLabel8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel8, gridBagConstraints);

        jLabel9.setText("jLabel9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel9, gridBagConstraints);

        jLabel10.setText("jLabel10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel10, gridBagConstraints);

        jLabel11.setText("jLabel11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel11, gridBagConstraints);

        jLabel12.setText("jLabel12");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(jLabel12, gridBagConstraints);

        Antasida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Antasida.setText("Antasida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(Antasida, gridBagConstraints);

        cbCoughDrops.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbCoughDrops.setText("Cough Drops");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbCoughDrops, gridBagConstraints);

        cbPainReliefCream.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbPainReliefCream.setText("Pain Relief Cream");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbPainReliefCream, gridBagConstraints);

        cbHeadache.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbHeadache.setText("Headache Relief");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbHeadache, gridBagConstraints);

        cbTheraflu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbTheraflu.setText("Theraflu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pTengah.add(cbTheraflu, gridBagConstraints);

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLambungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLambungActionPerformed
    String detailObat = "Omeprazole: \nHarga: 30.000\nDeskripsi: Mengatasi asam lambung, GERD, dan tukak lambung\nDosis: 20-40 mg sekali sehari\n\n"
               + "Antasida: \nHarga: 20.000\nDeskripsi: Mengatasi asam lambung berlebih, dan gangguan pencernaan\nDosis: 1-2 tablet saat gejala muncul";
    
    JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnLambungActionPerformed

    private void btnBatukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatukActionPerformed
    String detailObat = "Cough Syrup: \nHarga: 16.000\nDeskripsi: Digunakan untuk meredakan batuk kering\nDosis: 10-20 ml setiap 4-6 jam, tidak lebih dari 4 dosis per hari\n\n"
               + "Cough Drops: \nHarga: 8.000\nDeskripsi: Mengurangi iritasi tenggorokan dan batuk\nDosis:1 tablet hisap setiap 2 hingga 3 jam, atau sesuai dengan petunjuk pada kemasan atau saran dokter.";
    
    JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnBatukActionPerformed

    private void btnSakitKepalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSakitKepalaActionPerformed
      String detailObat = "Paracetamol: \nHarga: 5.000\nDeskripsi: Mengurangi nyeri kepala dan demam\nDosis: 500 mg hingga 1000 mg setiap 4-6 jam sesuai kebutuhan\n\n"
               + "Headache Relief: \nHarga: 7.000\nDeskripsi: Obat untuk meredakan sakit kepala\nDosis:500 mg hingga 1000 mg setiap 4-6 jam, sesuai kebutuhan. Dosis maksimal per hari adalah 4000 mg.";
    
    JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSakitKepalaActionPerformed

    private void btnNyeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyeriActionPerformed
    String detailObat = "Ibuprofen: \nHarga: 5.000\nDeskripsi: Obat antiinflamasi untuk mengatasi nyeri dan peradangan\nDosis: 200 mg hingga 400 mg setiap 4-6 jam sesuai kebutuhan. Dosis maksimal per hari adalah 1200 mg (tanpa resep dokter).\n\n"
               + "Pain Relief Cream: \nHarga: 18.000\nDeskripsi: Krim untuk mengurangi nyeri otot dan sendi\nDosis:Oleskan krim dengan kandungan menthol 1% hingga 5% sesuai petunjuk pada kemasan, biasanya 3-4 kali sehari.";
    
    JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnNyeriActionPerformed

    private void btnFluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFluActionPerformed
    String detailObat = "cbTheraflu: \nHarga: 17.000\nDeskripsi: Meredakan hidung tersumbat akibat flu.\nDosis:  60 mg setiap 4-6 jam (maksimal 240 mg per hari).\n\n"
               + "Pseudoephedrine: \nHarga: 12.000\nDeskripsi: Membantu meredakan gejala flu dan pilek.\nDosis:60 mg setiap 4-6 jam (maksimal 240 mg per hari).";
    
    JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnFluActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
    int totalHarga = 0;
    int jumlah = 0;
    
    
    if (tfJumlah.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Mohon isi jumlah yang ingin dibeli.");
        return;
    }

try {

    jumlah = Integer.parseInt(tfJumlah.getText());

    // Lanjutkan perhitungan jika jumlah valid
    if (cbCoughSyrup.isSelected()) {
        totalHarga += 16000 * jumlah;
    }
    if (cbParacetamol.isSelected()) {
        totalHarga += 5000 * jumlah;
    }
    if (cbIbuprofen.isSelected()) {
        totalHarga += 5000 * jumlah;
    }
    if (cbCoughDrops.isSelected()) {
        totalHarga += 8000 * jumlah;
    }
    if (cbOmeprazole.isSelected()) {
        totalHarga += 30000 * jumlah;
    }
    if (cbTheraflu.isSelected()) {
        totalHarga += 17000 * jumlah;
    }
    if (cbPseudoephedrine.isSelected()) {
        totalHarga += 12000 * jumlah;
    }
    if (cbPainReliefCream.isSelected()) {
        totalHarga += 18000 * jumlah;
    }

    tfTotal.setText("" + totalHarga);
    
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Mohon masukkan jumlah yang valid (angka).");
}

    }//GEN-LAST:event_btnTotalActionPerformed

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
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apotik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Antasida;
    private javax.swing.JButton btnBatuk;
    private javax.swing.JButton btnFlu;
    private javax.swing.JButton btnLambung;
    private javax.swing.JButton btnNyeri;
    private javax.swing.JButton btnSakitKepala;
    private javax.swing.JButton btnTotal;
    private javax.swing.JCheckBox cbCoughDrops;
    private javax.swing.JCheckBox cbCoughSyrup;
    private javax.swing.JCheckBox cbHeadache;
    private javax.swing.JCheckBox cbIbuprofen;
    private javax.swing.JCheckBox cbOmeprazole;
    private javax.swing.JCheckBox cbPainReliefCream;
    private javax.swing.JCheckBox cbParacetamol;
    private javax.swing.JCheckBox cbPseudoephedrine;
    private javax.swing.JCheckBox cbTheraflu;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pKanan;
    private javax.swing.JPanel pKiri;
    private javax.swing.JPanel pTengah;
    private javax.swing.JTextField tfBayar;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKembalian;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
