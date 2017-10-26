package modelo;

public class ConcreteCulturaCreator implements CulturaCreator {

    @Override
    public Cultura factoryMethod(String tipo) {
        switch (tipo) {
            case "Folha":
                return new Folha();
            case "Fruto":
                return new Fruto();
            case "Grão":
                return new Grao();
            default:
                return null;
        }
    }

}
