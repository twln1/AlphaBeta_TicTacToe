package TicTacToe;

import java.awt.List;
import java.nio.file.spi.FileSystemProvider;
import java.util.LinkedList;

public class Position {
	public int dim = 3;
	public char turn;
	public char[] board;
	
	public Position(){
		this.board = "         ".toCharArray();
		this.turn = 'x';
	}
	
	public Position(String board){
		this.board = board.toCharArray();
		this.turn = 'x';
	}
	
	public Position(char[] board, char turn){
		this.board = board;
		this.turn = turn;
	}
	
	public String toString(){
		return new String(board);
	}
	
	public Position move(int i){
		char[] cloneBoard = board.clone();
		cloneBoard[i] = turn;
		return new Position(cloneBoard, turn == 'x' ? 'o' : 'x');
	}
	
	public Integer [] possibleMoves(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i < board.length; i++){
			if (board[i] == ' '){
				list.add(i);
			}
		}
		Integer[] array = new Integer[list.size()];
		list.toArray(array);
		return array;
	}
	
	/***
	 * Mathematically check for winning move
	 * @param turn	Which player's turn are we testing
	 * @param start	Starting position on the board
	 * @param step	How many positions to move by
	 * @return
	 */
	public boolean win_line(char turn, int start, int step){
		for (int i = 0; i < 3; i++){
			if(board[start + step*i] != turn){
				return false;
			}
		}
		return true;
	}
	/***
	 * 
	 * @param turn	Which player are we testing a win for
	 * @return		TRUE on a win condition
	 */
	public boolean win(char turn){
		for(int i = 0; i < dim; i++){
			// Horizontal/vertical win
			if(win_line(turn, i*dim, 1) || win_line(turn, i, dim))
				return true;
			// Diagonal win
			if ((win_line(turn, dim-1, dim-1) || win_line(turn, 0, dim+1)))
				return true;
		}
		return false;
	}
}
