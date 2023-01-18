package main.java.game.model;

import java.util.*;

/**
 * Creates an array of cards into a deck and shuffles the deck
 * @author David Jackson
 */
public class Deck {
	
	private ArrayList<Cards> deck;
	
	public Deck() {
		
		this.deck = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		
		for(Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
	            Cards card = new Cards(suit, rank);
	            deck.add(card);
	        }
		}
	}
	
	public void shuffleDeck(int seed) {
		
		Collections.shuffle(this.deck,  new Random(seed));
	}
	
	public Cards playCard(int numCard) {
	
		return deck.get(numCard);
	}
	
}
