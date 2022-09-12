/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author sangtm
 */
public class Staff {
    private int id;
    private String hoten;
    private String sdt;
    private int gioitinh;
    private String diachi;
    private String taikhoan;
    private String matkhau;
    private String trangthai;

    public Staff() {
    }

    public Staff(int id, String hoten, String sdt, int gioitinh, String diachi, String taikhoan, String matkhau, String trangthai) {
        this.id = id;
        this.hoten = hoten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", hoten=" + hoten + ", sdt=" + sdt + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", trangthai=" + trangthai + '}';
    }


}
