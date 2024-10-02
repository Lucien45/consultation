package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modele.Bureau;
import modele.Connexion;
import modele.Consultation;
import modele.Visiteur;
import view.FrameDashboard;

public class CRUD_Consultation extends JFrame {

	private JPanel contentPane;
	private JPanel center;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPrev;
	private JButton btnFirst;
	private JComboBox comboBox;
	private String action;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtAge;
	private JTextField txtContact;
	private JTextField txtAdresse;
	private JTextField txtMotif;
	int xx,xy;
	
	Bureau bur = new Bureau();
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxBureau;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxDirection;
	private JButton btnInserte;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxSexe;


	/**
	 * Create the frame.
	 */
	public CRUD_Consultation(JPanel center, JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,JComboBox comboBox,String action) {
		this.center = center;
		this.btnLast = btnLast;
		this.btnNext = btnNext;
		this.btnPrev = btnPrev;
		this.btnFirst = btnFirst;
		this.comboBox = comboBox;
		this.action = action;
		setTitle("Nouveau Consultation");
		setResizable(false);
		setBounds(100, 100, 576, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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
				CRUD_Consultation.this.setLocation(x - xx, y - xy);
			}
		});
		setUndecorated(true);
		
		JPanel panelTitre = new JPanel();
		panelTitre.setBackground(new Color(0, 51, 51));
		panelTitre.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitre = new JLabel("FORMULAIRE A REMPLIR");
		lblTitre.setForeground(new Color(0, 255, 255));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
		panelTitre.add(lblTitre, BorderLayout.CENTER);
		
		JPanel Iconminmaxclose = new JPanel();
		Iconminmaxclose.setLayout(null);
		Iconminmaxclose.setPreferredSize(new Dimension(100, 50));
		Iconminmaxclose.setBackground(new Color(0, 51, 51));
		panelTitre.add(Iconminmaxclose, BorderLayout.EAST);
		
		JPanel ButtonClose = new JPanel();
		ButtonClose.setBackground(new Color(0, 51, 51));
		ButtonClose.setBounds(54, 0, 46, 50);
		Iconminmaxclose.add(ButtonClose);
		ButtonClose.setLayout(new BorderLayout(0, 0));
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonClose.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonClose.setBackground(new Color(0, 51, 51));
			}
		});
		close.setIcon(new ImageIcon(CRUD_Consultation.class.getResource("/Icon/close_window_16px.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonClose.add(close, BorderLayout.CENTER);
		
		JPanel ButtonMin = new JPanel();
		ButtonMin.setBackground(new Color(0, 51, 51));
		ButtonMin.setBounds(1, 0, 51, 50);
		Iconminmaxclose.add(ButtonMin);
		ButtonMin.setLayout(new BorderLayout(0, 0));
		
		JLabel fullmin = new JLabel("");
		fullmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonMin.setBackground(new Color(102,255,204));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonMin.setBackground(new Color(0, 51, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(FrameDashboard.ICONIFIED);
			}
		});
		fullmin.setIcon(new ImageIcon(CRUD_Consultation.class.getResource("/Icon/subtract_16px.png")));
		fullmin.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonMin.add(fullmin, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		
		panelButton.setBackground(new Color(0, 51, 51));
		panelButton.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panelButton, BorderLayout.SOUTH);
		panelButton.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtonInserte = new JPanel();
		panelButtonInserte.setPreferredSize(new Dimension(275, 10));
		panelButtonInserte.setBorder(UIManager.getBorder("Button.border"));
		panelButtonInserte.setBackground(new Color(0, 51, 51));
		panelButton.add(panelButtonInserte, BorderLayout.CENTER);
		panelButtonInserte.setLayout(new BorderLayout(0, 0));
		
		btnInserte = new JButton("ENREISTRER");
		btnInserte.setIcon(new ImageIcon(CRUD_Consultation.class.getResource("/Icon/save_close_24px.png")));
		action_inserte();
		btnInserte.setForeground(new Color(0, 0, 0));
		btnInserte.setBorder(new LineBorder(new Color(0, 0, 51), 4));
		btnInserte.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelButtonInserte.add(btnInserte, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		panel.setPreferredSize(new Dimension(190, 10));
		panelButton.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 51));
		panel_1.setPreferredSize(new Dimension(190, 10));
		panelButton.add(panel_1, BorderLayout.EAST);
		
		JPanel panelgauche = new JPanel();
		panelgauche.setBackground(new Color(0, 51, 51));
		contentPane.add(panelgauche, BorderLayout.WEST);
		
		JPanel paneldroite = new JPanel();
		paneldroite.setBackground(new Color(0, 51, 51));
		contentPane.add(paneldroite, BorderLayout.EAST);
		
		JPanel panelFormulaire = new JPanel();
		panelFormulaire.setBackground(new Color(102, 255, 204));
		contentPane.add(panelFormulaire, BorderLayout.CENTER);
		panelFormulaire.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setHorizontalAlignment(SwingConstants.LEFT);
		lblNom.setBounds(50, 21, 39, 29);
		panelFormulaire.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtNom.setBounds(160, 21, 317, 29);
		panelFormulaire.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(50, 72, 100, 29);
		panelFormulaire.add(lblPrenom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtPrenom.setBounds(160, 72, 317, 29);
		panelFormulaire.add(txtPrenom);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(50, 119, 39, 29);
		panelFormulaire.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtAge.setBounds(160, 119, 317, 29);
		panelFormulaire.add(txtAge);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexe.setBounds(50, 173, 39, 29);
		panelFormulaire.add(lblSexe);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(50, 221, 100, 29);
		panelFormulaire.add(lblContact);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtContact.setBounds(160, 221, 317, 29);
		panelFormulaire.add(txtContact);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdresse.setBounds(50, 277, 100, 29);
		panelFormulaire.add(lblAdresse);
		
		txtAdresse = new JTextField();
		txtAdresse.setColumns(10);
		txtAdresse.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtAdresse.setBounds(160, 277, 317, 29);
		panelFormulaire.add(txtAdresse);
		
		JLabel lblMotif = new JLabel("Motif");
		lblMotif.setHorizontalAlignment(SwingConstants.LEFT);
		lblMotif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotif.setBounds(50, 323, 39, 29);
		panelFormulaire.add(lblMotif);
		
		txtMotif = new JTextField();
		txtMotif.setColumns(10);
		txtMotif.setBorder(new LineBorder(new Color(0, 255, 204), 2));
		txtMotif.setBounds(160, 323, 317, 29);
		panelFormulaire.add(txtMotif);
		
		JLabel lblBureau = new JLabel("Bureau");
		lblBureau.setHorizontalAlignment(SwingConstants.LEFT);
		lblBureau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBureau.setBounds(50, 372, 48, 29);
		panelFormulaire.add(lblBureau);
		
		cbxBureau = new JComboBox();
		cbxBureau.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxBureau.addItem("");
		bur.affiche_bureau(cbxBureau);
		cbxBureau.setBounds(160, 374, 317, 29);
		panelFormulaire.add(cbxBureau);
		
		JLabel lblDirection = new JLabel("Direction");
		lblDirection.setHorizontalAlignment(SwingConstants.LEFT);
		lblDirection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDirection.setBounds(50, 415, 54, 29);
		panelFormulaire.add(lblDirection);
		
		cbxDirection = new JComboBox();
		cbxDirection.addItem("");
		cbxDirection.setEnabled(false);
		affiche_direction(cbxBureau, cbxDirection);
		cbxDirection.setBounds(160, 415, 317, 29);
		panelFormulaire.add(cbxDirection);
		
		cbxSexe = new JComboBox();
		cbxSexe.addItem("");
		cbxSexe.addItem("Homme");
		cbxSexe.addItem("Femme");
		cbxSexe.setBounds(160, 175, 317, 29);
		panelFormulaire.add(cbxSexe);
		
		JLabel lblrepnom = new JLabel("*");
		lblrepnom.setForeground(Color.RED);
		lblrepnom.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepnom.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepnom.setBounds(99, 21, 26, 29);
		panelFormulaire.add(lblrepnom);
		
		JLabel lblrepage = new JLabel("*");
		lblrepage.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepage.setForeground(Color.RED);
		lblrepage.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepage.setBounds(88, 118, 26, 29);
		panelFormulaire.add(lblrepage);
		
		JLabel lblrepsexe = new JLabel("*");
		lblrepsexe.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepsexe.setForeground(Color.RED);
		lblrepsexe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepsexe.setBounds(88, 173, 26, 29);
		panelFormulaire.add(lblrepsexe);
		
		JLabel lblrepmotif = new JLabel("*");
		lblrepmotif.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepmotif.setForeground(Color.RED);
		lblrepmotif.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepmotif.setBounds(88, 323, 26, 29);
		panelFormulaire.add(lblrepmotif);
		
		JLabel lblrepbureau = new JLabel("*");
		lblrepbureau.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepbureau.setForeground(Color.RED);
		lblrepbureau.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepbureau.setBounds(99, 372, 26, 29);
		panelFormulaire.add(lblrepbureau);
		
		JLabel lblrepdirection = new JLabel("*");
		lblrepdirection.setHorizontalAlignment(SwingConstants.LEFT);
		lblrepdirection.setForeground(Color.RED);
		lblrepdirection.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblrepdirection.setBounds(114, 415, 26, 29);
		panelFormulaire.add(lblrepdirection);
	}
	private void action_inserte() {
		btnInserte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom,prenom,age,sexe,adresse,contact, motif,dir;
				
				nom = txtNom.getText();
				prenom = txtPrenom.getText();
				age = txtAge.getText();
				sexe = cbxSexe.getSelectedItem().toString();
				adresse = txtAdresse.getText();
				contact = txtContact.getText();
				motif = txtMotif.getText();
				dir = cbxDirection.getSelectedItem().toString();
				
				String req = "SELECT id FROM direction WHERE acronyme = ?";
				try (PreparedStatement statement = con.getConn().prepareStatement(req)) {
                    statement.setString(1, dir);
                    ResultSet resultSet = statement.executeQuery();
                    if(resultSet.next()) {
                        int direction = resultSet.getInt("id");
                        if(!nom.equals("")&&!age.equals("")&&!sexe.equals("")&&!motif.equals("")){
							Visiteur vis = new Visiteur(nom, prenom, direction, sexe, contact, adresse);
							vis.ajoute_visiteur();
							
							Consultation cons = new Consultation(direction, motif);
							cons.ajoute_consultation();
							dispose();
							
							center.removeAll();
							center.repaint();
							center.revalidate();
							
							Liste_consultation list = new Liste_consultation(btnLast, btnNext, btnPrev, btnFirst, comboBox, action);
							list.setVisible(true);
							center.add(list, BorderLayout.CENTER);
							center.repaint();
							center.revalidate();
						}else{
							JOptionPane.showMessageDialog(null,"Veillez remplire le formulaire!",null,JOptionPane.ERROR_MESSAGE);
						}
                    }
                }
                catch (SQLException ex) {
		        	JOptionPane.showMessageDialog(null,"Erreur dans direction!",null,JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		
	}
	
	private void affiche_direction(JComboBox jcb, JComboBox jcb1) {
		jcb.addActionListener(new ActionListener() {
		    @SuppressWarnings("unchecked")
			@Override
		    public void actionPerformed(ActionEvent e) {
		        String selectedBureauName = (String) jcb.getSelectedItem();
		        String query = "SELECT id FROM bureau WHERE nom = ?";
		        try (PreparedStatement statement = con.getConn().prepareStatement(query)) {
		            statement.setString(1, selectedBureauName);
		            ResultSet resultSet = statement.executeQuery();
		            jcb1.setEnabled(true);
		            if(resultSet.next()) {
		                int selectedBureauId = resultSet.getInt("id");
		                System.out.println("Selected bureau name: " + selectedBureauName);
		                System.out.println("Selected bureau ID: " + selectedBureauId);
		                jcb1.removeAllItems();
		                String query2 = "SELECT acronyme FROM direction WHERE idB = ?";
		                try (PreparedStatement statement2 = con.getConn().prepareStatement(query2)) {
		                    statement2.setInt(1, selectedBureauId);
		                    ResultSet resultSet2 = statement2.executeQuery();
		                    while (resultSet2.next()) {
		                        String name = resultSet2.getString("acronyme");
		                        jcb1.addItem(name);
		                        System.out.println("acronyme :"+name);
		                    }
		                }
		                catch (SQLException ex) {
				        	JOptionPane.showMessageDialog(null,"Erreur dans direction!",null,JOptionPane.ERROR_MESSAGE);
				        }
		            }
		        } catch (SQLException ex) {
		        	JOptionPane.showMessageDialog(null,"Erreur dans bureau!",null,JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
	}
}
