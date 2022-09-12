/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author sangtm
 */
public class Customer {
    private int id;
    private String hoten;
    private String sdt;
    private int gioitinh;
    private String diachi;
    private String trangthai;

    public Customer(int id, String hoten, String sdt, int gioitinh, String diachi, String trangthai) {
        this.id = id;
        this.hoten = hoten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.trangthai = trangthai;
    }

    public Customer() {
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", hoten=" + hoten + ", sdt=" + sdt + ", gioitinh=" + gioitinh + ", diachi=" + diachi + ", trangthai=" + trangthai + '}';
    }
    
}
