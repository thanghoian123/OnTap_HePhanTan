/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import bean.KhoaBean;
import bean.SinhVienBean;
import bean.TaiKhoanBean;
import dao.KhoaDAO;
import dao.SinhVienDAO;
import dao.TaiKhoanDAO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class ThaoTac extends UnicastRemoteObject implements IThaoTac{

    public ThaoTac() throws Exception{
    }
    KhoaDAO khoa = new KhoaDAO();
    SinhVienDAO svdao = new SinhVienDAO();
    @Override
    public ArrayList<KhoaBean> getDSKHoa() throws Exception {
        return khoa.getDSKHoa();
    }

    @Override
    public ArrayList<SinhVienBean> getDSSV() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.getDSSV();
    }

    @Override
    public boolean themSV(SinhVienBean sv) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.themSV(sv);
    }

    @Override
    public boolean suaSV(SinhVienBean sv) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.suaSV(sv);
    }

    @Override
    public boolean xoaSV(String masv) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.xoaSV(masv);
    }

    @Override
    public ArrayList<SinhVienBean> timSV(String ma) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.timSV(ma);
    }

    @Override
    public ArrayList<SinhVienBean> filterTheoMaK(String ma) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return svdao.filterTheoMaK(ma);
    }
    
}
