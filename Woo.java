/* GoodNeighbor
   Driver class
*/

import cs1.Keyboard;
public class Woo{

    //instance variables
    //private boolean levelOver;
    static final String ANSI_CLS = "\u001b[2J";
    static final String ANSI_HOME = "\u001b[H";

    public static void play(Jake player) {

	for(int i = 1; i <= 3; i++) { //goes through three days
	    CallCenter dayEvents = new CallCenter(i);
	    dayEvents.startLv(dayEvents, player);

	    if (Jake.score < 100 * i) {
		levelOver();
		System.out.println("You did not pass this level. Must replay.");
		i -= 1;
	    }
	    System.out.println("Type 'q' to quit, SPACE to keep going.");
	    String userIn = Keyboard.readString().toLowerCase();
	    if (userIn.equals("q")) {
		gameOver();
		return;
	    }
	}
    }

    public static void levelOver() {
	System.out.print(ANSI_CLS + ANSI_HOME);
	System.out.flush();
	System.out.println("Level Over.\n\nCurrent Score: " + Jake.score);
    }

    public static void gameOver() {
	System.out.print(ANSI_CLS + ANSI_HOME);
	System.out.flush();
	System.out.println("GAME OVER!\n\nScore: " + Jake.score);
    }

    public static void main(String[] args){
	Jake fromStateFarm = new Jake();
	System.out.print(ANSI_CLS + ANSI_HOME);
	System.out.flush();
	play(fromStateFarm);
    }


}
