package TicTacToe;
import static org.junit.Assert.*;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

public class PositionTest {

	@Test
	public void testNew() throws Exception{
		Position p = new Position();
		assertEquals("         ", p.toString());
		assertEquals('x', p.turn);
	}
	
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
		assertTrue(new Position("xxx      ").win('x'));
		assertTrue(new Position("   ooo   ").win('o'));
		assertTrue(new Position("x  x  x  ").win('x'));
		assertTrue(new Position("x   x   x").win('x'));
	}
}
