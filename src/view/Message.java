package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Message extends JFrame {

	private JPanel contentPane;
	private MessageType messageType = MessageType.SUCCESS;
	private boolean show;
	private JLabel lblMessage;
	
	public boolean isShow() {
		return show;
	}
	
	public void setShow(boolean show) {
		this.show = show;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message frame = new Message();
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
	public Message() {
		setSize(new Dimension(323, 25));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 25);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMessage = new JLabel("MESSAGE");
		lblMessage.setSize(new Dimension(300, 30));
		lblMessage.setForeground(new Color(248, 248, 248));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(0, 0, 300, 25);
		contentPane.add(lblMessage);
	}
	
	public void showMesage(MessageType messageType, String message) {
		this.messageType = messageType;
		lblMessage.setText(message);
		if (messageType==MessageType.SUCCESS) {
			lblMessage.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\done_16px.png"));
		} else {
			lblMessage.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace1\\Projet_Final\\src\\Icon\\cancel_16px.png"));
		}
	}
	
	@Override
	public void paintComponents(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (messageType == MessageType.SUCCESS) {
			g2.setColor(new Color(15, 174, 37));
		} else {
			g2.setColor(new Color(240, 5, 53));
		}
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setComposite(AlphaComposite.SrcOver);
		g2.setColor(new Color(245, 245, 245));
		g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
		super.paintComponents(g);
	}
	
	public static enum MessageType{
		SUCCESS, ERROR
	}
	
}
