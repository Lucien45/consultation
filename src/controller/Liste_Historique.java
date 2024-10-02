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

import modele.Attente;
import modele.ButtonEditor;
import modele.ButtonRenderer;
import modele.Consultation;
import modele.Model_table;
import modele.Visiteur;

public class Liste_Historique extends JPanel {

	/**
	 * Create the panel.
	 */
	private JTable tb;
	private JScrollPane scrl;
	private String iconVoir = "src\\Icon\\eye_26px.png";
	private JPanel panelCentre;
	Visiteur vis = new Visiteur();
	Consultation con = new Consultation();
	
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	
	public Liste_Historique(JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,JComboBox comboBox,String action) {
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
		df.addColumn("attente");
		df.addColumn("Detail");
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		con.compteCombo_histo(comboBox, totalData);
		
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = totalPage;
				if (action.equals("normal")) {
					list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page<totalPage) {
					page++;
					if (action.equals("normal")) {
						list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
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
						list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
					}else {
						
					}
				}
			}
		});
	
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = 1;
				if (action.equals("normal")) {
					list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else {
					
				}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (action.equals("normal")) {
					list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else {
					
				}
			}
			
		});
		
		tb = new JTable();
		scrl = new JScrollPane();
		scrl.setViewportView(tb);
		
		panelCentre.add(scrl, BorderLayout.CENTER);
		
		if (action.equals("normal")) {
			list_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
		}
	}
	
	public void list_normal(DefaultTableModel df, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, JButton btnNext ) {
		int j = df.getColumnCount();
		rowCountPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
		totalData = con.getLength_histo();
		
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
		con.Liste_consultation(data, page, rowCountPerPage);
		String title[] = {"ID", "Date et heure", "Nom", "Motif", "Bureau", "sortie","attente","Detail"};
		Model_table m = new Model_table(data, title);
		this.tb.setModel(m);
		this.tb.setRowHeight(30);
		this.tb.getColumn("Detail").setCellRenderer(new ButtonRenderer(iconVoir));
		this.tb.getColumn("Detail").setCellEditor(new ButtonEditor(new JCheckBox(), iconVoir,"detail_historique"));

	}

}
