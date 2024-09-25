package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.sinhvien;
import model.sinhvienDAO;
import view.MonHocView;
import view.QuanLyView;
import view.SinhVienView;

public class QuanLyPresenter {
	private QuanLyView view;
	private sinhvienDAO model;
	
	public QuanLyPresenter(QuanLyView view) {
		this.view = view;
		this.model = new sinhvienDAO();
        //loadSinhViens();
        
        this.view.addQuanlySVButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SinhVienPresenter(new SinhVienView());
                view.dispose(); 
            }
        }); 
        
        this.view.addQuanlyMHButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MonHocPresenter(new MonHocView());
                view.dispose(); 
            }
        });
	}
	
//	private void loadSinhViens() {
//        try {
//        	 List<sinhvien> sinhviens = model.getall();
//             List<Object[]> data = new ArrayList<>();
//             for (sinhvien sv : sinhviens) {
//                 data.add(new Object[]{sv.getId(), sv.getTen(), sv.getTuoi(), sv.getDiachi(), sv.getDiemtb()});
//             }
//             view.setTableData(data);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
	
}
