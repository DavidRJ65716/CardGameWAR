package main.java.game.model;

import java.util.*;
/**
 * Game Rules for 2 player Continues game
 * @author David Jackson
 */
public class TwoPlayerLimitedLogic {
	
	private Player playerOne;
	private Player playerTwo;
	private Deck deck;
	
	public TwoPlayerLimitedLogic(int seed) throws NullPointerException {
		
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
		
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
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
			playerOne.addCardToHand(cardTwo);
			playerOne.addCardToHand(cardOne);
			winner = 1;
		} else {
			playerTwo.addCardToHand(cardTwo);
			playerTwo.addCardToHand(cardOne);
			winner = 2;
		}
		
		return winner;
	}
	
	public int startWar() {
		
		int winner = 0;
		int war = 2;
		
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
			winner = 0;
		} else if (playerOnePile.get(war).getRank().getRankValue() > playerTwoPile.get(war).getRank().getRankValue()) {
			playerOne.addPileToHand(playerOnePile);
			playerOne.addCardToHand(getPlayerOneCardNormal());
			playerOne.addPileToHand(playerTwoPile);
			playerOne.addCardToHand(getPlayerTwoCardNormal());
			winner = 1;
		} else {
			playerTwo.addPileToHand(playerOnePile);
			playerTwo.addCardToHand(getPlayerOneCardNormal());
			playerTwo.addPileToHand(playerTwoPile);
			playerTwo.addCardToHand(getPlayerTwoCardNormal());
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
		
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
	}
		
	public boolean gameOver() {
		int maxCards = 51;
		if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		} else if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		}
		return false;
	}

	public int getPlayerTwoScore() {
		return playerTwo.getCardsInHandPoints();
	}

	public int getPlayerOneScore() {
		return playerOne.getCardsInHandPoints();
	}

	public boolean gameOverTie() {
		if(playerOne.getCardsInHandPoints() == playerTwo.getCardsInHandPoints()) {
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

	public void resetPlayer() {
		playerOne.playerReset();
		playerTwo.playerReset();
	}
}
