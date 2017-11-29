package visao;

import controle.QuantificacaoControle;
import modelo.Doenca;
import modelo.iterator.Iterator;

/**
 *
 * @author henik
 */
public class TelaQuantificacao extends javax.swing.JFrame {

    private final QuantificacaoControle quantificacaoControle;

    /**
     * Creates new form NovoJFrame
     *
     * @param dirIn
     */
    public TelaQuantificacao(String dirIn) {
        quantificacaoControle = new QuantificacaoControle(dirIn);
        initComponents();
        quantificacaoControle.setDirIn(quantificacaoControle.getDirOut());
        preencherComboDoenca();
        preencherComboQuantificacao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonConfirmar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        panelImagem = new visao.DrawingPanel();
        jComboBoxQuantificacao = new javax.swing.JComboBox<>();
        jComboBoxDoenca = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Imagem");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        panelImagem.setDirIn(quantificacaoControle.getDirIn());
        panelImagem.setDirOut(quantificacaoControle.getDirOut());

        javax.swing.GroupLayout panelImagemLayout = new javax.swing.GroupLayout(panelImagem);
        panelImagem.setLayout(panelImagemLayout);
        panelImagemLayout.setHorizontalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImagemLayout.setVerticalGroup(
            panelImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 251, Short.MAX_VALUE)
        );

        jComboBoxQuantificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxQuantificacaoActionPerformed(evt);
            }
        });

        jComboBoxDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDoencaActionPerformed(evt);
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
                        .addComponent(jComboBoxQuantificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jComboBoxDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSair))
                    .addComponent(panelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonSair)
                    .addComponent(jComboBoxQuantificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        panelImagem.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        quantificacaoControle.quantificar(jComboBoxQuantificacao.getSelectedItem().toString(),
                (Doenca) quantificacaoControle.getDoencas().get(jComboBoxDoenca.getSelectedIndex() - 1));
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxQuantificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxQuantificacaoActionPerformed
        verificaCampos();
    }//GEN-LAST:event_jComboBoxQuantificacaoActionPerformed

    private void jComboBoxDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDoencaActionPerformed
        verificaCampos();
    }//GEN-LAST:event_jComboBoxDoencaActionPerformed

    private void verificaCampos() {
        if (jComboBoxQuantificacao.getSelectedItem() != null && jComboBoxDoenca.getSelectedItem() != null) {
            if (jComboBoxQuantificacao.getSelectedItem().toString().equals("") || jComboBoxDoenca.getSelectedItem().toString().equals("")) {
                jButtonConfirmar.setEnabled(false);
            } else {
                jButtonConfirmar.setEnabled(true);
            }
        } else {
            jButtonConfirmar.setEnabled(false);
        }
    }

    private void preencherComboDoenca() {
        Iterator di = quantificacaoControle.getDoencas().getIterator();
        jComboBoxDoenca.removeAllItems();
        jComboBoxDoenca.addItem("");
        for (di.primeiro(); !di.isFinalizado(); di.proximo()) {
            Doenca d = (Doenca) di.getAtual();
            jComboBoxDoenca.addItem(d.getNome());
        }
    }

    private void preencherComboQuantificacao() {
        jComboBoxQuantificacao.addItem("");
        jComboBoxQuantificacao.addItem("Incidência");
        jComboBoxQuantificacao.addItem("Medição Direta");
        jComboBoxQuantificacao.addItem("Classe Severidade");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxDoenca;
    private javax.swing.JComboBox<String> jComboBoxQuantificacao;
    private visao.DrawingPanel panelImagem;
    // End of variables declaration//GEN-END:variables
}