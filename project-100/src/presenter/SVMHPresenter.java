package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import interf.SVMonHocInterface;
import model.SVMonHocDAO;

public class SVMHPresenter {
	private SVMonHocInterface view;
    private SVMonHocDAO model;

    public SVMHPresenter(SVMonHocInterface view) {
        this.view = view;
        this.model = new SVMonHocDAO();

        // Xử lý khi nhấn nút xem thông tin sinh viên và các môn học
        this.view.addXemThongTinButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sinhVienId = view.getSinhVienId();
				loadSinhVienMonHoc(sinhVienId);
            }
        });
    }

    private void loadSinhVienMonHoc(int sinhVienId) {
        try {
            List<Object[]> data = model.getSinhVienMonHoc(sinhVienId);
            view.setTableData(data);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
