/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author romit
 */
public class Order {
    private String order_id;
    private String item_name;
    private String price;
    private String quantity;
    private String status;
    private String email;
    private String date;
    private String cupponid;
    private String offerid;
    private String totalsum;
    private String prefrence;

    public String getPrefrence() {
        return prefrence;
    }

    public void setPrefrence(String prefrence) {
        this.prefrence = prefrence;
    }

    public String getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(String totalsum) {
        this.totalsum = totalsum;
    }

    public String getCupponid() {
        return cupponid;
    }

    public void setCupponid(String cupponid) {
        this.cupponid = cupponid;
    }

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }
    


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
   
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
