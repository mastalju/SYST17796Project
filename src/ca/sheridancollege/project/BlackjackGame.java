/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Julian Mastalerz
 */
public class BlackjackGame extends Game {
    private Deck deck;
    // Created dealer as a BlackjackPlayer type because dealer needs same methods as a player
    private BlackjackPlayer dealer;
    private Scanner scanner;

    public BlackjackGame() {
        super("Blackjack");
        deck = new Deck();
        deck.shuffle();
        dealer = new BlackjackPlayer("Dealer", true);
        // Use getPlayers() to access the players list
        getPlayers().add(dealer);
        scanner = new Scanner(System.in);
    }

    public void addPlayer(BlackjackPlayer player) {
        getPlayers().add(player);
    }

    @Override
    public void play() {
        // Clear previous hands
        for (Player player : getPlayers()) {
            ((BlackjackPlayer) player).clearHand();
        }

        deck.shuffle();
        // Initial deal: two cards to each player, including the dealer
        for (Player player : getPlayers()) {
            BlackjackPlayer bp = (BlackjackPlayer) player;
            bp.addCard(deck.drawCard());
            bp.addCard(deck.drawCard());
        }

        // Show dealer's first card
        System.out.println("\nDealer's Hand:");
        System.out.println(dealer.getHand().get(0));
        System.out.println("Hidden Card");

        // Player turns
        for (Player player : getPlayers()) {
            BlackjackPlayer bp = (BlackjackPlayer) player;
            if (bp.isDealer()) continue;
            playerTurn(bp);
        }

        // Dealer's turn
        dealerTurn();
    }

    private void playerTurn(BlackjackPlayer player) {
        System.out.println("\n" + player + "'s turn:");
        while (true) {
            displayHand(player);
            if (player.isBusted()) {
                System.out.println("You busted!");
                break;
            }
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                BlackjackCard newCard = deck.drawCard();
                System.out.println("You drew: " + newCard);
                player.addCard(newCard);
            } else if (choice.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
    }

    private void dealerTurn() {
        System.out.println("\nDealer's turn:");
        displayHand(dealer);
        while (dealer.getHandValue() < 17) { // Dealer hits on less than 17
            BlackjackCard newCard = deck.drawCard();
            System.out.println("Dealer draws: " + newCard);
            dealer.addCard(newCard);
            System.out.println("Dealer's total value: " + dealer.getHandValue());
        }
        if (dealer.isBusted()) {
            System.out.println("Dealer busted!");
        }
    }

    private void displayHand(BlackjackPlayer player) {
        if (player.isDealer()) {
            // For the dealer, only display all cards if it's the dealer's turn
            System.out.println(player + "'s hand:");
            for (BlackjackCard card : player.getHand()) {
                System.out.println(card);
            }
            System.out.println("Total value: " + player.getHandValue());
        } else {
            System.out.println(player.getName() + "'s hand:");
            for (BlackjackCard card : player.getHand()) {
                System.out.println(card);
            }
            System.out.println("Total value: " + player.getHandValue());
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("\n--- Game Over ---");
        System.out.println("Dealer's total: " + dealer.getHandValue());
        for (Player player : getPlayers()) {
            BlackjackPlayer bp = (BlackjackPlayer) player;
            if (bp.isDealer()) continue;
            System.out.println("\n" + bp + "'s total: " + bp.getHandValue());
            if (bp.isBusted()) {
                System.out.println(bp.getName() + " busted and loses.");
            } else if (dealer.isBusted()) {
                System.out.println(bp.getName() + " wins! Dealer busted.");
            } else if (bp.getHandValue() > dealer.getHandValue()) {
                System.out.println(bp.getName() + " wins!");
            } else if (bp.getHandValue() < dealer.getHandValue()) {
                System.out.println(bp.getName() + " loses.");
            } else {
                System.out.println(bp.getName() + " ties with the dealer.");
            }
        }
    }
}
