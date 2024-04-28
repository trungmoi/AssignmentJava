/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ASMGD1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mxtru
 */
public class QLyDiem extends javax.swing.JFrame {
      private List<Student> list = new ArrayList<>();
      
   
    
    public QLyDiem() {
        initComponents();
        setLocationRelativeTo(null);
       
    }
 
    public boolean checkTim() {
        String tim = txtmasv.getText();
        if (tim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Mã Sinh Viên Cần Tìm", "Thông Báo", 2);
            txtmasv.requestFocus();
            return false;
        }
        if (Table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Danh Sách Thông Tin Trống.", "Thông báo", 2);
            return false;
        }
        return true;
    }
 
    public boolean check() {
        String maSv = txtmasv1.getText();
        String Ten = txthoten.getText();
        String diemTA = txttienganh.getText();
        String diemTH = txttinhoc.getText();
        String diemGDTC = txtgdtc.getText();

        if (Ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Họ Tên Sv", "Thông Báo", 2);
            txthoten.requestFocus();
            return false;
        }
       
        if (maSv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Mã Sinh Viên", "Thông Báo", 2);
            txtmasv1.requestFocus();
            return false;
        }
        if (diemTA.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập ĐIểm Tiếng Anh", "Thông Báo", 2);
            txttienganh.requestFocus();
            return false;
        }
        try {
            double diemTa = Double.parseDouble(diemTA);
            if (diemTa < 0 || diemTa > 10) {
                JOptionPane.showMessageDialog(this, "Điểm Chỉ từ 0 đến 10.", "Thông báo", 1);
                txttienganh.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là một số.", "Thông báo", 1);
            txttienganh.requestFocus();
            return false;
        }
        if (diemTH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Điểm Tin Học", "Thông Báo", 2);
            txttinhoc.requestFocus();
            return false;
        }
        try {
            double diemTh = Double.parseDouble(diemTH);
            if (diemTh < 0 || diemTh > 10) {
                JOptionPane.showMessageDialog(this, "Điểm Chỉ từ 0 đến 10.", "Thông báo", 1);
                txttinhoc.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là số.", "Thông báo", 1);
            txttinhoc.requestFocus();
            return false;
        }
        if (diemGDTC.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập Điểm GDTC", "Thông Báo", 2);
            txtgdtc.requestFocus();
            return false;
        }

        try {
            double diemgdtc = Double.parseDouble(diemGDTC);
            if (diemgdtc < 0 || diemgdtc > 10) {
                JOptionPane.showMessageDialog(this, "Điểm Chỉ từ 0 đến 10.", "Thông báo", 1);
                txtgdtc.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm phải là một số.", "Thông báo", 1);
            txtgdtc.requestFocus();
            return false;
        }
        return true;

    }

    public void FillToTable() {
         DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return Double.compare(st2.getDiemTb(), st1.getDiemTb());
            }
        });
        int count = 0;
        for (Student st : list) {
            Object[] row = new Object[]{st.getMaSV(), st.getHoTen(), st.getTienganh(), st.getTinhoc(), st.getGdtc(), st.getDiemTb()};
            model.addRow(st.toRow());
            count++;
            if (count == 3) {
                break;
            }
        }
    }

    public void reset() {
        int a = Table.getSelectedRow();
        list.remove(a);
    }

    public void add() {

         String maSv = txtmasv1.getText();
        String Ten = txthoten.getText();
        String diemTa = txttienganh.getText();
        String diemTH = txttinhoc.getText();
        String diemGDTC = txtgdtc.getText();
        String diemTB = txtdiemtb.getText();

        if (check()) {
            Student st = new Student();
            for (Student student : list) {
                if (st.getMaSV().equalsIgnoreCase(maSv)) {
                    JOptionPane.showMessageDialog(this, "Mã Sinh Viên Đã Tồn Tại", "LỖI", 2);
                    txtmasv1.requestFocus();
                    return;
                }
            }
            st.setHoTen(Ten);
            st.setMaSV(maSv);
            st.setTienganh(Double.parseDouble(diemTa));
            st.setTinhoc(Double.parseDouble(diemTH));
            st.setGdtc(Double.parseDouble(diemGDTC));
            list.add(st);
            txtdiemtb.setText(diemTB);
            txtdiemtb.setText(String.valueOf(st.getDiemTb()));
            FillToTable();
        }
    }



    public void xoa() {
            int a = Table.getSelectedRow();
            list.remove(a);
    }

    public void Tim() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        String timma = txtmasv.getText();
        boolean tim = false;
        if (timma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập Mã Sv cần tìm !", "Thông Báo", 3);
            txtmasv.requestFocus();

        }
        for (Student st : list) {
            if (st.getMaSV().equalsIgnoreCase(timma)) {
                model.setRowCount(0);
                Object[] row = new Object[]{st.getMaSV(), st.getHoTen(), st.getTienganh(), st.getTinhoc(), st.getGdtc(), st.getDiemTb()};
                model.addRow(row);
                show(st);
                tim = true;
                break;
            }
        }
        if (!tim) {
            JOptionPane.showMessageDialog(this, "Không Tìm Thấy Thông Tin", "Thông báo", 3);
        }
    }

    public void show(Student st) {
        txthoten.setText(st.getHoTen());
        txtmasv1.setText(st.getMaSV());
        txttienganh.setText(String.valueOf(st.getTienganh()));
        txttinhoc.setText(String.valueOf(st.getTinhoc()));
        txtgdtc.setText(String.valueOf(st.getGdtc()));
        txtdiemtb.setText(String.valueOf(st.getDiemTb()));
    }

    public void showclick() {
        int a = Table.getSelectedRow();
        Student st = list.get(a);
        show(st);
    }

    public void update() {
        int up = Table.getSelectedRow();
        Student st = list.get(up);
        if (check()) {
            st.setHoTen(txthoten.getText());
            st.setMaSV(txtmasv1.getText());
            st.setTienganh(Double.parseDouble(txttienganh.getText()));
            st.setTinhoc(Double.parseDouble(txttinhoc.getText()));
            st.setGdtc(Double.parseDouble(txtgdtc.getText()));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtdiemtb = new javax.swing.JTextField();
        txttienganh = new javax.swing.JTextField();
        txtmasv1 = new javax.swing.JTextField();
        txttinhoc = new javax.swing.JTextField();
        txthoten = new javax.swing.JTextField();
        txtgdtc = new javax.swing.JTextField();
        btnnext = new javax.swing.JButton();
        btndau = new javax.swing.JButton();
        btnnew = new javax.swing.JButton();
        btncuoi = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtmasv = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", " Tiếng Anh", " Tin Học", " GDTC", " Điểm TB"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("3 Sinh Viên Có ĐIểm Cao Nhất");

        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Họ Tên Sv");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mã Sv");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tiếng Anh");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Tin Học");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GIáo Dục TC");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Điểm TB");

        txtdiemtb.setBackground(new java.awt.Color(242, 242, 242));
        txtdiemtb.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtdiemtb.setForeground(new java.awt.Color(0, 0, 102));
        txtdiemtb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdiemtb.setBorder(null);
        txtdiemtb.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtdiemtb.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtdiemtb.setEnabled(false);
        txtdiemtb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiemtbActionPerformed(evt);
            }
        });

        txttienganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttienganhActionPerformed(evt);
            }
        });

        txtmasv1.setForeground(new java.awt.Color(51, 51, 51));
        txtmasv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmasv1ActionPerformed(evt);
            }
        });

        txttinhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttinhocActionPerformed(evt);
            }
        });

        txthoten.setForeground(new java.awt.Color(0, 0, 204));

        txtgdtc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgdtcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtgdtc))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txttinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txttienganh, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txthoten))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmasv1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtdiemtb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmasv1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttienganh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttinhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtdiemtb, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnnext.setText("<<");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btndau.setText(">>");
        btndau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndauActionPerformed(evt);
            }
        });

        btnnew.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASMGD1/Icon Application/Add.png"))); // NOI18N
        btnnew.setText("NEW");
        btnnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewActionPerformed(evt);
            }
        });

        btncuoi.setText(">");
        btncuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncuoiActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASMGD1/Icon Application/Save.png"))); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASMGD1/Icon Application/Edit.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUAN LY DIEM  SV");

        btndelete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASMGD1/Icon Application/Delete.png"))); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tim Kiem ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MÃ SV :");

        txtmasv.setForeground(new java.awt.Color(0, 0, 153));

        btnsearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ASMGD1/Icon Application/Search.png"))); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsearch))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmasv, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btndelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(btnback)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnnext)
                                        .addGap(18, 18, 18)
                                        .addComponent(btndau)
                                        .addGap(18, 18, 18)
                                        .addComponent(btncuoi)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnnew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(547, 547, 547))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TableMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtdiemtbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiemtbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiemtbActionPerformed

    private void txttienganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttienganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttienganhActionPerformed

    private void txtmasv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmasv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmasv1ActionPerformed

    private void txttinhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttinhocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttinhocActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnnextActionPerformed

    private void btndauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndauActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btndauActionPerformed

    private void btnnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewActionPerformed
        // TODO add your handling code here:
        txtmasv.setText(null);
        txtmasv1.setText(null);
        txthoten.setText(null);
        txttienganh.setText(null);
        txttinhoc.setText(null);
        txtgdtc.setText(null);
        txtdiemtb.setText(null);
    }//GEN-LAST:event_btnnewActionPerformed

    private void btncuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncuoiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btncuoiActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        this.add();
        this.FillToTable();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        if (Table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Thông Tin", "Thông báo", 3);
        } else {

            if (Table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy Chọn Sinh Viên Cần Update.", "Thông báo", 3);
            } else {
               
                this.update();
                this.FillToTable();
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if (Table.getRowCount() == 0) {

            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Thông Tin.", "Thông báo", 3);
        } else {
            if (Table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Hãy Chọn Sinh Viên Cần Xóa.", "Thông báo", 3);
            } else {
                this.xoa();
                this.FillToTable();
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:

        if (Table.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Thông Tin.", "Thông báo", 3);
        } else {
            this.Tim();
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtgdtcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgdtcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgdtcActionPerformed

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
            java.util.logging.Logger.getLogger(QLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLyDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLyDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncuoi;
    private javax.swing.JButton btndau;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtdiemtb;
    private javax.swing.JTextField txtgdtc;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtmasv1;
    private javax.swing.JTextField txttienganh;
    private javax.swing.JTextField txttinhoc;
    // End of variables declaration//GEN-END:variables
}
