package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.connect;


public class SVMonHocDAO {
	public List<Object[]> getSinhVienMonHoc(int sinhVienId) throws SQLException {
        Connection con = connect.getConnect();
        String sql = "SELECT sv.id, sv.ten, mh.tenMonHoc, mh.soTinChi FROM sinhvien sv " +
                     "INNER JOIN SinhVien_MonHoc svm ON sv.id = svm.sinhVienId " +
                     "INNER JOIN monhoc mh ON svm.monHocId = mh.id WHERE sv.id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, sinhVienId);
        ResultSet rs = pstm.executeQuery();

        List<Object[]> data = new ArrayList<>();
        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("ten"),
                rs.getString("tenMonHoc"),
                rs.getInt("soTinChi")
            };
            data.add(row);
        }
        return data;
    }
}
