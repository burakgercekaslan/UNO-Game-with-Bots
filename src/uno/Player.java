package uno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * Player class which represents the players (both {@linkplain uno.User} and {@linkplain uno.Bot}) in UNO.
 * It it an abstract class and has 2 subclasses: {@linkplain uno.User}, {@linkplain uno.Bot}
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public abstract class Player {
	/**
	 * A static HashMap of {@linkplain uno.Player}.
	 * It takes username as key and user as value.
	 * It will upload when an user is created.
	 */
	protected static HashMap<String, User> userMap = new HashMap<String, User>();
	protected LinkedList<Card> deckOfPlayer = new LinkedList<Card>();
	protected String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static HashMap<String, User> getUserMap() {
		return userMap;
	}

	public static void setUserMap(HashMap<String, User> userMap) {
		Player.userMap = userMap;
	}

	public void addCardToDeckOfPlayer(Card card) {
		deckOfPlayer.add(card);
	}

	public LinkedList<Card> getDeckOfPlayer() {
		return deckOfPlayer;
	}

	public void setDeckOfPlayer(LinkedList<Card> newDeck) {
		this.deckOfPlayer = newDeck;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getTotalGame() {
		return totalGame;
	}

	public void setTotalGame(int totalGame) {
		this.totalGame = totalGame;
	}

	protected int score;
	protected int win;
	protected int lose;
	protected int totalGame;
}
