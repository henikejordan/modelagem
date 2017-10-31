package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroMediano extends Filtro {

    @Override
    public void aplicarFiltro() {
        Mat image = imread(getInput());
        medianBlur(image, image, 3);
        imwrite(getInput(), image);
    }

}
