package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewer
{
    private Board board;
    private TetrisComponent tetrisComponent;


    public TetrisViewer(Board board){
	this.board = board;
	tetrisComponent = new TetrisComponent(board);
	board.addBoardListeners(tetrisComponent);
    }

    public void start(){
	final Action doOneStep = new AbstractAction() {
	    @Override public void actionPerformed(final ActionEvent e) {
		board.tick();
	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	show();
    }

    public void show(){
	JFrame frame = new JFrame("Tetris");
	frame.add(tetrisComponent, BorderLayout.CENTER);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
