package Modelo;

public abstract class Imagem {

    private char nome;

    private char extensao;

    private char caminho;

    private float tamanho;

    private int altura;

    private int largura;

    private CorrecaoCreator[] correcaoCreator;

    private ImagemDAO imagemDAO;

    private DAOCreator dAOCreator;

    public void carregaImagem() {

    }

}
