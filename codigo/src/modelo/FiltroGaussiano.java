package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

public class FiltroGaussiano extends Filtro {

    @Override
    public void aplicarFiltro() {
        Mat image = imread(getInput());
        GaussianBlur(image, image, new Size(5, 5), BORDER_DEFAULT);
        imwrite(getInput(), image);
    }

}
