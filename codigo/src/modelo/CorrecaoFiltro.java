package modelo;

import org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;

public class CorrecaoFiltro extends Correcao {

    @Override
    public void corrigirImagem() {
        Mat image = imread(getInput());
        cvtColor(image, image, CV_BGR2GRAY);
        imwrite(getInput(), image);
    }

}
