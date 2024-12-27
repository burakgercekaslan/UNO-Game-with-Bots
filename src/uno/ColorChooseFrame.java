package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * ColorChooseFrame to choose a color when {@linkplain uno.WildCard} played.
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "unused", "serial" })
public class ColorChooseFrame extends JFrame {
	public String color;
	
	/**
	 * Constructor of ColorChooseFrame. Game will be paused until color is chosen.
	 * @param gameFrame GameFrame object of current game.
	 * @param cardToPlay WildCard object that represents chosen {@linkplain uno.WildCard}.
	 */
	public ColorChooseFrame(GameFrame gameFrame, WildCard cardToPlay) {
		this.color = "";
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(100, 100, 780, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton Green = new JButton("");
		Green.setBackground(Color.GREEN);
		Green.setBounds(388, 246, 368, 161);
		getContentPane().add(Green);
		Green.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "green";
				dispose();
				gameFrame.handleChosenColor(color, cardToPlay);

			}
		});

		JButton Yellow = new JButton("");
		Yellow.setBackground(Color.YELLOW);
		Yellow.setBounds(10, 246, 368, 161);
		getContentPane().add(Yellow);
		Yellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "yellow";
				dispose();
				gameFrame.handleChosenColor(color, cardToPlay);
			}
		});

		JButton Blue = new JButton("");
		Blue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "blue";
				dispose();
				gameFrame.handleChosenColor(color, cardToPlay);
			}
		});
		Blue.setBackground(Color.BLUE);
		Blue.setBounds(388, 75, 368, 161);
		getContentPane().add(Blue);

		JButton Red = new JButton("");
		Red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = "red";
				dispose();
				gameFrame.handleChosenColor(color, cardToPlay);
			}
		});
		Red.setBackground(Color.RED);
		Red.setBounds(10, 75, 368, 161);
		getContentPane().add(Red);

		JLabel lblNewLabel = new JLabel("Choose Color!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(10, 10, 746, 55);
		getContentPane().add(lblNewLabel);
	}
}
