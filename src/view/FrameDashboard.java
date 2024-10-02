package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import modele.User;

@SuppressWarnings("serial")
public class FrameDashboard extends JFrame {

	private PanelHome panel_Home;
	private PanelConsultation panel_Consultations ;
	private PanelAttente panel_Attantes;
	private PanelSortie panel_sorties;
	private PanelDirections panel_Directions;
	private PanelHistoriques panel_historiques;
	
	private JPanel contentPane;
	private int xx,xy;
	private JPanel menuhide;
	private boolean a;
	private JPanel hidehome;
	private JPanel panelHistorique;
	private JPanel panelDirection;
	private JPanel paneloSortie;
	private JPanel panelAttentes;
	private JPanel panelConsultation;
	private JPanel panelHome;
	private JPanel hidehistorique;
	private JPanel hidedirection;
	private JPanel hidesortie;
	private JPanel hideattente;
	private JPanel hideConsulttion;
	private JPanel panelMainContent;
	private JPanel panelHideMenu;
	
	User u = new User();
	private JPanel panelSignOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		/**
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrameDashboard frame = new FrameDashboard();
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
	public FrameDashboard() {
		setUndecorated(true);
		setPreferredSize(new Dimension(1150, 750));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 548);
		setLocation(40,05);
		setSize(1174,750);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
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
				FrameDashboard.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.setPreferredSize(new Dimension(1150, 750));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelMainContent = new JPanel();
		panelMainContent.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panelMainContent, BorderLayout.CENTER);
		panelMainContent.setLayout(new BorderLayout(0, 0));
		
		try {
			panel_Home = new PanelHome();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_Consultations = new PanelConsultation();
		panel_Attantes = new PanelAttente();
		panel_sorties = new PanelSortie();
		panel_Directions = new PanelDirections();
		panel_historiques = new PanelHistoriques();
		
		JPanel Header = new JPanel();
		Header.setPreferredSize(new Dimension(800, 50));
		Header.setBackground(new Color(47, 79, 79));
		contentPane.add(Header, BorderLayout.NORTH);
		Header.setLayout(new BorderLayout(0, 0));
		
		JPanel Iconminmaxclose = new JPanel();
		Iconminmaxclose.setLayout(null);
		Iconminmaxclose.setPreferredSize(new Dimension(150, 50));
		Iconminmaxclose.setBackground(new Color(47, 79, 79));
		Header.add(Iconminmaxclose, BorderLayout.EAST);
		
		JPanel ButtonClose = new JPanel();
		ButtonClose.setBackground(new Color(47, 79, 79));
		ButtonClose.setBounds(104, 0, 46, 50);
		Iconminmaxclose.add(ButtonClose);
		ButtonClose.setLayout(new BorderLayout(0, 0));
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(ButtonClose, new Color(25,29,74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(ButtonClose, new Color(47, 79, 79));
			}
		});
		close.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/close_window_16px.png")));
		close.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonClose.add(close, BorderLayout.CENTER);
		
		JPanel ButtonMax = new JPanel();
		ButtonMax.setBackground(new Color(47, 79, 79));
		ButtonMax.setBounds(51, 0, 52, 50);
		Iconminmaxclose.add(ButtonMax);
		ButtonMax.setLayout(new BorderLayout(0, 0));
		
		JLabel fullmax = new JLabel("");
		fullmax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(ButtonMax, new Color(25,29,74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(ButtonMax, new Color(47, 79, 79));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(getExtendedState() != FrameDashboard.MAXIMIZED_BOTH) {
					setExtendedState(FrameDashboard.MAXIMIZED_BOTH);
					fullmax.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/fit_to_width_16px.png")));
				}else {
					setExtendedState(FrameDashboard.NORMAL);
					fullmax.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/full_screen_16px.png")));
				}
			}
		});
		fullmax.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/full_screen_16px.png")));
		fullmax.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonMax.add(fullmax, BorderLayout.CENTER);
		
		JPanel ButtonMin = new JPanel();
		ButtonMin.setBackground(new Color(47, 79, 79));
		ButtonMin.setBounds(1, 0, 52, 50);
		Iconminmaxclose.add(ButtonMin);
		ButtonMin.setLayout(new BorderLayout(0, 0));
		
		JLabel fullmin = new JLabel("");
		fullmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(ButtonMin, new Color(25,29,74));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(ButtonMin, new Color(47, 79, 79));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(FrameDashboard.ICONIFIED);
			}
		});
		fullmin.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/subtract_16px.png")));
		fullmin.setHorizontalAlignment(SwingConstants.CENTER);
		ButtonMin.add(fullmin, BorderLayout.CENTER);
		
		JPanel ProfileUser = new JPanel();
		ProfileUser.setLayout(null);
		ProfileUser.setPreferredSize(new Dimension(250, 50));
		ProfileUser.setBackground(new Color(47, 79, 79));
		Header.add(ProfileUser, BorderLayout.WEST);
		
		JPanel profileName = new JPanel();
		profileName.setBackground(new Color(47, 79, 79));
		profileName.setBounds(63, 0, 187, 50);
		ProfileUser.add(profileName);
		profileName.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		profileName.add(lblInfo, BorderLayout.CENTER);
		
		JPanel Photo = new JPanel();
		Photo.setBackground(new Color(47, 79, 79));
		Photo.setBounds(1, 0, 62, 50);
		ProfileUser.add(Photo);
		Photo.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/logo_4.png")));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		Photo.add(lblPhoto, BorderLayout.CENTER);
		
		JPanel menu = new JPanel();
		menu.setBackground(SystemColor.inactiveCaption);
		menu.setPreferredSize(new Dimension(200, 450));
		contentPane.add(menu, BorderLayout.WEST);
		menu.setLayout(new BorderLayout(0, 0));
		
		JPanel menuIcon = new JPanel();
		menuIcon.setLayout(null);
		menuIcon.setPreferredSize(new Dimension(50, 450));
		menuIcon.setBackground(SystemColor.inactiveCaption);
		menu.add(menuIcon, BorderLayout.WEST);
		
		JPanel hidemenu = new JPanel();
		hidemenu.setPreferredSize(new Dimension(50, 50));
		hidemenu.setBackground(new Color(102, 204, 204));
		hidemenu.setBounds(0, 0, 50, 58);
		menuIcon.add(hidemenu);
		hidemenu.setLayout(new BorderLayout(0, 0));
		
		JLabel Buttonhidemenu = new JLabel("");
		Buttonhidemenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidemenu, new Color(247,78,105));
				changecolor(panelHideMenu, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidemenu, new Color(102, 204, 204));
				changecolor(panelHideMenu, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				clickmenu(hidemenu,hidehome,hideConsulttion,hideattente,hidesortie,hidedirection,hidehistorique,1);
				if(a == true) {
					hideshow(menu, a, Buttonhidemenu);
					SwingUtilities.updateComponentTreeUI(menuhide);
					a = false;
				}else {
					hideshow(menu, a, Buttonhidemenu);
					SwingUtilities.updateComponentTreeUI(menuhide);
					a = true;
				}
			}
		});
		Buttonhidemenu.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/back_32px.png")));
		Buttonhidemenu.setHorizontalAlignment(SwingConstants.CENTER);
		hidemenu.add(Buttonhidemenu, BorderLayout.CENTER);
		
		
		panelMainContent.add(panel_Home, BorderLayout.CENTER);
		
		hidehome = new JPanel();
		hidehome.setPreferredSize(new Dimension(50, 50));
		hidehome.setBackground(new Color(102, 204, 204));
		hidehome.setBounds(0, 57, 50, 58);
		menuIcon.add(hidehome);
		hidehome.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconHome = new JLabel("");
		labelIconHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidehome, new Color(247,78,105));
				changecolor(panelHome, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidehome, new Color(102, 204, 204));
				changecolor(panelHome, new Color(102, 204, 204));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				clickmenu(hidehome,hidemenu,hideConsulttion,hideattente,hidesortie,hidedirection,hidehistorique,1);
				menuClicked(panel_Home, panelMainContent);
				
			}
		});
		labelIconHome.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconHome.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/dashboard_24px.png")));
		hidehome.add(labelIconHome, BorderLayout.CENTER);
		
		hideConsulttion = new JPanel();
		hideConsulttion.setPreferredSize(new Dimension(50, 50));
		hideConsulttion.setBackground(new Color(102, 204, 204));
		hideConsulttion.setBounds(0, 115, 50, 58);
		menuIcon.add(hideConsulttion);
		hideConsulttion.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconConsultation = new JLabel("");
		labelIconConsultation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hideConsulttion, new Color(247,78,105));
				changecolor(panelConsultation, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hideConsulttion, new Color(102, 204, 204));
				changecolor(panelConsultation, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				clickmenu(hideConsulttion,hidehome,hidemenu,hideattente,hidesortie,hidedirection,hidehistorique,1);
				menuClicked(panel_Consultations, panelMainContent);
				
			}
		});
		labelIconConsultation.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/male_user_24px.png")));
		labelIconConsultation.setHorizontalAlignment(SwingConstants.CENTER);
		hideConsulttion.add(labelIconConsultation, BorderLayout.CENTER);
		
		hideattente = new JPanel();
		hideattente.setPreferredSize(new Dimension(50, 50));
		hideattente.setBackground(new Color(102, 204, 204));
		hideattente.setBounds(0, 173, 50, 58); 
		menuIcon.add(hideattente);
		hideattente.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconAttentes = new JLabel("");
		labelIconAttentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hideattente, new Color(247,78,105));
				changecolor(panelAttentes, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hideattente, new Color(102, 204, 204));
				changecolor(panelAttentes, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Attantes, panelMainContent);
				clickmenu(hideattente,hidehome,hidemenu,hideConsulttion,hidesortie,hidedirection,hidehistorique,1);
				
			}
		});
		labelIconAttentes.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/delivery_time_24px.png")));
		labelIconAttentes.setHorizontalAlignment(SwingConstants.CENTER);
		hideattente.add(labelIconAttentes, BorderLayout.CENTER);
		
		hidesortie = new JPanel();
		hidesortie.setPreferredSize(new Dimension(50, 50));
		hidesortie.setBackground(new Color(102, 204, 204));
		hidesortie.setBounds(0, 231, 50, 58);
		menuIcon.add(hidesortie);
		hidesortie.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconSortie = new JLabel("");
		labelIconSortie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidesortie, new Color(247,78,105));
				changecolor(paneloSortie, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidesortie, new Color(102, 204, 204));
				changecolor(paneloSortie, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_sorties, panelMainContent);
				clickmenu(hidesortie,hidehome,hidemenu,hideConsulttion,hideattente,hidedirection,hidehistorique,1);
				
			}
		});
		labelIconSortie.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/exit_24px.png")));
		labelIconSortie.setHorizontalAlignment(SwingConstants.CENTER);
		hidesortie.add(labelIconSortie, BorderLayout.CENTER);
		
		hidedirection = new JPanel();
		hidedirection.setPreferredSize(new Dimension(50, 50));
		hidedirection.setBackground(new Color(102, 204, 204));
		hidedirection.setBounds(0, 289, 50, 58);
		menuIcon.add(hidedirection);
		hidedirection.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconDirections = new JLabel("");
		labelIconDirections.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidedirection, new Color(247,78,105));
				changecolor(panelDirection, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidedirection, new Color(102, 204, 204));
				changecolor(panelDirection, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Directions, panelMainContent);
				clickmenu(hidedirection,hidehome,hidemenu,hideConsulttion,hideattente,hidesortie,hidehistorique,1);
				
			}
		});
		labelIconDirections.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/office_24px.png")));
		labelIconDirections.setHorizontalAlignment(SwingConstants.CENTER);
		hidedirection.add(labelIconDirections, BorderLayout.CENTER);
		
		hidehistorique = new JPanel();
		hidehistorique.setPreferredSize(new Dimension(50, 50));
		hidehistorique.setBackground(new Color(102, 204, 204));
		hidehistorique.setBounds(0, 347, 50, 58);
		menuIcon.add(hidehistorique);
		hidehistorique.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconHistorique = new JLabel("");
		labelIconHistorique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidehistorique, new Color(247,78,105));
				changecolor(panelHistorique, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidehistorique, new Color(102, 204, 204));
				changecolor(panelHistorique, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_historiques, panelMainContent);
				clickmenu(hidehistorique,hidehome,hidemenu,hideConsulttion,hideattente,hidesortie,hidedirection,1);
				
			}
		});
		labelIconHistorique.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/activity_history_24px.png")));
		labelIconHistorique.setHorizontalAlignment(SwingConstants.CENTER);
		hidehistorique.add(labelIconHistorique, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 462, 50, 338);
		menuIcon.add(panel);
		
		JPanel hidesignout = new JPanel();
		hidesignout.setPreferredSize(new Dimension(50, 50));
		hidesignout.setBackground(new Color(102, 204, 204));
		hidesignout.setBounds(0, 403, 50, 58);
		menuIcon.add(hidesignout);
		hidesignout.setLayout(new BorderLayout(0, 0));
		
		JLabel labelIconSignOut = new JLabel("");
		labelIconSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidesignout, new Color(247,78,105));
				changecolor(panelSignOut, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidesignout, new Color(102, 204, 204));
				changecolor(panelSignOut, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin framelogin = new FrameLogin();
					framelogin.setVisible(true);
					FrameDashboard.this.dispose();
				}
			}
		});
		labelIconSignOut.setIcon(new ImageIcon(FrameDashboard.class.getResource("/Icon/logout_24px.png")));
		labelIconSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		hidesignout.add(labelIconSignOut, BorderLayout.CENTER);
		
		menuhide = new JPanel();
		menuhide.setLayout(null);
		menuhide.setBackground(SystemColor.inactiveCaption);
		menu.add(menuhide, BorderLayout.CENTER);
		
		panelHome = new JPanel();
		panelHome.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				changecolor(panelHome, new Color(247,78,105));
				changecolor(hidehome, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelHome, new Color(102, 204, 204));
				changecolor(hidehome, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Home, panelMainContent);
				clickpanel(panelHome,panelConsultation,panelAttentes,paneloSortie,panelDirection,panelHistorique,1);
			}
		});
		panelHome.setPreferredSize(new Dimension(50, 50));
		panelHome.setBackground(new Color(102, 204, 204));
		panelHome.setBounds(0, 57, 150, 58);
		menuhide.add(panelHome);
		panelHome.setLayout(new BorderLayout(0, 0));
		
		JLabel labelHome = new JLabel("ACCUEIL");
		labelHome.setHorizontalAlignment(SwingConstants.CENTER);
		labelHome.setForeground(Color.WHITE);
		labelHome.setFont(new Font("Dialog", Font.BOLD, 14));
		panelHome.add(labelHome, BorderLayout.CENTER);
		
		panelConsultation = new JPanel();
		panelConsultation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(panelConsultation, new Color(247,78,105));
				changecolor(hideConsulttion, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelConsultation, new Color(102, 204, 204));
				changecolor(hideConsulttion, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Consultations, panelMainContent);
				clickpanel(panelConsultation,panelHome,panelAttentes,paneloSortie,panelDirection,panelHistorique,1);
			}
		});
		panelConsultation.setPreferredSize(new Dimension(50, 50));
		panelConsultation.setBackground(new Color(102, 204, 204));
		panelConsultation.setBounds(0, 115, 150, 58);
		menuhide.add(panelConsultation);
		panelConsultation.setLayout(new BorderLayout(0, 0));
		
		JLabel lblConsultation = new JLabel("CONSULTATIONS");
		lblConsultation.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultation.setForeground(Color.WHITE);
		lblConsultation.setFont(new Font("Dialog", Font.BOLD, 14));
		panelConsultation.add(lblConsultation, BorderLayout.CENTER);
		
		panelAttentes = new JPanel();
		panelAttentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(panelAttentes, new Color(247,78,105));
				changecolor(hideattente, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelAttentes, new Color(102, 204, 204));
				changecolor(hideattente, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Attantes, panelMainContent);
				clickpanel(panelAttentes,panelHome,panelConsultation,paneloSortie,panelDirection,panelHistorique,1);
			}
		});
		panelAttentes.setPreferredSize(new Dimension(50, 50));
		panelAttentes.setBackground(new Color(102, 204, 204));
		panelAttentes.setBounds(0, 173, 150, 58);
		menuhide.add(panelAttentes);
		panelAttentes.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAttentes = new JLabel("ATTENTES");
		lblAttentes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttentes.setForeground(Color.WHITE);
		lblAttentes.setFont(new Font("Dialog", Font.BOLD, 14));
		panelAttentes.add(lblAttentes, BorderLayout.CENTER);
		
		paneloSortie = new JPanel();
		paneloSortie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(paneloSortie, new Color(247,78,105));
				changecolor(hidesortie, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(paneloSortie, new Color(102, 204, 204));
				changecolor(hidesortie, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_sorties, panelMainContent);
				clickpanel(paneloSortie,panelHome,panelConsultation,panelAttentes,panelDirection,panelHistorique,1);
			}
		});
		paneloSortie.setPreferredSize(new Dimension(50, 50));
		paneloSortie.setBackground(new Color(102, 204, 204));
		paneloSortie.setBounds(0, 231, 150, 58);
		menuhide.add(paneloSortie);
		paneloSortie.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSortie = new JLabel("DANS SORTIE");
		lblSortie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSortie.setForeground(Color.WHITE);
		lblSortie.setFont(new Font("Dialog", Font.BOLD, 14));
		paneloSortie.add(lblSortie, BorderLayout.CENTER);
		
		panelDirection = new JPanel();
		panelDirection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(panelDirection, new Color(247,78,105));
				changecolor(hidedirection, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelDirection, new Color(102, 204, 204));
				changecolor(hidedirection, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_Directions, panelMainContent);
				clickpanel(panelDirection,panelHome,panelConsultation,panelAttentes,paneloSortie,panelHistorique,1);
			}
		});
		panelDirection.setPreferredSize(new Dimension(50, 50));
		panelDirection.setBackground(new Color(102, 204, 204));
		panelDirection.setBounds(0, 289, 150, 58);
		menuhide.add(panelDirection);
		panelDirection.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDirection = new JLabel("DIRECTIONS");
		lblDirection.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirection.setForeground(Color.WHITE);
		lblDirection.setFont(new Font("Dialog", Font.BOLD, 14));
		panelDirection.add(lblDirection, BorderLayout.CENTER);
		
		panelHistorique = new JPanel();
		panelHistorique.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(panelHistorique, new Color(247,78,105));
				changecolor(hidehistorique, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelHistorique, new Color(102, 204, 204));
				changecolor(hidehistorique, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panel_historiques, panelMainContent);
				clickmenu(hidehistorique,hidehome,hidemenu,hideConsulttion,hideattente,hidesortie,hidedirection,1);
				
			}
		});
		panelHistorique.setPreferredSize(new Dimension(50, 50));
		panelHistorique.setBackground(new Color(102, 204, 204));
		panelHistorique.setBounds(0, 347, 150, 58);
		menuhide.add(panelHistorique);
		panelHistorique.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHistorique = new JLabel("HISTORIQUE");
		lblHistorique.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistorique.setForeground(Color.WHITE);
		lblHistorique.setFont(new Font("Dialog", Font.BOLD, 14));
		panelHistorique.add(lblHistorique, BorderLayout.CENTER);
		
		JPanel panelColor = new JPanel();
		panelColor.setBackground(new Color(102, 204, 204));
		panelColor.setBounds(0, 462, 150, 340);
		menuhide.add(panelColor);
		
		panelHideMenu = new JPanel();
		panelHideMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(hidemenu, new Color(247,78,105));
				changecolor(panelHideMenu, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(hidemenu, new Color(102, 204, 204));
				changecolor(panelHideMenu, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				clickmenu(hidemenu,hidehome,hideConsulttion,hideattente,hidesortie,hidedirection,hidehistorique,1);
				if(a == true) {
					hideshow(menu, a, Buttonhidemenu);
					SwingUtilities.updateComponentTreeUI(menuhide);
					a = false;
				}else {
					hideshow(menu, a, Buttonhidemenu);
					SwingUtilities.updateComponentTreeUI(menuhide);
					a = true;
				}
			}
		});
		panelHideMenu.setBackground(new Color(102, 204, 204));
		panelHideMenu.setBounds(0, 0, 150, 58);
		menuhide.add(panelHideMenu);
		panelHideMenu.setLayout(null);
		
		panelSignOut = new JPanel();
		panelSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(panelSignOut, new Color(247,78,105));
				changecolor(hidesignout, new Color(247,78,105));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				changecolor(panelSignOut, new Color(102, 204, 204));
				changecolor(hidesignout, new Color(102, 204, 204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "vous etes sur de quitter l'application?","Confirmation",JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin framelogin = new FrameLogin();
					framelogin.setVisible(true);
					FrameDashboard.this.dispose();
				}
				
			}
		});
		panelSignOut.setPreferredSize(new Dimension(50, 50));
		panelSignOut.setBackground(new Color(102, 204, 204));
		panelSignOut.setBounds(0, 403, 150, 58);
		menuhide.add(panelSignOut);
		panelSignOut.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSignOut = new JLabel("DECONNEXION");
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 14));
		panelSignOut.add(lblSignOut, BorderLayout.CENTER);
		
		menuClicked(panel_Home, panelMainContent);
	}
	//	methodes hide and show menu bare 
	
	public void changeImage(JLabel button, URL url) {
		ImageIcon aimg = new ImageIcon(url);
		button.setIcon(aimg);
	}
	
	public void changecolor(JPanel hover, Color rand) {
		hover.setBackground(rand);
	}
	public void clickmenu(JPanel h1, JPanel h2, JPanel h3, JPanel h4,JPanel h5, JPanel h6, JPanel h7, int numberbool) {
		if(numberbool == 1) {
			h1.setBackground(new Color(247,78,105));
			h2.setBackground(new Color(102, 204, 204));
			h3.setBackground(new Color(102, 204, 204));
			h4.setBackground(new Color(102, 204, 204));
			h5.setBackground(new Color(102, 204, 204));
			h6.setBackground(new Color(102, 204, 204));
			h7.setBackground(new Color(102, 204, 204));
		}else {
			h1.setBackground(new Color(102, 204, 204));
			h2.setBackground(new Color(247,78,105));
			h3.setBackground(new Color(247,78,105));
			h4.setBackground(new Color(247,78,105));
			h5.setBackground(new Color(247,78,105));
			h6.setBackground(new Color(247,78,105));
			h7.setBackground(new Color(247,78,105));
		}
	}
	
	public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {
		if(dashboard == true) {
			menushowhide.setPreferredSize(new Dimension(50,menushowhide.getHeight()));
			changeImage(button, FrameDashboard.class.getResource("/Icon/menu_32px.png"));
		}else {
			menushowhide.setPreferredSize(new Dimension(270,menushowhide.getHeight()));
			changeImage(button,FrameDashboard.class.getResource("/Icon/back_32px.png"));
		}
	}
	
	//END methodes hide and show menu bare	
	
	//	methode change panel
	public void clickpanel(JPanel h1, JPanel h2, JPanel h3, JPanel h4,JPanel h5, JPanel h6, int numberbool) {
		if(numberbool == 1) {
			h1.setBackground(new Color(247,78,105));
			h2.setBackground(new Color(102, 204, 204));
			h3.setBackground(new Color(102, 204, 204));
			h4.setBackground(new Color(102, 204, 204));
			h5.setBackground(new Color(102, 204, 204));
			h6.setBackground(new Color(102, 204, 204));
		}else {
			h1.setBackground(new Color(102, 204, 204));
			h2.setBackground(new Color(247,78,105));
			h3.setBackground(new Color(247,78,105));
			h4.setBackground(new Color(247,78,105));
			h5.setBackground(new Color(247,78,105));
			h6.setBackground(new Color(247,78,105));
		}
	}
	
	public void menuClicked(JPanel panel, JPanel paneContent) {
		panel_Home.setVisible(false);
		panel_Consultations.setVisible(false);
		panel_Attantes.setVisible(false);
		panel_sorties.setVisible(false);
		panel_Directions.setVisible(false);
		panel_historiques.setVisible(false);
		
		paneContent.add(panel, BorderLayout.CENTER);
		panel.setVisible(true);
		
	}
}
