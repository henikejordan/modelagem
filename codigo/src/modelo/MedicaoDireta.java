package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class MedicaoDireta extends Severidade {

    private int numeroLesoes;
    private float diametroMedioLesoes;
    private float indiceInfeccao;

    public float calculaAreaInfectada() {
        Mat image = imread(getDir());
        threshold(image, image, 200, 255, CV_THRESH_BINARY);
        cvtColor(image, image, CV_BGR2GRAY);
        int total = image.arrayHeight() * image.arrayWidth() - countNonZero(image);

        image = imread(getDir());
        threshold(image, image, 127, 255, CV_THRESH_BINARY);
        cvtColor(image, image, CV_BGR2GRAY);
        int doente = image.arrayHeight() * image.arrayWidth() - countNonZero(image);
        return (float) doente / total * 100;
    }

    public float calculaIndiceInfeccao() {
        return 0;
    }

}
