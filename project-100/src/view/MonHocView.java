package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import interf.MonHocViewInterface;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MonHocView extends JFrame implements MonHocViewInterface {
    private JTextField txtId = new JTextField(10);
    private JTextField txtTenMonHoc = new JTextField(10);
    private JTextField txtSoTinChi = new JTextField(10);
    private JTextField txtSinhVienId = new JTextField(10);  // Thêm trường để nhập sinh viên ID
    private JTextField txtMonHocId = new JTextField(10);  // Thêm trường để nhập môn học ID
    private JButton btnQuayLai = new JButton("Quay lại");
    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnXoa = new JButton("Xóa");
    private JButton btnGanMonHoc = new JButton("Đăng ký môn học cho sinh viên");  // Nút gán môn học
    private JButton btnXemThongTin = new JButton("Tra cứu sinh viên");
    private JTable table;
    private DefaultTableModel model;

    public MonHocView() {
    	 this.setTitle("Quản lý môn học");
         this.setSize(700, 400);
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setLayout(new BorderLayout(10, 10));

         // Tạo bảng
         String[] columns = {"Id", "Tên Môn Học", "Số Tín Chỉ"};
         model = new DefaultTableModel(columns, 0);
         table = new JTable(model);
         JScrollPane scrollPane = new JScrollPane(table);

         // Tiêu đề
         JPanel pnlabel = new JPanel();
         JLabel titleLabel = new JLabel("QUẢN LÝ MÔN HỌC");
         titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
         titleLabel.setForeground(new Color(51, 51, 153));
         pnlabel.add(titleLabel);

         // Bảng
         JPanel pntable = new JPanel();
         pntable.setLayout(new BorderLayout());
         pntable.add(scrollPane, BorderLayout.CENTER);
         
         // Thông tin môn học
         JPanel pnhienthi = new JPanel(new GridBagLayout());
         pnhienthi.setBorder(BorderFactory.createTitledBorder("Thông tin Môn Học"));
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.insets = new Insets(5, 5, 5, 5); // Thêm khoảng cách
         
         // Các thành phần thông tin
         gbc.gridx = 0; gbc.gridy = 0; pnhienthi.add(new JLabel("Id môn học:"), gbc);
         gbc.gridx = 1; gbc.gridy = 0; pnhienthi.add(txtId, gbc);
         gbc.gridx = 0; gbc.gridy = 1; pnhienthi.add(new JLabel("Tên Môn Học:"), gbc);
         gbc.gridx = 1; gbc.gridy = 1; pnhienthi.add(txtTenMonHoc, gbc);
         gbc.gridx = 0; gbc.gridy = 2; pnhienthi.add(new JLabel("Số Tín Chỉ:"), gbc);
         gbc.gridx = 1; gbc.gridy = 2; pnhienthi.add(txtSoTinChi, gbc);
         gbc.gridx = 0; gbc.gridy = 3; pnhienthi.add(new JLabel("Sinh Viên Id:"), gbc);
         gbc.gridx = 1; gbc.gridy = 3; pnhienthi.add(txtSinhVienId, gbc);
         gbc.gridx = 0; gbc.gridy = 4; pnhienthi.add(new JLabel("Môn Học Id:"), gbc);
         gbc.gridx = 1; gbc.gridy = 4; pnhienthi.add(txtMonHocId, gbc);

         // Nút
         JPanel pnbtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
         pnbtn.add(btnQuayLai);
         pnbtn.add(btnThem);
         pnbtn.add(btnSua);
         pnbtn.add(btnXoa);
         pnbtn.add(btnGanMonHoc);
         pnbtn.add(btnXemThongTin);

         // Đặt màu nền cho các nút
         btnQuayLai.setBackground(new Color(150, 150, 250));
         btnThem.setBackground(new Color(100, 200, 100));
         btnSua.setBackground(new Color(100, 150, 200));
         btnXoa.setBackground(new Color(200, 100, 100));
         btnGanMonHoc.setBackground(new Color(150, 150, 250));
         btnXemThongTin.setBackground(new Color(150, 150, 250));
         
         // Thay đổi màu chữ cho các nút
         btnQuayLai.setForeground(Color.WHITE);
         btnThem.setForeground(Color.WHITE);
         btnSua.setForeground(Color.WHITE);
         btnXoa.setForeground(Color.WHITE);
         btnGanMonHoc.setForeground(Color.WHITE);
         btnXemThongTin.setForeground(Color.WHITE);

         // Bố cục tổng thể
         this.add(pnlabel, BorderLayout.NORTH);
         this.add(pntable, BorderLayout.CENTER);
         this.add(pnhienthi, BorderLayout.EAST);
         this.add(pnbtn, BorderLayout.SOUTH);
         
         ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
         // Hiển thị giao diện
         this.setVisible(true);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public int getId() {
        return Integer.parseInt(txtId.getText());
    }

    @Override
    public void setId(int id) {
        txtId.setText(String.valueOf(id));
    }

    @Override
    public String getTenMonHoc() {
        return txtTenMonHoc.getText();
    }

    @Override
    public void setTenMonHoc(String tenMonHoc) {
        txtTenMonHoc.setText(tenMonHoc);
    }

    @Override
    public int getSoTinChi() {
        return Integer.parseInt(txtSoTinChi.getText());
    }

    @Override
    public void setSoTinChi(int soTinChi) {
        txtSoTinChi.setText(String.valueOf(soTinChi));
    }

    @Override
    public int getSinhVienId() {
        return Integer.parseInt(txtSinhVienId.getText());
    }

    @Override
    public int getMonHocId() {
        return Integer.parseInt(txtMonHocId.getText());
    }
    
    @Override
    public void addQuayLaiListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    @Override
    public void addThemButtonListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    @Override
    public void addSuaButtonListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    @Override
    public void addXoaButtonListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
    }

    @Override
    public void addGanMonHocButtonListener(ActionListener listener) {
        btnGanMonHoc.addActionListener(listener);
    }

    @Override
    public void addTraCuuListener(ActionListener listener) {
    	btnXemThongTin.addActionListener(listener);
    }
    
    @Override
    public void setTableData(List<Object[]> data) {
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    @Override
    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    
    @Override
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) table.getModel();
    }
}
