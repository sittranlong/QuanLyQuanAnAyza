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
public class Bill {
    private int id;
    private int id_customer;
    private int id_staff;
    private Date ngayban;
    private double thanhtoan;

    public Bill() {
    }

    public Bill(int id_customer, int id_staff, Date ngayban, double thanhtoan) {
        this.id_customer = id_customer;
        this.id_staff = id_staff;
        this.ngayban = ngayban;
        this.thanhtoan = thanhtoan;
    }
    
    

    public Bill(int id, int id_staff, Date ngayban) {
        this.id = id;
        this.id_staff = id_staff;
        this.ngayban = ngayban;
    }
    
    public Bill(int id, int id_customer, int id_staff, Date ngayban, double thanhtoan) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_staff = id_staff;
        this.ngayban = ngayban;
        this.thanhtoan = thanhtoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_staff() {
        return id_staff;
    }

    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    public Date getNgayban() {
        return ngayban;
    }

    public void setNgayban(Date ngayban) {
        this.ngayban = ngayban;
    }

    public double getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(double thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", id_customer=" + id_customer + ", id_staff=" + id_staff + ", ngayban=" + ngayban + ", thanhtoan=" + thanhtoan + '}';
    }

}
