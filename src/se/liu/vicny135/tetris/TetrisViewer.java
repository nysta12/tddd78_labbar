package se.liu.vicny135.tetris;

import javax.swing.*;
import java.awt.*;

public class TetrisViewer
{
    Board board;
    public TetrisViewer(Board board){
	this.board = board;
    }

    public void show(){
	BoardToTextConverter boardToTextConverter = new BoardToTextConverter();
	String str = boardToTextConverter.convertToText(board);

	JFrame frame = new JFrame("Tetris");
	frame.setLayout(new BorderLayout());
	JTextArea textArea = new JTextArea(board.getHeight(), board.getWidth());
	textArea.setText(str);
	frame.add(textArea, BorderLayout.CENTER);
	textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
	frame.pack();
	frame.setVisible(true);
    }
}
