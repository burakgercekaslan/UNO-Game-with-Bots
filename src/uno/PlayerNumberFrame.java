package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * PlayerNumberFrame represents the frame to pick bot number and calls the {@linkplain uno.GameFrame} afterwards.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "serial", "unused" })
public class PlayerNumberFrame extends JFrame{
	private int botNumber;
	public int getBotNumber() {
		return botNumber;
	}
	public void setBotNumber(int botNumber) {
		this.botNumber = botNumber;
	}
	/**
	 * Constructor to initialize PlayerNumberFrame.
	 * @param user User current user that logged in.
	 * @param menu MenuFrame current menu. When game starts visible is set false.
	 */
	public PlayerNumberFrame(User user,MenuFrame menu){
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Please choose how many bots to play!");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 766, 60);
		getContentPane().add(lblNewLabel);
		
		JButton button1 = new JButton("1");
		button1.setFont(new Font("Tahoma", Font.BOLD, 40));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(1);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
		button1.setBounds(130, 80, 90, 134);
		getContentPane().add(button1);
		
		JButton button2 = new JButton("2");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(2);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button2.setFont(new Font("Tahoma", Font.BOLD, 40));
		button2.setBounds(130, 248, 90, 134);
		getContentPane().add(button2);
		
		JButton button3 = new JButton("3");
		button3.setFont(new Font("Tahoma", Font.BOLD, 40));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(3);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button3.setBounds(250, 80, 90, 134);
		getContentPane().add(button3);
		
		JButton button4 = new JButton("4");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(4);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button4.setFont(new Font("Tahoma", Font.BOLD, 40));
		button4.setBounds(250, 248, 90, 134);
		getContentPane().add(button4);
		
		JButton button5 = new JButton("5");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(5);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button5.setFont(new Font("Tahoma", Font.BOLD, 40));
		button5.setBounds(370, 80, 90, 134);
		getContentPane().add(button5);
		
		JButton button6 = new JButton("6");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(6);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button6.setFont(new Font("Tahoma", Font.BOLD, 40));
		button6.setBounds(370, 248, 90, 134);
		getContentPane().add(button6);
		
		JButton button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(7);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button7.setFont(new Font("Tahoma", Font.BOLD, 40));
		button7.setBounds(490, 80, 90, 134);
		getContentPane().add(button7);
		
		JButton button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(8);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button8.setFont(new Font("Tahoma", Font.BOLD, 40));
		button8.setBounds(490, 248, 90, 134);
		getContentPane().add(button8);
		
		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerNumberFrame.this.setBotNumber(9);
				try {
					new GameFrame(user,botNumber,menu);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		button9.setFont(new Font("Tahoma", Font.BOLD, 40));
		button9.setBounds(610, 165, 90, 134);
		getContentPane().add(button9);
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(100, 100, 800, 450);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
