package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.ButtonEditor;
import modele.ButtonRenderer;
import modele.Consultation;
import modele.Model_table;
import modele.Visiteur;

@SuppressWarnings("serial")
public class Liste_consultation extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JTable tb;
	JScrollPane scrl;
	
	Visiteur vis = new Visiteur();
	Consultation con = new Consultation();
	private JPanel panelCentre;
	
	private String iconSortie = "src\\Icon\\exit_sign_24px.png";
	@SuppressWarnings("unused")
	private String iconSupprimer = "src\\Icon\\delete_24px.png";
	private String iconVoir = "src\\Icon\\eye_26px.png";
	
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	
	@SuppressWarnings("rawtypes")
	public Liste_consultation(JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,JComboBox comboBox,String action) {
		setPreferredSize(new Dimension(705, 523));
		setBackground(SystemColor.inactiveCaption);
		setLayout(new BorderLayout(0, 0));
		
		btnFirst.setEnabled(true);
		btnPrev.setEnabled(true);
		comboBox.setEnabled(true);
		
		btnLast.setEnabled(true);
		btnNext.setEnabled(true);
		
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("ID");
		df.addColumn("Date et Heure");
		df.addColumn("Nom");
		df.addColumn("Motif");
		df.addColumn("Bureau");
		df.addColumn("sortie");
		df.addColumn("Detail");
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		con.compteComboBox(comboBox, totalData);
		
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = totalPage;
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page<totalPage) {
					page++;
					if (action.equals("normal")) {
						liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
					}else {
						
					}
				}
			}
		});
		
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page>1) {
					page --;
					if (action.equals("normal")) {
						liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
					}else {
						
					}
				}
			}
		});
	
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = 1;
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else {
					
				}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else {
					
				}
			}
			
		});
		
		
		
		tb = new JTable();
		scrl = new JScrollPane();
		scrl.setViewportView(tb);
		
		panelCentre.add(scrl, BorderLayout.CENTER);
		
		if (action.equals("normal")) {
			liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
		}
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public Liste_consultation(JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,
			JComboBox comboBox,String action, String debut, String fin) {
		setPreferredSize(new Dimension(705, 523));
		setBackground(SystemColor.inactiveCaption);
		setLayout(new BorderLayout(0, 0));
		
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("Identifiant");
		df.addColumn("Date et Heure");
		df.addColumn("Nom");
		df.addColumn("Motif");
		df.addColumn("Bureau");
		df.addColumn("sortie");
		df.addColumn("Detail");
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		tb = new JTable();
		scrl = new JScrollPane();
		scrl.setViewportView(tb);
		
		if (action.equals("filtrage")) {
			list_filtrage_deux(df, comboBox, btnFirst, btnPrev, btnLast, btnNext, debut, fin);
		}
		
		panelCentre.add(scrl, BorderLayout.CENTER);
	}
	
	@SuppressWarnings("rawtypes")
	public void liste_normal(DefaultTableModel df, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, JButton btnNext ) {
		
		int j = df.getColumnCount();
		rowCountPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
		totalData = con.getLengthTable();
		
		System.out.println("totalData : "+totalData);
		Object[][] data = new Object[rowCountPerPage][j];
		Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
		totalPage = totalPageD.intValue();
		
		if(page.equals(1)) {
			btnFirste.setEnabled(false);
			btnPrevious.setEnabled(false);
		}else {
			btnFirste.setEnabled(true);
			btnPrevious.setEnabled(true);
		}
		
		if(page.equals(totalPage)) {
			btnLast.setEnabled(false);
			btnNext.setEnabled(false);
		}else {
			btnLast.setEnabled(true);
			btnNext.setEnabled(true);
		}
		
		if(page> totalPage) {
			page = 1;
		}
		
		con.affichage(data, page, rowCountPerPage);
		
		String title[] = {"Identifiant", "Date et heure", "Nom", "Motif", "Bureau", "sortie", "Detail"};
		Model_table m = new Model_table(data, title);
		
		this.tb.setModel(m);
		
		this.tb.setRowHeight(30);
		
		this.tb.getColumn("sortie").setCellRenderer(new ButtonRenderer(iconSortie));
		this.tb.getColumn("sortie").setCellEditor(new ButtonEditor(new JCheckBox(), iconSortie,"sortie"));
		this.tb.getColumn("Detail").setCellRenderer(new ButtonRenderer(iconVoir));
		this.tb.getColumn("Detail").setCellEditor(new ButtonEditor(new JCheckBox(), iconVoir,"detail_consultation"));
		
		panelCentre.add(scrl, BorderLayout.CENTER);
	}
	
	@SuppressWarnings("rawtypes")
	public void list_filtrage_deux(DefaultTableModel df, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, 
			JButton btnNext, String debut, String fin) {
		
		int i = con.newLength(debut, fin);
		int j = df.getColumnCount();
		Object[][] data = new Object[i][j];
		
		btnFirste.setEnabled(false);
		btnPrevious.setEnabled(false);
		comboBox.setEnabled(false);
		
		btnLast.setEnabled(false);
		btnNext.setEnabled(false);
		
		
		con.Filtrage(data, debut, fin);
		String title[] = {"Identifiant", "Date et heure", "Nom", "Motif", "Bureau", "sortie", "Detail"};
		
		Model_table m = new Model_table(data, title);
		this.tb.setModel(m);
		
		this.tb.setRowHeight(30);
		
		this.tb.getColumn("sortie").setCellRenderer(new ButtonRenderer(iconSortie));
		this.tb.getColumn("sortie").setCellEditor(new ButtonEditor(new JCheckBox(), iconSortie,"sortie"));
		this.tb.getColumn("Detail").setCellRenderer(new ButtonRenderer(iconVoir));
		this.tb.getColumn("Detail").setCellEditor(new ButtonEditor(new JCheckBox(), iconVoir,"detail_consultation"));
		panelCentre.add(scrl, BorderLayout.CENTER);
	}
	

}
