
package tugasprktkm5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
public class Main extends javax.swing.JFrame {
    Connection conn;
    int hitung;
    private DefaultTableModel model;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTP;
    
    public Main() {
        initComponents();
        
        conn = Koneksi.getConnection();
        model = new DefaultTableModel();
        modelProyek = new DefaultTableModel();
        modelTP = new DefaultTableModel();
        
        tbl_karyawan.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPARTEMEN");

        tbl_proyek.setModel(modelProyek);
        modelProyek.addColumn("ID");
        modelProyek.addColumn("NAMA PROYEK");
        modelProyek.addColumn("DURASI PENGERJAAN");
        
        tbl_TP.setModel(modelTP);
        modelTP.addColumn("ID KARYAWAN");
        modelTP.addColumn("ID PROYEK");
        modelTP.addColumn("PERAN");
        
        loadKaryawanData();
        loadProyekData();
        loadTPData();
        
        IdProjek();
        IdKaryawan();
    }

    private void loadKaryawanData(){
    model.setRowCount(0);
    try {
      String sql = "SELECT * FROM karyawan";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         // Menambahkan baris ke dalam model tabel
         model.addRow(new Object[]{
         rs.getInt("id"),
         rs.getString("nama"),
         rs.getString("jabatan"),
         rs.getString("departemen"),
       });
      }
  } catch (SQLException e) {
     System.out.println("Error load Data" + e.getMessage());
   }      
    }
    
    private void loadProyekData(){
    modelProyek.setRowCount(0);
    try {
      String sql = "SELECT * FROM proyek";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         // Menambahkan baris ke dalam model tabel
         modelProyek.addRow(new Object[]{
         rs.getInt("id"),
         rs.getString("nama_proyek"),
         rs.getString("durasi_pengerjaan"),
       });
      }
  } catch (SQLException e) {
     System.out.println("Error load Data" + e.getMessage());
   }      
    }
    
    private void loadTPData(){
    modelTP.setRowCount(0);
    try {
      String sql = "SELECT * FROM transaksi";
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
         // Menambahkan baris ke dalam model tabel
         modelTP.addRow(new Object[]{
         rs.getInt("id_karyawan"),
         rs.getInt("id_proyek"),
         rs.getString("peran"),
       });
      }
  } catch (SQLException e) {
     System.out.println("Error load Data" + e.getMessage());
   }      
    }
    
    private void IdKaryawan(){
      try {
            String sql = "SELECT id FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            cb_IDK.removeAllItems(); 
            while (rs.next()) {
                cb_IDK.addItem(rs.getString("id"));
               hitung++;
            }
        } catch (SQLException e) {
            System.out.println("Error loading Worker IDs: " + e.getMessage());
        }
    }
    private void IdProjek(){
      try {
            String sql = "SELECT id FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            cb_IDP.removeAllItems(); 
            while (rs.next()) {
                cb_IDP.addItem(rs.getString("id"));
                hitung++;
            }
        } catch (SQLException e) {
            System.out.println("Error loading Worker IDs: " + e.getMessage());
        }
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        cb_jabatan = new javax.swing.JComboBox<>();
        cb_dpt = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        btn_tambahK = new javax.swing.JButton();
        btn_editk = new javax.swing.JButton();
        btn_hapusK = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btn_clearK = new javax.swing.JButton();
        btn_exitK = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        txt_durasi = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btn_tambahP = new javax.swing.JButton();
        btn_editP = new javax.swing.JButton();
        btn_hapusP = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        btn_clearP = new javax.swing.JButton();
        btn_exitP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cb_IDK = new javax.swing.JComboBox<>();
        cb_IDP = new javax.swing.JComboBox<>();
        tf_peran = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btn_tambahTP = new javax.swing.JButton();
        btn_editTP = new javax.swing.JButton();
        btn_hapusTP = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        btn_clearTP = new javax.swing.JButton();
        btn_exitTP = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_TP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(51, 0, 0));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Algerian", 3, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\teamwork_4025527 (1).png")); // NOI18N
        jPanel4.add(jLabel14);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA KARYAWAN");
        jPanel4.add(jLabel1);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\organization_2637425 (1).png")); // NOI18N
        jPanel4.add(jLabel11);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 90));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel2.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel3.setText("NAMA :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel4.setText("JABATAN :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel5.setText("DEPARTEMEN :");

        tf_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tf_nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        cb_jabatan.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        cb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "Manajer Produksi", "Operator Mesin", "Kepala IT", "Staf Dukungan Teknis", "Akuntan", "Spesialis Pajak" }));
        cb_jabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_jabatanActionPerformed(evt);
            }
        });

        cb_dpt.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        cb_dpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--", "PRODUKSI", "IT (TEKNOLOGI INFORMASI)", "KEUANGAN" }));
        cb_dpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_dptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(148, 148, 148))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_nama)
                            .addComponent(tf_id)
                            .addComponent(cb_dpt, 0, 240, Short.MAX_VALUE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(160, 160, 160))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_dpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 360, 250));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setLayout(new java.awt.GridLayout(3, 1));

        btn_tambahK.setBackground(new java.awt.Color(255, 204, 204));
        btn_tambahK.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_tambahK.setText("TAMBAH");
        btn_tambahK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahKActionPerformed(evt);
            }
        });
        jPanel10.add(btn_tambahK);

        btn_editk.setBackground(new java.awt.Color(255, 204, 204));
        btn_editk.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_editk.setText("EDIT");
        btn_editk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editkActionPerformed(evt);
            }
        });
        jPanel10.add(btn_editk);

        btn_hapusK.setBackground(new java.awt.Color(255, 204, 204));
        btn_hapusK.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_hapusK.setText("HAPUS");
        btn_hapusK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusKActionPerformed(evt);
            }
        });
        jPanel10.add(btn_hapusK);

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, 250));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setLayout(new java.awt.GridLayout(2, 1));

        btn_clearK.setBackground(new java.awt.Color(255, 204, 204));
        btn_clearK.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_clearK.setText("CLEAR");
        btn_clearK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearKActionPerformed(evt);
            }
        });
        jPanel11.add(btn_clearK);

        btn_exitK.setBackground(new java.awt.Color(255, 204, 204));
        btn_exitK.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_exitK.setText("EXIT");
        btn_exitK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitKActionPerformed(evt);
            }
        });
        jPanel11.add(btn_exitK);

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 110, 250));

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbl_karyawan);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 590, -1));

        jTabbedPane1.addTab("KARYAWAN", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\report_5329200 (1).png")); // NOI18N
        jPanel6.add(jLabel12);

        jLabel6.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DATA PROYEK");
        jPanel6.add(jLabel6);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\report_5231456 (1).png")); // NOI18N
        jPanel6.add(jLabel13);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 90));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel7.setText(" ID :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel8.setText("NAMA PROYEK :");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel9.setText("DURASI PENGERJAAN :");

        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_durasi.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 86, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 370, 200));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setLayout(new java.awt.GridLayout(3, 1));

        btn_tambahP.setBackground(new java.awt.Color(255, 204, 204));
        btn_tambahP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_tambahP.setText("TAMBAH");
        btn_tambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahPActionPerformed(evt);
            }
        });
        jPanel14.add(btn_tambahP);

        btn_editP.setBackground(new java.awt.Color(255, 204, 204));
        btn_editP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_editP.setText("EDIT");
        btn_editP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editPActionPerformed(evt);
            }
        });
        jPanel14.add(btn_editP);

        btn_hapusP.setBackground(new java.awt.Color(255, 204, 204));
        btn_hapusP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_hapusP.setText("HAPUS");
        btn_hapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusPActionPerformed(evt);
            }
        });
        jPanel14.add(btn_hapusP);

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 120, 200));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.setLayout(new java.awt.GridLayout(2, 1));

        btn_clearP.setBackground(new java.awt.Color(255, 204, 204));
        btn_clearP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_clearP.setText("CLEAR");
        btn_clearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearPActionPerformed(evt);
            }
        });
        jPanel15.add(btn_clearP);

        btn_exitP.setBackground(new java.awt.Color(255, 204, 204));
        btn_exitP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_exitP.setText("EXIT");
        btn_exitP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitPActionPerformed(evt);
            }
        });
        jPanel15.add(btn_exitP);

        jPanel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 100, 200));

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_proyek);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 590, -1));

        jTabbedPane1.addTab("PROYEK", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel19.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\house_10604790 (1).png")); // NOI18N
        jPanel8.add(jLabel19);

        jLabel10.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TRANSAKSI PROYEK");
        jPanel8.add(jLabel10);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\amand\\Downloads\\deal_11099163 (1).png")); // NOI18N
        jPanel8.add(jLabel15);

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 100));

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("ID KARYAWAN :");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ID PROYEK :");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("PERAN :");

        cb_IDK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--" }));

        cb_IDP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH--" }));

        tf_peran.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_IDP, 0, 213, Short.MAX_VALUE)
                            .addComponent(cb_IDK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel17))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel18)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_IDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_IDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 200));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new java.awt.GridLayout(3, 1));

        btn_tambahTP.setBackground(new java.awt.Color(255, 204, 204));
        btn_tambahTP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_tambahTP.setText("TAMBAH");
        btn_tambahTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahTPActionPerformed(evt);
            }
        });
        jPanel12.add(btn_tambahTP);

        btn_editTP.setBackground(new java.awt.Color(255, 204, 204));
        btn_editTP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_editTP.setText("EDIT");
        btn_editTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editTPActionPerformed(evt);
            }
        });
        jPanel12.add(btn_editTP);

        btn_hapusTP.setBackground(new java.awt.Color(255, 204, 204));
        btn_hapusTP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_hapusTP.setText("HAPUS");
        btn_hapusTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusTPActionPerformed(evt);
            }
        });
        jPanel12.add(btn_hapusTP);

        jPanel3.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 140, 200));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(new java.awt.GridLayout(2, 1));

        btn_clearTP.setBackground(new java.awt.Color(255, 204, 204));
        btn_clearTP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_clearTP.setText("CLEAR");
        btn_clearTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearTPActionPerformed(evt);
            }
        });
        jPanel13.add(btn_clearTP);

        btn_exitTP.setBackground(new java.awt.Color(255, 204, 204));
        btn_exitTP.setFont(new java.awt.Font("Serif", 3, 14)); // NOI18N
        btn_exitTP.setText("EXIT");
        btn_exitTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitTPActionPerformed(evt);
            }
        });
        jPanel13.add(btn_exitTP);

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 140, 200));

        tbl_TP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_TP);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 590, 290));

        jTabbedPane1.addTab("TRANSAKSI PROYEK", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahKActionPerformed
    String jabatan =  String.valueOf(Main.cb_jabatan.getSelectedItem());        
    String departemen =  String.valueOf(Main.cb_dpt.getSelectedItem());
   
        if(jabatan.equals("--PILIH--") || departemen.equals("--PILIH--")){
      JOptionPane.showMessageDialog(null, "TOLONG PILIH JABATAN TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
    }
        if(tf_nama.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
         }else if(jabatan.equals("--PILIH--") || departemen.equals("--PILIH--") ){
            JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
        try{
            String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tf_id.getText()));
                ps.setString(2, tf_nama.getText());
                ps.setString(3, cb_jabatan.getSelectedItem().toString());
                ps.setString(4, cb_dpt.getSelectedItem().toString());
                ps.executeUpdate();
             JOptionPane.showMessageDialog(this, "Data yang di Tambahkan Sukses ");
            loadKaryawanData();
            IdKaryawan();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }  
        }
    }//GEN-LAST:event_btn_tambahKActionPerformed

    private void btn_editkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editkActionPerformed
       String jabatan =  String.valueOf(Main.cb_jabatan.getSelectedItem());        
       String departemen =  String.valueOf(Main.cb_dpt.getSelectedItem());
        
        if(tf_nama.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
         }else if(jabatan.equals("--PILIH--") || departemen.equals("--PILIH--") ){
            JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_nama.getText());
            ps.setString(2, cb_jabatan.getSelectedItem().toString());
            ps.setString(3, cb_dpt.getSelectedItem().toString());
            ps.setInt(4, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data yang di Update Sukses");   
            loadKaryawanData();
        }  catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    }//GEN-LAST:event_btn_editkActionPerformed

    private void btn_hapusKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusKActionPerformed
        try  {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data yang di Hapus Sukses");
            loadKaryawanData();
            IdKaryawan();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusKActionPerformed

    private void btn_exitKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitKActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitKActionPerformed

    private void btn_clearKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearKActionPerformed
        tf_id.setText("");
        tf_nama.setText("");
        cb_jabatan.setSelectedIndex(0);
        cb_dpt.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearKActionPerformed

    private void btn_tambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahPActionPerformed
        if(txt_id.getText().isEmpty() || txt_nama.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
        try{
            String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txt_id.getText()));
                ps.setString(2, txt_nama.getText());
                ps.setString(3, txt_durasi.getText());
                ps.executeUpdate();
             JOptionPane.showMessageDialog(this, "Data yang di Simpan Sukses");
            loadProyekData();
            IdProjek();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }  
        }
    }//GEN-LAST:event_btn_tambahPActionPerformed

    private void btn_editPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editPActionPerformed
        if(txt_id.getText().isEmpty() || txt_nama.getText().isEmpty() || txt_durasi.getText().isEmpty()){
           JOptionPane.showMessageDialog(this,"TOLONG ISI TERLEBIH DAHULU","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txt_nama.getText());
            ps.setString(2, txt_durasi.getText());
            ps.setInt(3, Integer.parseInt(txt_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data yang di Update Sukses");   
            loadProyekData();
        }  catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
        }
    }//GEN-LAST:event_btn_editPActionPerformed

    private void btn_hapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusPActionPerformed
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txt_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data yang di Hapus Sukses");
            loadProyekData();
            IdProjek();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
        
    }//GEN-LAST:event_btn_hapusPActionPerformed

    private void btn_clearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearPActionPerformed
        txt_id.setText("");
        txt_nama.setText("");
        txt_durasi.setText("");
    }//GEN-LAST:event_btn_clearPActionPerformed

    private void btn_exitPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitPActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitPActionPerformed

    private void btn_exitTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitTPActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitTPActionPerformed

    private void btn_clearTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearTPActionPerformed
        tf_peran.setText("");
    }//GEN-LAST:event_btn_clearTPActionPerformed

    private void cb_jabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_jabatanActionPerformed
        String jabatan =  String.valueOf(Main.cb_jabatan.getSelectedItem());
        String departemen =  String.valueOf(Main.cb_dpt.getSelectedItem());

    if(jabatan.equals("Manajer Produksi") || jabatan.equals("Operator Mesin")){
        if(departemen.equals("IT (TEKNOLOGI INFORMASI")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN PRODUKSI!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }else if(departemen.equals("KEUANGAN")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN PRODUKSI!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }    
    }else if(jabatan.equals("Kepala IT") || jabatan.equals("Staf Dukungan Teknis")){
        if(departemen.equals("PRODUKSI")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN IT!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }else if(departemen.equals("KEUANGAN")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN IT!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }
    }else if(jabatan.equals("Akuntan") || jabatan.equals("Spesialis Pajak")){
        if(departemen.equals("PRODUKSI")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN KEUANGAN!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }else if(departemen.equals("IT (TEKNOLOGI INFORMASI)")){
            JOptionPane.showMessageDialog(this,"INI BUKAN DEPARTEMEN KEUANGAN!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_jabatan.setSelectedIndex(0);
        }
    }
    }//GEN-LAST:event_cb_jabatanActionPerformed

    private void cb_dptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_dptActionPerformed
    String jabatan =  String.valueOf(Main.cb_jabatan.getSelectedItem());        
    String departemen =  String.valueOf(Main.cb_dpt.getSelectedItem());
    
    if(departemen.equals("PRODUKSI")){
        if(jabatan.equals("Kepala IT")|| jabatan.equals("Staf Dukungan Teknis") || jabatan.equals("Akuntan") || jabatan.equals("Spesialis Pajak")){
            JOptionPane.showMessageDialog(this,"ini bukan jabatan anda, jabatan yang ada yaitu Manajer Produksi dan Operator Mesin!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_dpt.setSelectedIndex(0);
        }
    }else if(departemen.equals("IT (TEKNOLOGI INFORMASI)")){
        if(jabatan.equals("Manajer Produksi")|| jabatan.equals("Operator Mesin") || jabatan.equals("Akuntan") || jabatan.equals("Spesialis Pajak")){
            JOptionPane.showMessageDialog(this,"ini bukan jabatan anda, jabatan yang ada yaitu Kepala IT dan Staf Dukungan Teknis!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_dpt.setSelectedIndex(0);
        }
    }else if(departemen.equals("KEUANGAN")){
        if(jabatan.equals("Manajer Produksi")|| jabatan.equals("Operator Mesin") || jabatan.equals("Kepala IT") || jabatan.equals("Staf Dukungan Teknis")){
            JOptionPane.showMessageDialog(this,"ini bukan jabatan anda, jabatan yang ada yaitu Kepala IT dan Staf Dukungan Teknis!!!","DISCLAIMER", JOptionPane.WARNING_MESSAGE);
           cb_dpt.setSelectedIndex(0);
        }
    }
    }//GEN-LAST:event_cb_dptActionPerformed

    private void btn_tambahTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahTPActionPerformed
    if(tf_peran.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"TOLONG ISI DATA YANG KOSONG","DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, cb_IDK.getSelectedItem().toString());
                ps.setString(2, cb_IDP.getSelectedItem().toString());
                ps.setString(3, tf_peran.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data yang di Simpan Sukses");
                loadTPData();
            } catch (SQLException e) {
                System.out.println("Error Save Data" + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_tambahTPActionPerformed

    private void btn_editTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editTPActionPerformed
     if (tbl_TP.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "TIDAK ADA DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
    }else{
         try {
            String sql = "SELECT peran FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cb_IDK.getSelectedItem().toString());
            ps.setString(2, cb_IDP.getSelectedItem().toString());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "TIDAK ADA DATA", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String role = tf_peran.getText().isEmpty() ? rs.getString("peran") : tf_peran.getText();
            String upsql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement upps = conn.prepareStatement(upsql);
            upps.setString(1, role);
            upps.setString(2, cb_IDK.getSelectedItem().toString());
            upps.setString(3, cb_IDP.getSelectedItem().toString());
            upps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data yang di Edit Sukses");
            loadTPData();
    } catch (SQLException e) {
        System.out.println("Error updating data: " + e.getMessage());
    }
     }
    }//GEN-LAST:event_btn_editTPActionPerformed

    private void btn_hapusTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusTPActionPerformed
   try  {
            String sql = "DELETE FROM transaksi WHERE id_proyek = ? AND id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(cb_IDP.getSelectedItem().toString()));
            ps.setInt(2, Integer.parseInt(cb_IDK.getSelectedItem().toString()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data yang di Hapus Sukses");
            loadTPData();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusTPActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clearK;
    private javax.swing.JButton btn_clearP;
    private javax.swing.JButton btn_clearTP;
    private javax.swing.JButton btn_editP;
    private javax.swing.JButton btn_editTP;
    private javax.swing.JButton btn_editk;
    private javax.swing.JButton btn_exitK;
    private javax.swing.JButton btn_exitP;
    private javax.swing.JButton btn_exitTP;
    private javax.swing.JButton btn_hapusK;
    private javax.swing.JButton btn_hapusP;
    private javax.swing.JButton btn_hapusTP;
    private javax.swing.JButton btn_tambahK;
    private javax.swing.JButton btn_tambahP;
    private javax.swing.JButton btn_tambahTP;
    private javax.swing.JComboBox<String> cb_IDK;
    private javax.swing.JComboBox<String> cb_IDP;
    private static javax.swing.JComboBox<String> cb_dpt;
    private static javax.swing.JComboBox<String> cb_jabatan;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_TP;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_peran;
    private javax.swing.JTextField txt_durasi;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nama;
    // End of variables declaration//GEN-END:variables
}
