package se.liu.vicny135.tetris;

public class BoardToTextConverter
{
    public String convertToText(Board board){
	StringBuilder str = new StringBuilder();
	for (int row = 0; row < board.getHeight(); row ++){
	    for (int col = 0; col < board.getWidth(); col ++){
		switch (board.getVisibleSquareAt(row, col)){
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
