package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Sortie {
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	PreparedStatement pst;
	ResultSet rs;
	
	@SuppressWarnings("unused")
	private int idConsultation, ID;

	public Sortie(int idConsultation) {
		this.idConsultation = idConsultation;
	}
	
	public Sortie() {
		
	}
	
	public void total(JLabel label) {
		LocalDate now = LocalDate.now();
		try {
			String rq = "select count(*) as som from sortie where date(date_heure) = '"+now.toString()+"'";
			st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			if(rst.next()) {
				label.setText(rst.getString("som"));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void compteComboBox(JComboBox comboBox, Integer totalData) {
		LocalDate now = LocalDate.now();
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from sortie where date(date_heure) = '"+now.toString()+"'");
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
			 JOptionPane.showMessageDialog(null,"comptecombo!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void delete() {
		 String rq = "delete from visiteur where id='"+getIdConsultation()+"'";		
		try {
			 st=con.getConn().createStatement();
			 st.executeUpdate(rq);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erreur dans suppresion sortie!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public int getLengthTable() {
		LocalDate now = LocalDate.now();
		int count = 0;
		String rq = "select * from sortie where date(date_heure) = '"+now.toString()+"'";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			 while(rst.next()){
				 count = count + 1;
			 }	
			 
		}
		 catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans count sortie!",null,JOptionPane.ERROR_MESSAGE);	
		 }
		System.out.println("total "+count);
		
		return count;
	}
	
	public int newLength(String debut, String fin) {
		int count = 0;
		String rq = "select * from sortie"+" WHERE date(date_heure) BETWEEN '"+debut+"' AND '"+fin+"'";
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
	
	public void Filtrage(Object[][] data, String debut, String fin) {
		String req = "select * from sortie "+" WHERE date(date_heure) BETWEEN '"+debut+"' AND '"+fin+"'";
		 try{
			 pst = con.getConn().prepareStatement(req);
			 rs = pst.executeQuery();
			 int row = 0;
			 while(rs.next()){
				 data[row][0]= rs.getString("id");
				 data[row][1]= rs.getString("date_heure");
				 data[row][2]= rs.getString("idC");
				 data[row][3]= rs.getString("id");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur deux!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void affichage(Object[][] data, Integer page, Integer rowCountPerPage) {
		LocalDate now = LocalDate.now();
		String req = "select * from sortie where date(date_heure) = '"+now.toString()+"'"+" ORDER BY id DESC "+" limit ?,?";
		try {
			pst = con.getConn().prepareStatement(req);
			pst.setInt(1, rowCountPerPage * (page - 1));
			pst.setInt(2, rowCountPerPage);
			rs = pst.executeQuery();
			int row = 0;
			while(rs.next()==true) {
				data[row][0]= rs.getString("id");
				data[row][1]= rs.getString("date_heure");
				data[row][2]= rs.getString("idC");
				data[row][3]= rs.getString("id");
				row = row + 1;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"affichage!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void Liste_sortie(Object[][] data) {
		LocalDate now = LocalDate.now();
		String req = "select * from sortie where date(date_heure) = '"+now.toString()+ "'"+" ORDER BY id DESC ";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 int row = 0;
			 while(rst.next()){
				data[row][0]= rst.getString("id");
				data[row][1]= rst.getString("date_heure");
				data[row][2]= rst.getString("idC");
				data[row][3]= rst.getString("id");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	
	public void inserte() {
		String rq="select * from sortie where idC = '"+getIdConsultation()+"'";
		try {
			 st1=con.getConn().createStatement();
			 rst1=st1.executeQuery(rq);
			if (rst1.next()== true) {
				JOptionPane.showMessageDialog(null,"Cette consultation est d�ja dans le sortie!",null,JOptionPane.ERROR_MESSAGE);
			}else {
				String rq1="insert into sortie(idC) " + " values('"+getIdConsultation()+"')";
				try{
					st=con.getConn().createStatement();
					st.executeUpdate(rq1);
					JOptionPane.showMessageDialog(null,"Mise en sortie effectu�e!",null,JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException ex){
			    	JOptionPane.showMessageDialog(null,"Erreur dans sortie!",null,JOptionPane.ERROR_MESSAGE);	
			    }
			}
		}catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans Verification sortie!",null,JOptionPane.ERROR_MESSAGE);	
	    }
		
	}
	
	public void detail_sortie(JLabel lblID, JLabel lblNom, JLabel lblPrenom, JLabel lblAge, JLabel lblSexe,  JLabel lblContact, 
			JLabel lblAdresse, JLabel lblDate,JLabel lblMotif, JLabel lblDirection, JLabel lblSortie){
		String rq="select * from sortie where id = ?";
		try (PreparedStatement statement = con.getConn().prepareStatement(rq)) {
            statement.setInt(1, getIdConsultation());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	String req1 ="select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom, vis.prenom, vis.age, vis.sexe, vis.contact, vis.adresse FROM consultation"+
        				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
        				" INNER JOIN visiteur vis ON vis.id = c.idV "+"where c.id = ?";
            	 try(PreparedStatement statement3 = con.getConn().prepareStatement(req1)){
            		 statement3.setInt(1, resultSet.getInt("idC"));
	                    ResultSet resultSet3 = statement3.executeQuery();
	                    if (resultSet3.next()) {
	                    	 lblID.setText(resultSet.getString("id"));
 	      				 lblNom.setText(resultSet3.getString("nom"));
 	      				 lblAge.setText(resultSet3.getString("age"));
 	      				 lblSexe.setText(resultSet3.getString("sexe"));
 	      				 lblDirection.setText(resultSet3.getString("acronyme"));
 	      				 lblMotif.setText(resultSet3.getString("motif"));
 	      				 lblDate.setText(resultSet3.getString("date_heure"));
 	      				 if (resultSet3.getString("prenom").equals("")) {
 	      					 lblPrenom.setText("N/A");
 	      				} else {
 	      					lblPrenom.setText(resultSet3.getString("prenom"));
 	      				}
 	      				 if (resultSet3.getString("contact").equals("")) {
 	      					 lblContact.setText("N/A");
 	      				} else {
 	      					lblContact.setText(resultSet3.getString("contact"));
 	      				}
 	      				if (resultSet3.getString("adresse").equals("")) {
 	      					 lblAdresse.setText("N/A");
 	      				} else {
 	      					lblAdresse.setText(resultSet3.getString("adresse"));
 	      				}
 	      				if (resultSet.getString("date_heure").equals("")) {
 	      					 lblSortie.setText("N/A");
 	      				} else {
 	      					lblSortie.setText(resultSet.getString("date_heure"));
 	      				}
					}
            	 }catch (SQLException ex) {
 		        	JOptionPane.showMessageDialog(null,"Erreur dans consultation!",null,JOptionPane.ERROR_MESSAGE);
 		        }
            }
        }catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,"Erreur dans sortie!",null,JOptionPane.ERROR_MESSAGE);
        }
	}

	public int getIdConsultation() {
		return idConsultation;
	}

	public void setIdConsultation(int idConsultation) {
		this.idConsultation = idConsultation;
	}
	
}
