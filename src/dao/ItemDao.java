
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Item;
import java.sql.*;
/**
 *
 * @author romit
 */
public class ItemDao {
    
    public static void delete(Item i){
        String query ="delete from item where id='"+i.getId()+"'";
        DbOperations.setDataOrDelete(query, "deleted successfully");
        
    }
    public static void update(Item i){
        String query = "update item set name='"+i.getName()+"',price='"+i.getPrice()+"' where id='"+i.getId()+"' ";
        DbOperations.setDataOrDelete(query, "updated");
    }
    
    public static ArrayList<Item> getAllItems(){
        ArrayList<Item> it=new ArrayList();
        String query="select * from item ";
        
        try{
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Item item=new Item();
                item.setId((rs.getString("id")));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getString("price"));
                item.setName(rs.getString("name"));
                it.add(item);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return it;

    }
    
    public static ArrayList<Item> getAllSnacks(){
        ArrayList<Item> it=new ArrayList();
        String query="select * from item where category='snacks'";
        
        try{
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Item item=new Item();
                item.setId((rs.getString("id")));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getString("price"));
                item.setName(rs.getString("name"));
                it.add(item);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return it;
    }
    public static ArrayList<Item> getAllDrinks(){
        ArrayList<Item> it=new ArrayList();
        String query="select * from item where category='drinks'";
        
        try{
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Item item=new Item();
                item.setId((rs.getString("id")));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getString("price"));
                item.setName(rs.getString("name"));
                it.add(item);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return it;
    }
    public static ArrayList<Item> getAllCombos(){
        ArrayList<Item> it=new ArrayList();
        String query="select * from item where category='combos'";
        
        try{
            ResultSet rs = DbOperations.getData(query);
            while(rs.next()){
                Item item=new Item();
                item.setId((rs.getString("id")));
                item.setCategory(rs.getString("category"));
                item.setPrice(rs.getString("price"));
                item.setName(rs.getString("name"));
                it.add(item);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return it;
    }
    public static void save(Item i){
        String query ="insert into item values('"+i.getId()+"','"+i.getName()+"','"+i.getPrice()+"','"+i.getCategory()+"')";
        DbOperations.setDataOrDelete(query, "item added");
    }
    
}
