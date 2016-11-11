package javacv.opencvebook;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class CameraVideoCapture {

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	private JFrame frame;
	private JLabel imageLabel;
	private VideoCapture capture;

	public static void main(String[] args) {

		CameraVideoCapture cvc = new CameraVideoCapture();

		cvc.initGUI();
		cvc.ruMainLoop(args);
	}

	private void ruMainLoop(String[] args) {

		ImageProcessor imageProcessor = new ImageProcessor();
		Mat webcamMatImage = new Mat();
		Image tempImage;
		capture = new VideoCapture(0);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);

		if (capture.isOpened()) {
			while (true) {
				capture.read(webcamMatImage);
//				System.out.println("capturing...");
				if (!webcamMatImage.empty()) {
					tempImage = imageProcessor.toBufferedImage(webcamMatImage);
					ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");
					imageLabel.setIcon(imageIcon);
					frame.pack();
				} else {
					System.out.println(" -- Frame not captured -- Break!");
					break;
				}
			}
		}
	}

	private void initGUI() {

		frame = new JFrame("Camera Input Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		imageLabel = new JLabel();
		frame.add(imageLabel);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	capture.release();
            	System.exit(0);
            }
        });

	}
	
}