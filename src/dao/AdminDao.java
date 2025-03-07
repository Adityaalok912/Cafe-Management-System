/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Admin;
/**
 *
 * @author romit
 */
public class AdminDao {
    public static void addAdmin(Admin admin){
        String query="insert into admin(id,password) values('"+admin.getId()+"','"+admin.getPassword()+"')";
        DbOperations.setDataOrDelete(query, "");
    }
    public static Admin login(String id,String password){
        Admin admin=null;
        try{
            ResultSet rs = DbOperations.getData("select * from admin where id='"+id+"' and password='"+password+"'");
            while(rs.next()){
                admin =new Admin();
                
                
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return admin;
    }
    public static void add(String id,String password){
        String query ="insert into admin values('"+id+"','"+password+"')";
        DbOperations.setDataOrDelete(query, "new admin added");
    }
    
    public static boolean getsuperadmin(String id){
        
        
        try{
            ResultSet rs = DbOperations.getData("select * from superadmin");
            
            while(rs.next()){
                String sid=rs.getString("id");
                if(id.equals(sid)){
                    return true;
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        
        return false;
    }
    
    public static ArrayList<Admin> getalladmins(){
        ArrayList<Admin> admins= new ArrayList();
        
        try{
            ResultSet rs = DbOperations.getData("select * from admin where id not in (select id from superadmin);");
            
            while(rs.next()){
                Admin adm = new Admin();
                String id = rs.getString("id");
                String pass = rs.getString("password");
                
                adm.setId(id);
                adm.setPassword(pass);
                
                admins.add(adm);
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return admins;
    }

    public static void delete(String id) {
        
       String query = "delete from admin where id='"+id+"'";
       DbOperations.setDataOrDelete(query, "deleted");
    }
    
    
    
}
