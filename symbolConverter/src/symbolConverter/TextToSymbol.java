package symbolConverter;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextToSymbol {

	/**
	 * What program should do?
	 * - You type in text
	 * - press a button
	 * - then the corresponding symbol gets sent to your clipboard.
	 * @param args
	 */
	
	
	public static JFrame frame = new JFrame("Symbol Converter");
	public static JPanel panel = new JPanel();
	public static JTextField wordedSymbol = new JTextField();
	
	private static void GUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,600));
		
		
		wordedSymbol.setPreferredSize(new Dimension(500, 25));
		JButton okButton = new JButton("okay");
		
		panel.add(wordedSymbol);
		panel.add(okButton);
		
		frame.pack();
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	
	// TODO: Function here that will parse the given text and turn it into a symbol
	
	
	// TODO: Function here that will take the given symbol and place it into the clipboard.
	// RESEARCH THIS PART FIRST BEFORE STARTING. 
	
	public static void main(String[] args) {
		GUI();
	}

}
