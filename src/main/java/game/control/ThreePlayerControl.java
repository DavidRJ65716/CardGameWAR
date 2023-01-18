package main.java.game.control;

import main.java.game.model.ThreePlayerLogic;
import main.java.game.view.ThreePlayerView;
/**
 * Controls the flow of Three player game
 * @author David Jackson
 */
public class ThreePlayerControl implements ThreePlayerInterface{
	
	private ThreePlayerLogic game;
	private ThreePlayerView view;
	final private int warInitiate = 0;
	final private int warLost = 0;
	final private int warLoopStop = 4;
	final private int noMoreCards = 6;
	
	public ThreePlayerControl(int seed) {
		
		game = new ThreePlayerLogic(seed);
		view = new ThreePlayerView(seed);
	}
	
	@Override
	public void gameLoop() {
		
		int winner = 0;
		
		while (!game.gameOver()) {
			
			winner = game.ComparePlayers();
									
			switch (winner) {
				case warInitiate:	
					int warWinner = game.startWar();
					
					if(warWinner == warLost) {
						view.printFailedWar();
					} else { 
						printWarBoard(warWinner);
						if(warWinner == warLoopStop) {//Stops an infinite loop when their is not enough cards
							break;
						}
					}
				case noMoreCards:
					break;
				default:
					printNormalBoard(winner);
			}
			
			if (game.gameOver()) {
				break;
			}
		}
		
		view.printGameOver(game.trueWinner(), game.getPlayerOneScore(), game.getPlayerTwoScore(), game.getPlayerThreeScore());
	}

	public void printNormalBoard(int winner) {
		view.printNormaBoard(game.getPlayerOneCardNormal().getRank().getRankName(), 
				game.getPlayerOneCardNormal().getSuit().getSuitName(), 
				game.getPlayerTwoCardNormal().getRank().getRankName(), 
				game.getPlayerTwoCardNormal().getSuit().getSuitName(),
				game.getPlayerThreeCardNormal().getRank().getRankName(), 
				game.getPlayerThreeCardNormal().getSuit().getSuitName(),
				winner, game.getPlayerOneScore(), game.getPlayerTwoScore(),
				game.getPlayerThreeScore());
	}
	
	public void printWarBoard(int warWinner) {
		view.printPreWarBoard(game.getPlayerOneCardNormal().getRank().getRankName(), 
				game.getPlayerOneCardNormal().getSuit().getSuitName(), 
				game.getPlayerTwoCardNormal().getRank().getRankName(), 
				game.getPlayerTwoCardNormal().getSuit().getSuitName(),
				game.getPlayerThreeCardNormal().getRank().getRankName(), 
				game.getPlayerThreeCardNormal().getSuit().getSuitName());
		view.printWarBoard(game.getPlayerOneCardWar().getRank().getRankName(), 
				game.getPlayerOneCardWar().getSuit().getSuitName(), 
				game.getPlayerTwoCardWar().getRank().getRankName(), 
				game.getPlayerTwoCardWar().getSuit().getSuitName(),
				game.getPlayerThreeCardWar().getRank().getRankName(), 
				game.getPlayerThreeCardWar().getSuit().getSuitName(),
				warWinner, game.getPlayerOneScore(), game.getPlayerTwoScore(), 
				game.getPlayerThreeScore());
	}
}
