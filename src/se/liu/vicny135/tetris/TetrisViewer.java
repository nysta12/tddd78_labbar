package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board board;
    private JFrame frame;
    private TetrisComponent tetrisComponent;


    public TetrisViewer(Board board){
	this.board = board;
	frame = new JFrame("Tetris");
	tetrisComponent = new TetrisComponent(board);
	board.addBoardListeners(tetrisComponent);
    }

    public void start(){
	final Action doOneStep = new AbstractAction() {
	    @Override public void actionPerformed(final ActionEvent e) {
		board.tick();
		show();
	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	show();
    }

    public void show(){
	frame.add(tetrisComponent, BorderLayout.CENTER);
	frame.pack();
	frame.setVisible(true);
    }
}
