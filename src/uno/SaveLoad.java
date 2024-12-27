package uno;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.common.base.SystemUtils;
/**
 * SaveLoad class represents to handle saving and loading games.
 * It is an abstract class.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public abstract class SaveLoad {
	private static File file;
	private static User user;
	private static UnoGame game;
	private static BufferedReader in;
	private static BufferedWriter out;
	/**
	 * Method to initialize user, current game, file, and reader/writer.
	 * @param save SaveFrame current save frame.
	 */
	public static void initializeSave(SaveFrame save) {
		game = save.getGame();
		user = game.getUser();
		file = new File(String.format("%s.txt", user.getUsername()));
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to initialize user, users' saved games, file, and reader/writer.
	 * @param user User current user that logged in.
	 */
	public static void initializeLoad(User user) {
		file = new File(String.format("%s.txt", user.getUsername()));
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			in = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out = new BufferedWriter(new FileWriter(file, true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Method to load the game from current saved games.
	 * @param loadFrame LoadFrame current load frame.
	 * @param loadSlot JButton representing which save to load.
	 * @return UnoGame object which is loaded game.
	 */
	public static UnoGame load(LoadFrame loadFrame, JButton loadSlot) {
		user = loadFrame.getUser();
		initializeLoad(user);
		String sessionName = loadSlot.getText();
		String line;
		ArrayList<Bot> bots = new ArrayList<>();
		String[] parts = null;

		try {
			while ((line = in.readLine()) != null) {
				parts = line.split(":");
				if (parts[0].equals(sessionName)) {
					int turn = Integer.parseInt(parts[1]);
					int rotation = Integer.parseInt(parts[2]);
					boolean skipNext = Boolean.parseBoolean(parts[3]);
					Stack<Card> discardPile = loadStacks(parts[4]);
					Stack<Card> deck = loadStacks(parts[5]);
					user.setDeckOfPlayer(loadLinkedLists(parts[7]));
					for (int i = 8; i < parts.length; i += 2) {
						Bot bot = new Bot(parts[i]);
						bot.setDeckOfPlayer(loadLinkedLists(parts[i + 1]));
						bots.add(bot);
					}
					UnoGame game = new UnoGame(sessionName, turn, rotation, skipNext, discardPile, deck, bots, user);
					return game;
				}
			}
			System.out.println("No matched save!!!");
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {

			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Method to save the current game to the current users' saved games.
	 * @param save SaveFrame current save frame.
	 * @param saveSlot JButton to pick which slot to save.
	 */
	public static void save(SaveFrame save, JButton saveSlot) {
		initializeSave(save);
		JLabel errorLabel = save.getErrorLabel();
		JTextField txtSessionName = save.getTxtSessionName();
		try {
			if (saveSlot.getText().equals("Empty Slot 1") || saveSlot.getText().equals("Empty Slot 2")
					|| saveSlot.getText().equals("Empty Slot 3")) {
				if (!txtSessionName.getText().equals("Enter Session Name Here!") && !txtSessionName.getText().equals("")
						&& !txtSessionName.getText().equals(saveSlot.getText())) {
					try {
						user.addElementToSavedGames(txtSessionName.getText());
						save.getGame().setSessionName(txtSessionName.getText());
						out.write(String.format("%s:%d:%d:%b:%s:%s", txtSessionName.getText(), game.getTurn(),
								game.getRotation(), game.isSkipNext(), game.getDiscardPile(), game.getDeck()));
						for (Player player : game.getPlayers()) {
							out.write(":" + player.getUsername() + ":" + player.getDeckOfPlayer().toString());
						}
						out.newLine();
						errorLabel.setText("Saved Successfully!");
						errorLabel.setForeground(Color.GREEN);
						saveSlot.setText(txtSessionName.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					errorLabel.setText("Please enter a session name.");
				}
			} else {
				errorLabel.setText("This slot is full.");
			}
		} finally {

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Method to convert String object that represents Stack to a Stack object.
	 * @param list String which should be converted to a Stack of {@linkplain uno.Card}.
	 * @return Stack of {@linkplain uno.Card}.
	 */
	public static Stack<Card> loadStacks(String list) {
		Stack<Card> cardList = new Stack<>();
		String[] cards = list.split(",");
		for (int i = 0; i < cards.length; i++) {
			if (i != cards.length - 1) {
				String cardInfo = cards[i].substring(1);
				String[] cardToAdd = cardInfo.split(" ");
				if (cardToAdd[1].equals("+4") || cardToAdd[1].equals("C")) {
					WildCard card = new WildCard(cardToAdd[1]);
					card.setColor(cardToAdd[0]);
					cardList.add(card);
				} else if (cardToAdd[1].equals("+2") || cardToAdd[1].equals("R") || cardToAdd[1].equals("B")) {
					ActionCard card = new ActionCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				} else {
					NumberCard card = new NumberCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				}
			} else {
				String cardInfo = cards[i].substring(1, cards[i].length() - 1);
				String[] cardToAdd = cardInfo.split(" ");
				if (cardToAdd[1].equals("+4") || cardToAdd[1].equals("C")) {
					WildCard card = new WildCard(cardToAdd[1]);
					card.setColor(cardToAdd[0]);
					cardList.add(card);
				} else if (cardToAdd[1].equals("+2") || cardToAdd[1].equals("R") || cardToAdd[1].equals("B")) {
					ActionCard card = new ActionCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				} else {
					NumberCard card = new NumberCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				}
			}
		}
		return cardList;
	}
	/**
	 * Method to convert String object that represents LinkedList to a LinkedList object.
	 * @param list String which should be converted to a LinkedList of {@linkplain uno.Card}.
	 * @return LinkedList of {@linkplain uno.Card}.
	 */
	public static LinkedList<Card> loadLinkedLists(String list) {
		LinkedList<Card> cardList = new LinkedList<>();
		String[] cards = list.split(",");
		for (int i = 0; i < cards.length; i++) {
			if (i != cards.length - 1) {
				String cardInfo = cards[i].substring(1);
				String[] cardToAdd = cardInfo.split(" ");
				if (cardToAdd[1].equals("+4") || cardToAdd[1].equals("C")) {
					WildCard card = new WildCard(cardToAdd[1]);
					card.setColor(cardToAdd[0]);
					cardList.add(card);
				} else if (cardToAdd[1].equals("+2") || cardToAdd[1].equals("R") || cardToAdd[1].equals("B")) {
					ActionCard card = new ActionCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				} else {
					NumberCard card = new NumberCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				}
			} else {
				String cardInfo = cards[i].substring(1, cards[i].length() - 1);
				String[] cardToAdd = cardInfo.split(" ");
				if (cardToAdd[1].equals("+4") || cardToAdd[1].equals("C")) {
					WildCard card = new WildCard(cardToAdd[1]);
					card.setColor(cardToAdd[0]);
					cardList.add(card);
				} else if (cardToAdd[1].equals("+2") || cardToAdd[1].equals("R") || cardToAdd[1].equals("B")) {
					ActionCard card = new ActionCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				} else {
					NumberCard card = new NumberCard(cardToAdd[0], cardToAdd[1]);
					cardList.add(card);
				}
			}
		}
		return cardList;
	}
	/**
	 * Method to Update the GUI with the saved sessions' names.
	 * @param loadFrame LoadFrame current load frame.
	 */
	public static void initializeLoadFrame(LoadFrame loadFrame) {
		user = loadFrame.getUser();
		initializeLoad(user);
		String line;
		int i = 1;
		try {
			while ((line = in.readLine()) != null) {
				if (i == 1) {
					loadFrame.getSaveSlot1().setText(line.split(":")[0]);
				} else if (i == 2) {
					loadFrame.getSaveSlot2().setText(line.split(":")[0]);
				} else {
					loadFrame.getSaveSlot3().setText(line.split(":")[0]);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Method to Update the GUI with the saved sessions' names.
	 * @param saveFrame SaveFrame current save frame.
	 */
	public static void initializeSaveFrame(SaveFrame saveFrame) {
		user = saveFrame.getUser();
		initializeSave(saveFrame);
		String line;
		int i = 1;
		try {
			while ((line = in.readLine()) != null) {
				if (i == 1) {
					saveFrame.getSaveSlot1().setText(line.split(":")[0]);
				} else if (i == 2) {
					saveFrame.getSaveSlot2().setText(line.split(":")[0]);
				} else {
					saveFrame.getSaveSlot3().setText(line.split(":")[0]);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *  Method to delete the save when game is over.
	 * @param game UnoGame current game.
	 */
	public static void handleGameOver(UnoGame game) {
		if (game.getSessionName() == null) {
			return;
		}
		initializeLoad(game.getUser());
		String line;
		ArrayList<String> lines = new ArrayList<>();
		try {
			System.out.println("Game Session name is: " + game.getSessionName());
			while ((line = in.readLine()) != null) {
				System.out.println("Reading: " + line);
				String[] parts = line.split(":");
				if (!parts[0].equals(game.getSessionName())) {
					lines.add(line);
					System.out.println(parts[0] + " added!");
				}
			}
			file.delete();
			file.createNewFile();
			out = new BufferedWriter(new FileWriter(file));
			for (String eachLine : lines) {
				System.out.println("Writing: " + eachLine);
				out.write(eachLine);
				out.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
