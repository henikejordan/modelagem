package modelo;

import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.CV_THRESH_BINARY;
import static org.bytedeco.javacpp.opencv_imgproc.threshold;

public class CorrecaoRuido extends Correcao {

    @Override
    public void corrigirImagem() {
        Mat image = imread(getInput());
        threshold(image, image, 127, 255, CV_THRESH_BINARY);
        imwrite(getInput(), image);
    }

}
