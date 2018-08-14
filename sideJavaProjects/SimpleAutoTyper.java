package busTime;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

public class SimpleAutoTyper {
	
	// A common font all texts/labels will use.
	private static Font textFont = new Font("sans serif", 20, 50);
	// constants
	private static String specialLetters = "*!@#$%^&()\"{}_|?<>";
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	// Future feature that'll be added is timing.
	
	/**
	 * This function will allow the client to type whatever text they want
	 * through the given window which is defined here.
	 * @param args
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public static void AutoTypedWindow(String autoType) throws AWTException, InterruptedException {
		Robot r = new Robot();
		// Define a KeyboardKeys map here later.
		// For every character in the textbox, convert it to an 
		// array and simulate every typed character 
		// into the main-frame.
		
	    for (char c : autoType.toCharArray()) {
	    	CharSequence charact = c + "";
	        int code = KeyEvent.getExtendedKeyCodeForChar(c);
	        
	        // If the character is a capital or if the character is a symbol then,
	        if (Character.isUpperCase(c) || specialLetters.contains(charact)) {
	        	
	        	// get the integer corresponding to the symbol.
	        	if (specialLetters.contains(charact)) {
	        		code = AllKeys.letterToNumbForSpecialLetters(charact);
	        	}
	        	
	        	// now order the computer to simulate the key presses towards those letters.
	            r.keyPress(KeyEvent.VK_SHIFT);
	            r.keyPress(code);
		        r.keyRelease(code);
		        r.keyRelease(KeyEvent.VK_SHIFT);
		        
	        // otherwise,
	        } else {
	        	
	        	// simulate these key presses.
	        	r.keyPress(code);
	        	r.keyRelease(code);
	        	
	        }
	        Thread.sleep(100);
	    }
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException, FontFormatException, IOException {
		
		// Initializing the window here.
		JFrame frame = new JFrame("AutoType");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.setPreferredSize(new Dimension(1280, 200));
		frame.setLocation(screenSize.width / 2, screenSize.height / 2);
		
		
		// TextField component that accepts whatever 
		// keyboard characters the user types.
		JTextField textBox = new JTextField();
		textBox.setEditable(true);
		textBox.setPreferredSize(new Dimension(500, 50));
		textBox.setFont(textFont);
		// Set DocumentFilter for textBox; in which the font size will be increased.
		
		// Button component that accepts whatever text is given from
		// JTextField.
		JButton OKbutt = new JButton("Ok");
		Font buttFont = new Font("sans serif", 20, 30);
		OKbutt.setFont(buttFont);
		OKbutt.setPreferredSize(new Dimension(200, 50));
		OKbutt.setMnemonic(KeyEvent.VK_ENTER);
		
		// Repetition text to repeat how long the text will be running.
		JTextField timeBox = new JTextField();
		timeBox.setEditable(true);
		timeBox.setPreferredSize(new Dimension(500, 50));
		timeBox.setFont(textFont);
		
		// A Filter to prevent user from typing characters
		// other than integers, and that size is increased.
		PlainDocument giveTime = (PlainDocument) timeBox.getDocument();
		giveTime.setDocumentFilter(new IntegerFilter());
		
		// Placing components into the JPanel.
		panel.add(textBox);
		//panel.add(timeBox);
		panel.add(OKbutt);

		// When "OK" button is pressed, window will close
		// and commence the typing.
		OKbutt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame.dispose();
					Thread.sleep(3000);
					AutoTypedWindow(textBox.getText());
				} catch (AWTException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		// other JFrame-related stuff.
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
