package uno;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
/**
 * UserLoginInfo class to handle backend of {@linkplain uno.LogInFrame}
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public abstract class UserLoginInfo {
	private static HashMap<String, String> userDatabase = new HashMap<String, String>();// for username and password
																						// pairs.

	public static HashMap<String, String> getUserDatabase() {
		return userDatabase;
	}

	public static void setUserDatabase(HashMap<String, String> userDatabase) {
		UserLoginInfo.userDatabase = userDatabase;
	}
	/**
	 * Method to create user and write users' login info to UserInfo.txt file. Stats of user initialized as 0.
	 * @param username String username of the user.
	 * @param password String password of the user.
	 * @throws IOException
	 */
	public static void writeUserLoginInfo(String username, String password) throws IOException {
		userDatabase.put(username, password);
		File log = new File("UserInfo.txt");// our log file is here.
		try {
			if (log.exists() == false) {
				log.createNewFile();
			}
			try (BufferedWriter out = new BufferedWriter(new FileWriter(log, true))) {
				out.write(username + ":" + password + ":0:0:0");
				out.newLine();
			}
			new User(username, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to read UserInfo.txt file and create existing users again respectfully.
	 * @throws Exception
	 */
	public static void readUserLoginInfo() throws Exception {
		File log = new File("UserInfo.txt");
		if (!log.exists()) {
			log.createNewFile();
		} else {
			try (BufferedReader in = new BufferedReader(new FileReader(log))) {
				String data;
				while ((data = in.readLine()) != null) {
					userDatabase.put(data.split(":")[0], data.split(":")[1]);
					new User(data.split(":")[0], data.split(":")[1], Integer.parseInt(data.split(":")[2]),
							Integer.parseInt(data.split(":")[3]), Integer.parseInt(data.split(":")[4]));
				}
			}
		}
	}
	/**
	 * Updates the file with the new stats of given user and deletes the old values.
	 * @param user User current user object.
	 */
	public static void updateUserInfo(User user) {
		File log = new File("UserInfo.txt");
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader in = new BufferedReader(new FileReader(log))) {
			String line;
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		for (int i = 0; i < lines.size(); i++) {
			String[] parts = lines.get(i).split(":");
			if (parts.length >= 5 && parts[0].equals(user.getUsername())) {
				parts[2] = Integer.toString(user.getWin());
				parts[3] = Integer.toString(user.getLose());
				parts[4] = Integer.toString(user.getScore());
				lines.set(i, String.join(":", parts));
				break;
			}
		}
		try (BufferedWriter out = new BufferedWriter(new FileWriter(log))) {
			for (String line : lines) {
				out.write(line);
				out.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to confirm login.
	 * @param username String username of user.
	 * @param password String password of user.
	 * @return Boolean true if username matches password, false otherwise.
	 */
	public static boolean confirmLogin(String username, String password) {
		return (userDatabase.get(username).equals(password));
	}
}
