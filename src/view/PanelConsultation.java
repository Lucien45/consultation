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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import controller.CRUD_Consultation;
import controller.Liste_consultation;
import modele.Consultation;
import modele.Visiteur;

public class PanelConsultation extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	Visiteur vis = new Visiteur();
	Consultation con = new Consultation();
	private JPanel panelAdd;
	private JButton btnAdd;
	private JDateChooser dateChooser_Deux_2;
	private JDateChooser dateChooser_Deux_1;
	private JButton btnFiltrer2;
	private JPanel panelCentre;
	private Liste_consultation list;
	private JButton btnFirst;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnLast;
	private JComboBox comboChec;
	public PanelConsultation() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 964, 690);
		setSize(897,752);
		setLayout(new BorderLayout(0, 0));
		
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 50));
		Header.setBackground(SystemColor.inactiveCaption);
		add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		actualiser();
		
		panelAdd = new JPanel();
		panelAdd.setPreferredSize(new Dimension(120, 10));
		panelAdd.setBackground(SystemColor.inactiveCaption);
		Header.add(panelAdd, BorderLayout.EAST);
		panelAdd.setLayout(new BorderLayout(0, 0));
		
		JPanel panelContent = new JPanel();
		panelContent.setBackground(SystemColor.inactiveCaption);
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		
		panelCentre = new JPanel();
		panelCentre.setBackground(SystemColor.inactiveCaption);
		panelCentre.setPreferredSize(new Dimension(200, 10));
		panelContent.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new BorderLayout(0, 0));
		
		btnAdd = new JButton("Nouveau");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdd.setIcon(new ImageIcon(PanelConsultation.class.getResource("/Icon/create_24px.png")));
		nouveau();
		panelAdd.add(btnAdd, BorderLayout.CENTER);
		
		JPanel panelService = new JPanel();
		panelService.setPreferredSize(new Dimension(80, 0));
		panelService.setBackground(SystemColor.inactiveCaption);
		Header.add(panelService, BorderLayout.WEST);
		panelService.setLayout(new BorderLayout(0, 0));
		
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
				
				reaffiche();
				
			}
		});
		lblRefresh.setIcon(new ImageIcon(PanelConsultation.class.getResource("/Icon/refresh_30px.png")));
		lblRefresh.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Refresh.add(lblRefresh, BorderLayout.CENTER);
		
		JPanel panel_sepDrt = new JPanel();
		panel_Refresh.add(panel_sepDrt, BorderLayout.EAST);
		panel_sepDrt.setPreferredSize(new Dimension(3, 10));
		
		JPanel panel_sepBas = new JPanel();
		panel_sepBas.setPreferredSize(new Dimension(10, 3));
		panelService.add(panel_sepBas, BorderLayout.SOUTH);
		
		JPanel paneLDoite = new JPanel();
		paneLDoite.setBackground(SystemColor.inactiveCaption);
		paneLDoite.setPreferredSize(new Dimension(40, 10));
		panelContent.add(paneLDoite, BorderLayout.EAST);
		
		JPanel paneLGauche = new JPanel();
		paneLGauche.setBackground(SystemColor.inactiveCaption);
		paneLGauche.setPreferredSize(new Dimension(40, 10));
		panelContent.add(paneLGauche, BorderLayout.WEST);
		
		JPanel paneLNord = new JPanel();
		paneLNord.setBackground(SystemColor.inactiveCaption);
		paneLNord.setPreferredSize(new Dimension(10, 100));
		panelContent.add(paneLNord, BorderLayout.NORTH);
		paneLNord.setLayout(new BorderLayout(0, 0));
		
		JPanel panelDeux = new JPanel();
		panelDeux.setBackground(SystemColor.inactiveCaption);
		panelDeux.setPreferredSize(new Dimension(10, 65));
		paneLNord.add(panelDeux, BorderLayout.NORTH);
		panelDeux.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGauche = new JPanel();
		panelGauche.setBackground(SystemColor.inactiveCaption);
		panelGauche.setPreferredSize(new Dimension(150, 10));
		panelDeux.add(panelGauche, BorderLayout.WEST);
		panelGauche.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panelGauche.add(panel, BorderLayout.NORTH);
		
		JPanel panelRBT1 = new JPanel();
		panelRBT1.setBackground(SystemColor.inactiveCaption);
		panelGauche.add(panelRBT1, BorderLayout.CENTER);
		panelRBT1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Filtrer la date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelRBT1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.inactiveCaption);
		panelGauche.add(panel_8, BorderLayout.SOUTH);
		
		
		JPanel panelButton = new JPanel();
		panelButton.setPreferredSize(new Dimension(190, 10));
		panelButton.setBackground(SystemColor.inactiveCaption);
		panelDeux.add(panelButton, BorderLayout.EAST);
		panelButton.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 15));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panelButton.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 15));
		panel_2.setBackground(SystemColor.inactiveCaption);
		panelButton.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(150, 10));
		panel_4.setBackground(SystemColor.inactiveCaption);
		panelButton.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		btnFiltrer2 = new JButton("Filtrer");
		btnFiltrer2.setIcon(new ImageIcon(PanelConsultation.class.getResource("/Icon/filter_24px.png")));
		filtrageDeux();
		btnFiltrer2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(btnFiltrer2, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(15, 10));
		panel_6.setBackground(SystemColor.inactiveCaption);
		panel_4.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.inactiveCaption);
		panel_7.setBorder(null);
		panel_7.setPreferredSize(new Dimension(30, 10));
		panel_4.add(panel_7, BorderLayout.EAST);
		
		JPanel panelCalendar = new JPanel();
		panelCalendar.setBackground(SystemColor.inactiveCaption);
		panelDeux.add(panelCalendar, BorderLayout.CENTER);
		panelCalendar.setLayout(new BorderLayout(0, 0));
		
		JPanel panelC1 = new JPanel();
		panelC1.setBackground(SystemColor.inactiveCaption);
		panelC1.setPreferredSize(new Dimension(277, 10));
		panelCalendar.add(panelC1, BorderLayout.WEST);
		panelC1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setPreferredSize(new Dimension(10, 17));
		panel_8_1.setBackground(SystemColor.inactiveCaption);
		panelC1.add(panel_8_1, BorderLayout.NORTH);
		panel_8_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Debut");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8_1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setPreferredSize(new Dimension(10, 17));
		panel_9_1.setBackground(SystemColor.inactiveCaption);
		panelC1.add(panel_9_1, BorderLayout.SOUTH);
		
		dateChooser_Deux_1 = new JDateChooser();
		dateChooser_Deux_1.setDateFormatString("yyy-MM-dd");
		panelC1.add(dateChooser_Deux_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setPreferredSize(new Dimension(20, 10));
		panelC1.add(panel_3, BorderLayout.EAST);
		
		JPanel panelC2 = new JPanel();
		panelC2.setBackground(SystemColor.inactiveCaption);
		panelC2.setPreferredSize(new Dimension(277, 10));
		panelCalendar.add(panelC2, BorderLayout.EAST);
		panelC2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8_1_1 = new JPanel();
		panel_8_1_1.setPreferredSize(new Dimension(10, 17));
		panel_8_1_1.setBackground(SystemColor.inactiveCaption);
		panelC2.add(panel_8_1_1, BorderLayout.NORTH);
		panel_8_1_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Fin");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_8_1_1.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_9_1_1 = new JPanel();
		panel_9_1_1.setPreferredSize(new Dimension(10, 17));
		panel_9_1_1.setBackground(SystemColor.inactiveCaption);
		panelC2.add(panel_9_1_1, BorderLayout.SOUTH);
		
		dateChooser_Deux_2 = new JDateChooser();
		dateChooser_Deux_2.setDateFormatString("yyy-MM-dd");
		panelC2.add(dateChooser_Deux_2, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.inactiveCaption);
		panelC2.add(panel_5, BorderLayout.WEST);
		
		JPanel panelUn = new JPanel();
		panelUn.setPreferredSize(new Dimension(10, 30));
		panelUn.setBackground(SystemColor.inactiveCaption);
		paneLNord.add(panelUn, BorderLayout.SOUTH);
		panelUn.setLayout(new BorderLayout(0, 0));
		
		JPanel paneLSud = new JPanel();
		paneLSud.setBackground(SystemColor.inactiveCaption);
		paneLSud.setPreferredSize(new Dimension(10, 70));
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
		panel_Pagination.setPreferredSize(new Dimension(420, 10));
		panel_Pagination.setBackground(SystemColor.inactiveCaption);
		paneLSud.add(panel_Pagination, BorderLayout.EAST);
		panel_Pagination.setLayout(null);
		
		btnFirst = new JButton("First");
		
		btnFirst.setBounds(0, 11, 80, 29);
		panel_Pagination.add(btnFirst);
		
		btnPrev = new JButton("Previous");
		btnPrev.setBounds(101, 11, 73, 29);
		panel_Pagination.add(btnPrev);
		
		comboChec = new JComboBox();
		comboChec.setBounds(184, 12, 43, 26);
		panel_Pagination.add(comboChec);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(237, 11, 60, 29);
		panel_Pagination.add(btnNext);
		
		btnLast = new JButton("Last");
		btnLast.setBounds(307, 11, 80, 29);
		panel_Pagination.add(btnLast);
		
		list = new Liste_consultation(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		panelCentre.add(list, BorderLayout.CENTER);
	}
	
	protected void reaffiche() {
		panelCentre.removeAll();
		panelCentre.repaint();
		panelCentre.revalidate();
		
		list = new Liste_consultation(btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
		list.setVisible(true);
		
		panelCentre.add(list, BorderLayout.CENTER);
		panelCentre.repaint();
		panelCentre.revalidate();
		JOptionPane.showMessageDialog(null,"actulisé!",null,JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void generate_excel(String nom){
		Workbook wb = new HSSFWorkbook();
		
		OutputStream fileOut;
		try {
			fileOut = new FileOutputStream("D:\\"+nom+".xlsx");
			wb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"EXCEL créer avec succès!",null,JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	protected void generate_pdf(String nom) {
		LocalDate now = LocalDate.now();
		Document doc = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("D://"+nom+".pdf"));
			System.out.println("PDF created.");
			
			doc.open();
			doc.add(new Paragraph("Liste des consultation!!!!"));
			doc.add(new Paragraph(""+now));
			doc.close();
			writer.close();
			JOptionPane.showMessageDialog(null,"PDF créer avec succès!",null,JOptionPane.INFORMATION_MESSAGE);
		} catch (DocumentException e){
			e.printStackTrace();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	private void filtrageDeux() {
		btnFiltrer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String debut = ((JTextField)dateChooser_Deux_1.getDateEditor().getUiComponent()).getText();
				String fin = ((JTextField)dateChooser_Deux_2.getDateEditor().getUiComponent()).getText();
				
				System.out.println("Debut: "+debut+" | Fin: "+fin);
				getPanelCentre().removeAll();
				getPanelCentre().repaint();
				getPanelCentre().revalidate();
				
				list = new Liste_consultation(btnLast, btnNext, btnPrev, btnFirst, comboChec, "filtrage", debut, fin);
				list.setVisible(true);
				
				getPanelCentre().add(list, BorderLayout.CENTER);
				getPanelCentre().repaint();
				getPanelCentre().revalidate();
			}
		});
	}
	public JPanel getPanelCentre() {
		return panelCentre;
	}
	public void setPanelCentre(JPanel panelCentre) {
		this.panelCentre = panelCentre;
	}
	private void nouveau() {
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD_Consultation crud = new CRUD_Consultation(getPanelCentre(), btnLast, btnNext, btnPrev, btnFirst, comboChec, "normal");
				crud.setVisible(true);
			}
		});
	}
	private void actualiser() {
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
}
