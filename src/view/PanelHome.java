package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import modele.Attente;
import modele.Connexion;
import modele.Consultation;
import modele.Sortie;

@SuppressWarnings("serial")
public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	private Consultation code;
	private Attente att;
	private Sortie s;

	
	Statement st, st1;
	Connexion con=new Connexion();
	ResultSet rst, rst1;
	JScrollPane scrl1;
	private JPanel panelBarChart;
	private JButton btnNotification;
	private JLabel lblCons;
	private JLabel lblAtt;
	private JLabel lblSortie;
	
	public PanelHome() throws SQLException {
		setBackground(SystemColor.inactiveCaption);
		setSize(897,752);
		setBounds(0, 0, 964, 690);
		setLayout(new BorderLayout(0, 0));
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 50));
		Header.setBackground(SystemColor.inactiveCaption);
		add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNotification = new JPanel();
		panelNotification.setBackground(SystemColor.inactiveCaption);
		panelNotification.setPreferredSize(new Dimension(100, 10));
		Header.add(panelNotification, BorderLayout.EAST);
		panelNotification.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panelNotification.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panelNotification.add(panel_1, BorderLayout.SOUTH);
		
		btnNotification = new JButton("");
		btnNotification.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/refresh_30px.png")));
		panelNotification.add(btnNotification, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setPreferredSize(new Dimension(25, 10));
		panelNotification.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setPreferredSize(new Dimension(25, 10));
		panelNotification.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		JPanel paneLNord = new JPanel();
		paneLNord.setPreferredSize(new Dimension(10, 50));
		paneLNord.setBackground(SystemColor.inactiveCaption);
		panelContent.add(paneLNord, BorderLayout.NORTH);
		paneLNord.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("RAPPORTS DES ACTIVITES");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paneLNord.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		panelContent.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGraphe1 = new JPanel();
		panelGraphe1.setBackground(SystemColor.inactiveCaption);
		panelGraphe1.setPreferredSize(new Dimension(10, 200));
		panelCentre.add(panelGraphe1, BorderLayout.NORTH);
		panelGraphe1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_G = new JPanel();
		panel_G.setBackground(SystemColor.inactiveCaption);
		panel_G.setPreferredSize(new Dimension(300, 10));
		panelGraphe1.add(panel_G, BorderLayout.WEST);
		panel_G.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_GH = new JPanel();
		panel_GH.setBackground(SystemColor.inactiveCaption);
		panel_G.add(panel_GH, BorderLayout.NORTH);
		
		JPanel panel_GG = new JPanel();
		panel_GG.setBackground(SystemColor.inactiveCaption);
		panel_G.add(panel_GG, BorderLayout.WEST);
		
		JPanel panel_GB = new JPanel();
		panel_GB.setBackground(SystemColor.inactiveCaption);
		panel_G.add(panel_GB, BorderLayout.SOUTH);
		
		JPanel panel_GD = new JPanel();
		panel_GD.setBackground(SystemColor.inactiveCaption);
		panel_G.add(panel_GD, BorderLayout.EAST);
		
		JPanel panel_GC = new JPanel();
		panel_G.add(panel_GC, BorderLayout.CENTER);
		panel_GC.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 204, 204));
		panel_4.setPreferredSize(new Dimension(10, 25));
		panel_GC.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("consultation");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setPreferredSize(new Dimension(180, 14));
		panel_4.add(lblTitle, BorderLayout.WEST);
		
		JLabel lblIconCons = new JLabel("");
		lblIconCons.setPreferredSize(new Dimension(90, 0));
		lblIconCons.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/login_16px.png")));
		panel_4.add(lblIconCons, BorderLayout.EAST);
		
		JPanel panel_cons = new JPanel();
		panel_cons.setBackground(new Color(0, 204, 255));
		panel_GC.add(panel_cons, BorderLayout.CENTER);
		panel_cons.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcCons = new JLabel("");
		lblIcCons.setPreferredSize(new Dimension(100, 0));
		lblIcCons.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/users_60px.png")));
		lblIcCons.setHorizontalAlignment(SwingConstants.CENTER);
		panel_cons.add(lblIcCons, BorderLayout.WEST);
		
		lblCons = new JLabel("Test");
		lblCons.setFont(new Font("Tahoma", Font.BOLD, 40));
		code = new Consultation();
		code.total(lblCons);
		lblCons.setHorizontalAlignment(SwingConstants.CENTER);
		panel_cons.add(lblCons, BorderLayout.CENTER);
		
		JPanel panel_D = new JPanel();
		panel_D.setBackground(SystemColor.inactiveCaption);
		panel_D.setPreferredSize(new Dimension(300, 10));
		panelGraphe1.add(panel_D, BorderLayout.EAST);
		panel_D.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DH = new JPanel();
		panel_DH.setBackground(SystemColor.inactiveCaption);
		panel_D.add(panel_DH, BorderLayout.NORTH);
		
		JPanel panel_DB = new JPanel();
		panel_DB.setBackground(SystemColor.inactiveCaption);
		panel_D.add(panel_DB, BorderLayout.SOUTH);
		
		JPanel panel_DG = new JPanel();
		panel_DG.setBackground(SystemColor.inactiveCaption);
		panel_D.add(panel_DG, BorderLayout.WEST);
		
		JPanel panel_DD = new JPanel();
		panel_DD.setBackground(SystemColor.inactiveCaption);
		panel_D.add(panel_DD, BorderLayout.EAST);
		
		JPanel panel_DC = new JPanel();
		panel_D.add(panel_DC, BorderLayout.CENTER);
		panel_DC.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(new Color(0, 102, 51));
		panel_4_2.setPreferredSize(new Dimension(10, 25));
		panel_DC.add(panel_4_2, BorderLayout.SOUTH);
		panel_4_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIconAtt = new JLabel("");
		lblIconAtt.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/login2_16px.png")));
		lblIconAtt.setPreferredSize(new Dimension(90, 0));
		panel_4_2.add(lblIconAtt, BorderLayout.EAST);
		
		JLabel lblTitle_1 = new JLabel("attente");
		lblTitle_1.setPreferredSize(new Dimension(180, 14));
		lblTitle_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4_2.add(lblTitle_1, BorderLayout.WEST);
		
		JPanel panel_vis = new JPanel();
		panel_vis.setBackground(new Color(0, 153, 102));
		panel_DC.add(panel_vis, BorderLayout.CENTER);
		panel_vis.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcAtt = new JLabel("");
		lblIcAtt.setPreferredSize(new Dimension(100, 0));
		lblIcAtt.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/cloud_waiting_48px.png")));
		lblIcAtt.setHorizontalAlignment(SwingConstants.CENTER);
		panel_vis.add(lblIcAtt, BorderLayout.WEST);
		
		lblAtt = new JLabel("Test");
		att = new Attente();
		att.total(lblAtt);
		lblAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtt.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_vis.add(lblAtt, BorderLayout.CENTER);
		
		JPanel panel_C = new JPanel();
		panel_C.setBackground(SystemColor.inactiveCaption);
		panelGraphe1.add(panel_C, BorderLayout.CENTER);
		panel_C.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CG = new JPanel();
		panel_CG.setBackground(SystemColor.inactiveCaption);
		panel_C.add(panel_CG, BorderLayout.WEST);
		
		JPanel panel_CD = new JPanel();
		panel_CD.setBackground(SystemColor.inactiveCaption);
		panel_C.add(panel_CD, BorderLayout.EAST);
		
		JPanel panel_CH = new JPanel();
		panel_CH.setBackground(SystemColor.inactiveCaption);
		panel_C.add(panel_CH, BorderLayout.NORTH);
		
		JPanel panel_CB = new JPanel();
		panel_CB.setBackground(SystemColor.inactiveCaption);
		panel_C.add(panel_CB, BorderLayout.SOUTH);
		
		JPanel panel_CC = new JPanel();
		panel_CC.setBackground(SystemColor.inactiveCaption);
		panel_C.add(panel_CC, BorderLayout.CENTER);
		panel_CC.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(255, 140, 0));
		panel_4_1.setPreferredSize(new Dimension(10, 25));
		panel_CC.add(panel_4_1, BorderLayout.SOUTH);
		panel_4_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle_1_1 = new JLabel("sortie     ");
		lblTitle_1_1.setPreferredSize(new Dimension(180, 14));
		lblTitle_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4_1.add(lblTitle_1_1, BorderLayout.WEST);
		
		JLabel lblIconSortie = new JLabel("");
		lblIconSortie.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconSortie.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/login2_16px.png")));
		lblIconSortie.setPreferredSize(new Dimension(100, 0));
		panel_4_1.add(lblIconSortie, BorderLayout.CENTER);
		
		JPanel panel_list = new JPanel();
		panel_list.setBackground(new Color(255, 165, 0));
		panel_CC.add(panel_list, BorderLayout.CENTER);
		panel_list.setLayout(new BorderLayout(0, 0));
		
		JLabel lblIcSortie = new JLabel("");
		lblIcSortie.setIcon(new ImageIcon(PanelHome.class.getResource("/Icon/exit_sign_48px.png")));
		lblIcSortie.setPreferredSize(new Dimension(100, 0));
		lblIcSortie.setHorizontalAlignment(SwingConstants.CENTER);
		panel_list.add(lblIcSortie, BorderLayout.WEST);
		
		lblSortie = new JLabel("");
		s = new Sortie();
		s.total(lblSortie);
		lblSortie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortie.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_list.add(lblSortie, BorderLayout.CENTER);
		
		JPanel panelGraphe2 = new JPanel();
		panelGraphe2.setPreferredSize(new Dimension(10, 390));
		panelGraphe2.setBackground(SystemColor.inactiveCaption);
		panelCentre.add(panelGraphe2, BorderLayout.SOUTH);
		panelGraphe2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_hg = new JPanel();
		panel_hg.setBackground(SystemColor.inactiveCaption);
		panelGraphe2.add(panel_hg, BorderLayout.WEST);
		
		JPanel panel_hd = new JPanel();
		panel_hd.setBackground(SystemColor.inactiveCaption);
		panelGraphe2.add(panel_hd, BorderLayout.EAST);
		
		JPanel panel_hb = new JPanel();
		panel_hb.setBackground(SystemColor.inactiveCaption);
		panelGraphe2.add(panel_hb, BorderLayout.SOUTH);
		
		JPanel panel_hc = new JPanel();
		panel_hc.setBackground(SystemColor.inactiveCaption);
		panelGraphe2.add(panel_hc, BorderLayout.CENTER);
		panel_hc.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Filter = new JPanel();
		panel_Filter.setPreferredSize(new Dimension(10, 55));
		panel_hc.add(panel_Filter, BorderLayout.NORTH);
		panel_Filter.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(280, 10));
		panel_Filter.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panelBarChart = new JPanel();
		panel_hc.add(panelBarChart, BorderLayout.CENTER);
		panelBarChart.setLayout(new BorderLayout(0, 0));
		
		showBar();
		actualiser();
	}
	
	private void actualiser() {
		btnNotification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBarChart.removeAll();
				panelBarChart.repaint();
				panelBarChart.revalidate();
				
				showBar();
				
				code = new Consultation();
				code.total(lblCons);
				
				att = new Attente();
				att.total(lblAtt);
				
				s = new Sortie();
				s.total(lblSortie);
				
				panelBarChart.repaint();
				panelBarChart.revalidate();
				JOptionPane.showMessageDialog(null,"Actualisé!",null,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}

	public void showBar() {
		// Create dataset for the graph
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	    // Fetch data from the "consultation" table and calculate the total number of consultations per day
	    try {
	        Statement statement = con.getConn().createStatement();
	        ResultSet resultSet = statement.executeQuery("SELECT DATE(date_heure) AS datet, COUNT(*) AS total FROM consultation GROUP BY datet");

	        while (resultSet.next()) {
	            String date = resultSet.getString("datet");
	            int total = resultSet.getInt("total");
	            dataset.setValue(total, "nombre", date);
	        }
	     // Create chart
		    JFreeChart chart = ChartFactory.createBarChart("Rapports du consultation", "Jours", "nombre",
		            dataset, PlotOrientation.VERTICAL, false, true, false);

		    // Customize chart appearance
		    CategoryPlot categoryPlot = chart.getCategoryPlot();
		    categoryPlot.setBackgroundPaint(Color.white);
		    BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
		    Color clr3 = new Color(204, 0, 51);
		    renderer.setSeriesPaint(0, clr3);

		    // Create chartPanel to display the chart (graph)
		    ChartPanel barChartPanel = new ChartPanel(chart);
		    panelBarChart.removeAll();
		    panelBarChart.add(barChartPanel, BorderLayout.CENTER);
		    panelBarChart.validate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	
}