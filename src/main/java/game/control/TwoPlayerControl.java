package main.java.game.control;

import main.java.game.model.TwoPlayerLogic;
import main.java.game.view.TwoPlayerView;

/**
 * Controls the flow of a two player game
 * @author David Jackson
 */
public class TwoPlayerControl implements TwoPlayerInterface{
	
	private TwoPlayerLogic game;
	private TwoPlayerView view;
	
	public TwoPlayerControl(int seed) {
		
		game = new TwoPlayerLogic(seed);
		view = new TwoPlayerView(seed);
	}
	
	@Override
	public void gameLoop() {
		
		int winner = 0;
		
		while (!game.gameOver()) {
			
			winner = game.ComparePlayers();
									
			switch (winner) {
				case 0:	
					int warWinner = game.startWar();
					
					if(warWinner == 0) {
						view.printFailedWar();
					} else { 
						printWarBoard(warWinner);
						if(warWinner == 4) {
							break;
						}
					}
				case 3:
					break;
				default:
					printNormalBoard(winner);
			}
			
			if (game.gameOver()) {
				break;
			}
		}
		
		view.printGameOver(game.trueWinner(), game.getPlayerOneScore(), game.getPlayerTwoScore());
	}

	public void printNormalBoard(int winner) {
		view.printNormaBoard(game.getPlayerOneCardNormal().getRank().getRankName(), 
				game.getPlayerOneCardNormal().getSuit().getSuitName(), 
				game.getPlayerTwoCardNormal().getRank().getRankName(), 
				game.getPlayerTwoCardNormal().getSuit().getSuitName(),
				winner, game.getPlayerOneScore(), game.getPlayerTwoScore());
	}
	
	public void printWarBoard(int warWinner) {
		view.printPreWarBoard(game.getPlayerOneCardNormal().getRank().getRankName(), 
				game.getPlayerOneCardNormal().getSuit().getSuitName(), 
				game.getPlayerTwoCardNormal().getRank().getRankName(), 
				game.getPlayerTwoCardNormal().getSuit().getSuitName());
		view.printWarBoard(game.getPlayerOneCardWar().getRank().getRankName(), 
				game.getPlayerOneCardWar().getSuit().getSuitName(), 
				game.getPlayerTwoCardWar().getRank().getRankName(), 
				game.getPlayerTwoCardWar().getSuit().getSuitName(), warWinner, 
				game.getPlayerOneScore(), game.getPlayerTwoScore());
	}
}
