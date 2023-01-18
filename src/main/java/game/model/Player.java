package main.java.game.model;

import java.util.*;

/**
 * Stores The players card in hand and point pile
 * @author David Jackson
 */
public class Player {
	
	private LinkedList<Cards> cardsInHand;
	private ArrayList<Cards> pointPile;
	private Cards normalCard;
	private Cards warCard;
	private int PlayerNumber;
	
	public Player(LinkedList<Cards> newCardsInHand, int newPlayerNumber) {
		
		this.cardsInHand = newCardsInHand;
		this.setPlayerNumber(newPlayerNumber);
	}
	
	public void createPointPile(ArrayList<Cards> newPointPile){
		this.pointPile = newPointPile;
	}
	
	public Cards playCard() {
		if(cardsInHand.isEmpty()) {
			return null;
		}
		return cardsInHand.removeLast();
	}
	
	public void addCardToHand(Cards card) {
		cardsInHand.addFirst(card);;
	}
		
	public void addCardToPoitPile(Cards card) {
		pointPile.add(card);
	}
	
	public void addPileToHand(ArrayList<Cards> card) {
		
		for(Cards firstCard : card) {
			cardsInHand.addFirst(firstCard);
		}
	}
	
	public void addpileToPoitPile(ArrayList<Cards> card) {
		pointPile.addAll(card);
	}
	
	public int getCardsInHandPoints() {
		return cardsInHand.size();
	}
	
	public int getpointPileSize() throws NullPointerException{
		if (pointPile.isEmpty()) {
			return 0;
		} else {
			return pointPile.size();
		}
	}
	
	public int getPlayerNumber() {
		return PlayerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		PlayerNumber = playerNumber;
	}

	public Cards getNormalCard() {
		return normalCard;
	}

	public void setNormalCard(Cards normalCard) {
		this.normalCard = normalCard;
	}

	public Cards getWarCard() {
		return warCard;
	}

	public void setWarCard(Cards warCard) {
		this.warCard = warCard;
	}
	
	public void playerReset() {
		cardsInHand.clear();
		pointPile.clear();
	}
}
