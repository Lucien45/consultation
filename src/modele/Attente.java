package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Attente {
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	PreparedStatement pst;
	ResultSet rs;
	
	private int idSortie;
	private String date;
	
	public Attente(int idSortie, String date) {
		this.idSortie = idSortie;
		this.date = date;
				
	}
	
	public Attente() {
		
	}
	
	public Attente(int id) {
		this.idSortie = id;
	}
	
	@SuppressWarnings("unchecked")
	public void compteComboBox(JComboBox comboBox, Integer totalData) {
		int i = 5;
		try {
			Statement stmt = con.getConn().createStatement();
			ResultSet st = stmt.executeQuery("select * from attente");
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
			 JOptionPane.showMessageDialog(null,"compteCombo!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void total(JLabel label) {
		try {
			String rq = "select count(*) as som from attente";
			st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			if(rst.next()) {
				label.setText(rst.getString("som"));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public void inserte() {
		String rq="select * from attente where idS = '"+getIdSortie()+"'";
		try {
			 st1=con.getConn().createStatement();
			 rst1=st1.executeQuery(rq);
			if (rst1.next()== true) {
				JOptionPane.showMessageDialog(null,"Cette personne est d�j� mise en attente!",null,JOptionPane.ERROR_MESSAGE);
			}else {
				String rq1="insert into attente(idS, date_de_retour) " + " values('"+getIdSortie()+"','"+getDate()+"')";
				try{
					st=con.getConn().createStatement();
					st.executeUpdate(rq1);
					JOptionPane.showMessageDialog(null,"Mise en attente effectu�e!",null,JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException ex){
			    	JOptionPane.showMessageDialog(null,"Erreur dans attente!",null,JOptionPane.ERROR_MESSAGE);	
			    }
			}
		}catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur dans Verification attente!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
		
	public int getLengthTable() {
		int count = 0;
		String rq = "select * from attente";
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
	
	public int newLength(String debut, String fin) {
		int count = 0;
		String rq = "select * from attente"+" WHERE date(date_de_retour) BETWEEN '"+debut+"' AND '"+fin+"'";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(rq);
			 while(rst.next()){
				 count = count + 1;
			 }	
			 
		}
		 catch(SQLException ex){
		    	JOptionPane.showMessageDialog(null,"Erreur dans len attente!",null,JOptionPane.ERROR_MESSAGE);	
		 }
		System.out.println("total "+count);
		
		return count;
	}
	
	public void affichage(Object[][] data, Integer page, Integer rowCountPerPage) {
		String req = "select * from attente"+
					" order by id desc "+
					" limit ?,?";
		try {
			pst = con.getConn().prepareStatement(req);
			pst.setInt(1, rowCountPerPage * (page - 1));
			pst.setInt(2, rowCountPerPage);
			rs = pst.executeQuery();
			int row = 0;
			while(rs.next()==true) {
				data[row][0]= rs.getString("id");
				data[row][1]= rs.getString("idS");
				data[row][2]= rs.getString("date_de_retour");
				data[row][3]= rs.getString("id");
					row = row + 1;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null,"affichage!",null,JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void liste_attente(Object[][] data) {
		String req = "select * from attente"+" ORDER BY date_de_retour DESC ";
		try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 int row = 0;
			 while(rst.next()){
				data[row][0]= rst.getString("id");
				data[row][1]= rst.getString("idS");
				data[row][2]= rst.getString("date_de_retour");
				data[row][3]= rst.getString("id");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur date ato!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	public void Filtrage(Object[][] data, String debut, String fin) {
		String req = "select * from attente"+" WHERE date(date_de_retour) BETWEEN '"+debut+"' AND '"+fin+"'"+" ORDER BY date_de_retour DESC ";
		 try{
			 st=con.getConn().createStatement();
			 rst=st.executeQuery(req);
			 int row = 0;
			 while(rst.next()){
				data[row][0]= rst.getString("id");
				data[row][1]= rst.getString("idS");
				data[row][2]= rst.getString("date_de_retour");
				data[row][3]= rst.getString("id");
					row = row + 1;
			 } 
		} 
		catch(SQLException ex){
	    	JOptionPane.showMessageDialog(null,"Erreur deux attente!",null,JOptionPane.ERROR_MESSAGE);	
	    }
	}
	
	public void detail_attente(JLabel lblID, JLabel lblNom, JLabel lblPrenom, JLabel lblAge, JLabel lblSexe,  JLabel lblContact, 
			JLabel lblAdresse, JLabel lblDate,JLabel lblMotif, JLabel lblDirection, JLabel lblAttente){
		String rq="select * from attente where id = ?";
		try (PreparedStatement statement = con.getConn().prepareStatement(rq)) {
            statement.setInt(1, getIdSortie());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	 String query2 = "SELECT * FROM sortie WHERE id = ?";
	                try (PreparedStatement statement2 = con.getConn().prepareStatement(query2)) {
	                    statement2.setInt(1, resultSet.getInt("idS"));
	                    ResultSet resultSet2 = statement2.executeQuery();
	                    if(resultSet2.next()) {
	                    	String req1 ="select c.date_heure, c.id, c.motif, dir.acronyme, vis.nom, vis.prenom, vis.age, vis.sexe, vis.contact, vis.adresse FROM consultation"+
	                				" c INNER JOIN direction AS dir ON dir.id = c.idD"+
	                				" INNER JOIN visiteur vis ON vis.id = c.idV "+"where c.id = ?";
	                    	 try(PreparedStatement statement3 = con.getConn().prepareStatement(req1)){
	                    		 statement3.setInt(1, resultSet2.getInt("idC"));
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
		     	      				if (resultSet.getString("date_de_retour").equals("")) {
		     	      					 lblAttente.setText("N/A");
		     	      				} else {
		     	      					lblAttente.setText(resultSet.getString("date_de_retour"));
		     	      				}
								}
	                    	 }catch (SQLException ex) {
	         		        	JOptionPane.showMessageDialog(null,"Erreur dans consultation!",null,JOptionPane.ERROR_MESSAGE);
	         		        }
	                    }else{
//	                    	lblSortie.setText("OUI");
//	                    	lblAttente.setText("NON");
	                    }
	                }
	               catch (SQLException ex) {
		        	JOptionPane.showMessageDialog(null,"Erreur dans attente!",null,JOptionPane.ERROR_MESSAGE);
		        }
            }else {
//            	lblSortie.setText("NON");
//            	lblAttente.setText("NON");
            }
      }catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null,"Erreur dans sortie!",null,JOptionPane.ERROR_MESSAGE);
      }
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdSortie() {
		return idSortie;
	}

	public void setIdSortie(int idSortie) {
		this.idSortie = idSortie;
	}
	
}
