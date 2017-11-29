package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class Incidencia extends Intensidade {

    private int totalOrgaos;
    private int totalOrgaosDoentes;

    public float calculaIncidencia(String dir) {
        Mat src = imread(dir, IMREAD_GRAYSCALE);
        MatVector contours = new MatVector();
        threshold(src, src, 200, 255, 1);
        findContours(src, contours, 1, 2);
        totalOrgaos = (int) contours.size();

        src = imread(dir, IMREAD_GRAYSCALE);
        contours = new MatVector();
        threshold(src, src, 80, 255, 1);
        erode(src, src, new Mat());
        findContours(src, contours, 1, 2);
        totalOrgaosDoentes = (int) contours.size();

        return totalOrgaosDoentes / totalOrgaos * 100;
    }

}
