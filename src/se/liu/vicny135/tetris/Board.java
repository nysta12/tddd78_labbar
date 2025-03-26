package se.liu.vicny135.tetris;

import java.util.ArrayList;
import java.util.List;
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
    private List<BoardListener> boardListeners;
    private TetrominoMaker tetrominoMaker;
    private final static int MARGIN = 2;
    private final static int DOUBLE_MARGIN = 4;
    private boolean gameOver = false;



    public Board(int width, int height){
	this.width = width;
	this.height = height;
	tetrominoMaker = new TetrominoMaker();
	squares = new SquareType[height + DOUBLE_MARGIN][width + DOUBLE_MARGIN];
	boardListeners = new ArrayList<>();
	for (int row = 0; row < height + DOUBLE_MARGIN; row++) {
	    for (int col = 0; col < width + DOUBLE_MARGIN; col++) {
		if((row >= MARGIN && row < (height + MARGIN)) && (col >= MARGIN && col < (width + MARGIN))) {
		    squares[row][col] = SquareType.EMPTY;
		}
		else {
		    squares[row][col] = SquareType.OUTSIDE;
		}
	    }
	}
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

    private void notifyListeners(){
	for(BoardListener bl : boardListeners){
	    bl.boardChanged();
	}
    }

    public void addBoardListeners(BoardListener bl){
	boardListeners.add(bl);
    }

    public void polyToBoard() {
	for (int row = 0; row < falling.getHeight(); row++) {
	    for (int col = 0; col < falling.getWidth(); col++) {
		if (falling.getPoly()[row][col] != SquareType.EMPTY) {
		    squares[(row + fallingRow)][(col + fallingColumn)] = falling.getPoly()[row][col];
		}
	    }
	}
	notifyListeners();
    }

    public void tick(){
	if(!gameOver) {
	    if (falling == null) {
		setNewFalling();
		if (hasCollision()) {
		    gameOver = true;
		    System.out.println("Game Over");
		}
	    } else {
		moveFalling();
		if (hasCollision()) {
		    fallingRow--;
		    polyToBoard();
		    falling = null;
		    removeFullRow();
		}
	    }
	}
	notifyListeners();
    }

    public SquareType getVisibleSquareAt(int row, int col){
	col += MARGIN;
	row += MARGIN;
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

    public boolean hasCollision(){
	for (int y = 0; y < falling.getHeight(); y++) {
	    for (int x = 0; x < falling.getWidth(); x++) {
		if ((falling.getPoly()[y][x] != SquareType.EMPTY) &&
		    (getSquareType((fallingRow + y), (fallingColumn + x)) != SquareType.EMPTY)){
		    return true;
		}
	    }
	}
	return false;
    }

    public void setNewFalling(){
	int i = RND.nextInt(tetrominoMaker.getNumberOfTypes() - 1);
	falling = tetrominoMaker.getPoly(i);
	fallingColumn = ((width + MARGIN) / 2);
	fallingRow = MARGIN;
	notifyListeners();
    }

    public void moveFalling(){
	fallingRow ++;
	notifyListeners();
    }

    public void move(Direction direction){
	if(falling != null) {
	    if (direction == Direction.LEFT) {
		fallingColumn--;
		if (hasCollision()) {
		    fallingColumn++;
		}
	    } else if (direction == Direction.RIGHT) {
		fallingColumn++;
		if (hasCollision()) {
		    fallingColumn--;
		}
	    } else if (direction == Direction.DOWN) {
		fallingRow++;
		if (hasCollision()) {
		    fallingRow--;
		}
	    }
	    notifyListeners();
	}
    }

    public void rotate(Direction direction) {
	if (falling != null) {
	    Poly oldPoly = falling;
	    Poly newPoly = new Poly(new SquareType[falling.getHeight()][falling.getWidth()]);
	    for (int r = 0; r < falling.getHeight(); r++) {
		for (int c = 0; c < falling.getWidth(); c++) {
		    if (direction == Direction.RIGHT) {
			newPoly.getPoly()[c][falling.getWidth() - 1 - r] = oldPoly.getPoly()[r][c];
		    } else {
			newPoly.getPoly()[falling.getHeight() - 1 - c][r] = oldPoly.getPoly()[r][c];
		    }
		}
	    }
	    falling = newPoly;
	    if (hasCollision()) {
		falling = oldPoly;
	    }
	    notifyListeners();
	}
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

    public void removeFullRow(){
	for(int y = MARGIN; y < height + MARGIN; y++){
	    boolean fullRow = true;
	    for(int x = MARGIN; x < width + MARGIN; x++) {
		if(squares[y][x] == SquareType.EMPTY) {
		    fullRow = false;
		    break;
		}
	    }
	    if(fullRow){
		for(int j = y; j > MARGIN; j --) {
		    for (int x = MARGIN; x < width + MARGIN; x++) {
			squares[j][x] = squares[j - 1][x];
		    }
		}
		for(int x = MARGIN; x < width + MARGIN; x++) {
		    squares[MARGIN][x] = SquareType.EMPTY;
		}
	    }
	}
    }
}
