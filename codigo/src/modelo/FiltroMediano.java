package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroMediano implements Filtro {

    @Override
    public void aplicarFiltro(String dirIn, String dirOut) {
        Mat image = imread(dirIn);
        medianBlur(image, image, 3);
        imwrite(dirOut, image);
    }

}
