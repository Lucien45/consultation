package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.FrameDashboard;

public class User {
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String sexe;
	private String photo;
	private String username;
	private String email;
	private String password;
	private int direction;
	private String type_compte;
	
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}

	public User(String nom, String prenom, int age, String sexe, String photo, String username, String email, String password, int direction, String type_compte) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.photo = photo;
		this.username = username;
		this.email = email;
		this.password = password;
		this.direction = direction;
		this.type_compte = type_compte;
	}
	
	public User(String email, String password, String type) {
		this.email = email;
		this.password = password;
		this.type_compte = type;
	}
	
	public void affiche_profile(JLabel lbl1, JLabel lbl2){
		String rq="select photo, username from utilisateur where id = '"+10+"'";
		try {
			st=con.getConn().createStatement();
			rst = st.executeQuery(rq);
			while(rst.next()) {
				lbl1.setIcon(new ImageIcon(rst.getString("photo")));;
				lbl2.setText(rst.getString("nom")+" "+rst.getString("prenom"));
			}
		} catch (Exception e) {
			
		}
	}
	
	
	public void signup() {
		String rq1="select * from utilisateur where email = '"+getEmail()+"'";
		try {
			 st1=con.getConn().createStatement();
			 rst1=st1.executeQuery(rq1);
			if (rst1.next()== true) {
				JOptionPane.showMessageDialog(null,"Cette email d�j� utilis�e",null,JOptionPane.ERROR_MESSAGE);
			}else {
				String rq="INSERT INTO utilisateur(nom,prenom,age,sexe,photo,username,email,password,direction, type_compte) "
						+ " VALUES('"+getNom()+"','"+getPrenom()+"','"+getAge()+"','"+getSexe()+"','"+getPhoto()+"','"
						+getUsername()+"','"+getEmail()+"','"+getPassword()+"','"+getDirection()+"','"+getType_compte()+"')";
				try{
					st=con.getConn().createStatement();
					st.executeUpdate(rq);
					JOptionPane.showMessageDialog(null,"Enregistrement �ffectu� avec succ�s !",null,JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException ex){
			    	JOptionPane.showMessageDialog(null,"Erreur dans user! "	+ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);	
			    }
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erreur dans Verification utilisateur!",null,JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public void login(JLabel label, JFrame frm) {
		String rq = "SELECT email, password FROM utilisateur where type_compte = '"+getType_compte()+"'";
		try {
			 st1=con.getConn().createStatement();
			 rst1=st1.executeQuery(rq);
			 if (rst1.next()== false) {
					JOptionPane.showMessageDialog(null,"Vous n'avez pas d'acc�s dans ce compte",null,JOptionPane.ERROR_MESSAGE);
			 }else{
				 String rq1 = "SELECT * FROM utilisateur";
					st=con.getConn().createStatement();
					rst=st.executeQuery(rq1);
					while (rst.next()) {
						if (rst.getString("email").equals(getEmail()) && rst.getString("password").equals(getPassword())) {
							if (rst.getString("type_compte").equals(getType_compte())) {
								System.out.println(rst.getString("id"));
								FrameDashboard frame = new FrameDashboard();
								frame.setVisible(true);
								frm.dispose();
							}else{
								label.setText("Vous n'avez pas d'acc�s dans ce type de compte");
							}
						}else {
							label.setText("Email ou mot de passe incorect!");
						}
					}
			 }
		} catch (Exception e) {
			System.out.println("Erreur de connexion "+e.getMessage());
		}
		
	}
	
	public String getType_compte() {
		return type_compte;
	}

	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
