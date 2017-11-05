package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroBilateral extends Filtro {

    @Override
    public void aplicarFiltro() {
        Mat image = imread(getDirIn()), dst = new Mat();
        bilateralFilter(image, dst, 3, 255, 255, BORDER_DEFAULT);
        imwrite(getDirOut(), dst);
    }

}
