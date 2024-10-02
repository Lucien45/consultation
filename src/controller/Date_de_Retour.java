package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Date_de_Retour extends JFrame {

	private JPanel contentPane;
	private JDateChooser date_iverenany;
	private JButton btnvalider;
	private JLabel lblIcon;
	int xx,xy;
	
	/**
	 * Create the frame.
	 */
	public Date_de_Retour() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 313, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
				Date_de_Retour.this.setLocation(x - xx, y - xy);
			}
		});
		
		date_iverenany = new JDateChooser();
		date_iverenany.setDateFormatString("yyy-MM-dd");
		date_iverenany.setBounds(10, 30, 185, 23);
		contentPane.add(date_iverenany);
		
		btnvalider = new JButton("valider");
		btnvalider.setIcon(new ImageIcon(Date_de_Retour.class.getResource("/Icon/verified_account_16px.png")));
		btnvalider.setBounds(205, 30, 98, 23);
		contentPane.add(btnvalider);
		
		JLabel labelTitre = new JLabel("Date Du Retour");
		labelTitre.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 185, 19);
		contentPane.add(labelTitre);
		
		lblIcon = new JLabel("X");
		lblIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date_de_Retour.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIcon.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIcon.setForeground(Color.BLACK);
			}
		});
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(281, 0, 42, 19);
		contentPane.add(lblIcon);
	}

	public JDateChooser getDate_iverenany() {
		return date_iverenany;
	}

	public void setDate_iverenany(JDateChooser date_iverenany) {
		this.date_iverenany = date_iverenany;
	}

	public JButton getBtnvalider() {
		return btnvalider;
	}

	public void setBtnvalider(JButton btnvalider) {
		this.btnvalider = btnvalider;
	}
}
