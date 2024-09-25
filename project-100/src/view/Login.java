package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import interf.LoginViewInterface;

import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements LoginViewInterface {

	private DefaultTableModel model;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JButton bt1;

	public Login() {
		this.setTitle("Đăng nhập");
		this.setSize(350, 250);
		this.setLocationRelativeTo(null);

		// Tiêu đề
		JLabel lb1 = new JLabel("ĐĂNG NHẬP",  SwingConstants.CENTER);
		lb1.setFont(new Font("Serif", Font.BOLD, 20));
		lb1.setForeground(Color.WHITE);
		lb1.setOpaque(true);
		lb1.setBackground(new Color(70, 130, 180)); // Màu nền xanh dương
//		lb1.setBorder(new EmptyBorder(10, 0, 10, 0)); // Khoảng cách padding cho tiêu đề

		// Nút đăng nhập
		bt1 = new JButton("Đăng nhập");
		bt1.setFont(new Font("Serif", Font.BOLD, 14));
		bt1.setForeground(Color.WHITE);
		bt1.setBackground(new Color(60, 179, 113)); // Màu nền xanh lá
		bt1.setFocusPainted(false);
		bt1.setPreferredSize(new Dimension(120, 40));

		// Các label và text field
		JLabel lb2 = new JLabel("Tài khoản:");
		lb2.setFont(new Font("Serif", Font.PLAIN, 14));
		JLabel lb3 = new JLabel("Mật khẩu:");
		lb3.setFont(new Font("Serif", Font.PLAIN, 14));

		txtUser = new JTextField();
		txtUser.setFont(new Font("Serif", Font.PLAIN, 14));
		txtUser.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Serif", Font.PLAIN, 14));
		txtPassword.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

		// layout cho các label và các text field
		JPanel pnhienthi = new JPanel();
		pnhienthi.setLayout(new GridLayout(2, 2, 10, 10));
		pnhienthi.add(lb2);
		pnhienthi.add(txtUser);
		pnhienthi.add(lb3);
		pnhienthi.add(txtPassword);

		// Panel cho nút đăng nhập
		JPanel pnbtn = new JPanel();
		pnbtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnbtn.add(bt1);

		this.setLayout(new BorderLayout(20, 20));
        this.add(lb1, BorderLayout.NORTH);  // Tiêu đề phía trên
        this.add(pnhienthi, BorderLayout.CENTER);  // Bảng và form nhập liệu ở giữa
        this.add(pnbtn, BorderLayout.SOUTH); 
		// Tạo khoảng cách tổng thể cho khung cửa sổ
		((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Hiển thị giao diện
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public String getUsername() {
		return txtUser.getText();
	}

	@Override
	public String getPassword() {
		return new String(txtPassword.getPassword());
	}

	@Override
	public void addLoginButtonListener(ActionListener listener) {
		bt1.addActionListener(listener);
	}

	@Override
	public void showError(String message) {
		JOptionPane.showMessageDialog(this, message, "Lỗi", JOptionPane.ERROR_MESSAGE);
	}
}
