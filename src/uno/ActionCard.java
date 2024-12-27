package uno;
/**
 * ActionCard class represents the {@linkplain uno.ActionCard} in UNO (+2,block,reverse).
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
public class ActionCard extends Card {
	/**
	 * Constructor to initialize {@linkplain uno.ActionCard} object.
	 * @param color String color of {@linkplain uno.ActionCard} ("yellow","red","blue","green")
	 * @param type String type of {@linkplain uno.ActionCard} ("+2","R","B")
	*/
	public ActionCard(String color, String type) {
		super(color, type);
		score = 20;
	}

}
