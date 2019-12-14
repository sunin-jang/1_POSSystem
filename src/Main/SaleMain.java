package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Main.DAO.InsertDAO;
import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.MemberDTO;
import Main.DTO.OrderDTO;
import Main.DTO.OrderManagementDTO;
import Main.DTO.PaymentDTO;
import Main.DTO.PcDTO;
import Main.DTO.ProductDTO;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.BevelBorder;

public class SaleMain extends JFrame implements WindowListener{
	int count = 0;
	int price = 0;
	int totalprice = 0;
	
	SelectDAO sdao = new SelectDAO();
	UpdateDAO udao = new UpdateDAO();
	InsertDAO idao = new InsertDAO();
	ArrayList<OrderManagementDTO> order = new ArrayList<OrderManagementDTO>();
	java.util.Date utilDate = new java.util.Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	private JFrame frame;
	private JTable table;
	private JTextField txtData;
	private JButton drink1;
	
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleMain frame = new SaleMain();
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
	public SaleMain() {
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 579);
		getContentPane().setLayout(null);

		JScrollPane foodtab = new JScrollPane();
		foodtab.setBounds(424, 89, 422, 326);
		getContentPane().add(foodtab);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("함초롬돋움", Font.PLAIN, 12));

		foodtab.setViewportView(tabbedPane);

		JPanel cup = new JPanel();
		tabbedPane.addTab("\uCEF5\uB77C\uBA74", null, cup, null);
		tabbedPane.add("<html><body><table width='60'><tr><td>컵라면</td></tr></table></body></html>", cup);
		txtData = new JTextField();
		JButton cup1 = new JButton("");
		cup1.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup1.setBounds(0, 1, 133, 120);
		cup1.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uB108\uAD6C\uB9AC.jpg"));
		cup1.setBackground(Color.WHITE);
		cup1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "너구리"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup.setLayout(null);
		cup.add(cup1);

		JButton cup2 = new JButton("");
		cup2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "참깨라면"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
				
			}
		});
		cup2.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup2.setBackground(new Color(255, 255, 255));
		cup2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uCC38\uAE681.jpg"));
		cup2.setBounds(133, 1, 133, 120);
		cup.add(cup2);

		JButton cup3 = new JButton("");
		cup3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "새우탕"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup3.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC0C8\uC6B0\uD0D5.jpg"));
		cup3.setBackground(new Color(255, 255, 255));
		cup3.setBounds(266, 1, 133, 120);
		cup.add(cup3);

		JButton cup4 = new JButton("");
		cup4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "신라면"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup4.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup4.setBackground(new Color(255, 255, 255));
		cup4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\sin.jpg"));
		cup4.setBounds(0, 121, 133, 120);
		cup.add(cup4);

		JButton cup5 = new JButton("");
		cup5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prd_name = "왕뚜껑"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup5.setBackground(Color.RED);
		cup5.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC655\uB69C\uAED1.jpg"));
		cup5.setBounds(133, 121, 133, 120);
		cup.add(cup5);

		JButton cup6 = new JButton("");
		cup6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "진라면"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup6.setBackground(Color.WHITE);
		cup6.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC9C4222.jpg"));
		cup6.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup6.setBounds(266, 121, 133, 120);
		cup.add(cup6);

		JButton cup7 = new JButton("");
		cup7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "튀김우동"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup7.setBackground(Color.WHITE);
		cup7.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uD280\uAE40\uC6B0\uB3D9.jpg"));
		cup7.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup7.setBounds(0, 241, 133, 120);
		cup.add(cup7);

		JButton cup8 = new JButton("");
		cup8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "짜파게티"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup8.setBackground(Color.WHITE);
		cup8.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC9DC\uD30C.jpg"));
		cup8.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup8.setBounds(133, 241, 133, 120);
		cup.add(cup8);

		JButton cup9 = new JButton("");
		cup9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "육개장"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		cup9.setBackground(Color.WHITE);
		cup9.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		cup9.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC721\uAC1C\uC7A5.jpg"));
		cup9.setBounds(266, 241, 133, 120);
		cup.add(cup9);

		JPanel drink = new JPanel();
		tabbedPane.addTab("\uC74C\uB8CC", null, drink, null);
		tabbedPane.add("<html><body><table width='60'><tr><td>음료</td></tr></table></body></html>", drink);
		drink.setLayout(null);

		drink1 = new JButton("");
		drink1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "사이다"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink1.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC0AC\uC774\uB2E4.jpg"));
		drink1.setBounds(0, 0, 133, 120);
		drink.add(drink1);

		JButton drink2 = new JButton("");
		drink2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "포카리"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\po.jpg"));
		drink2.setBounds(133, 0, 133, 120);
		drink.add(drink2);

		JButton drink3 = new JButton("");
		drink3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "웰치스"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\wel.jpg"));
		drink3.setBounds(265, 0, 133, 120);
		drink.add(drink3);

		JButton drink4 = new JButton("");
		drink4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "코카콜라"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\co.jpg"));
		drink4.setBounds(0, 120, 133, 120);
		drink.add(drink4);

		JButton drink5 = new JButton("");
		drink5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "핫식스"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\hot.jpg"));
		drink5.setBounds(133, 120, 133, 120);
		drink.add(drink5);

		JButton drink6 = new JButton("");
		drink6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "밀키스"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink6.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\milk.jpg"));
		drink6.setBounds(265, 120, 133, 120);
		drink.add(drink6);

		JButton drink7 = new JButton("");
		drink7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "마운틴듀"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink7.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uB9C8\uC6B4\uD2F4\uB4C0.jpg"));
		drink7.setBounds(0, 238, 133, 120);
		drink.add(drink7);

		JButton drink8 = new JButton("");
		drink8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "코코팜"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink8.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\cococ.jpg"));
		drink8.setBounds(133, 238, 133, 120);
		drink.add(drink8);

		JButton drink9 = new JButton("");
		drink9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "환타"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		drink9.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\fan.jpg"));
		drink9.setBounds(265, 238, 133, 120);
		drink.add(drink9);

		JPanel snack = new JPanel();
		tabbedPane.addTab("\uC2A4\uB0B5", null, snack, null);
		tabbedPane.add("<html><body><table width='60'><tr><td>스넥</td></tr></table></body></html>", snack);
		snack.setLayout(null);

		JButton snack1 = new JButton("");
		snack1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "콘칩"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack1.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\conn.jpg"));
		snack1.setBounds(1, 1, 132, 120);
		snack1.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack1);

		JButton snack2 = new JButton("");
		snack2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "꿀꽈배기"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\GGul.jpg"));
		snack2.setBounds(133, 1, 132, 120);
		snack2.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack2);

		JButton snack3 = new JButton("");
		snack3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "오징어집"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\o.jpg"));
		snack3.setBounds(265, 1, 132, 120);
		snack3.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack3);

		JButton snack4 = new JButton("");
		snack4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\poka.jpg"));
		snack4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "포카칩"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack4.setBounds(1, 121, 132, 120);
		snack4.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack4);

		JButton snack5 = new JButton("");
		snack5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "포스틱"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\post.jpg"));
		snack5.setBounds(133, 121, 132, 120);
		snack5.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack5);

		JButton snack6 = new JButton("");
		snack6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "사또밥"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack6.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\sato.jpg"));
		snack6.setBounds(265, 121, 132, 120);
		snack6.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack6);

		JButton snack7 = new JButton("");
		snack7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "새우깡"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack7.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\t\uC0C8\uC6B0\uAE61.jpg"));
		snack7.setBounds(1, 241, 132, 120);
		snack7.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack7);

		JButton snack8 = new JButton("");
		snack8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "썬칩"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack8.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\sunt.jpg"));
		snack8.setBounds(133, 241, 132, 120);
		snack8.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack8);

		JButton snack9 = new JButton("");
		snack9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "벌집핏짜"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		snack9.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\pizza.jpg"));
		snack9.setBounds(265, 241, 132, 120);
		snack9.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		snack.add(snack9);

		JPanel ice = new JPanel();
		tabbedPane.addTab("냉동식품", null, ice, null);
		tabbedPane.add("<html><body><table width='60'><tr><td>냉동식품</td></tr></table></body></html>", ice);
		ice.setLayout(null);

		JButton ice1 = new JButton("");
		ice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "햄버거"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice1.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\bug.jpg"));
		ice1.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice1.setBackground(Color.WHITE);
		ice1.setBounds(0, 0, 133, 120);
		ice.add(ice1);

		JButton ice2 = new JButton("");
		ice2.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uCE58\uC988.jpg"));
		ice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prd_name = "치즈스틱"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice2.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice2.setBackground(Color.WHITE);
		ice2.setBounds(133, 0, 133, 120);
		ice.add(ice2);

		JButton ice3 = new JButton("");
		ice3.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\pizzaaa.jpg"));
		ice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "스틱피자"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice3.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice3.setBackground(Color.WHITE);
		ice3.setBounds(266, 0, 133, 120);
		ice.add(ice3);

		JButton ice4 = new JButton("");
		ice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "새우튀김"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice4.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC0C8\uC6B0\uD280\uAE40.jpg"));
		ice4.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice4.setBackground(Color.WHITE);
		ice4.setBounds(0, 120, 133, 120);
		ice.add(ice4);

		JButton ice5 = new JButton("");
		ice5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "찐만두"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice5.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\man.jpg"));
		ice5.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice5.setBackground(Color.WHITE);
		ice5.setBounds(133, 120, 133, 120);
		ice.add(ice5);

		JButton ice6 = new JButton("");
		ice6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "소떡소떡"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice6.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\\uC18C\uB5A1.jpg"));
		ice6.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice6.setBackground(Color.WHITE);
		ice6.setBounds(266, 120, 133, 120);
		ice.add(ice6);

		JButton ice7 = new JButton("");
		ice7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "핫도그"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice7.setIcon(new ImageIcon("C:\\WebWork\\1_POSSystem\\src\\picture\\hotdog.jpg"));
		ice7.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice7.setBackground(Color.WHITE);
		ice7.setBounds(0, 232, 133, 120);
		ice.add(ice7);

		JButton ice8 = new JButton("");
		ice8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "크림우동"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice8.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice8.setBackground(Color.WHITE);
		ice8.setBounds(133, 232, 133, 120);
		ice.add(ice8);

		JButton ice9 = new JButton("");
		ice9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prd_name = "새우볶음밥"; // 상품이름
				int quantity = sdao.select_quantity(prd_name); // 상품수량
				count++;
				int row = udao.quantity_update(quantity, count, prd_name);
				price = sdao.select_price(prd_name); // 상품가격
				totalprice += price;
				OrderDTO o = new OrderDTO(PcDTO.PcNumber, MemberDTO.MemberId, prd_name, PaymentDTO.CardNumber,(java.sql.Date) sqlDate,price);
				idao.insert_order(o);
				OrderManagementDTO om = new OrderManagementDTO(prd_name, price, quantity);
				int result = idao.insert_order(o);
				order.add(new OrderManagementDTO(prd_name,price,1));
				Vector<String> voTest = new Vector();
				voTest.add(order.get(0).getProductName());
				voTest.add(order.get(0).getProductQuantity()+"");
				voTest.add(order.get(0).getProductPrice()+"");
				model.addRow(voTest);
				txtData.setText(totalprice+"");
			}
		});
		ice9.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		ice9.setBackground(Color.WHITE);
		ice9.setBounds(266, 232, 133, 120);
		ice.add(ice9);

		JScrollPane etc = new JScrollPane();
		tabbedPane.addTab("...", null, etc, null);

		JPanel 야이 = new JPanel();
		etc.setViewportView(야이);
		야이.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_2);
		btnNewButton_2.setPreferredSize(new Dimension(0, 0));

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_3);
		btnNewButton_3.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_4);
		btnNewButton_4.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_13);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_5);
		btnNewButton_5.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_6);
		btnNewButton_6.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_7);
		btnNewButton_7.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_8);
		btnNewButton_8.setPreferredSize(new Dimension(120, 120));

		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		야이.add(btnNewButton_9);
		btnNewButton_9.setPreferredSize(new Dimension(120, 120));

		JPanel amount = new JPanel();
		amount.setBackground(Color.WHITE);
		amount.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, Color.BLACK, null));
		amount.setBounds(10, 391, 392, 58);
		getContentPane().add(amount);
		amount.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\uCD1D\uC561  :");
		lblNewLabel_1.setBounds(0, 0, 137, 58);
		amount.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		txtData.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		txtData.setHorizontalAlignment(SwingConstants.RIGHT);
//		Qty q = new Qty(txtData);
//		int data = q.out_price();
//		txtData.setText(Integer.toString(data));

		txtData.setBounds(128, 20, 170, 25);
		amount.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\uC6D0");
		lblNewLabel_2.setFont(new Font("함초롬돋움", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(323, 20, 57, 18);
		amount.add(lblNewLabel_2);

		JPanel selectpay = new JPanel();
		selectpay.setBounds(424, 425, 422, 58);
		getContentPane().add(selectpay);
		selectpay.setLayout(new GridLayout(1, 0, 0, 0));

		

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(30,50, 100));
		topPanel.setBounds(0, 0, 871, 70);
		getContentPane().add(topPanel);
		SpringLayout sl_topPanel = new SpringLayout();
		topPanel.setLayout(sl_topPanel);

		JLabel lblNewLabel = new JLabel("\uADFC\uB9CC\uC131\uC2E4pc\uBC29");
		lblNewLabel.setForeground(Color.WHITE);
		sl_topPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 681, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 60, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -38, SpringLayout.EAST, topPanel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		topPanel.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("\uC74C\uC2DD\uC8FC\uBB38");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		sl_topPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 0, SpringLayout.NORTH, lblNewLabel);
		sl_topPanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 20, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_topPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 259, SpringLayout.WEST, topPanel);
		topPanel.add(lblNewLabel_3);

		JPanel foodlist = new JPanel();
		foodlist.setBackground(Color.WHITE);
		foodlist.setBounds(10, 89, 392, 295);
		getContentPane().add(foodlist);
		foodlist.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 392, 295);
		foodlist.add(scrollPane);
		String[] columnNames = { "상품", "수량", "금액" };
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);

		scrollPane.setViewportView(table);
		setVisible(true);
		
		JButton btn_cancel = new JButton("\uC120\uD0DD\uCDE8\uC18C");
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row<0) return;
				int col = table.getSelectedColumn();
				Object value = table.getValueAt(row, col);
				int prd_price = sdao.select_price((String) value);
				model.removeRow(row);
				totalprice -= prd_price;
				txtData.setText(totalprice+"");
			}
		});
		
		btn_cancel.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		selectpay.add(btn_cancel);

		JButton btn_allcancel = new JButton("\uC804\uCCB4\uCDE8\uC18C");
		btn_allcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				totalprice = 0;
				txtData.setText(totalprice+"");
			}
		});
		btn_allcancel.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		selectpay.add(btn_allcancel);

		JButton btn_pay = new JButton("\uACB0\uC81C\uD558\uAE30");
		btn_pay.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		btn_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제완료!");
				int totalcharge = sdao.select_total(MemberDTO.MemberId);
				udao.chargeamount(totalcharge, totalprice, MemberDTO.MemberId);
				int reprice = sdao.select_total(MemberDTO.MemberId);
				PaymentDTO.ChargeAmount = reprice;
				PrivatePC pc2 = new PrivatePC();
				frame.dispose();

			}
		});
		selectpay.add(btn_pay);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 50, 100));
		panel.setBounds(0, 493, 871, 47);
		getContentPane().add(panel);
		panel.setLayout(new SpringLayout());
		
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
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