/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.KhoaBean;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Thang
 */
public class KhoaDAO {
    public ArrayList<KhoaBean> getDSKHoa() throws Exception{
       ArrayList<KhoaBean> list = new ArrayList<>();
       FileReader fr = new FileReader("khoa.txt");
       BufferedReader br = new BufferedReader(fr);
       while(true){
           String str = br.readLine();
           if(str==null || str =="") break;
           String[] st = str.split(";");
           String maK = st[0];
           String tenK = st[1];
           KhoaBean kh = new KhoaBean(maK, tenK);
           list.add(kh);
       }
       return list;
    }
}
