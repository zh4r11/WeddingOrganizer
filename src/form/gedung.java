/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import static form.pelanggan.tabmode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Azhari
 */
public class gedung extends javax.swing.JFrame {
    public static DefaultTableModel tabmode;
    private Connection conn = new koneksi().connect();
    String ID = "";
    String KD = "";
    Boolean isClick = false;

    /**
     * Creates new form gedung
     */
    public gedung() {
        initComponents();
        kosong();
        datatable();
    }
    
    protected void kosong() {
        tKode.setText("");
        tNama.setText("");
        tHarga.setText("");
        tAlamat.setText("");
        tCari.setText("");
    }
    
    protected void datatable(){
        Object[] Baris ={"Kode Gedung","Nama","Telp","Status"};
        tabmode = new DefaultTableModel(null, Baris);
        tbGedung.setModel(tabmode);
        String cariitem = tCari.getText();
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            String sql = "SELECT * FROM gedung where kd_gedung like '%"+cariitem+"%' or nama_gedung like'%"+cariitem+"%' order by kd_gedung asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id = hasil.getString("id_gedung");
                String kd = hasil.getString("kd_gedung");
                String nama = hasil.getString("nama_gedung");
                String telp = hasil.getString("telp");
                Boolean status = hasil.getBoolean("status");
                String status2 = "";
                if(status){
                    status2 = "Tersedia";
                }else{
                    status2 = "Tidak Tersedia";
                }
                String[] data = {kd,nama,telp,status2};
                tabmode.addRow(data);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
    }
    
    protected Boolean validateKode(String Kode){
        Boolean validate = false;
        String sql = "select IFNULL((select kd_gedung from gedung where kd_gedung = '"+Kode+"'),'') as kode";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String kd = hasil.getString("nik");
                if (!kd.equals(Kode)){
                    validate = true;
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
        return validate;
    }
    
    protected String findId(String Kode){
        String id = "";
        String sql = "SELECT id_gedung FROM pelanggan where kd_gedung = '"+Kode+"'";
        try {
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                id = hasil.getString("id_gedung");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
        }
        return id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlamat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcStat = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbGedung = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tTelp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gedung");

        tKode.setEditable(false);

        jLabel2.setText("Kode Gedung");

        jLabel3.setText("Nama Gedung");

        jLabel4.setText("Telp");

        jLabel5.setText("Harga");

        tAlamat.setColumns(20);
        tAlamat.setRows(5);
        jScrollPane1.setViewportView(tAlamat);

        jLabel6.setText("Alamat");

        jLabel7.setText("Status");

        jcStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak Tersedia", "Tersedia" }));

        jButton2.setText("SIMPAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("UBAH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("HAPUS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("BATAL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("KELUAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tbGedung.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGedung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGedungMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbGedung);

        jButton1.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tKode, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(tNama)
                                    .addComponent(tHarga)
                                    .addComponent(tTelp))
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcStat, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jcStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(!isClick){
            String Kode = tKode.getText();
            Boolean validateKode = validateKode(Kode);
            int stat = jcStat.getSelectedIndex();
            if (validateKode){
                String sqlx = "insert into gedung(kd_gedung,nama_gedung,telp,alamat,harga,status,createdat,updatedat) values (?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement statx = conn.prepareStatement(sqlx);
                    statx.setString(1, tKode.getText());
                    statx.setString(2, tNama.getText());
                    statx.setString(3, tTelp.getText());
                    statx.setString(4, tAlamat.getText());
                    statx.setString(5, tHarga.getText());
                    statx.setString(6, String.valueOf(stat));
                    statx.setString(7, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new java.util.Locale("id")).format(new Date()));
                    statx.setString(8, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new java.util.Locale("id")).format(new Date()));
                    statx.executeUpdate();
                    JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
                    kosong();
                    datatable();
                }
            }else{
                JOptionPane.showMessageDialog(null, "NIK sudah terdaftar");
            }
            kosong();
            datatable();
        }else{
            JOptionPane.showMessageDialog(null, "data yg sudah tersimpan tidak bisa dijadikan data baru!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id = findId(KD);
        String newKode = tKode.getText();
        int status = jcStat.getSelectedIndex();
        
        if(KD.equals(newKode)){
            try{
                String sql = "update gedung set kd_gedung=?,nama_gedung=?,telp=?,alamat=?,status=?,updatedAt=? where id_gedung = '"+id+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, newKode);
                stat.setString(2, tNama.getText());
                stat.setString(3, tTelp.getText());
                stat.setString(4, tAlamat.getText());
                stat.setString(5, String.valueOf(status));
                stat.setString(6, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new java.util.Locale("id")).format(new Date()));
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil diubah");

            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "data gagal diubah | "+e);
                KD = "";
                kosong();
                datatable();
            }
        }else{
            Boolean validateKode = validateKode(newKode);
            if (validateKode){
                try{
                    String sql = "update gedung set kd_gedung=?,nama_gedung=?,telp=?,alamat=?,status=?,updatedAt=? where id_gedung = '"+id+"'";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, newKode);
                stat.setString(2, tNama.getText());
                stat.setString(3, tTelp.getText());
                stat.setString(4, tAlamat.getText());
                stat.setString(5, String.valueOf(status));
                stat.setString(6, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",new java.util.Locale("id")).format(new Date()));
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null, "data berhasil diubah");

                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "data gagal diubah | "+e);
                    KD = "";
                    kosong();
                    datatable();
                }
            }else{
                JOptionPane.showMessageDialog(null, "NIK sudah terdaftar");
            }
        }
        
        KD = "";
        kosong();
        datatable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            String id = findId(KD);
            String sql = "delete from gedung where id_gedung ='"+id+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
            }
        }
        datatable();
        kosong();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        kosong();
        datatable();
        KD = "";
        isClick = false;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbGedungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGedungMouseClicked
        // TODO add your handling code here:
        int bar = tbGedung.getSelectedRow();
        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        
        try {
            String sql = "SELECT * FROM gedung where kd_gedung = '"+a+"' and nama_gedung = '"+b+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String id = hasil.getString("id_gedung");
                String kd = hasil.getString("kd_gedung");
                String nama = hasil.getString("nama_gedung");
                String telp = hasil.getString("telp");
                Boolean status = hasil.getBoolean("status");
                String alamat = hasil.getString("alamat");
                String harga =  (String) hasil.getString("harga");
                
                tKode.setText(kd);
                tNama.setText(nama);
                tTelp.setText(telp);
                tHarga.setText(harga);
                tAlamat.setText(alamat);
                if(status){
                    jcStat.setSelectedIndex(1);
                }else{
                    jcStat.setSelectedIndex(0);
                }
                isClick = true;
                KD = id;
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil | "+ex);
        }
    }//GEN-LAST:event_tbGedungMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gedung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gedung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gedung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gedung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gedung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jcStat;
    private javax.swing.JTextArea tAlamat;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tTelp;
    private javax.swing.JTable tbGedung;
    // End of variables declaration//GEN-END:variables
}
