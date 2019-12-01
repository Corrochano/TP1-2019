package tp.p2.p3.view;
import tp.p2.p3.logic.Game;
import tp.p2.p3.logic.MyStringUtils;

public class BoardPrinter extends GamePrinter {
	
	int numRows; 
	int numCols;
	String[][] board;
	final String space = " ";
	
	public BoardPrinter() {
		// TODO Auto-generated constructor stub
	}

	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				board[i][j] =  game.toStringObjectAt(i, j);
			}
		}
	}
	
	public String toString() {

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<numRows; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<numCols; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
	
	public String toString(Game game) {
		this.setGame(game);
		this.numRows = Game.DIM_X;
		this.numCols = Game.DIM_Y;		
		encodeGame(game);
		return this.toString();
	}
	
}