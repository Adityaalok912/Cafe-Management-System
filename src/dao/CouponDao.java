/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Coupon;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author romit
 */
public class CouponDao {
    
    public static ArrayList<Coupon> getAllCuppon(){
        ArrayList<Coupon> cuppons = new ArrayList();
        
        try{
            
            
            String query = "select * from coupon where status='True'";
            
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Coupon cup = new Coupon();
                
                cup.setId(rs.getString("id"));
                cup.setAmount(rs.getString("amount"));
                cup.setStatus("True");
                
                cuppons.add(cup);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return cuppons;
    }

    public static void save(Coupon i) {
        
        String query="insert into coupon values('"+i.getId()+"','"+i.getAmount()+"','true')";
        DbOperations.setDataOrDelete(query, "");
    }

    public static void delete(String id) {
        String query = "delete from coupon where id='"+id+"'";
        DbOperations.setDataOrDelete(query, "Deleted!!");
        
    }
    
}
