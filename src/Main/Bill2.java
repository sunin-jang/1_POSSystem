package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.MemberDTO;
import Main.DTO.PaymentDTO;
import Main.DTO.PcDTO;
import Main.DTO.SeatDTO;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class Bill2 implements WindowListener {

	private JFrame frame;
	private JTextField txt_count;
	private JTextField cardnumber;
	private static final String inputTXT = null;
	SelectDAO sdao = new SelectDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill2 window = new Bill2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bill2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		SelectDAO dao = new SelectDAO();
		SeatDTO vo = dao.selectmemberid_sDTO(inputTXT);
		Time_Test time = new Time_Test(dao, vo);
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 310, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("\uC601\uC218\uC99D");
		lblNewLabel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 0, 197, 51);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uC0C1\uD488\uBA85");
		label.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label.setBounds(22, 140, 86, 33);
		frame.getContentPane().add(label);

		JLabel label_3 = new JLabel("\uCE74\uB4DC\uBC88\uD638");
		label_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_3.setBounds(22, 266, 86, 33);
		frame.getContentPane().add(label_3);

		txt_count = new JTextField();
		txt_count.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_count.setText(Integer.toString(PaymentDTO.ChargeAmount));
		txt_count.setBounds(164, 180, 86, 21);
		txt_count.setBorder(null);
		frame.getContentPane().add(txt_count);
		txt_count.setColumns(10);

		cardnumber = new JTextField();
		cardnumber.setText(PaymentDTO.CardNumber);
		cardnumber.setColumns(10);
		cardnumber.setBounds(120, 273, 116, 21);
		cardnumber.setBorder(null);
		frame.getContentPane().add(cardnumber);

		JLabel lblNewLabel_2 = new JLabel(
				"<html>\uADFC\uB9CC\uC131\uC2E4 PC\uBC29 <br>\uAD11\uC8FC\uAD11\uC5ED\uC2DC \uC11C\uAD6C \uCC9C\uBCC0\uC88C\uB85C 268 <br>KDB\uC0DD\uBA85\uBCF4\uD5D8(\uC8FC) 23\uCE35<br> 2019-07-29     12:50:01 <html>");
		lblNewLabel_2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(22, 61, 283, 63);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel label_4 = new JLabel("\uCE74\uB4DC\uAD6C\uBD84");
		label_4.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_4.setBounds(22, 320, 57, 15);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\uC815\uC0C1\uC2B9\uC778\uAC70\uB798");
		label_5.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_5.setBounds(22, 335, 93, 33);
		frame.getContentPane().add(label_5);

		JLabel lblNewLabel_3 = new JLabel("======================================");
		lblNewLabel_3.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(12, 163, 349, 15);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel label_6 = new JLabel("======================================");
		label_6.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_6.setBounds(12, 134, 349, 15);
		frame.getContentPane().add(label_6);

		JLabel lblNewLabel_4 = new JLabel("--------------------------------------------");
		lblNewLabel_4.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(12, 43, 349, 21);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel label_1 = new JLabel("\uC2B9\uC778\uBC88\uD638");
		label_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_1.setBounds(22, 295, 57, 15);
		frame.getContentPane().add(label_1);

		JLabel lblNewLabel_6 = new JLabel("30001359");
		lblNewLabel_6.setBounds(120, 285, 160, 42);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel label_7 = new JLabel("\uAE08\uC561");
		label_7.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		label_7.setBounds(219, 140, 86, 33);
		frame.getContentPane().add(label_7);

		JLabel lblNewLabel_1 = new JLabel("--------------------------------------------");
		lblNewLabel_1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(12, 239, 311, 17);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblpc = new JLabel("\uADFC\uB9CCPC \uC2DC\uAC04\uCDA9\uC804");
		lblpc.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblpc.setBounds(22, 183, 120, 15);
		frame.getContentPane().add(lblpc);

		JLabel lblNewLabel_7 = new JLabel("======================================");
		lblNewLabel_7.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(12, 364, 268, 21);
		frame.getContentPane().add(lblNewLabel_7);

		JTextField txt_card = new JTextField("\uADFC\uB9CC\uCE74\uB4DC");
		txt_card.setBounds(120, 321, 57, 15);
		frame.getContentPane().add(txt_card);
		txt_card.setBorder(null);

		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentDTO.ChargeAmount = sdao.select_total(MemberDTO.MemberId);
				PrivatePC pc2 = new PrivatePC();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(92, 396, 97, 23);
		frame.getContentPane().add(btnNewButton);

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
		PaymentDTO.ChargeAmount = Integer.parseInt(txt_count.getText());
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