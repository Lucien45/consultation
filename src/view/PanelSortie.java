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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import controller.List_sortie;
import controller.Liste_Attente;
import controller.Liste_consultation;
import modele.Sortie;

public class PanelSortie extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable tb;
	private JScrollPane scrl;
	Sortie s = new Sortie();
	
	private JPanel panelTableau;
	private JPanel panelContent;
	private List_sortie list;
	private JButton btnAdd;
	private JPanel tableau;
	private JButton btnFiltrer;
	private JDateChooser dateChooser_Deux_1;
	private JDateChooser dateChooser_Deux_2;
	private JButton btnLast;
	private JButton btnNext;
	private JComboBox comboChec;
	private JButton btnPrev;
	private JButton btnFirst;
	public PanelSortie() {
		setBackground(SystemColor.inactiveCaption);
		setSize(538,396);
		setBounds(0, 0, 964, 690);
		setLayout(new BorderLayout(0, 0));
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 110));
		Header.setBackground(SystemColor.inactiveCaption);
		add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel Filtrage = new JPanel();
		Filtrage.setPreferredSize(new Dimension(10, 40));
		Filtrage.setBackground(SystemColor.inactiveCaption);
		Header.add(Filtrage, BorderLayout.CENTER);
		Filtrage.setLayout(new BorderLayout(0, 0));
		
		JPanel panelbutton = new JPanel();
		Filtrage.add(panelbutton, BorderLayout.EAST);
		panelbutton.setPreferredSize(new Dimension(240, 10));
		panelbutton.setBackground(SystemColor.inactiveCaption);
		panelbutton.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaption);
		panelbutton.add(panel_7, BorderLayout.NORTH);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.inactiveCaption);
		panelbutton.add(panel_8, BorderLayout.SOUTH);
		
		JPanel panelFilter = new JPanel();
		panelFilter.setPreferredSize(new Dimension(110, 10));
		panelFilter.setBackground(SystemColor.inactiveCaption);
		panelbutton.add(panelFilter, BorderLayout.WEST);
		panelFilter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelF1 = new JPanel();
		panelF1.setBackground(SystemColor.inactiveCaption);
		panelFilter.add(panelF1, BorderLayout.WEST);
		
		btnFiltrer = new JButton("Filtrer");
		
		btnFiltrer.setIcon(new ImageIcon(PanelSortie.class.getResource("/Icon/filter_24px.png")));
		filtrageDeux();
		panelFilter.add(btnFiltrer, BorderLayout.CENTER);
		btnFiltrer.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		JPanel panelCalendar = new JPanel();
		Filtrage.add(panelCalendar, BorderLayout.CENTER);
		panelCalendar.setBackground(SystemColor.inactiveCaption);
		panelCalendar.setLayout(new BorderLayout(0, 0));
		
		JPanel panelVide = new JPanel();
		panelVide.setPreferredSize(new Dimension(130, 10));
		panelVide.setBackground(SystemColor.inactiveCaption);
		panelCalendar.add(panelVide, BorderLayout.WEST);
		panelVide.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Filtrer la date");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelVide.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelCalendar2 = new JPanel();
		panelCalendar2.setPreferredSize(new Dimension(300, 10));
		panelCalendar2.setBackground(SystemColor.inactiveCaption);
		panelCalendar.add(panelCalendar2, BorderLayout.EAST);
		panelCalendar2.setLayout(new BorderLayout(0, 0));
		
		JPanel panellabel = new JPanel();
		panellabel.setPreferredSize(new Dimension(70, 10));
		panellabel.setBackground(SystemColor.inactiveCaption);
		panelCalendar2.add(panellabel, BorderLayout.WEST);
		panellabel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 11));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panelCalendar2.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setPreferredSize(new Dimension(10, 11));
		panel_1_1.setBackground(SystemColor.inactiveCaption);
		panelCalendar2.add(panel_1_1, BorderLayout.SOUTH);
		panel_1_1.setLayout(new BorderLayout(0, 0));
		
		dateChooser_Deux_2 = new JDateChooser();
		dateChooser_Deux_2.setDateFormatString("yyy-MM-dd");
		panelCalendar2.add(dateChooser_Deux_2, BorderLayout.CENTER);
		
		JPanel panelCalendar1 = new JPanel();
		panelCalendar1.setBackground(SystemColor.inactiveCaption);
		panelCalendar.add(panelCalendar1, BorderLayout.CENTER);
		panelCalendar1.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDate = new JPanel();
		panelDate.setBackground(SystemColor.inactiveCaption);
		panelCalendar1.add(panelDate, BorderLayout.CENTER);
		panelDate.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 15));
		panel.setBackground(SystemColor.inactiveCaption);
		panelDate.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Debut");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 15));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panelDate.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panellabel_1 = new JPanel();
		panellabel_1.setPreferredSize(new Dimension(70, 10));
		panellabel_1.setBackground(SystemColor.inactiveCaption);
		panelDate.add(panellabel_1, BorderLayout.WEST);
		panellabel_1.setLayout(new BorderLayout(0, 0));
		
		dateChooser_Deux_1 = new JDateChooser();
		dateChooser_Deux_1.setDateFormatString("yyy-MM-dd");
		panelDate.add(dateChooser_Deux_1, BorderLayout.CENTER);
		
		JPanel Bascule = new JPanel();
		Bascule.setPreferredSize(new Dimension(800, 50));
		Bascule.setBackground(SystemColor.inactiveCaption);
		Header.add(Bascule, BorderLayout.NORTH);
		Bascule.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAdd = new JPanel();
		panelAdd.setPreferredSize(new Dimension(130, 10));
		Bascule.add(panelAdd, BorderLayout.EAST);
		panelAdd.setBackground(SystemColor.inactiveCaption);
		panelAdd.setLayout(new BorderLayout(0, 0));
		
		JPanel panelService = new JPanel();
		panelService.setPreferredSize(new Dimension(80, 0));
		panelService.setBackground(SystemColor.inactiveCaption);
		Bascule.add(panelService, BorderLayout.WEST);
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
		lblRefresh.setIcon(new ImageIcon(PanelSortie.class.getResource("/Icon/refresh_30px.png")));
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Refresh.add(lblRefresh, BorderLayout.CENTER);
		
		JPanel panel_sepDrt_1 = new JPanel();
		panel_Refresh.add(panel_sepDrt_1, BorderLayout.EAST);
		panel_sepDrt_1.setPreferredSize(new Dimension(3, 10));
		
		
		
		panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		panelTableau = new JPanel();
		panelTableau.setPreferredSize(new Dimension(200, 10));
		panelTableau.setBackground(SystemColor.inactiveCaption);
		panelContent.add(panelTableau, BorderLayout.CENTER);
		panelTableau.setLayout(new BorderLayout(0, 0));
		
		JPanel paneLGauche = new JPanel();
		paneLGauche.setPreferredSize(new Dimension(40, 10));
		paneLGauche.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLGauche, BorderLayout.WEST);
		
		JPanel paneLDoite = new JPanel();
		paneLDoite.setPreferredSize(new Dimension(40, 10));
		paneLDoite.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLDoite, BorderLayout.EAST);
		
		JPanel paneLSud = new JPanel();
		paneLSud.setPreferredSize(new Dimension(10, 80));
		paneLSud.setBackground(SystemColor.inactiveCaption);
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
		panel_Pagination.setLayout(null);
		panel_Pagination.setPreferredSize(new Dimension(420, 10));
		panel_Pagination.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_Pagination, BorderLayout.EAST);
		
		btnFirst = new JButton("First");
		btnFirst.setBounds(0, 11, 80, 29);
		panel_Pagination.add(btnFirst);
		
		btnPrev = new JButton("Previous");
		btnPrev.setBounds(90, 11, 80, 29);
		panel_Pagination.add(btnPrev);
		
		comboChec = new JComboBox();
		comboChec.setBounds(180, 12, 43, 26);
		panel_Pagination.add(comboChec);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(244, 11, 69, 29);
		panel_Pagination.add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.setBounds(323, 11, 80, 29);
		panel_Pagination.add(btnLast);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_4.setPreferredSize(new Dimension(10, 30));
		panelTableau.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setPreferredSize(new Dimension(10, 30));
		panelTableau.add(panel_3, BorderLayout.NORTH);
		
		tableau = new JPanel();
		tableau.setBackground(SystemColor.inactiveCaption);
		panelTableau.add(tableau, BorderLayout.CENTER);
		tableau.setLayout(new BorderLayout(0, 0));
		
		list = new List_sortie(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		tableau.add(list,  BorderLayout.CENTER);
		
	}
	
	protected void refresh() {
		getTableau().removeAll();
		getTableau().repaint();
		getTableau().revalidate();
		
		list = new List_sortie(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		getTableau().add(list, BorderLayout.CENTER);
		getTableau().repaint();
		getTableau().revalidate();
		JOptionPane.showMessageDialog(null,"actulisé!",null,JOptionPane.INFORMATION_MESSAGE);
		
	}

	private void filtrageDeux() {
		btnFiltrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String debut = ((JTextField)dateChooser_Deux_1.getDateEditor().getUiComponent()).getText();
				String fin = ((JTextField)dateChooser_Deux_2.getDateEditor().getUiComponent()).getText();
				
				System.out.println("Debut: "+debut+" | Fin: "+fin);
				getTableau().removeAll();
				getTableau().repaint();
				getTableau().revalidate();
				
				list = new List_sortie(btnLast, btnNext, btnPrev, btnFirst, comboChec, "filtrage", debut, fin);
				list.setVisible(true);
				
				getTableau().add(list, BorderLayout.CENTER);
				getTableau().repaint();
				getTableau().revalidate();
			}
		});
	}

	public JPanel getTableau() {
		return tableau;
	}

	public void setTableau(JPanel tableau) {
		this.tableau = tableau;
	}
	

}
