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
import modele.Direction;
import modele.Model_table;

public class Liste_Directions extends JPanel {

	JTable tb;
	JScrollPane scrl;
	
	Direction dir = new Direction();
	private JPanel panelCentre;
	
	private String iconEdit = "src\\Icon\\edit_32px.png";
	private String iconVoir = "src\\Icon\\eye_26px.png";
	
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	
	/**
	 * Create the panel.
	 */
	
	public Liste_Directions(JButton btnLast, JButton btnNext, JButton btnPrev, JButton btnFirst,JComboBox comboBox,String action) {
		setPreferredSize(new Dimension(705, 523));
		setBackground(SystemColor.inactiveCaption);
		setLayout(new BorderLayout(0, 0));
		
		btnFirst.setEnabled(true);
		btnPrev.setEnabled(true);
		comboBox.setEnabled(true);
		
		btnLast.setEnabled(true);
		btnNext.setEnabled(true);
		
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("Identifiant");
		df.addColumn("Acronyme");
		df.addColumn("Nomination");
		df.addColumn("Detail");
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		dir.compteComboBox(comboBox, totalData);
		
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = totalPage;
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else if(action.equals("filtrage")) {
					liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page<totalPage) {
					page++;
					if (action.equals("normal")) {
						liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
					}else if(action.equals("filtrage")) {
						liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
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
					}else if(action.equals("filtrage")) {
						liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
					}
				}
			}
		});
	
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = 1;
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else if(action.equals("filtrage")) {
					liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (action.equals("normal")) {
					liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}else if(action.equals("filtrage")) {
					liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
				}
			}
			
		});
		
		tb = new JTable();
		scrl = new JScrollPane();
		scrl.setViewportView(tb);
		
		panelCentre.add(scrl, BorderLayout.CENTER);
		
		if (action.equals("normal")) {
			liste_normal(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
		}else if(action.equals("filtrage")) {
			liste_desc(df, comboBox, btnFirst, btnPrev, btnLast, btnNext);
		}
	}
	
	public Liste_Directions() {
		setPreferredSize(new Dimension(705, 523));
		setBackground(SystemColor.inactiveCaption);
		setLayout(new BorderLayout(0, 0));
		
		panelCentre = new JPanel();
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelCentre.setBackground(SystemColor.inactiveCaption);
		add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
	}
	
	public void liste_normal(DefaultTableModel df, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, JButton btnNext) {
		int j = df.getColumnCount();
		rowCountPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
		totalData = dir.getLengthTable();
		
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
		
		dir.affichage(data, page, rowCountPerPage);
		
		String title[] = {"ID", "Acronyme", "Nomination", "Detail"};
		Model_table m = new Model_table(data, title);
		
		this.tb.setModel(m);
		
		this.tb.setRowHeight(30);
		this.tb.getColumn("Detail").setCellRenderer(new ButtonRenderer(iconVoir));
		this.tb.getColumn("Detail").setCellEditor(new ButtonEditor(new JCheckBox(), iconVoir,"detail_direction"));
		panelCentre.add(scrl, BorderLayout.CENTER);
	}
	
	public void liste_desc(DefaultTableModel df, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, JButton btnNext) {
		int j = df.getColumnCount();
		rowCountPerPage = Integer.valueOf(comboBox.getSelectedItem().toString());
		totalData = dir.getLengthTable();
		
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
		
		dir.Liste_direction_desc(data, page, rowCountPerPage);
		String title[] = {"ID", "Acronyme", "Nomination", "Detail"};
		Model_table m = new Model_table(data, title);
		
		this.tb.setModel(m);
		
		this.tb.setRowHeight(30);
		this.tb.getColumn("Detail").setCellRenderer(new ButtonRenderer(iconVoir));
		this.tb.getColumn("Detail").setCellEditor(new ButtonEditor(new JCheckBox(), iconVoir,"detail_direction"));
		panelCentre.add(scrl, BorderLayout.CENTER);
	}
	
}
