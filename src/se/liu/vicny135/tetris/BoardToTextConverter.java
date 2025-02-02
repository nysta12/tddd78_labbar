package se.liu.vicny135.tetris;

public class BoardToTextConverter
{
    private final static int DOUBLE_MARGIN = 4;
    public String convertToText(Board board){
	StringBuilder str = new StringBuilder();
	for (int row = 0; row < board.getHeight() + DOUBLE_MARGIN; row ++){
	    for (int col = 0; col < board.getWidth() + DOUBLE_MARGIN; col ++){
		switch (board.getSquareType(row, col)){
		    case OUTSIDE:
			str.append("!");
			break;
		    case EMPTY:
			str.append("-");
			break;
		    case L:
			str.append("%");
			break;
		    case S:
			str.append("&");
			break;
		    case T:
			str.append("?");
			break;
		    case Z:
			str.append("¤");
			break;
		    case O:
			str.append("@");
			break;
		    case I:
			str.append("£");
			break;
		    case J:
			str.append("$");
			break;
		}
	    }
	    str.append("\n");
	}
	return str.toString();
    }
}
