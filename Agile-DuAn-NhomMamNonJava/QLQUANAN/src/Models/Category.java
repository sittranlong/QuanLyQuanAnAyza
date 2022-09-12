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
public class Category {
    private int id;
    private String tendanhmuc;
    private String trangthai;

    public Category() {
    }

    public Category(int id, String tendanhmuc, String trangthai) {
        this.id = id;
        this.tendanhmuc = tendanhmuc;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
    

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", tendanhmuc=" + tendanhmuc + ", trangthai=" + trangthai + '}';
    }
    
    
}
