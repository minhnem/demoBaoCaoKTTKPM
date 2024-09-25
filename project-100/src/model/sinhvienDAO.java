package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.connect;

public class sinhvienDAO {
	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public List<sinhvien> getall() throws SQLException{
		con = connect.getConnect();
		List<sinhvien> all = new ArrayList<sinhvien>();
		String sql =  "select * from sinhvien";
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		while(rs.next()) {
			sinhvien sv = new sinhvien();
			sv.setId(rs.getInt("id"));
			sv.setTen(rs.getString("ten"));
			sv.setTuoi(rs.getInt("tuoi"));
			sv.setDiachi(rs.getString("diachi"));
			sv.setDiemtb(rs.getFloat("diemtb"));
			all.add(sv);
		}
		return all;
	}
	
	public sinhvien getId(int id) throws SQLException {
		con = connect.getConnect();
		sinhvien sv = new sinhvien();
		String sql = "select * from sinhvien where id = ?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		rs = pstm.executeQuery();
		while(rs.next()) {
			sv.setId(rs.getInt("id"));
			sv.setTen(rs.getString("ten"));
			sv.setTuoi(rs.getInt("tuoi"));
			sv.setDiachi(rs.getString("diachi"));
			sv.setDiemtb(rs.getFloat("diemtb"));
		}
		return sv;
	}
	
	public void insert(int id, String ten, int tuoi, String diachi, Float diemtb) throws SQLException {
		con = connect.getConnect();
		String sql = "insert into sinhvien(id, ten, tuoi, diachi, diemtb) value(?,?,?,?,?)";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2, ten);
		pstm.setInt(3, tuoi);
		pstm.setString(4, diachi);
		pstm.setFloat(5, diemtb);
		pstm.executeUpdate();
	}
	
	public void delete(int id) throws SQLException {
		con = connect.getConnect();
		String sql = "delete from sinhvien where id = ?";
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	
	public void update(int id, String ten, int tuoi, String diachi, Float diemtb) throws SQLException {
		con = connect.getConnect();
		String sql = "update sinhvien set ten = ?, tuoi = ?, diachi = ?, diemtb = ? where id= ?";
		pstm = con.prepareStatement(sql);
		pstm.setString(1, ten);
		pstm.setInt(2, tuoi);
		pstm.setString(3, diachi);
		pstm.setFloat(4, diemtb);
		pstm.setInt(5, id);
		pstm.executeUpdate();
	}
}
