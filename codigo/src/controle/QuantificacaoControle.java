package controle;

import dao.ClasseSeveridadeDAO;
import dao.ConcreteCreatorDAO;
import dao.DAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.ClasseSeveridade;
import modelo.ConcreteCreatorQuantificacao;
import modelo.Doenca;
import modelo.Incidencia;
import modelo.MedicaoDireta;
import modelo.Quantificacao;
import modelo.iterator.Iterator;
import modelo.iterator.Lista;

/**
 *
 * @author henik
 */
public class QuantificacaoControle {

    private String dirIn, dirOut;
    private final DAO daoDoenca;

    public QuantificacaoControle(String dirIn) {
        daoDoenca = new ConcreteCreatorDAO().factoryMethod("Doença");
        this.dirIn = dirIn;
        dirOut = gerarNomeArquivo();
        apagarDiretorioImagens();
        copiarArquivo(dirIn, dirOut);
    }

    public void quantificar(String metodo, Doenca doenca) {
        Quantificacao quantificacao = new ConcreteCreatorQuantificacao().factoryMethod(metodo);
        switch (metodo) {
            case "Incidência":
                Incidencia incidencia = (Incidencia) quantificacao;
                JOptionPane.showMessageDialog(null, "Porcentagem de doença: " + (incidencia.calculaIncidencia(dirIn) <= 100 ? incidencia.calculaIncidencia(dirIn) : 100) + "%");
                break;
            case "Medição Direta":
                MedicaoDireta medicaoDireta = (MedicaoDireta) quantificacao;
                JOptionPane.showMessageDialog(null, "Porcentagem de doença: " + (medicaoDireta.calculaAreaInfectada(dirIn) <= 100 ? medicaoDireta.calculaAreaInfectada(dirIn) : 100) + "%");
                break;
            case "Classe Severidade":
                ClasseSeveridadeDAO daoClasse = (ClasseSeveridadeDAO) new ConcreteCreatorDAO().factoryMethod(metodo);
                ClasseSeveridade classe = (ClasseSeveridade) quantificacao;
                Iterator ci = daoClasse.pesquisar(doenca.getIdDoenca()).getIterator();
                for (ci.primeiro(); !ci.isFinalizado(); ci.proximo()) {
                    ClasseSeveridade c = (ClasseSeveridade) ci.getAtual();
                    if (classe.calculaAreaInfectada(dirIn) > c.getInferior() && classe.calculaAreaInfectada(dirIn) < c.getSuperior()) {
                        JOptionPane.showMessageDialog(null, "Classe de Severidade da doença: " + c.getDescricao());
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

    public Lista getDoencas() {
        return daoDoenca.pesquisar("");
    }

    public String getDirIn() {
        return dirIn;
    }

    public void setDirIn(String dirIn) {
        this.dirIn = dirIn;
    }

    public String getDirOut() {
        return dirOut;
    }

    public void setDirOut(String dirOut) {
        this.dirOut = dirOut;
    }

    private String gerarNomeArquivo() {
        Random random = new Random();
        String aux = "img/";
        for (int i = 0; i < 5; i++) {
            aux += random.nextInt(10);
        }
        aux += ".jpg";
        return aux;
    }

    private void copiarArquivo(String entrada, String saida) {
        apagarDiretorioImagens();
        FileInputStream origem;
        FileOutputStream destino;
        FileChannel fcOrigem;
        FileChannel fcDestino;
        try {
            origem = new FileInputStream(entrada);
            destino = new FileOutputStream(saida);
            fcOrigem = origem.getChannel();
            fcDestino = destino.getChannel();
            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
            origem.close();
            destino.close();
        } catch (IOException ex) {
            //
        }
    }

    private void apagarDiretorioImagens() {
        File folder = new File("img/");
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }

}
