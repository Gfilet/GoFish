import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class GameUI {
	private JLabel player1;
	private JLabel bot;
	private TextArea messages;
	private JScrollPane scroll;
	private JTextField textEntry;
	private JButton restart;
	private JButton exit;
	private JButton enter;
	private String fishRequest;
	
	public void playGame(JFrame frame) {
		frame.setVisible(true);
	}

	private void addResetListeners(JButton restart2) {
		restart2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				messages.setText("");
			}
			
		});
	}

	private void addExitListener(JButton exit2) {
		exit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void addComponents(JFrame frame) {
		frame.add(player1);
		frame.add(bot);
		frame.add(messages);
		frame.add(textEntry);
		frame.add(new JLabel());
		frame.add(enter);
		frame.add(restart);
		frame.add(exit);
		frame.setSize(650, 500);
	}

	private void initializeBoard() {
		player1 = new JLabel("Player 1: ", JLabel.LEFT);
		bot = new JLabel("Bot: ", JLabel.RIGHT);
		messages = new TextArea();
		//scroll.setPreferredSize(new Dimension(400, 200));
		textEntry = new JTextField();
		restart = new JButton("Reset");
		exit = new JButton("Exit");
		enter = new JButton("Enter");
		enter.setBounds(20,30,50,30);
		restart.setBounds(20,30,50,30);
		exit.setBounds(20,30,50,30);
	}

	public void notifyMessages(String string) {
		messages.append(string+"\n");
	}

	public void setup(JFrame frame) {
		initializeBoard();
		addComponents(frame);
		frame.setLayout(new GridLayout(5,2));
		addResetListeners(restart);
		addExitListener(exit);
		addEnterListener(enter);
		addTextListener(textEntry);
		frame.setVisible(false);
	}

	private void addTextListener(JTextField textEntry2) {
		textEntry2.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				setFishRequest(textEntry.getText());
				System.out.println(textEntry.getText());
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				setFishRequest(textEntry.getText());
				System.out.println(textEntry.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

	private void addEnterListener(JButton enter2) {
		enter2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setFishRequest(textEntry.getText());
				System.out.println(textEntry.getText());
			}
		});
	}

	protected void setFishRequest(String line) {
		fishRequest = line;
	}

	public void notifyPLabel(int score) {
		player1.setText("Player1: "+score);
	}

	public void notifyBLabel(int score) {
		bot.setText("Bot: "+score+"  ");
		
	}

	public String hasRequest() {
		return getFishRequest();
	}

	private String getFishRequest() {
		return fishRequest;
	}

	public void clear() {
		textEntry.setText("");
	}

}
