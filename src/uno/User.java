package uno;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * User class represents the logged user.
 * It is subclass of {@linkplain uno.Player}.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public class User extends Player {
	private ArrayList<String> savedGames;
	private String password;
	private Card cardToPlay = null;

	public Card getCardToPlay() {
		return cardToPlay;
	}

	public void setCardToPlay(Card cardToPlay) {
		this.cardToPlay = cardToPlay;
	}
	/**
	 * Contructor to initialize {@linkplain uno.User} objects.
	 * @param username String to initialize username of {@linkplain uno.User}.
	 * @param password String to initialize password of {@linkplain uno.User}.
	 */
	public User(String username, String password) {
		this.savedGames = new ArrayList<>();
		this.username = username;
		this.password = password;
		this.win = 0;
		this.lose = 0;
		this.score = 0;
		this.totalGame = 0;
		userMap.put(username, this);
	}
	/**
	 * Contructor to initialize {@linkplain uno.User} objects while loading their stats.
	 * @param username String to initialize username of {@linkplain uno.User}.
	 * @param password String to initialize password of {@linkplain uno.User}.
	 * @param win int to initialize win of {@linkplain uno.User}.
	 * @param lose int to initialize lose of {@linkplain uno.User}.
	 * @param score int to initialize score of {@linkplain uno.User}.
	 */
	public User(String username, String password, int win, int lose, int score) {
		this.savedGames = new ArrayList<>();
		this.username = username;
		this.password = password;
		this.lose = lose;
		this.win = win;
		this.score = score;
		this.totalGame = win + lose;
		userMap.put(username, this);
	}

	public ArrayList<String> getSavedGames() {
		return savedGames;
	}

	public void addElementToSavedGames(String gameSession) {
		savedGames.add(gameSession);
	}

	public void setSavedGames(ArrayList<String> savedGames) {
		this.savedGames = savedGames;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
