/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_bdl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.lang.System.Logger.*;

/**
 *
 * @author Lenovo
 */
public class karyawan extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/UAS_BDL";
    String user = "postgres";
    String password = "adelia19";
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Creates new form karyawan
     */
    public karyawan() {
        initComponents();
        tampil();
        cbIDJ();
    }
    
    public void tampil() {
        // TODO code application logi
        String search = tfSearch.getText();
        try ( Connection conn = DriverManager.getConnection(koneksi, user, password);  
        Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery("SELECT * FROM karyawan WHERE NAMA_KARYAWAN LIKE '%"+search+"%' "
                + "OR ID_KARYAWAN LIKE '%"+search+"%'")) {

            // Dapatkan model tabel yang ada
            DefaultTableModel model = (DefaultTableModel) Tabel.getModel();

            // Kosongkan data tabel terlebih dahulu
            model.setRowCount(0);

            // Tambahkan data dari ResultSet ke model tabel
            while (rs.next()) {
                Object[] rowData = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            // Tangani eksepsi
            System.err.println("Terjadi kesalahan: " + ex.getMessage());
        }
    }

    private void cbIDJ(){
       try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            String sqlPelanggan = "SELECT * FROM jabatan_karyawan";
            ResultSet rsPelanggan = stmt.executeQuery(sqlPelanggan);

            cbIDJ.removeAllItems(); // Membersihkan item sebelumnya jika ada

            while (rsPelanggan.next()) {
                cbIDJ.addItem(rsPelanggan.getString("id_jabatan"));
            }

            rsPelanggan.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memuat data jabatan: " + ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfIDK = new javax.swing.JTextField();
        tfNama = new javax.swing.JTextField();
        tfGaji = new javax.swing.JTextField();
        cbIDJ = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        tfJabatan = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("DATA KARYAWAN");

        jLabel2.setText("ID KARYAWAN");

        jLabel3.setText("ID JABATAN");

        jLabel4.setText("NAMA KARYAWAN");

        jLabel5.setText("JABATAN");

        jLabel6.setText("JUMLAH GAJI");

        cbIDJ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID KARYAWAN", "ID JABATAN", "NAMA KARYAWAN", "JABATAN", "JUMLAH GAJI KARYAWAN"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jLabel7.setText("SEARCH");

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnInsert.setText("INSERT");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfIDK)
                                    .addComponent(tfNama)
                                    .addComponent(tfGaji)
                                    .addComponent(cbIDJ, 0, 160, Short.MAX_VALUE)
                                    .addComponent(tfJabatan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(jLabel1)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbIDJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnInsert)
                            .addComponent(btnClear)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String id_karyawan, id_jabatan, nama_karyawan, jabatan, jumlah_gaji_karyawan;
        if (tfIDK.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (cbIDJ.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfJabatan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfGaji.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
                conn.setAutoCommit(false);

                String sql = "INSERT INTO karyawan VALUES(?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);

                id_karyawan = tfIDK.getText();
                id_jabatan = (String) cbIDJ.getSelectedItem();   
                nama_karyawan = tfNama.getText();
                jabatan = tfJabatan.getText();
                jumlah_gaji_karyawan = tfGaji.getText();

                pstmt.setString(1, id_karyawan);
                pstmt.setString(2, id_jabatan);
                pstmt.setString(3, nama_karyawan);
                pstmt.setString(4, jabatan);
                pstmt.setInt(5, Integer.parseInt(jumlah_gaji_karyawan));

                pstmt.executeUpdate();
                conn.commit();
                pstmt.close();
                conn.close();

                JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat pengisian");
            }
        }
        tampil(); 
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (tfIDK.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (cbIDJ.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfJabatan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else if (tfGaji.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            try {
                Class.forName(driver);
                String sql = "UPDATE karyawan SET id_jabatan = ?, nama_karyawan = ?, jabatan = ?, jumlah_gaji_karyawan = ? WHERE id_karyawan = ?";
                        
                conn = DriverManager.getConnection(koneksi, user, password);
                pstmt = conn.prepareStatement(sql);

                String id_karyawan, id_jabatan, nama_karyawan, jabatan, jumlah_gaji_karyawan;
                id_karyawan = tfIDK.getText();
                id_jabatan = (String) cbIDJ.getSelectedItem();   
                nama_karyawan = tfNama.getText();
                jabatan = tfJabatan.getText();
                jumlah_gaji_karyawan = tfGaji.getText();

                pstmt.setString(1, id_jabatan);
                pstmt.setString(2, nama_karyawan);
                pstmt.setString(3, jabatan);
                pstmt.setInt(4, Integer.parseInt(jumlah_gaji_karyawan));
                pstmt.setString(5, id_karyawan);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                    pstmt.close();
                    conn.close();
                 
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(karyawan.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        tampil();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String ID_KARYAWAN;
        try {
        Class.forName(driver);
        conn = DriverManager.getConnection(koneksi, user, password);
        conn.setAutoCommit(false);

        if (tfIDK.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID Karyawan tidak boleh kosong");
        } else {
            String sql = "DELETE FROM karyawan WHERE ID_KARYAWAN = ?";
            pstmt = conn.prepareStatement(sql);

            ID_KARYAWAN = tfIDK.getText(); // Mengambil ID Karyawan dari input

            pstmt.setString(1, ID_KARYAWAN);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan");
            }

                pstmt.close();
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada koneksi database: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada SQL query: " + ex.getMessage());
        }

        tampil(); 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        tfIDK.setText("");
        cbIDJ.setSelectedItem("");
        tfNama.setText("");
        tfJabatan.setText("");
        tfGaji.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        int row = Tabel.getSelectedRow();
        tfIDK.setText(Tabel.getValueAt(row, 0).toString());
        cbIDJ.setSelectedItem(Tabel.getValueAt(row, 1).toString());  
        tfNama.setText(Tabel.getValueAt(row, 2).toString()); 
        tfJabatan.setText(Tabel.getValueAt(row, 3).toString());
        tfGaji.setText(Tabel.getValueAt(row, 4).toString());
    }//GEN-LAST:event_TabelMouseClicked

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_tfSearchKeyReleased

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
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbIDJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfGaji;
    private javax.swing.JTextField tfIDK;
    private javax.swing.JTextField tfJabatan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
