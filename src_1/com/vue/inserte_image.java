package com.vue;

import java.awt.EventQueue;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Connexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class inserte_image extends JFrame {

	private JPanel contentPane;
	private JLabel labelImage_1;
	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	private JTextField txtImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inserte_image frame = new inserte_image();
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
	public inserte_image() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnParcour = new JButton("Parcourir");
		btnParcour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parcourirPhotoSansImage(txtImage, labelImage_1);
			}
		});
		btnParcour.setBounds(471, 288, 75, 38);
		contentPane.add(btnParcour);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String image = txtImage.getText();
				String rq="insert into user(photo) "
						+ "values('"+image+"')";
				try{
					st=con.getConn().createStatement();
					st.executeUpdate(rq);
					JOptionPane.showMessageDialog(null,"Enregistrement éffectué avec succès !",null,JOptionPane.INFORMATION_MESSAGE);
				}
				catch(SQLException ex){
			    	JOptionPane.showMessageDialog(null,"Erreur dans insertion!",null,JOptionPane.ERROR_MESSAGE);	
			    }
			}
		});
		btnAdd.setBounds(317, 382, 75, 24);
		contentPane.add(btnAdd);
		
		labelImage_1 = new JLabel("");
		labelImage_1.setHorizontalAlignment(SwingConstants.CENTER);
		labelImage_1.setBounds(50, 11, 375, 244);
		contentPane.add(labelImage_1);
		
		txtImage = new JTextField();
		txtImage.setBounds(168, 288, 249, 38);
		contentPane.add(txtImage);
		txtImage.setColumns(10);
	}
	
	/**
	 * Parcourir le photo
	 */
	public void parcourirPhotoSansImage(JTextField lblLien, JLabel lblLien1) {
		JFileChooser fch = new JFileChooser();
		FileNameExtensionFilter fnx = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
		fch.addChoosableFileFilter(fnx);
		int load = fch.showOpenDialog(null);
		if(load==fch.APPROVE_OPTION) {
			File f = fch.getSelectedFile();
			String path = f.getAbsolutePath();
			lblLien1.setIcon(new ImageIcon(path));
			lblLien.setText(path);
		}
	}
}
