package visao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Random;
import modelo.Filtro;
import modelo.FiltroBilateral;
import modelo.FiltroNormalizado;
import modelo.FiltroGaussiano;
import modelo.FiltroMediano;

/**
 *
 * @author henik
 */
public class TelaFiltro extends javax.swing.JFrame {

    private String dirIn, dirOut;

    /**
     * Creates new form NovoJFrame
     *
     * @param dirIn
     */
    public TelaFiltro(String dirIn) {
        dirOut = gerarNomeArquivo();
        copiarArquivo(dirIn, dirOut);
        this.dirIn = dirOut;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNormal = new javax.swing.JButton();
        panelImagem = new visao.DrawingPanel();
        jButtonGauss = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonMediano = new javax.swing.JButton();
        jButtonBilateral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Imagem");

        jButtonNormal.setText("Normalizado");
        jButtonNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNormalActionPerformed(evt);
            }
        });

        panelImagem.setDirIn(dirIn);
        panelImagem.setDirOut(dirOut);

        javax.swing.GroupLayout panelImagemLayout = new javax.swing.GroupLayout(panelImagem);
        panelImagem.setLayout(panelImagemLayout);
        panelImagemLayout.setHorizontalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImagemLayout.setVerticalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jButtonGauss.setText("Gaussiano");
        jButtonGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGaussActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonMediano.setText("Mediano");
        jButtonMediano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMedianoActionPerformed(evt);
            }
        });

        jButtonBilateral.setText("Bilateral");
        jButtonBilateral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBilateralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButtonNormal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGauss)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMediano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBilateral)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNormal)
                    .addComponent(jButtonGauss)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonMediano)
                    .addComponent(jButtonBilateral))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNormalActionPerformed
        aplicarFiltro(new FiltroNormalizado());
    }//GEN-LAST:event_jButtonNormalActionPerformed

    private void jButtonGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGaussActionPerformed
        aplicarFiltro(new FiltroGaussiano());
    }//GEN-LAST:event_jButtonGaussActionPerformed

    private void jButtonMedianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedianoActionPerformed
        aplicarFiltro(new FiltroMediano());
    }//GEN-LAST:event_jButtonMedianoActionPerformed

    private void jButtonBilateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBilateralActionPerformed
        aplicarFiltro(new FiltroBilateral());
    }//GEN-LAST:event_jButtonBilateralActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void aplicarFiltro(Filtro filtro) {
        dirOut = gerarNomeArquivo();
        filtro.aplicarFiltro(dirIn, dirOut);
        panelImagem.setDirIn(dirOut);
        panelImagem.setDirOut(dirOut);
        panelImagem.repaint();
        new File(dirIn).delete();
        dirIn = dirOut;
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
        } catch (Exception ex) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBilateral;
    private javax.swing.JButton jButtonGauss;
    private javax.swing.JButton jButtonMediano;
    private javax.swing.JButton jButtonNormal;
    private javax.swing.JButton jButtonSair;
    private visao.DrawingPanel panelImagem;
    // End of variables declaration//GEN-END:variables
}
