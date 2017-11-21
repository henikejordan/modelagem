package modelo;

public class ConcreteCreatorQuantificacao {

    public Quantificacao factoryMethod(String tipo) {
        switch (tipo) {
            case "Incidência":
                return new Incidencia();
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
