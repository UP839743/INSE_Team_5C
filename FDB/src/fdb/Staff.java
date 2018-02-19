/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdb;

import java.sql.*;

/**
 *
 * @author Samuel
 */
public class Staff {
    String staffFirstName;
    String staffLastName;
    String position;
    Date DoB;
    String nationality;

    private String getFirstName(String query){
    System.out.println("Connection attempted");
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/homes","INSE","root");  
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from Player where " + query);  
    while(rs.next())  
        System.out.println(rs.getString(1));  
        con.close();  }
    catch(Exception e){
        System.out.println(e);
        System.out.println("Connection Failed");
    }
    return staffFirstName;
    }

    private String getLastName(){
    return staffLastName;
    }

    private String getPosition(){
    return position;
    }

    private Date getDoB(){
    return DoB;
    }

    private String getNationality(){
    return nationality;
    }
}