package com.silalahi.valentinus.twodimensionalarray;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-26
 * Time: 10:10
 * To change this template use File | Settings | File and Code Templates.
 */
public class TicTacToe {
	public static final int X=1;
	public static final int O=-1;
	public static final int EMPTY = 0;
	private int board[][] = new int[3][3];
	private int player;

	public TicTacToe() {
		clearBoard();
	}

	private void clearBoard() {
		for (int i =0; i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j] = EMPTY;
			}
		}
		player=X;
	}
	
	public void putMark(int x, int y){
		if((x<0) || (y>2) || (y<0) || (y>2))
			throw new IllegalArgumentException("invalid board position");
		if(board[x][y]!= EMPTY)
			throw new IllegalArgumentException("Board position occupied");
		board[x][y] = player;
		player =- player;
	}
	
	public boolean isWin(int mark){
		return ((board[0][0] + board[0][1] + board[0][2] == mark * 3)
					   	|| (board[1][0] + board[1][1] + board[1][2] == mark * 3)
						|| (board[2][0] + board[2][1] + board[2][2] == mark * 3)
						|| (board[0][0] + board[1][0] + board[2][0] == mark * 3)
						|| (board[0][1] + board[1][1] + board[2][1] == mark * 3)
						|| (board[0][2] + board[1][2] + board[2][2] == mark * 3)
						|| (board[0][0] + board[1][1] + board[2][2] == mark * 3)
						|| (board[2][0] + board[1][1] + board[0][2] == mark * 3) );
	}
	
	public int winner(){
		if(isWin(X))
			return X;
		else if(isWin(O))
			return (O);
		else
			return (O);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				switch (board[i][j]){
					case X : sb.append("X");
					break;
					case O: sb.append("O");
					break;
					case EMPTY : sb.append(" ");
					break;
				}
				if(j<2) sb.append("|");
			}
			if (i<2) sb.append("\n=====\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.putMark(1,1);		game.putMark(0,2);
		game.putMark(2,2);		game.putMark(0,0);
		game.putMark(0,1);		game.putMark(2,1);
		game.putMark(1,2);		game.putMark(1,0);
		game.putMark(2,0);
		System.out.println(game);
		int winningPlayer = game.winner();
		String[] outCome = {"O wins", "Tie", "X wins"};
		System.out.println(outCome[1+winningPlayer]);
	}
}
