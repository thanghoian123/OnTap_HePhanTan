/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import bean.KhoaBean;
import bean.SinhVienBean;
import dao.chungDAO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class ThaoTac extends UnicastRemoteObject implements IThaoTac{

    public ThaoTac() throws Exception{}
    chungDAO dao = new chungDAO();
    @Override
    public ArrayList<SinhVienBean> getDSSV() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dao.getDSSV();
    }

    @Override
    public ArrayList<KhoaBean> getListK() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dao.getListK();
    }

    @Override
    public boolean SuaSV(SinhVienBean sv) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dao.SuaSV(sv);
    }

    @Override
    public boolean XoaSV(String ma) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dao.XoaSV(ma);
    }

    @Override
    public boolean themSV(SinhVienBean sv) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return dao.themSV(sv);
    }
    
    
    
}
