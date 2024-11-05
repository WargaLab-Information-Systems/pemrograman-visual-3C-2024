package tugaspraktikum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ManajemenKP extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    public ManajemenKP() {
        initComponents();
        conn = koneksi.getConnection();
        //tabel Karyawan
        model = new DefaultTableModel();
        tblKaryawan.setModel(model);
        model.addColumn("Id Proyek");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");        
        loadData();
        
        // Tabel Proyek
        modelProyek = new DefaultTableModel();
        tblProyek.setModel(modelProyek);
        modelProyek.addColumn("Id Proyek");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi Pengerjaan");
        loadDataProyek(); 
        
        // Tabel Proyek
        modelTransaksi = new DefaultTableModel();
        tblTransaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("Id Karyawan");
        modelTransaksi.addColumn("id Proyek");
        modelTransaksi.addColumn("Peran ");
        loadDataTransaksi();        
    }
    
    private void loadData() {
          model.setRowCount(0);
          try {
              String sql = "SELECT * FROM karyawan ";
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                 model.addRow(new Object[]{
                 rs.getInt("ID"),
                 rs.getString("Nama"),
                 rs.getString("Jabatan"),
                 rs.getString("Departemen")
               });
              }
          } catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
           }          
        }
    private void loadDataProyek() {
        modelProyek.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelProyek.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_proyek"),
                    rs.getInt("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Proyek: " + e.getMessage());
        }
    }
    private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0);
     try {
              String sql = "SELECT * FROM transaksi ";
              PreparedStatement ps = conn.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              while (rs.next()) {
                 modelTransaksi.addRow(new Object[]{
                 rs.getInt("id_karyawan"),
                 rs.getInt("id_proyek"),
                 rs.getString("peran")
               });
              }
              
          } catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
           }
     
    String proyek= "SELECT id, nama_proyek FROM proyek"; 
    String karyawan = "SELECT id, nama FROM karyawan";
    

    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("id"); 
            cbProyek.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("id"); 
            cbKaryawan.addItem(namaKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    }
    
    private void saveData() {
          try{
             String sql = "INSERT INTO karyawan (nama, jabatan, departemen ) VALUES (?, ?, ? )";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, tfNama.getText());
             ps.setString(2, tfJabatan.getText());
             ps.setString(3, tfDepartemen.getText());
             ps.executeUpdate();
             JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
             loadData();
           } catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
           }
         }

    private void updateData() {
          try {
              String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setString(1, tfNama.getText());
              ps.setString(2, tfJabatan.getText());
              ps.setString(3, tfDepartemen.getText());
              ps.setInt(4, Integer.parseInt(tfIDKaryawan.getText()));
              ps.executeUpdate();
              JOptionPane.showMessageDialog(this, "Data berhasil di update");
              loadData();
          }  catch (SQLException e) {
              System.out.println("Error Save Data" + e.getMessage());
          }
         }
        private void deleteData() {
         try  {
              String sql = "DELETE FROM karyawan WHERE id = ?";
              PreparedStatement ps = conn.prepareStatement(sql);
              ps.setInt(1, Integer.parseInt(tfIDKaryawan.getText()));
              ps.executeUpdate();
              JOptionPane.showMessageDialog(this, "Data berhasil di delete");
              loadData();
         } catch (SQLException e) {
              System.out.println("Error Save Data" + e.getMessage());
          }
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        p_karyawan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfIDKaryawan = new javax.swing.JTextField();
        tfJabatan = new javax.swing.JTextField();
        tfDepartemen = new javax.swing.JTextField();
        btnC1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        bntU1 = new javax.swing.JButton();
        btnD1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnC2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnU2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnD2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfNamaProyek = new javax.swing.JTextField();
        tfIDProyek = new javax.swing.JTextField();
        tfDurasiPengerjaan = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProyek = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbKaryawan = new javax.swing.JComboBox<>();
        cbProyek = new javax.swing.JComboBox<>();
        tfPeran = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnC3 = new javax.swing.JButton();
        btnU3 = new javax.swing.JButton();
        btnD3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel1.setText("Aplikasi ManajemenKP");
        jPanel5.add(jLabel1);

        getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 153, 204));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        p_karyawan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("ID  Karyawan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Jabatan");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Departemen");

        tfNama.setBackground(new java.awt.Color(102, 102, 255));
        tfNama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfNama.setForeground(new java.awt.Color(255, 255, 255));
        tfNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfIDKaryawan.setBackground(new java.awt.Color(102, 102, 255));
        tfIDKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfIDKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        tfIDKaryawan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfJabatan.setBackground(new java.awt.Color(102, 102, 255));
        tfJabatan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfJabatan.setForeground(new java.awt.Color(255, 255, 255));
        tfJabatan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfDepartemen.setBackground(new java.awt.Color(102, 102, 255));
        tfDepartemen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfDepartemen.setForeground(new java.awt.Color(255, 255, 255));
        tfDepartemen.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnC1.setBackground(new java.awt.Color(0, 102, 255));
        btnC1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnC1.setForeground(new java.awt.Color(255, 255, 255));
        btnC1.setText("Create");
        btnC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Action");

        bntU1.setBackground(new java.awt.Color(255, 204, 0));
        bntU1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntU1.setForeground(new java.awt.Color(255, 255, 255));
        bntU1.setText("Update");
        bntU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntU1ActionPerformed(evt);
            }
        });

        btnD1.setBackground(new java.awt.Color(255, 0, 0));
        btnD1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnD1.setForeground(new java.awt.Color(255, 255, 255));
        btnD1.setText("Delete");
        btnD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnD1ActionPerformed(evt);
            }
        });

        tblKaryawan.setBackground(new java.awt.Color(255, 153, 153));
        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID karyawan", "Nama", "Jabatan", "Departemen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblKaryawan);

        javax.swing.GroupLayout p_karyawanLayout = new javax.swing.GroupLayout(p_karyawan);
        p_karyawan.setLayout(p_karyawanLayout);
        p_karyawanLayout.setHorizontalGroup(
            p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_karyawanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p_karyawanLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnC1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntU1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD1))
                    .addGroup(p_karyawanLayout.createSequentialGroup()
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        p_karyawanLayout.setVerticalGroup(
            p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_karyawanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_karyawanLayout.createSequentialGroup()
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfIDKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnC1)
                    .addComponent(bntU1)
                    .addComponent(btnD1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Karyawan", p_karyawan);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnC2.setBackground(new java.awt.Color(0, 102, 255));
        btnC2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnC2.setForeground(new java.awt.Color(255, 255, 255));
        btnC2.setText("Create");
        btnC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Action");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("ID Proyek ");

        btnU2.setBackground(new java.awt.Color(255, 204, 0));
        btnU2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnU2.setForeground(new java.awt.Color(255, 255, 255));
        btnU2.setText("Update");
        btnU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnU2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Nama Proyek");

        btnD2.setBackground(new java.awt.Color(255, 0, 0));
        btnD2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnD2.setForeground(new java.awt.Color(255, 255, 255));
        btnD2.setText("Delete");
        btnD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnD2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Durasi Pekerjaan");

        tfNamaProyek.setBackground(new java.awt.Color(102, 102, 255));
        tfNamaProyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfNamaProyek.setForeground(new java.awt.Color(255, 255, 255));
        tfNamaProyek.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfIDProyek.setBackground(new java.awt.Color(102, 102, 255));
        tfIDProyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfIDProyek.setForeground(new java.awt.Color(255, 255, 255));
        tfIDProyek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfIDProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDProyekActionPerformed(evt);
            }
        });

        tfDurasiPengerjaan.setBackground(new java.awt.Color(102, 102, 255));
        tfDurasiPengerjaan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfDurasiPengerjaan.setForeground(new java.awt.Color(255, 255, 255));
        tfDurasiPengerjaan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tblProyek.setBackground(new java.awt.Color(255, 153, 153));
        tblProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblProyek);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnC2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnU2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIDProyek, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNamaProyek, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDurasiPengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfIDProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfNamaProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfDurasiPengerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnC2)
                    .addComponent(btnU2)
                    .addComponent(btnD2))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("proyek", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("ID Karyawan");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("ID Proyek");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Peran");

        cbKaryawan.setBackground(new java.awt.Color(102, 102, 255));
        cbKaryawan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        cbKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));

        cbProyek.setBackground(new java.awt.Color(102, 102, 255));
        cbProyek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbProyek.setForeground(new java.awt.Color(255, 255, 255));
        cbProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih" }));
        cbProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProyekActionPerformed(evt);
            }
        });

        tfPeran.setBackground(new java.awt.Color(102, 102, 255));
        tfPeran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfPeran.setForeground(new java.awt.Color(255, 255, 255));

        tblTransaksi.setBackground(new java.awt.Color(255, 153, 153));
        tblTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblTransaksi);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Action");

        btnC3.setBackground(new java.awt.Color(0, 102, 255));
        btnC3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnC3.setForeground(new java.awt.Color(255, 255, 255));
        btnC3.setText("Create");
        btnC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC3ActionPerformed(evt);
            }
        });

        btnU3.setBackground(new java.awt.Color(255, 204, 0));
        btnU3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnU3.setForeground(new java.awt.Color(255, 255, 255));
        btnU3.setText("Update");
        btnU3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnU3ActionPerformed(evt);
            }
        });

        btnD3.setBackground(new java.awt.Color(255, 0, 0));
        btnD3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnD3.setForeground(new java.awt.Color(255, 255, 255));
        btnD3.setText("Delete");
        btnD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnD3ActionPerformed(evt);
            }
        });

        jLabel16.setText("jLabel16");

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProyek, 0, 223, Short.MAX_VALUE)
                    .addComponent(tfPeran)
                    .addComponent(cbKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnC3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnU3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnD3))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(btnC3)
                            .addComponent(btnU3)
                            .addComponent(btnD3)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(tfPeran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("transaksi", jPanel6);

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menu Navigation ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntU1ActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_bntU1ActionPerformed

    private void btnC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC1ActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btnC1ActionPerformed

    private void btnC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC2ActionPerformed
    try {
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaProyek.getText());
            ps.setInt(2, Integer.parseInt(tfDurasiPengerjaan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil disimpan");
            loadDataProyek();
        } catch (SQLException e) {
            System.out.println("Error Save Data Proyek: " + e.getMessage());
        }
       
    }//GEN-LAST:event_btnC2ActionPerformed

    private void tfIDProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDProyekActionPerformed

    private void btnD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnD2ActionPerformed
    try {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tfIDProyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil di hapus");
            loadDataProyek();
        } catch (SQLException e) {
            System.out.println("Error Delete Data Proyek: " + e.getMessage());
        }
    }//GEN-LAST:event_btnD2ActionPerformed

    private void btnD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnD1ActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_btnD1ActionPerformed

    private void btnU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnU2ActionPerformed
     try {
         
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfNamaProyek.getText());
            ps.setInt(2, Integer.parseInt(tfDurasiPengerjaan.getText()));
            ps.setInt(3, Integer.parseInt(tfIDProyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data proyek berhasil di Update");
            loadDataProyek();
        } catch (SQLException e) {
            System.out.println("Error Update Data Proyek: " + e.getMessage());
        }
    }//GEN-LAST:event_btnU2ActionPerformed

    private void btnC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC3ActionPerformed
    try{
         String sql = "INSERT INTO transaksi (id_proyek, id_karyawan, peran) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setInt(1, Integer.parseInt((String) cbKaryawan.getSelectedItem())); 
         ps.setInt(2, Integer.parseInt((String) cbProyek.getSelectedItem())); 
         ps.setString(3, tfPeran.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data Berhasil di Simpan");
         //
         loadDataTransaksi();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }

    }//GEN-LAST:event_btnC3ActionPerformed

    private void btnU3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnU3ActionPerformed
        try {
          String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          
          
          ps.setInt(1, Integer.parseInt(tfPeran.getText())); // peran
          ps.setInt(2, Integer.parseInt((String) cbKaryawan.getSelectedItem())); // id_karyawan
          ps.setInt(3, Integer.parseInt((String) cbProyek.getSelectedItem())); // id_proyek

          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data Berhasil di Update");
          loadDataTransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
        
    }//GEN-LAST:event_btnU3ActionPerformed

    private void btnD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnD3ActionPerformed
        // TODO add your handling code here:
        try  {
          String sql = "DELETE FROM transaksi WHERE id_karyawan = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt((String) cbKaryawan.getSelectedItem()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data Berhasil di-Delete");
          loadDataTransaksi();
     }catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
    }
    }//GEN-LAST:event_btnD3ActionPerformed

    private void cbProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProyekActionPerformed

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
            java.util.logging.Logger.getLogger(ManajemenKP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManajemenKP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManajemenKP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManajemenKP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManajemenKP().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntU1;
    private javax.swing.JButton btnC1;
    private javax.swing.JButton btnC2;
    private javax.swing.JButton btnC3;
    private javax.swing.JButton btnD1;
    private javax.swing.JButton btnD2;
    private javax.swing.JButton btnD3;
    private javax.swing.JButton btnU2;
    private javax.swing.JButton btnU3;
    private javax.swing.JComboBox<String> cbKaryawan;
    private javax.swing.JComboBox<String> cbProyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel p_karyawan;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTable tblProyek;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField tfDepartemen;
    private javax.swing.JTextField tfDurasiPengerjaan;
    private javax.swing.JTextField tfIDKaryawan;
    private javax.swing.JTextField tfIDProyek;
    private javax.swing.JTextField tfJabatan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNamaProyek;
    private javax.swing.JTextField tfPeran;
    // End of variables declaration//GEN-END:variables
}




