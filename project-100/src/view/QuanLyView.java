package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import interf.QuanLyViewInterface;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class QuanLyView extends JFrame implements QuanLyViewInterface{
    private JButton btnThem = new JButton("Quản lý thông sinh viên");
    private JButton btnSua = new JButton("Quản lý môn học");
    private JButton btnXoa = new JButton("===========");
//    private JTable table;
//    private DefaultTableModel model;

    public QuanLyView() {
        this.setTitle("Quản lý Sinh Viên");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(240, 248, 255)); // Màu nền sáng

        // Tiêu đề
        JLabel lb1 = new JLabel("HỆ THỐNG QUẢN LÝ SINH VIÊN", SwingConstants.CENTER);
        lb1.setFont(new Font("Arial", Font.BOLD, 20));
        lb1.setForeground(new Color(34, 139, 34)); // Màu chữ tiêu đề

        // Tạo các nút với màu sắc
        customizeButton(btnThem);
        customizeButton(btnSua);
        customizeButton(btnXoa);

        // Layout cho các nút chức năng
        JPanel pnbtn = new JPanel();
        pnbtn.setLayout(new GridLayout(3, 1, 10, 10)); // Sử dụng GridLayout để bố trí các nút
        pnbtn.add(btnThem);
        pnbtn.add(btnSua);
        pnbtn.add(btnXoa);
        pnbtn.setBackground(new Color(240, 248, 255)); // Màu nền cho panel chứa nút

        // Thiết lập bố cục cho JFrame
        this.setLayout(new BorderLayout());
        this.add(lb1, BorderLayout.NORTH);
        this.add(pnbtn, BorderLayout.CENTER);

        // Thêm khoảng cách cho khung
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // Màu nền cho nút
        button.setForeground(Color.WHITE); // Màu chữ nút
        button.setFont(new Font("Arial", Font.BOLD, 16)); // Định dạng chữ
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Khoảng cách bên trong nút
        button.setFocusPainted(false); // Không hiển thị viền khi chọn
    }


    @Override
    public void addQuanlySVButtonListener(ActionListener listener) {
        btnThem.addActionListener(listener);
    }

    @Override
    public void addQuanlyMHButtonListener(ActionListener listener) {
        btnSua.addActionListener(listener);
    }

    @Override
    public void addXoaButtonListener(ActionListener listener) {
        btnXoa.addActionListener(listener);
    }

//    @Override
//    public void setTableData(List<Object[]> data) {
//        model.setRowCount(0); // Xóa các dòng hiện tại
//        for (Object[] row : data) {
//            model.addRow(row); // Thêm từng dòng dữ liệu
//        }
//    }

//    @Override
//    public int getSelectedRow() {
//        return table.getSelectedRow();
//    }
//
//    // Lấy mô hình của bảng
//    @Override
//    public DefaultTableModel getTableModel() {
//        return (DefaultTableModel) table.getModel();
//    }
}

