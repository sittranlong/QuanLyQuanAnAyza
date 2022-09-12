/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import Dialog.ShowDialog;
import Models.Category;
import Models.Product;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Long
 */
public class QLMonAn extends javax.swing.JPanel {

    ArrayList<Product> listP = new ArrayList<>();
    ArrayList<Category> listC = new ArrayList<>();

    /**
     * Creates new form QuanLyMonAn
     */
    public QLMonAn() {
        initComponents();
        loadList();
        addItemDanhMuc();
        fillTable();
    }
    
    public void selectFirstRow() {
        if (tb_fill.getRowCount() > 0) {
            tb_fill.setRowSelectionInterval(0, 0);
            fillForm();
        }
    }

    public void loadList() {
        listP = ProductDAO.getList();
        listC = CategoryDAO.getList();
    }

    public String getTenDanhMuc(int id) {
        for (Category l : listC) {
            if (id == l.getId()) {
                return l.getTendanhmuc();
            }
        }
        return null;
    }

    public int getIdDanhMuc(String tendanhmuc) {
        for (Category l : listC) {
            if (tendanhmuc.equalsIgnoreCase(l.getTendanhmuc())) {
                return l.getId();
            }
        }
        return -1;
    }

    public void fillTable() {
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        dtm.setRowCount(0);
        for (Product l : listP) {
            dtm.addRow(new Object[]{l.getId(), l.getTenmonan(), getTenDanhMuc(l.getId_category()), l.getDongia(), l.getAnh(), l.getGioithieu()});
        }
    }

    public void addItemDanhMuc() {
        cbb_danhmuc.removeAllItems();
        for (Category l : listC) {
            cbb_danhmuc.addItem(l.getTendanhmuc());
        }
        if (cbb_danhmuc.getItemCount() == 1) {
            cbb_danhmuc.setSelectedIndex(0);
        }
    }

    public void clearForm() {
        loadList();
        addItemDanhMuc();
        tf_ma.setText("");
        if (cbb_danhmuc.getItemCount() != 0) {
            cbb_danhmuc.setSelectedIndex(0);
        }
        tf_tenmon.setText("");
        tf_dongia.setText("");
        ta_gioithieu.setText("");
        tf_anh.setText("");
        tf_batdau.setText("");
        tf_ketthuc.setText("");
        anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/demo.jpg")));
        fillTable();
    }

    public void fillForm() {
        int index = tb_fill.getSelectedRow();
        tf_ma.setText(String.valueOf(listP.get(index).getId()));
        tf_anh.setText(listP.get(index).getAnh());
        tf_dongia.setText(String.valueOf(listP.get(index).getDongia()));
        tf_tenmon.setText(listP.get(index).getTenmonan());
        ta_gioithieu.setText(listP.get(index).getGioithieu());
        for (int i = 0; i < cbb_danhmuc.getItemCount(); i++) {
            if (getTenDanhMuc(listP.get(index).getId_category()).equals(cbb_danhmuc.getItemAt(i))) {
                cbb_danhmuc.setSelectedIndex(i);
            }
        }
        anh.setIcon(new javax.swing.ImageIcon(listP.get(index).getAnh()));
    }

    public int searchRow() {
        String tenmonan = tf_moncantim.getText().trim();
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (tenmonan.equalsIgnoreCase(String.valueOf(dtm.getValueAt(i, 1)))) {
                return i;
            }
        }
        return -1;
    }

    public void setDisable() {
        btn_them.setEnabled(false);
        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_ma = new javax.swing.JTextField();
        tf_tenmon = new javax.swing.JTextField();
        tf_dongia = new javax.swing.JTextField();
        tf_anh = new javax.swing.JTextField();
        cbb_danhmuc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_gioithieu = new javax.swing.JTextArea();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_fill = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tf_batdau = new javax.swing.JTextField();
        tf_ketthuc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_loc = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        anh = new javax.swing.JLabel();
        tf_moncantim = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã món ăn:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Danh mục:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Món ăn:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Đơn giá:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("File ảnh:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giới thiệu:");

        tf_ma.setEditable(false);
        tf_ma.setBackground(new java.awt.Color(255, 255, 255));
        tf_ma.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_ma.setEnabled(false);

        tf_tenmon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_dongia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tf_anh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_anhMouseClicked(evt);
            }
        });

        cbb_danhmuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_danhmuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_danhmucActionPerformed(evt);
            }
        });

        ta_gioithieu.setColumns(20);
        ta_gioithieu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ta_gioithieu.setLineWrap(true);
        ta_gioithieu.setRows(5);
        jScrollPane1.setViewportView(ta_gioithieu);

        btn_them.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/themMon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editMon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xoaMon.png"))); // NOI18N
        btn_xoa.setText("  Xóa   ");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lammoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_lammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lammoi.png"))); // NOI18N
        btn_lammoi.setText("Làm mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        tb_fill.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb_fill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_fill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món ăn", "Tên món ăn", "Danh mục", "Đơn giá", "Ảnh", "Giới thiệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_fill.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_fill.setRowHeight(25);
        tb_fill.setRowMargin(2);
        tb_fill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_fillMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_fill);
        tb_fill.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Khoảng giá:");

        tf_batdau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_batdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_batdauActionPerformed(evt);
            }
        });

        tf_ketthuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("-");

        btn_loc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_loc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/locMon.png"))); // NOI18N
        btn_loc.setText(" Lọc  ");
        btn_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(210, 90));

        anh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgMonAn/demo.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tf_moncantim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btn_timkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/timkiemMonan.png"))); // NOI18N
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Bảng quản lý món ăn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbb_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_moncantim)
                                .addGap(18, 18, 18)
                                .addComponent(btn_timkiem))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(tf_ketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(19, 19, 19)
                                                .addComponent(btn_loc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_lammoi)))))))))
                .addGap(10, 10, 10))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_lammoi, btn_loc, btn_sua, btn_them, btn_timkiem, btn_xoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(cbb_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(tf_tenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(tf_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(tf_anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_them)
                                    .addComponent(btn_xoa))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_sua)
                                    .addComponent(btn_lammoi))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(tf_ketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_loc)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tf_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)))
                                    .addComponent(jLabel8))))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(tf_moncantim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_timkiem))
                .addGap(13, 13, 13)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_lammoi, btn_loc, btn_sua, btn_them, btn_timkiem, btn_xoa});

    }// </editor-fold>//GEN-END:initComponents

    private void cbb_danhmucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_danhmucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_danhmucActionPerformed

    private void tf_batdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_batdauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_batdauActionPerformed

    private void tf_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_anhMouseClicked
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fc.setFileFilter(fnef);
        fc.setMultiSelectionEnabled(false);

        int i = fc.showDialog(this, "Chọn file ảnh");
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            tf_anh.setText(f.getAbsolutePath());
            anh.setIcon(new javax.swing.ImageIcon(f.getAbsolutePath()));
        }
    }//GEN-LAST:event_tf_anhMouseClicked

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void tb_fillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_fillMouseClicked
        // TODO add your handling code here:
        fillForm();
    }//GEN-LAST:event_tb_fillMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        loadList();
        int id_category = getIdDanhMuc(cbb_danhmuc.getItemAt(cbb_danhmuc.getSelectedIndex()));
        String tenmonan = tf_tenmon.getText().trim();
        if (tenmonan.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập tên món!", "Thông báo");
            return;
        }
        Double dongia = null;
        try {
            dongia = Double.parseDouble(tf_dongia.getText().trim());
        } catch (Exception e) {
            System.out.println(e);
            ShowDialog.openMessage(this, "Vui lòng nhập đúng định dạng!", "Thông báo");
            return;
        }
        String anh = tf_anh.getText().trim();
        if (anh.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng chọn file ảnh!", "Thông báo");
            return;
        }
        String gioithieu = ta_gioithieu.getText().trim();
        if (gioithieu.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập giới thiệu!", "Thông báo");
            return;
        }
        System.out.println(id_category);
        ProductDAO.insertProduct(id_category, tenmonan, dongia, gioithieu, anh);
        loadList();
        fillTable();
        clearForm();
        ShowDialog.openMessage(this, "Thêm món ăn thành công!", "Thông báo");
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        if (tf_ma.getText().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng chọn món cần sửa!", "Thông báo");
            return;
        }
        int id_category = getIdDanhMuc(cbb_danhmuc.getItemAt(cbb_danhmuc.getSelectedIndex()));
        String tenmonan = tf_tenmon.getText().trim();
        if (tenmonan.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập tên món!", "Thông báo");
            return;
        }
        Double dongia = null;
        try {
            dongia = Double.parseDouble(tf_dongia.getText().trim());
        } catch (Exception e) {
            System.out.println(e);
            ShowDialog.openMessage(this, "Vui lòng nhập đúng định dạng!", "Thông báo");
        }
        String anh = tf_anh.getText().trim();
        if (anh.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng chọn file ảnh!", "Thông báo");
            return;
        }
        String gioithieu = ta_gioithieu.getText().trim();
        if (gioithieu.isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập giới thiệu!", "Thông báo");
            return;
        }
        ProductDAO.updateProduct(Integer.parseInt(tf_ma.getText()), id_category, tenmonan, dongia, gioithieu, anh, "Đang hoạt động");
        loadList();
        fillTable();
        clearForm();
        ShowDialog.openMessage(this, "Sửa thành công", "Thông báo");
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        if (tf_ma.getText().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng chọn món cần Xóa!", "Thông báo");
            return;
        }
        int i = ShowDialog.showConfirm(this, "Bạn có muốn xóa món ăn?", "Thông báo");
        if (i == JOptionPane.YES_OPTION) {
            ProductDAO.deleteProduct(Integer.parseInt(tf_ma.getText()));
            loadList();
            fillTable();
            clearForm();
            ShowDialog.openMessage(this, "Xóa thành công", "Thông báo");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        if (tf_moncantim.getText().trim().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập tên món cần tìm!", "Thông báo");
            return;
        }
        if (searchRow() != -1) {
            tb_fill.setRowSelectionInterval(searchRow(), searchRow());
            fillForm();
        } else {
            ShowDialog.openMessage(this, "Không tìm thấy món ăn!", "Thông báo");
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locActionPerformed
        // TODO add your handling code here:
        if (tf_batdau.getText().trim().isEmpty() || tf_ketthuc.getText().trim().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập khoảng giá!", "Thông báo");
            return;
        }
        double batdau;
        double ketthuc;
        try {
            batdau = Double.parseDouble(tf_batdau.getText());
            ketthuc = Double.parseDouble(tf_ketthuc.getText());
        } catch (NumberFormatException e) {
            System.out.println(e);
            ShowDialog.openMessage(this, "Sai định dạng!", "Thông báo");
            return;
        }
        if (batdau > ketthuc) {
            ShowDialog.openMessage(this, "Vui lòng nhập lại khoảng giá!", "Thông báo");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        dtm.setRowCount(0);
        for (Product l : listP) {
            if (l.getDongia() >= batdau && l.getDongia() <= ketthuc) {
                dtm.addRow(new Object[]{l.getId(), l.getTenmonan(), getTenDanhMuc(l.getId_category()), l.getDongia(), l.getAnh(), l.getGioithieu()});
            }
        }
    }//GEN-LAST:event_btn_locActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anh;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_loc;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_danhmuc;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta_gioithieu;
    private javax.swing.JTable tb_fill;
    private javax.swing.JTextField tf_anh;
    private javax.swing.JTextField tf_batdau;
    private javax.swing.JTextField tf_dongia;
    private javax.swing.JTextField tf_ketthuc;
    private javax.swing.JTextField tf_ma;
    private javax.swing.JTextField tf_moncantim;
    private javax.swing.JTextField tf_tenmon;
    // End of variables declaration//GEN-END:variables
}
