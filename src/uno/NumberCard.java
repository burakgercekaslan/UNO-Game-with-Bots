package uno;
/**
 * NumberCard class represents the {@linkplain uno.NumberCard} objects in UNO (0-9).
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
public class NumberCard extends Card {
	/**
	 * Constructor to initialize {@linkplain uno.NumberCard} object.
	 * Score initialized as types' value.(0-9)
	 * @param color String color of {@linkplain uno.NumberCard} ("yellow","red","blue","green")
	 * @param type String type of {@linkplain uno.NumberCard} (0-9)
	*/
	public NumberCard(String color, String type) {
		super(color, type);
		score = Integer.parseInt(type);
	}
}
