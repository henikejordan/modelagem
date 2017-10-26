package modelo;

import dao.DoencaDAO;
import dao.CreatorDAO;

public class Doenca {

    private char nome;

    private char tipo;

    private char descricao;

    private char caracteristica;

    private Cultura[] cultura;

    private DoencaDAO doencaDAO;

    private CreatorDAO dAOCreator;

    private Quantificacao[] quantificacao;

}
