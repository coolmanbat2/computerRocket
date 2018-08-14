package busTime;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * This program will provide an ascii number for ANY character that is typed
 * into the system. It provides a user with much more ease of finding what key
 * will map into another machine.
 * @author thanu
 *
 */
public class KeyboardKeys {
	
	private static JPanel panel = new JPanel();
	private static JFrame frame = new JFrame("HELO");
	
	/**
	 * The window is intialized and setup for any additional
	 * features that need to be added into the software.
	 * @author thanu
	 * @since 2018
	 */
	public static void ourFrame() {
		// Obtaining screen size here.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Frame setup.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1080, 300));
		frame.setLocation((int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	/**
	 * This contains all the additional features the window requires in order
	 * for the program to run properly. 
	 * @author thanu
	 * @since 2018
	 */
	public static void frameAdditions() {
		// Label for seeing letters.
				Font lettFont = new Font("sans serif", 20, 50);
				JLabel letter = new JLabel("Type in a keycode and you'll get its value here.");
				//letter.setAlignmentX(Component.CENTER_ALIGNMENT);
				//letter.setAlignmentY(Component.TOP_ALIGNMENT);
				letter.setFont(lettFont);
				panel.add(letter);
				panel.setVisible(true);
				
				// Label to see corresponding keycode for the letter.
				JLabel keyCode = new JLabel();
				//keyCode.setAlignmentX(Component.CENTER_ALIGNMENT);
				//keyCode.setAlignmentY(Component.CENTER_ALIGNMENT);
				panel.add(keyCode);
				
				// KeyCode.
				frame.addKeyListener(new KeyListener() {

					@Override
					public void keyPressed(KeyEvent e) {
						
						// This will get the key character from the user,
						// then update the frame for the user.
						Font font = new Font("sans serif", 20, 70);
						String character = e.getKeyChar() + ""; // this works... but the other way doesn't.. OK. :-)
						keyCode.setFont(font);
						
						// Along with the update of letters, the corresponding
						// key code will be shown here.
						int numCode = e.getKeyCode();
						keyCode.setText(character + " corresponds to number: " + numCode);
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
	}
	
	/**
	 * KeyboardKeys starts off here.
	 * @param args
	 */
	public static void main(String args[]) {
		ourFrame();
		frameAdditions();
		
	}
}
