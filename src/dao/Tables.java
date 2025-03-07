/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author romit
 */
public class Tables {
    public static void main(String[] args){
        try{
            String userTable="create table user(id int AUTO_INCREMENT primary key,"
                    + "name varchar(200),email varchar(200),phoneNumber varchar(10),password varchar(200),"
                    + "securityQuestion varchar(200),answer varchar(200),status varchar(100),UNIQUE (email))";
            
            String adminTable="create table admin(id varchar(20) primary key ,password varchar(200) not null)";
            
            String itemTable="create table item(id int varchar(10) primary key ,name varchar(200) not null,"
                    + " price varchar(20) not null,category varchar(200) not null)";
            
            String orderinfo="create table orderinfo(id varchar(10) primary key,"
                    + "email varchar(200),offerId varchar(10),couponId varchar(10),totalsum varchar(100),prefrence varchar(100),FOREIGN KEY(email) REFERENCES user(email))";
            
            String orderdata="create table orderdata(id varchar(10),item_name varchar(10),"
                    + "price varchar(10),quantity varchar(10),status varchar(20),date date)";
            
            String offer = "create table offer(id varchar(10),percent varchar(2),status varchar(10))";
            
            String cuppon = "create table coupon(id varchar(10),amount varchar(10),status varchar(10))";
            
            String superadmin ="create table superadmin(id varchar(20) primary key,password varchar(200) not null)";
            
//            DbOperations.setDataorDelete(userTable, "user Table created");
//            DbOperations.setDataorDelete(adminTable, "admin Table created");
//             DbOperations.setDataorDelete(itemTable, "item Table created");
//               DbOperations.setDataOrDelete(orderinfo, "order Table 1 created");
 //              DbOperations.setDataOrDelete(orderdata, "order Table 2 created");
//                 DbOperations.setDataOrDelete(offer, "offer Table created");
//                DbOperations.setDataOrDelete(cuppon, "cuppon table created");
                 DbOperations.setDataOrDelete(superadmin, "superadmin table created");
 
 

               
        
        
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
