package simpleRPS;

import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RockPaperSicssors {
	
	public static int yourScore = 0;
	public static int computerScore = 0;
	
	public static void main( String [] args) throws InterruptedException {
		Random random = new Random();
		Scanner scanner = new Scanner( System.in);
		String computerChoice;
		String userChoice;
		String winner;
		
		computerChoice = generateComputerChoice(random);
		showMenu();
		userChoice = getUserChoice(scanner);
		System.out.println("Your Choice: " + userChoice + "\nComputer chose: " + computerChoice);
		winner = winner(computerChoice, userChoice);
		if(winner.equalsIgnoreCase("computer")) {
			System.out.println("You lose!!");
			computerScore = computerScore + 1;
			TimeUnit.MILLISECONDS.sleep(70);
			System.out.println("Computer Score: " + computerScore + "\nYour Score: " + yourScore);
			TimeUnit.SECONDS.sleep(1);
			main(args);

			
		} else if(winner.equalsIgnoreCase("You")) {
			System.out.println("You Win!!");
			yourScore = yourScore +1;
			TimeUnit.MILLISECONDS.sleep(70);
			System.out.println("Computer Score: " + computerScore + "\nYour Score: " + yourScore);
			TimeUnit.SECONDS.sleep(1);
			
			main(args);


		}else if(winner.equalsIgnoreCase("Tie")) {
			System.out.println("Its a tie please try again");
			TimeUnit.MILLISECONDS.sleep(70);
			TimeUnit.SECONDS.sleep(1);
			main(args);
		}
		
		
		
		
		
		
		
		
	}
	
	public static String generateComputerChoice( Random random ) {
		int wordNumber;
		String computerChoice = "";
		wordNumber = random.nextInt( 3 ) + 1; 
		
		if (wordNumber == 1 )  {
			computerChoice = "Rock";
		}else if (wordNumber == 2 ){
			computerChoice = "Paper";
		}else if (wordNumber == 3) {
			computerChoice = "Scissors";
		}
		System.out.println("The computer has made its choice");
		return computerChoice;
	}

	public static void showMenu() {
		System.out.println( "1. Rock\n2. Paper\n3. Scissors" );
	}
	
	public static String getUserChoice( Scanner scanner ) throws InterruptedException {
		String userChoice = "";
		
	
		for(int correct = 0; correct == 0;) {
		System.out.println("Please, Make your choice");
		userChoice = scanner.nextLine(  );
		if(userChoice.equalsIgnoreCase("rock")) {
			userChoice = "rock";
			correct = 1;
		} else if(userChoice.equalsIgnoreCase("paper")) {
			userChoice = "paper";
			correct = 1;
		}else if(userChoice.equalsIgnoreCase("Scissors")) {
			userChoice = "scissors";
			correct = 1;
		}else {
			System.out.println("Not an option");
			correct = 0;
		}
	}
		
		
		return userChoice;
		
	}
	
	public static String winner( String computerChoice, String userChoice ) {
		String winner = "No winner";
		String customMessage = "";
		String rock = "Rock Brakes Scissors";
		String paper = "Paper Covers Rock";
		String scissors = "Scissors Cut Paper";
		String noWinner = "Its a tie!! Try again";
		
		if(computerChoice.equals("Rock") && userChoice.equalsIgnoreCase("scissors")) {
			winner = "Computer";
			customMessage = rock;
		} else if(computerChoice.equals("Scissors") && userChoice.equalsIgnoreCase("rock")) {
			winner = "You";
			customMessage = rock;
		}
		
		if(computerChoice.equals("Scissors") && userChoice.equalsIgnoreCase("paper")) {
			winner = "Computer";
			customMessage = scissors;
		} else if(computerChoice.equals("Paper") && userChoice.equalsIgnoreCase("scissors")) {
			winner = "You";
			customMessage = scissors;
		}
		
		if(computerChoice.equals("Paper") && userChoice.equalsIgnoreCase("rock")) {
			winner = "Computer";
			customMessage = paper;
		} else if(computerChoice.equals("Rock") && userChoice.equalsIgnoreCase("paper")) {
			winner = "You";
			customMessage = paper;
		}
		
		if(computerChoice.equals("Rock") && userChoice.equalsIgnoreCase("rock")) {
			winner = "Tie";
			customMessage = noWinner;
		} 
		
		if(computerChoice.equals("Paper") && userChoice.equalsIgnoreCase("paper")) {
			winner = "Tie";
			customMessage = noWinner;
		} 		
		
		if(computerChoice.equals("Scissors") && userChoice.equalsIgnoreCase("scissors")) {
			winner = "Tie";
			customMessage = noWinner;
		} 		
		return winner;
	}
}
