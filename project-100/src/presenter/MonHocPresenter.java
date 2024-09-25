package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import interf.MonHocViewInterface;
import model.MonHoc;
import model.MonHocDAO;
import view.QuanLyView;
import view.SinhVienMonHoc;

public class MonHocPresenter {
    private MonHocViewInterface view;
    private MonHocDAO model;

    public MonHocPresenter(MonHocViewInterface view) {
        this.view = view;
        this.model = new MonHocDAO();

        this.view.addThemButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = view.getId();
                    String tenMonHoc = view.getTenMonHoc();
                    int soTinChi = view.getSoTinChi();
                    model.insertMonHoc(id, tenMonHoc, soTinChi);
                    javax.swing.JOptionPane.showMessageDialog(null, "Thêm môn học thành công!");
                    loadMonHocs();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.view.addSuaButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = view.getId();
                    String tenMonHoc = view.getTenMonHoc();
                    int soTinChi = view.getSoTinChi();
                    model.updateMonHoc(id, tenMonHoc, soTinChi);
                    loadMonHocs();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.view.addXoaButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = view.getSelectedRow();
                    if (selectedRow >= 0) {
                        int id = Integer.parseInt(view.getTableModel().getValueAt(selectedRow, 0).toString());
                        model.deleteMonHoc(id);
                        loadMonHocs();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        this.view.addGanMonHocButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int sinhVienId = view.getSinhVienId();
                    int monHocId = view.getMonHocId();
                    model.ganMonHocChoSinhVien(sinhVienId, monHocId);
                    loadMonHocs();
                    //loadMonHocBySinhVien(sinhVienId);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        this.view.addTraCuuListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SinhVienMonHoc sv = new SinhVienMonHoc();
				new SVMHPresenter(sv);
				((JFrame) view).dispose();
			}
		});
        
        this.view.addQuayLaiListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				QuanLyView sv = new QuanLyView();
				new QuanLyPresenter(sv);
				((JFrame) view).dispose();
			}
		});
        loadMonHocs();
    }

    private void loadMonHocs() {
        try {
            List<MonHoc> monHocs = model.getAllMonHoc();
            List<Object[]> data = monHocs.stream().map(mh -> new Object[]{
                mh.getId(), mh.getTenMonHoc(), mh.getSoTinChi()
            }).collect(Collectors.toList());
            view.setTableData(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadMonHocBySinhVien(int sinhVienId) {
        try {
            List<MonHoc> monHocs = model.getMonHocBySinhVienId(sinhVienId);
            List<Object[]> data = monHocs.stream().map(mh -> new Object[]{
                mh.getId(), mh.getTenMonHoc(), mh.getSoTinChi()
            }).collect(Collectors.toList());
            view.setTableData(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
