/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class SinhVienBean implements Serializable{
    Date ngaySinh ;
    String maSV,ten,gioiTinh,maK;
    float dtb;

    public SinhVienBean() {
    }

    public SinhVienBean(Date ngaySinh, String maSV, String ten, String gioiTinh, String maK, float dtb) {
        this.ngaySinh = ngaySinh;
        this.maSV = maSV;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.maK = maK;
        this.dtb = dtb;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaK() {
        return maK;
    }

    public void setMaK(String maK) {
        this.maK = maK;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }
    
    
}
