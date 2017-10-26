package modelo;

import dao.ClasseSeveridadeDAO;
import dao.DAOCreator;

public class ClasseSeveridade extends MedicaoVisual {

    private char descricao;

    private float inferior;

    private float superior;

    private ClasseSeveridadeDAO classeSeveridadeDAO;

    private DAOCreator dAOCreator;

}
