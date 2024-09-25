package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import interf.SinhVienViewInterface;
import model.sinhvien;

import model.sinhvienDAO;

public class SinhVienPresenter {
    private SinhVienViewInterface view;
    private sinhvienDAO model;

    public SinhVienPresenter(SinhVienViewInterface view) {
        this.view = view;
        this.model = new sinhvienDAO();

        this.view.addThemButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = view.getId();
                    String ten = view.getTen();
                    int tuoi = view.getTuoi();
                    String diachi = view.getDiachi();
                    float diemtb = view.getDiemtb();
                    model.insert(id, ten, tuoi, diachi, diemtb);
                    loadSinhViens();
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
                    String ten = view.getTen();
                    int tuoi = view.getTuoi();
                    String diachi = view.getDiachi();
                    float diemtb = view.getDiemtb();
                    model.update(id, ten, tuoi, diachi, diemtb);
                    loadSinhViens();
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
                        model.delete(id);
                        loadSinhViens();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        this.view.addChonButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.getSelectedRow();
                if (selectedRow >= 0) {
                    int id = Integer.parseInt(view.getTableModel().getValueAt(selectedRow, 0).toString());
                    try {
                        sinhvien sv = model.getId(id);
                        view.setId(sv.getId());
                        view.setTen(sv.getTen());
                        view.setTuoi(sv.getTuoi());
                        view.setDiachi(sv.getDiachi());
                        view.setDiemtb(sv.getDiemtb());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        loadSinhViens();
    }

    private void loadSinhViens() {
    	 try {
             List<sinhvien> sinhviens = model.getall();
             List<Object[]> data = sinhviens.stream().map(s -> new Object[]{
                 s.getId(), s.getTen(), s.getTuoi(), s.getDiachi(), s.getDiemtb()
             }).collect(Collectors.toList());
             view.setTableData(data);
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    }
}
