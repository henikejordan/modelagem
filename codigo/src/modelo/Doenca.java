package modelo;

import dao.DoencaDAO;
import dao.DAOCreator;

public class Doenca {

    private char nome;

    private char tipo;

    private char descricao;

    private char caracteristica;

    private Cultura[] cultura;

    private DoencaDAO doencaDAO;

    private DAOCreator dAOCreator;

    private Quantificacao[] quantificacao;

}
