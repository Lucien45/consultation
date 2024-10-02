package com.modele;

import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Consultation extends AbstractModel {
	
	private int direction;
	private String motif;
	public Consultation(int direction, String motif) {
		this.direction = direction;
		this.motif = motif;
	}
	
	public Consultation() {
		
	}
	
	@Override
	public void affichage(DefaultTableModel df) {
		String req = "select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 df.addRow(new Object[]{
						 rst.getString("id"),rst.getString("date_heure"),rst.getString("nom"),rst.getString("motif"),rst.getString("acronyme")

				});
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur !",null,JOptionPane.ERROR_MESSAGE);	
	    }

	}

	@Override
	public void inserer() {
		String rq1 = "select MAX(id) from visiteur";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq1);
			 while(rst.next()){
				 int id = rst.getInt(1);
				 String rq2 = "insert into consultation(motif,idV,idD)"
						 +"values('"+getMotif()+"','"+id+"','"+getDirection()+"')";
				 st=con.getConn().createStatement();
				 st.executeUpdate(rq2);
			 }		 
		}
		 catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans consulttion!",null,JOptionPane.ERROR_MESSAGE);	
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
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	@Override
	public void affichage(JComboBox jcb) {
		// TODO Auto-generated method stub
		
	}

}
