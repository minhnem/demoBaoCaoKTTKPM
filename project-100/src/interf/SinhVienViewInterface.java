package interf;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public interface SinhVienViewInterface {
    // Các phương thức getter và setter
    int getId();
    void setId(int id);

    String getTen();
    void setTen(String ten);

    int getTuoi();
    void setTuoi(int tuoi);

    String getDiachi();
    void setDiachi(String diachi);

    float getDiemtb();
    void setDiemtb(float diemtb);

    // Các phương thức để thêm các listener cho các nút
    void addThemButtonListener(ActionListener listener);
    void addSuaButtonListener(ActionListener listener);
    void addXoaButtonListener(ActionListener listener);
    void addChonButtonListener(ActionListener listener);

    // Phương thức để thiết lập dữ liệu cho bảng
    void setTableData(List<Object[]> data);

    // Phương thức lấy dòng được chọn từ bảng
    int getSelectedRow();
    
    // lấy thông tin sinh viên và môn học
    
    
    DefaultTableModel getTableModel();
}
