package com.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

public class Fenetre_1 extends JFrame {

	private JPanel contentPane;
	
	private JPopupMenu jpm = new JPopupMenu();
	private JMenu background = new JMenu("Couleur de fond");
	private JMenu couleur = new JMenu("Couleur de la forme");
	private JMenuItem launch = new JMenuItem("Lancer l'animation");
	private JMenuItem stop = new JMenuItem("Arrêter l'animation");
	private JMenuItem rouge = new JMenuItem("Rouge"),
	bleu = new JMenuItem("Bleu"),
	vert = new JMenuItem("Vert"),
	rougeBack = new JMenuItem("Rouge"),
	bleuBack = new JMenuItem("Bleu"),
	vertBack = new JMenuItem("Vert");

	private StopAnimationListener stopAnimation=new
	StopAnimationListener();
	private StartAnimationListener startAnimation=new
	StartAnimationListener();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre_1 frame = new Fenetre_1();
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
	public Fenetre_1() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(new BorderLayout());
		
		//On initialise le menu stop
		stop.setEnabled(false);
		//On affecte les écouteurs
//		stop.addActionListener(stopAnimation);
		launch.addActionListener(startAnimation);
		
		Component pan = null;
		pan.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent event){
				
				if(event.isPopupTrigger()){
					background.add(rougeBack);
					background.add(bleuBack);
					background.add(vertBack);
					couleur.add(rouge);
					couleur.add(bleu);
					couleur.add(vert);
					jpm.add(launch);
					jpm.add(stop);
					jpm.add(couleur);
					jpm.add(background);
					//La méthode qui va afficher le menu
					jpm.show(pan, event.getX(), event.getY());
				}
			}
		});
		contentPane.add(pan, BorderLayout.CENTER);
		this.setContentPane(contentPane);
		this.initMenu();
	}
	private void initMenu(){
		//Ajout du listener pour lancer l'animation
		//ATTENTION, LE LISTENER EST GLOBAL !!!
		launch.addActionListener(startAnimation);
		//On attribue l'accélerateur c
		launch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
		
	}
	private void go(){
		//La méthode n'a pas changé
	}
	public class StartAnimationListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
			"Voulez-vous lancer l'animation ?",
			"Lancement de l'animation",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				launch.setEnabled(false);
				stop.setEnabled(true);
				//On ajoute l'instruction pour le menu contextuel
				launch.setEnabled(false);
				stop.setEnabled(true);
//				animated = true;
//				t = new Thread(new PlayAnimation());
//				t.start();
			}
		}
	}
	
	public class StopAnimationListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
			"Voulez-vous lancer l'animation ?",
			"Lancement de l'animation",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.OK_OPTION){
				launch.setEnabled(false);
				stop.setEnabled(true);
				//On ajoute l'instruction pour le menu contextuel
				launch.setEnabled(false);
				stop.setEnabled(true);
//				animated = true;
//				t = new Thread(new PlayAnimation());
//				t.start();
			}
		}
	}
}
