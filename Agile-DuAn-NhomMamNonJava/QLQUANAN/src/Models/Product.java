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
public class Product {
    private int id;
    private int id_category;
    private String tenmonan;
    private double dongia;
    private String gioithieu;
    private String anh;
    private String trangthai;

    public Product() {
    }

    public Product(int id, int id_category, String tenmonan, double dongia, String gioithieu, String anh, String trangthai) {
        this.id = id;
        this.id_category = id_category;
        this.tenmonan = tenmonan;
        this.dongia = dongia;
        this.gioithieu = gioithieu;
        this.anh = anh;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getTenmonan() {
        return tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        this.tenmonan = tenmonan;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", id_category=" + id_category + ", tenmonan=" + tenmonan + ", dongia=" + dongia + ", gioithieu=" + gioithieu + ", anh=" + anh + ", trangthai=" + trangthai + '}';
    }

    
}
