package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroNormalizado extends Filtro {

    @Override
    public void aplicarFiltro() {
        Mat image = imread(getInput());
        blur(image, image, new Size(5, 5));
        imwrite(getInput(), image);
    }

}
