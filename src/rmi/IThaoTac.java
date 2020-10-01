/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import bean.KhoaBean;
import bean.SinhVienBean;
import bean.TaiKhoanBean;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public interface IThaoTac extends Remote{
    public ArrayList<KhoaBean> getDSKHoa() throws Exception;
    public ArrayList<SinhVienBean> getDSSV() throws Exception;
    public boolean  themSV (SinhVienBean sv) throws Exception;
    public boolean  suaSV (SinhVienBean sv) throws Exception;
    public boolean  xoaSV (String masv) throws Exception;
    public ArrayList<SinhVienBean> timSV(String ma) throws Exception;
    public ArrayList<SinhVienBean> filterTheoMaK(String ma) throws Exception ;
    
}
