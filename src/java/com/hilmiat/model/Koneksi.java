/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hilmiat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hilmiat
 */
public class Koneksi {
    private Connection con;
    public Koneksi(){
        initDB();
    }

    private void initDB() {
        //parameter
        String dbhost = "localhost";
        String dbname = "mywebapp";
        String dbuser = "mywebappuser";
        String dbpass = "mywebapppass";
        String dburl = "jdbc:mysql://"+dbhost+":3306/"+dbname;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(dburl,dbuser,dbpass);
            System.out.println("Koneksi Sukses");
        }catch(Exception e){
            System.out.println("Koneksi gagal :");
            e.printStackTrace();
        }
    }
    public Connection getKoneksi(){
        try {
            if(this.con == null || this.con.isClosed()){
                this.initDB();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.con;
    }
    
    public void closeKoneksi(){
        if(this.con !=null){
            try {
                this.con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
