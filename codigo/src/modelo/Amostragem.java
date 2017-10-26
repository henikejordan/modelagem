package modelo;

import dao.AmostragemDAO;
import dao.CreatorDAO;

public class Amostragem {

    private char tipo;

    private int tamanho;

    private char local;

    private int epoca;

    private char objetivo;

    private Imagem[] imagem;

    private AmostragemDAO amostragemDAO;

    private CreatorDAO dAOCreator;

}
