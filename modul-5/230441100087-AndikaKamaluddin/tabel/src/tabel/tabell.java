/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tabel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USEr
 */
public class tabell extends javax.swing.JFrame {
Connection konek;
private DefaultTableModel model1;
private DefaultTableModel model2;
private DefaultTableModel model3;
    /**
     * Creates new form tabell
     */
    public tabell(){
        initComponents();
        setTitle("Employee n Project");
        konek = koneksi.getConnection();
        
        model1 = new DefaultTableModel();
        tbl_employee.setModel(model1);
        model1.addColumn("ID");
        model1.addColumn("Name");
        model1.addColumn("Position");
        model1.addColumn("Department");
        loadEmployee();
        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        model2.addColumn("ID");
        model2.addColumn("Project Name");
        model2.addColumn("Duration(Week)");
        loadProject();
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);
        model3.addColumn("Employee");
        model3.addColumn("Project");
        model3.addColumn("Role");
        loadTransaction();
        
        loadEmployeeNames();
        loadProjectNames();

    }
    
    private void loadEmployee(){
        model1.setRowCount(0);
        try{
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               model1.addRow(new Object[]{
               rs.getInt("id"),
               rs.getString("nama"),
               rs.getString("jabatan"),
               rs.getString("departemen")
            });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
    }
    
    private void loadProject() {
        model2.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               model2.addRow(new Object[]{
               rs.getInt("id"),
               rs.getString("nama_proyek"),
               rs.getInt("durasi_pengerjaan")
             });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
    }
    
    private void loadTransaction() {
        model3.setRowCount(0);
        try {
            String sql = "SELECT k.nama AS karyawan, p.nama_proyek AS proyek, t.peran " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id_karyawan = k.id " +
                         "JOIN proyek p ON t.id_proyek = p.id";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model3.addRow(new Object[]{
                    rs.getString("karyawan"),
                    rs.getString("proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading transaction data: " + e.getMessage());
        }
    }

    
    private void loadEmployeeNames() {
        cmb_karyawan.removeAllItems();
        try {
            String sql = "SELECT nama FROM karyawan";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmb_karyawan.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading employee names: " + e.getMessage());
        }
    }
    
    private void loadProjectNames() {
        cmb_project.removeAllItems();
        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmb_project.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading project names: " + e.getMessage());
        }
    }
    
    private int getIdKaryawan() throws SQLException {
        String namaKaryawan = (String) cmb_karyawan.getSelectedItem();
        String sql = "SELECT id FROM karyawan WHERE nama = ?";
        PreparedStatement ps = konek.prepareStatement(sql);
        ps.setString(1, namaKaryawan);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("ID karyawan tidak ditemukan untuk nama: " + namaKaryawan);
    }

    private int getIdProyek() throws SQLException {
        String namaProyek = (String) cmb_project.getSelectedItem();
        String sql = "SELECT id FROM proyek WHERE nama_proyek = ?";
        PreparedStatement ps = konek.prepareStatement(sql);
        ps.setString(1, namaProyek);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("ID proyek tidak ditemukan untuk nama: " + namaProyek);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        cmb_position = new javax.swing.JComboBox<>();
        cmb_department = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_idd = new javax.swing.JTextField();
        tf_duration = new javax.swing.JTextField();
        tf_project = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_role = new javax.swing.JTextField();
        cmb_project = new javax.swing.JComboBox<>();
        cmb_karyawan = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        btn_entry = new javax.swing.JButton();
        btn_up = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_hps = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.setLayout(new java.awt.GridLayout(4, 0));

        btn_add.setBackground(new java.awt.Color(255, 51, 51));
        btn_add.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel8.add(btn_add);

        btn_update.setBackground(new java.awt.Color(255, 51, 51));
        btn_update.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel8.add(btn_update);

        btn_delete.setBackground(new java.awt.Color(255, 51, 51));
        btn_delete.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel8.add(btn_delete);

        btn_clear.setBackground(new java.awt.Color(255, 51, 51));
        btn_clear.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel8.add(btn_clear);

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 130, 510));

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Employees Here");
        jPanel5.add(jLabel1);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\teamwork_1256650 (1).png")); // NOI18N
        jPanel5.add(jLabel2);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        tbl_employee.setBackground(new java.awt.Color(204, 204, 204));
        tbl_employee.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Position", "Department"
            }
        ));
        jScrollPane1.setViewportView(tbl_employee);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 347, -1, 270));

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("ID:");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel5.setText("Position:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel6.setText("Department:");

        cmb_position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Akuntan", "Pemasaran", "Pengembang", "Supervisor" }));

        cmb_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HR", "IT", "Marketing", "Finance", "Operations" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_id)
                    .addComponent(tf_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(cmb_position, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_department, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 240));

        jTabbedPane1.addTab("Karyawan", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\presentation_2400339 (1).png")); // NOI18N
        jPanel10.add(jLabel10);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Projects Here");
        jPanel10.add(jLabel9);

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        jPanel9.setBackground(new java.awt.Color(102, 204, 255));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel7.setText("Project Name:");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setText("ID:");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel11.setText("Duration(Week):");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_project, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_idd, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_duration, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_idd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_project, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 240));

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));
        jPanel11.setLayout(new java.awt.GridLayout(4, 0));

        btn_tambah.setBackground(new java.awt.Color(255, 51, 51));
        btn_tambah.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_tambah.setText("Add");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel11.add(btn_tambah);

        btn_edit.setBackground(new java.awt.Color(255, 51, 51));
        btn_edit.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_edit.setText("Update");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel11.add(btn_edit);

        btn_hapus.setBackground(new java.awt.Color(255, 51, 51));
        btn_hapus.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_hapus.setText("Delete");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel11.add(btn_hapus);

        btn_reset.setBackground(new java.awt.Color(255, 51, 51));
        btn_reset.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_reset.setText("Clear");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel11.add(btn_reset);

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 130, 510));

        tbl_proyek.setBackground(new java.awt.Color(204, 204, 204));
        tbl_proyek.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Project Name", "Duration (Week)"
            }
        ));
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 270));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Proyek", jPanel3);

        jPanel12.setBackground(new java.awt.Color(204, 204, 204));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(0, 102, 153));

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\presentation_2400339 (1).png")); // NOI18N
        jPanel13.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Data Projects");
        jPanel13.add(jLabel13);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\USEr\\Downloads\\teamwork_1256650 (1).png")); // NOI18N
        jPanel13.add(jLabel14);

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, -1));

        jPanel14.setBackground(new java.awt.Color(102, 204, 255));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel15.setText("Project:");

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel16.setText("Employee:");

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel17.setText("Role:");

        cmb_project.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_role, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(cmb_project, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_karyawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cmb_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cmb_project, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 450, 240));

        jPanel15.setBackground(new java.awt.Color(255, 51, 51));
        jPanel15.setLayout(new java.awt.GridLayout(4, 0));

        btn_entry.setBackground(new java.awt.Color(255, 51, 51));
        btn_entry.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_entry.setText("Add");
        btn_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entryActionPerformed(evt);
            }
        });
        jPanel15.add(btn_entry);

        btn_up.setBackground(new java.awt.Color(255, 51, 51));
        btn_up.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_up.setText("Update");
        btn_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upActionPerformed(evt);
            }
        });
        jPanel15.add(btn_up);

        btn_remove.setBackground(new java.awt.Color(255, 51, 51));
        btn_remove.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_remove.setText("Delete");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel15.add(btn_remove);

        btn_hps.setBackground(new java.awt.Color(255, 51, 51));
        btn_hps.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_hps.setText("Clear");
        btn_hps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hpsActionPerformed(evt);
            }
        });
        jPanel15.add(btn_hps);

        jPanel12.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 130, 510));

        tbl_transaksi.setBackground(new java.awt.Color(204, 204, 204));
        tbl_transaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee", "Project", "Role"
            }
        ));
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 270));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TransaksiProyek", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        try {
            if (tf_id.getText().trim().isEmpty() || tf_nama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong");
                return;
            }
            int id = Integer.parseInt(tf_id.getText().trim());
            String sqlCheck = "SELECT id FROM karyawan WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "ID karyawan sudah ada, gunakan ID yang berbeda");
                return;
            }
            String sqlInsert = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = konek.prepareStatement(sqlInsert);
            psInsert.setInt(1, id);
            psInsert.setString(2, tf_nama.getText().trim());
            psInsert.setString(3, cmb_position.getSelectedItem().toString());
            psInsert.setString(4, cmb_department.getSelectedItem().toString());
            psInsert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Karyawan berhasil ditambahkan");

            loadEmployee();
            loadEmployeeNames();

            tf_id.setText("");
            tf_nama.setText("");
            cmb_position.setSelectedIndex(0);
            cmb_department.setSelectedIndex(0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            if (tf_id.getText().trim().isEmpty() && tf_nama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong");
                return;
            } else if (tf_id.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            } else if (tf_nama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
                return;
            }
            String sqlCheck = "SELECT nama, jabatan, departemen FROM karyawan WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, Integer.parseInt(tf_id.getText()));
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                String currentName = rs.getString("nama");
                String currentPosition = rs.getString("jabatan");
                String currentDepartment = rs.getString("departemen");

                boolean isNameSame = currentName.equals(tf_nama.getText().trim());
                boolean isPositionSame = currentPosition.equals(cmb_position.getSelectedItem().toString());
                boolean isDepartmentSame = currentDepartment.equals(cmb_department.getSelectedItem().toString());
                
                if (isNameSame && isPositionSame && isDepartmentSame) {
                    JOptionPane.showMessageDialog(this, "Tidak ada perubahan data. Silakan ubah setidaknya satu field sebelum memperbarui.");
                    return;
                }
            }
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setString(1, tf_nama.getText());
            ps.setString(2, cmb_position.getSelectedItem().toString());
            ps.setString(3, cmb_department.getSelectedItem().toString());
            ps.setInt(4, Integer.parseInt(tf_id.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");

            tf_id.setText("");
            tf_nama.setText("");
            cmb_position.setSelectedIndex(0);
            cmb_department.setSelectedIndex(0);

            loadEmployee();
            loadEmployeeNames();
        } catch (SQLException e) {
            System.out.println("Error Update Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try {
            if (tf_id.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            }
            int id = Integer.parseInt(tf_id.getText().trim());
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Karyawan berhasil dihapus");
                loadEmployee();
                loadEmployeeNames();
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "ID karyawan tidak ditemukan");
            }
            
            tf_id.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
            if (tf_idd.getText().trim().isEmpty() || tf_project.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama Proyek tidak boleh kosong");
                return;
            }
            int projectId = Integer.parseInt(tf_idd.getText().trim());
            
            String sqlCheck = "SELECT id FROM proyek WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, projectId);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "ID proyek sudah ada, gunakan ID yang berbeda");
                return;
            }

            String sqlInsert = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement psInsert = konek.prepareStatement(sqlInsert);
            psInsert.setInt(1, projectId);
            psInsert.setString(2, tf_project.getText().trim());
            psInsert.setInt(3, Integer.parseInt(tf_duration.getText().trim()));
            psInsert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Proyek berhasil ditambahkan");

            loadProject();
            loadProjectNames();
            tf_idd.setText("");
            tf_project.setText("");
            tf_duration.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID dan durasi harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            if (tf_idd.getText().trim().isEmpty() && tf_project.getText().trim().isEmpty() && tf_duration.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID, Nama Proyek, dan Durasi tidak boleh kosong");
                return;
            } else if (tf_idd.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            } else if (tf_project.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Proyek tidak boleh kosong");
                return;
            } else if (tf_duration.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Durasi tidak boleh kosong");
                return;
            }

            String idProyek = tf_idd.getText();
            String oldNamaProyek = "";
            int oldDurasi = 0;

            String selectSql = "SELECT nama_proyek, durasi_pengerjaan FROM proyek WHERE id = ?";
            PreparedStatement selectPs = konek.prepareStatement(selectSql);
            selectPs.setInt(1, Integer.parseInt(idProyek));
            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {
                oldNamaProyek = rs.getString("nama_proyek");
                oldDurasi = rs.getInt("durasi_pengerjaan");
            } else {
                JOptionPane.showMessageDialog(this, "Proyek tidak ditemukan");
                return;
            }

            boolean isNamaBerubah = !tf_project.getText().trim().equals(oldNamaProyek);
            boolean isDurasiBerubah = !tf_duration.getText().trim().equals(String.valueOf(oldDurasi));

            if (!isNamaBerubah && !isDurasiBerubah) {
                JOptionPane.showMessageDialog(this, "Tidak ada perubahan pada Nama Proyek dan Durasi");
                return;
            }

            ps.setString(1, tf_project.getText());
            ps.setString(2, tf_duration.getText());
            ps.setInt(3, Integer.parseInt(idProyek));
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data updated successfully");
            tf_idd.setText("");
            tf_project.setText("");
            tf_duration.setText("");
            loadProject();
            loadProjectNames();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID dan Durasi harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            if (tf_idd.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong");
                return;
            }
            int projectId = Integer.parseInt(tf_idd.getText().trim());

            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, projectId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Proyek berhasil dihapus");
                loadProject();
                loadProjectNames();
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "ID proyek tidak ditemukan");
            }

            tf_idd.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        tf_idd.setText("");
        tf_project.setText("");
        tf_duration.setText("");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        tf_id.setText("");
        tf_nama.setText("");
        cmb_position.setSelectedIndex(0);
        cmb_department.setSelectedIndex(0);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entryActionPerformed
        try {
            if (tf_role.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
                return;
            }

            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sqlCheck = "SELECT * FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, idKaryawan);
            psCheck.setInt(2, idProyek);
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {
                JOptionPane.showMessageDialog(this, "Kombinasi karyawan dan proyek sudah ada. Tidak dapat menambahkan data duplikat.");
                return;
            }

            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, tf_role.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            cmb_karyawan.setSelectedIndex(0);
            cmb_project.setSelectedIndex(0);
            tf_role.setText("");
            loadTransaction();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_entryActionPerformed

    private void btn_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upActionPerformed
        try {
            if (tf_role.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
                return;
            }
            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sqlCheck = "SELECT * FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, idKaryawan);
            psCheck.setInt(2, idProyek);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                String role = rs.getString("peran");
                if (role.equals(tf_role.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Tidak ada perubahan data. Silakan ubah peran sebelum memperbarui.");
                    return;
                }

                String sqlUpdate = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement psUpdate = konek.prepareStatement(sqlUpdate);
                psUpdate.setString(1, tf_role.getText());
                psUpdate.setInt(2, idKaryawan);
                psUpdate.setInt(3, idProyek);
                psUpdate.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diperbarui");
                cmb_karyawan.setSelectedIndex(0);
                cmb_project.setSelectedIndex(0);
                tf_role.setText("");
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan. Pastikan memilih karyawan dan proyek yang valid.");
            }
        } catch (SQLException e) {
            System.out.println("Error Update Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_upActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        try {
            if (tf_role.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong untuk menghapus data");
                return;
            }

            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau gagal dihapus");
            }

            cmb_karyawan.setSelectedIndex(0);
            cmb_project.setSelectedIndex(0);
            tf_role.setText("");
            loadTransaction();
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_hpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hpsActionPerformed
        cmb_karyawan.setSelectedIndex(0);
        cmb_project.setSelectedIndex(0);
        tf_role.setText("");
    }//GEN-LAST:event_btn_hpsActionPerformed

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
            java.util.logging.Logger.getLogger(tabell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_entry;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hps;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_up;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cmb_department;
    private javax.swing.JComboBox<String> cmb_karyawan;
    private javax.swing.JComboBox<String> cmb_position;
    private javax.swing.JComboBox<String> cmb_project;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_duration;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_idd;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_project;
    private javax.swing.JTextField tf_role;
    // End of variables declaration//GEN-END:variables
}
