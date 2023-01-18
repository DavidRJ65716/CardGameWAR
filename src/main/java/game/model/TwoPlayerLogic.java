package main.java.game.model;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Game Rules for 2 player game
 * @author David Jackson
 */
public class TwoPlayerLogic {
	
	private Player playerOne;
	private Player playerTwo;
	private Deck deck;
	
	public TwoPlayerLogic(int seed) throws NullPointerException {
		
		deck = new Deck();
		deck.shuffleDeck(seed);
		
		LinkedList<Cards> playerOnePile = new LinkedList<Cards>();
		LinkedList<Cards> playerTwoPile = new LinkedList<Cards>();
		
		int deckSize = 52;
		for(int currentCard = 0; currentCard < deckSize; ++currentCard) {
			
			if (currentCard % 2 == 0) {
				Cards card = deck.playCard(currentCard);
				playerOnePile.add(card);
			}else {
				Cards card = deck.playCard(currentCard);
				playerTwoPile.add(card);
			}
		}
		
		ArrayList<Cards> pointOnePile = new ArrayList<Cards>();
		ArrayList<Cards> pointTwoPile = new ArrayList<Cards>();
				
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
		
		playerOne.createPointPile(pointOnePile);
		playerTwo.createPointPile(pointTwoPile);
	}
		
	public int ComparePlayers(){
		
		int winner = 0;
		Cards cardOne  = playerOne.playCard();
		Cards cardTwo  = playerTwo.playCard();
		if(cardOne == null || cardTwo == null) {
			return 3;
		}
		
		playerOne.setNormalCard(cardOne);
		playerTwo.setNormalCard(cardTwo);
		
		if (cardOne.getRank().getRankValue() == cardTwo.getRank().getRankValue()) {
			winner = 0;
		} else if (cardOne.getRank().getRankValue() > cardTwo.getRank().getRankValue()) {
			playerOne.addCardToPoitPile(cardOne);
			playerOne.addCardToPoitPile(cardTwo);
			winner = 1;
		} else {
			playerTwo.addCardToPoitPile(cardOne);
			playerTwo.addCardToPoitPile(cardTwo);
			winner = 2;
		}
		
		return winner;
	}
	
	public int startWar() {
		
		int winner = 0;
		int war = 1;
		
		//Breaks out of infinite loops when their is not enough cards
		if (playerOne.getCardsInHandPoints() < 3 || playerTwo.getCardsInHandPoints() < 3) {
			if (getPlayerOneCardNormal().getRank().getRankValue() == getPlayerTwoCardNormal().getRank().getRankValue()) {
				playerOne.addCardToPoitPile(getPlayerOneCardNormal());
				playerTwo.addCardToPoitPile(getPlayerTwoCardNormal());
				return 0;
			} else {
				playerOne.addCardToHand(getPlayerOneCardNormal());
				playerTwo.addCardToHand(getPlayerTwoCardNormal());
				return 0;
			}
		}

		ArrayList<Cards> playerOnePile = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		ArrayList<Cards> playerTwoPile = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		
		for (int cardsPulled = 0; cardsPulled <= war; cardsPulled++) {
			Cards cardOne  = playerOne.playCard();
			Cards cardTwo  = playerTwo.playCard();
			if(cardOne == null || cardTwo == null) {
				return 3;
			}
			
			playerOnePile.add(cardOne);
			playerTwoPile.add(cardTwo);
		}
		
		playerOne.setWarCard(playerOnePile.get(war));
		playerTwo.setWarCard(playerTwoPile.get(war));

		if (playerOnePile.get(war).getRank().getRankValue() == playerTwoPile.get(war).getRank().getRankValue()) {
			playerOne.addPileToHand(playerOnePile);
			playerOne.addCardToHand(getPlayerOneCardNormal());
			playerTwo.addPileToHand(playerTwoPile);
			playerTwo.addCardToHand(playerTwo.getNormalCard());
			winner = 0;			
		} else if (playerOnePile.get(war).getRank().getRankValue() > playerTwoPile.get(war).getRank().getRankValue()) {
			playerOne.addpileToPoitPile(playerTwoPile);
			playerOne.addCardToPoitPile(getPlayerOneCardNormal());
			playerOne.addpileToPoitPile(playerTwoPile);
			playerOne.addCardToPoitPile(getPlayerTwoCardNormal());
			winner = 1;
		} else {
			playerTwo.addpileToPoitPile(playerOnePile);
			playerTwo.addCardToPoitPile(getPlayerOneCardNormal());
			playerTwo.addpileToPoitPile(playerTwoPile);
			playerTwo.addCardToPoitPile(getPlayerTwoCardNormal());
			winner = 2;
		}
			
		playerOnePile.clear();
		playerTwoPile.clear();
		return winner;
	}
	
	public void fillPlyers(Deck deck) throws NullPointerException {
		
		LinkedList<Cards> playerOnePile = new LinkedList<Cards>();
		LinkedList<Cards> playerTwoPile = new LinkedList<Cards>();
		
		int deckSize = 52;
		for(int currentCard = 0; currentCard < deckSize; ++currentCard) {
			
			if (currentCard % 2 == 0) {
				Cards card = deck.playCard(currentCard);
				playerOnePile.add(card);
			}else {
				Cards card = deck.playCard(currentCard);
				playerTwoPile.add(card);
			}
		}
		
		ArrayList<Cards> pointOnePile = new ArrayList<Cards>();
		ArrayList<Cards> pointTwoPile = new ArrayList<Cards>();
				
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
		
		playerOne.createPointPile(pointOnePile);
		playerTwo.createPointPile(pointTwoPile);
	}
		
	public boolean gameOver() {
		int maxCards = 0;
		if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		} else if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		}
		return false;
	}
		
	public Cards getPlayerOneCardNormal() {
		return playerOne.getNormalCard();
	}
	
	public Cards getPlayerOneCardWar() {
		return playerOne.getWarCard();
	}
	
	public Cards getPlayerTwoCardNormal() {
		return playerTwo.getNormalCard();
	}
	
	public Cards getPlayerTwoCardWar() {
		return playerTwo.getWarCard();
	}
	
	public int getPlayerTwoScore() {
		return playerTwo.getpointPileSize();
	}

	public int getPlayerOneScore() {
		return playerOne.getpointPileSize();
	}

	public int trueWinner() {
		if(playerOne.getpointPileSize() == playerTwo.getpointPileSize()) {
			return 0;
		} else if(playerOne.getpointPileSize() > playerTwo.getpointPileSize()) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public void resetPlayer() {
		playerOne.playerReset();
		playerTwo.playerReset();
	}
}
