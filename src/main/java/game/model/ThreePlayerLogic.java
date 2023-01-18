package main.java.game.model;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Game Rules for 3 player game
 * @author David Jackson
 */
public class ThreePlayerLogic {
	
	private Player playerOne;
	private Player playerTwo;
	private Player playerThree;
	private Deck deck;
	
	public ThreePlayerLogic(int seed) throws NullPointerException {
		
		deck = new Deck();
		deck.shuffleDeck(seed);
		
		LinkedList<Cards> playerOnePile = new LinkedList<Cards>();
		LinkedList<Cards> playerTwoPile = new LinkedList<Cards>();
		LinkedList<Cards> playerThreePile = new LinkedList<Cards>();
		
		int deckSize = 51;
		for(int currentCard = 0; currentCard < deckSize; ++currentCard) {
			
			if (currentCard % 3 == 0) {
				Cards card = deck.playCard(currentCard);
				playerOnePile.add(card);
			} else if (currentCard % 2 == 0) {
				Cards card = deck.playCard(currentCard);
				playerTwoPile.add(card);
			}else {
				Cards card = deck.playCard(currentCard);
				playerThreePile.add(card);
			}
		}
		
		ArrayList<Cards> pointOnePile = new ArrayList<Cards>();
		ArrayList<Cards> pointTwoPile = new ArrayList<Cards>();
		ArrayList<Cards> pointThreePile = new ArrayList<Cards>();
				
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
		playerThree = new Player(playerThreePile, 3);
		
		playerOne.createPointPile(pointOnePile);
		playerTwo.createPointPile(pointTwoPile);
		playerThree.createPointPile(pointThreePile);
	}
		
	public int ComparePlayers(){
		
		int winner = 0;
		Cards cardOne  = playerOne.playCard();
		Cards cardTwo  = playerTwo.playCard();
		Cards cardThree  = playerThree.playCard();
		if(cardOne == null || cardTwo == null || cardThree == null) {
			return 6;
		}
		
		playerOne.setNormalCard(cardOne);
		playerTwo.setNormalCard(cardTwo);
		playerThree.setNormalCard(cardThree);
		
		if (cardOne.getRank().getRankValue() == cardTwo.getRank().getRankValue()) {
			winner = 0;
		} else if (cardOne.getRank().getRankValue() > cardTwo.getRank().getRankValue() && cardOne.getRank().getRankValue() > cardThree.getRank().getRankValue()) {
			playerOne.addCardToPoitPile(cardOne);
			playerOne.addCardToPoitPile(cardTwo);
			playerOne.addCardToPoitPile(cardThree);
			winner = 1;
		} else if (cardTwo.getRank().getRankValue() > cardOne.getRank().getRankValue() && cardThree.getRank().getRankValue() > cardThree.getRank().getRankValue()){
			playerTwo.addCardToPoitPile(cardOne);
			playerTwo.addCardToPoitPile(cardTwo);
			playerTwo.addCardToPoitPile(cardThree);
			winner = 2;
		}else {
		
			playerThree.addCardToPoitPile(cardOne);
			playerThree.addCardToPoitPile(cardTwo);
			playerThree.addCardToPoitPile(cardThree);
			winner = 3;
		}
		
		return winner;
	}
	
	public int startWar() {
		
		int winner = 0;
		int warCard = 1;
		int cardMin = 3;
		
		//Breaks out of infinite loop when their is not enough cards 
		if (playerOne.getCardsInHandPoints() < cardMin || playerTwo.getCardsInHandPoints() < cardMin ||
				playerThree.getCardsInHandPoints() < cardMin) {
			if (getPlayerOneCardNormal().getRank().getRankValue() == getPlayerTwoCardNormal().getRank().getRankValue()) {
				playerOne.addCardToPoitPile(getPlayerOneCardNormal());
				playerTwo.addCardToPoitPile(getPlayerTwoCardNormal());
				playerThree.addCardToPoitPile(getPlayerThreeCardNormal());
				return 0;
			} else {
				playerOne.addCardToHand(getPlayerOneCardNormal());
				playerTwo.addCardToHand(getPlayerTwoCardNormal());
				playerThree.addCardToHand(getPlayerThreeCardNormal());
				return 0;
			}
		}

		ArrayList<Cards> playerOnePile = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		ArrayList<Cards> playerTwoPile = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		ArrayList<Cards> playerThreePile = new ArrayList<Cards>(Suit.values().length * Rank.values().length);
		
		for (int cardsPulled = 0; cardsPulled <= warCard; cardsPulled++) {
			Cards cardOne  = playerOne.playCard();
			Cards cardTwo  = playerTwo.playCard();
			Cards cardThree  = playerThree.playCard();
			if(cardOne == null || cardTwo == null || cardThree == null) {
				return 6;
			}
			
			playerOnePile.add(cardOne);
			playerTwoPile.add(cardTwo);
			playerThreePile.add(cardThree);
		}
		
		playerOne.setWarCard(playerOnePile.get(warCard));
		playerTwo.setWarCard(playerTwoPile.get(warCard));
		playerThree.setWarCard(playerThreePile.get(warCard));

		if (playerOnePile.get(warCard).getRank().getRankValue() == playerTwoPile.get(warCard).getRank().getRankValue()) {
			playerOne.addPileToHand(playerOnePile);
			playerOne.addCardToHand(getPlayerOneCardNormal());
			playerTwo.addPileToHand(playerTwoPile);
			playerTwo.addCardToHand(getPlayerTwoCardNormal());
			winner = 0;			
		} else if (playerOnePile.get(warCard).getRank().getRankValue() > playerTwoPile.get(warCard).getRank().getRankValue() &&
				playerOnePile.get(warCard).getRank().getRankValue() > playerThreePile.get(warCard).getRank().getRankValue()) {
			playerOne.addpileToPoitPile(playerTwoPile);
			playerOne.addCardToPoitPile(getPlayerOneCardNormal());
			playerOne.addpileToPoitPile(playerTwoPile);
			playerOne.addCardToPoitPile(getPlayerTwoCardNormal());
			playerOne.addpileToPoitPile(playerThreePile);
			playerOne.addCardToPoitPile(getPlayerThreeCardNormal());
			winner = 1;
		} else if (playerTwoPile.get(warCard).getRank().getRankValue() > playerOnePile.get(warCard).getRank().getRankValue() &&
				playerTwoPile.get(warCard).getRank().getRankValue() > playerThreePile.get(warCard).getRank().getRankValue()) {
			playerTwo.addpileToPoitPile(playerOnePile);
			playerTwo.addCardToPoitPile(getPlayerOneCardNormal());
			playerTwo.addpileToPoitPile(playerTwoPile);
			playerTwo.addCardToPoitPile(getPlayerTwoCardNormal());
			playerTwo.addpileToPoitPile(playerThreePile);
			playerTwo.addCardToPoitPile(getPlayerThreeCardNormal());
			winner = 2;
		} else {
			playerThree.addpileToPoitPile(playerOnePile);
			playerThree.addCardToPoitPile(getPlayerOneCardNormal());
			playerThree.addpileToPoitPile(playerTwoPile);
			playerThree.addCardToPoitPile(getPlayerTwoCardNormal());
			playerThree.addpileToPoitPile(playerThreePile);
			playerThree.addCardToPoitPile(getPlayerThreeCardNormal());
			winner = 3;
		}
			
		playerOnePile.clear();
		playerTwoPile.clear();
		playerThreePile.clear();
		return winner;
	}
	
	public void fillPlyers(Deck deck) throws NullPointerException {
		
		LinkedList<Cards> playerOnePile = new LinkedList<Cards>();
		LinkedList<Cards> playerTwoPile = new LinkedList<Cards>();
		LinkedList<Cards> playerThreePile = new LinkedList<Cards>();
		
		int deckSize = 51;
		for(int currentCard = 0; currentCard < deckSize; ++currentCard) {
			
			if (currentCard % 3 == 0) {
				Cards card = deck.playCard(currentCard);
				playerOnePile.add(card);
			} else if (currentCard % 2 == 0) {
				Cards card = deck.playCard(currentCard);
				playerTwoPile.add(card);
			}else {
				Cards card = deck.playCard(currentCard);
				playerThreePile.add(card);
			}
		}
		
		ArrayList<Cards> pointOnePile = new ArrayList<Cards>();
		ArrayList<Cards> pointTwoPile = new ArrayList<Cards>();
		ArrayList<Cards> pointThreePile = new ArrayList<Cards>();
				
		playerOne = new Player(playerOnePile, 1);
		playerTwo = new Player(playerTwoPile, 2);
		playerThree = new Player(playerThreePile, 3);
		
		playerOne.createPointPile(pointOnePile);
		playerTwo.createPointPile(pointTwoPile);
		playerThree.createPointPile(pointThreePile);
	}
		
	public boolean gameOver() {
		int maxCards = 0;
		if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		} else if (playerTwo.getCardsInHandPoints() == maxCards) {
			return true;
		} else if (playerThree.getCardsInHandPoints() == maxCards) {
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
	
	public Cards getPlayerThreeCardNormal() {
		return playerThree.getNormalCard();
	}
	
	public Cards getPlayerThreeCardWar() {
		return playerThree.getWarCard();
	}
	
	public int getPlayerTwoScore() {
		return playerTwo.getpointPileSize();
	}

	public int getPlayerOneScore() {
		return playerOne.getpointPileSize();
	}
	
	public int getPlayerThreeScore() {
		return playerThree.getpointPileSize();
	}

	public int trueWinner() {
		if(playerOne.getpointPileSize() == playerTwo.getpointPileSize() && 
				playerTwo.getpointPileSize() == playerThree.getpointPileSize()) {
			return 0;
		} else if(playerOne.getpointPileSize() > playerTwo.getpointPileSize() && 
				playerOne.getpointPileSize() > playerThree.getpointPileSize()) {
			return 1;
		} else if (playerTwo.getpointPileSize() > playerOne.getpointPileSize() && 
				playerTwo.getpointPileSize() > playerThree.getpointPileSize()) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public void resetPlayer() {
		playerOne.playerReset();
		playerTwo.playerReset();
		playerThree.playerReset();
	}
}
