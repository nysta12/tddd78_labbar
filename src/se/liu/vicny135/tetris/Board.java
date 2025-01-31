package se.liu.vicny135.tetris;

import java.util.Random;

public class Board
{
    private SquareType [][] squares;
    private int width;
    private int height;
    private final static Random RND = new Random();
    private Poly falling = null;
    private int fallingColumn;
    private int fallingRow;



    public Board(int width, int height){
	this.width = width;
	this.height = height;
	TetrominoMaker tetrominoMaker = new TetrominoMaker();
	squares = new SquareType[height][width];
	for (int row = 0; row < height; row ++){
	    for (int col = 0; col < width; col ++){
		squares[row][col] = SquareType.EMPTY;
	    }
	}
	setFalling(tetrominoMaker);
    }

    public void randomBoard(){
	for (int row = 0; row < height; row ++){
	    for (int col = 0; col < width; col ++){
		int index = RND.nextInt(SquareType.values().length - 1);
		SquareType randomSquare = SquareType.values()[index];
		squares[row][col] = randomSquare;
	    }
	}
    }


    public SquareType getVisibleSquareAt(int row, int col){
	if (falling == null) {
	    return squares[row][col];
	}
	int fallingWidth = fallingColumn + falling.getWidth();
	int fallingHeight = fallingRow + falling.getHeight();
	if(fallingColumn <= col && fallingWidth > col && fallingRow <= row && fallingHeight > row) {
	    int insideXPoly = col - fallingColumn;
	    int insideYPoly = row - fallingRow;
	    if (falling.getPoly()[insideYPoly][insideXPoly] == SquareType.EMPTY) {
		return getSquareType(row, col);
	    }
	    else {
		return falling.getPoly()[insideYPoly][insideXPoly];
	    }
	}
	else{
	    return getSquareType(row, col);
	}
    }

    public void setFalling(TetrominoMaker tetrominoMaker){
	this.falling = tetrominoMaker.getPoly(3);
	this.fallingColumn = (width / 2) - 2;
	this.fallingRow = 0;
    }
    public Poly getFalling(){
	return falling;
    }
    public int getFallingColumn(){
	return fallingColumn;
    }
    public int getFallingRow(){
	return fallingRow;
    }
    public int getWidth(){
	return width;
    }

    public int getHeight(){
	return height;
    }

    public SquareType getSquareType(int row, int col){
	return squares[row][col];
    }

    public static void main(String[] args) {
	Board board = new Board(10, 12);
	System.out.println(board.getWidth());
	System.out.println(board.getHeight());

    }
}
