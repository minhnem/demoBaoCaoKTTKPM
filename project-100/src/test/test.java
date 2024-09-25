package test;

import view.Login;
import view.MonHocView;
import view.QuanLyView;
import view.SinhVienMonHoc;
import view.SinhVienView;
import presenter.LoginPresenter;
import presenter.MonHocPresenter;
import presenter.QuanLyPresenter;
import presenter.SVMHPresenter;
import presenter.SinhVienPresenter;

public class test {
	public static void main(String[] args) {
//		Login loginView = new Login();
//        new LoginPresenter(loginView);
		MonHocView view = new MonHocView();
		MonHocPresenter presenter = new MonHocPresenter(view);
//		SinhVienMonHoc sv = new SinhVienMonHoc();
//		new SVMHPresenter(sv);
//		SinhVienView sv = new SinhVienView();
	}
}
