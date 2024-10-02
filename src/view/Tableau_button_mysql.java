package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.mysql.cj.xdevapi.Statement;

import modele.Connexion;

public class Tableau_button_mysql {
	private JFrame frame;
	private JTable table;
//	private Code_Swing code = new Code_Swing();
	private JMenuBar menuBar = new JMenuBar();

	Statement st, st1;
	ResultSet rst, rst1;
	
	static Connexion connexion = new Connexion();
	static PreparedStatement pst;
	static ResultSet rs;
	
	Integer page = 1;
	Integer rowCountPerPage = 5;
	Integer totalPage = 1;
	Integer totalData = 0;
	
	String title[] = {"ID", "Code", "Name", "Prix", "Action"};
	private DefaultTableModel modelT;
	private DefaultTableModel renistialisemodel = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableau_button_mysql window = new Tableau_button_mysql();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Tableau_button_mysql() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		modelT = new DefaultTableModel();

		modelT.addColumn("ID");
		modelT.addColumn("date_heure");
		modelT.addColumn("Modtif");
		modelT.addColumn("idV");
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(10, 11, 604, 73);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(new BorderLayout(0, 0));
		
		
		
		/**
		 *   MENU
		 */
		JMenu animation = new JMenu("Animation");
		JMenu forme = new JMenu("Forme");
		JMenu typeForme = new JMenu("Type de forme");
		JMenu aPropos = new JMenu("A propos");
		
		JMenuItem lancer = new JMenuItem("Lancer l'animation");
		JMenuItem arreter = new JMenuItem("Arrêter l'animation");
		JMenuItem quitter = new JMenuItem("Quitter l'animation");
		JMenuItem aProposItem = new JMenuItem("?");
		
		JCheckBoxMenuItem morph = new JCheckBoxMenuItem("Morphing");
		
		JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré");
		JRadioButtonMenuItem rond = new JRadioButtonMenuItem("Rond");
		JRadioButtonMenuItem triangle = new JRadioButtonMenuItem("Triangle");
		JRadioButtonMenuItem etoile = new JRadioButtonMenuItem("Etoile");
		
		ButtonGroup bg = new ButtonGroup();
		
		
		animation.add(lancer);
		lancer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Lancer");
			}
			
		});
		animation.add(arreter);
		arreter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Arreter");
			}
			
		});
		animation.addSeparator();
		animation.add(quitter);
		
		bg.add(carre);
		bg.add(triangle);
		bg.add(rond);
		bg.add(etoile);
		
		typeForme.add(rond);
		typeForme.add(carre);
		typeForme.add(triangle);
		typeForme.add(etoile);

		rond.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("rond");			
			}
			
		});
		
		carre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("carre");			
			}
			
		});
		
		triangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("triangle");			
			}
			
		});
		
		etoile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("etoile");			
			}
			
		});
		
		forme.add(typeForme);
		forme.add(morph);
		
		aPropos.add(aProposItem);
		
		menuBar.add(animation);
		menuBar.add(forme);
		menuBar.add(aPropos);
		
		panelMenu.add(menuBar, BorderLayout.NORTH);
		/**
		 *  TABLEAU
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 166, 624, 280);
		
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(126, 132, 89, 23);
		frame.getContentPane().add(btnLast);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(241, 132, 89, 23);
		frame.getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(436, 132, 89, 23);
		frame.getContentPane().add(btnPrevious);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(535, 132, 89, 23);
		frame.getContentPane().add(btnFirst);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(363, 133, 53, 20);
		this.compteComboBox("product", comboBox);
		frame.getContentPane().add(comboBox);
		
		
		
		
		
		
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = totalPage;
				initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page<totalPage) {
					page++;
					initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
				}
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(page>1) {
					page --;
					initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
				}
			}
		});
	
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page = 1;
				initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
			}
		});
		
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
			}
			
		});
		
		table = new JTable();
		scrollPane.setViewportView(table);
		this.table.setRowHeight(30);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(scrollPane);

		this.initPagination(modelT, comboBox, btnFirst, btnPrevious, btnLast, btnNext);
		
		
	}
	
	public void compteComboBox(String nomTable, JComboBox comboBox) {
		int i = 5;
//		try {
//			String rq1 = "select * from Consultation";
//			Statement stmt = (Statement) connexion.getConn().createStatement();
//			ResultSet st = ((java.sql.Statement) stmt).executeQuery("select * from consultation");
//			 totalData = getLengthTable();
//			while(((ResultSet) st).next()) {
//				if(i<totalData) {
//					comboBox.addItem(i);
//				}
//				i= i+5;
//	           }
//			comboBox.addItem(totalData);
//		}catch(SQLException e){
//			 e.printStackTrace();
//		}
	}
	
	public void initPagination(DefaultTableModel model, JComboBox comboBox, JButton btnFirste, JButton btnPrevious, JButton btnLast, JButton btnNext ) {
	
		table.setModel(renistialisemodel);
		
		int j = model.getColumnCount();
		String co = comboBox.getSelectedItem().toString();
		
		rowCountPerPage = Integer.valueOf(co);
		totalData = getLengthTable();
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
		
	
		
//		try {
//			pst = connexion.getConn().prepareStatement("SELECT * FROM `consultation` limit ?,?");
//			pst.setInt(1, rowCountPerPage * (page - 1));
//			pst.setInt(2, rowCountPerPage);
//			rs = pst.executeQuery();
//			int row = 0;
//			while(rs.next()==true) {
//				data[row][0]= rs.getString("id");
//				data[row][1]= rs.getString("date_heure");
//				data[row][2]= rs.getString("motif");
//				data[row][3]= rs.getString("idV");
//				data[row][4]= rs.getString("idV");
//				row = row + 1;
//			}
//			
//		}catch(SQLException e) {
//			System.out.println(e);
//		}
		
		
		
		ZModel m = new ZModel(data, title);
		
		table.setModel(m);
		
//		autoResizeColumn(table);
	}
	public int getLengthTable() {
		int count = 0;
//		String rq = "select * from Consultation";
//		try{
//			 st=(Statement) connexion.getConn().createStatement();
//			 rst=((java.sql.Statement) st).executeQuery(rq);
//			 while(rst.next()){
//				 count = count + 1;
//			 }	
//			 
//		}
//		 catch(SQLException ex){
//		    	JOptionPane.showMessageDialog(null,"Erreur dans consulttion!",null,JOptionPane.ERROR_MESSAGE);	
//		 }
//		System.out.println("total "+count);
		
		return count;
	}
	
	public void autoResizeColumn(JTable jtable) {
		JTableHeader header = jtable.getTableHeader();
		int rowCount = jtable.getRowCount();
		
		final Enumeration columns = jtable.getColumnModel().getColumns();
		while(columns.hasMoreElements()) {
			TableColumn column = (TableColumn)columns.nextElement();
			int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			int width = (int)jtable.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(jtable, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();
			for(int row = 0; row<rowCount; row++) {
				int preferedWidth = (int)jtable.getCellRenderer(row, col).getTableCellRendererComponent(jtable, jtable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
				width = Math.max(width, preferedWidth);
			}
			header.setResizingColumn(column);
			column.setWidth(width + jtable.getIntercellSpacing().width);
			
			
		}
	}
	
	class ZModel extends AbstractTableModel{
		private Object[][] data;
		private String[] title;
		DefaultTableModel model;
		
		public ZModel(Object[][] data, String[] title) {
			this.data = data;
			this.title = title;
		}
		
		public ZModel(DefaultTableModel model) {
			this.model = model;
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
		
		public String getColumnName(int col) {
			return this.title[col];
		}
		
		public Class getColumnClass(int col){
			return this.data[0][col].getClass();
		}
		
		public boolean isCellEditable(int row, int col){
			if(getValueAt(0, col) instanceof JButton) 
				return false;
			return true;
		}
	}
}
