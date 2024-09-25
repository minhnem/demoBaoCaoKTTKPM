package model;

public class MonHoc {
    private int id;
    private String tenMonHoc;
    private int soTinChi;

    public MonHoc(int id, String tenMonHoc, int soTinChi) {
        this.id = id;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
