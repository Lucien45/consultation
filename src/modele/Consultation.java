package modele;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Consultation {
	Statement st, st1, st2;
	Connexion con=new Connexion();
	ResultSet rst, rst1, rst2;
	
	PreparedStatement pst;
	ResultSet rs;
	
	private int ID;
	private int direction;
	private String motif;
	
	public Consultation(int direction, String motif) {
		this.direction = direction;
		this.motif = motif;
	}
	
	public Consultation() {
		
	}
	
	public Consultation(int id) {
		this.ID = id;
	}
	
	public void total(JLabel label, int idD) {
		try {
			String rq = "select count(*) as som from consultation where idD = '"+idD+"'";
			st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			while(rst.next()) {
				if (rst.getString("som").equals("0")) {
					label.setText("               "+rst.getString("som"));
					label.setForeground(Color.RED);
				} else {
					label.setText("               "+rst.getString("som"));
					label.setForeground(new Color(0, 0, 0));
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void total(JLabel label) {
		LocalDate now = LocalDate.now();
		try {
			String rq = "select count(*) as som from consultation where date(date_heure) = '"+now.toString()+"'";
			st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			if(rst.next()) {
				label.setText(rst.getString("som"));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void liste_data(Object[][] data) {
		try {
			String rq1 = "select * from consultation";
			st=con.getConn().createStatement();
			 rst=st.executeQuery(rq1);
			int row = 0;
			while(rst.next()==true) {
				data[row][0]= rst.getString("id");
				data[row][1]= rst.getString("motif");
				data[row][2]= rst.getString("date_heure");
				data[row][3]= rst.getString("id");
				row = row + 1;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void Liste_consultation(Object[][] data, Integer page, Integer rowCountPerPage) {
		String req = "select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV "+
				" ORDER BY date_heure DESC "+" limit ?,?";
		
		 try{
			 pst = con.getConn().prepareStatement(req);
			 pst.setInt(1, rowCountPerPage * (page - 1));
			 pst.setInt(2, rowCountPerPage);
			 rs = pst.executeQuery();
			 int row = 0;
			 while(rs.next()){
				 data[row][0]= rs.getString("id");
				 data[row][1]= rs.getString("date_heure");
				 data[row][2]= rs.getString("nom");
				 data[row][3]= rs.getString("motif");
				 data[row][4]= rs.getString("acronyme");
				 String req1 = "select * from sortie where idC=?";
				 try (PreparedStatement statement = con.getConn().prepareStatement(req1)) {
	                    statement.setInt(1, rs.getInt("id"));
	                    ResultSet resultSet = statement.executeQuery();
	                    if(resultSet.next()) {
	                    	 String query2 = "SELECT * FROM attente WHERE idS = ?";
	 		                try (PreparedStatement statement2 = con.getConn().prepareStatement(query2)) {
	 		                    statement2.setInt(1, resultSet.getInt("id"));
	 		                    ResultSet resultSet2 = statement2.executeQuery();
	 		                    if(resultSet2.next()) {
	 		                    	data[row][5]= "OUI";
	 		       				 	data[row][6]= "OUI";
	 		                    }else{
	 		                    	data[row][5]= "OUI";
	 		       				 	data[row][6]= "NON";
	 		                    }
	 		                }
	 		               catch (SQLException ex) {
					        	JOptionPane.showMessageDialog(null,"Erreur dans attente!",null,JOptionPane.ERROR_MESSAGE);
					        }
	                    }else {
	                    	data[row][5]= "NON";
	       				 	data[row][6]= "NON";
	                    }
	              }catch (SQLException ex) {
			        	JOptionPane.showMessageDialog(null,"Erreur dans sortie!",null,JOptionPane.ERROR_MESSAGE);
			      }
				 data[row][7]= rs.getString("id");
				 row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void compteComboBox(JComboBox comboBox, Integer totalData) {
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from consultation");
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
		LocalDate now = LocalDate.now();
		int count = 0;
		String rq = "select * from consultation where date(date_heure) = '"+now.toString()+"'";
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
	
	public int getLength_histo() {
		int count = 0;
		String rq = "select * from consultation";
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
	
	public void compteCombo_histo(JComboBox comboBox, Integer totalData) {
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from consultation");
			totalData = getLength_histo();			
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
	
	
	public void ajoute_consultation(){
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
	

	public void affichage(Object[][] data, Integer page, Integer rowCountPerPage) {
		LocalDate now = LocalDate.now();
		String req = "select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV "+
				"where date(date_heure) = ?"+
				" order by id desc "+
				" limit ?,? ";
		try {
			pst = con.getConn().prepareStatement(req);
			pst.setString(1, now.toString());
			pst.setInt(2, rowCountPerPage * (page - 1));
			pst.setInt(3, rowCountPerPage);
			rs = pst.executeQuery();
			int row = 0;
			while(rs.next()==true) {
				data[row][0]= rs.getString("id");
				data[row][1]= rs.getString("date_heure");
				data[row][2]= rs.getString("nom");
				data[row][3]= rs.getString("motif");
				data[row][4]= rs.getString("acronyme");
				data[row][5]= rs.getString("id");
				data[row][6]= rs.getString("id");
				row = row + 1;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Erreur dans consulttion!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void compteComboBox_filtre(JComboBox comboBox, Integer totalData, String debut, String fin) {
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from consultation "+" WHERE date(date_heure) BETWEEN '"+debut+"' AND '"+fin+"'");
			totalData = newLength(debut, fin);
			while(st.next()) {
				if(i<totalData) {
					comboBox.addItem(i);
				}
				i= i+5;
	        }
			comboBox.addItem(totalData);
			System.out.println("ato: "+totalData);
		}catch(SQLException e){
			 e.printStackTrace();
		}
	}
	
	public void Filtrage(Object[][] data, String debut, String fin) {
		String req = "SELECT c.date_heure, c.id, c.motif, dir.acronyme, vis.nom FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV "+" WHERE date(date_heure) BETWEEN '"+debut+"' AND '"+fin+"'"+
				" ORDER BY date_heure DESC ";
		 try{
			 pst = con.getConn().prepareStatement(req);
			 rs = pst.executeQuery();
			 int row = 0;
			 while(rs.next()){
				data[row][0]= rs.getString("id");
				data[row][1]= rs.getString("date_heure");
				data[row][2]= rs.getString("nom");
				data[row][3]= rs.getString("motif");
				data[row][4]= rs.getString("acronyme");
				data[row][5]= rs.getString("id");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur deux!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void detail_historique(JLabel lblID, JLabel lblNom, JLabel lblPrenom, JLabel lblAge, JLabel lblSexe,  JLabel lblContact, 
			JLabel lblAdresse, JLabel lblDate,JLabel lblMotif, JLabel lblDirection, JLabel lblSortie, JLabel lblAttente) {
		String req ="select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom, vis.prenom, vis.age, vis.sexe, vis.contact, vis.adresse FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV "+"where c.id ='"+getID()+"'";
		try{
			 pst = con.getConn().prepareStatement(req);
			 rs = pst.executeQuery();
			 while(rs.next()){
				 lblID.setText(rs.getString("id"));
				 lblNom.setText(rs.getString("nom"));
				 lblAge.setText(rs.getString("age"));
				 lblSexe.setText(rs.getString("sexe"));
				 lblDirection.setText(rs.getString("acronyme"));
				 lblMotif.setText(rs.getString("motif"));
				 lblDate.setText(rs.getString("date_heure"));
				 if (rs.getString("prenom").equals("")) {
					 lblPrenom.setText("N/A");
				} else {
					lblPrenom.setText(rs.getString("prenom"));
				}
				 if (rs.getString("contact").equals("")) {
					 lblContact.setText("N/A");
				} else {
					lblContact.setText(rs.getString("contact"));
				}
				 if (rs.getString("adresse").equals("")) {
					 lblAdresse.setText("N/A");
				} else {
					lblAdresse.setText(rs.getString("adresse"));
				}
				 String req1 = "select * from sortie where idC=?";
				 try (PreparedStatement statement = con.getConn().prepareStatement(req1)) {
	                    statement.setInt(1, rs.getInt("id"));
	                    ResultSet resultSet = statement.executeQuery();
	                    if(resultSet.next()) {
	                    	 String query2 = "SELECT * FROM attente WHERE idS = ?";
	 		                try (PreparedStatement statement2 = con.getConn().prepareStatement(query2)) {
	 		                    statement2.setInt(1, resultSet.getInt("id"));
	 		                    ResultSet resultSet2 = statement2.executeQuery();
	 		                    if(resultSet2.next()) {
	 		                    	 lblSortie.setText("OUI");
	 		                    	 lblAttente.setText("OUI");
	 		                    }else{
	 		                    	lblSortie.setText("OUI");
	 		                    	lblAttente.setText("NON");
	 		                    }
	 		                }
	 		               catch (SQLException ex) {
					        	JOptionPane.showMessageDialog(null,"Erreur dans attente!",null,JOptionPane.ERROR_MESSAGE);
					        }
	                    }else {
	                    	lblSortie.setText("NON");
	                    	lblAttente.setText("NON");
	                    }
	              }catch (SQLException ex) {
			        	JOptionPane.showMessageDialog(null,"Erreur dans sortie!",null,JOptionPane.ERROR_MESSAGE);
			      }
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void detail_consultation(JLabel lblID, JLabel lblNom, JLabel lblPrenom, JLabel lblAge, JLabel lblSexe,  JLabel lblContact, 
									JLabel lblAdresse, JLabel lblDirection, JLabel lblMotif, JLabel lblDate) {
		String req = "select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom, vis.prenom, vis.age, vis.sexe, vis.contact, vis.adresse FROM consultation"+
				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
				" INNER JOIN visiteur vis ON vis.id = c.idV "+"where c.id ='"+getID()+"'";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 while(rst.next()){
				 lblID.setText(rst.getString("id"));
				 lblNom.setText(rst.getString("nom"));
				 lblAge.setText(rst.getString("age"));
				 lblSexe.setText(rst.getString("sexe"));
				 lblDirection.setText(rst.getString("acronyme"));
				 lblMotif.setText(rst.getString("motif"));
				 lblDate.setText(rst.getString("date_heure"));
				 if (rst.getString("prenom").equals("")) {
					 lblPrenom.setText("N/A");
				} else {
					lblPrenom.setText(rst.getString("prenom"));
				}
				 if (rst.getString("contact").equals("")) {
					 lblContact.setText("N/A");
				} else {
					lblContact.setText(rst.getString("contact"));
				}
				 if (rst.getString("adresse").equals("")) {
					 lblAdresse.setText("N/A");
				} else {
					lblAdresse.setText(rst.getString("adresse"));
				}
			 } 
		} 
		catch(SQLException ex){
			System.out.println("Erreur dans detail consultation!");
	    	JOptionPane.showMessageDialog(null,"Erreur dans detail consultation!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public int newLength(String debut, String fin) {
		int count = 0;
		String rq = "select * from Consultation"+" WHERE date(date_heure) BETWEEN '"+debut+"' AND '"+fin+"'";
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
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
	
	
}
