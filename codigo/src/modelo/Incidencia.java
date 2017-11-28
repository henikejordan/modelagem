package modelo;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class Incidencia extends Intensidade {

    private int totalOrgaos;
    private int totalOrgaosDoentes;

    public float calculaIncidencia(String dir) {
        Mat src = imread(dir);
        MatVector contours = new MatVector();
        Mat hierarchy = new Mat();

        threshold(src, src, 127, 255, THRESH_BINARY);
        cvtColor(src, src, CV_BGR2GRAY);
        findContours(src, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE);
        totalOrgaos = (int) contours.size();

        src = imread(dir);
        contours = new MatVector();
        hierarchy = new Mat();

        threshold(src, src, 200, 255, THRESH_BINARY);
        cvtColor(src, src, CV_BGR2GRAY);
        findContours(src, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_NONE);
        totalOrgaosDoentes = (int) contours.size();

        return totalOrgaosDoentes / totalOrgaos * 100;
    }

}
