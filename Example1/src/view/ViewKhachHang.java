/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.KhachHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.QuanLyKhachHangService;
import service.impl.QuanLyKhachHangServiceImpl;

/**
 *
 * @author fptsh
 */
public class ViewKhachHang extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private List<KhachHang> list;
    private List<String> listLoai;
    private QuanLyKhachHangService quanLyKhachHangService;

    /**
     * Creates new form ViewKhachHang
     */
    public ViewKhachHang() {
        initComponents();
        dtm = new DefaultTableModel();
        dcbm = new DefaultComboBoxModel();
        list = new QuanLyKhachHangServiceImpl().getData();

        listLoai = new ArrayList<>();
        quanLyKhachHangService = new QuanLyKhachHangServiceImpl();
        dtm = (DefaultTableModel) this.tblListKh.getModel();
        dcbm = (DefaultComboBoxModel) this.cboLoai.getModel();

        showDataTable(list);
        detailKhachHang(0);
        listLoai.add("Khach thuong");
        listLoai.add("VIP");
        listLoai.add("VVIP");
        showDataComboBox(listLoai);
    }

    private void showDataTable(List<KhachHang> getData) {
        dtm.setRowCount(0);
        for (KhachHang kh : getData) {
            dtm.addRow(kh.toDataRow());
        }
    }

    private void showDataComboBox(List<String> list) {
        for (String s : list) {
            dcbm.addElement(s);
        }
    }

    private void showDataVip(List<KhachHang> list) {
        dtm.setRowCount(0);
        for (KhachHang kh : list) {
            if (kh.getLoai().equalsIgnoreCase("VIP")) {
                dtm.addRow(kh.toDataRow());
            }
        }
    }

    private void detailKhachHang(int index) {
        KhachHang kh = list.get(index);
        txtMaKH.setText(kh.getMakh());
        txtTenKH.setText(kh.getTenkh());
        txtTuoi.setText(String.valueOf(kh.getTuoi()));
        if (kh.isGioiTinh() == true) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        cboLoai.setSelectedItem(kh.getLoai());
    }

    private KhachHang getDataFormView() {
        KhachHang kh = new KhachHang();
        String makh = txtMaKH.getText();
        String ten = txtTenKH.getText();
        int tuoi = Integer.parseInt(txtTuoi.getText());
        boolean gioiTinh = false;
        if (rdoNam.isSelected()) {
            gioiTinh = true;
        }
        String loai = cboLoai.getSelectedItem().toString();
        return new KhachHang(makh, ten, tuoi, gioiTinh, loai);
    }

    private boolean validateKhachHang(){
        if (txtMaKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten sach khong duoc de trong");
            return false;
        } else if (txtTenKH.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tac gia khong duoc de trong");
            return false;
        } else if (!txtTuoi.getText().trim().replace(".", "").matches("\\d+") || Double.parseDouble(txtTuoi.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Tuoi la so va lon hon 0");
            return false;
        }
        return true; 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMax = new javax.swing.JTextField();
        txtMin = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        cboLoai = new javax.swing.JComboBox<>();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListKh = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClear.setText("Clear");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        jLabel2.setText("Max age");

        jLabel3.setText("Min age");

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Information");

        jLabel5.setText("Ma khach hang");

        jLabel6.setText("Ten khach hang");

        jLabel7.setText("Tuoi");

        jLabel8.setText("Gioi tinh");

        jLabel9.setText("Loai khach hang");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nu");

        tblListKh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma KH", "Ten KH", "Tuoi", "Gioi tinh", "Loai KH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblListKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListKhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListKh);

        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnChange.setText("Change");
        btnChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangeMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortMouseClicked(evt);
            }
        });

        btnList.setText("List VIP");
        btnList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListMouseClicked(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("List Data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(81, 81, 81)
                                        .addComponent(btnSearch))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel3))
                                                .addGap(20, 20, 20)
                                                .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(btnAdd)
                            .addComponent(btnSort))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoNu))
                                    .addComponent(txtMaKH)
                                    .addComponent(txtTenKH)
                                    .addComponent(txtTuoi)
                                    .addComponent(cboLoai, 0, 200, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnChange)
                                    .addComponent(btnList))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExit)
                                    .addComponent(btnDelete))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnChange)
                            .addComponent(btnDelete))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSort)
                            .addComponent(btnList)
                            .addComponent(btnExit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListMouseClicked
        showDataVip(list);
    }//GEN-LAST:event_btnListMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        int min = Integer.parseInt(txtMin.getText());
        int max = Integer.parseInt(txtMax.getText());
//        List<KhachHang> listSearch = quanLyKhachHangService.Search(list, max, min);
//        showDataTable(listSearch);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblListKhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListKhMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblListKh.getSelectedRow();
        if (rowIndex >= 0 && rowIndex <= list.size()) {
            detailKhachHang(rowIndex);
        }
    }//GEN-LAST:event_tblListKhMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        txtMaKH.setText("");
        txtMax.setText("");
        txtMin.setText("");
        txtTenKH.setText("");
        txtTuoi.setText("");
        buttonGroup1.clearSelection();
        cboLoai.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortMouseClicked
        // TODO add your handling code here:
        List<KhachHang> listSort = new QuanLyKhachHangServiceImpl().sortBy();
        quanLyKhachHangService.sortBy();
        showDataTable(listSort);
    }//GEN-LAST:event_btnSortMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (validateKhachHang()) {
            KhachHang khachHang = getDataFormView();
            list.add(khachHang);
            showDataTable(list);
            JOptionPane.showMessageDialog(this, "Data save successfully");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangeMouseClicked

    }//GEN-LAST:event_btnChangeMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int row = tblListKh.getSelectedRow(); //Lay dong da chon tren table
        if (row >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Delete?");
            System.out.println(result);
            if (result == 0) {
            //    quanLyKhachHangService.delete(long makh, row);
                showDataTable(list);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chon dung can xoa");
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

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
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblListKh;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
