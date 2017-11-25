package visao;

import controle.FiltroControle;
import modelo.FiltroBilateral;
import modelo.FiltroNormalizado;
import modelo.FiltroGaussiano;
import modelo.FiltroMediano;

/**
 *
 * @author henik
 */
public class TelaFiltro extends javax.swing.JFrame {

    private final FiltroControle filtroControle;

    /**
     * Creates new form NovoJFrame
     *
     * @param dirIn
     */
    public TelaFiltro(String dirIn) {
        filtroControle = new FiltroControle(dirIn);
        initComponents();
        filtroControle.setDirIn(filtroControle.getDirOut());
        preencherComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImagem = new visao.DrawingPanel();
        jButtonSair = new javax.swing.JButton();
        jButtonAplicar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxFiltro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Imagem");

        panelImagem.setDirIn(filtroControle.getDirIn());
        panelImagem.setDirOut(filtroControle.getDirOut());

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

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonAplicar.setText("Aplicar");
        jButtonAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAplicarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
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
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxFiltro, 0, 180, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAplicar)
                        .addGap(22, 22, 22)
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
                    .addComponent(jButtonSair)
                    .addComponent(jButtonAplicar)
                    .addComponent(jButtonSalvar)
                    .addComponent(jComboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencherComboBox() {
        jComboBoxFiltro.addItem("");
        jComboBoxFiltro.addItem("Bilateral");
        jComboBoxFiltro.addItem("Normalizado");
        jComboBoxFiltro.addItem("Gaussiano");
        jComboBoxFiltro.addItem("Mediano");
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        TelaSalvar telaSalvar = new TelaSalvar(filtroControle);
        telaSalvar.setVisible(true);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAplicarActionPerformed
        switch (jComboBoxFiltro.getSelectedItem().toString()) {
            case "Bilateral":
                filtroControle.aplicarFiltro(new FiltroBilateral(), panelImagem);
                break;
            case "Normalizado":
                filtroControle.aplicarFiltro(new FiltroNormalizado(), panelImagem);
                break;
            case "Gaussiano":
                filtroControle.aplicarFiltro(new FiltroGaussiano(), panelImagem);
                break;
            case "Mediano":
                filtroControle.aplicarFiltro(new FiltroMediano(), panelImagem);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonAplicarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAplicar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxFiltro;
    private visao.DrawingPanel panelImagem;
    // End of variables declaration//GEN-END:variables
}
