/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Julian Mastalerz
 */
public class BlackjackCard extends Card {
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }
    
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);
        
        private int value;
        
        Rank(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    private Suit suit;
    private Rank rank;
    
    public BlackjackCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
