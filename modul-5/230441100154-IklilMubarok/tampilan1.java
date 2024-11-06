
package modul5p;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class tampilan1 extends javax.swing.JFrame {
   
    Connection conn;
    private  DefaultTableModel modelw;
    private  DefaultTableModel modelp;
    private  DefaultTableModel modelt;
    HashMap<String, Integer> karyawanMap = new HashMap<>(); 
    HashMap<String, Integer> proyekMap = new HashMap<>();
   
    
    public tampilan1() {
        
        initComponents();
        conn = koneksi.getConnection();
        
        modelw = new DefaultTableModel();
        modelp = new DefaultTableModel();
        modelt = new DefaultTableModel();
        
        tabel_karyawan.setModel(modelw);
        tabel_karyawan.setEnabled(false);
        modelw.addColumn("ID");
        modelw.addColumn("nama");
        modelw.addColumn("jabatan");
        modelw.addColumn("departemen");
        
        tabel_proyek.setModel(modelp);
        tabel_proyek.setEnabled(false);
        modelp.addColumn("ID");
        modelp.addColumn("nama_proyek");
        modelp.addColumn("durasi_pengerjaan");
        
        tabel_transaksi.setModel(modelt);
        tabel_proyek.setEnabled(false);
        modelt.addColumn("ID_transaksi");
        modelt.addColumn("ID_karyawan");
        modelt.addColumn("ID_proyek");
        modelt.addColumn("Peran");
        
        loadDataK();
        loadDataP();
        loadDataT(); 
        loadComboBoxKaryawan();
        loadComboBoxProyek();
 
    }
    
    private void loadDataK() {
        modelw.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelw.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    private void loadDataP() {
        modelp.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelp.addRow(new Object[]{
                    rs.getInt("ID"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void loadDatatransaksi() {
         String proyek= "SELECT  id,nama_proyek FROM proyek"; 
         String karyawan = "SELECT id,nama FROM karyawan"; 

    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("nama_proyek"); 
            id_proyek.addItem(namaProyek);
            int idProyek = rsProyek.getInt("id");
            proyekMap.put(namaProyek, idProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
        }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("nama"); // Ganti nama kolom sesuai tabel
            id_karyawan.addItem(namaKaryawan);
            int idKaryawan = rsKaryawan.getInt("id");
            karyawanMap.put(namaKaryawan, idKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }   

    }
    
    private void loadDataT() {
        modelt.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelt.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("id_proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        tf_jabatan = new javax.swing.JTextField();
        tf_departemen = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        update1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        tambah1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_karyawan = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        kembali1 = new javax.swing.JButton();
        reset1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Tf_id = new javax.swing.JTextField();
        Tf_nama = new javax.swing.JTextField();
        Tf_durasi = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        update2 = new javax.swing.JButton();
        tambah2 = new javax.swing.JButton();
        hapus2 = new javax.swing.JButton();
        reset2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_proyek = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        kembali2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        peran = new javax.swing.JTextField();
        update3 = new javax.swing.JButton();
        tambah3 = new javax.swing.JButton();
        hapus3 = new javax.swing.JButton();
        reset3 = new javax.swing.JButton();
        id_karyawan = new javax.swing.JComboBox<>();
        id_proyek = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        id_transaksi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        kembali3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jButton4.setText("jButton4");

        jButton14.setText("jButton14");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(84, 195, 146));

        jTabbedPane1.setBackground(new java.awt.Color(198, 231, 255));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setOpaque(true);

        jPanel6.setBackground(new java.awt.Color(122, 178, 211));

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jPanel9.setBackground(new java.awt.Color(198, 231, 255));

        jPanel10.setBackground(new java.awt.Color(198, 231, 255));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setText("Nama");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setText("Jabatan");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setText("Departemen");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(198, 231, 255));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        update1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        update1.setText("Update");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        jPanel17.add(update1, gridBagConstraints);

        hapus1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        hapus1.setText("Delete");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        jPanel17.add(hapus1, gridBagConstraints);

        tambah1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tambah1.setText("Create");
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(tambah1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(tambah1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9);

        tabel_karyawan.setBackground(new java.awt.Color(198, 231, 255));
        tabel_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        jScrollPane3.setViewportView(tabel_karyawan);

        kembali1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        kembali1.setText("Kembali");
        kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali1ActionPerformed(evt);
            }
        });

        reset1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(kembali1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reset1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reset1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembali1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FROM KARYAWAN", jPanel2);

        jPanel11.setBackground(new java.awt.Color(122, 178, 211));

        jPanel12.setBackground(new java.awt.Color(198, 231, 255));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel13.setBackground(new java.awt.Color(198, 231, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setText("Durasi");
        jPanel13.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 106, 80, 29));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel11.setText("Nama_Proyek");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 63, -1, 27));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel10.setText("ID");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 26, 89, 27));
        jPanel13.add(Tf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 26, 173, -1));
        jPanel13.add(Tf_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 62, 173, -1));
        jPanel13.add(Tf_durasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 106, 173, -1));

        jPanel18.setBackground(new java.awt.Color(198, 231, 255));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        update2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        update2.setText("Update");
        update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel18.add(update2, gridBagConstraints);

        tambah2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tambah2.setText("Create");
        tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        jPanel18.add(tambah2, gridBagConstraints);

        hapus2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        hapus2.setText("Delete");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        jPanel18.add(hapus2, gridBagConstraints);

        reset2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 7);
        jPanel18.add(reset2, gridBagConstraints);

        jPanel13.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 151, 456, 27));

        jPanel12.add(jPanel13);

        tabel_proyek.setBackground(new java.awt.Color(198, 231, 255));
        tabel_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama_proyek", "Durasi_Proyek"
            }
        ));
        jScrollPane1.setViewportView(tabel_proyek);

        kembali2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        kembali2.setText("Kembali");
        kembali2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(kembali2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kembali2)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(60, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FORM PROYEK", jPanel4);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(122, 178, 211));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(198, 231, 255));
        jPanel15.setLayout(new java.awt.GridLayout(1, 2));

        jPanel16.setBackground(new java.awt.Color(198, 231, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel15.setText("Karyawan");
        jPanel16.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 88, 40));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel16.setText("Proyek");
        jPanel16.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 88, 33));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel17.setText("Peran");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 94, 30));
        jPanel16.add(peran, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 190, -1));

        update3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        update3.setText("Update");
        update3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update3ActionPerformed(evt);
            }
        });
        jPanel16.add(update3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 20));

        tambah3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tambah3.setText("Create");
        tambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah3ActionPerformed(evt);
            }
        });
        jPanel16.add(tambah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        hapus3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        hapus3.setText("Delete");
        hapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus3ActionPerformed(evt);
            }
        });
        jPanel16.add(hapus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, -1, -1));

        reset3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        reset3.setText("Reset");
        reset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset3ActionPerformed(evt);
            }
        });
        jPanel16.add(reset3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        id_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel16.add(id_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 190, -1));

        id_proyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel16.add(id_proyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("id_transaksi");
        jPanel16.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        id_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_transaksiActionPerformed(evt);
            }
        });
        jPanel16.add(id_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 180, -1));

        jPanel15.add(jPanel16);

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 480, 190));

        tabel_transaksi.setBackground(new java.awt.Color(198, 231, 255));
        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID_karyawan", "ID_proyek", "Peran"
            }
        ));
        jScrollPane2.setViewportView(tabel_transaksi);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 320, 200));
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 170, 130));

        kembali3.setText("Kembali");
        kembali3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali3ActionPerformed(evt);
            }
        });
        jPanel14.add(kembali3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 110, -1));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 480));

        jTabbedPane1.addTab("TRANSAKSI PROYEK", jPanel3);

        jPanel7.setBackground(new java.awt.Color(122, 178, 211));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah2ActionPerformed
    if (Tf_nama.getText().isEmpty() || 
        Tf_durasi.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
        try {
        // Cek apakah Tf_durasi berisi angka
        int durasi = Integer.parseInt(Tf_durasi.getText()); // Mengonversi input durasi menjadi integer
        
        
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setInt(1, id);
        ps.setString(1, Tf_nama.getText());
        ps.setInt(2, durasi); // Menggunakan setInt untuk kolom durasi_pengerjaan
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
        loadDataP();
        loadComboBoxProyek();
        } 
        catch (NumberFormatException e) {
        // Menampilkan pesan jika durasi tidak valid
        JOptionPane.showMessageDialog(this, "Durasi pengerjaan harus berupa angka.", "Input Error", JOptionPane.ERROR_MESSAGE);

        } 
        catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }//GEN-LAST:event_tambah2ActionPerformed

    private void reset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset3ActionPerformed
    peran.setText("");
    id_karyawan.setSelectedIndex(0);
    id_proyek.setSelectedIndex(0);
    }//GEN-LAST:event_reset3ActionPerformed

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
     if (tf_nama.getText().isEmpty() || 
        tf_jabatan.getText().isEmpty() || 
        tf_departemen.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }else
        try{
         
         
         String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";  //BINDABLE STATMEN
         PreparedStatement ps = conn.prepareStatement(sql);
//         ps.setInt(1, id);
         ps.setString(1, tf_nama.getText());
         ps.setString(2, tf_jabatan.getText());
          ps.setString(3, tf_departemen.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
         loadDataK();
         loadComboBoxKaryawan();
       } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }    
    }//GEN-LAST:event_tambah1ActionPerformed

    private void kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali1ActionPerformed
       int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_kembali1ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        if (tf_id.getText().isEmpty() || 
        tf_nama.getText().isEmpty() || 
        tf_jabatan.getText().isEmpty() || 
        tf_departemen.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }else
        try  {
            
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadDataK();
//            IdProj();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_hapus1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        if (tf_id.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi id dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
        }
        if (tabel_karyawan.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
            }else
        try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, tf_nama.getText());
          ps.setString(2, tf_jabatan.getText());
          ps.setString(3, tf_departemen.getText());
          ps.setInt(4,Integer.parseInt(tf_id.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
          loadDataK();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_update1ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
    tf_nama.setText("");
    tf_jabatan.setText("");
    tf_departemen.setText("");
    tf_id.setText("");
    }//GEN-LAST:event_reset1ActionPerformed

    private void tambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah3ActionPerformed
    if (peran.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi peran!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
        try {
        if (id_karyawan.getSelectedItem() == null || id_proyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(id_proyek.getSelectedItem().toString());
        
        if (idKaryawan == -1 || idProyek == -1) {
            JOptionPane.showMessageDialog(this, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        
        if (peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
            return;
        }
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.setString(3, peran.getText().trim());
        
        int result = ps.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
            loadDataT();
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
    }
    
    
             
    }//GEN-LAST:event_tambah3ActionPerformed

    private void update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update2ActionPerformed
        if (Tf_id.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi id dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
        }
        if (tabel_proyek.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
            }else{
                try {  
                    String sql = "SELECT nama_proyek, durasi_pengerjaan FROM proyek WHERE id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(Tf_id.getText()));
                    ResultSet rs = ps.executeQuery();

                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    String proname = Tf_nama.getText().isEmpty() ? rs.getString("nama_proyek") : Tf_nama.getText();
                    String duration = Tf_durasi.getText().isEmpty() ? rs.getString("durasi_pengerjaan") : Tf_durasi.getText();
                    String upsql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
                    PreparedStatement upps = conn.prepareStatement(upsql);
                    upps.setString(1, proname);
                    upps.setString(2, duration);
                    upps.setInt(3, Integer.parseInt(Tf_id.getText()));
                    upps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "P SUKSES");
                    loadDataP();
            } catch (SQLException e) {
                System.out.println("Error updating data: " + e.getMessage());
            }
                }

    }//GEN-LAST:event_update2ActionPerformed

    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
      if (Tf_id.getText().isEmpty() || 
        Tf_nama.getText().isEmpty() || 
        Tf_durasi.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }else
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(Tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadDataP();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_hapus2ActionPerformed

    private void kembali2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali2ActionPerformed
      int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_kembali2ActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
    Tf_nama.setText("");
    Tf_durasi.setText("");
    Tf_id.setText("");
    }//GEN-LAST:event_reset2ActionPerformed
    
    private void loadComboBoxKaryawan() {
        id_karyawan.removeAllItems();
        try {
            String sql = "SELECT id, nama, jabatan, departemen FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tampilan = String.format("ID: %d - %s (%s, %s)", 
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                );
                id_karyawan.addItem(tampilan);
            }
        } catch (SQLException e) {
            System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
        }
    }
    
    private void loadComboBoxProyek() {
    id_proyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            id_proyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
   private int getSelectedId(String textComboBox) {
    if (textComboBox == null) return -1;
    try {
        String idPart = textComboBox.substring(textComboBox.indexOf("ID: ") + 4);
        return Integer.parseInt(idPart.substring(0, idPart.indexOf(" -")));
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}
    private void update3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update3ActionPerformed
        if (tabel_transaksi.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "THERE IS NO DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
            }else
        try {
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(id_proyek.getSelectedItem().toString());
        
        ps.setString(1, peran.getText());
        ps.setInt(2, idKaryawan);
        ps.setInt(3, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataT();
        } catch (SQLException e) {
            System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
        }

    }//GEN-LAST:event_update3ActionPerformed

    private void hapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus3ActionPerformed
        if (peran.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, 
            "Harap isi dulu!", 
            "Peringatan", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }else
        try {
        String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(id_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(id_proyek.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
        loadDataT();
        } catch (SQLException e) {
            System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
        }
    }//GEN-LAST:event_hapus3ActionPerformed

    private void kembali3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali3ActionPerformed
        int keluar = JOptionPane.showConfirmDialog(null,"beneran mau keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_kembali3ActionPerformed

    private void id_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_transaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_transaksiActionPerformed

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
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Tf_durasi;
    private javax.swing.JTextField Tf_id;
    private javax.swing.JTextField Tf_nama;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton hapus2;
    private javax.swing.JButton hapus3;
    private javax.swing.JComboBox<String> id_karyawan;
    private javax.swing.JComboBox<String> id_proyek;
    private javax.swing.JTextField id_transaksi;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton kembali1;
    private javax.swing.JButton kembali2;
    private javax.swing.JButton kembali3;
    private javax.swing.JTextField peran;
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JButton reset3;
    private javax.swing.JTable tabel_karyawan;
    private javax.swing.JTable tabel_proyek;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton tambah2;
    private javax.swing.JButton tambah3;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JButton update1;
    private javax.swing.JButton update2;
    private javax.swing.JButton update3;
    // End of variables declaration//GEN-END:variables
}
