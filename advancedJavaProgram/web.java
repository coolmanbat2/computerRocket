package playground;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.github.sarxos.webcam.*;
import playground.GUIForWebcam;


/*
 * I'm just going to open the webcam,
 * take a picture,
 * close the camera,
 * then show the camera to the user.
 * Copyright 2017 Thanusun.
 */

public class web {
	public static void main(String[] args) throws IOException, WebcamException, TimeoutException {
		Webcam webcam = Webcam.getDefault();
		GUIForWebcam.webcamWindow(webcam);
		if (webcam == null) {
			webcam.close();
		}
	}
}
