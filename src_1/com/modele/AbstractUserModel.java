package com.modele;

import java.sql.ResultSet;
import java.sql.Statement;

import modele.Connexion;

/**
 * 
 * @author HP
 *
 */

public abstract class AbstractUserModel {
	
	protected Statement st, st1;
	protected Connexion con=new Connexion();
	protected ResultSet rst, rst1;
	
	/**
	 * Attribut de base 
	 */
	protected int id, age, type_compte;
	protected String nom, prenom, sexe, poste, photo;
	protected String email, password;
	
	public AbstractUserModel(int id, int age, int type_compte, String nom, String prenom, String sexe, String poste, String photo, String email, String password) {
		this.id = id;
		this.age = age;
		this.type_compte = type_compte;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.poste = poste;
		this.photo = photo;
		this.email = email;
		this.password = password;
	}

	public abstract void create_user();
	
	public abstract void login();
	
	public abstract void logout();
	
	public abstract void update();
	
	public abstract void delete();
	
	
}
