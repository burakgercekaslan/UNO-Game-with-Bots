package uno;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * GameMenuFrame represents the menu of {@linkplain uno.GameFrame}.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "serial", "unused" })
public class GameMenuFrame extends JFrame {
	private GameFrame gameFrame;

	/**
	 * Constructor to initialize a menu inside the game.
	 * @param user User of current game.
	 * @param gameFrame GameFrame of current game.
	 */
	public GameMenuFrame(User user, GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		gameFrame.stopTimer();
		this.setBounds(100, 100, 220, 376);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		getContentPane().setLayout(null);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveFrame(user, gameFrame);
			}
		});
		saveButton.setBackground(Color.GREEN);
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		saveButton.setBounds(10, 10, 186, 100);
		getContentPane().add(saveButton);

		JButton resumeButton = new JButton("Resume");
		resumeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameFrame.startTimer();
				;
				dispose();
			}
		});
		resumeButton.setBackground(Color.YELLOW);
		resumeButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		resumeButton.setBounds(10, 120, 186, 100);
		getContentPane().add(resumeButton);

		JButton quitButton_1 = new JButton("Quit");
		quitButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		quitButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		quitButton_1.setBackground(Color.RED);
		quitButton_1.setBounds(10, 230, 186, 100);
		getContentPane().add(quitButton_1);
	}
}
