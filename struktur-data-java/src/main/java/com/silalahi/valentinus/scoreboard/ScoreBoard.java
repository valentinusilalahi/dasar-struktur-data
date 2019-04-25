package com.silalahi.valentinus.scoreboard;

/**
 * Created by IntelliJ IDEA.
 * User: valentinussilalahi
 * Date: 2019-04-24
 * Time: 11:26
 * Storing game entries in an array
 */
public class ScoreBoard {
	private int numEntries=0;
	private GameEntry[] board;
	
	public ScoreBoard(int capacity){
		board = new GameEntry[capacity];
	}
	
	public void add(GameEntry e){
		int newScore = e.getScore();
		if (numEntries<board.length || newScore>board[numEntries-1].getScore()){
			if(numEntries<board.length){
				numEntries++;
				
				int j = numEntries -1;
				while (j>0&& board[j-1].getScore()<newScore){
					board[j] = board[j-1];
					j--;
				}
				board[j] =e;
			}
		}
	}
	
	public GameEntry remove(int i)throws IndexOutOfBoundsException{
		if(i < 0 || i >= numEntries){
			throw new IndexOutOfBoundsException("Invalid index: "+i);
		}
		GameEntry temp = board[i];
		for (int j= i;j<numEntries-1;j++){
			board[j] =board[j+1];
		}
		board[numEntries-1]=null;
		return temp;
	}
}
