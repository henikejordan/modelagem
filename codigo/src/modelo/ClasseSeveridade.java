package modelo;

import dao.ClasseSeveridadeDAO;
import dao.CreatorDAO;

public class ClasseSeveridade extends MedicaoVisual {

    private char descricao;

    private float inferior;

    private float superior;

    private ClasseSeveridadeDAO classeSeveridadeDAO;

    private CreatorDAO dAOCreator;

}
