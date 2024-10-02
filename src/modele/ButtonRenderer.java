package modele;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		//On �crit dans le bouton ce que contient la cellule
		setText((value != null) ? value.toString() : "");

		//On retourne notre bouton
		return this;
	}
	
	public ButtonRenderer(String lien) {
		setIcon(new ImageIcon(lien));
		setBorder(null);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		
	}

}
