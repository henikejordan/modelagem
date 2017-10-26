package modelo;

import dao.DAOCreator;
import dao.AmostragemDAO;

public class Amostragem {

    private char tipo;

    private int tamanho;

    private char local;

    private int epoca;

    private char objetivo;

    private Imagem[] imagem;

    private AmostragemDAO amostragemDAO;

    private DAOCreator dAOCreator;

}
