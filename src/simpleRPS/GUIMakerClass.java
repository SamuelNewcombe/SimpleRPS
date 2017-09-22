package simpleRPS;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import audio.AudioMaster;
import simpleRPS.RockPaperSicssors;

public class GUIMakerClass {
	
	int test;
	
	static JFrame myFrame = new JFrame("My test App");
	
	JButton Rock = new JButton();
	JButton Paper = new JButton();
	JButton Scissors = new JButton();
	
	JPanel panel1 = new JPanel();
	static JPanel panel2 = new JPanel();
	static JPanel panel3 = new JPanel();
	
	static JLabel score = new JLabel();	
	static JLabel score2 = new JLabel();
	static JLabel score3 = new JLabel();
	
	
	public void createGUI() {
		Rock.setText("Rock");
		Paper.setText("Paper");
		Scissors.setText("Scissors");
	    

		
		GUIListener myListener = new GUIListener();
		Rock.addActionListener(myListener);
		Paper.addActionListener(myListener);
		Scissors.addActionListener(myListener);
		
		panel1.add(Rock);
		panel1.add(Paper);
		panel1.add(Scissors);
		panel1.setSize(100,50);
		
		panel2.setBorder(new TitledBorder("Score"));
		panel2.add(score);
		panel2.add(score2);
		
		panel3.add(score3);
		
		myFrame.add(panel1);
		myFrame.add(panel2);
		myFrame.add(panel3);
		myFrame.setSize(600,400);
		myFrame.setLocationRelativeTo(null);
		myFrame.setLayout(new GridLayout(3,5));
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		myFrame.setVisible(true);
		score3.setForeground(Color.blue);
		
		
	}
	 
	
	
	public class GUIListener implements ActionListener {
		@Override
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Rock) {
				RockPaperSicssors.userChoice = "Rock";
				try {
					winner();
					
					

				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}else if (e.getSource() == Paper) {	
				RockPaperSicssors.userChoice = "Paper";
				try {
					winner();
					

				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}else if (e.getSource() == Scissors ) {
				RockPaperSicssors.userChoice = "Scissors";
				try {
					winner();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				

				}
			
		}
				
	public final void winner() throws InterruptedException {
		System.out.println("Your Choice: " + RockPaperSicssors.userChoice + "\nComputer chose: " + RockPaperSicssors.computerChoice);
		RockPaperSicssors.winner = RockPaperSicssors.winner(RockPaperSicssors.computerChoice, RockPaperSicssors.userChoice);
		if(RockPaperSicssors.winner.equalsIgnoreCase("computer")) {
			score3.setText("You lose!!");
			score3.validate();
			score3.repaint();
				TimeUnit.SECONDS.sleep(1);
			RockPaperSicssors.computerScore = RockPaperSicssors.computerScore + 1;
				TimeUnit.MILLISECONDS.sleep(70);
			
			System.out.println("Computer Score: " + RockPaperSicssors.computerScore + "\nYour Score: " + RockPaperSicssors.yourScore);
			
			RockPaperSicssors.comp();

			
		} else if(RockPaperSicssors.winner.equalsIgnoreCase("You")) {
			score3.setText("You win!!");
			score3.validate();
			score3.repaint();
				TimeUnit.SECONDS.sleep(1);
			RockPaperSicssors.yourScore = RockPaperSicssors.yourScore +1;
				TimeUnit.MILLISECONDS.sleep(70);
			System.out.println("Computer Score: " + RockPaperSicssors.computerScore + "\nYour Score: " + RockPaperSicssors.yourScore);
			RockPaperSicssors.comp();

		}else if(RockPaperSicssors.winner.equalsIgnoreCase("Tie")) {
			score3.setText("Its a tie");
			score3.validate();
			score3.repaint();
				TimeUnit.SECONDS.sleep(1);
				TimeUnit.MILLISECONDS.sleep(70);
				TimeUnit.SECONDS.sleep(1);	
			RockPaperSicssors.comp();
			}
		}
	}
	
	public static void refresh() {
		score.setText("Your Score: " + RockPaperSicssors.yourScore);
		score2.setText("Computer Score: " + RockPaperSicssors.computerScore);
		score.validate();
		score.repaint();
		score2.validate();
		score2.repaint();

	}
	
}

		
		
		
	

		


