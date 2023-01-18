package main.java.game.model;

/**
 * Stores the data for the cards Suits
 * @author David Jackson
 */
public enum Suit {
    SPADES("SPADES"), 
    HEARTS("HEARTS"), 
    DIAMONDS("DIAMONDS"),
    CLUBS("CLUBS");
	
	private String suitName;
	
	Suit(String newSuitName) {
		this.setSuitName(newSuitName);
	}

	public String getSuitName() {
		return suitName;
	}

	public void setSuitName(String suitName) {
		this.suitName = suitName;
	} 
}
