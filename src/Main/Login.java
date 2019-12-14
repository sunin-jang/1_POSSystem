package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Main.DAO.InsertDAO;
import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.MemberDTO;
import Main.DTO.PcDTO;
import Main.DTO.SeatDTO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Login extends JFrame implements WindowListener {

	private static final String inputTXT = null;
	private JPanel contentPane;
	private static JTextField txtNo;
	private JTextField member_id;
	private JPasswordField member_pw;
	private static JTextField txt_seat = null;
	private static JComboBox txt_seat_1;
	static String num_cho = null;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		SelectDAO dao = new SelectDAO();
		SeatDTO vo = dao.selectmemberid_sDTO(inputTXT);
		Time_Test time = new Time_Test(dao, vo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(48, 46, 47));
		panel.setBounds(842, 551, 410, 200);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("<html>청소년은 22시이후출입이 불가합니다.<br>외부음식은 반입불가입니다.<html>");
		lblNewLabel_2.setBounds(0, 0, 420, 51);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_3 = new JLabel("\uC88C\uC11D\uBC88\uD638");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(99, 89, 72, 21);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.PLAIN, 14));

		JButton btn_join = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_join.setBounds(312, 156, 86, 23);
		panel.add(btn_join);
		btn_join.setFont(new Font("함초롬돋움", Font.PLAIN, 12));

		JButton btn_login = new JButton("\uC0AC\uC6A9\uC2DC\uC791");
		btn_login.setBounds(312, 123, 86, 23);
		panel.add(btn_login);
		btn_login.setFont(new Font("함초롬돋움", Font.PLAIN, 12));

		txt_seat_1 = new JComboBox();
		txt_seat_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27",
				"28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
				"45", "46", "47", "48", "49", "50" }));
		txt_seat_1.setBounds(183, 90, 116, 21);
		panel.add(txt_seat_1);

		member_pw = new JPasswordField();
		member_pw.setBounds(184, 157, 116, 21);
		panel.add(member_pw);

		member_id = new JTextField();
		member_id.setBounds(184, 124, 116, 21);
		panel.add(member_id);

		String inputTXT = member_id.getText();
		member_id.setColumns(10);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setBounds(110, 160, 57, 15);
		panel.add(label);
		label.setFont(new Font("함초롬돋움", Font.PLAIN, 14));

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(109, 129, 57, 15);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(12, 76, 166, 134);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\login2222.png"));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = member_id.getText();
				String pw = member_pw.getText();
				SelectDAO sdao = new SelectDAO();
				String name = sdao.select(id, pw);
				UpdateDAO udao = new UpdateDAO();
				MemberDTO.MemberId = id;
				int seat = Integer.parseInt(txt_seat_1.getSelectedItem().toString());

				boolean pcuse = sdao.seatselect(seat);

				PcDTO pcd = new PcDTO(seat, false, null);
				if (seat > 50) {
					JOptionPane.showMessageDialog(null, "좌석번호는 1번부터 50번까지입니다.");
					txt_seat.setText("");
				} else {
					if (pcuse == true) {
						JOptionPane.showMessageDialog(null, "이미 선택된 좌석입니다.");
						txt_seat.setText("");
					} else if (name == null) {
						JOptionPane.showMessageDialog(null, "로그인 실패");
						member_id.setText("");
						member_pw.setText("");
					} else {
						JOptionPane.showMessageDialog(null, name + "님 환영합니다.");
						boolean pc = udao.PcOn(seat);
						payment.main(null);
//						PrivatePC pc2 = new PrivatePC(dao, vo, time);
//						String inputTXT = txt_seat.getText();
//						pc2.printTXT(inputTXT);
//						pc2.setTitle(txt_seat.getText());
						dispose();
					}
				}
			}
		});
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Join1.main(null);
			}
		});

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(185, 39, 903, 569);
		contentPane.add(lblNewLabel);
		lblNewLabel
				.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uB300\uD53C\uB3C412.png"));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4
				.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\1111111111111111111.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1264, 761);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setBackground(Color.BLACK);

		String[] arr = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34",
				"35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49" };
	}

//	public static String setTxt_seat(String i) {
//		txt_seat_1.setText(i);
//		return i;
//	}

//	public static String getTxt_seat(String inputOUT) {
//		return inputOUT; // 다른곳에서 return 해주려고
//	}

	public static String getTxt_seat() {
		return num_cho; // 다른곳에서 return 해주려고
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
