package window;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AimBot {

	private JFrame main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AimBot window = new AimBot();
				window.initialize(1280, 720);
			}
		});
	}
	
	
	/**
	 * ActionListener for a button when pressed.
	 * @return
	 */
	private ActionListener gg() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean gameResult = isGame();
					aimBot();
				} catch (AWTException | IOException e) {
					e.printStackTrace();
				}		
			}
		};
	}
	
	/**
	 * Figures out if a game is currently running..
	 * @return
	 */
	private boolean isGame() {
		return false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int width, int height) {
		main = new JFrame("Test");
		main.setBounds(100, 100, width, height);
		JButton butt = new JButton("Start");
		butt.addActionListener(gg());
		butt.setPreferredSize(new Dimension(200, 100));
		main.add(butt);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}
	
	/**
	 * Start the aimbotting program here.
	 * @throws AWTException 
	 * @throws IOException 
	 */
	private void aimBot() throws AWTException, IOException {
		// Assuming the game is running Full Screen.
		
		
		// First get the game screen.
		Robot mouse = new Robot();
		BufferedImage gameScreen = mouse.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
		Graphics2D graphics = gameScreen.createGraphics();
		// Once game screen is obtained
		// Figure out which parts are heads or not.
		File finalOut = new File("gameScreen.png");
		ImageIO.write(gameScreen, "png", finalOut);
		// Once figured out.. aim the mouse right at their head and shoots :---).
	}

}
