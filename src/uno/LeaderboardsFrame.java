package uno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;
/**
 * LeaderboardsFrame represents the leaderboard of all {@linkplain uno.User} objects.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("serial")
public class LeaderboardsFrame extends JFrame {
	private DefaultTableModel model;
	private JTable table;
	/**
	 * Constructor to initialize LeaderboardsFrame objects.
	 * It adds all users to the table and sort them with decreasing score order.
	 */
	public LeaderboardsFrame() {
		setTitle("Leaderboards");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Creates a table model which is not editible.
		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("User");
		model.addColumn("Score");

		// Creates a table with the model
		table = new JTable(model);

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
		initializeAllUsers();
		sortTableModelByScore();
		// Mouse listener for table. If a row of table clicked 2 times then it opens UserInfoFrame of the user in selected row.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedRow = table.getSelectedRow();
					String username = (String) model.getValueAt(selectedRow, 0);
					new UserInfoFrame(Player.getUserMap().get(username));
				}
			}
		});
	}
	/**
	 * Method to add user to the table model.
	 * @param user User to add model.
	 */
	private void addUser(User user) {
		model.addRow(new Object[] { user.getUsername(), user.getScore() });
	}
	/**
	 * Method to sort table model and sort table respectfully.
	 * This method uses {@linkplain java.util.Comparator#comparingInt()} method to sort the model.
	 */
	private void sortTableModelByScore() {
		ArrayList<User> userList = new ArrayList<User>();
		for (User user : Player.getUserMap().values()) {
			userList.add(user);
		}
		userList.sort(Comparator.comparingInt(User::getScore).reversed());

		model.setRowCount(0); // Clear all rows
		for (User user : userList) {
			model.addRow(new Object[] {user.getUsername(), user.getScore()});
		}
	}
	/**
	 * Method that calls {@linkplain uno.LeaderboardsFrame#addUser(User)} for every user in {@linkplain uno.Player#userMap}
	 */
	private void initializeAllUsers() {
		for (User user : Player.getUserMap().values()) {
			addUser(user);
		}
	}
}
