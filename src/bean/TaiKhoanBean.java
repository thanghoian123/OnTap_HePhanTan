/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;

/**
 *
 * @author Thang
 */
public class TaiKhoanBean implements Serializable{
    String us,mk;

    public TaiKhoanBean() {
    }
    
    public TaiKhoanBean(String us, String mk) {
        this.us = us;
        this.mk = mk;
    }
    
    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
    
}
