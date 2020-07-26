import java.util.Scanner;

public class Prompter {

	private Game game;
	
	public Prompter(Game game) {
		this.game = game;
	}
	
	public boolean promptForGuess() {
		boolean isHit = false;
		Scanner input = new Scanner(System.in);
		boolean isAcceptable = false;
		
		do {
			System.out.print("Enter a letter:  ");
			String guessInput = input.nextLine();
			
			try {
				isHit = game.applyGuess(guessInput);
				isAcceptable = true;
			}catch(IllegalArgumentException iae ) {
				System.out.printf("%s. Please try again. %n", iae.getMessage());
			}
		}while(!isAcceptable);
		return isHit;
	}
	
	public void displayProgress() {
		System.out.printf("You have %d tries left. Try to solve this Hangman: %s%n", game.getRemainingTries(),game.getProgress());
	}
	
	public void displayOutcome() {
		if(game.isWon())
			System.out.printf("Congratulations you won with %d tries remaining.%n", game.getRemainingTries());
		else 
			System.out.printf("Bummer the word was %s.  :( %n",game.getAnswer());
	}

}
