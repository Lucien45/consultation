package com.modele;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import modele.Connexion;

/**
 * 
 * @author HP
 *
 */

public abstract class AbstractModel {
	
	protected Statement st, st1;
	protected Connexion con=new Connexion();
	protected ResultSet rst, rst1;
	
	public abstract void affichage(DefaultTableModel df);
	
	@SuppressWarnings("rawtypes")
	public abstract void affichage(JComboBox jcb);
	
	public abstract void inserer();
	
	public abstract void modifier();
	
	public abstract void supprimer();
	
	
}
