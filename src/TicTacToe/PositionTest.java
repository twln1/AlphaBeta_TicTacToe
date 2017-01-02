package TicTacToe;
import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {
	
	@Test
	public void testMove() throws Exception{
		Position p = new Position().move(1);
		assertEquals(" x       ", p.toString());
		assertEquals('o', p.turn);
	}
	
	@Test
	public void testPossibleMoves() throws Exception {
		Position position = new Position().move(1).move(3).move(4);
		assertArrayEquals( new Integer[] {0, 2,5,6,7,8}, position.possibleMoves());
	}
	
	@Test
	public void testWin(){
		//assertFalse(new Position().win('o'));
		assertTrue(new Position("xxx      ").isWin('x'));
		assertTrue(new Position("   ooo   ").isWin('o'));
		assertTrue(new Position("x  x  x  ").isWin('x'));
		assertTrue(new Position("x   x   x").isWin('x'));
	}
	
	@Test 
	public void testMinimax(){
		assertEquals(100, new Position("xxx      ").minimax());
		assertEquals(-100, new Position("ooo      ").minimax());
		assertEquals(0, new Position("xoxoxooxo").minimax());
		assertEquals(99, new Position(" xx       ").minimax());
		assertEquals(-99, new Position("oo        ", 'o').minimax());
	}
	
	@Test
	public void testBestPossibleMove(){
		assertEquals(0, new Position(" xx       ").bestPossibleMove());
		assertEquals(1, new Position("o o       ", 'o').bestPossibleMove());
	}
	
	@Test
	public void testEndGame(){
		assertFalse(new Position().gameOver());
		assertTrue(new Position("xxx      ").gameOver());
	}
}
