package modelo;

import dao.ImagemDAO;
import dao.CreatorDAO;

public abstract class Imagem {

    private char nome;

    private char extensao;

    private char caminho;

    private float tamanho;

    private int altura;

    private int largura;

    private CreatorCorrecao[] correcaoCreator;

    private ImagemDAO imagemDAO;

    private CreatorDAO dAOCreator;

    public void carregaImagem() {

    }

}
