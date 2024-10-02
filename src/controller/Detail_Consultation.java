package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modele.Consultation;

public class Detail_Consultation extends JFrame {

	private JPanel contentPane;
	private JLabel lblID;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblAge;
	private JLabel lblContact;
	private JLabel lblAdresse;
	private JLabel lblDirection;
	private JLabel lblMotif;
	private JLabel lblDate;
	private JLabel lblSexe;
	private int id;

	/**
	 * Create the frame.
	 */
	public Detail_Consultation(int id) {
		this.id = id;
		setResizable(false);
		setType(Type.UTILITY);
		setBounds(100, 100, 665, 371);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(10, 50));
		panelTitre.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDetail = new JLabel("DETAIL DU CONSULTATION");
		lblDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetail.setForeground(Color.BLACK);
		lblDetail.setFont(new Font("Arial", Font.BOLD, 30));
		panelTitre.add(lblDetail, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(5, 10));
		panelTitre.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 5));
		panelTitre.add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(5, 10));
		panelTitre.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 5));
		panelTitre.add(panel_3, BorderLayout.NORTH);
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(null);
		
		JLabel lblTitreID = new JLabel("IDENTIFIANT : ");
		lblTitreID.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitreID.setBounds(200, 11, 175, 46);
		panelContent.add(lblTitreID);
		
		lblID = new JLabel("0");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(376, 11, 46, 46);
		panelContent.add(lblID);
		
		JLabel lblTitreNom = new JLabel("Nom: ");
		lblTitreNom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreNom.setBounds(10, 59, 73, 34);
		panelContent.add(lblTitreNom);
		
		lblNom = new JLabel("");
		lblNom.setBounds(93, 59, 259, 34);
		panelContent.add(lblNom);
		
		JLabel lblTitrePrenom = new JLabel("Prenom: ");
		lblTitrePrenom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitrePrenom.setBounds(10, 104, 73, 34);
		panelContent.add(lblTitrePrenom);
		
		lblPrenom = new JLabel("");
		lblPrenom.setBounds(93, 104, 259, 34);
		panelContent.add(lblPrenom);
		
		JLabel lblTitreAge = new JLabel("Age: ");
		lblTitreAge.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreAge.setBounds(10, 149, 73, 34);
		panelContent.add(lblTitreAge);
		
		lblAge = new JLabel("");
		lblAge.setBounds(93, 149, 237, 34);
		panelContent.add(lblAge);
		
		JLabel lblTitreSexe = new JLabel("Sexe: ");
		lblTitreSexe.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreSexe.setBounds(10, 194, 73, 34);
		panelContent.add(lblTitreSexe);
		
		lblSexe = new JLabel("");
		lblSexe.setBounds(93, 194, 259, 34);
		panelContent.add(lblSexe);
		
		JLabel lblTitreContact = new JLabel("Contact: ");
		lblTitreContact.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreContact.setBounds(10, 239, 73, 34);
		panelContent.add(lblTitreContact);
		
		lblContact = new JLabel("");
		lblContact.setBounds(93, 239, 259, 34);
		panelContent.add(lblContact);
		
		JLabel lblTitreAdresse = new JLabel("Adresse: ");
		lblTitreAdresse.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreAdresse.setBounds(366, 59, 73, 34);
		panelContent.add(lblTitreAdresse);
		
		lblAdresse = new JLabel("");
		lblAdresse.setBounds(449, 59, 182, 34);
		panelContent.add(lblAdresse);
		
		lblDate = new JLabel("");
		lblDate.setBounds(432, 104, 199, 34);
		panelContent.add(lblDate);
		
		JLabel lblTitreDate = new JLabel("Date: ");
		lblTitreDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreDate.setBounds(370, 104, 52, 34);
		panelContent.add(lblTitreDate);
		
		JLabel lblTitreModtif = new JLabel("Motif: ");
		lblTitreModtif.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreModtif.setBounds(370, 149, 52, 34);
		panelContent.add(lblTitreModtif);
		
		lblMotif = new JLabel("");
		lblMotif.setBounds(432, 149, 199, 34);
		panelContent.add(lblMotif);
		
		JLabel lblTitreDirection = new JLabel("Direction: ");
		lblTitreDirection.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitreDirection.setBounds(370, 194, 73, 34);
		panelContent.add(lblTitreDirection);
		
		lblDirection = new JLabel("");
		lblDirection.setBounds(461, 194, 170, 34);
		panelContent.add(lblDirection);
		
		Detail();
	}

	private void Detail() {
		Consultation cons = new Consultation(id);
		cons.detail_consultation(lblID, lblNom, lblPrenom, lblAge, lblSexe, lblContact, lblAdresse, lblDirection, lblMotif, lblDate);
	}
}
