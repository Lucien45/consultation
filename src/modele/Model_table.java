package modele;

import javax.swing.table.AbstractTableModel;

public class Model_table extends AbstractTableModel{
	private Object[][] data;
	private String[] title;

	public Model_table(Object[][] data, String[] title){
		this.data = data;
		this.title = title;
	}

	public String getColumnName(int col) {
		return this.title[col];
	}

	public int getColumnCount() {
		return this.title.length;
	}

	public int getRowCount() {
		return this.data.length;
	}

	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	public void setValueAt(Object value, int row, int col) {

		if(!this.getColumnName(col).equals("sortie") &&!this.getColumnName(col).equals("Detail") &&!this.getColumnName(col).equals("Action")&&!this.getColumnName(col).equals("attente"))
			this.data[row][col] = value;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int col){
		return this.data[0][col].getClass();
	}
	public boolean isCellEditable(int row, int col){
		return true;
	}
}
