package com.qpp;
import java.sql.*;
public class dcon {
	static Connection conn = null;
    public static Connection gcon(){
    	try{
	    	Class.forName("org.postgresql.Driver");
	    	String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
	  		conn = DriverManager.getConnection(url);
  		} catch (Exception e){
  			System.out.println(e.getMessage());
  		}
  		return conn;
    }
}