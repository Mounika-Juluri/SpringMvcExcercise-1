package com.stackroute.db;

import java.sql.*;

public class CrudOperation {
    private Connection con;
    public void insertData(String user,String pass) {
        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student","Mounika","root123");
            //create statement object
            PreparedStatement stmt=con.prepareStatement("insert into Login (username,passwaord) values (?,?)");
            stmt.setString(1,user);
            stmt.setString(2,pass);
            stmt.execute();

        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String displayCustomerByName(String uname) {

        try{
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student","Mounika","root123");
            //create statement object
            PreparedStatement stmt=con.prepareStatement("Select username from Login where username=?");

           stmt.setString(1,uname);
            ResultSet rs = stmt.executeQuery();
            String str="";
            System.out.println("query excecuted");
            while(rs.next()){
            str= rs.getString(1);}
            con.close();
            return str;
        }catch(Exception e){ System.out.println(e);}
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       return null;
    }


}
