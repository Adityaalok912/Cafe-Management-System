/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.Order;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import model.UserCart;

/**
 *
 * @author romit
 */
public class OrderDao {
    
    public static void  changeStatus(String id,String name){
        String query = "update orderdata set status='completed' where id='"+id+"' and item_name='"+name+"' ";
        DbOperations.setDataOrDelete(query, "");
    }
    public static String getid(){
        int id=1;
        String idd="";
        try{
            ResultSet rs = DbOperations.getData("select max(id) from orderinfo");
            if(rs.next()){
                idd=rs.getString("max(id)");
                id=Integer.parseInt(idd);
                id=id+1;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
        
    }
    public static void saveinfo(Order order){
        String query="insert into orderinfo values('"+order.getOrder_id()+"','"+order.getEmail()+"','"+order.getOfferid()+"','"+order.getCupponid()+"','"+order.getTotalsum()+"','"+order.getPrefrence()+"')";
        DbOperations.setDataOrDelete(query, "");
    }
    public static void savedata(Order order){
        
        String Q1="insert into orderdata values('"+order.getOrder_id()+"','"+order.getItem_name()+"','"+order.getPrice()+"','"+order.getQuantity()+"','"+order.getStatus()+"','"+order.getDate()+"')";
        
        DbOperations.setDataOrDelete(Q1, "");
        
    }
    
    public static ArrayList<Order> getallorder(String email){
        
        ArrayList<Order> ordd=new ArrayList();
        
        try{
            String query="select od.*,oi.offerId,oi.coupon,oi.totalsum,oi.prefrence  from orderinfo oi join orderdata od ON oi.id=od.id where oi.email='"+email+"'" ;

            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                Order o =new Order();
                o.setOrder_id(rs.getString("id"));
                o.setItem_name(rs.getString("item_name"));
                o.setQuantity(rs.getString("quantity"));
                o.setPrice(rs.getString("price"));
                o.setDate(rs.getString("date"));
                o.setStatus(rs.getString("status"));
                o.setTotalsum(rs.getString("totalsum"));
                o.setPrefrence(rs.getString("prefrence"));
                o.setCupponid(rs.getString("coupon"));
                o.setOfferid(rs.getString("offerId"));
                
                
                ordd.add(o);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return ordd;
        
    }
    public static ArrayList<Order> getAllorders(){
        
        ArrayList<Order> ordd=new ArrayList();
        
        try{
            String query="select od.*,oi.offerId,oi.coupon,oi.totalsum,oi.prefrence,oi.email  from orderinfo oi join orderdata od ON oi.id=od.id " ;

            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                Order o =new Order();
                o.setOrder_id(rs.getString("id"));
                o.setItem_name(rs.getString("item_name"));
                o.setQuantity(rs.getString("quantity"));
                o.setPrice(rs.getString("price"));
                o.setDate(rs.getString("date"));
                o.setStatus(rs.getString("status"));
                o.setTotalsum(rs.getString("totalsum"));
                o.setPrefrence(rs.getString("prefrence"));
                o.setCupponid(rs.getString("coupon"));
                o.setOfferid(rs.getString("offerId"));
                o.setEmail(rs.getString("email"));
                
                
                ordd.add(o);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return ordd;
        
    }
    public static void saveOrder(String email,ArrayList<UserCart> usercart,String cupponid,String totalsum,String offerid,String preference){
        String id = getid();
        int i=Integer.parseInt(id);
        
        id=String.valueOf(i);
        //date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String date = String.valueOf(dtf.format(now));
        //
        Order order = new Order();
        order.setOrder_id(id);
        order.setEmail(email);
        order.setDate(date);
        order.setStatus("pending");
        order.setCupponid(cupponid);
        order.setOfferid(offerid);
        order.setTotalsum(totalsum);
        order.setPrefrence(preference);
        
        //saving into order info
        saveinfo(order);
        
        
        //saving in orderdata
        Iterator<UserCart> itr = usercart.iterator();
        
        while(itr.hasNext()){
            UserCart uc = itr.next();
            order.setItem_name(uc.getItem().getName());
            order.setPrice(uc.getItem().getPrice());
            order.setQuantity(uc.getQty());
            
            savedata(order);
            
        }
        
        
    }
    
//    public static void main(String[] args){
//        
//        String s=getid();
//        System.out.print(s);
//       
//        
//        
//    }
    
}
