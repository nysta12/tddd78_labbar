package se.liu.vicny135.tetris;

public class BoardTester
{
    public static void main(String[] args) {
	Board board = new Board(10, 12);

	// Timer
	TetrisViewerOld tetrisViewer = new TetrisViewerOld(board);
	tetrisViewer.start();

	// Test GUI with text
	/*
	TetrisViewer tetrisViewer = new TetrisViewer(board);
	tetrisViewer.show();*/


	/*
	// Test board with still falling poly in text
	BoardToTextConverter textBoard = new BoardToTextConverter();
	String str = textBoard.convertToText(board);
	System.out.println(str);
	*/

	/*
	// 10 random boards
	for(int i = 0; i < 10; i++){
	    board.randomBoard();
	    String str = textBoard.convertToText(board);
	    System.out.println(str);
	}*/
    }
}
