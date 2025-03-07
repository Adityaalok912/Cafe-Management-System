/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.Offer;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author romit
 */
public class OfferDao {
    public static Offer getAllOffer(){
        Offer offer = new Offer();
        offer.setPercent("0");
        String query="select * from offer where status='True'";
        try{
            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                offer.setId(rs.getString("id")); 
                offer.setPercent(rs.getString("percent"));
            }

            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return offer;
    }
    
    public static ArrayList<Offer> getAllOffers(){
        ArrayList<Offer> of = new ArrayList(); 
        
        
        String query="select * from offer";
        try{
            ResultSet rs = DbOperations.getData(query);
            
            while(rs.next()){
                Offer offer = new Offer();
                offer.setId(rs.getString("id")); 
                offer.setPercent(rs.getString("percent"));
                offer.setStatus(rs.getString("status"));
                of.add(offer);
                
            }

            
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            
        }
        return of;
    }

    public static void save(Offer o) {
        String query="insert into offer values('"+o.getId()+"','"+o.getPercent()+"','"+o.getStatus()+"')";
        DbOperations.setDataOrDelete(query, "");
    }

    public static void updatestatus(String idrow, String newv) {
        String query="update offer set status='"+newv+"' where id='"+idrow+"' ";
        DbOperations.setDataOrDelete(query, "");
    }
    
}
