/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TaiKhoanBean;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class TaiKhoanDAO {
    public ArrayList<TaiKhoanBean> getTaiKhoan()throws Exception{
        ArrayList<TaiKhoanBean> list = new ArrayList<>();
        FileReader f = new FileReader("data.txt");
        BufferedReader r = new BufferedReader(f);
        while(true){
            String str = r.readLine();
            System.out.println(str);
            if(str == null || str =="") break;
            String [] st = str.split(";");
            String un = st[0];
            String pass = st[1];
            TaiKhoanBean tk = new TaiKhoanBean(un, pass);
            list.add(tk);
        }
        return list;
    }
    
    public boolean themTK(TaiKhoanBean tk) throws Exception{
        BufferedWriter bw = null;
        FileWriter fw = null;
        ArrayList<TaiKhoanBean> list = getTaiKhoan();
        try {
            String data=null;
            if(list.size()==0){
                System.out.println("");
                data =tk.getUs().toString()+";"+tk.getMk().toString()+"\n";
            }else{
                data =tk.getUs().toString()+";"+tk.getMk().toString()+"\n";
            }
            System.out.println(data+"data");
            File file = new File("data.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.append(data);
            System.out.println("them thanh cong");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean xoa(String un) throws Exception{
        BufferedWriter bw = null;
        FileWriter fw = null;
        ArrayList<TaiKhoanBean> list = getTaiKhoan();
        
        try {
            int index = tim(un, list);
            if(index != -1){
                list.remove(index);                
                File file = new File("data.txt");
                if(!file.exists()){
                    file.createNewFile();
                }
                fw = new FileWriter(file.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                for (TaiKhoanBean tk : list) {
                    String st = tk.getUs()+";"+tk.getMk()+"\n";
                    bw.append(st);
                }
                return true;
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean sua(TaiKhoanBean tk) throws Exception{
        ArrayList<TaiKhoanBean> list = getTaiKhoan();
        BufferedWriter bw = null;
        FileWriter fw = null;
       
        try {
            int index = tim(tk.getUs(), list);
            if(index!=-1){
//                System.out.println(index+"index");
                list.set(index, tk);
//                System.out.println(list.get(index).toString()+"asdasd");
                File f = new File("data.txt");
                if(!f.exists()){
                    f.createNewFile();
                }
                fw = new FileWriter(f.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                for (TaiKhoanBean i : list) {
                    String a = i.getUs()+";"+i.getMk()+"\n";
                    bw.append(a);
                }
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public int tim(String un,ArrayList<TaiKhoanBean> list) throws Exception{
        int index =0;
        for (TaiKhoanBean tk : list) {
            if(tk.getUs().equals(un)){
                return index;
            }
            index++;
        }
        return -1;
    }
    
}
