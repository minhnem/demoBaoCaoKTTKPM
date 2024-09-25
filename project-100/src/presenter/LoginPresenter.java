package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import interf.LoginViewInterface;
import model.UserDao;
import view.QuanLyView;

public class LoginPresenter {

    private LoginViewInterface view;
    private UserDao userDao;

    public LoginPresenter(LoginViewInterface view) {
        this.view = view;
        this.userDao = new UserDao();

        this.view.addLoginButtonListener(new LoginButtonListener());
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (userDao.authenticate(username, password)) {
                // Nếu xác thực thành công, mở trang SinhVienView
            	QuanLyView quanLyView = new QuanLyView();
                new QuanLyPresenter(quanLyView); // Tạo một phiên bản của SinhVienView
                ((JFrame) view).dispose(); // Đóng cửa sổ đăng nhập
            } else {
                // Hiển thị thông báo lỗi nếu xác thực không thành công
                view.showError("Tên đăng nhập hoặc mật khẩu không đúng!");
            }
        }
    }
}
