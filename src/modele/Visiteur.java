package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Visiteur {
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	private String nom;
	private String prenom;
	private int age, ID;
	private String sexe;
	private String contact;
	private String adresse;
	
	public Visiteur(String nom, String prenom, int age, String sexe, String contact, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.contact = contact;
		this.adresse = adresse;
	}
	
	public Visiteur() {
		
	}
	
	public Visiteur(int id) {
		this.ID = id;
	}
	
	public void delete() {
		 String rq = "delete from visiteur where id='"+getID()+"'";		
		try {
			 st=con.getConn().createStatement();
			 st.executeUpdate(rq);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erreur dans suppresion visiteur!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void Liste_visiteur(DefaultTableModel df) {
		String req="select * from visiteur  ";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 df.addRow(new Object[]{
						 rst.getString("id"),rst.getString("nom"),rst.getString("prenom"),
						 rst.getString("contact"),rst.getString("adresse")

				});
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans visiteur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void ajoute_visiteur() {
		String rq="insert into visiteur(nom,prenom,age,sexe,contact,adresse) "
				+ "values('"+getNom()+"','"+getPrenom()+"','"+getAge()+"','"+getSexe()+"','"+getContact()+"','"+getAdresse()+"')";
		try{
			st=con.getConn().createStatement();
			st.executeUpdate(rq);
			JOptionPane.showMessageDialog(null,"Enregistrement �ffectu� avec succ�s !",null,JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans visiteur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
}
