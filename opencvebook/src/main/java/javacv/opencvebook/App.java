package javacv.opencvebook;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Hello world!
 *
 */
public class App {

	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
		
    public static void main( String[] args ){
    	
		String filePath = "resource/cathedral.jpg";
		Mat newImage = Imgcodecs.imread(filePath);
		if (newImage.dataAddr() == 0) {
			System.out.println("Couldn't open file " + filePath);
		} else {
			
			GUI gui = new GUI("no name", newImage);
			gui.init();
//			ImageViewer imageViewer = new ImageViewer();
//			imageViewer.show(newImage, "Loaded image");
		}
    	
    }

}
