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

import javax.swing.ImageIcon;

public class Join1 extends JFrame implements WindowListener{

	private JPanel contentPane;
	private JTextField member_name;
	private JTextField member_id;
	private JTextField member_pww;
	private JTextField member_phonenumber;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JPasswordField member_pw;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join1 frame = new Join1();
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
	public Join1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_confrim = new JButton("\uD655\uC778");
		btn_confrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = member_id.getText();
				String pw = member_pw.getText();
				String pww = member_pww.getText();
				String name = member_name.getText();
				String phonenumber = member_phonenumber.getText();
				if (!pw.equals(pww)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
					member_pw.setText("");
					member_pww.setText("");
				} else {
					MemberDTO m = new MemberDTO(id,pw,name,phonenumber);
					InsertDAO idao = new InsertDAO();
					int result = idao.insert_member(m);
					if (result == 0) {
						JOptionPane.showMessageDialog(null, "회원가입 실패");
					} else {
						JOptionPane.showMessageDialog(null, "회원가입 성공");
						dispose();
					}
				}
			}
		});
		btn_confrim.setBounds(113, 316, 74, 23);
		contentPane.add(btn_confrim);
		
		member_name = new JTextField();
		member_name.setBounds(113, 143, 160, 21);
		contentPane.add(member_name);
		member_name.setColumns(10);
		
		member_id = new JTextField();
		member_id.setBounds(113, 174, 160, 21);
		contentPane.add(member_id);
		member_id.setColumns(10);
		
		member_phonenumber = new JTextField();
		member_phonenumber.setColumns(10);
		member_phonenumber.setBounds(113, 267, 160, 21);
		contentPane.add(member_phonenumber);
		
		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 143, 89, 15);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("\uC544\uC774\uB514 ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label.setBounds(12, 174, 96, 15);
		contentPane.add(label);
		
		label_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label_1.setBounds(12, 199, 89, 27);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778 ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label_2.setBounds(12, 236, 96, 15);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\uC5F0\uB77D\uCC98");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		label_3.setBounds(12, 267, 89, 15);
		contentPane.add(label_3);
		
		member_pww = new JPasswordField();
		member_pww.setColumns(10);
		member_pww.setBounds(113, 236, 160, 21);
		contentPane.add(member_pww);
		
		member_pw = new JPasswordField();
		member_pw.setBounds(113, 203, 160, 23);
		contentPane.add(member_pw);
		
		JButton btn_cancel = new JButton("\uCDE8\uC18C");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_cancel.setBounds(199, 316, 74, 23);
		contentPane.add(btn_cancel);
		
		JButton btn_confrim2 = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_confrim2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = member_id.getText();
				SelectDAO dao = new SelectDAO();
				String confirm_id = dao.idconfirm(id);
				
				if (id.equals(confirm_id)) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
					member_id.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "사용할 수 있는 아이디입니다.");
				}
			}
		});
		btn_confrim2.setBounds(285, 173, 90, 23);
		contentPane.add(btn_confrim2);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 24, 368, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel.setBounds(74, 28, 220, 47);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(43, 10, 90, 90);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\idpw111.png"));
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
