package com.modele;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Bureau extends AbstractModel {

	@Override
	public void affichage(DefaultTableModel df) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void affichage(JComboBox jcb) {
		String req="select * from bureau ";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 String name = rst.getString("nom");
			     jcb.addItem(name);
			 }		 
		}
		 catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans l'affichage bureau!",null,JOptionPane.ERROR_MESSAGE);	
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

}
