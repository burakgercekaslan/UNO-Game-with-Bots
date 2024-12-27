package uno;
/**
 * WildCard class represents the {@linkplain uno.WildCard} objects in UNO (+4, colorSwap).
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
public class WildCard extends Card {
	/**
	 * WildCard constructor to initialize an {@linkplain uno.WildCard} object.
	 * Color initialized as "black". 
	 * Score initialized as 50.
	 * @param type String type of {@linkplain uno.WildCard} ("+4","C")
	*/
	public WildCard(String type) {
		super("black", type);
		score = 50;
	}
}
