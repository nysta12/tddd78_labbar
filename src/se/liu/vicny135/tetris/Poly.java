package se.liu.vicny135.tetris;

public class Poly
{
    public SquareType[][] poly;

    public Poly(final SquareType[][] poly) {
	this.poly = poly;
    }
    public SquareType[][] getPoly(){
	return poly;
    }
    public int getWidth(){
	return poly[0].length;
    }
    public int getHeight(){
	return poly.length;
    }
}
