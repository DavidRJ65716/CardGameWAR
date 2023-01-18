package test.java.game.startGame;

import static org.junit.Assert.*;
import org.junit.Test;

import main.java.game.model.*;

public class testGame {
	
	@Test
	public void testTwoPlayerLimitedCompareCards() {

		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.ComparePlayers(), 2);
	}
	
	@Test
	public void testTwoPlayerLimitedWarCards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}
	
	@Test
	public void testTwoPlayerLimitedWar2Cards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}

	@Test
	public void testTwoPlayerCompareCards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLogic newGame = new TwoPlayerLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.ComparePlayers(), 2);
	}
	
	@Test
	public void testTwoPlayerWarCards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLogic newGame = new TwoPlayerLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}
	
	@Test
	public void testTwoPlayerWar2Cards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLogic newGame = new TwoPlayerLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}
	
	@Test
	public void testThreePlayerCompareCards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.ComparePlayers(), 2);
	}
	
	@Test
	public void testThreePlayerWarCards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}
	
	@Test
	public void testThreePlayerWar2Cards() {
		
		Deck deck = new Deck(); 	
		
		TwoPlayerLimitedLogic newGame = new TwoPlayerLimitedLogic(5);
		newGame.resetPlayer();
		newGame.fillPlyers(deck);
		
		assertEquals(newGame.startWar(), 2);
	}
}
