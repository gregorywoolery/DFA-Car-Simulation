package com.main;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.view.Dashboard;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = -8413149401553241952L;

	
	JButton exitBtn;
	JButton continueBtn;
	JPanel splash_panel;
	private JPanel contentPane;
	private JLabel title_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		initializeComponents();
		registerListeners();
	}
	
	private void initializeComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Changes frame icon
		ImageIcon frameIcon = new ImageIcon("./Resources/img/Utech_logo.jpg");
		setIconImage(frameIcon.getImage());
		
		setBounds(100, 100, 675, 500);
		

		//Centers frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		title_label = new JLabel("<html> <center>UTech TOC </center><br>Ultra Vehicle Control System</html>");
		title_label.setHorizontalTextPosition(SwingConstants.CENTER);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setPreferredSize(new Dimension(400, 100));
		title_label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 25));
		title_label.setForeground(Color.WHITE);
		contentPane.add(title_label);
		
		splash_panel = new JPanel();
		contentPane.add(splash_panel);
		
		continueBtn = new JButton("Continue");
		contentPane.add(continueBtn);
		
		exitBtn = new JButton("Exit");
		contentPane.add(exitBtn);
		
		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("./Resources/img/interior-1.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			splash_panel.add(picLabel);
			
		} catch (IOException e) {
			System.out.print("Cannot load image");
		}
		
		this.setVisible(true);
	}
	
	private void registerListeners(){
		continueBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(continueBtn)){
			this.setVisible(false);
			Dashboard dashboard = new Dashboard();
			dashboard.setVisible(true);
		}
		
		if(e.getSource().equals(exitBtn)){
			dispose();
			System.exit(0);
		}
		
	}

}
