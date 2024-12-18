/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bayar;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Iruzzend
 */
public class Bayarspp extends javax.swing.JFrame {
    boolean[] statusPembayaranBulan = new boolean[12];
    private String namaSiswa = "";
    private String kelasSiswa = "";
    
    public Bayarspp() {
        initComponents();
        txtbayar.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                penghitungan();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void penghitungan() {
        try {
            double pembayaran = Double.parseDouble(txttotal.getText()); // Total harga yang baru
            double uangmasuk = Double.parseDouble(txtbayar.getText()); // Uang yang sudah dimasukkan
            double kembalian = uangmasuk - pembayaran;

            if (kembalian >= 0) {
                txtkembali.setText(String.valueOf(kembalian)); // Menampilkan kembalian
            } else {
                txtkembali.setText("Uang Tidak Cukup"); // Jika uang kurang
            }
        } catch (NumberFormatException e) {
            txtkembali.setText(""); // Kosongkan jika error parsing
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtkelas = new javax.swing.JTextField();
        btnkirim = new javax.swing.JButton();
        btnstatus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jan = new javax.swing.JCheckBox();
        feb = new javax.swing.JCheckBox();
        mar = new javax.swing.JCheckBox();
        apr = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        jun = new javax.swing.JCheckBox();
        jul = new javax.swing.JCheckBox();
        agus = new javax.swing.JCheckBox();
        sep = new javax.swing.JCheckBox();
        okt = new javax.swing.JCheckBox();
        nov = new javax.swing.JCheckBox();
        des = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btnkeluar = new javax.swing.JButton();
        txttotal = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtkembali = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btntotal = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbriwayat = new javax.swing.JTable();
        btnriwayat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(new javax.swing.ImageIcon("C:\\Users\\123\\Downloads\\ini icon\\image1-2.png")), "PEMBAYARAN SPP", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Montserrat SemiBold", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sekolah SMP NGAWI Utara Pucuk Timur Laut Kapal");
        jPanel1.add(jLabel7);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 1080, 210));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Siswa");

        btnkirim.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btnkirim.setText("Kirim");
        btnkirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkirimActionPerformed(evt);
            }
        });

        btnstatus.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        btnstatus.setText("Status");
        btnstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kelas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnstatus)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnkirim))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(89, 89, 89)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtkelas)
                                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel2)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnkirim)
                    .addComponent(btnstatus))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 197, 560, 280));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        jPanel6.setBackground(new java.awt.Color(0, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("LOKET PEMBAYARAN");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel6)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));

        jan.setText("Januari");

        feb.setText("Februari");

        mar.setText("Maret");

        apr.setText("April");

        mei.setText("Mei");

        jun.setText("Juni");

        jul.setText("Juli");

        agus.setText("Agustus");

        sep.setText("September");

        okt.setText("Oktober");

        nov.setText("November");

        des.setText("Desember");

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel1.setText("Pilih Bulan");

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        txttotal.setEditable(false);

        txtkembali.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel9.setText("Kembali");

        btntotal.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        btntotal.setText("Total");
        btntotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnbayar.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel5.setText("Total");

        jLabel8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        jLabel8.setText("Bayar");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jLabel1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jan)
                        .addGap(38, 38, 38)
                        .addComponent(feb)
                        .addGap(18, 18, 18)
                        .addComponent(mar)
                        .addGap(43, 43, 43)
                        .addComponent(apr))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(mei)
                        .addGap(55, 55, 55)
                        .addComponent(jun)
                        .addGap(40, 40, 40)
                        .addComponent(jul)
                        .addGap(57, 57, 57)
                        .addComponent(agus))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(sep)
                        .addGap(18, 18, 18)
                        .addComponent(okt)
                        .addGap(18, 18, 18)
                        .addComponent(nov)
                        .addGap(18, 18, 18)
                        .addComponent(des)))
                .addGap(0, 57, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntotal))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbayar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnreset)
                            .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnkeluar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jan)
                    .addComponent(feb)
                    .addComponent(mar)
                    .addComponent(apr))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mei)
                    .addComponent(jun)
                    .addComponent(jul)
                    .addComponent(agus))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep)
                    .addComponent(okt)
                    .addComponent(nov)
                    .addComponent(des))
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotal)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbayar)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreset)
                    .addComponent(btnkeluar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 197, -1, 640));

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setLayout(new java.awt.BorderLayout(5, 0));

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        tbriwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Bulan", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbriwayat);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 514, -1, -1));

        btnriwayat.setFont(new java.awt.Font("Montserrat Medium", 1, 14)); // NOI18N
        btnriwayat.setText("Riwayat Pembayaran");
        btnriwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnriwayatActionPerformed(evt);
            }
        });
        getContentPane().add(btnriwayat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 483, 553, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatusActionPerformed
        updateStatusPembayaranTabel();
    }
        private void updateStatusPembayaranTabel() {
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        DefaultTableModel model = (DefaultTableModel) tbriwayat.getModel();
        model.setRowCount(0);

        boolean lunasSemua = true; 

        for (int i = 0; i < statusPembayaranBulan.length; i++) {
            String status = statusPembayaranBulan[i] ? "Lunas" : "Belum dibayar";
            model.addRow(new Object[]{bulan[i], status});

            // Cek jika ada bulan yang belum lunas
            if (!statusPembayaranBulan[i]) {
                lunasSemua = false;
            }
        }

        // Tampilkan pesan sesuai status pembayaran
        if (lunasSemua) {
            JOptionPane.showMessageDialog(null, "Pembayaran sudah lunas untuk semua bulan.", "Status Pembayaran", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pembayaran belum lunas. Silakan cek bulan yang belum dibayar.", "Status Pembayaran", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnstatusActionPerformed

    private void btnkirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkirimActionPerformed
        String nama = txtnama.getText();
        String kelas = txtkelas.getText();

        if (nama.isEmpty() || kelas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap mengisi semua data siswa!");
        } else {
            // Simpan data siswa ke variabel global
            namaSiswa = nama;
            kelasSiswa = kelas;

            // Kosongkan field setelah data dikirim
            txtnama.setText("");
            txtkelas.setText("");

            JOptionPane.showMessageDialog(null, "Data siswa berhasil dikirim!");
        }
    }//GEN-LAST:event_btnkirimActionPerformed

    private void btnriwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnriwayatActionPerformed
       if (namaSiswa.isEmpty() || kelasSiswa.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Belum ada data siswa yang diinputkan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
        // Membuat string builder untuk riwayat pembayaran
        StringBuilder riwayat = new StringBuilder();
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        // Tampilkan data siswa dari variabel global
        riwayat.append("Nama: ").append(namaSiswa).append("\n");
        riwayat.append("Kelas: ").append(kelasSiswa).append("\n");

        // Tambahkan riwayat pembayaran yang sudah dibayar
        boolean adaPembayaran = false;
        for (int i = 0; i < statusPembayaranBulan.length; i++) {
            if (statusPembayaranBulan[i]) {
                riwayat.append(bulan[i]).append(" sudah dibayar\n");
                adaPembayaran = true;
            }
        }

        // Jika belum ada pembayaran, tampilkan pesan ini
        if (!adaPembayaran) {
            riwayat.append("Belum ada pembayaran yang dilakukan.");
        }

        JOptionPane.showMessageDialog(null, riwayat.toString(), "Riwayat Pembayaran", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnriwayatActionPerformed

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        double totalPembayaran = Double.parseDouble(txttotal.getText());
        double uangDibayar = Double.parseDouble(txtbayar.getText());
        if (uangDibayar < totalPembayaran) {
            JOptionPane.showMessageDialog(null, "Pembayaran kurang!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update status pembayaran bulan yang dipilih
        if (jan.isSelected()) statusPembayaranBulan[0] = true;
        if (feb.isSelected()) statusPembayaranBulan[1] = true;
        if (mar.isSelected()) statusPembayaranBulan[2] = true;
        if (apr.isSelected()) statusPembayaranBulan[3] = true;
        if (mei.isSelected()) statusPembayaranBulan[4] = true;
        if (jun.isSelected()) statusPembayaranBulan[5] = true;
        if (jul.isSelected()) statusPembayaranBulan[6] = true;
        if (agus.isSelected()) statusPembayaranBulan[7] = true;
        if (sep.isSelected()) statusPembayaranBulan[8] = true;
        if (okt.isSelected()) statusPembayaranBulan[9] = true;
        if (nov.isSelected()) statusPembayaranBulan[10] = true;
        if (des.isSelected()) statusPembayaranBulan[11] = true;

        // Kosongkan semua field setelah data terkirim
        txtbayar.setText("");
        txtkembali.setText("");
        txttotal.setText("");
        jan.setSelected(false);
        feb.setSelected(false);
        mar.setSelected(false);
        apr.setSelected(false);
        mei.setSelected(false);
        jun.setSelected(false);
        jul.setSelected(false);
        agus.setSelected(false);
        sep.setSelected(false);
        okt.setSelected(false);
        nov.setSelected(false);
        des.setSelected(false);

        JOptionPane.showMessageDialog(null, "Pembayaran berhasil dan data telah disimpan.");
    }//GEN-LAST:event_btnbayarActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        jan.setSelected(false);
        feb.setSelected(false);
        mar.setSelected(false);
        apr.setSelected(false);
        mei.setSelected(false);
        jun.setSelected(false);
        jul.setSelected(false);
        agus.setSelected(false);
        sep.setSelected(false);
        okt.setSelected(false);
        nov.setSelected(false);
        des.setSelected(false);

        // Reset total pembayaran
        txttotal.setText("");
        txtbayar.setText("");

        // Tampilkan pesan konfirmasi
        JOptionPane.showMessageDialog(null, "Pilihan pembayaran telah dibatalkan.", "Pembatalan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnresetActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        if (namaSiswa.isEmpty() || kelasSiswa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap mengisi data siswa terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Periksa dan nonaktifkan checkbox untuk bulan yang sudah lunas
        if (statusPembayaranBulan[0]) {
            jan.setEnabled(false);
            jan.setSelected(false); // Deselect jika sudah lunas
        }
        if (statusPembayaranBulan[1]) {
            feb.setEnabled(false);
            feb.setSelected(false);
        }
        if (statusPembayaranBulan[2]) {
            mar.setEnabled(false);
            mar.setSelected(false);
        }
        if (statusPembayaranBulan[3]) {
            apr.setEnabled(false);
            apr.setSelected(false);
        }
        if (statusPembayaranBulan[4]) {
            mei.setEnabled(false);
            mei.setSelected(false);
        }
        if (statusPembayaranBulan[5]) {
            jun.setEnabled(false);
            jun.setSelected(false);
        }
        if (statusPembayaranBulan[6]) {
            jul.setEnabled(false);
            jul.setSelected(false);
        }
        if (statusPembayaranBulan[7]) {
            agus.setEnabled(false);
            agus.setSelected(false);
        }
        if (statusPembayaranBulan[8]) {
            sep.setEnabled(false);
            sep.setSelected(false);
        }
        if (statusPembayaranBulan[9]) {
            okt.setEnabled(false);
            okt.setSelected(false);
        }
        if (statusPembayaranBulan[10]) {
            nov.setEnabled(false);
            nov.setSelected(false);
        }
        if (statusPembayaranBulan[11]) {
            des.setEnabled(false);
            des.setSelected(false);
        }

        // Lanjutkan dengan logika perhitungan total pembayaran
        try {
            double sppPerBulan = 500000; // Misalkan biaya per bulan
            int jumlahBulanDipilih = 0;

            // Cek bulan yang dipilih dan tidak lunas
            if (jan.isSelected() && !statusPembayaranBulan[0]) jumlahBulanDipilih++;
            if (feb.isSelected() && !statusPembayaranBulan[1]) jumlahBulanDipilih++;
            if (mar.isSelected() && !statusPembayaranBulan[2]) jumlahBulanDipilih++;
            if (apr.isSelected() && !statusPembayaranBulan[3]) jumlahBulanDipilih++;
            if (mei.isSelected() && !statusPembayaranBulan[4]) jumlahBulanDipilih++;
            if (jun.isSelected() && !statusPembayaranBulan[5]) jumlahBulanDipilih++;
            if (jul.isSelected() && !statusPembayaranBulan[6]) jumlahBulanDipilih++;
            if (agus.isSelected() && !statusPembayaranBulan[7]) jumlahBulanDipilih++;
            if (sep.isSelected() && !statusPembayaranBulan[8]) jumlahBulanDipilih++;
            if (okt.isSelected() && !statusPembayaranBulan[9]) jumlahBulanDipilih++;
            if (nov.isSelected() && !statusPembayaranBulan[10]) jumlahBulanDipilih++;
            if (des.isSelected() && !statusPembayaranBulan[11]) jumlahBulanDipilih++;

            // Total yang harus dibayar
            double totalPembayaran = jumlahBulanDipilih * sppPerBulan;
            txttotal.setText(String.valueOf(totalPembayaran));

            // Cek apakah input pembayaran tidak kosong dan valid
            String uangDibayarText = txtbayar.getText().trim();
            if (uangDibayarText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Harap masukkan jumlah uang yang dibayar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Parse jumlah uang yang dibayarkan
            double uangDibayar = Double.parseDouble(uangDibayarText);

            // Panggil metode penghitungan untuk menghitung kembalian
            penghitungan();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah uang yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btntotalActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        int pilihan = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih "Yes", program akan ditutup
        if (pilihan == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnkeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Bayarspp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bayarspp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bayarspp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bayarspp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bayarspp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agus;
    private javax.swing.JCheckBox apr;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkirim;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnriwayat;
    private javax.swing.JButton btnstatus;
    private javax.swing.JButton btntotal;
    private javax.swing.JCheckBox des;
    private javax.swing.JCheckBox feb;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jan;
    private javax.swing.JCheckBox jul;
    private javax.swing.JCheckBox jun;
    private javax.swing.JCheckBox mar;
    private javax.swing.JCheckBox mei;
    private javax.swing.JCheckBox nov;
    private javax.swing.JCheckBox okt;
    private javax.swing.JCheckBox sep;
    private javax.swing.JTable tbriwayat;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JTextField txtkelas;
    private javax.swing.JTextField txtkembali;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
