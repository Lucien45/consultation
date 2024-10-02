package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class FrameForgot extends JFrame {

	private JPanel contentPane;
	private JTextField txtSendEmail;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameForgot frame = new FrameForgot();
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
	public FrameForgot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(FrameForgot.class.getResource("/Icon/forgot_password_64px.png")));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(202, 26, 128, 64);
		contentPane.add(lblIconLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(123, 133, 282, 40);
		contentPane.add(panel_1);
		
		txtSendEmail = new JTextField();
		txtSendEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSendEmail.getText().equals("Send Email")) {
					txtSendEmail.setText("");
				}else {
					txtSendEmail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSendEmail.getText().equals("")) {
					txtSendEmail.setText("Send Email");
				}
			}
		});
		txtSendEmail.setText("Send Email");
		txtSendEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSendEmail.setColumns(10);
		txtSendEmail.setBorder(null);
		txtSendEmail.setBounds(10, 11, 216, 20);
		panel_1.add(txtSendEmail);
		
		JLabel lblIconEmail = new JLabel("");
		lblIconEmail.setIcon(new ImageIcon(FrameForgot.class.getResource("/Icon/email_send_24px.png")));
		lblIconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmail.setBounds(236, 0, 46, 40);
		panel_1.add(lblIconEmail);
		
		JButton btnSend = new JButton("send");
		btnSend.setIcon(new ImageIcon(FrameForgot.class.getResource("/Icon/send_24px.png")));
		btnSend.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBackground(new Color(51, 51, 0));
		btnSend.setBounds(121, 198, 105, 40);
		contentPane.add(btnSend);
		
		JLabel lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBackground(SystemColor.menu);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FrameForgot.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(new Color(0,0,0));
			}
		});
		lblX.setBounds(498, 0, 34, 29);
		contentPane.add(lblX);
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
				FrameForgot.this.setLocation(x - xx, y - xy);
			}
		});
		setUndecorated(true);
	}

}
