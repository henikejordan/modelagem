package modelo;

public class ImagemProxy extends Imagem {

    private ImagemReal imagemReal;

    @Override
    public void carregarImagem() {
        if (imagemReal == null) {
            imagemReal = new ImagemReal();
        }
        imagemReal.carregarImagem();
    }

}
