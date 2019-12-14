package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.DAO.UpdateDAO;
import Main.DTO.PcDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UWannaFinish implements WindowListener{

   private JFrame frame;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               UWannaFinish window = new UWannaFinish();
               window.frame.setVisible(true);
               window.frame.setLocationRelativeTo(null);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public UWannaFinish() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 395, 156);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC815\uB9D0\uB85C \uC885\uB8CC\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
      lblNewLabel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 15));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(38, 28, 298, 26);
      frame.getContentPane().add(lblNewLabel);
      
      JButton btn_ok = new JButton("\uD655\uC778");
      btn_ok.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
      btn_ok.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	int pcnum = PcDTO.PcNumber;
			UpdateDAO udao = new UpdateDAO();
			boolean pc = udao.PcOff(pcnum);
            frame.dispose();
            Login.main(null);
            
         }
      });
      btn_ok.setBounds(90, 64, 84, 23);
      frame.getContentPane().add(btn_ok);
      
      JButton btn_cancel = new JButton("\uB4A4\uB85C");
      btn_cancel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
      btn_cancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            
         }
      });
      btn_cancel.setBounds(186, 64, 84, 23);
      frame.getContentPane().add(btn_cancel);
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