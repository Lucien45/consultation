package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 * 
 * @author HP
 *
 */
public class Bureau {
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void affiche_bureau(JComboBox jcb) {
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
	
	
}
