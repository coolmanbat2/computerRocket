/*
 * Note this program is still in development.
 * Date: October 1st, 2018
 * NOTE: If you forget how to push and commit files into git for another branch
 * refer to the Chrome bookmark you made at this date. :---------).
 */


package window;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
	
	// public private window stuff.
	private JPanel panel = new JPanel(new GridBagLayout());
	private GridBagConstraints constraints = new GridBagConstraints();
	
	// Actual buttons
	private JButton startButt = new JButton("Start");
	private JButton quitButt = new JButton("Quit");
	
	// labeling stuff: 
	private JLabel informUser = new JLabel("Half Life AimBot: Press start to get started.");
	
	// boolean for quitting loop; 
	private boolean theQuitter = false;
	/*=================================== FRONT-END STUFF ====================================== */	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int width, int height) {

		// start button stuff :--)
		startButt.addActionListener(trigger());
		startButt.setPreferredSize(new Dimension(200, 100));
		startButt.setMnemonic(KeyEvent.VK_ENTER);
		startButt.setLocation(0, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(startButt, constraints);
		
		// Label that gives the space in between the two buttons. 
		Font font = new Font("serif", 15, 25);
		informUser.setFont(font);
		// Constraints to locate the component.
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(-10, 0,0,0);
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(informUser, constraints);
		
		// quit button stuff :----)
		quitButt.addActionListener(quit());
		quitButt.setPreferredSize(new Dimension(200, 100));
		quitButt.setMnemonic(KeyEvent.VK_ENTER);
		quitButt.setLocation(0, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 2;
		constraints.gridy = 1;
		panel.add(quitButt, constraints);
		
		// Window stuff.
		// Window setup stuff.
		JFrame main = new JFrame("Test");
		main.setSize(width, height);
		//main.setBounds(100, 100, width, height);
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
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		};
	}
	
	/**
	 * Program is safely shut down here.
	 * @return
	 */
	private ActionListener quit() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				theQuitter = true;
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
	private void aimBot() throws IOException {
		// Assuming the game is running Full Screen.
		
		
		// First get the game screen.
		AimBot fcnCall = new AimBot();
		boolean gameRunning = fcnCall.isGame();
		
		// In order for this progarm to continue (while also having buttons work);
		// a Thread is required.
		// Current problem with Thread: program still runs indefinitely.. Solution: Research more on Threads. 
		Thread aimBotAction = new Thread() {
			@Override
			public void run() {
				while (!theQuitter) {
					// If the game is running then, 
					if (gameRunning) {
						// start the "aimbot"
						Robot mouse;
						System.out.println("testing");
						try {
							mouse = new Robot();
							BufferedImage gameScreen = mouse.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
							Graphics2D graphics = gameScreen.createGraphics();
							// Once game screen is obtained
							// Figure out which parts are heads or not.
							// DO THE SCREEN CAPTURE OF JUST ONE APPLICATION.
							File finalOut = new File("gameScreen.png");
							try {
								ImageIO.write(gameScreen, "png", finalOut);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (AWTException e1) {
							e1.printStackTrace();
						}
					// otherwise, tell the user to run the game.
					} else {
						Font font = new Font("serif", 15, 25);
						informUser.setText("Please run the fucking game, Thanks!");
						informUser.setFont(font);
						// Constraints to locate the component.
						constraints.fill = GridBagConstraints.HORIZONTAL;
						constraints.insets = new Insets(-10, 0,0,0);
						constraints.gridx = 1;
						constraints.gridy = 0;
						
						panel.validate();
					}
				}
			}
		};
		aimBotAction.run();
		// Once figured out.. aim the mouse right at their head and shoots :---).
	}

}
