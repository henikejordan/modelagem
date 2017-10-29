package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ClasseSeveridade;
import modelo.Doenca;
import modelo.QuantificacaoCreator;

public class ClasseSeveridadeDAO extends DAO {

    @Override
    public ArrayList lerTodos() {
        ArrayList<ClasseSeveridade> classes = new ArrayList();
        ResultSet resultado = super.getConecta().executaSQL("select * from classe_severidade");
        try {
            resultado.first();
            do {
                classes.add((ClasseSeveridade) ler(resultado.getInt("id_classe_severidade")));
            } while (resultado.next());
        } catch (SQLException ex) {
            //
        }
        return classes;
    }

    @Override
    public Object ler(int id) {
        ClasseSeveridade classeSeveridade = (ClasseSeveridade) new QuantificacaoCreator().factoryMethod("Classe Severidade");
        Doenca doenca = new Doenca();
        ResultSet resultClasse = super.getConecta().executaSQL("select * from classe_severidade where id_classe_severidade='" + id + "'");
        try {
            resultClasse.first();
            classeSeveridade.setIdClasseSeveridade(resultClasse.getInt("id_classe_severidade"));
            classeSeveridade.setDescricao(resultClasse.getString("descricao"));
            classeSeveridade.setInferior(resultClasse.getFloat("inferior"));
            classeSeveridade.setSuperior(resultClasse.getFloat("superior"));
            ResultSet resultDoenca = super.getConecta().executaSQL("select * from doenca where id_doenca='" + resultClasse.getInt("id_doenca") + "'");
            resultDoenca.first();
            doenca.setIdDoenca(resultDoenca.getInt("id_doenca"));
            doenca.setNome(resultDoenca.getString("nome"));
            doenca.setTipo(resultDoenca.getString("tipo"));
            doenca.setCaracteristica(resultDoenca.getString("caracteristica"));
            doenca.setDescricao(resultDoenca.getString("descricao"));
            classeSeveridade.setDoenca(doenca);
        } catch (SQLException ex) {
            //
        }
        return classeSeveridade;
    }

    @Override
    public boolean inserir(Object obj) {
        ClasseSeveridade classeSeveridade = (ClasseSeveridade) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("insert into classe_severidade(descricao, inferior, superior, id_doenca) values(?,?,?,?)");
            pst.setString(1, classeSeveridade.getDescricao());
            pst.setFloat(2, classeSeveridade.getInferior());
            pst.setFloat(3, classeSeveridade.getSuperior());
            pst.setInt(4, classeSeveridade.getDoenca().getIdDoenca());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean alterar(Object obj) {
        ClasseSeveridade classeSeveridade = (ClasseSeveridade) obj;
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("update classe_severidade set descricao=?, inferior=?, superior=?, id_doenca=? where id_classe_severidade=?");
            pst.setString(1, classeSeveridade.getDescricao());
            pst.setFloat(2, classeSeveridade.getInferior());
            pst.setFloat(3, classeSeveridade.getSuperior());
            pst.setInt(4, classeSeveridade.getDoenca().getIdDoenca());
            pst.setInt(5, classeSeveridade.getIdClasseSeveridade());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    @Override
    public boolean excluir(int id) {
        try {
            PreparedStatement pst = super.getConecta().getConnection().prepareStatement("delete from classe_severidade where id_classe_severidade=?");
            pst.setInt(1, id);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

}
