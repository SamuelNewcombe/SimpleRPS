package simpleRPS;

import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


public class RockPaperSicssors {
	
	public static int yourScore = 0;
	public static int computerScore = 0;
	public static String userChoice = "";
	public static String computerChoice;
	public static String winner;
	

	
	public static void main( String [] args) throws InterruptedException {
		test();
		GUIMakerClass myGUI = new GUIMakerClass();		
		myGUI.createGUI();
		
	}
	
	public static void test() {
		Random random = new Random();
		computerChoice = generateComputerChoice(random);
		
		GUIMakerClass.refresh();
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
		
	
		for(Boolean correct = false; correct == false;) {
		System.out.println("Please, Make your choice");
		userChoice = scanner.nextLine(  );
		if(userChoice.equalsIgnoreCase("rock")) {
			userChoice = "rock";
			correct = true;
		} else if(userChoice.equalsIgnoreCase("paper")) {
			userChoice = "paper";
			correct = true;
		}else if(userChoice.equalsIgnoreCase("Scissors")) {
			userChoice = "scissors";
			correct = true;
		}else {
			System.out.println("Not an option");
			correct = false;
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
