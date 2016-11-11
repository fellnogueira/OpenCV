package javacv.opencvebook;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

public class SimpleSample {

	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

	public static void main(String[] args) {

		 System.out.println("Welcome to OpenCV " + Core.VERSION);
		 Mat m = new Mat(10, 10, CvType.CV_8UC1, new Scalar(1));
		 System.out.println("OpenCV Mat: " + m);
		 Mat mr1 = m.row(1);
		 mr1.setTo(new Scalar(1));
		 Mat mc5 = m.col(2);
		 mc5.setTo(new Scalar(2));
		 System.out.println("OpenCV Mat data:\n" + m.dump());
	}
}