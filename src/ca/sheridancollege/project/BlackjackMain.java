/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
/**
 *
 * @author Julian Mastalerz
 */
public class BlackjackMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to Blackjack! ===");

        // Initialize the game
        BlackjackGame game = new BlackjackGame();

        // Get number of players
        int numPlayers = 0;
        while (true) {
            System.out.print("Enter number of players: ");
            try {
                numPlayers = Integer.parseInt(scanner.nextLine());
                if (numPlayers < 1) {
                    System.out.println("There must be at least one player.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Get player names
        for (int i = 1; i <= numPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            BlackjackPlayer player = new BlackjackPlayer(name, false);
            game.addPlayer(player);
        }

        boolean playAgain = true;
        while (playAgain) {
            game.play();
            game.declareWinner();

            // Ask if players want to play again
            System.out.print("\nDo you want to play again? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing Blackjack!");
        scanner.close();
    }
}
