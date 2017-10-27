package dao;

public class ConcreteCreatorDAO implements CreatorDAO {

    @Override
    public DAO factoryMethod(String tipo) {
        switch (tipo) {
            case "Amostragem":
                return new AmostragemDAO();
            case "Câmera":
                return new CameraDAO();
            case "ClasseSeveridade":
                return new ClasseSeveridadeDAO();
            case "Cultura":
                return new CulturaDAO();
            case "Doença":
                return new DoencaDAO();
            case "Imagem":
                return new ImagemDAO();
            default:
                return null;
        }
    }

}
