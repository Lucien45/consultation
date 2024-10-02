package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class app extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app frame = new app();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public app() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNext = new JLabel("");
		lblNext.setIcon(new ImageIcon(app.class.getResource("/Icon/fast_forward_16px.png")));
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setBounds(120, 226, 24, 25);
		contentPane.add(lblNext);
		
		JLabel lblEnd = new JLabel("");
		lblEnd.setIcon(new ImageIcon(app.class.getResource("/Icon/end_16px.png")));
		lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnd.setBounds(154, 226, 24, 25);
		contentPane.add(lblEnd);
		
		JLabel lblPrev = new JLabel("");
		lblPrev.setIcon(new ImageIcon(app.class.getResource("/Icon/rewind_16px.png")));
		lblPrev.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrev.setBounds(55, 226, 24, 25);
		contentPane.add(lblPrev);
		
		JLabel lblFirst = new JLabel("");
		lblFirst.setIcon(new ImageIcon(app.class.getResource("/Icon/skip_to_start_16px.png")));
		lblFirst.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirst.setBounds(21, 226, 24, 25);
		contentPane.add(lblFirst);
	}
}
