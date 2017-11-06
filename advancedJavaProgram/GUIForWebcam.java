package playground;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import java.awt.*;
import java.awt.event.*;

/**
 * Purpose: The purpose of this program is to present a GUI, and
 * present anything when given the opportunity for it. 
 * @author ProgrammerA
 *
 */
public class GUIForWebcam {
	/**
	 * This is the literal GUI, set for a size of 800, 600; and must be given a camera
	 * in order to display it.
	 * 
	 * @param comp
	 */
	public static void webcamWindow(Webcam camera) {
		JFrame window = new JFrame("Webcam");
		JPanel webcam = new WebcamPanel(camera.getDefault());
		window.add(webcam);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
		window.setSize(new Dimension(800, 600));
	}
}
