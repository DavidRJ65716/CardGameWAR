package main.java.game.control;

import main.java.game.view.TwoPlayerLimitedView;
import main.java.game.model.TwoPlayerLimitedLogic;

/**
 * Controls the flow for a Two player Continues game 
 * @author David Jackson
 */
public class TwoPlayerLimitedControl implements TwoPlayerLimitedInterface{
	
	private TwoPlayerLimitedLogic game;
	private TwoPlayerLimitedView view;
	private int num_Of_Rounds;
	
	public TwoPlayerLimitedControl(int seed, int limit) {
		
		this.num_Of_Rounds = limit;
		game = new TwoPlayerLimitedLogic(seed);
		view = new TwoPlayerLimitedView(seed, limit);
	}
	
	@Override
	public void gameLoop() {
		
		int winner = 0;
		
		for (int currentRound = 1; currentRound <= num_Of_Rounds; ++currentRound) {
			
			winner = game.ComparePlayers();
									
			switch (winner) {
				case 0:	
					int warWinner = game.startWar();
					
					if(warWinner == 0) {
						view.printFailedWar();
					} else { 
						printWarBoard(warWinner);
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
		
		view.printGameOver(winner, game.getPlayerOneScore(), game.getPlayerTwoScore(), game.gameOverTie());
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
