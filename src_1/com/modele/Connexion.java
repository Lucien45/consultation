package com.modele;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	Connection cn;
	public Connexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/consultation","root","");
//	    System.out.println("Connection �tablie !");
		}
		catch(Exception e){
			System.out.println("connexion �cho�e! ==>"+ e.getMessage());
			
		}
		
	}
    public Connection getConn(){
    	return cn;
    }
}
