package main.java.game.model;

/**
 * Store the data for the cards rank
 * @author David Jackson
 */
public enum Rank {
	TWO("TWO", 2),
	THREE("THREE", 3),
	FOUR("FOUR", 4),
	FIVE("FIVE", 5),
	SIX("SIX", 6),
	SEVEN("SEVEN", 7),
	EIGHT("EIGHT", 8),
	NINE("NINE", 9),
	TEN("TEN", 10),
	JACK("JACK", 11),
	QUEEN("QUEEN", 12),
	KING("KING", 13),
	ACE("ACE", 14);
	
	private String rankName;
	private int rankValue;

	Rank(String newRankName, int newRankValue) {
		this.setRankName(newRankName);
		this.setRankValue(newRankValue);
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}
}
