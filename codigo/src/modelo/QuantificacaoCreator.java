package modelo;

public class QuantificacaoCreator {

    public Quantificacao factoryMethod(String tipo) {
        switch (tipo) {
            case "Incidência":
                return new Incidencia();
            case "Intensidade":
                return new Intensidade();
            case "Medição Direta":
                return new MedicaoDireta();
            case "Classe Severidade":
                return new ClasseSeveridade();
            case "Escalas Diagramáticas":
                return new EscalasDiagramaticas();
            default:
                return null;
        }
    }

}
