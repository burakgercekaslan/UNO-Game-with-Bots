package uno;

import java.util.ArrayList;
/**
 * Card class represents the {@linkplain uno.Card} objects in UNO (+2,block,reverse).
 * It is an abstract class and have three subclasses: {@linkplain uno.ActionCard}, {@linkplain uno.NumberCard}, {@linkplain uno.WildCard}
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public abstract class Card {
	/**
	 * String color: Color of the {@linkplain uno.Card}
	 */
	protected String color;
	/**
	 * String type: Type of the {@linkplain uno.Card}
	 */
	protected String type;
	/**
	 * int score: Score value of the {@linkplain uno.Card}
	 */
	protected int score;
	/**
	 * Getter method for score.
	 * @return {@linkplain uno.Card#score}
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Setter method for {@linkplain uno.Card#score}.
	 * @param score int to set score.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * Getter method for color.
	 * @return {@linkplain uno.Card#color}
	 */
	public String getColor() {
		return color;
	}
	/**
	 * Setter method for {@linkplain uno.Card#color}.
	 * @param color String to set color.
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Getter method for type.
	 * @return {@linkplain uno.Card#type}
	 */
	public String getType() {
		return type;
	}
	/**
	 * Setter method for {@linkplain uno.Card#type}.
	 * @param type String to set type.
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Constructor to initialize {@linkplain uno.Card} objects.
	 * Since {@linkplain uno.Card} is an abstract class this constructor is used for subclasses.
	 * @param color String to initialize color.
	 * @param type String to initialize type.
	 */
	public Card(String color, String type) {
		this.color = color;
		this.type = type;
	}

	protected final static String COLOR_RED = "red";
	protected final static String COLOR_BLUE = "blue";
	protected final static String COLOR_GREEN = "green";
	protected final static String COLOR_YELLOW = "yellow";
	protected final static String NUMBER_0 = "0";
	protected final static String NUMBER_1 = "1";

	public String getCOLOR_RED() {
		return COLOR_RED;
	}

	public String getCOLOR_BLUE() {
		return COLOR_BLUE;
	}

	public String getCOLOR_GREEN() {
		return COLOR_GREEN;
	}

	public String getCOLOR_YELLOW() {
		return COLOR_YELLOW;
	}

	public String getNUMBER_0() {
		return NUMBER_0;
	}

	public String getNUMBER_1() {
		return NUMBER_1;
	}

	public String getNUMBER_2() {
		return NUMBER_2;
	}

	public String getNUMBER_3() {
		return NUMBER_3;
	}

	public String getNUMBER_4() {
		return NUMBER_4;
	}

	public String getNUMBER_5() {
		return NUMBER_5;
	}

	public String getNUMBER_6() {
		return NUMBER_6;
	}

	public String getNUMBER_7() {
		return NUMBER_7;
	}

	public String getNUMBER_8() {
		return NUMBER_8;
	}

	public String getNUMBER_9() {
		return NUMBER_9;
	}

	public String getACTION_BLOCK() {
		return ACTION_BLOCK;
	}

	public String getACTION_REVERSE() {
		return ACTION_REVERSE;
	}

	public String getACTION_PLUS2() {
		return ACTION_PLUS2;
	}

	public String getWILD_COLOR() {
		return WILD_COLOR;
	}

	public String getWILD_PLUS4() {
		return WILD_PLUS4;
	}

	public static String[] getCardColorList() {
		return cardColorList;
	}

	public static String[] getCardTypeList() {
		return cardTypeList;
	}

	public String toString() {
		return String.format("%s %s", this.getColor(), this.getType());
	}

	protected final static String NUMBER_2 = "2";
	protected final static String NUMBER_3 = "3";
	protected final static String NUMBER_4 = "4";
	protected final static String NUMBER_5 = "5";
	protected final static String NUMBER_6 = "6";
	protected final static String NUMBER_7 = "7";
	protected final static String NUMBER_8 = "8";
	protected final static String NUMBER_9 = "9";
	protected final static String ACTION_BLOCK = "B";
	protected final static String ACTION_REVERSE = "R";
	protected final static String ACTION_PLUS2 = "+2";
	protected final static String WILD_COLOR = "C";
	protected final static String WILD_PLUS4 = "+4";
	/**
	 * Color list of {@linkplain uno.Card} objects. It is initialized as "black" for {@linkplain uno.WildCard}
	 */
	public static final String[] cardColorList = { COLOR_RED, COLOR_BLUE, COLOR_GREEN, COLOR_YELLOW };
	/**
	 * Type list of {@linkplain uno.Card} objects.
	 */
	public static final String[] cardTypeList = { NUMBER_0, NUMBER_1, NUMBER_2, NUMBER_3, NUMBER_4, NUMBER_5, NUMBER_6,
			NUMBER_7, NUMBER_8, NUMBER_9, ACTION_BLOCK, ACTION_REVERSE, ACTION_PLUS2, WILD_COLOR, WILD_PLUS4 };
}
