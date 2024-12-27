package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
/**
 * SaveFrame represents the save slots. User can save the game by clicking on an empty save slot.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "unused", "serial" })
public class SaveFrame extends JFrame{
	private User user;
	private File file;
	private BufferedReader in;
	private BufferedWriter out;
	private JTextField txtSessionName;
	private UnoGame game;
	private JButton saveSlot1;
	private JButton saveSlot2;
	private JButton saveSlot3;
	private JLabel errorLabel;
	
	public UnoGame getGame() {
		return game;
	}

	public void setGame(UnoGame game) {
		this.game = game;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	public JTextField getTxtSessionName() {
		return txtSessionName;
	}

	public void setTxtSessionName(JTextField txtSessionName) {
		this.txtSessionName = txtSessionName;
	}

	public JButton getSaveSlot1() {
		return saveSlot1;
	}

	public void setSaveSlot1(JButton saveSlot1) {
		this.saveSlot1 = saveSlot1;
	}

	public JButton getSaveSlot2() {
		return saveSlot2;
	}

	public void setSaveSlot2(JButton saveSlot2) {
		this.saveSlot2 = saveSlot2;
	}

	public JButton getSaveSlot3() {
		return saveSlot3;
	}

	public void setSaveSlot3(JButton saveSlot3) {
		this.saveSlot3 = saveSlot3;
	}
	/**
	 * Constructor to initialize save frame.
	 * @param user User current user that logged in.
	 * @param gameFrame GameFrame current gameFrame to save the game.
	 */
	public SaveFrame(User user,GameFrame gameFrame) {
		this.user = user;
		this.game = gameFrame.getGame();
		this.setVisible(true);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		this.setBounds(600,300, 320, 458);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		errorLabel = new JLabel("");
		this.getContentPane().add(errorLabel);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 66, 286, 45);
		
		saveSlot1 = new JButton("Empty Slot 1");
		this.getContentPane().add(saveSlot1);
		saveSlot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveLoad.save(SaveFrame.this, saveSlot1);
			}
		});
		saveSlot1.setBackground(SystemColor.activeCaption);
		saveSlot1.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot1.setBounds(10, 121, 286, 90);
		
		saveSlot2 = new JButton("Empty Slot 2");
		this.getContentPane().add(saveSlot2);
		saveSlot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveLoad.save(SaveFrame.this, saveSlot2);
			}
		});
		saveSlot2.setBackground(SystemColor.activeCaption);
		saveSlot2.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot2.setBounds(10, 221, 286, 90);
		
		saveSlot3 = new JButton("Empty Slot 3");
		this.getContentPane().add(saveSlot3);
		saveSlot3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveLoad.save(SaveFrame.this, saveSlot3);
			}
		});
		saveSlot3.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot3.setBackground(SystemColor.activeCaption);
		saveSlot3.setBounds(10, 321, 286, 90);
		
		txtSessionName = new JTextField();
		txtSessionName.setHorizontalAlignment(SwingConstants.CENTER);
		txtSessionName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtSessionName.setText("Enter Session Name Here!");
		txtSessionName.setBounds(10, 10, 286, 46);
		getContentPane().add(txtSessionName);
		txtSessionName.setColumns(10);
		SaveLoad.initializeSaveFrame(this);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}