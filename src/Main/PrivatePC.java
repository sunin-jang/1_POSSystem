package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.MemberDTO;
import Main.DTO.PaymentDTO;
import Main.DTO.PcDTO;
import Main.DTO.SeatDTO;
import Main.Time_Test;

import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class PrivatePC extends JFrame implements WindowListener{
	// 날짜, 시간 관련 기본 import
	static Calendar cal = Calendar.getInstance();
	static SimpleDateFormat fomDateFormat = new SimpleDateFormat("hh:mm");

	// gui 관련
	private static final String String = null;
	private JFrame frame;
	private JPanel contentPane;
	private static JTextField txtNo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField yen_txt;
	private String member_id = null;
	private SeatDTO vo = null;
	private Time_Test time = null;
	private SelectDAO dao = null;
	private Date start_time; // 로그인 시간
	private Date stop_time; // 로그아웃 시간
	private Date date_re_time; // 잔여시간;
	public static int addPrice = 0;
	SelectDAO sdao = new SelectDAO();
	


	public void printTXT(String yen) {
		txtNo.setText(yen);
		yen_txt.setText(yen);
	}

	public JTextField setTxt(JTextField i) {
		this.yen_txt = i;
		return yen_txt;
	}

	public JTextField inputTxt() {
//		return txtNo.getText();
		return yen_txt;
	}

	/**
	 * Create the frame.
	 */
	
	public PrivatePC() {
		this.dao = dao;
		this.vo = vo;
//	    this.time = time;
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
//      contentPane.setBackground("C:\\sin.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button_1 = new JButton("\uC0AC\uC6A9\uC885\uB8CC");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UWannaFinish.main(null);
			}
		});

		JPanel back = new JPanel();
		back.setBackground(new Color(255, 255, 255));
		back.setBounds(0, 0, 1264, 761);
		contentPane.add(back);
		back.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uD734\uC9C0\uD1B5\uD1B51.png"));
		lblNewLabel_1.setBounds(23, 10, 102, 106);
		back.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC9C1\uBC15\uAD6C\uB9AC2.png"));
		lblNewLabel_3.setBounds(23, 124, 96, 98);
		back.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("\uD734\uC9C0\uD1B5");
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(28, 95, 65, 20);
		back.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("\uC9C1\uBC15\uAD6C\uB9AC");
		lblNewLabel_5.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(23, 221, 57, 15);
		back.add(lblNewLabel_5);

		JPanel sdfsfdsfe = new JPanel();
		sdfsfdsfe.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, null, Color.WHITE, null));
		sdfsfdsfe.setBackground(new Color(50, 85, 110));
		sdfsfdsfe.setBounds(873, 10, 379, 256);
		back.add(sdfsfdsfe);
		sdfsfdsfe.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(80, 120, 150));
		panel.setBounds(12, 12, 356, 145);
		sdfsfdsfe.add(panel);
		panel.setLayout(null);

		JButton button_2 = new JButton("\uD638\uCD9C");
		button_2.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "매니저를 호출중입니다 잠시만 기다려주세yo");
			}
		});
		button_2.setBounds(24, 99, 94, 36);
		panel.add(button_2);

		JLabel lblNewLabel = new JLabel("\uD604\uC7AC\uC2DC\uAC04");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 46, 92, 21);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("\uC794\uC5EC\uC2DC\uAC04");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(130, 77, 90, 21);
		panel.add(label);

		JLabel label_1 = new JLabel("\uC794\uC5EC\uAE08\uC561");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(130, 15, 90, 21);
		panel.add(label_1);

		txtNo = new JTextField();
		txtNo.setBackground(new Color(0, 0, 0));
		txtNo.setForeground(new Color(255, 204, 0));
		txtNo.setFont(new Font("Calibri", Font.BOLD, 27));
		txtNo.setHorizontalAlignment(SwingConstants.CENTER);
		inputTxt();
		txtNo.setText(Integer.toString(PcDTO.PcNumber));
		txtNo.setBounds(24, 15, 94, 74);
		panel.add(txtNo);
		txtNo.setColumns(10);

		textField = new JTextField();
		this.start_time = cal.getTime();
		textField.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		textField.setText(fomDateFormat.format(start_time));
//		textField.setText("3:34");
		textField.setBounds(220, 46, 101, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		textField_1.setText("00:35");
		textField_1.setColumns(10);
		textField_1.setBounds(220, 77, 101, 21);
		panel.add(textField_1);
		
//		date_re_time = vo.getRemainingTime(); // Error

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		textField_2.setText(Integer.toString(sdao.select_total(MemberDTO.MemberId)));
		textField_2.setColumns(10);
		textField_2.setBounds(220, 15, 101, 21);
		panel.add(textField_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 167, 356, 72);
		sdfsfdsfe.add(panel_1);

		JButton button = new JButton("\uAE08\uC561\uCDA9\uC804");
		button.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment2.main(null);
			}
		});
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		panel_1.add(button);

		JButton btnNewButton = new JButton("\uC74C\uC2DD\uC8FC\uBB38");
		btnNewButton.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleMain.main(null);
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC0AC\uC6A9\uC885\uB8CC");
		btnNewButton_1.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Date end = cal.getTime();            
//	            vo.setStopTime(end);
//				date_re_time= time.timeCalculate();
				UWannaFinish.main(null);
			}
		});
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(40, 60, 80));
		panel_2.setBounds(181, 495, 889, 256);
		back.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URL("http://pubg.game.daum.net/pubg/index.daum").toURI());
					} catch (MalformedURLException ex) {
						Logger.getLogger(PrivatePC.class.getName()).log(Level.SEVERE, null,ex);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
			});
		btnNewButton_3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\20190110124218.jpg"));
		btnNewButton_3.setBounds(0, 10, 540, 124);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\exp.jpg"));
		btnNewButton_4.setBounds(540, 135, 130, 130);
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("http://fifaonline4.nexon.com/main/index").toURI());
					} catch (MalformedURLException ex) {
						Logger.getLogger(PrivatePC.class.getName()).log(Level.SEVERE, null,ex);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\fifa.jpg"));
		btnNewButton_5.setBounds(541, 10, 348, 124);
		panel_2.add(btnNewButton_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\lol1.png"));
		lblNewLabel_6.setBounds(20, 138, 120, 120);
		panel_2.add(lblNewLabel_6);

		JLabel label_2 = new JLabel("");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\overwatch1111.jpg.png"));
		label_2.setBounds(150, 141, 120, 120);
		panel_2.add(label_2);

		JLabel label_4 = new JLabel("");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\sratc.png"));
		label_4.setBounds(410, 136, 120, 120);
		panel_2.add(label_4);

		JLabel lblNewLabel_7 = new JLabel("\uC778\uAE30\uAC8C\uC784");
		lblNewLabel_7.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(48, 219, 109, 30);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("\uC628\uB77C\uC778\uAC8C\uC784");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblNewLabel_8.setBounds(168, 218, 95, 31);
		panel_2.add(lblNewLabel_8);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\fifaa.png"));
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(280, 137, 120, 120);
		panel_2.add(label_3);
		
		JLabel label_5 = new JLabel("\uC2A4\uD3EC\uCE20\uAC8C\uC784");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("나눔고딕", Font.BOLD, 18));
		label_5.setBounds(297, 219, 95, 31);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(391, 136, 120, 120);
		panel_2.add(label_6);
		
		JLabel lblCd = new JLabel("CD\uAC8C\uC784");
		lblCd.setForeground(Color.WHITE);
		lblCd.setFont(new Font("나눔고딕", Font.BOLD, 18));
		lblCd.setBounds(439, 217, 95, 31);
		panel_2.add(lblCd);
		button.setOpaque(false);
		button.setContentAreaFilled(false);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\1111111111111111111.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1264, 761);
		back.add(lblNewLabel_4);
	}

	public String returnNum() {
		return txtNo.getText();
	}
	
	public int price() {
		return PaymentDTO.ChargeAmount;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}