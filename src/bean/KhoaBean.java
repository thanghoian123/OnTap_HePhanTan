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
public class KhoaBean implements Serializable{
    String maK, tenK;

    public KhoaBean() {
    }

    public KhoaBean(String maK, String tenK) {
        this.maK = maK;
        this.tenK = tenK;
    }

    public String getMaK() {
        return maK;
    }

    public void setMaK(String maK) {
        this.maK = maK;
    }

    public String getTenK() {
        return tenK;
    }

    public void setTenK(String tenK) {
        this.tenK = tenK;
    }
    
}
