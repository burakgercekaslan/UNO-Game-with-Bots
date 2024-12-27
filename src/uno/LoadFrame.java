package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
/**
 * LoadFrame represents the {@linkplain uno.MenuFrame#user}'s saved games to load.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "unused", "serial" })
public class LoadFrame extends JFrame {

	private JButton saveSlot3;
	private JLabel errorLabel;
	private JButton saveSlot1;
	private JButton saveSlot2;
	private User user;
	private MenuFrame menu;

	public MenuFrame getMenu() {
		return menu;
	}

	public void setMenu(MenuFrame menu) {
		this.menu = menu;
	}

	public JButton getSaveSlot3() {
		return saveSlot3;
	}

	public void setSaveSlot3(JButton saveSlot3) {
		this.saveSlot3 = saveSlot3;
	}

	public JLabel getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
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

	/**
	 * Constructor to initialize LoadFrame objects.
	 * @param user User represents current user.
	 * @param menu MenuFrame represents current menu.
	 */
	public LoadFrame(User user, MenuFrame menu) {
		this.user = user;
		this.menu = menu;
		this.setVisible(true);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		this.setBounds(600, 300, 320, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);

		errorLabel = new JLabel("");
		this.getContentPane().add(errorLabel);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 10, 286, 45);

		saveSlot1 = new JButton("Empty Slot 1");
		this.getContentPane().add(saveSlot1);
		saveSlot1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(saveSlot1.getText() == "Empty Slot 1")) {
					menu.setVisible(false);
					UnoGame game = SaveLoad.load(LoadFrame.this, saveSlot1);
					try {
						new GameFrame(game, menu);
						dispose();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					errorLabel.setText("This slot is empty.");
				}
			}
		});
		saveSlot1.setBackground(SystemColor.activeCaption);
		saveSlot1.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot1.setBounds(10, 63, 286, 90);

		saveSlot2 = new JButton("Empty Slot 2");
		this.getContentPane().add(saveSlot2);
		saveSlot2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(saveSlot2.getText() == "Empty Slot 2")) {
					menu.setVisible(false);
					UnoGame game = SaveLoad.load(LoadFrame.this, saveSlot2);
					try {
						new GameFrame(game, menu);
						dispose();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					errorLabel.setText("This slot is empty.");
				}
			}
		});
		saveSlot2.setBackground(SystemColor.activeCaption);
		saveSlot2.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot2.setBounds(10, 163, 286, 90);

		saveSlot3 = new JButton("Empty Slot 3");
		this.getContentPane().add(saveSlot3);
		saveSlot3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(saveSlot3.getText() == "Empty Slot 3")) {
					menu.setVisible(false);
					UnoGame game = SaveLoad.load(LoadFrame.this, saveSlot3);
					try {
						new GameFrame(game, menu);
						dispose();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					errorLabel.setText("This slot is empty.");
				}
			}
		});
		saveSlot3.setFont(new Font("Tahoma", Font.BOLD, 25));
		saveSlot3.setBackground(SystemColor.activeCaption);
		saveSlot3.setBounds(10, 263, 286, 90);
		SaveLoad.initializeLoadFrame(this);

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}