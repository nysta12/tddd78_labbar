package se.liu.vicny135.tetris;

public class TetrominoMaker
{
    public int getNumberOfTypes() {
	return SquareType.values().length - 1;
    }

    public Poly getPoly(int n) {
	SquareType[][] seq;
	switch (n) {
	    case 0:
		seq = new SquareType[][] {{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
			{SquareType.I, SquareType.I, SquareType.I, SquareType.I},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    case 1:
		seq = new SquareType[][] {{SquareType.J, SquareType.EMPTY, SquareType.EMPTY},
			{SquareType.J, SquareType.J, SquareType.J},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    case 2:
		seq = new SquareType[][] {{SquareType.EMPTY, SquareType.EMPTY, SquareType.L},
			{SquareType.L, SquareType.L, SquareType.L},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY }};
		break;
	    case 3:
		seq = new SquareType[][] {{SquareType.EMPTY, SquareType.O, SquareType.O, SquareType.EMPTY},
			{SquareType.EMPTY, SquareType.O, SquareType.O, SquareType.EMPTY},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    case 4:
		seq = new SquareType[][] {{SquareType.EMPTY, SquareType.S, SquareType.S},
			{SquareType.S, SquareType.S, SquareType.EMPTY},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    case 5:
		seq = new SquareType[][] {{SquareType.EMPTY, SquareType.T, SquareType.EMPTY},
			{SquareType.T, SquareType.T, SquareType.T},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    case 6:
		seq = new SquareType[][] {{SquareType.Z, SquareType.Z, SquareType.EMPTY},
			{SquareType.EMPTY, SquareType.Z, SquareType.Z},
			{SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}};
		break;
	    default:
		throw new IllegalArgumentException("Invalid index: " + n);
	}
	return new Poly(seq);
    }
}
