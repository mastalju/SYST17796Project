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
public class BlackjackPlayer extends Player {
    private ArrayList<BlackjackCard> hand;
    private boolean isDealer;
    
    public BlackjackPlayer(String name, boolean isDealer) {
        super(name);
        this.hand = new ArrayList<>();
        this.isDealer = isDealer;
    }
    
    public ArrayList<BlackjackCard> getHand() {
        return hand;
    }
    
    public void addCard(BlackjackCard card) {
        hand.add(card);
    }
    
    /**
     * Calculates the total value of the player's hand.
     * Aces can count as 1 or 11.
     * 
     * @return the total hand value.
     */
    public int getHandValue() {
        int value = 0;
        int aceCount = 0;
        for (BlackjackCard card : hand) {
            value += card.getRank().getValue();
            if (card.getRank() == BlackjackCard.Rank.ACE) {
                aceCount++;
            }
        }
        while (value > 21 && aceCount > 0) {
            value -= 10; // Counting Ace as 1 instead of 11
            aceCount--;
        }
        return value;
    }
    
    public boolean isBusted() {
        return getHandValue() > 21;
    }
    
    @Override
    public void play() {
        // Player actions are handled in the game class
    }
    
    public boolean isDealer() {
        return isDealer;
    }
    
    public void clearHand() {
        hand.clear();
    }
    
    @Override
    public String toString() {
        return getName();  // or return whatever information you want to display
    }
}