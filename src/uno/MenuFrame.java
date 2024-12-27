package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.List;
/**
 * MenuFrame represents the initialized menu of the current user that logged in.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "serial", "unused" })
public class MenuFrame extends JFrame {
	private JLabel label;
	/**
	 * Represents current user that logged in.
	 */
	private User user;
	/**
	 * Constructor to initialize MenuFrame with the current user that logged in.
	 * @param user User current logged user.
	 */
	public MenuFrame(User user) {
		this.user = user;
		this.setVisible(true);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		this.setBounds(100, 60, 1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		JLabel unoLabel = new JLabel("UNO");
		this.getContentPane().add(unoLabel);
		unoLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 99));
		unoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unoLabel.setForeground(Color.BLACK);
		unoLabel.setBackground(Color.LIGHT_GRAY);
		unoLabel.setBounds(10, 32, 1254, 159);

		label = new JLabel("");
		this.getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 50));
		label.setBounds(10, 220, 1246, 64);
		label.setText("Welcome " + user.getUsername() + "!");

		JButton quitButton = new JButton("Quit");
		this.getContentPane().add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 84));
		quitButton.setBackground(new Color(255, 0, 0));
		quitButton.setBounds(0, 470, 316, 213);

		JButton playButton = new JButton("Play");
		this.getContentPane().add(playButton);
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlayerNumberFrame(user, MenuFrame.this);
			}
		});
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 84));
		playButton.setBackground(Color.GREEN);
		playButton.setBounds(310, 470, 328, 213);

		JButton leaderboardsButton = new JButton("Leaderboards");
		leaderboardsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LeaderboardsFrame();
			}
		});
		this.getContentPane().add(leaderboardsButton);
		leaderboardsButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		leaderboardsButton.setBackground(Color.CYAN);
		leaderboardsButton.setBounds(948, 470, 316, 213);

		JButton loadButton = new JButton("Load");
		this.getContentPane().add(loadButton);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoadFrame(user, MenuFrame.this);
			}
		});
		loadButton.setFont(new Font("Tahoma", Font.PLAIN, 84));
		loadButton.setBackground(Color.YELLOW);
		loadButton.setBounds(632, 470, 322, 213);
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}
