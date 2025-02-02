package com.vue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class ZFenetre extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	private JMenu test1_2 = new JMenu("Sous ficher");
	private JMenu test2 = new JMenu("Edition");
	private JMenuItem item1 = new JMenuItem("Ouvrir");
	private JMenuItem item2 = new JMenuItem("Fermer");
	private JMenuItem item3 = new JMenuItem("Lancer");
	private JMenuItem item4 = new JMenuItem("Arr�ter");
	private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
	private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");
	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZFenetre frame = new ZFenetre();
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
	public ZFenetre() {
		this.setSize(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//On initialise nos menus
		this.test1.add(item1);
		//On ajoute les �l�ments dans notre sous-menu
		this.test1_2.add(jcmi1);
		this.test1_2.add(jcmi2);
		//Ajout d'un s�parateur
		this.test1_2.addSeparator();
		//On met nos radios dans un ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrmi1);
		bg.add(jrmi1);
		//On pr�s�lectionne la premi�re radio
		jrmi1.setSelected(true);
		this.test1_2.add(jrmi1);
		this.test1_2.add(jrmi2);
		//Ajout du sous-menu dans notre menu
		this.test1.add(this.test1_2);
		//Ajout d'un s�parateur
		this.test1.addSeparator();
		item2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.test1.add(item2);
		this.test2.add(item3);
		this.test2.add(item4);
		this.menuBar.add(test1);
		this.menuBar.add(test2);
		this.setJMenuBar(menuBar);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
	}

}
