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
        super(52);
        initializeDeck();
    }
    
    public void initializeDeck() {
        ArrayList<Card> deck = getCards();
        for (BlackjackCard.Suit suit : BlackjackCard.Suit.values()) {
            for (BlackjackCard.Rank rank : BlackjackCard.Rank.values()) {
                deck.add(new BlackjackCard(suit, rank));
            }
        }
    }
    
    /**
     * Draws the top card from the deck.
     * 
     * @return the drawn BlackjackCard, or null if the deck is empty.
     */
    public BlackjackCard drawCard() {
        if (getCards().isEmpty()) {
            System.out.println("Deck is empty. Reshuffling...");
            initializeDeck();
            shuffle();
        }
        return (BlackjackCard) getCards().remove(0);
    }
}
