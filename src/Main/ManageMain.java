package Main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import java.awt.Choice;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.table.DefaultTableModel;

import Main.DAO.UpdateDAO;
import Main.DTO.PcDTO;

import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
public class ManageMain implements WindowListener{
	Vector v;
	Vector cols;
	DefaultTableModel model;
	private JFrame frame;
	JTable table;
	JScrollPane pane;
	private JTable table_1;
	private JTextField txt_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMain window = new ManageMain();
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
	public ManageMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 982, 699);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 26, 942, 624);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		
		tabbedPane.addTab("매장관리", null, panel, null);
		tabbedPane.setTitleAt(0, "\uB9E4\uC7A5\uAD00\uB9AC");
		tabbedPane.add("<html><body><table width='120'><tr><td>매장관리</td></tr></table></body></html>", panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton button_8 = new JButton("New button");
		panel.add(button_8);
		
		JButton button_1 = new JButton("New button");
		panel.add(button_1);
		
		JButton button = new JButton("New button");
		panel.add(button);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton button_4 = new JButton("New button");
		panel.add(button_4);
		
		JButton button_3 = new JButton("New button");
		panel.add(button_3);
		
		JButton button_2 = new JButton("New button");
		panel.add(button_2);
		
		JButton button_9 = new JButton("New button");
		panel.add(button_9);
		
		JButton button_7 = new JButton("New button");
		panel.add(button_7);
		
		JButton button_6 = new JButton("New button");
		panel.add(button_6);
		
		JButton button_5 = new JButton("New button");
		panel.add(button_5);
		
		JButton button_10 = new JButton("New button");
		panel.add(button_10);
		
		JButton button_11 = new JButton("New button");
		panel.add(button_11);
		
		JButton button_12 = new JButton("New button");
		panel.add(button_12);
		
		JButton button_16 = new JButton("New button");
		panel.add(button_16);
		
		JButton button_15 = new JButton("New button");
		panel.add(button_15);
		
		JButton button_14 = new JButton("New button");
		panel.add(button_14);
		
		JButton button_13 = new JButton("New button");
		panel.add(button_13);
		
		JButton button_17 = new JButton("New button");
		panel.add(button_17);
		
		JButton button_18 = new JButton("New button");
		panel.add(button_18);
		
		JButton button_19 = new JButton("New button");
		panel.add(button_19);
		
		JButton button_23 = new JButton("New button");
		panel.add(button_23);
		
		JButton button_22 = new JButton("New button");
		panel.add(button_22);
		
		JButton button_21 = new JButton("New button");
		panel.add(button_21);
		
		JButton button_20 = new JButton("New button");
		panel.add(button_20);
		
		JButton button_24 = new JButton("New button");
		panel.add(button_24);
		
		JButton button_25 = new JButton("New button");
		panel.add(button_25);
		
		JButton button_26 = new JButton("New button");
		panel.add(button_26);
		
		JButton button_30 = new JButton("New button");
		panel.add(button_30);
		
		JButton button_29 = new JButton("New button");
		panel.add(button_29);
		
		JButton button_28 = new JButton("New button");
		panel.add(button_28);
		
		JButton button_27 = new JButton("New button");
		panel.add(button_27);
		
		JButton button_31 = new JButton("New button");
		panel.add(button_31);
		
		JButton button_32 = new JButton("New button");
		panel.add(button_32);
		
		JButton button_33 = new JButton("New button");
		panel.add(button_33);
		
		JButton button_37 = new JButton("New button");
		panel.add(button_37);
		
		JButton button_36 = new JButton("New button");
		panel.add(button_36);
		
		JButton button_35 = new JButton("New button");
		panel.add(button_35);
		
		JButton button_34 = new JButton("New button");
		panel.add(button_34);
		
		JButton button_38 = new JButton("New button");
		panel.add(button_38);
		
		JButton button_39 = new JButton("New button");
		panel.add(button_39);
		
		JButton button_40 = new JButton("New button");
		panel.add(button_40);
		
		JButton button_44 = new JButton("New button");
		panel.add(button_44);
		
		JButton button_43 = new JButton("New button");
		panel.add(button_43);
		
		JButton button_42 = new JButton("New button");
		panel.add(button_42);
		
		JButton button_41 = new JButton("New button");
		panel.add(button_41);
		
		JButton button_45 = new JButton("New button");
		panel.add(button_45);
		
		JButton button_46 = new JButton("New button");
		panel.add(button_46);
		
		JButton button_47 = new JButton("New button");
		panel.add(button_47);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("매출", null, panel_3, null);
		tabbedPane.add("<html><body><table width='120'><tr><td>매출</td></tr></table></body></html>", panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, "name_461113599412100");
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 135, 730, 440);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"주문시간", "pc번호", "주문내역", "추가할것"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(145, 64, 730, 61);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		String[] year1 = {"2015","2016","2017","2018","2019"};
		JComboBox year = new JComboBox(year1);
		year.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		year.setBounds(107, 19, 86, 21);
		panel_6.add(year);
		
		JButton btnNewButton_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_1.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(year.getSelectedItem());
			}
		});
		btnNewButton_1.setBounds(641, 14, 77, 32);
		panel_6.add(btnNewButton_1);
		
		JLabel label_30 = new JLabel("\uB0A0\uC9DC\uAC80\uC0C9");
		label_30.setFont(new Font("함초롬돋움", Font.PLAIN, 18));
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(-11, 2, 125, 50);
		panel_6.add(label_30);
		
		
		
		
		String[] month1 = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		JComboBox month = new JComboBox(month1);
		month.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		month.setBounds(205, 19, 59, 21);
		panel_6.add(month);
		
		String[] day1 = {"1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15","16","17","18","19","20"
				,"21","22","23","24","25","26","27","28","29","30","31"};
		JComboBox day = new JComboBox(day1);
		day.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		day.setBounds(276, 19, 59, 21);
		panel_6.add(day);
		
		JComboBox comboBox_3 = new JComboBox(day1);
		comboBox_3.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		comboBox_3.setBounds(552, 20, 59, 21);
		panel_6.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox(month1);
		comboBox_4.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		comboBox_4.setBounds(481, 20, 59, 21);
		panel_6.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox(year1);
		comboBox_5.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		comboBox_5.setBounds(383, 20, 86, 21);
		panel_6.add(comboBox_5);
		
		JLabel label_31 = new JLabel("~");
		label_31.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		label_31.setBounds(358, 7, 33, 44);
		panel_6.add(label_31);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(30, 50, 100));
		panel_8.setBounds(0, 0, 937, 54);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB9E4\uCD9C\uAD00\uB9AC");
		lblNewLabel.setBounds(12, 10, 161, 31);
		lblNewLabel.setForeground(new Color(240, 255, 240));
		panel_8.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("회원관리", null, panel_1, null);
		tabbedPane.add("<html><body><table width='120'><tr><td>회원관리</td></tr></table></body></html>", panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(0, 0, 937, 585);
		panel_1.add(panel_9);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(145, 135, 730, 440);
		panel_9.add(scrollPane_1);
		
		table_1 = new JTable();
		// 1. 디비접속해서 찾는 회원정보를 가져와서 그 수만큼 ArrayList로 가져오고
//		 ArrayList<회원정보> a1 = dao.selectAll // 같은 함수로 모든 회원을 가져오기 > 나중에 맞나 확인할예정
		 										//확인
		
		// 2. ArrayList를 Object 2차원 배열로 변경
//		Object[][] obj = new Object[a1.size()][4];
//		
//		for (int i = 0; i < a1.length; i++) {
//			회원정보 vo = a1.get(i);
//			obj = new Object { vo.getCo1(), vo.getCol2() , vo.getCol3() , vo.getCol4() };
//		}
		
		// 3. setModel을 진행
		
 		table_1.setModel(new DefaultTableModel(
 			new Object[][] {
 			},
 			new String[] {
 				"\uC774\uB984", "\uC5F0\uB77D\uCC98", "\uC544\uC774\uB514", "\uCD94\uAC00\uD560\uAC83"
 			}
 		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(145, 64, 730, 61);
		panel_9.add(panel_10);
		
		JButton button_48 = new JButton("\uAC80\uC0C9");
//		button_48.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DAO dao = new DAO();
//				v = dao.MemberList();
//				cols = getColumn();
//				model = new DefaultTableModel(v, cols);
//				
//				table = new JTable(model);
//				pane = new JScrollPane(table);
//				add(pane);
//				
//				table.addMouseListener(this);
//				String name = txt_name.getText();
//				
//			}
//		});
		button_48.setBounds(390, 10, 86, 39);
		panel_10.add(button_48);
		
		JLabel label_32 = new JLabel("\uD68C\uC6D0\uAC80\uC0C9");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setFont(new Font("굴림", Font.PLAIN, 18));
		label_32.setBounds(0, 2, 125, 50);
		panel_10.add(label_32);
		
		txt_name = new JTextField();
		txt_name.setBounds(125, 5, 253, 50);
		panel_10.add(txt_name);
		txt_name.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(new Color(30, 50, 100));
		panel_11.setBounds(0, 0, 937, 54);
		panel_9.add(panel_11);
		
		JLabel label_34 = new JLabel("\uD68C\uC6D0\uAD00\uB9AC");
		label_34.setHorizontalAlignment(SwingConstants.LEFT);
		label_34.setForeground(new Color(240, 255, 240));
		label_34.setFont(new Font("굴림", Font.BOLD, 18));
		label_34.setBackground(new Color(30, 144, 255));
		label_34.setBounds(12, 10, 161, 31);
		panel_11.add(label_34);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("회원관리", null, panel_2, null);
		tabbedPane.add("<html><body><table width='120'><tr><td>재고관리</td></tr></table></body></html>", panel_2);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("추가할것", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(3, 0, 133, 117);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(136, 0, 133, 117);
		panel_4.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(269, 0, 133, 117);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(402, 0, 133, 117);
		panel_4.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(535, 0, 133, 117);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(668, 0, 133, 117);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(801, 0, 133, 117);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setBounds(3, 117, 133, 117);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(136, 117, 133, 117);
		panel_4.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(269, 117, 133, 117);
		panel_4.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(402, 117, 133, 117);
		panel_4.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(535, 117, 133, 117);
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(668, 117, 133, 117);
		panel_4.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(801, 117, 133, 117);
		panel_4.add(label_13);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(3, 234, 133, 117);
		panel_4.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(136, 234, 133, 117);
		panel_4.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(269, 234, 133, 117);
		panel_4.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(402, 234, 133, 117);
		panel_4.add(label_17);
		
		JLabel label_18 = new JLabel("");
		label_18.setBounds(535, 234, 133, 117);
		panel_4.add(label_18);
		
		JLabel label_19 = new JLabel("");
		label_19.setBounds(668, 234, 133, 117);
		panel_4.add(label_19);
		
		JLabel label_20 = new JLabel("");
		label_20.setBounds(801, 234, 133, 117);
		panel_4.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setBounds(3, 351, 133, 117);
		panel_4.add(label_21);
		
		JLabel label_22 = new JLabel("");
		label_22.setBounds(136, 351, 133, 117);
		panel_4.add(label_22);
		
		JLabel label_23 = new JLabel("");
		label_23.setBounds(269, 351, 133, 117);
		panel_4.add(label_23);
		
		JLabel label_24 = new JLabel("");
		label_24.setBounds(402, 351, 133, 117);
		panel_4.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setBounds(535, 351, 133, 117);
		panel_4.add(label_25);
		
		JLabel label_26 = new JLabel("");
		label_26.setBounds(668, 351, 133, 117);
		panel_4.add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setBounds(801, 351, 133, 117);
		panel_4.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setBounds(3, 468, 133, 117);
		panel_4.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setBounds(136, 468, 133, 117);
		panel_4.add(label_29);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 58, 942, 49);
		frame.getContentPane().add(panel_7);
	}

	public Vector getColumn() {
		// TODO Auto-generated method stub
		Vector col = new Vector();
		col.add("아이디");
		col.add("이름");
		col.add("전화번호");
		
		return col;
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
