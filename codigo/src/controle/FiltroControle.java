package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import modelo.Filtro;
import visao.DrawingPanel;

/**
 *
 * @author henik
 */
public class FiltroControle {

    private String dirIn, dirOut;

    public FiltroControle(String dirIn) {
        this.dirIn = dirIn;
        dirOut = gerarNomeArquivo();
        apagarDiretorioImagens();
        copiarArquivo(dirIn, dirOut);
    }

    public void aplicarFiltro(Filtro filtro, DrawingPanel panelImagem) {
        dirOut = gerarNomeArquivo();
        filtro.aplicarFiltro(dirIn, dirOut);
        panelImagem.setDirIn(dirOut);
        panelImagem.setDirOut(dirOut);
        panelImagem.repaint();
        new File(dirIn).delete();
        dirIn = dirOut;
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

    public void copiarArquivo(String entrada, String saida) {
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
