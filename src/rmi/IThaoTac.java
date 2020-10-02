/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import bean.KhoaBean;
import bean.SinhVienBean;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface IThaoTac extends Remote {
    public ArrayList<SinhVienBean> getDSSV() throws Exception ;
    
    public ArrayList<KhoaBean> getListK() throws Exception ;
    
    public boolean SuaSV(SinhVienBean sv) throws Exception;
        
    
    public boolean XoaSV(String ma) throws Exception;
        
    public boolean themSV(SinhVienBean sv) throws Exception;
        
}
