package view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import interf.SVMonHocInterface;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class SinhVienMonHoc extends JFrame implements SVMonHocInterface{
	private JTextField txtSinhVienId = new JTextField(10);  // Trường nhập ID sinh viên
    private JButton btnXemThongTin = new JButton("Xem Thông Tin");
    private JTable table;
    private DefaultTableModel model;

    public SinhVienMonHoc() {
        this.setTitle("Thông tin sinh viên và môn học");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        // Cập nhật cột chỉ gồm Id, Họ Tên, Tên Môn Học và Số Tín Chỉ
        String[] columns = {"Id sinh viên", "Họ Tên", "Tên Môn Học", "Số Tín Chỉ"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Set table row height and font
        table.setRowHeight(25);
        table.setFont(new Font("Serif", Font.PLAIN, 14));

        // Phần tiêu đề
        JLabel lblTitle = new JLabel("THÔNG TIN SINH VIÊN VÀ MÔN HỌC", JLabel.CENTER);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 20));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(70, 130, 180)); // Set màu nền xanh dương cho tiêu đề
        lblTitle.setBorder(new EmptyBorder(10, 0, 10, 0)); // Tạo khoảng trống xung quanh tiêu đề

        // Phần nhập ID sinh viên
        JPanel pnhienthi = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnhienthi.add(new JLabel("Nhập vào id sinh viên để xem thông tin:"));
        pnhienthi.add(txtSinhVienId);

        // Set font and padding for input
        txtSinhVienId.setFont(new Font("Serif", Font.PLAIN, 14));
        txtSinhVienId.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Phần bảng
        JPanel pntable = new JPanel();
        pntable.setLayout(new BorderLayout());
        pntable.add(scrollPane, BorderLayout.CENTER);

        // Nút xem thông tin
        btnXemThongTin.setFont(new Font("Serif", Font.BOLD, 14));
        btnXemThongTin.setForeground(Color.WHITE);
        btnXemThongTin.setBackground(new Color(70, 130, 180)); // Màu xanh dương
        btnXemThongTin.setFocusPainted(false);
        btnXemThongTin.setPreferredSize(new Dimension(140, 40));

        // Panel chứa bảng và trường nhập
        JPanel pngop = new JPanel(new BorderLayout(10, 10));
        pngop.setBorder(new EmptyBorder(10, 10, 10, 10)); // Tạo khoảng trống giữa các panel và biên cửa sổ
        pngop.add(pntable, BorderLayout.CENTER);
        pngop.add(pnhienthi, BorderLayout.SOUTH);

        // Panel chứa nút xem thông tin
        JPanel pnbtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnbtn.add(btnXemThongTin);

        // Layout tổng thể
        this.setLayout(new BorderLayout());
        this.add(lblTitle, BorderLayout.NORTH); // Tiêu đề ở trên cùng
        this.add(pngop, BorderLayout.CENTER); // Bảng và trường nhập ở giữa
        this.add(pnbtn, BorderLayout.SOUTH); // Nút ở dưới cùng

        // Hiển thị giao diện
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public int getSinhVienId() {
        return Integer.parseInt(txtSinhVienId.getText());
    }

    @Override
    public void addXemThongTinButtonListener(ActionListener listener) {
        btnXemThongTin.addActionListener(listener);
    }

    @Override
    public void setTableData(List<Object[]> data) {
        model.setRowCount(0);
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

}
