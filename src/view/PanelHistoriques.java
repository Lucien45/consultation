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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Liste_Attente;
import controller.Liste_Historique;
import modele.Connexion;
import modele.Consultation;
import modele.Direction;

import javax.swing.JButton;

public class PanelHistoriques extends JPanel {

	private JPanel panelCentre;
	private Liste_Historique list;
	private Direction dir = new Direction();
	private JComboBox combo_direction;
	private JLabel lblNombre;
	Connexion con=new Connexion();
	private JPanel tableau;
	private JComboBox comboChec;
	private JButton btnPrev;
	private JButton btnFirst;
	private JButton btnLast;
	private JButton btnNext;

	/**
	 * Create the panel.
	 */
	public PanelHistoriques() {
		setBackground(SystemColor.inactiveCaption);
		setSize(538,396);
		setBounds(0, 0, 882, 750);
		setLayout(new BorderLayout(0, 0));
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 50));
		Header.setBackground(SystemColor.inactiveCaption);
		add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel panelService = new JPanel();
		panelService.setPreferredSize(new Dimension(80, 0));
		panelService.setBackground(SystemColor.inactiveCaption);
		Header.add(panelService, BorderLayout.WEST);
		panelService.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_sepBas = new JPanel();
		panel_sepBas.setPreferredSize(new Dimension(10, 3));
		panelService.add(panel_sepBas, BorderLayout.SOUTH);
		
		JPanel panel_Refresh = new JPanel();
		panel_Refresh.setPreferredSize(new Dimension(78, 10));
		panel_Refresh.setBackground(SystemColor.inactiveCaption);
		panelService.add(panel_Refresh, BorderLayout.WEST);
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
				
				refresh();
			}
		});
		lblRefresh.setIcon(new ImageIcon(PanelHistoriques.class.getResource("/Icon/refresh_30px.png")));
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Refresh.add(lblRefresh, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(3, 10));
		panel_Refresh.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_sepDrt_1 = new JPanel();
		panel_Refresh.add(panel_sepDrt_1, BorderLayout.EAST);
		panel_sepDrt_1.setPreferredSize(new Dimension(3, 10));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		JPanel paneLNord = new JPanel();
		paneLNord.setPreferredSize(new Dimension(10, 100));
		paneLNord.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLNord, BorderLayout.NORTH);
		paneLNord.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setPreferredSize(new Dimension(250, 10));
		panelGauche.setBackground(SystemColor.inactiveCaption);
		paneLNord.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_h = new JPanel();
		panel_h.setBackground(SystemColor.inactiveCaption);
		panel_h.setPreferredSize(new Dimension(10, 50));
		panelGauche.add(panel_h, BorderLayout.NORTH);
		panel_h.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTxt1 = new JLabel("selectionner une direction pour savoir");
		lblTxt1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTxt1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_h.add(lblTxt1, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(3, 10));
		panel_h.add(panel_10, BorderLayout.EAST);
		
		JPanel panel_12 = new JPanel();
		panel_12.setPreferredSize(new Dimension(3, 10));
		panel_h.add(panel_12, BorderLayout.WEST);
		
		JPanel panel_b = new JPanel();
		panel_b.setBackground(SystemColor.inactiveCaption);
		panel_b.setPreferredSize(new Dimension(10, 50));
		panelGauche.add(panel_b, BorderLayout.SOUTH);
		panel_b.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTxt2 = new JLabel("le nombre total de consultation");
		lblTxt2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTxt2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_b.add(lblTxt2, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(3, 10));
		panel_b.add(panel_9, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		panel_13.setPreferredSize(new Dimension(3, 10));
		panel_b.add(panel_13, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 3));
		paneLNord.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panelButton = new JPanel();
		panelButton.setPreferredSize(new Dimension(190, 10));
		panelButton.setBackground(SystemColor.inactiveCaption);
		paneLNord.add(panelButton, BorderLayout.EAST);
		panelButton.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSystem = new JPanel();
		panelSystem.setBackground(SystemColor.inactiveCaption);
		paneLNord.add(panelSystem, BorderLayout.CENTER);
		panelSystem.setLayout(new BorderLayout(0, 0));
		
		JPanel panelC1 = new JPanel();
		panelC1.setPreferredSize(new Dimension(250, 10));
		panelC1.setBackground(SystemColor.inactiveCaption);
		panelSystem.add(panelC1, BorderLayout.WEST);
		panelC1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(SystemColor.inactiveCaption);
		panelTitle.setPreferredSize(new Dimension(10, 30));
		panelC1.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lbltitle = new JLabel("SELECTIONNER");
		lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbltitle.setIcon(new ImageIcon(PanelHistoriques.class.getResource("/Icon/checklist_16px.png")));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lbltitle, BorderLayout.CENTER);
		
		JPanel panel_combo = new JPanel();
		panel_combo.setBackground(SystemColor.inactiveCaption);
		panelC1.add(panel_combo, BorderLayout.CENTER);
		panel_combo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setPreferredSize(new Dimension(10, 17));
		panel_combo.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setPreferredSize(new Dimension(10, 17));
		panel_combo.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setPreferredSize(new Dimension(20, 10));
		panel_combo.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setPreferredSize(new Dimension(20, 10));
		panel_combo.add(panel_3, BorderLayout.WEST);
		
		combo_direction = new JComboBox();
		combo_direction.addItem("");
		dir.affiche_all_direction(combo_direction);
		action(combo_direction);
		panel_combo.add(combo_direction, BorderLayout.CENTER);
		
		JPanel panelC2 = new JPanel();
		panelC2.setPreferredSize(new Dimension(193, 10));
		panelC2.setBackground(SystemColor.inactiveCaption);
		panelSystem.add(panelC2, BorderLayout.EAST);
		panelC2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_title = new JPanel();
		panel_title.setBackground(SystemColor.inactiveCaption);
		panel_title.setPreferredSize(new Dimension(10, 30));
		panelC2.add(panel_title, BorderLayout.NORTH);
		panel_title.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("RESULTATS");
		lblTitle.setIcon(new ImageIcon(PanelHistoriques.class.getResource("/Icon/test_passed_16px.png")));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_title.add(lblTitle, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_title.add(panel_8, BorderLayout.WEST);
		panel_8.setPreferredSize(new Dimension(3, 10));
		
		JPanel panel_14 = new JPanel();
		panel_14.setPreferredSize(new Dimension(3, 10));
		panel_title.add(panel_14, BorderLayout.EAST);
		
		JPanel panel_resultat = new JPanel();
		panel_resultat.setBackground(SystemColor.inactiveCaption);
		panelC2.add(panel_resultat, BorderLayout.CENTER);
		panel_resultat.setLayout(new BorderLayout(0, 0));
		
		lblNombre = new JLabel("               0");
		lblNombre.setForeground(Color.RED);
		lblNombre.setIcon(new ImageIcon(PanelHistoriques.class.getResource("/Icon/sigma_30px.png")));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_resultat.add(lblNombre, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_resultat.add(panel_7, BorderLayout.WEST);
		panel_7.setPreferredSize(new Dimension(3, 10));
		
		JPanel panel_15 = new JPanel();
		panel_15.setPreferredSize(new Dimension(3, 10));
		panel_resultat.add(panel_15, BorderLayout.EAST);
		
		JPanel paneLSud = new JPanel();
		paneLSud.setPreferredSize(new Dimension(10, 70));
		paneLSud.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLSud, BorderLayout.SOUTH);
		paneLSud.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Pagination = new JPanel();
		panel_Pagination.setLayout(null);
		panel_Pagination.setPreferredSize(new Dimension(420, 10));
		panel_Pagination.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_Pagination, BorderLayout.EAST);
		
		btnFirst = new JButton("First");
		btnFirst.setBounds(0, 11, 80, 29);
		panel_Pagination.add(btnFirst);
		
		btnPrev = new JButton("Previous");
		btnPrev.setBounds(101, 11, 73, 29);
		panel_Pagination.add(btnPrev);
		
		comboChec = new JComboBox();
		comboChec.setBounds(184, 12, 43, 26);
		panel_Pagination.add(comboChec);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(237, 11, 60, 29);
		panel_Pagination.add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.setBounds(307, 11, 80, 29);
		panel_Pagination.add(btnLast);
		
		JPanel paneLGauche = new JPanel();
		paneLGauche.setPreferredSize(new Dimension(40, 10));
		paneLGauche.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLGauche, BorderLayout.WEST);
		
		JPanel paneLDoite = new JPanel();
		paneLDoite.setPreferredSize(new Dimension(40, 10));
		paneLDoite.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLDoite, BorderLayout.EAST);
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		panelContent.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		tableau = new JPanel();
		tableau.setPreferredSize(new Dimension(200, 10));
		tableau.setBackground(SystemColor.inactiveCaption);
		panelCentre.add(tableau, BorderLayout.CENTER);
		tableau.setLayout(new BorderLayout(0, 0));
		
		list = new Liste_Historique(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		tableau.add(list, BorderLayout.CENTER);
		
		JPanel panel_N = new JPanel();
		panel_N.setBackground(SystemColor.inactiveCaption);
		panelCentre.add(panel_N, BorderLayout.NORTH);
	}

	protected void refresh() {
		tableau.removeAll();
		tableau.repaint();
		tableau.revalidate();
		
		list = new Liste_Historique(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		tableau.add(list, BorderLayout.CENTER);
		tableau.repaint();
		tableau.revalidate();
		JOptionPane.showMessageDialog(null,"actulisé!",null,JOptionPane.INFORMATION_MESSAGE);
		
	}

	private void action(JComboBox jcb) {
		combo_direction.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 String selectedBureauName = (String) jcb.getSelectedItem();
				 String query = "SELECT id FROM direction WHERE acronyme = ?";
				 
			        try (PreparedStatement statement = con.getConn().prepareStatement(query)) {
			            statement.setString(1, selectedBureauName);
			            ResultSet resultSet = statement.executeQuery();
			            if(resultSet.next()) {
			                int idD = resultSet.getInt("id");
			                System.out.println("ID: "+idD);
							 Consultation cons = new Consultation();
							 cons.total(lblNombre, idD);
			            }
			        }catch (SQLException ex) {
			        	JOptionPane.showMessageDialog(null,"Erreur dans direction!",null,JOptionPane.ERROR_MESSAGE);
			        }
//				 Consultation cons = new Consultation();
//				 cons.total(lblNombre, dir.getID(selectedBureauName));
			}
		});
		
	}

}
