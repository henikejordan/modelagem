package modelo;

import dao.CameraDAO;
import dao.CreatorDAO;

public class Camera {

    private float marca;

    private char modelo;

    private float distancia_focal;

    private int largura_resolucao;

    private int altura_resolucao;

    private char tipo_lente;

    private Amostragem[] amostragem;

    private CameraDAO cameraDAO;

    private CreatorDAO dAOCreator;

}
