package interf;

import java.awt.event.ActionListener;
import java.util.List;

public interface SVMonHocInterface {
	int getSinhVienId();  // Lấy ID sinh viên để xem thông tin

    void addXemThongTinButtonListener(ActionListener listener);  // Nút xem thông tin sinh viên

    void setTableData(List<Object[]> data);  // Hiển thị dữ liệu trên bảng
}
