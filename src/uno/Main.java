package uno;

import java.security.SecureRandom;
import java.util.ArrayList;
/**
 * Main class to start the game.
 * 
 * @author Burak Gerçekaslan
 * @version 1.0
 * @since 2024-05-15
 */
@SuppressWarnings("unused")
public class Main {
	/**
	 * Method that calls {@linkplain uno.UserLoginInfo#readUserLoginInfo()} and initializes {@linkplain uno.LogInFrame}
	 * @param args String[] arguments if needed to initialize variables.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		/**************
		 * Pledge of Honor ****************************************** I hereby certify
		 * that I have completed this programming project on my own without any help
		 * from anyone else. The effort in the project thus belongs completely to me. I
		 * did not search for a solution, or I did not consult any program written by
		 * others or did not copy any program from other sources. I read and followed
		 * the guidelines provided in the project description. READ AND SIGN BY WRITING
		 * YOUR NAME SURNAME AND STUDENT ID SIGNATURE: Burak Gerçekaslan, 83583
		 *************************************************************************/
		UserLoginInfo.readUserLoginInfo(); // reads the user login data.
		LogInFrame login = new LogInFrame(); // opens login screen.
	}
}
