package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.connect;

public class MonHocDAO {
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    public List<MonHoc> getAllMonHoc() throws SQLException {
        con = connect.getConnect();
        List<MonHoc> monHocList = new ArrayList<>();
        String sql = "SELECT * FROM monhoc";
        pstm = con.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next()) {
            MonHoc monHoc = new MonHoc(rs.getInt("id"), rs.getString("tenMonHoc"), rs.getInt("soTinChi"));
            monHocList.add(monHoc);
        }
        return monHocList;
    }

    public void insertMonHoc(int id, String tenMonHoc, int soTinChi) throws SQLException {
        con = connect.getConnect();
        String sql = "INSERT INTO monhoc(id, tenMonHoc, soTinChi) VALUES (?, ?, ?)";
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, tenMonHoc);
        pstm.setInt(3, soTinChi);
        pstm.executeUpdate();
    }

    public void deleteMonHoc(int id) throws SQLException {
        con = connect.getConnect();
        String sql = "DELETE FROM monhoc WHERE id = ?";
        pstm = con.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }

    public void updateMonHoc(int id, String tenMonHoc, int soTinChi) throws SQLException {
        con = connect.getConnect();
        String sql = "UPDATE monhoc SET tenMonHoc = ?, soTinChi = ? WHERE id = ?";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, tenMonHoc);
        pstm.setInt(2, soTinChi);
        pstm.setInt(3, id);
        pstm.executeUpdate();
    }
    
    // gán môn học cho sinh viên
    public void ganMonHocChoSinhVien(int sinhVienId, int monHocId) throws SQLException {
        Connection con = connect.getConnect();
        String sql = "INSERT INTO SinhVien_MonHoc (sinhVienId, monHocId) VALUES (?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, sinhVienId);
        pstm.setInt(2, monHocId);
        pstm.executeUpdate();
    }

    // Lấy danh sách môn học của sinh viên
    public List<MonHoc> getMonHocBySinhVienId(int sinhVienId) throws SQLException {
        Connection con = connect.getConnect();
        List<MonHoc> monHocList = new ArrayList<>();
        String sql = "SELECT mh.* FROM monhoc mh INNER JOIN SinhVien_MonHoc svm ON mh.id = svm.monHocId WHERE svm.sinhVienId = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, sinhVienId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            MonHoc monHoc = new MonHoc(rs.getInt("id"), rs.getString("tenMonHoc"), rs.getInt("soTinChi"));
            monHocList.add(monHoc);
        }
        return monHocList;
    }
}
