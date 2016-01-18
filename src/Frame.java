import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Frame {
	private JFrame frame;
	private JTextArea jtext;
	private JScrollPane scrollPane;
	private JTextArea introText;
	private JButton jb;
	private JPanel jp;
	public void startGame() {
		
		setWindow();
		addUICompnts();
	}
	
	private void addUICompnts() {
		jp = new JPanel();
		jtext = new JTextArea(400,300);
		scrollPane = new JScrollPane(jtext);
		jtext.setEditable(false);
		jb = new JButton("Start");
		jb.setBounds(20,30,50,30);
		introText = new JTextArea("Welcome to Go Fish! \n" +
				"To start, the program deals 7 cards from our shuffled deck to each player. \n" +
				"The goal is to get as many pairs of cards as possible. Pairs are 2 cards with the same numerical value. \n" +
				"If you get a pair it will add a point to your score. \n" +
				"If your opponent doesn't have the card you asked for, you will automatically Go Fish (draw a card from the deck).\n" +
				"Your turn is then over and it's your opponents turn to try to guess pairs. \n" +
				"The game will continue until one of the players is out of cards. \n" +
				"Valid Entries of cards to ask for are: A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K");
		introText.setEditable(false);
		introText.setBackground(new Color(211,211,211));
		introText.setSize(650,200);
		//jp.setLayout(new GridLayout(2,1,0,0));
		jp.setAlignmentX(50);
		jp.setBackground(new Color(211,211,211));
		TitledBorder border = new TitledBorder("Introduction");
		border.setBorder((BorderFactory.createLineBorder(Color.RED)));
		jp.setBorder(border);
		jp.add(introText);
		jp.add(jb);
		frame.add(jp);
		frame.setVisible(true);
	}

	private void setWindow() {
		frame = new JFrame("Go Fish");
		frame.setSize(new Dimension(650,300));
	    frame.setVisible(false);
	}

	Frame() {
		
	}
	
}