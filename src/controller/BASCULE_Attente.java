package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modele.ButtonEditor;
import modele.ButtonRenderer;
import modele.Model_table;
import modele.Sortie;

public class BASCULE_Attente extends JFrame {

	private JPanel contentPane;
	private JPanel center;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPrev;
	private JButton btnFirst;
	private JComboBox comboBox;
	private String action;
	JTable tb,tb1;
	JScrollPane scrl,scrl1;
	Sortie so = new Sortie();
	int xx,xy;
	private JButton btnStop;
	private JPanel panel_Refresh;
	private JLabel lblRefresh;
	private JPanel panelCentre;
	private DefaultTableModel df;

	/**
	 * Create the frame.
	 */
	public BASCULE_Attente(JPanel center, JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,JComboBox comboBox,String action) {
		this.center = center;
		this.btnLast = btnLast;
		this.btnNext = btnNext;
		this.btnPrev = btnPrev;
		this.btnFirst = btnFirst;
		this.comboBox = comboBox;
		this.action = action;
		setTitle("Basculation");
		setResizable(false);
		setBounds(100, 100, 674, 524);
		setUndecorated(true);
		
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
				BASCULE_Attente.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel panelTitre = new JPanel();
		panelTitre.setPreferredSize(new Dimension(10, 50));
		panelTitre.setBackground(new Color(0, 51, 51));
		contentPane.add(panelTitre, BorderLayout.NORTH);
		panelTitre.setLayout(new BorderLayout(0, 0));
		
		JPanel ButtonClose = new JPanel();
		ButtonClose.setPreferredSize(new Dimension(50, 10));
		ButtonClose.setBackground(new Color(0, 51, 51));
		panelTitre.add(ButtonClose, BorderLayout.EAST);
		ButtonClose.setLayout(new BorderLayout(0, 0));

		JLabel close = new JLabel("");
		close.setPreferredSize(new Dimension(50, 0));
		ButtonClose.add(close, BorderLayout.CENTER);
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BASCULE_Attente.this.dispose();
				center.removeAll();
				center.repaint();
				center.revalidate();
				
				Liste_Attente list = new Liste_Attente(btnLast, btnNext, btnPrev, btnFirst, comboBox, action);
				list.setVisible(true);
				center.add(list, BorderLayout.CENTER);
				center.repaint();
				center.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonClose.setBackground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonClose.setBackground(new Color(0, 51, 51));
			}
		});
		close.setIcon(new ImageIcon(BASCULE_Attente.class.getResource("/Icon/cancel_24px.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBasculationEnAttente = new JLabel("BASCULATION EN ATTENTE");
		lblBasculationEnAttente.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasculationEnAttente.setForeground(Color.CYAN);
		lblBasculationEnAttente.setFont(new Font("Arial", Font.BOLD, 18));
		panelTitre.add(lblBasculationEnAttente, BorderLayout.CENTER);
		
		panel_Refresh = new JPanel();
		panel_Refresh.setBackground(new Color(0, 51, 51));
		panel_Refresh.setPreferredSize(new Dimension(50, 10));
		panelTitre.add(panel_Refresh, BorderLayout.WEST);
		panel_Refresh.setLayout(new BorderLayout(0, 0));
		
		lblRefresh = new JLabel("");
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Refresh.setBackground(new Color(1,153,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_Refresh.setBackground(new Color(0, 51, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblRefresh.setIcon(new ImageIcon(BASCULE_Attente.class.getResource("/Icon/refresh_30px.png")));
		lblRefresh.setPreferredSize(new Dimension(50, 0));
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Refresh.add(lblRefresh, BorderLayout.CENTER);
		
		JPanel panelgauche = new JPanel();
		panelgauche.setBackground(new Color(0, 51, 51));
		contentPane.add(panelgauche, BorderLayout.WEST);
		
		JPanel paneldroite = new JPanel();
		paneldroite.setBackground(new Color(0, 51, 51));
		contentPane.add(paneldroite, BorderLayout.EAST);
		
		panelCentre = new JPanel();
		panelCentre.setBackground(new Color(102, 255, 204));
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		JPanel Bas = new JPanel();
		Bas.setPreferredSize(new Dimension(10, 50));
		Bas.setBackground(new Color(0, 51, 51));
		contentPane.add(Bas, BorderLayout.SOUTH);
		Bas.setLayout(null);
		
		btnStop = new JButton("Terminer");
		btnStop.setIcon(new ImageIcon(BASCULE_Attente.class.getResource("/Icon/save_close_24px.png")));
		stop();
		btnStop.setForeground(new Color(0, 0, 0));
		btnStop.setFont(new Font("Arial", Font.BOLD, 15));
		btnStop.setBounds(488, 11, 130, 28);
		Bas.add(btnStop);
		
		df=new DefaultTableModel();
		
		df.addColumn("ID");
		df.addColumn("Date et Heure");
		df.addColumn("Identifiant consultation");
		df.addColumn("Action");
		init(df);
		String icon = "C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\attente_24px.png";
		this.tb.setRowHeight(30);
		this.tb.getColumn("Action").setCellRenderer(new ButtonRenderer(icon));
		this.tb.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), icon,"attente"));
		panelCentre.add(scrl, BorderLayout.CENTER);
		reaffiche();
	}
	protected void reaffiche() {
		lblRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCentre.removeAll();
				panelCentre.repaint();
				panelCentre.revalidate();
				
				df=new DefaultTableModel();
				
				df.addColumn("ID");
				df.addColumn("Date et Heure");
				df.addColumn("Identifiant consultation");
				df.addColumn("Action");
				init(df);
				String icon = "C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\attente_24px.png";
				tb.setRowHeight(30);
				tb.getColumn("Action").setCellRenderer(new ButtonRenderer(icon));
				tb.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), icon,"attente"));
				panelCentre.add(scrl, BorderLayout.CENTER);
				
				panelCentre.repaint();
				panelCentre.revalidate();
			}
		});
		
	}
	private void stop() {
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				center.removeAll();
				center.repaint();
				center.revalidate();
				
				Liste_Attente list = new Liste_Attente(btnLast, btnNext, btnPrev, btnFirst, comboBox, action);
				list.setVisible(true);
				center.add(list, BorderLayout.CENTER);
				center.repaint();
				center.revalidate();
			}
		});
		
	}

	private void init(DefaultTableModel df) {
		int i = so.getLengthTable();
		int j = df.getColumnCount();
		Object[][] data = new Object[i][j];
		so.Liste_sortie(data);
		String title[] = {"ID", "Date et heure", "Identifiant consultation", "Action"};
		Model_table m = new Model_table(data, title);
		tb = new JTable(m);
		scrl = new JScrollPane();
		scrl.setViewportView(tb);
	}

}
