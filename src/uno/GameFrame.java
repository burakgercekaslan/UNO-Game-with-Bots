package uno;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * GameFrame represents the {@linkplain uno.UnoGame} in GUI and lets play the
 * game.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings({ "serial", "unused" })
public class GameFrame extends JFrame {
	private Timer gameLoopTimer;
	private JLabel discardPileLabel;
	private MenuFrame menu;
	private UnoGame game;
	/**
	 * JLabel represents how many cards left in {@linkplain uno.UnoGame#deck}
	 */
	private JLabel cardLeftLabel;
	/**
	 * JLabel represents the rotation by  {@linkplain uno.UnoGame#rotation}.
	 */
	private JLabel rotationLabel;
	private JLabel botLabel1;
	private JLabel botLabel2;
	private JLabel botLabel3;
	private JLabel botLabel4;
	private JLabel botLabel5;
	private JLabel botLabel6;
	private JLabel botLabel7;
	private JLabel botLabel8;
	private JLabel botLabel9;
	private String botLabelText;
	private JLabel errorLabel;
	/**
	 * HashMap of all botLabels. Key is Integer object that represents the botLabels' index. Value is spesific botLabel at given index. 
	 */
	private HashMap<Integer, JLabel> botLabels;
	/**
	 * HashMap of all buttons. Key is Integer object that represents the buttons' index. Value is spesific button at given index. 
	 */
	private HashMap<Integer, JButton> buttons;

	public Timer getGameLoopTimer() {
		return gameLoopTimer;
	}

	public void setGameLoopTimer(Timer gameLoopTimer) {
		this.gameLoopTimer = gameLoopTimer;
	}

	public UnoGame getGame() {
		return game;
	}

	public void setGame(UnoGame game) {
		this.game = game;
	}
	/**
	 * Constructor to load a playable GameFrame.
	 * 
	 * @param game UnoGame represents current game.
	 * @param menuFrame MenuFrame represents current menu.
	 * @throws InterruptedException
	 */
	public GameFrame(UnoGame game, MenuFrame menu) throws InterruptedException {
		this.game = game;
		this.menu = menu;
		this.buttons = new HashMap<Integer, JButton>();
		this.botLabels = new HashMap<Integer, JLabel>();
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(25, 20, 1500, 800);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton Card0 = new JButton("");
		buttons.put(0, Card0);
		Card0.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(0);
			}
		});
		Card0.setBounds(43, 600, 85, 153);
		getContentPane().add(Card0);

		JButton Card1 = new JButton("");
		buttons.put(1, Card1);
		Card1.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(1);
			}
		});
		Card1.setBounds(138, 600, 85, 153);
		getContentPane().add(Card1);

		JButton Card2 = new JButton("");
		buttons.put(2, Card2);
		Card2.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(2);
			}
		});
		Card2.setBounds(233, 600, 85, 153);
		getContentPane().add(Card2);

		JButton Card3 = new JButton("");
		Card3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(3);
			}
		});
		buttons.put(3, Card3);
		Card3.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card3.setBounds(328, 600, 85, 153);
		getContentPane().add(Card3);

		JButton Card4 = new JButton("");
		Card4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(4);
			}
		});
		buttons.put(4, Card4);
		Card4.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card4.setBounds(423, 600, 85, 153);
		getContentPane().add(Card4);

		JButton Card5 = new JButton("");
		Card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(5);
			}
		});
		buttons.put(5, Card5);
		Card5.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card5.setBounds(518, 600, 85, 153);
		getContentPane().add(Card5);

		JButton Card6 = new JButton("");
		Card6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(6);
			}
		});
		buttons.put(6, Card6);
		Card6.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card6.setBounds(613, 600, 85, 153);
		getContentPane().add(Card6);

		JButton Card7 = new JButton("");
		Card7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(7);
			}
		});
		buttons.put(7, Card7);
		Card7.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card7.setBounds(709, 600, 85, 153);
		getContentPane().add(Card7);

		JButton Card8 = new JButton("");
		Card8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(8);
			}
		});
		buttons.put(8, Card8);
		Card8.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card8.setBounds(804, 600, 85, 153);
		getContentPane().add(Card8);

		JButton Card9 = new JButton("");
		Card9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(9);
			}
		});
		buttons.put(9, Card9);
		Card9.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card9.setBounds(899, 600, 85, 153);
		getContentPane().add(Card9);

		JButton Card10 = new JButton("");
		Card10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(10);
			}
		});
		buttons.put(10, Card10);
		Card10.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card10.setBounds(994, 600, 85, 153);
		getContentPane().add(Card10);

		JButton Card11 = new JButton("");
		buttons.put(11, Card11);
		Card11.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(11);
			}
		});
		Card11.setBounds(1089, 600, 85, 153);
		getContentPane().add(Card11);

		JButton Card12 = new JButton("");
		Card12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(12);
			}
		});
		buttons.put(12, Card12);
		Card12.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card12.setBounds(1181, 600, 85, 153);
		getContentPane().add(Card12);

		JButton Card13 = new JButton("");
		buttons.put(13, Card13);
		Card13.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(13);
			}
		});
		Card13.setBounds(1276, 600, 85, 153);
		getContentPane().add(Card13);

		JButton Card14 = new JButton("");
		Card14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(14);
			}
		});
		buttons.put(14, Card14);
		Card14.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card14.setBounds(1371, 600, 85, 153);
		getContentPane().add(Card14);

		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(43, 495, 1036, 75);
		getContentPane().add(errorLabel);

		discardPileLabel = new JLabel("DCP");
		discardPileLabel.setFont(new Font("Tahoma", Font.BOLD, 80));
		discardPileLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		discardPileLabel.setBounds(470, 182, 183, 285);
		getContentPane().add(discardPileLabel);

		JLabel turnLabel = new JLabel("Bot               Card Number");
		turnLabel.setVerticalAlignment(SwingConstants.TOP);
		turnLabel.setHorizontalAlignment(SwingConstants.LEFT);
		turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		turnLabel.setBounds(1089, 10, 387, 47);
		getContentPane().add(turnLabel);

		botLabel1 = new JLabel("");
		botLabels.put(1, botLabel1);
		getContentPane().add(botLabel1);
		botLabel1.setVerticalAlignment(SwingConstants.TOP);
		botLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel1.setBounds(1089, 67, 387, 47);

		botLabel2 = new JLabel("");
		botLabels.put(2, botLabel2);
		botLabel2.setVerticalAlignment(SwingConstants.TOP);
		botLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel2.setBounds(1089, 124, 387, 47);
		getContentPane().add(botLabel2);

		botLabel3 = new JLabel("");
		botLabels.put(3, botLabel3);
		botLabel3.setVerticalAlignment(SwingConstants.TOP);
		botLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel3.setBounds(1089, 181, 387, 47);
		getContentPane().add(botLabel3);

		botLabel4 = new JLabel("");
		botLabels.put(4, botLabel4);
		botLabel4.setVerticalAlignment(SwingConstants.TOP);
		botLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel4.setBounds(1089, 238, 387, 47);
		getContentPane().add(botLabel4);

		botLabel5 = new JLabel("");
		botLabels.put(5, botLabel5);
		botLabel5.setVerticalAlignment(SwingConstants.TOP);
		botLabel5.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel5.setBounds(1089, 295, 387, 47);
		getContentPane().add(botLabel5);

		botLabel6 = new JLabel("");
		botLabels.put(6, botLabel6);
		botLabel6.setVerticalAlignment(SwingConstants.TOP);
		botLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel6.setBounds(1089, 352, 387, 47);
		getContentPane().add(botLabel6);

		botLabel7 = new JLabel("");
		botLabels.put(7, botLabel7);
		botLabel7.setVerticalAlignment(SwingConstants.TOP);
		botLabel7.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel7.setBounds(1089, 409, 387, 47);
		getContentPane().add(botLabel7);

		botLabel8 = new JLabel("");
		botLabels.put(8, botLabel8);
		botLabel8.setVerticalAlignment(SwingConstants.TOP);
		botLabel8.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel8.setBounds(1089, 466, 387, 47);
		getContentPane().add(botLabel8);

		botLabel9 = new JLabel("");
		botLabels.put(9, botLabel9);
		botLabel9.setVerticalAlignment(SwingConstants.TOP);
		botLabel9.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel9.setBounds(1089, 523, 387, 47);
		getContentPane().add(botLabel9);

		JButton drawButton = new JButton("Draw");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(29);
			}
		});
		drawButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		drawButton.setBounds(709, 370, 275, 115);
		getContentPane().add(drawButton);

		JButton Card16 = new JButton("");
		buttons.put(16, Card16);
		Card16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(16);
			}
		});
		Card16.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card16.setBounds(138, 10, 85, 153);
		getContentPane().add(Card16);

		JButton Card15 = new JButton("");
		buttons.put(15, Card15);
		Card15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(15);
			}
		});
		Card15.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card15.setBounds(43, 10, 85, 153);
		getContentPane().add(Card15);

		JButton Card17 = new JButton("");
		buttons.put(17, Card17);
		Card17.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card17.setBounds(233, 10, 85, 153);
		getContentPane().add(Card17);
		Card17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(17);
			}
		});

		JButton Card18 = new JButton("");
		buttons.put(18, Card18);
		Card18.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card18.setBounds(328, 10, 85, 153);
		getContentPane().add(Card18);
		Card18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(18);
			}
		});

		JButton Card19 = new JButton("");
		buttons.put(19, Card19);
		Card19.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card19.setBounds(423, 10, 85, 153);
		getContentPane().add(Card19);
		Card19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(19);
			}
		});

		JButton Card20 = new JButton("");
		buttons.put(20, Card20);
		Card20.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card20.setBounds(518, 10, 85, 153);
		getContentPane().add(Card20);
		Card20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(20);
			}
		});

		JButton Card21 = new JButton("");
		buttons.put(21, Card21);
		Card21.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card21.setBounds(613, 10, 85, 153);
		getContentPane().add(Card21);
		Card21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(21);
			}
		});

		JButton Card22 = new JButton("");
		buttons.put(22, Card22);
		Card22.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card22.setBounds(709, 10, 85, 153);
		getContentPane().add(Card22);
		Card22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(22);
			}
		});

		JButton Card23 = new JButton("");
		buttons.put(23, Card23);
		Card23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(23);
			}
		});
		Card23.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card23.setBounds(804, 10, 85, 153);
		getContentPane().add(Card23);

		JButton Card24 = new JButton("");
		buttons.put(24, Card24);
		Card24.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card24.setBounds(899, 10, 85, 153);
		getContentPane().add(Card24);
		Card24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(24);
			}
		});

		JButton Card26 = new JButton("");
		buttons.put(26, Card26);
		Card26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(26);
			}
		});
		Card26.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card26.setBounds(138, 173, 85, 153);
		getContentPane().add(Card26);

		JButton Card27 = new JButton("");
		buttons.put(27, Card27);
		Card27.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card27.setBounds(233, 173, 85, 153);
		getContentPane().add(Card27);
		Card27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(27);
			}
		});

		JButton Card28 = new JButton("");
		buttons.put(28, Card28);
		Card28.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card28.setBounds(328, 173, 85, 153);
		getContentPane().add(Card28);
		Card28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(28);
			}
		});

		JButton Card25 = new JButton("");
		buttons.put(25, Card25);
		Card25.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card25.setBounds(43, 173, 85, 153);
		getContentPane().add(Card25);

		JButton drawButton_1 = new JButton("MENU");
		drawButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameMenuFrame(game.getUser(), GameFrame.this);
			}
		});
		drawButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		drawButton_1.setBounds(233, 342, 180, 137);
		getContentPane().add(drawButton_1);

		JButton unoButton = new JButton("UNO");
		unoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((game.getUser().getDeckOfPlayer().size() == 2) && (game.getPlayers()
						.get(Math.floorMod(game.getTurn(), game.getPlayers().size())).equals(game.getUser()))) {
					game.setUno(true);
				} else {
					errorLabel.setText("You cannot say uno now!");
					errorLabel.setForeground(Color.RED);
				}
			}
		});
		unoButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		unoButton.setBounds(43, 342, 180, 137);
		getContentPane().add(unoButton);

		cardLeftLabel = new JLabel("Card Left:");
		cardLeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		cardLeftLabel.setBounds(709, 182, 275, 75);
		getContentPane().add(cardLeftLabel);

		rotationLabel = new JLabel("Rotation:");
		rotationLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		rotationLabel.setBounds(709, 267, 275, 75);
		getContentPane().add(rotationLabel);
		Card25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(25);
			}
		});
		menu.setVisible(false);
		updatePlayerDeck(game.getUser());
		updateBotLabel();
		updateDiscardPile();
		startGameLoop();
	}

	/**
	 * Constructor to initialize a playable GameFrame.
	 * 
	 * @param user      User represents user of the game.
	 * @param botNumber int represents botNumber
	 * @param menu      MenuFrame represents the menu.
	 * @throws InterruptedException
	 */
	public GameFrame(User user, int botNumber, MenuFrame menu) throws InterruptedException {
		this.game = new UnoGame(user, botNumber);
		this.menu = menu;
		this.buttons = new HashMap<Integer, JButton>();
		this.botLabels = new HashMap<Integer, JLabel>();
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(25, 20, 1500, 800);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton Card0 = new JButton("");
		buttons.put(0, Card0);
		Card0.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(0);
			}
		});
		Card0.setBounds(43, 600, 85, 153);
		getContentPane().add(Card0);

		JButton Card1 = new JButton("");
		buttons.put(1, Card1);
		Card1.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(1);
			}
		});
		Card1.setBounds(138, 600, 85, 153);
		getContentPane().add(Card1);

		JButton Card2 = new JButton("");
		buttons.put(2, Card2);
		Card2.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(2);
			}
		});
		Card2.setBounds(233, 600, 85, 153);
		getContentPane().add(Card2);

		JButton Card3 = new JButton("");
		Card3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(3);
			}
		});
		buttons.put(3, Card3);
		Card3.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card3.setBounds(328, 600, 85, 153);
		getContentPane().add(Card3);

		JButton Card4 = new JButton("");
		Card4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(4);
			}
		});
		buttons.put(4, Card4);
		Card4.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card4.setBounds(423, 600, 85, 153);
		getContentPane().add(Card4);

		JButton Card5 = new JButton("");
		Card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(5);
			}
		});
		buttons.put(5, Card5);
		Card5.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card5.setBounds(518, 600, 85, 153);
		getContentPane().add(Card5);

		JButton Card6 = new JButton("");
		Card6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(6);
			}
		});
		buttons.put(6, Card6);
		Card6.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card6.setBounds(613, 600, 85, 153);
		getContentPane().add(Card6);

		JButton Card7 = new JButton("");
		Card7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(7);
			}
		});
		buttons.put(7, Card7);
		Card7.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card7.setBounds(709, 600, 85, 153);
		getContentPane().add(Card7);

		JButton Card8 = new JButton("");
		Card8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(8);
			}
		});
		buttons.put(8, Card8);
		Card8.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card8.setBounds(804, 600, 85, 153);
		getContentPane().add(Card8);

		JButton Card9 = new JButton("");
		Card9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(9);
			}
		});
		buttons.put(9, Card9);
		Card9.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card9.setBounds(899, 600, 85, 153);
		getContentPane().add(Card9);

		JButton Card10 = new JButton("");
		Card10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(10);
			}
		});
		buttons.put(10, Card10);
		Card10.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card10.setBounds(994, 600, 85, 153);
		getContentPane().add(Card10);

		JButton Card11 = new JButton("");
		buttons.put(11, Card11);
		Card11.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(11);
			}
		});
		Card11.setBounds(1089, 600, 85, 153);
		getContentPane().add(Card11);

		JButton Card12 = new JButton("");
		Card12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(12);
			}
		});
		buttons.put(12, Card12);
		Card12.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card12.setBounds(1181, 600, 85, 153);
		getContentPane().add(Card12);

		JButton Card13 = new JButton("");
		buttons.put(13, Card13);
		Card13.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(13);
			}
		});
		Card13.setBounds(1276, 600, 85, 153);
		getContentPane().add(Card13);

		JButton Card14 = new JButton("");
		Card14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(14);
			}
		});
		buttons.put(14, Card14);
		Card14.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card14.setBounds(1371, 600, 85, 153);
		getContentPane().add(Card14);

		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 65));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setBounds(43, 495, 1036, 75);
		getContentPane().add(errorLabel);

		discardPileLabel = new JLabel("DCP");
		discardPileLabel.setFont(new Font("Tahoma", Font.BOLD, 80));
		discardPileLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		discardPileLabel.setBounds(470, 182, 183, 285);
		getContentPane().add(discardPileLabel);

		JLabel turnLabel = new JLabel("Bot               Card Number");
		turnLabel.setVerticalAlignment(SwingConstants.TOP);
		turnLabel.setHorizontalAlignment(SwingConstants.LEFT);
		turnLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		turnLabel.setBounds(1089, 10, 387, 47);
		getContentPane().add(turnLabel);

		botLabel1 = new JLabel("");
		botLabels.put(1, botLabel1);
		getContentPane().add(botLabel1);
		botLabel1.setVerticalAlignment(SwingConstants.TOP);
		botLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel1.setBounds(1089, 67, 387, 47);

		botLabel2 = new JLabel("");
		botLabels.put(2, botLabel2);
		botLabel2.setVerticalAlignment(SwingConstants.TOP);
		botLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel2.setBounds(1089, 124, 387, 47);
		getContentPane().add(botLabel2);

		botLabel3 = new JLabel("");
		botLabels.put(3, botLabel3);
		botLabel3.setVerticalAlignment(SwingConstants.TOP);
		botLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel3.setBounds(1089, 181, 387, 47);
		getContentPane().add(botLabel3);

		botLabel4 = new JLabel("");
		botLabels.put(4, botLabel4);
		botLabel4.setVerticalAlignment(SwingConstants.TOP);
		botLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel4.setBounds(1089, 238, 387, 47);
		getContentPane().add(botLabel4);

		botLabel5 = new JLabel("");
		botLabels.put(5, botLabel5);
		botLabel5.setVerticalAlignment(SwingConstants.TOP);
		botLabel5.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel5.setBounds(1089, 295, 387, 47);
		getContentPane().add(botLabel5);

		botLabel6 = new JLabel("");
		botLabels.put(6, botLabel6);
		botLabel6.setVerticalAlignment(SwingConstants.TOP);
		botLabel6.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel6.setBounds(1089, 352, 387, 47);
		getContentPane().add(botLabel6);

		botLabel7 = new JLabel("");
		botLabels.put(7, botLabel7);
		botLabel7.setVerticalAlignment(SwingConstants.TOP);
		botLabel7.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel7.setBounds(1089, 409, 387, 47);
		getContentPane().add(botLabel7);

		botLabel8 = new JLabel("");
		botLabels.put(8, botLabel8);
		botLabel8.setVerticalAlignment(SwingConstants.TOP);
		botLabel8.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel8.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel8.setBounds(1089, 466, 387, 47);
		getContentPane().add(botLabel8);

		botLabel9 = new JLabel("");
		botLabels.put(9, botLabel9);
		botLabel9.setVerticalAlignment(SwingConstants.TOP);
		botLabel9.setHorizontalAlignment(SwingConstants.LEFT);
		botLabel9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		botLabel9.setBounds(1089, 523, 387, 47);
		getContentPane().add(botLabel9);

		JButton drawButton = new JButton("Draw");
		drawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(29);
			}
		});
		drawButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		drawButton.setBounds(709, 370, 275, 115);
		getContentPane().add(drawButton);

		JButton Card16 = new JButton("");
		buttons.put(16, Card16);
		Card16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(16);
			}
		});
		Card16.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card16.setBounds(138, 10, 85, 153);
		getContentPane().add(Card16);

		JButton Card15 = new JButton("");
		buttons.put(15, Card15);
		Card15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(15);
			}
		});
		Card15.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card15.setBounds(43, 10, 85, 153);
		getContentPane().add(Card15);

		JButton Card17 = new JButton("");
		buttons.put(17, Card17);
		Card17.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card17.setBounds(233, 10, 85, 153);
		getContentPane().add(Card17);
		Card17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(17);
			}
		});

		JButton Card18 = new JButton("");
		buttons.put(18, Card18);
		Card18.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card18.setBounds(328, 10, 85, 153);
		getContentPane().add(Card18);
		Card18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(18);
			}
		});

		JButton Card19 = new JButton("");
		buttons.put(19, Card19);
		Card19.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card19.setBounds(423, 10, 85, 153);
		getContentPane().add(Card19);
		Card19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(19);
			}
		});

		JButton Card20 = new JButton("");
		buttons.put(20, Card20);
		Card20.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card20.setBounds(518, 10, 85, 153);
		getContentPane().add(Card20);
		Card20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(20);
			}
		});

		JButton Card21 = new JButton("");
		buttons.put(21, Card21);
		Card21.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card21.setBounds(613, 10, 85, 153);
		getContentPane().add(Card21);
		Card21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(21);
			}
		});

		JButton Card22 = new JButton("");
		buttons.put(22, Card22);
		Card22.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card22.setBounds(709, 10, 85, 153);
		getContentPane().add(Card22);
		Card22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(22);
			}
		});

		JButton Card23 = new JButton("");
		buttons.put(23, Card23);
		Card23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(23);
			}
		});
		Card23.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card23.setBounds(804, 10, 85, 153);
		getContentPane().add(Card23);

		JButton Card24 = new JButton("");
		buttons.put(24, Card24);
		Card24.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card24.setBounds(899, 10, 85, 153);
		getContentPane().add(Card24);
		Card24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(24);
			}
		});

		JButton Card26 = new JButton("");
		buttons.put(26, Card26);
		Card26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(26);
			}
		});
		Card26.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card26.setBounds(138, 173, 85, 153);
		getContentPane().add(Card26);

		JButton Card27 = new JButton("");
		buttons.put(27, Card27);
		Card27.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card27.setBounds(233, 173, 85, 153);
		getContentPane().add(Card27);
		Card27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(27);
			}
		});

		JButton Card28 = new JButton("");
		buttons.put(28, Card28);
		Card28.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card28.setBounds(328, 173, 85, 153);
		getContentPane().add(Card28);
		Card28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(28);
			}
		});

		JButton Card25 = new JButton("");
		buttons.put(25, Card25);
		Card25.setFont(new Font("Tahoma", Font.BOLD, 35));
		Card25.setBounds(43, 173, 85, 153);
		getContentPane().add(Card25);

		JButton drawButton_1 = new JButton("MENU");
		drawButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GameMenuFrame(user, GameFrame.this);
			}
		});
		drawButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		drawButton_1.setBounds(233, 342, 180, 137);
		getContentPane().add(drawButton_1);

		JButton unoButton = new JButton("UNO");
		unoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((game.getUser().getDeckOfPlayer().size() == 2) && (game.getPlayers()
						.get(Math.floorMod(game.getTurn(), game.getPlayers().size())).equals(game.getUser()))) {
					game.setUno(true);
				} else {
					errorLabel.setText("You cannot say uno now!");
					errorLabel.setForeground(Color.RED);
				}
			}
		});
		unoButton.setFont(new Font("Tahoma", Font.BOLD, 60));
		unoButton.setBounds(43, 342, 180, 137);
		getContentPane().add(unoButton);

		cardLeftLabel = new JLabel("Card Left:");
		cardLeftLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		cardLeftLabel.setBounds(709, 182, 275, 75);
		getContentPane().add(cardLeftLabel);

		rotationLabel = new JLabel("Rotation:");
		rotationLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		rotationLabel.setBounds(709, 267, 275, 75);
		getContentPane().add(rotationLabel);
		Card25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playCardOnButtonPress(25);
			}
		});
		menu.setVisible(false);
		updatePlayerDeck(user);
		updateBotLabel();
		updateDiscardPile();
		errorLabel.setText("Users' turn!");
		errorLabel.setForeground(Color.BLUE);
		startGameLoop();
	}
	/**
	 * Update {@linkplain uno.UnoGame#user} objects' deck in GUI.
	 * @param user User represents the user of the game.
	 */
	private void updatePlayerDeck(User user) {
		for (int k = 0; k < 29; k++) {
			buttons.get(k).setVisible(false);
		}
		int i = 0;
		for (Card card : user.getDeckOfPlayer()) {
			JButton button = buttons.get(i);
			button.setVisible(true);
			button.setText(card.getType());
			if (card.getColor().equals("yellow")) {
				button.setBackground(Color.YELLOW);
				button.setForeground(Color.BLACK);
			} else if (card.getColor().equals("green")) {
				button.setBackground(Color.GREEN);
				button.setForeground(Color.BLACK);
			} else if (card.getColor().equals("red")) {
				button.setBackground(Color.RED);
				button.setForeground(Color.BLACK);
			} else if (card.getColor().equals("blue")) {
				button.setBackground(Color.BLUE);
				button.setForeground(Color.BLACK);
			} else {
				button.setBackground(Color.BLACK);
				button.setForeground(Color.WHITE);
			}
			i++;
		}
		for (int j = i; j < 15; j++) {
			JButton button = buttons.get(i);
			button.setText("");
			button.setBackground(new Color(240, 240, 240));
			button.setVisible(false);
		}
	}
	/**
	 * Updates {@linkplain uno.UnoGame#discardPile} in GUI.
	 */
	public void updateDiscardPile() {
		Card card = game.getDiscardPile().lastElement();
		discardPileLabel.setText(card.getType());
		if (card.getColor().equals("yellow")) {
			discardPileLabel.setForeground(Color.YELLOW);
		} else if (card.getColor().equals("green")) {
			discardPileLabel.setForeground(Color.GREEN);
		} else if (card.getColor().equals("red")) {
			discardPileLabel.setForeground(Color.RED);
		} else if (card.getColor().equals("blue")) {
			discardPileLabel.setForeground(Color.BLUE);
		} else {
			discardPileLabel.setForeground(Color.BLACK);
		}
	}
	/**
	 * Updates {@linkplain uno.GameFrame#botLabels} in GUI.
	 */
	public void updateBotLabel() {
		for (int i = 1; i < 10; i++) {
			if (i > game.getBots().size()) {
				return;
			} else {
				JLabel currentLabel = botLabels.get(i);
				int x = 25 - game.getBots().get(i - 1).getUsername().length();
				currentLabel.setText(game.getBots().get(i - 1).getUsername() + " ".repeat(x)
						+ game.getBots().get(i - 1).getDeckOfPlayer().size());
			}
		}
	}
	/**
	 * Stars the {@linkplain uno.GameFrame#gameLoopTimer} while it is not {@linkplain uno.UnoGame#user}'s turn. Plays bot turn in each 1500 ms.
	 * When it is {@linkplain uno.UnoGame#user}'s turn, {@linkplain uno.GameFrame#gameLoopTimer} stops.
	 * After each 1500 ms, it updates GUI.
	 */
	private void startGameLoop() {
		gameLoopTimer = new Timer(1500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getWinner() != null) {
					errorLabel.setForeground(Color.RED);
					SaveLoad.handleGameOver(game);
					errorLabel.setText("Game is finished! " + game.getPlayers()
							.get(Math.floorMod(game.getTurn() - game.getRotation(), game.getPlayers().size()))
							.getUsername() + " win!");
					try {
						game.getOut().write("Game is finished! " + game.getPlayers()
						.get(Math.floorMod(game.getTurn() - game.getRotation(), game.getPlayers().size()))
						.getUsername() + " win!");
						game.getOut().newLine();
						game.getOut().flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					game.updateUserScore();
					if (game.getWinner() instanceof User) {
						menu.getLabel().setText(String.format("Congratulations %s! You win! New Score:%d",
								game.getUser().getUsername(), game.getUser().getScore()));
						menu.getLabel().setForeground(Color.GREEN);
					} else {
						menu.getLabel()
								.setText("Game is finished! " + game.getPlayers().get(
										Math.floorMod(game.getTurn() - game.getRotation(), game.getPlayers().size()))
										.getUsername() + " win!");
						menu.getLabel().setForeground(Color.GREEN);
					}
					updateVisuals();
					menu.setVisible(true);
					dispose();
					((Timer) e.getSource()).stop();
					return;
				}
				if (game.getPlayers().get(Math.floorMod(game.getTurn(), game.getPlayers().size())) instanceof User
						&& (game.isSkipNext() == false)) {
					errorLabel.setForeground(Color.BLUE);
					errorLabel.setText("Users' turn!");
					((Timer) e.getSource()).stop();
					return;
				} else if (game.getPlayers()
						.get(Math.floorMod(game.getTurn(), game.getPlayers().size())) instanceof User
						&& game.isSkipNext()) {
					game.setTurn(game.getTurn() + game.getRotation());
					game.setSkipNext(false);
					errorLabel.setText("Your turn skipped.");
					errorLabel.setForeground(Color.RED);
					try {
						game.getOut().write("Your turn skipped.");
						game.getOut().newLine();
						game.getOut().flush();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					botPlay();
				}
				updateVisuals();
			}
		});
		gameLoopTimer.start();
		updateVisuals();
	}
	/**
	 * Play method of {@linkplain uno.Bot} objects. 
	 * Updates {@linkplain uno.UnoGame#turn}, {@linkplain uno.UnoGame#rotation}, {@linkplain uno.UnoGame#skipNext} if needed.
	 */
	private void botPlay() {
		Bot bot = (Bot) game.getPlayers().get(Math.floorMod(game.getTurn(), game.getPlayers().size()));
		game.play(bot, game.getDiscardPile().lastElement());
		errorLabel.setText(bot.getUsername() + " played.");
		errorLabel.setForeground(Color.BLACK);
		updateVisuals();
		if (game.getPlayers().get(Math.floorMod(game.getTurn(), game.getPlayers().size())).getDeckOfPlayer()
				.size() == 0) {
			return;
		}
	}
	/**
	 * Methot to pla {@linkplain uno.UnoGame#user}'s turn when a button in {@linkplain uno.GameFrame#buttons} clicked.
	 * After {@linkplain uno.UnoGame#user}'s turn, this method calls {@linkplain uno.GameFrame#startGameLoop()}
	 * @param cardIndex Int represents the clicked buttons' index.
	 * 
	 */
	private void playCardOnButtonPress(int cardIndex) {
		if (game.getPlayers().get(Math.floorMod(game.getTurn(), game.getPlayers().size())) == game.getUser()) {
			if (cardIndex == 29) {
				game.drawCard(game.getUser(), 1);
				try {
					game.getOut().write(game.getUser().getUsername() + " draw 1.");
					game.getOut().newLine();
					game.getOut().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				game.setTurn(game.getTurn() + game.getRotation());
				updateVisuals();
				startGameLoop();
			} else {
				User user = game.getUser();
				if (user.getDeckOfPlayer().size() <= cardIndex) {
					errorLabel.setText("No card in this slot!");
					errorLabel.setForeground(Color.RED);
					return;
				}
				Card cardToPlay = user.getDeckOfPlayer().get(cardIndex);
				if (game.canPlay(cardToPlay, game.getDiscardPile().lastElement())) {
					if (!(game.getUser().getDeckOfPlayer().size() == 2)
							| ((game.getUser().getDeckOfPlayer().size() == 2) && game.isUno())) {
						if (!(cardToPlay instanceof WildCard)) {
							user.setCardToPlay(cardToPlay);
							game.play(user, cardToPlay, game.getDiscardPile().lastElement());
							game.setUno(false);
							updateVisuals();
							startGameLoop();
						} else {
							ColorChooseFrame colorFrame = new ColorChooseFrame(this, (WildCard) cardToPlay);
						}
					} else {
						try {
							game.getOut().write("You fool! You did not said uno!!!");
							game.getOut().newLine();
							game.getOut().flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
						game.drawCard(user, 2);
						game.setTurn(game.getTurn() + game.getRotation());
						errorLabel.setText("You fool! You did not said uno!!!");
						errorLabel.setForeground(Color.RED);
						updateVisuals();
						startGameLoop();
					}
				} else {
					errorLabel.setText("You cannot play this card!");
					errorLabel.setForeground(Color.RED);
				}
			}
		} else {
			errorLabel.setText("It is not your turn!");
			errorLabel.setForeground(Color.RED);
		}
	}
	/**
	 * Method to update GUI. It calls {@linkplain uno.GameFrame#updateBotLabel()}, {@linkplain uno.GameFrame#updateDiscardPile()}, {@linkplain uno.GameFrame#updatePlayerDeck(User)},{@linkplain uno.GameFrame#updateLabels()} 
	 */
	private void updateVisuals() {
		updateBotLabel();
		updateDiscardPile();
		updatePlayerDeck(game.getUser());
		updateLabels();
	}
	/**
	 * Updates {@linkplain uno.GameFrame#rotationLabel} and {@linkplain uno.GameFrame#cardLeftLabel} in GUI.
	 */
	private void updateLabels() {
		if (game.getRotation() == 1) {
			rotationLabel.setText("Rotation:CCW");
		} else {
			rotationLabel.setText("Rotation:CW");
		}
		cardLeftLabel.setText(Integer.toString(game.getDeck().size()));
	}
	/**
	 * Method to handle {@linkplain uno.WildCard} objects' play. It calls {@linkplain uno.GameFrame#startGameLoop()} afterwards.
	 * @param color String represents chosen color in {@linkplain uno.ColorChooseFrame}.
	 * @param cardToPlay {@linkplain uno.Card} object represents the chosen card to play.
	 */
	public void handleChosenColor(String color, Card cardToPlay) {
		if (cardToPlay.getType() == "C") {
			cardToPlay.setColor(color);
			game.getUser().getDeckOfPlayer().remove(cardToPlay);
			game.getDiscardPile().add(cardToPlay);
			try {
				game.getOut().write(String.format("Player: %s : Played Card:%s  :  Player Deck: %s", game.getUser().getUsername(),
						cardToPlay, game.getUser().getDeckOfPlayer()));
				game.getOut().newLine();
				game.getOut().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			game.setTurn(game.getTurn() + game.getRotation());
			updateVisuals();
			startGameLoop();
		} else {
			cardToPlay.setColor(color);
			game.getUser().getDeckOfPlayer().remove(cardToPlay);
			game.getDiscardPile().add(cardToPlay);
			game.setSkipNext(true);
			game.drawCard(game.getPlayers()
					.get(Math.floorMod((game.getTurn() + game.getRotation()), game.getPlayers().size())), 4);
			try {
				game.getOut().write(String.format("Player: %s : Played Card:%s  :  Player Deck: %s", game.getUser().getUsername(),
						cardToPlay, game.getUser().getDeckOfPlayer()));
				game.getOut().newLine();
				game.getOut().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			game.setTurn(game.getTurn() + game.getRotation());
			updateVisuals();
			startGameLoop();
		}
	}

	public void stopTimer() {
		gameLoopTimer.stop();
	}

	public void startTimer() {
		gameLoopTimer.start();
	}
}
