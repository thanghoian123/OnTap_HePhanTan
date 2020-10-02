/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.KhoaBean;
import bean.SinhVienBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thang
 */
public class chungDAO {
    ArrayList<SinhVienBean> listSV = new ArrayList<>();
    ArrayList<KhoaBean> listK = new ArrayList<>();

    public chungDAO() throws IOException {
        BufferedReader brK = null;
        BufferedReader brSV = null;
        try {
            brK= new BufferedReader(new FileReader("khoa.txt"));
            brSV = new BufferedReader(new FileReader("sinhvien.txt"));
            while(true){
                String str = brK.readLine();
                if(str==null||str=="") break;
                String [] st = str.split(";");
                listK.add(new KhoaBean(st[0], st[1]));
            }
            
             while(true){
                String str = brSV.readLine();
                if(str==null||str=="") break;
                String [] st = str.split(";");
                Date ngaysinh = stringToDate(st[2]);
                String masv = st[0];
                String ten = st[1];
                String gioitinh = st[3];
                float dtb = Float.parseFloat(st[4]);
                String mak = st[5];
                listSV.add(new SinhVienBean(ngaysinh, masv, ten, gioitinh, mak, dtb));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            brK.close();
            brSV.close();
        }
    }
    
    public Date stringToDate (String ngaySinh) throws ParseException{
        Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh); 
        return date1;
    }
    
    
    public ArrayList<SinhVienBean> getDSSV() throws Exception{
        return listSV;
    }
    
    public ArrayList<KhoaBean> getListK() throws Exception{
        return listK;
    }
    
    
    
    public boolean themSV(SinhVienBean sv) throws Exception{
        int index = findByMa(sv.getMaSV());
        System.out.println(index);
        if(index==-1){
            listSV.add(sv);
            return LoadFile();
        }else{
            return false;
        }
    }
    
    public boolean SuaSV(SinhVienBean sv) throws Exception{
        int index = findByMa(sv.getMaSV());
        if(index!=-1){
            listSV.set(index, sv);
            return LoadFile();
        }else{
            return false;
        }
    }
    
    public boolean XoaSV(String ma) throws Exception{
        int index = findByMa(ma);
        if(index!=-1){
            listSV.remove(index);
            return LoadFile();
        }else{
            return false;
        }
    }

    private int findByMa(String maSV) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        int i = 0;
        for (SinhVienBean sv : listSV) {
            if(sv.getMaSV().equals(maSV)) return i;
            i++;
        }
        return -1;
    }

    private boolean LoadFile() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        FileWriter fw= null;
        BufferedWriter bw = null;
        try {
            File f = new File("sinhvien.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            for (SinhVienBean sv : listSV) {
                String dtb = sv.getDtb()+"";
                String data = sv.getMaSV()+";"+sv.getTen()+";"+dateToString(sv.getNgaySinh())+";"+sv.getGioiTinh()+";"+dtb+";"+sv.getMaK()+"\n";
                System.out.println(data);
                bw.append(data);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(chungDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
    }
    
    private String getMaKh(String tenK) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (KhoaBean k : listK) {
            if(k.getTenK().equals(tenK)) return k.getMaK();
        }
        return null;
    }

    private String dateToString(Date ngaySinh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        String x = df.format(ngaySinh);
        return x;
    }
}
