package TicTacToe;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Game {
	Position position = new Position();
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Tic Tac Toe");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new GridLayout(3, 3));
				frame.setPreferredSize(new Dimension(500, 500));
				final Game game = new Game();
				final JButton[] buttons = new JButton[9] ;
				for(int i = 0; i < 9; i++){
					final int index = i;
					JButton button = new JButton();
					buttons[i] = button;
					button.setPreferredSize(new Dimension(80, 80));
					button.setBackground(Color.WHITE);
					button.setFont(new Font(null, Font.PLAIN, 60));
					button.setOpaque(true);
					button.addMouseListener(new MouseListener() {
					
						public void mouseClicked(MouseEvent e) {
							button.setText("" + game.position.turn);
							button.setEnabled(false);
							game.move(index);
							if(!game.position.gameOver()){						
								int bestMove = game.position.bestPossibleMove();
								buttons[bestMove].setText("" + game.position.turn);
								buttons[bestMove].setEnabled(false);
								game.move(bestMove);
								
							}
							if(game.position.gameOver()){
								if(game.position.isWin('x'))
									JOptionPane.showMessageDialog(frame, "You won! Good job!", "Game Over", JOptionPane.PLAIN_MESSAGE);
								if(game.position.isWin('o'))
									JOptionPane.showMessageDialog(frame,"(AI) won!", "Game Over", JOptionPane.PLAIN_MESSAGE);
								else
									JOptionPane.showMessageDialog(frame, "DRAW!", "Game Over", JOptionPane.PLAIN_MESSAGE);
								frame.setVisible(false);
								run();
							}
							
						}
						public void mouseEntered(MouseEvent e) {}
						public void mouseExited(MouseEvent e) {}
						public void mousePressed(MouseEvent e) {}
						public void mouseReleased(MouseEvent e) {}
					});
					frame.add(button);
					
				}
				frame.pack();
				frame.setLocationRelativeTo(null); // Center on screen
				frame.setVisible(true);		
			}
		});
	}
	protected void move(int index) {
		position = position.move(index);
		
	}
}
