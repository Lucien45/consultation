package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import modele.User;
import net.miginfocom.swing.MigLayout;


public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");
	int xx,xy;
	private JComboBox comboType;
	private JPanel bg;
	private BorderLayout layout =  new BorderLayout(0, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		/**
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrameLogin frame = new FrameLogin();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
//		**/
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public FrameLogin() {
//		layout = new MigLayout("[]", "[]");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
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
				FrameLogin.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(164, 142, 306, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals("Email")) {
					txtEmail.setText("");
				}else {
					txtEmail.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().equals("")) {
					txtEmail.setText("Email");
				}
			}
		});
		txtEmail.setBorder(null);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		txtEmail.setText("Email");
		txtEmail.setBounds(10, 11, 229, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblIconEmail = new JLabel("");
		lblIconEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconEmail.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/username_24px.png")));
		lblIconEmail.setBounds(260, 0, 46, 40);
		panel.add(lblIconEmail);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(164, 217, 306, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				} else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 223, 20);
		panel_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/password_24px.png")));
		lblIconPassword.setBounds(260, 0, 46, 40);
		panel_1.add(lblIconPassword);
		
		JPanel pntBtnLogin = new JPanel();
		pntBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				action_log();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pntBtnLogin.setBackground(new Color(30,60,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pntBtnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pntBtnLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pntBtnLogin.setBackground(new Color(30,60,60));
			}
		});
		pntBtnLogin.setBackground(new Color(47, 79, 79));
		pntBtnLogin.setBounds(189, 347, 250, 49);
		contentPane.add(pntBtnLogin);
		pntBtnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("CONNEXION");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLogin.setBounds(93, 11, 120, 27);
		pntBtnLogin.add(lblLogin);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/key_24px.png")));
		lblIconLogin.setBounds(33, 0, 50, 50);
		pntBtnLogin.add(lblIconLogin);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/logo_4.png")));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(201, 11, 271, 120);
		contentPane.add(lblIconLogo);
		
		lblLoginMessage.setForeground(Color.RED);
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 13));
		lblLoginMessage.setBounds(164, 318, 331, 18);
		contentPane.add(lblLoginMessage);
		
		JPanel pntBtnSignup = new JPanel();
		pntBtnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup framesignup = new Signup();
				framesignup.setVisible(true);
				FrameLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pntBtnSignup.setBackground(new Color(30,60,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pntBtnSignup.setBackground(new Color(0, 51, 51));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pntBtnSignup.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pntBtnSignup.setBackground(new Color(30,60,60));
			}
		});
		pntBtnSignup.setLayout(null);
		pntBtnSignup.setBackground(new Color(0, 51, 51));
		pntBtnSignup.setBounds(60, 407, 253, 52);
		contentPane.add(pntBtnSignup);
		
		JLabel lblSignup = new JLabel("INSCRIPTION");
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setFont(new Font("Arial", Font.BOLD, 14));
		lblSignup.setBounds(90, 11, 128, 27);
		pntBtnSignup.add(lblSignup);
		
		JLabel lblIconSignup = new JLabel("");
		lblIconSignup.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/add_user_male_26px.png")));
		lblIconSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconSignup.setBounds(30, 0, 50, 50);
		pntBtnSignup.add(lblIconSignup);
		
		JPanel pntBtnForgot = new JPanel();
		pntBtnForgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameForgot frame = new FrameForgot();
				frame.setVisible(true);
				FrameLogin.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pntBtnForgot.setBackground(new Color(30,60,60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pntBtnForgot.setBackground(new Color(0, 100, 0));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pntBtnForgot.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pntBtnForgot.setBackground(new Color(30,60,60));
			}
		});
		pntBtnForgot.setLayout(null);
		pntBtnForgot.setBackground(new Color(0, 100, 0));
		pntBtnForgot.setBounds(323, 407, 250, 52);
		contentPane.add(pntBtnForgot);
		
		JLabel lblMotForgot = new JLabel("MOT DE PASSE OBLIER");
		lblMotForgot.setForeground(Color.WHITE);
		lblMotForgot.setFont(new Font("Arial", Font.BOLD, 12));
		lblMotForgot.setBounds(87, 0, 163, 52);
		pntBtnForgot.add(lblMotForgot);
		
		JLabel lblIconForgot = new JLabel("");
		lblIconForgot.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/forgot_password_24_1px.png")));
		lblIconForgot.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconForgot.setBounds(24, 0, 53, 52);
		pntBtnForgot.add(lblIconForgot);
		
		JPanel ButtonClose = new JPanel();
		ButtonClose.setBackground(new Color(0, 139, 139));
		ButtonClose.setBounds(603, 11, 45, 39);
		contentPane.add(ButtonClose);
		ButtonClose.setLayout(new BorderLayout(0, 0));
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonClose.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonClose.setBackground(new Color(0, 139, 139));
			}
		});
		close.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/close_window_16px.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonClose.add(close, BorderLayout.CENTER);
		
		JPanel ButtonMin = new JPanel();
		ButtonMin.setBackground(new Color(0, 139, 139));
		ButtonMin.setBounds(557, 11, 45, 39);
		contentPane.add(ButtonMin);
		ButtonMin.setLayout(new BorderLayout(0, 0));
		
		JLabel fullmin = new JLabel("");
		fullmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(FrameLogin.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				ButtonMin.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ButtonMin.setBackground(new Color(0, 139, 139));
			}
		});
		fullmin.setIcon(new ImageIcon(FrameLogin.class.getResource("/Icon/subtract_16px.png")));
		fullmin.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonMin.add(fullmin, BorderLayout.CENTER);
		
		comboType = new JComboBox();
		comboType.addItem("");
		comboType.addItem("Admin");
		comboType.addItem("Secretaire");
		comboType.addItem("Autre");
		comboType.setBounds(164, 277, 199, 40);
		contentPane.add(comboType);
		
		JLabel lblIconType = new JLabel("Type Compte");
		lblIconType.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIconType.setBounds(373, 277, 128, 39);
		contentPane.add(lblIconType);
		
		
		bg = new JPanel();
		bg.setBackground(new Color(0, 139, 139));
		bg.setBounds(40, 11, 178, 25);
		contentPane.add(bg);
//		bg.setLayout(new BorderLayout(0, 0));
		bg.setLayout(layout);
		
		setUndecorated(true);
		setLocationRelativeTo(null);
	}
	
	private void action_log(){
		String email, password, type;
		email = txtEmail.getText();
		password = txtPassword.getText();
		type = comboType.getSelectedItem().toString();
		if (!email.equals("") && !email.equals("Email") && !password.equals("") && !password.equals("Password") && !type.equals("")) {
			User u = new User(email, password, type);
			u.login(lblLoginMessage, this);
		} else {
			lblLoginMessage.setText("Remplisser tous les champs!");
			showMessage(Message.MessageType.ERROR, "Erreur");
		}
	}
	
	private void showMessage(Message.MessageType messageType, String message) {
		Message ms = new Message();
		ms.showMesage(messageType, message);
		TimingTarget target = new TimingTargetAdapter() {
			public void begin() {
				if (!ms.isShow()) {
//					bg.add(ms, "pos 0.5al -30", 0);
					bg.add(ms, BorderLayout.CENTER);
					ms.setVisible(true);
					bg.repaint();
				}
			}
			
			public void timingEvent(float fraction) {
				float f;
				if (ms.isShow()) {
					f = 40 * (1f - fraction);
				} else {
					f = 40 * fraction;
				}
				
//				layout.setComponentConstraints(ms, "pos 0.5al"+ (int) (f - 30));

				bg.repaint();
				bg.revalidate();
			}
			
			public void  end() {
				if (ms.isShow()) {
					bg.remove(ms);
					bg.repaint();
					bg.revalidate();
				}else {
					ms.setShow(true);
				}
			}
		};
		Animator animator = new Animator(300, target);
		animator.setResolution(0);
		animator.setAcceleration(0.5f);
		animator.setDeceleration(0.5f);
		animator.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
				
			}
		}).start();
	}
}
