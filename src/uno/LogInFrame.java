package uno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Label;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
/**
 * LogInFrame represents the frame to login with username and password.
 * It also gives you opportunity to create a new account with username and password.
 * After logged in it initializes a new {@linkplain uno.MenuFrame} and disposes automatically.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "unused", "serial" })
public class LogInFrame extends JFrame {

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	/**
	 * Constructor to initialize LogInFrame.
	 */
	public LogInFrame() {
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		this.setTitle("UNO");
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		this.setBounds(250, 75, 900, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		JLabel txtError = new JLabel("");
		this.getContentPane().add(txtError);
		txtError.setForeground(Color.RED);
		txtError.setBackground(Color.WHITE);
		txtError.setFont(new Font("Yu Gothic UI", Font.PLAIN, 25));
		txtError.setBounds(163, 495, 503, 74);

		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			// Method to create a new user
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (UserLoginInfo.getUserDatabase().containsKey(txtUsername.getText())) {
					txtError.setForeground(Color.RED);
					txtError.setText("User already exist.");
					txtPassword.setText("");
				} else if (txtUsername.getText().length() == 0) {
					txtError.setForeground(Color.RED);
					txtError.setText("Username cannot be empty.");
				} else if (txtPassword.getText().length() == 0) {
					txtError.setForeground(Color.RED);
					txtError.setText("Password cannot be empty.");
				} else {
					txtError.setText("");
					try {
						UserLoginInfo.writeUserLoginInfo(txtUsername.getText(), txtPassword.getText());
						txtError.setForeground(Color.GREEN);
						txtError.setText("Account created succesfully.");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(664, 579, 212, 94);
		this.getContentPane().add(btnNewButton);

		txtUsername = new JTextField();
		this.getContentPane().add(txtUsername);
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsername.setBounds(163, 200, 503, 90);
		txtUsername.setColumns(10);

		Label label = new Label("Please Login or Create an Account.");
		this.getContentPane().add(label);
		label.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		label.setForeground(Color.BLACK);
		label.setBackground(new Color(192, 192, 192));
		label.setBounds(163, 10, 848, 90);

		JLabel lblNewLabel = new JLabel("Enter your username:");
		this.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblNewLabel.setBounds(163, 143, 503, 47);

		JLabel lblEnterYourPassword = new JLabel("Enter your password:");
		this.getContentPane().add(lblEnterYourPassword);
		lblEnterYourPassword.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblEnterYourPassword.setBounds(163, 300, 503, 47);

		JButton btnLogin = new JButton("Login");
		this.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// Method to login with an existing user
				if (txtUsername.getText().length() == 0) {
					txtError.setForeground(Color.RED);
					txtError.setText("Username cannot be empty.");
				} else if (txtPassword.getText().length() == 0) {
					txtError.setForeground(Color.RED);
					txtError.setText("Password cannot be empty.");
				} else if (!UserLoginInfo.getUserDatabase().containsKey(txtUsername.getText())) {
					txtError.setForeground(Color.RED);
					txtError.setText("There is not any user with username " + txtUsername.getText());
				} else if (UserLoginInfo.confirmLogin(txtUsername.getText(), txtPassword.getText())) {
					txtError.setForeground(Color.GREEN);
					txtError.setText("Login Succesfully.");
					new MenuFrame(Player.getUserMap().get(txtUsername.getText()));
					dispose();
				} else {
					txtError.setForeground(Color.RED);
					txtError.setText("Wrong username or password.");
					txtPassword.setText("");
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setBounds(442, 579, 212, 94);

		JButton btnQuit = new JButton("Quit");
		this.getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnQuit.setBounds(10, 579, 212, 94);
		this.getContentPane().add(btnQuit);

		txtPassword = new JPasswordField();
		this.getContentPane().add(txtPassword);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPassword.setBounds(163, 357, 503, 90);
	}

}
