/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This class features a set of outputs that prompt the user to partake in a guessing game
 * in which the user guesses from a list of colors, and the program itself generates random numbers
 * that are then translated to random colors, and if the user guesses the correct color, then the program
 * awards them a point. This game goes for a total of 10 rounds, and the points are kept track of, as well as
 * how many incorrect guesses were made as well.
 * Due: 2/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Michael O'Connell
*/

package ESPGame;

import java.util.Scanner;
import java.util.Random;

public class ESPGame {
	
	public static void main(String[] args) {
		
		final String COLOR_RED = "Red";
		final String COLOR_ORANGE = "Orange";
		final String COLOR_YELLOW = "Yellow";
		final String COLOR_GREEN = "Green";
		final String COLOR_BLUE = "Blue";
		final String COLOR_INDIGO = "Indigo";
		final String COLOR_VIOLET = "Violet";
		
		String userName;
		String userDescription;
		String dueDate;
		int rightGuesses = 0;
		String randomColor = COLOR_RED;
		
		Scanner input = new Scanner(System.in); 
	    System.out.println("Enter your name: "); 
	    userName = input.nextLine(); 
	    System.out.println("Describe yourself: ");
	    userDescription = input.nextLine();
	    System.out.println("Due Date: ");
	    dueDate = input.nextLine();
	    System.out.println("CMSC203 Assignment1: Test your ESP skills!");
	    
	    
	    
	    for (int round = 1; round <= 10; round++)
	    {
	    	String guess = "";
	    	
	    	
	    	System.out.println("Round " + round);
	    	System.out.println();
	    	System.out.println("I am thinking of a color.");
	    	System.out.println("Is it Red, Orange, Yellow, Green, Blue, Indigo, or Violet?");
	    	System.out.println("Enter your guess: ");
	    	
	    	
	    	Random rand = new Random();
		    int upperbound = 7;
		    int int_random = rand.nextInt(upperbound);
		    

		    switch (int_random) {
		    case 0:
		    	randomColor = COLOR_RED;
		    	break;
		    case 1:
		    	randomColor = COLOR_ORANGE;
		    	break;
		    case 2:
		    	randomColor = COLOR_YELLOW;
		    	break;
		    case 3: 
		    	randomColor = COLOR_GREEN;
		    	break;
		    case 4:
		    	randomColor = COLOR_BLUE;
		    	break;
		    case 5:
		    	randomColor = COLOR_INDIGO;
		    	break;
		    case 6:
		    	randomColor = COLOR_VIOLET;
		    	break;
		    default: 
		    	System.out.println("SOMETHING WENT WRONG");
		    }
		    int int_color_input = -1;
		    
		    while (int_color_input == -1) {
		    	guess = input.nextLine();
		    	System.out.println();
		    
			    if (guess.equalsIgnoreCase(COLOR_RED)) {
			    	int_color_input = 0;
			    } else if (guess.equalsIgnoreCase(COLOR_ORANGE)) {
			    	int_color_input = 1;
			    } else if (guess.equalsIgnoreCase(COLOR_YELLOW)) {
			    	int_color_input = 2;
			    } else if (guess.equalsIgnoreCase(COLOR_GREEN)) {
			    	int_color_input = 3;
			    } else if (guess.equalsIgnoreCase(COLOR_BLUE)) {
			    	int_color_input = 4;
			    } else if (guess.equalsIgnoreCase(COLOR_INDIGO)) {
			    	int_color_input = 5;
			    } else if (guess.equalsIgnoreCase(COLOR_VIOLET)) {
			    	int_color_input = 6;
			    } else {
			    	System.out.println("You entered incorrect color. Is it Red, Green, Blue, Orange, or Yellow?");
			    	System.out.println("Enter your guess again:");
			    	System.out.println();
			    }
		    }
		    
		    
		    System.out.println("I was thinking of " + randomColor);
		    
		   // System.out.println("guess: " + guess); DEBUGGING
		   // System.out.println("randomColor: " + randomColor); DEBUGGING
		    
		    
		    if(int_color_input == int_random) {
		    	
		    	rightGuesses +=1;
		    }
		    //System.out.println("rightGuesses: " + rightGuesses); DEBUGGING
	    }
	    
	    System.out.println("Game Over");
	    System.out.println("You guessed " + rightGuesses +" out of 10 colors correctly");
	    System.out.println("User name: " + userName);
	    System.out.println("User description: " + userDescription);
	    System.out.println("Due Date: " + dueDate);
	    input.close();
	}
}
