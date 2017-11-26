package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import javax.swing.JOptionPane;
import modelo.ConcreteCreatorQuantificacao;
import modelo.MedicaoDireta;

/**
 *
 * @author henik
 */
public class MedicaoDiretaControle {

    private String dirIn, dirOut;

    public MedicaoDiretaControle(String dirIn) {
        this.dirIn = dirIn;
        dirOut = gerarNomeArquivo();
        apagarDiretorioImagens();
        copiarArquivo(dirIn, dirOut);
    }

    public void quantificar() {
        MedicaoDireta medicaoDireta = (MedicaoDireta) new ConcreteCreatorQuantificacao().factoryMethod("Medição Direta");
        JOptionPane.showMessageDialog(null, "Porcentagem de doença: " + medicaoDireta.calculaAreaInfectada(dirIn) + "%");
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
