package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Direction {
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	PreparedStatement pst;
	ResultSet rs;
	
	private int id;
	
	public Direction() {}
	
	public Direction(int id) {
		this.id = id;
	}
	
	public void compteComboBox(JComboBox comboBox, Integer totalData) {
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from direction");
			totalData = getLengthTable();			
			while(st.next()) {
				if(i<totalData) {
					comboBox.addItem(i);
				}
				i= i+5;
	           }
			comboBox.addItem(totalData);
		}catch(SQLException e){
			 e.printStackTrace();
		}
	}
	
	public int getLengthTable() {
		int count = 0;
		String rq = "select * from direction";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			 while(rst.next()){
				 count = count + 1;
			 }	
			 
		}
		 catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans consulttion!",null,JOptionPane.ERROR_MESSAGE);	
		 }
		System.out.println("total "+count);
		
		return count;
	}
	
	public int getID(String nom) {
		int count = 0;
		String rq = "select id from direction where acronyme='"+nom+"'";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			 if(rst.next()){
				 count = count + 1;
			 }	
			 
		}
		catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans consulttion!",null,JOptionPane.ERROR_MESSAGE);	
		}
		
		return count;
	}
	
	public void affichage(Object[][] data, Integer page, Integer rowCountPerPage) {
		String req = "select * from direction order by id asc"+" limit ?,?";
		try {
			pst = con.getConn().prepareStatement(req);
			pst.setInt(1, rowCountPerPage * (page - 1));
			pst.setInt(2, rowCountPerPage);
			rs = pst.executeQuery();
			int row = 0;
			while(rs.next()==true) {
				data[row][0]= rs.getString("id");
				data[row][1]= rs.getString("acronyme");
				data[row][2]= rs.getString("nomination");
				data[row][3]= rs.getString("id");
					row = row + 1;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void Liste_direction(Object[][] data) {
		String req = "select * from direction order by id asc";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 int row = 0;
			 while(rst.next()){
				data[row][0]= rst.getString("id");
				data[row][1]= rst.getString("acronyme");
				data[row][2]= rst.getString("nomination");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void Liste_direction_desc(Object[][] data, Integer page, Integer rowCountPerPage) {
		String req = "select * from direction order by id desc"+" limit ?,?";
		 try{
			 pst = con.getConn().prepareStatement(req);
			pst.setInt(1, rowCountPerPage * (page - 1));
			pst.setInt(2, rowCountPerPage);
			rs = pst.executeQuery();
			 int row = 0;
			 while(rs.next()==true) {
					data[row][0]= rs.getString("id");
					data[row][1]= rs.getString("acronyme");
					data[row][2]= rs.getString("nomination");
					data[row][3]= rs.getString("id");
						row = row + 1;
			} 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public int getId(String nom, int id) {
		String req = "SELECT id FROM direction WHERE acronyme='"+nom+"'";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
            while(rst.next()) {
                id = rst.getInt("id");
            }
        }
        catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,"Erreur dans direction!",null,JOptionPane.ERROR_MESSAGE);
        }
		return id;
	}

	@SuppressWarnings("unchecked")
	public void affiche_all_direction(JComboBox jcb) {
		String req="select * from direction ";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 jcb.addItem(rst.getString("acronyme"));
			 }
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans l'affichage direction!",null,JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void affiche_direction(JComboBox jcb) {
		String req="select * from direction where idB='"+getId()+"'";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 jcb.addItem(rst.getString("acronyme"));
			 }
		}
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans l'affichage direction!",null,JOptionPane.ERROR_MESSAGE);	
		}
	}
	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
