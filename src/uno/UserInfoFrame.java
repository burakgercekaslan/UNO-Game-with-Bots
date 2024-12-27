package uno;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * UserInfoFrame to show users stats detailed.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "unused", "serial" })
public class UserInfoFrame extends JFrame {
	private User user;
	private JLabel scorePGameLabel;
	private JLabel usernameLabel;
	private JLabel totalWinLabel;
	private JLabel totalGameLabel;
	private JLabel totalScoreLabel;
	/**
	 * Constructor to initialize a frame that shows user stats detailed.
	 * @param user User represents current user that logged in.
	 */
	public UserInfoFrame(User user) {
		this.setVisible(true);
		this.user = user;
		this.setResizable(false);
		this.setBounds(100, 100, 619, 430);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		usernameLabel.setBounds(10, 10, 585, 60);
		getContentPane().add(usernameLabel);

		JLabel lblNewLabel_1 = new JLabel("Total Wins");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 80, 291, 60);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Total Games");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(304, 80, 291, 60);
		getContentPane().add(lblNewLabel_1_1);

		totalWinLabel = new JLabel("Total Wins");
		totalWinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalWinLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		totalWinLabel.setBounds(10, 150, 291, 60);
		getContentPane().add(totalWinLabel);

		totalGameLabel = new JLabel("Total Games");
		totalGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalGameLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		totalGameLabel.setBounds(304, 150, 291, 60);
		getContentPane().add(totalGameLabel);

		JLabel lblNewLabel_1_2 = new JLabel("Total Score");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(10, 220, 291, 60);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Score/Game");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_2_1.setBounds(304, 220, 291, 60);
		getContentPane().add(lblNewLabel_1_2_1);

		totalScoreLabel = new JLabel("Total Score");
		totalScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		totalScoreLabel.setBounds(10, 290, 291, 60);
		getContentPane().add(totalScoreLabel);

		scorePGameLabel = new JLabel("Score/Game");
		scorePGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scorePGameLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		scorePGameLabel.setBounds(304, 290, 291, 60);
		getContentPane().add(scorePGameLabel);
		initializeUser();
	}
	/**
	 * Method to update GUI respectfully with users' stats.
	 */
	public void initializeUser() {
		int scorePGame;
		try {
			scorePGame = Math.round(user.getScore() / user.getTotalGame());
		} catch (ArithmeticException e) {
			scorePGame = 0;
		}
		usernameLabel.setText(user.getUsername());
		totalWinLabel.setText(Integer.toString(user.getWin()));
		totalGameLabel.setText(Integer.toString(user.getTotalGame()));
		totalScoreLabel.setText(Integer.toString(user.getScore()));
		scorePGameLabel.setText(Integer.toString(scorePGame));
	}
}
