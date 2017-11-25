package visao;

import controle.FiltroControle;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Henike
 */
public class TelaSalvar extends javax.swing.JFrame {

    private final FiltroControle filtroControle;

    /**
     * Creates new form Browser
     *
     * @param filtroControle
     */
    public TelaSalvar(FiltroControle filtroControle) {
        this.filtroControle = filtroControle;
        initComponents();
        txtDiretorio.setText(arquivos.getCurrentDirectory().getAbsolutePath());
        arquivos.setCurrentDirectory(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        corpo = new javax.swing.JPanel();
        arquivos = new javax.swing.JFileChooser();
        txtDiretorio = new javax.swing.JTextField();
        jLabelDiretorio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        arquivos.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        arquivos.setCurrentDirectory(null);
        arquivos.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        arquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivosActionPerformed(evt);
            }
        });
        arquivos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                arquivosPropertyChange(evt);
            }
        });

        txtDiretorio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDiretorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiretorioKeyReleased(evt);
            }
        });

        jLabelDiretorio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDiretorio.setText("Diretório:");

        javax.swing.GroupLayout corpoLayout = new javax.swing.GroupLayout(corpo);
        corpo.setLayout(corpoLayout);
        corpoLayout.setHorizontalGroup(
            corpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, corpoLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabelDiretorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(corpoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(arquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        corpoLayout.setVerticalGroup(
            corpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(corpoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(corpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiretorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDiretorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arquivos, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(corpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(corpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void arquivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivosActionPerformed
        setVisible(false);
        if (JFileChooser.APPROVE_SELECTION.equals(evt.getActionCommand())) {
            String dir = arquivos.getSelectedFile().toString();
            filtroControle.copiarArquivo(filtroControle.getDirOut(), dir + ".jpg");
        }
    }//GEN-LAST:event_arquivosActionPerformed

    private void txtDiretorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiretorioKeyReleased
        String dir = txtDiretorio.getText();
        arquivos.setCurrentDirectory(new File(dir));
    }//GEN-LAST:event_txtDiretorioKeyReleased

    private void arquivosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_arquivosPropertyChange
        txtDiretorio.setText(arquivos.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_arquivosPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser arquivos;
    private javax.swing.JPanel corpo;
    private javax.swing.JLabel jLabelDiretorio;
    private javax.swing.JTextField txtDiretorio;
    // End of variables declaration//GEN-END:variables

}