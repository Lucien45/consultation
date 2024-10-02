package modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Date_de_Retour;
import controller.Detail_Attente;
import controller.Detail_Consultation;
import controller.Detail_Historique;
import controller.Detail_Sortie;


public class ButtonEditor extends DefaultCellEditor {
	protected JButton button;
	private String icon;
	private ButtonSortie sortie = new ButtonSortie();
	private ButtonSupprimer supprimer = new ButtonSupprimer();
	private ButtonAttente attente = new ButtonAttente();
	private ButtonDetail_cons detailConsultation = new ButtonDetail_cons();
	private ButtonDetail_s detailSortie = new ButtonDetail_s();
	private ButtonDetail_a detailAttente = new ButtonDetail_a(); 
	private ButtonDetail_h detailHistorique = new ButtonDetail_h();
	
	public ButtonEditor(JCheckBox checkBox, String icon, String action) {
		super(checkBox);
		
		button = new JButton();
		button.setOpaque(false);
		
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setVerticalAlignment(SwingConstants.CENTER);
		
		this.icon = icon;
		
		if (action.equals("sortie")) {
			button.addActionListener(sortie);
		}else if(action.equals("supprimer")) {
			button.addActionListener(supprimer);
		}else if(action.equals("attente")) {
			button.addActionListener(attente);
		}else if(action.equals("detail_consultation")) {
			button.addActionListener(detailConsultation);
		}else if(action.equals("detail_attente")) {
			button.addActionListener(detailAttente);
		}else if(action.equals("detail_sortie")) {
			button.addActionListener(detailSortie);
		}else if(action.equals("detail_historique")) {
			button.addActionListener(detailHistorique);
		}
	} 
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	
		sortie.setRow(row);
		supprimer.setRow(row);
		detailConsultation.setRow(row);
		detailSortie.setRow(row);
		detailAttente.setRow(row);
		detailHistorique.setRow(row);
		
		sortie.setColumn(column);
		supprimer.setColumn(column);
		detailConsultation.setColumn(column);
		detailSortie.setColumn(column);
		detailAttente.setColumn(column);
		detailHistorique.setColumn(column);
		
		sortie.setTable(table);
		supprimer.setTable(table);
		detailConsultation.setTable(table);
		detailSortie.setTable(table);
		detailAttente.setTable(table);
		detailHistorique.setTable(table);
		
	
		button.setText( (value == null) ? "" : value.toString() );
		button.setIcon(new ImageIcon(this.icon));
		button.setForeground(new Color(240, 240, 240));
		
		return button;
	} 
	class ButtonSortie implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			if (JOptionPane.showConfirmDialog(null, "vous etes sur de faire cette sortie ?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
				String i =  ((JButton)event.getSource()).getText();
				int id = Integer.parseInt(i);
				Sortie s = new Sortie(id);
				s.inserte();
			}
			
		}
	}
	
	class ButtonSupprimer implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			if (JOptionPane.showConfirmDialog(null, "vous etes sur de vouloir effacer ce liste?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
				System.out.println("Suppression");
			}
		}
	}
	
	class ButtonAttente implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
//			if (JOptionPane.showConfirmDialog(null, "vous etes sur de faire cette attente ?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
				System.out.println("atente");
				
				Date_de_Retour dt = new Date_de_Retour();
				dt.setVisible(true);
				dt.getBtnvalider().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String daty = ((JTextField)dt.getDate_iverenany().getDateEditor().getUiComponent()).getText();
						String i =  ((JButton)event.getSource()).getText();
						int id = Integer.parseInt(i);
						Attente a = new Attente(id, daty);
						if (JOptionPane.showConfirmDialog(null, "vous etes sur de faire cette attente ?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
						a.inserte();
						dt.dispose();
						}
					}
				});
//			}
			
		}
	}
	
	class ButtonDetail_cons implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			String i =  ((JButton)event.getSource()).getText();
			int id = Integer.parseInt(i);
			System.out.println(id);
			Detail_Consultation frame = new Detail_Consultation(id);
			frame.setVisible(true);
			System.out.println("Detail complez");
		}
	}
	
	class ButtonDetail_s implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			String i =  ((JButton)event.getSource()).getText();
			int id = Integer.parseInt(i);
			System.out.println(id);
			Detail_Sortie frame = new Detail_Sortie(id);
			frame.setVisible(true);
			System.out.println("Detail Sortie");
		}
	}
	
	class ButtonDetail_a implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			String i =  ((JButton)event.getSource()).getText();
			int id = Integer.parseInt(i);
			System.out.println(id);
			Detail_Attente frame = new Detail_Attente(id);
			frame.setVisible(true);
			System.out.println("Detail Attente");
		}
	}
	
	class ButtonDetail_h implements ActionListener{
		private int column, row;
		private JTable table;
		private int nbre = 0;
		public void setColumn(int col){this.column = col;}
		public void setRow(int row){this.row = row;}
		public void setTable(JTable table){this.table = table;}
		public void actionPerformed(ActionEvent event) {
			String i =  ((JButton)event.getSource()).getText();
			int id = Integer.parseInt(i);
			System.out.println(id);
			Detail_Historique frame = new Detail_Historique(id);
			frame.setVisible(true);
			System.out.println("Detail historique");
		}
	}
}
