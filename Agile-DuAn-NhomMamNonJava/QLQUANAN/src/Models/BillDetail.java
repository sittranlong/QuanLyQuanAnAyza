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
public class BillDetail {
    private int id;
    private int id_bill;
    private int id_product;
    private int soluong;
    private double dongia;
    private double tongtien;

    public BillDetail(int id, int id_bill, int id_product, int soluong, double dongia) {
        this.id = id;
        this.id_bill = id_bill;
        this.id_product = id_product;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tongtien = this.soluong * this.dongia;
    }

    public BillDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getTongtien() {
        return tongtien;
    }
    
    public void setTongtien() {
        this.tongtien = getDongia() * getSoluong();
    }

    @Override
    public String toString() {
        return "BillDetail{" + "id=" + id + ", id_bill=" + id_bill + ", id_product=" + id_product + ", soluong=" + soluong + ", dongia=" + dongia + ", tongtien=" + tongtien + '}';
    }
  
    
}
