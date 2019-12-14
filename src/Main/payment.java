package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Main.DAO.InsertDAO;
import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.MemberDTO;
import Main.DTO.PaymentDTO;
import Main.DTO.PcDTO;
import Main.DTO.SeatDTO;

public class payment extends JFrame implements WindowListener{

	private static JTextField txtNo; // pc 번호 받으려고

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public payment() {
		String[] arr = {"  ","롯데카드", "삼성카드", "NH농협", "신한카드", "근만카드"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, Color.BLACK, null));
		panel_2.setBounds(23, 76, 342, 411);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC694\uAE08\uCDA9\uC804");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 33, 155, 33);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 22));

		JLabel label = new JLabel("\uAE08\uC561");
		label.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label.setBounds(48, 157, 72, 15);
		panel_2.add(label);

		JLabel label_1 = new JLabel("\uCE74\uB4DC\uC0AC \uC120\uD0DD");
		label_1.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label_1.setBounds(22, 205, 72, 15);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_2.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label_2.setBounds(23, 250, 72, 15);
		panel_2.add(label_2);

		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.setFont(new Font("함초롬돋움", Font.PLAIN, 12));

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		JComboBox cmd_card = new JComboBox(arr);
		cmd_card.setBounds(100, 199, 182, 21);
		panel_2.add(cmd_card);
		
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(100, 155, 182, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 247, 182, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\uC644\uB8CC");
		button.setBounds(96, 290, 90, 23);
		panel_2.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertDAO idao = new InsertDAO();

				SelectDAO dao = null; // privatePc 랑 연결하기 위한 선언
				SeatDTO vo = null;
				Time_Test time = null;

//				PrivatePC pc2 = new PrivatePC(dao, vo, time);
//				String pcnum = pc2.returnNum();

				int chargeamount = Integer.parseInt(textField.getText());
				String cardnumber = textField_1.getText();
				String memberid = MemberDTO.MemberId;
				//////////////////////////////

//				String pcNum = pc2.printTXT(inputTXT);

				// pcNum = login 때 입력값이 넘어옴

				PaymentDTO pay = new PaymentDTO(cardnumber, memberid, chargeamount);
				
				int result = idao.insert_payment(pay);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "충전 실패");

				} else {
					JOptionPane.showMessageDialog(null, "충전 성공");
					PaymentDTO p = new PaymentDTO();
					p.setChargeAmount(chargeamount);
					Bill.main(null);
					dispose();
				}
			}
		});
		button.setFont(new Font("함초롬돋움", Font.PLAIN, 12));

		button_1.setBounds(198, 290, 84, 23);
		panel_2.add(button_1);

		

		
		

		PaymentDTO.CardName = cmd_card.getSelectedItem().toString();
//		txt_cardNum = new JTextField();
//		txt_cardNum.setBackground(new Color(224, 255, 255));
//		txt_cardNum.setBounds(97, 246, 185, 21);
//		panel_2.add(txt_cardNum);
//		txt_cardNum.setColumns(10);
//		JComboBox comboBox = new JComboBox(arr);
//		comboBox.setBounds(99, 202, 182, 21);
//		panel_2.add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("\uC0C1\uD488\uBA85 : \uADFC\uB9CC\uC131\uC2E4 PC\uBC29");
		lblNewLabel_1.setBounds(22, 104, 291, 33);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel(" *1\uC2DC\uAC04\uC5D0 4\uB538\uB77C \uC785\uB2C8\uB2E4.");
		lblNewLabel_2.setBounds(22, 323, 296, 75);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\paymentIcon.png"));
		lblNewLabel_5.setBounds(12, 10, 90, 83);
		panel_2.add(lblNewLabel_5);

		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(30, 50, 100));
		panel.setBounds(0, 0, 383, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("\uADFC\uB9CC\uD398\uC774 \uACB0\uC81C\uC11C\uBE44\uC2A4");
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 19));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 5, 383, 40);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(30, 50, 100));
		panel_1.setBounds(0, 528, 383, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("\uBBFF\uC74C\uACFC \uC2E0\uB8B0\uC758 \uADFC\uB9CC\uD398\uC774");
		lblNewLabel_4.setBounds(0, 0, 382, 33);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("함초롬돋움", Font.BOLD, 18));

		

		String[] arr1 = { "근만", "지성", "예은", "인장" };
	}

	public static String getTxt_seat(String inputOUT) {
		return inputOUT; // 다른곳에서 return 해주려고
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
