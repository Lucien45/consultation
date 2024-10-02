package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Connexion;
import modele.Direction;
import modele.User;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtPhoto;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmePassword;
	int xx,xy;
	private boolean a;
	private JButton btnSignup;
	private JButton btnLogin;
	private JComboBox comboDirection;
	
	Direction dir = new Direction();
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	private JComboBox comboSexe;
	private JComboBox comboType;
	private JTextField txtCode;
	
	private final Image eye;
	private final Image eye_hide;
	private boolean hide = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Signup() {
		setBounds(100, 100, 827, 719);
		setLocation(200,10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		eye = new ImageIcon("C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\eye_16px.png").getImage();
		eye_hide = new ImageIcon("C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\hide_16px.png").getImage();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Signup.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(800, 50));
		header.setBackground(new Color(47, 79, 79));
		contentPane.add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));
		
		JPanel icon_min_max_close = new JPanel();
		icon_min_max_close.setLayout(null);
		icon_min_max_close.setPreferredSize(new Dimension(150, 50));
		icon_min_max_close.setBackground(new Color(47, 79, 79));
		header.add(icon_min_max_close, BorderLayout.EAST);
		
		JPanel ButtonClose = new JPanel();
		ButtonClose.setBackground(new Color(47, 79, 79));
		ButtonClose.setBounds(104, 0, 46, 50);
		icon_min_max_close.add(ButtonClose);
		ButtonClose.setLayout(new BorderLayout(0, 0));
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					Signup.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(ButtonClose, new Color(25,29,74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(ButtonClose, new Color(47, 79, 79));
			}
		});
		close.setIcon(new ImageIcon(Signup.class.getResource("/Icon/close_window_16px.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonClose.add(close, BorderLayout.CENTER);
		
		JPanel ButtonMin = new JPanel();
		ButtonMin.setBackground(new Color(47, 79, 79));
		ButtonMin.setBounds(58, 0, 46, 50);
		icon_min_max_close.add(ButtonMin);
		ButtonMin.setLayout(new BorderLayout(0, 0));
		
		JLabel fullmin = new JLabel("");
		fullmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(ButtonMin, new Color(25,29,74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(ButtonMin, new Color(47, 79, 79));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(Signup.ICONIFIED);
			}
		});
		fullmin.setIcon(new ImageIcon(Signup.class.getResource("/Icon/subtract_16px.png")));
		fullmin.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonMin.add(fullmin, BorderLayout.CENTER);
		
		JPanel Content = new JPanel();
		Content.setBackground(new Color(211, 211, 211));
		contentPane.add(Content, BorderLayout.CENTER);
		Content.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitre = new JPanel();
		panelTitre.setBackground(new Color(211, 211, 211));
		panelTitre.setPreferredSize(new Dimension(10, 85));
		Content.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("  INSCRIVEZ - VOUS");
		lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/Icon/logo_4.png")));
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitre.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(211, 211, 211));
		panelButtons.setPreferredSize(new Dimension(10, 100));
		Content.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(408, 10));
		panel.setBackground(new Color(211, 211, 211));
		panelButtons.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		btnSignup = new JButton("Inscrir");
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignup.setBackground(new Color(30,60,60));
				btnSignup.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignup.setBackground(new Color(220, 20, 60));
				btnSignup.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnSignup.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnSignup.setBackground(new Color(30,60,60));
			}
		});
		btnSignup.setIcon(new ImageIcon(Signup.class.getResource("/Icon/add_user_male_26px.png")));
		btnSignup.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSignup.setBackground(new Color(220, 20, 60));
		btnSignup.setBounds(119, 26, 125, 40);
		panel.add(btnSignup);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(408, 10));
		panel_1.setBackground(new Color(211, 211, 211));
		panelButtons.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);
		
		JLabel lblMessage = new JLabel("Déja une compte ?");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMessage.setBounds(22, 26, 143, 40);
		panel_1.add(lblMessage);
		
		btnLogin = new JButton("se connecter");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(30,60,60));
				btnLogin.setForeground(Color.green);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 128, 0));
				btnLogin.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btnLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLogin.setBackground(new Color(30,60,60));
			}
		});
		btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrameLogin framelogin = new FrameLogin();
					framelogin.setVisible(true);
					Signup.this.dispose();
			}
		});
		btnLogin.setIcon(new ImageIcon(Signup.class.getResource("/Icon/login_24px.png")));
		btnLogin.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(new Color(0, 128, 0));
		btnLogin.setBounds(195, 26, 158, 40);
		panel_1.add(btnLogin);
		
		JPanel panelFormulaires = new JPanel();
		panelFormulaires.setBackground(new Color(211, 211, 211));
		Content.add(panelFormulaires, BorderLayout.CENTER);
		panelFormulaires.setLayout(new BorderLayout(0, 0));
		
		JPanel Formumlaire_gauche = new JPanel();
		Formumlaire_gauche.setPreferredSize(new Dimension(408, 10));
		Formumlaire_gauche.setBackground(new Color(211, 211, 211));
		panelFormulaires.add(Formumlaire_gauche, BorderLayout.WEST);
		Formumlaire_gauche.setLayout(null);
		
		txtNom = new JTextField();
		txtNom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNom.getText().equals("Nom")) {
					txtNom.setText("");
				}else {
					txtNom.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNom.getText().equals("")) {
					txtNom.setText("Nom");
				}
			}
		});
		txtNom.setBackground(new Color(230, 230, 250));
		txtNom.setText("Nom");
		txtNom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNom.setColumns(10);
		txtNom.setBorder(null);
		txtNom.setBounds(10, 34, 288, 31);
		Formumlaire_gauche.add(txtNom);
		
		JLabel lblIconFirstName = new JLabel("");
		lblIconFirstName.setIcon(new ImageIcon(Signup.class.getResource("/Icon/male_user_24px.png")));
		lblIconFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconFirstName.setBounds(309, 34, 43, 31);
		Formumlaire_gauche.add(lblIconFirstName);
		
		txtAge = new JTextField();
		txtAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtAge.getText().equals("Age")) {
					txtAge.setText("");
				}else {
					txtAge.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAge.getText().equals("")) {
					txtAge.setText("Age");
				}
			}
		});
		txtAge.setBackground(new Color(230, 230, 250));
		txtAge.setText("Age");
		txtAge.setFont(new Font("Arial", Font.PLAIN, 12));
		txtAge.setColumns(10);
		txtAge.setBorder(null);
		txtAge.setBounds(10, 102, 288, 31);
		Formumlaire_gauche.add(txtAge);
		
		JLabel lblIconAge = new JLabel("");
		lblIconAge.setIcon(new ImageIcon(Signup.class.getResource("/Icon/age_24px.png")));
		lblIconAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconAge.setBounds(309, 102, 43, 31);
		Formumlaire_gauche.add(lblIconAge);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Email")) {
					txtEmail.setText("");
				}else {
					txtEmail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setText("Email");
				}
			}
		});
		txtEmail.setBackground(new Color(230, 230, 250));
		txtEmail.setText("Email");
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(10, 164, 288, 31);
		Formumlaire_gauche.add(txtEmail);
		
		JLabel lblIconEmail = new JLabel("");
		lblIconEmail.setIcon(new ImageIcon(Signup.class.getResource("/Icon/gmail_logo_24px.png")));
		lblIconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmail.setBounds(309, 164, 43, 31);
		Formumlaire_gauche.add(lblIconEmail);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				} else {
					pwdPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setBackground(new Color(230, 230, 250));
		pwdPassword.setText("Password");
		pwdPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		pwdPassword.setEchoChar(' ');
		pwdPassword.setBorder(null);
		pwdPassword.setBounds(10, 223, 288, 31);
		Formumlaire_gauche.add(pwdPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setIcon(new ImageIcon(Signup.class.getResource("/Icon/password_24px.png")));
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(309, 223, 43, 31);
		Formumlaire_gauche.add(lblIconPassword);
		
		comboSexe = new JComboBox();
		comboSexe.addItem("");
		comboSexe.addItem("Homme");
		comboSexe.addItem("Femme");
		comboSexe.setBounds(10, 299, 288, 31);
		Formumlaire_gauche.add(comboSexe);
		
		JLabel lblIconSexe = new JLabel("Sexe");
		lblIconSexe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSexe.setBounds(309, 300, 43, 29);
		Formumlaire_gauche.add(lblIconSexe);
		
		txtCode = new JTextField();
		txtCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCode.getText().equals("Entrer le code")) {
					txtCode.setText("");
				}else {
					txtCode.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtCode.getText().equals("")) {
					txtCode.setText("Entrer le code");
				}
			}
		});
		txtCode.setEnabled(false);
		txtCode.setBackground(new Color(230, 230, 250));
		txtCode.setText("Entrer le code");
		txtCode.setBounds(10, 425, 143, 31);
		Formumlaire_gauche.add(txtCode);
		txtCode.setColumns(10);
		
		comboType = new JComboBox();
		comboType.addItem("");
		comboType.addItem("Admin");
		comboType.addItem("Secretaire");
		comboType.addItem("Autre");
		action_combo(comboType, txtCode);
		comboType.setBounds(266, 360, 132, 31);
		Formumlaire_gauche.add(comboType);
		
		JPanel Formulaire_droite = new JPanel();
		Formulaire_droite.setPreferredSize(new Dimension(408, 10));
		Formulaire_droite.setBackground(new Color(211, 211, 211));
		panelFormulaires.add(Formulaire_droite, BorderLayout.EAST);
		Formulaire_droite.setLayout(null);
		
		txtPrenom = new JTextField();
		txtPrenom.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPrenom.getText().equals("Prenom")) {
					txtPrenom.setText("");
				}else {
					txtPrenom.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPrenom.getText().equals("")) {
					txtPrenom.setText("Prenom");
				}
			}
		});
		txtPrenom.setBackground(new Color(230, 230, 250));
		txtPrenom.setText("Prenom");
		txtPrenom.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPrenom.setColumns(10);
		txtPrenom.setBorder(null);
		txtPrenom.setBounds(10, 31, 301, 35);
		Formulaire_droite.add(txtPrenom);
		
		JLabel lblIconLastName = new JLabel("");
		lblIconLastName.setIcon(new ImageIcon(Signup.class.getResource("/Icon/male_user_24px.png")));
		lblIconLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLastName.setBounds(333, 31, 44, 35);
		Formulaire_droite.add(lblIconLastName);
		
		txtPhoto = new JTextField();
		txtPhoto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhoto.getText().equals("Photo")) {
					txtPhoto.setText("");
				} else {
					txtPhoto.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPhoto.getText().equals("")) {
					txtPhoto.setText("Photo");
				}
			}
		});
		txtPhoto.setBackground(new Color(230, 230, 250));
		txtPhoto.setText("Photo");
		txtPhoto.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPhoto.setColumns(10);
		txtPhoto.setBorder(null);
		txtPhoto.setBounds(10, 96, 264, 35);
		Formulaire_droite.add(txtPhoto);
		
		JButton btnParcour = new JButton("Parcourir");
		btnParcour.setIcon(new ImageIcon(Signup.class.getResource("/Icon/browse_folder_24px.png")));
		btnParcour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parcourirPhotoSansImage(txtPhoto);
			}
		});
		btnParcour.setBounds(284, 96, 124, 35);
		Formulaire_droite.add(btnParcour);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBackground(new Color(230, 230, 250));
		txtUsername.setText("Username");
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		txtUsername.setBorder(null);
		txtUsername.setBounds(10, 170, 301, 35);
		Formulaire_droite.add(txtUsername);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setIcon(new ImageIcon(Signup.class.getResource("/Icon/username_24px.png")));
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setBounds(333, 170, 44, 35);
		Formulaire_droite.add(lblIconUsername);
		
		pwdConfirmePassword = new JPasswordField();
		pwdConfirmePassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdConfirmePassword.getText().equals("Confirmer")) {
					pwdConfirmePassword.setEchoChar('●');
					pwdConfirmePassword.setText("");
				} else {
					pwdConfirmePassword.selectAll();
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (pwdConfirmePassword.getText().equals("")) {
					pwdConfirmePassword.setText("Confirmer");
					pwdConfirmePassword.setEchoChar((char)0);
				}
			}
		});
		pwdConfirmePassword.setBackground(new Color(230, 230, 250));
		pwdConfirmePassword.setText("Confirmer");
		pwdConfirmePassword.setFont(new Font("Arial", Font.PLAIN, 12));
		pwdConfirmePassword.setEchoChar(' ');
		pwdConfirmePassword.setBorder(null);
		pwdConfirmePassword.setBounds(10, 231, 301, 35);
		Formulaire_droite.add(pwdConfirmePassword);
		
		JLabel lblIconPassword_1 = new JLabel("");
		lblIconPassword_1.setIcon(new ImageIcon(Signup.class.getResource("/Icon/password_24px.png")));
		lblIconPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword_1.setBounds(333, 231, 44, 35);
		Formulaire_droite.add(lblIconPassword_1);
		
		comboDirection = new JComboBox();
		comboDirection.addItem("");
		dir.affiche_all_direction(comboDirection);
		comboDirection.setBounds(10, 293, 301, 35);
		Formulaire_droite.add(comboDirection);
		
		JLabel lblIconDirection = new JLabel("Direction");
		lblIconDirection.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconDirection.setBounds(330, 291, 68, 39);
		Formulaire_droite.add(lblIconDirection);
		
		JLabel lblIconType = new JLabel("Type Compte");
		lblIconType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIconType.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconType.setBounds(10, 355, 128, 39);
		Formulaire_droite.add(lblIconType);
		setUndecorated(true);
		inscription();
	}
	
	private void action_combo(JComboBox combo, JTextField txtCode2) {
		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedBureauName = (String) combo.getSelectedItem();
				if (selectedBureauName.equals("Admin")) {
					txtCode2.setEnabled(true);
				}else {
					txtCode2.setEnabled(false);
				}
			}
		});
	}
	
	public void createshowhide(Graphics2D g2) {
		 int x = getWidth() -30+5;
		 int y = (getHeight() - 20) / 20;
		 g2.drawImage(hide ? eye_hide : eye,x,y,null);
	}

	/**
	 * Inscription
	 */
	private void inscription() {
		btnSignup.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nom, prenom, sexe, photo, username, email, password, confirmer,direct, a, type,c;
				int age, direction = 0, code;
				
				nom = txtNom.getText();
				prenom = txtPrenom.getText();
				a = txtAge.getText();
				sexe = comboSexe.getSelectedItem().toString();
				photo = txtPhoto.getText();
				username = txtUsername.getText();
				email = txtEmail.getText();
				password = pwdPassword.getText();
				confirmer = pwdConfirmePassword.getText();
				c = txtCode.getText();
				direct = comboDirection.getSelectedItem().toString();
				type = comboType.getSelectedItem().toString();
				System.out.println("password :"+password+" | confirme: "+confirmer);
				if (type.equals("Admin")) {
					if(!nom.equals("") && !prenom.equals("") && !a.equals("") && !sexe.equals("") && !photo.equals("") && 
					!username.equals("")&& !email.equals("")&& !password.equals("")&& !confirmer.equals("")&& !direct.equals("")&& !c.equals("")) {
						System.out.println("ato");
						code = Integer.parseInt(c);
						age = Integer.parseInt(a);
						
					}else {
						JOptionPane.showMessageDialog(null,"Veillez remplir touts les champs",null,JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if(!nom.equals("") && !prenom.equals("") && !a.equals("") && !sexe.equals("") && !photo.equals("") && 
							!username.equals("")&& !email.equals("")&& !password.equals("")&& !confirmer.equals("")&& !direct.equals("")) {
							if (password.equals(confirmer)) {
								age = Integer.parseInt(a);
								String req = "SELECT id FROM direction WHERE acronyme = ?";
								try (PreparedStatement statement = con.getConn().prepareStatement(req)) {
				                    statement.setString(1, direct);
				                    ResultSet resultSet = statement.executeQuery();
				                    if(resultSet.next()) {
				                        direction = resultSet.getInt("id");
										User u = new User(nom, prenom, age, sexe, photo, username, email, password, direction, type);
										u.signup();
				                    }
				                }
				                catch (SQLException ex) {
						        	JOptionPane.showMessageDialog(null,"Erreur dans direction!",null,JOptionPane.ERROR_MESSAGE);
						        }
								
							}else if(!password.equals(confirmer)){
								JOptionPane.showMessageDialog(null,"verifier le mot de passe",null,JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null,"Veillez remplir touts les champs",null,JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		});
		
	}
	
	/**
	 * Parcourir le photo
	 */
	public void parcourirPhotoSansImage(JTextField lblLien) {
		JFileChooser fch = new JFileChooser();
		FileNameExtensionFilter fnx = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
		fch.addChoosableFileFilter(fnx);
		int load = fch.showOpenDialog(null);
		if(load==fch.APPROVE_OPTION) {
			File f = fch.getSelectedFile();
			String path = f.getAbsolutePath();
			lblLien.setText(path);
		}
	}
	
	public void changeImage(JLabel button, String ressourceImage) {
		ImageIcon aimg = new ImageIcon(ressourceImage);
		button.setIcon(aimg);
	}
	
	public void changecolor(JPanel hover, Color rand) {
		hover.setBackground(rand);
	}
	public void clickmenu(JPanel h1, int numberbool) {
		if(numberbool == 1) {
			h1.setBackground(new Color(247,78,105));
		}else {
			h1.setBackground(new Color(0, 0, 51));
		}
	}
	public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {
		if(dashboard == true) {
			menushowhide.setPreferredSize(new Dimension(50,menushowhide.getHeight()));
			changeImage(button,"C:\\Users\\HP\\eclipse-workspace1\\Dashboard\\src\\Icon\\menu_32px.png");
		}else {
			menushowhide.setPreferredSize(new Dimension(270,menushowhide.getHeight()));
			changeImage(button,"C:\\Users\\HP\\eclipse-workspace1\\Dashboard\\src\\Icon\\back_32px.png");
		}
	}
}
