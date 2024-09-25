package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import interf.SinhVienViewInterface;
 
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SinhVienView extends JFrame implements SinhVienViewInterface{
    private JTextField txtId = new JTextField(15);
    private JTextField txtTen = new JTextField(15);
    private JTextField txtTuoi = new JTextField(15);
    private JTextField txtDiachi = new JTextField(15);
    private JTextField txtDiemtb = new JTextField(15);
    private JButton btnThem = new JButton("Thêm");
    private JButton btnSua = new JButton("Sửa");
    private JButton btnXoa = new JButton("Xóa");
    private JButton btnChon = new JButton("Chọn");
    private JTable table;
    private DefaultTableModel model;

    public SinhVienView() {
    	// Thiết lập tiêu đề cửa sổ
        this.setTitle("Quản lý sinh viên");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);  // Cửa sổ hiển thị giữa màn hình

        // Tiêu đề cho giao diện
        JLabel lb1 = new JLabel("QUẢN LÝ SINH VIÊN", SwingConstants.CENTER);
        lb1.setFont(new Font("Serif", Font.BOLD, 28));
        lb1.setForeground(Color.WHITE);
        lb1.setOpaque(true);
        lb1.setBackground(new Color(70, 130, 180));
        lb1.setPreferredSize(new Dimension(this.getWidth(), 50));

        // Các cột cho bảng dữ liệu sinh viên
        String[] columns = {"Id", "Tên", "Tuổi", "Địa chỉ", "Điểm TB"};
        model = new DefaultTableModel(columns, 0);
        
        // Tạo bảng và thêm nó vào trong JScrollPane
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(650, 150));

        // Panel chứa bảng dữ liệu
        JPanel pntable = new JPanel();
        pntable.add(scrollPane);

        // Tạo và căn chỉnh cho các trường nhập thông tin sinh viên
        JPanel pnhienthi = new JPanel(new GridLayout(5, 2, 10, 10));
        pnhienthi.add(new JLabel("Nhập id sinh viên:"));
        pnhienthi.add(txtId);
        pnhienthi.add(new JLabel("Nhập tên sinh viên:"));
        pnhienthi.add(txtTen);
        pnhienthi.add(new JLabel("nhập tuổi sinh viên:"));
        pnhienthi.add(txtTuoi);
        pnhienthi.add(new JLabel("Nhập địa chỉ:"));
        pnhienthi.add(txtDiachi);
        pnhienthi.add(new JLabel("Nhập vào điểm TB:"));
        pnhienthi.add(txtDiemtb);

        // Tạo panel chứa bảng và form nhập liệu
        JPanel pngop = new JPanel(new BorderLayout(10, 10));
        pngop.add(pntable, BorderLayout.NORTH);
        pngop.add(pnhienthi, BorderLayout.CENTER);

        // Tạo các nút chức năng với kích thước và màu sắc tùy chỉnh
        btnThem.setBackground(new Color(60, 179, 113));
        btnThem.setForeground(Color.WHITE);
        btnThem.setPreferredSize(new Dimension(100, 40));

        btnSua.setBackground(new Color(60, 179, 113));
        btnSua.setForeground(Color.WHITE);
        btnSua.setPreferredSize(new Dimension(100, 40));

        btnXoa.setBackground(new Color(220, 20, 60));
        btnXoa.setForeground(Color.WHITE);
        btnXoa.setPreferredSize(new Dimension(100, 40));

        btnChon.setBackground(new Color(255, 140, 0));
        btnChon.setForeground(Color.WHITE);
        btnChon.setPreferredSize(new Dimension(100, 40));

        // Panel chứa các nút chức năng
        JPanel pnbtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pnbtn.add(btnThem);
        pnbtn.add(btnSua);
        pnbtn.add(btnXoa);
        pnbtn.add(btnChon);

        // Thiết lập bố cục tổng thể cho JFrame
        this.setLayout(new BorderLayout(20, 20));
        this.add(lb1, BorderLayout.NORTH);  // Tiêu đề phía trên
        this.add(pngop, BorderLayout.CENTER);  // Bảng và form nhập liệu ở giữa
        this.add(pnbtn, BorderLayout.SOUTH);  // Nút chức năng ở dưới

        // Tạo đường viền tổng thể cho cửa sổ
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Hiển thị giao diện
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Các phương thức getter cho các JTextField
    @Override
    public int getId() {
        return Integer.parseInt(txtId.getText());
    }

    @Override
    public void setId(int id) {
        txtId.setText(String.valueOf(id));
    }

    @Override
    public String getTen() {
        return txtTen.getText();
    }

    @Override
    public void setTen(String ten) {
        txtTen.setText(ten);
    }

    @Override
    public int getTuoi() {
        return Integer.parseInt(txtTuoi.getText());
    }

    @Override
    public void setTuoi(int tuoi) {
        txtTuoi.setText(String.valueOf(tuoi));
    }

    @Override
    public String getDiachi() {
        return txtDiachi.getText();
    }

    @Override
    public void setDiachi(String diachi) {
        txtDiachi.setText(diachi);
    }

    @Override
    public float getDiemtb() {
        return Float.parseFloat(txtDiemtb.getText());
    }

    @Override
    public void setDiemtb(float diemtb) {
        txtDiemtb.setText(String.valueOf(diemtb));
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
    public void addChonButtonListener(ActionListener listener) {
        btnChon.addActionListener(listener);
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
