/*
 * GEE
 * This is free and unencumbered software released into the public domain.
 */
package gee_lab2;

/**
 * The Dice Game program represents a loaded six-sided dice with an increased
 * probability of rolling a certain face. The user takes turns to play against
 * the computer.
 *
 * @author Gee
 * @version 1.0
 */

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {

        //Create scanner object to take in user input
        Scanner scanner = new Scanner(System.in);

        //Print out welcome message and introduction
        System.out.println("Welcome! This is a game of you versus the computer."
                            + " We will each have one die.");
        System.out.println("We roll our own die, and the higher number wins."
                            + " We roll ten times, and");
        System.out.println("the one with the higher number of wins is the"
                            + " grand winner.\n");

        // Use a boolean flag to control whether the game continues
        boolean playAgain = true;

        /**
         * Executes the dice game until the user decides not to play again.
         * Keeps track of wins for both the computer and the user, displaying
         * results after each round.
         */
        while (playAgain) {

            // The counter for computer wins in a single game iteration.
            int computerWins = 0;

            // Count the number of user victories in a single game iteration.
            int userWins = 0;

            //This is an edit after submission and looking at the comments
            int ties = 0;

            // Play 10 rounds of the game
            for (int round = 1; round <= 10; round++) {
                System.out.println("Roll " + round + " of 10:");

                // Computer's turn
                LoadedDie computerDie = new LoadedDie(6,30);
                int computerRoll = computerDie.roll();
                System.out.println("Computer rolled a " + computerRoll);

                // User's turn
                System.out.println("Ready to roll? (Press ENTER when ready)");
                scanner.nextLine();

                LoadedDie userDie = new LoadedDie(1,30);
                int userRoll = userDie.roll();
                System.out.println("You rolled a " + userRoll
                );

                // Determine the winner of the round
                if (computerRoll > userRoll) {
                    computerWins++;
                } else if (userRoll > computerRoll) {
                    userWins++;
                } else  {
                    //it's a tie
                    ties++;
                    System.out.println("It's a tie!\n");
                }

                System.out.println();
            }

            // Display results after 10 rounds
            System.out.println("I won " + computerWins + " times.");
            System.out.println("You won " + userWins + " times.");
            System.out.println("Ties: " + ties);

            // Determine and display the grand winner
            if (computerWins > userWins) {
                System.out.println("Grand winner is me!\n");
            } else if (userWins > computerWins) {
                System.out.println("Grand winner is you!\n");
            } else {
                System.out.println("It's an overall tie!\n");
            }

            // Ask the user if they want to play again
            System.out.println("Ready to play? (no to quit)");
            String userInput = scanner.nextLine().toLowerCase();

            playAgain = !userInput.equals("no");

            if (!playAgain) {
                System.out.println("\nThanks for playing!\n");
            }
        }
    }
}
