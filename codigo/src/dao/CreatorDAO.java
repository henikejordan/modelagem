package dao;

public class CreatorDAO {

    public DAO factoryMethod(String tipo) {
        switch (tipo) {
            case "Amostragem":
                return new AmostragemDAO();
            case "Câmera":
                return new CameraDAO();
            case "Classe Severidade":
                return new ClasseSeveridadeDAO();
            case "Cultura":
                return new CulturaDAO();
            case "Doença":
                return new DoencaDAO();
            default:
                return null;
        }
    }

}
