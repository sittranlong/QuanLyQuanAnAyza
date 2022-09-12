/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.BillDAO;
import DAO.BillDetailDAO;
import DAO.CustomerDAO;
import DAO.ProductDAO;
import DAO.StaffDAO;
import Dialog.ShowDialog;
import Format.Formater;
import Models.Bill;
import Models.Customer;
import Models.Product;
import Models.Staff;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sangtm
 */
public class QLBanHang extends javax.swing.JPanel {

    Bill bill;

    ArrayList<Product> listP = new ArrayList<>();
    ArrayList<Staff> listS = new ArrayList<>();
    ArrayList<Customer> listC = new ArrayList<>();
    ArrayList<Bill> listB = new ArrayList<>();

    /**
     * Creates new form QLBanHang
     */
    public QLBanHang() {
        initComponents();
        loadList();
        lb_tennv.setText(getNameStaff());
//        setTongTien();
        setNgayBan();
        btn_huymon.setEnabled(false);
        btn_themmon.setEnabled(false);
        btn_thanhtoan.setEnabled(false);
    }

    public void setNgayBan() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        Date d = new Date();
        lb_ngayban.setText(sdf.format(d));
    }

    public int getIdStaff() {
        for (Staff l : listS) {
            if (Main.user.getUsername().equalsIgnoreCase(l.getTaikhoan())) {
                return l.getId();
            }
        }
        return -1;
    }
    
    public String getNameStaff() {
        for (Staff l : listS) {
            if (Main.user.getUsername().equalsIgnoreCase(l.getTaikhoan())) {
                return l.getHoten();
            }
        }
        return "Admin";
    }

    public void loadList() {
        listP = ProductDAO.getList();
        listS = StaffDAO.getList();
        listC = CustomerDAO.getList();
        listB = BillDAO.getList();
        addItemMonAn();
    }

    public void addItemMonAn() {
        cbb_monan.removeAllItems();
        for (Product l : listP) {
            cbb_monan.addItem(l.getTenmonan());
        }
        if (cbb_monan.getItemCount() != 0) {
            cbb_monan.setSelectedIndex(0);
            tf_dongia.setText(String.valueOf(getDonGia(cbb_monan.getItemAt(0))));
            setTongTien();
        }
    }

    public double getDonGia(String tenmon) {
        for (Product l : listP) {
            if (tenmon.equals(l.getTenmonan())) {
                return l.getDongia();
            }
        }
        return -1;
    }

    public void clearForm() {
        loadList();
        addItemMonAn();
        lb_mahoadon.setText("");
        tf_sodienthoai.setText("");
        sn_soluong.setValue(1);
        setTongTien();
        tf_sodienthoai.setEnabled(true);
        lb_tenkh.setText("");
        btn_tao.setEnabled(true);
        bill = null;
        btn_huymon.setEnabled(false);
        btn_themmon.setEnabled(false);
        btn_thanhtoan.setEnabled(false);
        lb_thanhtien.setText("0");
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        dtm.setRowCount(0);
    }

    public void setTongTien() {
        double dongia = 0;
        int soluong = 0;
        try {
            dongia = Double.parseDouble(tf_dongia.getText());
            soluong = (int) sn_soluong.getValue();
        } catch (Exception e) {
            System.out.println(e);
            ShowDialog.openMessage(this, "Vui lòng nhập đúng định dạng!", "Thông báo");
            return;
        }
        double tongtien = dongia * soluong;
        lb_tongtien.setText(Formater.formatVND(tongtien));
    }

    public String getTenKH(String sdt) {
        for (Customer l : listC) {
            if (l.getSdt().equals(sdt)) {
                return l.getHoten();
            }
        }
        return null;
    }

    public int getMaMon(String tenMon) {
        for (Product l : listP) {
            if (tenMon.equalsIgnoreCase(l.getTenmonan())) {
                return l.getId();
            }
        }
        return -1;
    }

    public int getMaKH(String sdt) {
        for (Customer l : listC) {
            if (l.getSdt().equals(sdt)) {
                return l.getId();
            }
        }
        return -1;
    }

    public void setThanhToan() {
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        double thanhTien = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            double tongtien = (Double) dtm.getValueAt(i, 4);
            thanhTien = thanhTien + tongtien;
        }
        lb_thanhtien.setText(Formater.formatVND(thanhTien));
    }
    
    public double getThanhToan() {
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        double thanhTien = 0;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            double tongtien = (Double) dtm.getValueAt(i, 4);
            thanhTien = thanhTien + tongtien;
        }
        return thanhTien;
    }

    public void themHDCT() {
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        String tenmon = cbb_monan.getItemAt(cbb_monan.getSelectedIndex());
        if (tenmon.trim().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng thêm món ăn vào menu!", "Thông báo");
            return;
        }
        int mamon = getMaMon(tenmon);
        double dongia = Double.parseDouble(tf_dongia.getText());
        int soluong;
        try {
            soluong = Integer.parseInt(String.valueOf(sn_soluong.getValue()));
        } catch (NumberFormatException e) {
            System.out.println(e);
            ShowDialog.openMessage(this, "Vui lòng nhập đúng định dạng!", "Thông báo");
            return;
        }
        double tongtien = soluong * dongia;
        dtm.addRow(new Object[]{tenmon, mamon, soluong, dongia, tongtien});
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_sodienthoai = new javax.swing.JTextField();
        btn_tao = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbb_monan = new javax.swing.JComboBox<>();
        sn_soluong = new javax.swing.JSpinner();
        tf_dongia = new javax.swing.JTextField();
        btn_themmon = new javax.swing.JButton();
        btn_huymon = new javax.swing.JButton();
        btn_thanhtoan = new javax.swing.JButton();
        lb_mahoadon = new javax.swing.JLabel();
        lb_ngayban = new javax.swing.JLabel();
        lb_tennv = new javax.swing.JLabel();
        lb_tongtien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_tenkh = new javax.swing.JLabel();
        lb_thanhtien = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_fill = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Ngày bán:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nhân viên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        tf_sodienthoai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btn_tao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_tao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/tao.png"))); // NOI18N
        btn_tao.setText("Tạo");
        btn_tao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Món ăn:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số lượng:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Đơn giá:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tổng tiền:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Thành tiền:");

        cbb_monan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbb_monan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_monanItemStateChanged(evt);
            }
        });
        cbb_monan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_monanActionPerformed(evt);
            }
        });

        sn_soluong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sn_soluong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        sn_soluong.setToolTipText("");
        sn_soluong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sn_soluongStateChanged(evt);
            }
        });
        sn_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sn_soluongKeyPressed(evt);
            }
        });

        tf_dongia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tf_dongia.setEnabled(false);

        btn_themmon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_themmon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/themHoaDon.png"))); // NOI18N
        btn_themmon.setText("Thêm món");
        btn_themmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themmonActionPerformed(evt);
            }
        });

        btn_huymon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_huymon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/huyMon.png"))); // NOI18N
        btn_huymon.setText("Hủy món");
        btn_huymon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huymonActionPerformed(evt);
            }
        });

        btn_thanhtoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/thanhToan.png"))); // NOI18N
        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        lb_mahoadon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lb_ngayban.setBackground(new java.awt.Color(51, 255, 51));
        lb_ngayban.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ngayban.setForeground(new java.awt.Color(0, 204, 0));
        lb_ngayban.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_tennv.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_tennv.setForeground(new java.awt.Color(0, 153, 0));
        lb_tennv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_tongtien.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_tongtien.setForeground(new java.awt.Color(204, 0, 0));
        lb_tongtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Khách hàng:");

        lb_tenkh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_tenkh.setForeground(new java.awt.Color(255, 102, 0));
        lb_tenkh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_thanhtien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_thanhtien.setForeground(new java.awt.Color(204, 0, 0));
        lb_thanhtien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tb_fill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_fill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên món", "Mã món", "Số lượng", "Đơn giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_fill.setRowHeight(25);
        tb_fill.setRowMargin(2);
        jScrollPane1.setViewportView(tb_fill);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Bảng chi tiết gọi món:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(592, 592, 592)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_ngayban, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(lb_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbb_monan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sn_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(99, 99, 99)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_huymon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_tao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_themmon))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_thanhtoan)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lb_ngayban, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lb_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(tf_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lb_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lb_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbb_monan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(sn_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(lb_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_tao)
                                .addGap(6, 6, 6)
                                .addComponent(btn_lammoi)
                                .addGap(6, 6, 6)
                                .addComponent(btn_themmon)))
                        .addGap(3, 3, 3)
                        .addComponent(btn_huymon)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_thanhtoan)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        // TODO add your handling code here:
        if (tb_fill.getRowCount() == 0) {
            ShowDialog.openMessage(this, "Vui lòng thêm món!", "Thông báo");
            return;
        }
        double thanhtoan = getThanhToan();
        BillDAO.insertBill(thanhtoan, bill.getId_staff(), bill.getId_customer());
        loadList();
        DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int soluong = (int) dtm.getValueAt(i, 2);
            double dongia = (double) dtm.getValueAt(i, 3);
            double tongtien = (double) dtm.getValueAt(i, 4);
            int id_product = (int) dtm.getValueAt(i, 1);
            BillDetailDAO.insertBD(soluong, dongia, tongtien, listB.get(listB.size() - 1).getId(), id_product);
        }
        ShowDialog.openMessage(this, "Thanh toán thành công!", "Thông báo");
        clearForm();
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void btn_huymonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huymonActionPerformed
        // TODO add your handling code here:
        int indexRow = tb_fill.getSelectedRow();
        if (indexRow == -1) {
            ShowDialog.openMessage(this, "Vui lòng chọn món cần xóa!", "Thông báo");
            return;
        }
        int i = ShowDialog.showConfirm(this, "Bạn có muốn hủy món ăn!", "Thông báo");
        if (i == JOptionPane.YES_OPTION) {
            DefaultTableModel dtm = (DefaultTableModel) tb_fill.getModel();
            dtm.removeRow(indexRow);
            setThanhToan();
            ShowDialog.openMessage(this, "Hủy thành công!", "Thông báo");
        }
    }//GEN-LAST:event_btn_huymonActionPerformed

    private void btn_themmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themmonActionPerformed
        // TODO add your handling code here:
        themHDCT();
        setThanhToan();
    }//GEN-LAST:event_btn_themmonActionPerformed

    private void sn_soluongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sn_soluongKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sn_soluongKeyPressed

    private void sn_soluongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sn_soluongStateChanged
        // TODO add your handling code here:
        if (cbb_monan.getItemCount() == 0) {
            ShowDialog.openMessage(this, "Vui lòng thêm món vào menu!", "Thông báo");
            return;
        }
        setTongTien();
    }//GEN-LAST:event_sn_soluongStateChanged

    private void cbb_monanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_monanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_monanActionPerformed

    private void cbb_monanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_monanItemStateChanged
        // TODO add your handling code here:
        if (cbb_monan.getItemCount() != 0) {
            tf_dongia.setText(String.valueOf(getDonGia(cbb_monan.getItemAt(cbb_monan.getSelectedIndex()))));
            setTongTien();
        }
    }//GEN-LAST:event_cbb_monanItemStateChanged

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
        // TODO add your handling code here:
        if (cbb_monan.getItemCount() == 0) {
            ShowDialog.openMessage(this, "Vui lòng thêm món vào menu!", "Thông báo");
            return;
        }
        clearForm();
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_taoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoActionPerformed
        // TODO add your handling code here:
        if (cbb_monan.getItemCount() == 0) {
            ShowDialog.openMessage(this, "Vui lòng thêm món vào menu!", "Thông báo");
            return;
        }
        if (tf_sodienthoai.getText().trim().isEmpty()) {
            ShowDialog.openMessage(this, "Vui lòng nhập số điện thoại!", "Thông báo");
            return;
        }
        String tenKH = getTenKH(tf_sodienthoai.getText().trim());
        if (tenKH == null) {
            ShowDialog.openMessage(this, "Không tìm thấy khách hàng!", "Thông báo");
            return;
        } else {
            lb_tenkh.setText(tenKH);
            tf_sodienthoai.setEnabled(false);
            btn_tao.setEnabled(false);
            bill = new Bill();
            bill.setId(-1);
            bill.setId_staff(getIdStaff());
            bill.setNgayban(new Date());
            bill.setId_customer(getMaKH(tf_sodienthoai.getText()));
            bill.setThanhtoan(0);
            System.out.println(bill.toString());
            btn_huymon.setEnabled(true);
            btn_themmon.setEnabled(true);
            btn_thanhtoan.setEnabled(true);
        }
    }//GEN-LAST:event_btn_taoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huymon;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_tao;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_themmon;
    private javax.swing.JComboBox<String> cbb_monan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_mahoadon;
    private javax.swing.JLabel lb_ngayban;
    private javax.swing.JLabel lb_tenkh;
    private javax.swing.JLabel lb_tennv;
    private javax.swing.JLabel lb_thanhtien;
    private javax.swing.JLabel lb_tongtien;
    private javax.swing.JSpinner sn_soluong;
    private javax.swing.JTable tb_fill;
    private javax.swing.JTextField tf_dongia;
    private javax.swing.JTextField tf_sodienthoai;
    // End of variables declaration//GEN-END:variables
}
