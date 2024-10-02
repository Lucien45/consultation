package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

import com.vue.Test_Menu;

import controller.Liste_Directions;
import controller.Liste_consultation;

/**
 * 
 * @author HP
 *
 */

public class PanelDirections extends JPanel {
	/**
	 * Create the panel.
	 */
	private JPanel panelCentre;
	private Liste_Directions list;
	private JMenuBar menuBar = new JMenuBar();
	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("ordre croissant");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("ordre décroissant");
	private JButton btnLast;
	private JButton btnNext;
	private JComboBox comboChec;
	private JButton btnPrev;
	private JButton btnFirst;
	
	public PanelDirections() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 964, 690);
		setSize(897,752);
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 50));
		Header.setBackground(SystemColor.inactiveCaption);
		add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		panelCentre = new JPanel();
		panelCentre.setBackground(SystemColor.inactiveCaption);
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelContent.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
//		list = new Liste_Directions();
//		list.liste_normal();
//		list.setVisible(true);
//		panelCentre.add(list, BorderLayout.CENTER);
		
		
		JPanel paneLDoite = new JPanel();
		paneLDoite.setBackground(SystemColor.inactiveCaption);
		paneLDoite.setPreferredSize(new Dimension(40, 10));
		panelContent.add(paneLDoite, BorderLayout.EAST);
		
		JPanel paneLGauche = new JPanel();
		paneLGauche.setBackground(SystemColor.inactiveCaption);
		paneLGauche.setPreferredSize(new Dimension(40, 10));
		panelContent.add(paneLGauche, BorderLayout.WEST);
		
		JPanel paneLNord = new JPanel();
		paneLNord.setBackground(SystemColor.inactiveCaption);
		paneLNord.setPreferredSize(new Dimension(10, 100));
		panelContent.add(paneLNord, BorderLayout.NORTH);
		paneLNord.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDeux = new JPanel();
		panelDeux.setBackground(SystemColor.inactiveCaption);
		panelDeux.setPreferredSize(new Dimension(10, 80));
		paneLNord.add(panelDeux, BorderLayout.NORTH);
		panelDeux.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(SystemColor.inactiveCaption);
		panelGauche.setPreferredSize(new Dimension(247, 0));
		panelDeux.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelButton = new JPanel();
		panelButton.setPreferredSize(new Dimension(250, 0));
		panelButton.setBackground(SystemColor.inactiveCaption);
		panelDeux.add(panelButton, BorderLayout.EAST);
		panelButton.setLayout(new BorderLayout(0, 0));
		
		JPanel panelService = new JPanel();
		panelService.setBackground(SystemColor.inactiveCaption);
		panelDeux.add(panelService, BorderLayout.CENTER);
		panelService.setLayout(new BorderLayout(0, 0));
		
		JPanel panelC1 = new JPanel();
		panelC1.setBackground(SystemColor.inactiveCaption);
		panelC1.setPreferredSize(new Dimension(243, 10));
		panelService.add(panelC1, BorderLayout.WEST);
		panelC1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setPreferredSize(new Dimension(74, 10));
		panelC1.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 15));
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFilter = new JLabel("Filtrer");
		lblFilter.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilter.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_3.add(lblFilter, BorderLayout.CENTER);
		
		JPanel panel_Filtrage = new JPanel();
		panel_Filtrage.setBackground(SystemColor.inactiveCaption);
		panel.add(panel_Filtrage, BorderLayout.CENTER);
		panel_Filtrage.setLayout(new BorderLayout(0, 0));
		
		JMenu menu = new JMenu("");
		menu.setBackground(SystemColor.inactiveCaption);
		menu.setHorizontalAlignment(SwingConstants.CENTER);
		menu.setIcon(new ImageIcon(Test_Menu.class.getResource("/Icon/filter_48px.png")));
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrmi1);
		bg.add(jrmi1);
		menu.add(jrmi1);
		menu.addSeparator();
		menu.add(jrmi2);
//		jrmi1.setSelected(true);
		
		jrmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				liste_croissant();
			}
		});
		jrmi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Décroissant",null,JOptionPane.INFORMATION_MESSAGE);
				panelCentre.removeAll();
				panelCentre.repaint();
				panelCentre.revalidate();
				
				list = new Liste_Directions(btnLast, btnNext, btnPrev, btnFirst, comboChec, "filtrage");
				list.setVisible(true);
				
				panelCentre.add(list, BorderLayout.CENTER);
				panelCentre.repaint();
				panelCentre.revalidate();
				jrmi1.setSelected(false);
			}
		});
		menuBar.setBackground(SystemColor.inactiveCaption);
		this.menuBar.add(menu);
		panel_Filtrage.add(menuBar, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setPreferredSize(new Dimension(80, 10));
		panelC1.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Titre_pdf = new JPanel();
		panel_1.add(panel_Titre_pdf, BorderLayout.SOUTH);
		panel_Titre_pdf.setPreferredSize(new Dimension(10, 15));
		panel_Titre_pdf.setBackground(SystemColor.inactiveCaption);
		panel_Titre_pdf.setLayout(new BorderLayout(0, 0));
		
		JLabel lblImprimer = new JLabel("Vers pdf");
		lblImprimer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblImprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblImprimer.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_Titre_pdf.add(lblImprimer, BorderLayout.CENTER);
		
		JPanel panel_pdf = new JPanel();
		panel_1.add(panel_pdf, BorderLayout.CENTER);
		panel_pdf.setBackground(SystemColor.inactiveCaption);
		panel_pdf.setLayout(new BorderLayout(0, 0));
		
		JLabel lblpdf = new JLabel("");
		lblpdf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_pdf.setBackground(new Color(255, 99, 71));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_pdf.setBackground(SystemColor.inactiveCaption);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de vouloir imprimer ce document","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					
				}
				
			}
		});
		lblpdf.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\pdf_48px.png"));
		lblpdf.setHorizontalAlignment(SwingConstants.CENTER);
		panel_pdf.add(lblpdf, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panelC1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_2.add(panel_3_1, BorderLayout.SOUTH);
		panel_3_1.setPreferredSize(new Dimension(10, 15));
		panel_3_1.setBackground(SystemColor.inactiveCaption);
		panel_3_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRafraichir = new JLabel("Rafraichir");
		lblRafraichir.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRafraichir.setHorizontalAlignment(SwingConstants.CENTER);
		lblRafraichir.setFont(new Font("Times New Roman", Font.BOLD, 12));
		panel_3_1.add(lblRafraichir, BorderLayout.CENTER);
		
		JPanel panel_Refresh = new JPanel();
		panel_2.add(panel_Refresh, BorderLayout.CENTER);
		panel_Refresh.setBackground(SystemColor.inactiveCaption);
		panel_Refresh.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRefresh = new JLabel("");
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Refresh.setBackground(new Color(1,153,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Refresh.setBackground(SystemColor.inactiveCaption);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
//				panelCentre.removeAll();
//				panelCentre.repaint();
//				panelCentre.revalidate();
//				
//				list = new Liste_Directions();
//				list.liste_normal();
//				list.setVisible(true);
//				
//				panelCentre.add(list, BorderLayout.CENTER);
//				panelCentre.repaint();
//				panelCentre.revalidate();
//				JOptionPane.showMessageDialog(null,"actulisez!",null,JOptionPane.INFORMATION_MESSAGE);
				
				refresh();
				
			}
		});
		lblRefresh.setIcon(new ImageIcon(PanelDirections.class.getResource("/Icon/refresh_40px.png")));
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Refresh.add(lblRefresh, BorderLayout.CENTER);
		
		JPanel panelC2 = new JPanel();
		panelC2.setBackground(SystemColor.inactiveCaption);
		panelC2.setPreferredSize(new Dimension(153, 10));
		panelService.add(panelC2, BorderLayout.EAST);
		panelC2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panel_5.setPreferredSize(new Dimension(75, 10));
		panelC2.add(panel_5, BorderLayout.WEST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaption);
		panel_6.setPreferredSize(new Dimension(75, 10));
		panelC2.add(panel_6, BorderLayout.EAST);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setPreferredSize(new Dimension(10, 15));
		panel_3_1_2.setBackground(SystemColor.inactiveCaption);
		panel_6.add(panel_3_1_2, BorderLayout.SOUTH);
		panel_3_1_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_excel = new JPanel();
		panel_excel.setBackground(SystemColor.inactiveCaption);
		panel_6.add(panel_excel, BorderLayout.CENTER);
		panel_excel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_SepBas = new JPanel();
		panel_SepBas.setPreferredSize(new Dimension(10, 3));
		panelC1.add(panel_SepBas, BorderLayout.SOUTH);
		
		JPanel panelUn = new JPanel();
		panelUn.setPreferredSize(new Dimension(10, 20));
		panelUn.setBackground(SystemColor.inactiveCaption);
		paneLNord.add(panelUn, BorderLayout.SOUTH);
		panelUn.setLayout(new BorderLayout(0, 0));
		
		JPanel paneLSud = new JPanel();
		paneLSud.setBackground(SystemColor.inactiveCaption);
		paneLSud.setPreferredSize(new Dimension(10, 70));
		panelContent.add(paneLSud, BorderLayout.SOUTH);
		paneLSud.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_h = new JPanel();
		panel_h.setPreferredSize(new Dimension(10, 15));
		panel_h.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_h, BorderLayout.NORTH);
		
		JPanel panel_b = new JPanel();
		panel_b.setPreferredSize(new Dimension(10, 15));
		panel_b.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_b, BorderLayout.SOUTH);
		
		JPanel panel_Pagination = new JPanel();
		panel_Pagination.setPreferredSize(new Dimension(420, 10));
		panel_Pagination.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_Pagination, BorderLayout.EAST);
		panel_Pagination.setLayout(null);
		
		btnFirst = new JButton("First");
		
		btnFirst.setBounds(0, 11, 80, 29);
		panel_Pagination.add(btnFirst);
		
		btnPrev = new JButton("Previous");
		btnPrev.setBounds(97, 11, 73, 29);
		panel_Pagination.add(btnPrev);
		
		comboChec = new JComboBox();
		comboChec.setBounds(180, 12, 43, 26);
		panel_Pagination.add(comboChec);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(233, 11, 73, 29);
		panel_Pagination.add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.setBounds(323, 11, 80, 29);
		panel_Pagination.add(btnLast);
		
		list = new Liste_Directions(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		panelCentre.add(list, BorderLayout.CENTER);
	}

	protected void refresh() {
		panelCentre.removeAll();
		panelCentre.repaint();
		panelCentre.revalidate();
		
		list = new Liste_Directions(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		panelCentre.add(list, BorderLayout.CENTER);
		panelCentre.repaint();
		panelCentre.revalidate();
		JOptionPane.showMessageDialog(null,"actulisez!",null,JOptionPane.INFORMATION_MESSAGE);
		
	}

	protected void liste_croissant() {
		JOptionPane.showMessageDialog(null,"croissant",null,JOptionPane.INFORMATION_MESSAGE);
		panelCentre.removeAll();
		panelCentre.repaint();
		panelCentre.revalidate();
		
		list = new Liste_Directions(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		panelCentre.add(list, BorderLayout.CENTER);
		panelCentre.repaint();
		panelCentre.revalidate();
		jrmi2.setSelected(false);
		
	}
}
