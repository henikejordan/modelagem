package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroNormalizado extends Filtro {

    @Override
    public void aplicarFiltro(String dirIn, String dirOut) {
        Mat image = imread(dirIn);
        blur(image, image, new Size(5, 5));
        imwrite(dirOut, image);
    }

}
