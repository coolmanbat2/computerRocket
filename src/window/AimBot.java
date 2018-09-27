package window;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AimBot {

	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints constraints = new GridBagConstraints();
	private JButton butt = new JButton("Start");

	/*=================================== FRONT-END STUFF ====================================== */	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int width, int height) {

		// button stuff :-)
		butt.addActionListener(trigger());
		butt.setPreferredSize(new Dimension(200, 100));
		butt.setMnemonic(KeyEvent.VK_ENTER);
		butt.setLocation(0, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		
		
		// Window stuff.
		// Window setup stuff.
		JFrame main = new JFrame("Test");
		main.setBounds(100, 100, width, height);
		panel.add(butt, constraints);
		main.add(panel);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}
	
	
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
	
	/* ================================================== BACK-END INFORMATION ====================================================== */
	
	/**
	 * ActionListener for a button when pressed, it will start
	 * the program for aim botting :-)
	 * @return
	 */
	private ActionListener trigger() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
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
	 * @throws IOException 
	 */
	private boolean isGame() throws IOException {
		boolean gameRunning = false;
		Process p = Runtime.getRuntime().exec("tasklist");
		// Reads all the current processes running.
		BufferedReader readTasks = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		
		// Read through all tasks and see which one is running the game.
		String tasksAvaliable = "";
		while (tasksAvaliable != null) {
			if (tasksAvaliable.startsWith("MinecraftLauncher.exe")) {
				gameRunning = true;
				tasksAvaliable = null;
			} else {
				tasksAvaliable = readTasks.readLine();
			}
		}
		return gameRunning;
	}
	
	/**
	 * Start the aimbotting program here.
	 * @throws AWTException 
	 * @throws IOException 
	 */
	private void aimBot() throws AWTException, IOException {
		// Assuming the game is running Full Screen.
		
		
		// First get the game screen.
		// PROGRAM WILL NOT RETURN TRUE :(
		AimBot fcnCall = new AimBot();
		boolean gameRunning = fcnCall.isGame();
		// If the game is running then, 
		if (gameRunning) {
			// start the "aimbot"
			Robot mouse = new Robot();
			BufferedImage gameScreen = mouse.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
			Graphics2D graphics = gameScreen.createGraphics();
			// Once game screen is obtained
			// Figure out which parts are heads or not.
			// DO THE SCREEN CAPTURE OF JUST ONE APPLICATION.
			File finalOut = new File("gameScreen.png");
			ImageIO.write(gameScreen, "png", finalOut);
		// otherwise, tell the user to run the game.
		} else {
			Font font = new Font("serif", 15, 25);
			JLabel informUser = new JLabel("Please run the fucking game, Thanks!");
			informUser.setFont(font);
			// Constraints to locate the component.
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = 1;
			constraints.gridy = 0;
			
			panel.add(informUser, constraints);
			panel.validate();
		}
		

		// Once figured out.. aim the mouse right at their head and shoots :---).
	}

}
