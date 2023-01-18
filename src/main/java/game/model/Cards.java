package main.java.game.model;

/**
 * Hold the individual card data
 * @author David Jackson
 */
public class Cards {
	    
    private Suit Suit;
    private Rank Rank;

    public Cards(Suit newSuit, Rank newRank) {
        this.Suit = newSuit;
        this.Rank = newRank;
    }

    public Suit getSuit() {
        return Suit;
    }

    public Rank getRank() {
        return Rank;
    }
}
