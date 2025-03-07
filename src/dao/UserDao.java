/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class UserDao {
    public static void save(User user){
        String query="insert into user(name,email,phoneNumber,password,securityQuestion,answer,status) values ('"+user.getName()+"','"+user.getEmail()+"','"+user.getPhone()+"','"+user.getPassword()+"','"+user.getSecurityquestion()+"','"+user.getSecurityanswer()+"','true')";
        DbOperations.setDataOrDelete(query,"Registered Successfully!");
        
    }
    public static User login(String email,String password){
        User user=null;
        try{
            ResultSet rs=DbOperations.getData("select * from user where email='"+email+"'and password='"+password+"'");
            while(rs.next())
            {
                user=new User();
                user.setStatus(rs.getString("status"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    public static User reset(String email){
        User user=null;
        try{
            ResultSet rs=DbOperations.getData("select * from user where email='"+email+"'");
            while(rs.next())
            {
                user=new User();
                user.setSecurityquestion(rs.getString("securityquestion"));
                user.setSecurityanswer(rs.getString("securityanswer"));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    public static void update(String email,String newpassword){
        String query="update user set password='"+newpassword+"'where email='"+email+"'";
        DbOperations.setDataOrDelete(query,"Password changed Successfully!");
    }
    public static User getUser(String email){
        String query="select * from user where email='"+email+"'";
        User u = new User();
        try{
            ResultSet rs=DbOperations.getData(query);
        while(rs.next()){
            u.setName(rs.getString("name"));
            u.setPhone(rs.getString("phoneNumber"));
            u.setSecurityanswer(rs.getString("answer"));
            u.setSecurityquestion(rs.getString("securityQuestion"));
            
            
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return u;
        
    }
    
    public static boolean validateUserPass(String email,String password ){
        String query="select * from user where email='"+email+"' and password='"+password+"'";
        try{
            ResultSet rs=DbOperations.getData(query);
            while(rs.next()){
                return true;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       
        return false;
    }
    
    public static boolean updateProfile(User user){
        if(validateUserPass(user.getEmail(), user.getPassword())){
            String query="update user set phoneNumber='"+user.getPhone()+"',name='"+user.getName()+"',securityQuestion='"+user.getSecurityquestion()+"',answer='"+user.getSecurityanswer()+"' WHERE email='"+user.getEmail()+"' ";
            DbOperations.setDataOrDelete(query, "profile Updated");
            
            return true;
            
        }else{
            return false;
        }
        
    }
   
}
