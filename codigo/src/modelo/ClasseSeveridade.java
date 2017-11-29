package modelo;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;

public class ClasseSeveridade extends MedicaoVisual {

    private int idClasseSeveridade;
    private String descricao;
    private float inferior;
    private float superior;

    public int getIdClasseSeveridade() {
        return idClasseSeveridade;
    }

    public void setIdClasseSeveridade(int idClasseSeveridade) {
        this.idClasseSeveridade = idClasseSeveridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getInferior() {
        return inferior;
    }

    public void setInferior(float inferior) {
        this.inferior = inferior;
    }

    public float getSuperior() {
        return superior;
    }

    public void setSuperior(float superior) {
        this.superior = superior;
    }

    public float calculaAreaInfectada(String dir) {
        Mat image = imread(dir);
        threshold(image, image, 200, 255, CV_THRESH_BINARY);
        cvtColor(image, image, CV_BGR2GRAY);
        int total = image.arrayHeight() * image.arrayWidth() - countNonZero(image);

        image = imread(dir);
        threshold(image, image, 127, 255, CV_THRESH_BINARY);
        cvtColor(image, image, CV_BGR2GRAY);
        int doente = image.arrayHeight() * image.arrayWidth() - countNonZero(image);
        return (float) doente / total * 100;
    }

}
