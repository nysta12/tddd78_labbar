package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TetrisViewerOld
{
    private Board board;
    private JFrame frame = null;
    private  JTextArea textArea = null;
    private BoardToTextConverter boardToTextConverter;

    public TetrisViewerOld(Board board){
	this.board = board;
	this.boardToTextConverter = new BoardToTextConverter();
    }

    public void start(){
	setUpFrame();
	final Action doOneStep = new AbstractAction() {
	    @Override public void actionPerformed(final ActionEvent e) {
		board.randomBoard();
		show();
	    }
	};

	final Timer clockTimer = new Timer(500, doOneStep);
	clockTimer.setCoalesce(true);
	clockTimer.start();
	show();
    }

    public void setUpFrame(){
	frame = new JFrame("Tetris");
	textArea = new JTextArea(board.getHeight(), board.getWidth());
	frame.setLayout(new BorderLayout());
	frame.add(textArea, BorderLayout.CENTER);
    }

    public void show(){
	textArea.setText(boardToTextConverter.convertToText(board));
	frame.add(textArea, BorderLayout.CENTER);
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.pack();
	frame.setVisible(true);
    }
}
