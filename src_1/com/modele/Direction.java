package com.modele;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Direction extends AbstractModel {

	private int id;
	public Direction(int id) {
		this.id = id;
	}
	
	@Override
	public void affichage(DefaultTableModel df) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void affichage(JComboBox jcb) {
		String req="select * from direction where idB='"+getId()+"'";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 jcb.addItem(rst.getString("acronyme"));
				 System.out.println(rst.getString("id")+" | "+rst.getString("acronyme"));
			 }
			 System.out.println("-----------------------");
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans l'affichage direction!",null,JOptionPane.ERROR_MESSAGE);	
		}

	}

	@Override
	public void inserer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifier() {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer() {
		// TODO Auto-generated method stub

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
