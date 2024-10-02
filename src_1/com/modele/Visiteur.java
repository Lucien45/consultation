package com.modele;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Visiteur extends AbstractModel {

	private String nom;
	private String prenom;
	private int age;
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
	
	@Override
	public void affichage(DefaultTableModel df) {
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

	@Override
	public void inserer() {
		
		String rq="insert into visiteur(nom,prenom,age,sexe,contact,adresse) "
				+ "values('"+getNom()+"','"+getPrenom()+"','"+getAge()+"','"+getSexe()+"','"+getContact()+"','"+getAdresse()+"')";
		try{
			st=con.getConn().createStatement();
			st.executeUpdate(rq);
			JOptionPane.showMessageDialog(null,"Enregistrement éffectué avec succès !",null,JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans visiteur!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub

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

	@Override
	public void affichage(JComboBox jcb) {
		// TODO Auto-generated method stub
		
	}

}
