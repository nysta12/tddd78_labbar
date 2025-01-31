package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class TetrisComponent extends JComponent
{
    private Board board;
    private final static EnumMap<SquareType, Color> SQUARE_COLORS = createColorMap();

    private static EnumMap<SquareType, Color> createColorMap() {
	EnumMap<SquareType, Color> colorMap = new EnumMap<>(SquareType.class);
	colorMap.put(SquareType.S, Color.blue);
	colorMap.put(SquareType.Z, Color.yellow);
	colorMap.put(SquareType.I, Color.red);
	colorMap.put(SquareType.J, Color.green);
	colorMap.put(SquareType.L, Color.pink);
	colorMap.put(SquareType.T, Color.orange);
	colorMap.put(SquareType.O, Color.black);
	colorMap.put(SquareType.EMPTY, Color.white);
	return colorMap;
    }

    public TetrisComponent(Board board){
	this.board = board;
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	for (int i = 0; i < board.getHeight(); i++) {
	    for (int j = 0; j < board.getWidth(); j++) {
		SquareType squareType = board.getVisibleSquareAt(j, i);
		//Color squareColor = squareColors.get(squareType);
		Color squareColor = Color.black;
		if(squareType == SquareType.EMPTY){
		    g2d.setColor(squareColor);
		    g2d.fillRect(j, i,10,10);
		    g2d.setColor(new Color(227, 219, 211));
		    g2d.drawRect(j, i, 10, 10);
		}
		else {
		    g2d.setColor(squareColor);
		    g2d.fillRect(j, i, 10, 10);
		    g2d.setColor(new Color(87,87,87));
		    g2d.drawRect(j, i, 10, 10);
		}
	    }
	}
    }

    public Dimension getPreferredSize() {
	final int height = 600;
	final int width= 450;
	return new Dimension(width, height);
    }
}
