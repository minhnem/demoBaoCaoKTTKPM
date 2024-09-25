package interf;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public interface MonHocViewInterface {
    int getId();
    void setId(int id);

    String getTenMonHoc();
    void setTenMonHoc(String tenMonHoc);

    int getSoTinChi();
    void setSoTinChi(int soTinChi);

    int getSinhVienId();  // Lấy ID của sinh viên
    int getMonHocId();  // Lấy ID của môn học

    void addQuayLaiListener(ActionListener listener);
    void addThemButtonListener(ActionListener listener);
    void addSuaButtonListener(ActionListener listener);
    void addXoaButtonListener(ActionListener listener);
    void addGanMonHocButtonListener(ActionListener listener);  // Thêm nút gán môn học
    void addTraCuuListener(ActionListener listener);

    void setTableData(List<Object[]> data);

    int getSelectedRow();
    
    DefaultTableModel getTableModel();
}
