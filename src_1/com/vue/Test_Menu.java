package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;

public class Test_Menu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenuBar menuBar1 = new JMenuBar();
//	private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
//	private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");
	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");
	private final JPanel panelMenu_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_Menu frame = new Test_Menu();
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
	public Test_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//On met nos radios dans un ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(24, 55, 71, 77);
		contentPane.add(panelMenu);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		JMenu menu = new JMenu("");
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setIcon(new ImageIcon(Test_Menu.class.getResource("/Icon/filter_48px.png")));
		bg.add(jrmi1);
		bg.add(jrmi1);
		
		menu.add(jrmi1);
		menu.addSeparator();
		menu.add(jrmi2);
		
		jrmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Dans 1",null,JOptionPane.INFORMATION_MESSAGE);
				jrmi1.setSelected(true);
				jrmi2.setSelected(false);
			}
		});
		jrmi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Dans 2",null,JOptionPane.INFORMATION_MESSAGE);
				jrmi1.setSelected(false);
			}
		});
		this.menuBar.add(menu);
		panelMenu.add(menuBar);
		panelMenu_1.setBounds(164, 55, 71, 77);
		
		contentPane.add(panelMenu_1);
	}
}
