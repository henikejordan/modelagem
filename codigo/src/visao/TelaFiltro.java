package visao;

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

    private final String dir;
    private final String dirOut = "img/image.jpg";

    /**
     * Creates new form NovoJFrame
     *
     * @param dir
     */
    public TelaFiltro(String dir) {
        this.dir = dir;
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

        panelImagem.setDir(dir);

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
        FiltroNormalizado filtroNormalizado = new FiltroNormalizado();
        aplicarFiltro(filtroNormalizado);
    }//GEN-LAST:event_jButtonNormalActionPerformed

    private void jButtonGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGaussActionPerformed
        FiltroGaussiano filtroGaussiano = new FiltroGaussiano();
        aplicarFiltro(filtroGaussiano);
    }//GEN-LAST:event_jButtonGaussActionPerformed

    private void jButtonMedianoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMedianoActionPerformed
        FiltroMediano filtroMediano = new FiltroMediano();
        aplicarFiltro(filtroMediano);
    }//GEN-LAST:event_jButtonMedianoActionPerformed

    private void jButtonBilateralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBilateralActionPerformed
        FiltroBilateral filtroBilateral = new FiltroBilateral();
        aplicarFiltro(filtroBilateral);
    }//GEN-LAST:event_jButtonBilateralActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void aplicarFiltro(Filtro filtro) {
        filtro.setDir(dir);
        filtro.aplicarFiltro();
        panelImagem.setDir(dirOut);
        panelImagem.repaint();
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
