
package tugas1;

public class Simpan extends javax.swing.JFrame {

    public Simpan() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bnukuran = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nama = new javax.swing.JLabel();
        notelpon = new javax.swing.JLabel();
        alamat = new javax.swing.JLabel();
        jenisproduk = new javax.swing.JLabel();
        ukuran = new javax.swing.JLabel();
        texsnotelp = new javax.swing.JTextField();
        texsalamat = new javax.swing.JTextField();
        jumlahpembelian = new javax.swing.JLabel();
        pembayaran = new javax.swing.JLabel();
        pengiriman = new javax.swing.JLabel();
        textjmlhbeli = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnselesai = new javax.swing.JButton();
        tfUkuran = new javax.swing.JTextField();
        tfJenisProduk = new javax.swing.JTextField();
        tfPembayaran = new javax.swing.JTextField();
        tfPengiriman = new javax.swing.JTextField();
        texsnama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(222, 235, 248));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas1/logo1.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 21, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel12.setText("Formulir Pemesanan Fashion");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel13.setText("Diah’s Pretty in Pink");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel14.setFont(new java.awt.Font("Serif", 0, 10)); // NOI18N
        jLabel14.setText("Jl. Raya Basuki Rahmad, PO, Box 3 Tuban Jawa Timur");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jLabel15.setFont(new java.awt.Font("Serif", 0, 10)); // NOI18N
        jLabel15.setText("Telp.081387532677, Call Center (209) 082458898");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\Downloads\\cloud-computing.png")); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(248, 223, 223));

        nama.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        nama.setText("Nama : ");

        notelpon.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        notelpon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\phone-rotary1.png")); // NOI18N
        notelpon.setText("No.Telp :");

        alamat.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        alamat.setText("Alamat :");

        jenisproduk.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jenisproduk.setText("Jenis Produk :");

        ukuran.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        ukuran.setText("Ukuran :");

        texsnotelp.setEditable(false);
        texsnotelp.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        texsnotelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texsnotelpActionPerformed(evt);
            }
        });

        texsalamat.setEditable(false);

        jumlahpembelian.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jumlahpembelian.setText("Jumlah pembelian :");

        pembayaran.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        pembayaran.setText("Pembayaran  :");

        pengiriman.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        pengiriman.setText("Pengiriman :");

        textjmlhbeli.setEditable(false);
        textjmlhbeli.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        textjmlhbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textjmlhbeliActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Lenovo\\OneDrive\\Documents\\PEMVIS DAN PRAKTIKUM\\CODINGAN PEMVIS\\fashion.png")); // NOI18N

        btnselesai.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnselesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tugas1/return.png"))); // NOI18N
        btnselesai.setText("Kembali");
        btnselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselesaiActionPerformed(evt);
            }
        });

        tfUkuran.setEditable(false);

        tfJenisProduk.setEditable(false);
        tfJenisProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJenisProdukActionPerformed(evt);
            }
        });

        tfPembayaran.setEditable(false);

        tfPengiriman.setEditable(false);

        texsnama.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notelpon)
                            .addComponent(alamat)
                            .addComponent(nama))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(texsnotelp, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                            .addComponent(texsalamat)
                            .addComponent(texsnama)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenisproduk)
                            .addComponent(ukuran)
                            .addComponent(jumlahpembelian)
                            .addComponent(pembayaran)
                            .addComponent(pengiriman))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUkuran)
                            .addComponent(textjmlhbeli)
                            .addComponent(tfJenisProduk)
                            .addComponent(tfPembayaran)
                            .addComponent(tfPengiriman))))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(btnselesai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama)
                    .addComponent(texsnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notelpon)
                    .addComponent(texsnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamat)
                    .addComponent(texsalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jenisproduk)
                    .addComponent(tfJenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ukuran)
                    .addComponent(tfUkuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahpembelian)
                    .addComponent(textjmlhbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pembayaran)
                    .addComponent(tfPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pengiriman)
                            .addComponent(tfPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnselesai))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void texsnotelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texsnotelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texsnotelpActionPerformed

    private void textjmlhbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textjmlhbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textjmlhbeliActionPerformed

    private void btnselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselesaiActionPerformed
         pendaftaran daftar = new pendaftaran();
         daftar.setVisible(true);
    }//GEN-LAST:event_btnselesaiActionPerformed

    private void tfJenisProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJenisProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJenisProdukActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simpan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel alamat;
    public javax.swing.ButtonGroup bnukuran;
    private javax.swing.JButton btnselesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JLabel jenisproduk;
    public javax.swing.JLabel jumlahpembelian;
    public javax.swing.JLabel nama;
    public javax.swing.JLabel notelpon;
    public javax.swing.JLabel pembayaran;
    public javax.swing.JLabel pengiriman;
    public javax.swing.JTextField texsalamat;
    public javax.swing.JTextField texsnama;
    public javax.swing.JTextField texsnotelp;
    public javax.swing.JTextField textjmlhbeli;
    public javax.swing.JTextField tfJenisProduk;
    public javax.swing.JTextField tfPembayaran;
    public javax.swing.JTextField tfPengiriman;
    public javax.swing.JTextField tfUkuran;
    public javax.swing.JLabel ukuran;
    // End of variables declaration//GEN-END:variables
}
