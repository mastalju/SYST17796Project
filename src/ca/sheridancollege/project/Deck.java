/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
/**
 *
 * @author Julian Mastalerz
 */
public class Deck extends GroupOfCards {
    public Deck() {
        super(52); // Passes value 52 to GroupOfCards constructor 
        initializeDeck(); // Creates a deck of 52 cards ready to be used in game
    }
    
    // Method to initialize the deck of cards that will be used in the game
    public void initializeDeck() {
        ArrayList<Card> deck = getCards(); // Gets list of cards
        // Creates cards for each suit and rank
        for (BlackjackCard.Suit suit : BlackjackCard.Suit.values()) {
            for (BlackjackCard.Rank rank : BlackjackCard.Rank.values()) {
                deck.add(new BlackjackCard(suit, rank));
            }
        }
    }
    
    // Draws card from deck
    public BlackjackCard drawCard() {
        if (getCards().isEmpty()) {
            System.out.println("Deck is empty. Reshuffling");
            initializeDeck();
            shuffle();
        }
        // Removes top card from the deck
        return (BlackjackCard) getCards().remove(0);
    }
}
