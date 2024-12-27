package uno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import uno.WildCard;
import uno.ActionCard;
import uno.NumberCard;
import javax.swing.Timer;
import java.io.File;
/**
 * UnoGame class  represents a game of UNO.
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public class UnoGame {
	private File file = new File("log.txt");
	private BufferedWriter out ;
	private SecureRandom random = new SecureRandom();
	/**
	 * Stack of drawable cards in {@linkplain uno.UnoGame} object.
	 */
	private Stack<Card> deck = new Stack<Card>();
	private ArrayList<Bot> bots = new ArrayList<Bot>();
	/**
	 * Currently logged user of the {@linkplain uno.UnoGame} object.
	 */
	private User user;
	private ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * Stack of discarded cards in {@linkplain uno.UnoGame} object.
	 */
	private Stack<Card> discardPile = new Stack<Card>();
	/**
	 * Int represents current turn of {@linkplain uno.UnoGame} object.
	 */
	private int turn;
	private boolean uno;
	/**
	 * String represents the session name of the current game. If game is not saved it has no session name.
	 */
	private String sessionName;

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public boolean isUno() {
		return uno;
	}

	public void setUno(boolean uno) {
		this.uno = uno;
	}
	
	public BufferedWriter getOut() {
		return out;
	}

	public void setOut(BufferedWriter out) {
		this.out = out;
	}

	/**
	 * Int represents the rotation of {@linkplain uno.UnoGame} object. 1 for CCW and -1 for CW.
	 */
	private int rotation = 1;

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	/**
	 * Boolean represents if the next player should play or not.
	 */
	private boolean skipNext = false;

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public boolean isSkipNext() {
		return skipNext;
	}

	public void setSkipNext(boolean skipNext) {
		this.skipNext = skipNext;
	}

	public boolean canPlay(Card cardToPlay, Card topCard) {
		if (cardToPlay instanceof WildCard) {
			return true;
		} else {
			if (cardToPlay.getColor().equals(topCard.getColor())) {
				return true;
			} else if (cardToPlay.getType().equals(topCard.getType())) {
				return true;
			} else {
				return false;
			}
		}
	}
	/**
	 * Constructor to load game.
	 * @param sessionName String represents the {@linkplain uno.UnoGame#sessionName}
	 * @param turn int represents the {@linkplain uno.UnoGame#turn}.
	 * @param rotation int represents the {@linkplain uno.UnoGame#rotation}
	 * @param skipNext boolean represents the {@linkplain uno.UnoGame#skipNext}
	 * @param discardPile Stack of {@linkplain uno.Card} objects represents the {@linkplain uno.UnoGame#discardPile}
	 * @param deck Stack of {@linkplain uno.Card} objects represents the {@linkplain uno.UnoGame#deck}
	 * @param bots ArrayList of {@linkplain uno.Bot} objects.
	 * @param user User represents the {@linkplain uno.UnoGame#user}
	 */
	public UnoGame(String sessionName, int turn, int rotation, boolean skipNext, Stack<Card> discardPile,
			Stack<Card> deck, ArrayList<Bot> bots, User user) {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			this.out = new BufferedWriter(new FileWriter(file,true));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.sessionName = sessionName;
		this.user = user;
		this.bots = bots;
		this.turn = turn;
		this.rotation = rotation;
		this.skipNext = skipNext;
		this.discardPile = discardPile;
		this.deck = deck;
		this.bots = bots;
		this.user = user;
		players.add(user);
		for (Bot bot : bots) {
			players.add(bot);
		}
	}
	/**
	 * Method to play players turn with cardToPlay bu adjusting players' deck and discard pile. Used for User objects mostly. It also write logs.
	 * @param player Player represents {@linkplain uno.Player} object.
	 * @param cardToPlay Card represents {@linkplain uno.Card} object to play.
	 * @param topCard Card represents the last item of {@linkplain uno.UnoGame#discardPile}
	 */
	public void play(Player player, Card cardToPlay, Card topCard) {
		if (this.isSkipNext()) {
			this.setTurn(this.getTurn() + this.getRotation());
			this.setSkipNext(false);
			return;
		} else {
			player.getDeckOfPlayer().remove(cardToPlay);
			discardPile.add(cardToPlay);
			useCardEffect(cardToPlay);
			try {
				out.write(String.format("Player: %s : Played Card:%s  :  Player Deck: %s", player.getUsername(), cardToPlay, player.getDeckOfPlayer()));
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			setTurn(getTurn() + getRotation());
		}
	}
	/**
	 * Method to play players turn with cardToPlay bu adjusting players' deck and discard pile. Used for Bot objects mostly. It also write logs.
	 * @param player player Player represents {@linkplain uno.Player} object.
	 * @param topCard Card represents the last item of {@linkplain uno.UnoGame#discardPile}
	 */
	public void play(Player player, Card topCard) {
		if (this.isSkipNext()) {
			this.setTurn(this.getTurn() + this.getRotation());
			this.setSkipNext(false);
			return;
		} else {
			ArrayList<Card> cardListToPlay = new ArrayList<Card>();
			for (Card card : player.getDeckOfPlayer()) {
				if (canPlay(card, topCard)) {
					cardListToPlay.add(card);
				}
			}
			if (cardListToPlay.size() == 0) {
				drawCard(player, 1);
				try {
					out.write(String.format("%s draw 1.", player.getUsername()));
					out.newLine();
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				setTurn(getTurn() + getRotation());
				return;
			} else {
				Card cardToPlay = cardListToPlay.get(random.nextInt(0, cardListToPlay.size()));
				player.getDeckOfPlayer().remove(cardToPlay);
				discardPile.add(cardToPlay);
				useCardEffect(cardToPlay);
				try {
					out.write(String.format("Player: %s : Played Card:%s  :  Player Deck: %s", player.getUsername(), cardToPlay, player.getDeckOfPlayer()));
					out.newLine();
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				setTurn(getTurn() + getRotation());
				return;
			}
		}

	}

	public Stack<Card> getDeck() {
		return deck;
	}

	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Bot> getBots() {
		return bots;
	}

	public void setBots(ArrayList<Bot> bots) {
		this.bots = bots;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * Constructor to create UnoGame. Initialize the games' deck, players' decks, and discard pile.
	 * @param user User current user that logged in.
	 * @param botNumber int number of bots to initialize.
	 */
	public UnoGame(User user, int botNumber) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}else {
				file.delete();
				file.createNewFile();
			}
			this.out = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Bot> botList = new ArrayList<Bot>(); // initializes a bot list.
		for (String botName : Bot.getBotNameList()) {
			botList.add(new Bot(botName));
		}
		for (Bot bot : botList) {
			bot.getDeckOfPlayer().clear();
		}
		user.getDeckOfPlayer().clear();
		this.user = user;
		players.add(user);
		do {
			int index = random.nextInt(0, botList.size());
			if (!players.contains(botList.get(index))) {
				players.add(botList.get(index));
				bots.add(botList.get(index));
			}
		} while (players.size() < botNumber + 1);
		for (String color : Card.getCardColorList()) {
			for (String type : Card.getCardTypeList()) {
				if (type == "+4" | type == "C") {
					continue;
				} else if (!((type == "0") | (type == "+2" | type == "B" | type == "R"))) {
					deck.add(new NumberCard(color, type));
					deck.add(new NumberCard(color, type));
				} else if ((type == "+2" | type == "B" | type == "R")) {
					deck.add(new ActionCard(color, type));
					deck.add(new ActionCard(color, type));
				} else {
					deck.add(new NumberCard(color, type));
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			deck.add(new WildCard("+4"));
			deck.add(new WildCard("C"));
		}

		for (Player player : players) {
			for (int i = 0; i < 7; i++) {
				Card card = deck.get(random.nextInt(0, deck.size()));
				player.getDeckOfPlayer().add(card);
				deck.remove(card);
			}
			try {
				out.write(String.format("Player %s   Deck : %s",player.getUsername(),player.getDeckOfPlayer()));
				out.newLine();
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Card card = deck.get(random.nextInt(0, deck.size()));
		while (card instanceof WildCard) {
			card = deck.get(random.nextInt(0, deck.size()));
		}
		discardPile.add(card);
		deck.remove(card);
		Collections.shuffle(deck);
	}

	public Stack<Card> getDiscardPile() {
		return discardPile;
	}

	public void setDiscardPile(Stack<Card> discardPile) {
		this.discardPile = discardPile;
	}

	public void drawCard(Player player, int number) {
		for (int i = 0; i < number; i++) {
			Card card = deck.pop();
			;
			player.getDeckOfPlayer().add(card);
		}
	}
	/**
	 * Method to update game respectfully with the given cards effect.
	 * @param card Card to use its' effect.
	 */
	public void useCardEffect(Card card) {
		if (card instanceof ActionCard) {
			if (card.getType().equals("+2")) {
				drawCard(players.get(Math.floorMod(getTurn() + getRotation(), players.size())), 2);
				try {
					out.write(String.format("%s draw 2.",
							players.get(Math.floorMod(getTurn() + getRotation(), players.size())).getUsername()));
					out.newLine();
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				skipNext = true;
			} else if (card.getType().equals("B")) {
				skipNext = true;
				try {
					out.write(String.format("%s blocked",
							players.get(Math.floorMod(getTurn() + getRotation(), players.size())).getUsername()));
					out.newLine();
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (card.getType().equals("R")) {
				rotation *= -1;
				try {
					if (rotation ==1) {
						out.write("Rotation is CCW");
					}else {
						out.write("Rotation is CW.");
					}
					out.newLine();
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if (card instanceof WildCard) {
			if (card.getType().equals("+4")) {
				drawCard(players.get(Math.floorMod(getTurn() + getRotation(), players.size())), 4);
				try {
					out.write(String.format("%s draw 4.",
							players.get(Math.floorMod(getTurn() + getRotation(), players.size())).getUsername()));
					out.newLine();
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				skipNext = true;
				int i = random.nextInt(0, 4);
				card.setColor(pickColor(i));
			} else {
				int i = random.nextInt(0, 4);
				card.setColor(pickColor(i));
			}
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	/**
	 * Method to shuffle {@linkplain uno.UnoGame#deck}
	 */
	public void shuffleDeck() {
		Card cardTop = discardPile.lastElement();
		ArrayList<Card> toRemove = new ArrayList<Card>();
		for (Card card : discardPile) {
			if (card != cardTop) {
				toRemove.add(card);
				if (card instanceof WildCard) {
					card.setColor("black");
				}
			}
		}
		discardPile.removeAll(toRemove);
		deck.addAll(toRemove);
		Collections.shuffle(deck);
	}
	/**
	 * Method to find any winner if exist and return.
	 * @return Player winner of the game. Returns null if not any winner exist.
	 */
	public Player getWinner() {
		for (Player player : players) {
			if (player.getDeckOfPlayer().size() == 0) {
				return player;
			}
		}
		return null;
	}
	/**
	 * Method to update users score if user win.
	 */
	public void updateUserScore() {
		if (getWinner() instanceof User) {
			int score = 0;
			for (Bot bot : bots) {
				for (Card card : bot.getDeckOfPlayer()) {
					score += card.getScore();
				}
			}
			user.setScore(user.getScore() + score);
			user.setWin(user.getWin() + 1);
		} else {
			user.setLose(user.getLose() + 1);
		}
		UserLoginInfo.updateUserInfo(user);
	}
	/**
	 * Method to represent color as int and convert that int to String color.
	 * @param i int represents the code of color.
	 * @return String color which is reprersented by i.
	 */
	public String pickColor(int i) {
		if (i == 0) {
			return "red";
		} else if (i == 1) {
			return "blue";
		} else if (i == 2) {
			return "green";
		} else {
			return "yellow";
		}
	}
}