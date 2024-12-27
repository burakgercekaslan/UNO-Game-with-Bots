package uno;

import java.util.LinkedList;
import java.util.Random;
/**
 * Bot class which represents the bots in UNO. It is subclass of {@linkplain uno.Player}.
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public class Bot extends Player {
	/**
	 * Bot names to randomly pick to initialize {@linkplain uno.Bot} objects for each game.
	 * It is a static and also a final field.
	*/
	private static final String[] BOT_NAME_LIST = {"Serengül", "Faiz", "Bob", "Barış", "Ege", "Himmet", "ChadGPT",
			"Polat Alemdar", "Neo", "tomar753", "Anagrom", "Xolsuz", "Bamboo", "InfinityWarrior", "Mehmet"};

	/**
	 * A static getter methot for {@link uno.Bot#BOT_NAME_LIST}.
	 * @return Returns {@link uno.Bot#BOT_NAME_LIST}.
	*/
	public static String[] getBotNameList() {
		return BOT_NAME_LIST;
	}
	/**
	 * Constructor to initialize {@link uno.Bot} objects.
	 * @param botName String to initialize Bots' username.
	*/
	public Bot(String botName) {
		username = botName;
	}

}
