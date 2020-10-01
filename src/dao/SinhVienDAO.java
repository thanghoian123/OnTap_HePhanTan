/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.SinhVienBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class SinhVienDAO  {
    public ArrayList<SinhVienBean> getDSSV() throws Exception {
        ArrayList<SinhVienBean> list = new ArrayList<>();
        FileReader fr = new FileReader("SinhVien.txt");
        BufferedReader br = new BufferedReader(fr);
        while(true){
            String str = br.readLine();
            if(str==null||str=="") break;
            String[] st = str.split(";");
            String maSV = st[0];
            String tenSV = st[1];
            String ngaySinh = st[2];
            String maK = st[3];
            boolean gioiTinh;
            if(st[4].equals("nam")){
                gioiTinh = true;
            }else{
                gioiTinh = false;
            }
            
            
            SinhVienBean sv = new SinhVienBean(maSV, tenSV, ngaySinh, maK, gioiTinh);
            list.add(sv);
        }
        return list;
    }
    
    public ArrayList<SinhVienBean> timSV(String ma) throws Exception {
        ArrayList<SinhVienBean> list = getDSSV();
        ArrayList<SinhVienBean> newlist = new ArrayList<>();
        for (SinhVienBean s : list) {
            if(s.getMaSV().equals(ma)) newlist.add(s);
        }
        
        return newlist;
    }
    
    public ArrayList<SinhVienBean> filterTheoMaK(String ma) throws Exception {
        ArrayList<SinhVienBean> list = getDSSV();
        ArrayList<SinhVienBean> newlist = new ArrayList<>();
        for (SinhVienBean s : list) {
            if(s.getMaK().equals(ma)) newlist.add(s);
        }        
        return newlist;
    }
    
    public boolean  themSV (SinhVienBean sv) throws Exception{
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File f = new File("SinhVien.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            String gioitinh = "nu";
            if(sv.isGioiTinh()){
                gioitinh = "nam";
            }
            String data = sv.getMaSV()+";"+sv.getHoTen()+";"+sv.getNgaySinh()+";"+sv.getMaK()+";"+gioitinh+"\n";
            System.out.println(data);
            fw = new FileWriter(f.getAbsoluteFile(),true);
            bw = new BufferedWriter(fw);
            bw.append(data);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null) bw.close();
                if(fw!=null) fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return false;
       
    }
    
    public int tim(String ma,ArrayList<SinhVienBean>list) throws Exception{
        int index = 0;
        for (SinhVienBean sv : list) {
            if(sv.getMaSV().equals(ma)) return index;
            index++;
        }
        return -1;
    }
    
    public boolean  suaSV (SinhVienBean sv) throws Exception{
        BufferedWriter bw = null;
        FileWriter fw = null;
        ArrayList<SinhVienBean>list = getDSSV();
        int index = tim(sv.getMaSV(), list);
        try {
            File f = new File("SinhVien.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            if(index != -1){
                list.set(index, sv);
                fw = new FileWriter(f.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                for (SinhVienBean s : list) {
                    String gioitinh = "nu";
                    if(s.isGioiTinh()){
                        gioitinh = "nam";
                    }
                    String data = s.getMaSV()+";"+s.getHoTen()+";"+s.getNgaySinh()+";"+s.getMaK()+";"+gioitinh+"\n";
                    bw.append(data);
                }               
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null) bw.close();
                if(fw!=null) fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return false;       
    }
    
    public boolean  xoaSV (String maSV) throws Exception{
        BufferedWriter bw = null;
        FileWriter fw = null;
        ArrayList<SinhVienBean>list = getDSSV();
        int index = tim(maSV, list);
        try {
            File f = new File("SinhVien.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            if(index != -1){
                list.remove(index);
                fw = new FileWriter(f.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                for (SinhVienBean s : list) {
                    String gioitinh = "nu";
                    if(s.isGioiTinh()){
                        gioitinh = "nam";
                    }
                    String data = s.getMaSV()+";"+s.getHoTen()+";"+s.getNgaySinh()+";"+s.getMaK()+";"+gioitinh+"\n";
                    bw.append(data);
                }               
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null) bw.close();
                if(fw!=null) fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        return false;       
    }
    
    
}
