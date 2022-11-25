/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domainmodel;

/**
 *
 * @author fptsh
 */
public class KhachHang {

    private String makh;
    private String tenkh;
    private int tuoi;
    private boolean gioiTinh;
    private String loai;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, int tuoi, boolean gioiTinh, String loai) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.loai = loai;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getGioiTinh(boolean gioiTinh) {
        return gioiTinh ? "Nam" : "Nữ";
    }

    @Override
    public String toString() {
        return "KhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + ", loai=" + loai + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{makh, tenkh, tuoi, getGioiTinh(gioiTinh), loai};
    }
    
}
