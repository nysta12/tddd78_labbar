package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumMap;

public class TetrisComponent extends JComponent implements BoardListener
{
    private Board board;
    private static final int SQUARE_SIZE = 40;
    private final static EnumMap<SquareType, Color> SQUARE_COLORS = createColorMap();
    private static EnumMap<SquareType, Color> createColorMap() {
	EnumMap<SquareType, Color> colorMap = new EnumMap<>(SquareType.class);
	colorMap.put(SquareType.S, Color.blue);
	colorMap.put(SquareType.Z, Color.yellow);
	colorMap.put(SquareType.I, Color.red);
	colorMap.put(SquareType.J, Color.green);
	colorMap.put(SquareType.L, Color.pink);
	colorMap.put(SquareType.T, Color.orange);
	colorMap.put(SquareType.O, Color.gray);
	colorMap.put(SquareType.EMPTY, Color.white);
	colorMap.put(SquareType.OUTSIDE, Color.magenta);
	return colorMap;
    }


    public TetrisComponent(Board board){
	this.board = board;
	final InputMap in = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	in.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
	in.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
	in.put(KeyStroke.getKeyStroke("DOWN"), "drop");
	in.put(KeyStroke.getKeyStroke("X"), "rotateRight");
	in.put(KeyStroke.getKeyStroke("Z"), "rotateLeft");

	final ActionMap act = getActionMap();
	act.put("moveRight", new MoveBlock(Direction.RIGHT));
	act.put("moveLeft", new MoveBlock(Direction.LEFT));
	act.put("drop", new MoveBlock(Direction.DOWN));
	act.put("rotateRight", new RotateBlock(Direction.RIGHT));
	act.put("rotateLeft", new RotateBlock(Direction.LEFT));
    }

    private class MoveBlock extends AbstractAction {
	public Direction direction;
	private MoveBlock(Direction direction) {
	    this.direction = direction;
	}
	@Override public void actionPerformed(final ActionEvent e) {
	    board.move(direction);
	}
    }

    private class RotateBlock extends AbstractAction {
	public Direction direction;
	private RotateBlock(Direction direction) {
	    this.direction = direction;
	}
	@Override public void actionPerformed(final ActionEvent e) { board.rotate(direction); }
    }

    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g2d = (Graphics2D) g;
	for (int row = 0; row < board.getHeight(); row ++){
	    for (int col = 0; col < board.getWidth(); col ++){
		SquareType squareType = board.getVisibleSquareAt(row, col);
		Color color = SQUARE_COLORS.get(squareType);
		g2d.setColor(color);
		g2d.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
		g2d.setColor(Color.lightGray);
		g2d.drawRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
	    }
	}
    }

    public Dimension getPreferredSize() {
	final int height = 800;
	final int width= 600;
	return new Dimension(width, height);
    }

    @Override public void boardChanged() {
	repaint();
    }
}
