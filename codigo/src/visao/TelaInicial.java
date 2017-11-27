package visao;

import visao.inicio.TelaCultura;
import util.AtualizaHora;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import visao.inicio.TelaAmostragem;
import visao.inicio.TelaCamera;
import visao.inicio.TelaClasseSeveridade;
import visao.inicio.TelaDoenca;
import visao.relatorio.TelaRelatorio;

/**
 *
 * @author Henike
 */
public class TelaInicial extends javax.swing.JFrame {

    private static TelaInicial instance;

    private TelaInicial() {
        initComponents();
        //pegar resolução da tela
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        //setar a posição e tamanho da label
        jLabelFundo.setBounds(0, 0, d.width - 12, d.height - 112);
        AtualizaHora.start(jLabelHorario);
    }

    public static TelaInicial getInstance() {
        if (instance == null) {
            instance = new TelaInicial();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jLabelHorario = new javax.swing.JLabel();
        jLabelFundo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuCadAmostragem = new javax.swing.JMenuItem();
        jMenuCadCamera = new javax.swing.JMenuItem();
        jMenuCadClasse = new javax.swing.JMenuItem();
        jMenuCadCultura = new javax.swing.JMenuItem();
        jMenuCadDoenca = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuOpcQuantificar = new javax.swing.JMenuItem();
        jMenuOpcFiltro = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quantificação");
        setLocation(new java.awt.Point(500, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelHorario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelHorario.setText("Horario");

        jLabelFundo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jMenuBar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jMenuCadastros.setMnemonic('C');
        jMenuCadastros.setText("Cadastro");
        jMenuCadastros.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuCadAmostragem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuCadAmostragem.setText("Amostragem");
        jMenuCadAmostragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadAmostragemActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCadAmostragem);

        jMenuCadCamera.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuCadCamera.setText("Câmera");
        jMenuCadCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadCameraActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCadCamera);

        jMenuCadClasse.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuCadClasse.setText("Classe Severidade");
        jMenuCadClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadClasseActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCadClasse);

        jMenuCadCultura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuCadCultura.setText("Cultura");
        jMenuCadCultura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadCulturaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCadCultura);

        jMenuCadDoenca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuCadDoenca.setText("Doença");
        jMenuCadDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadDoencaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuCadDoenca);

        jMenuBar.add(jMenuCadastros);

        jMenu2.setMnemonic('O');
        jMenu2.setText("Opções");
        jMenu2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuOpcQuantificar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuOpcQuantificar.setText("Quantificar Doença");
        jMenuOpcQuantificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcQuantificarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuOpcQuantificar);

        jMenuOpcFiltro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jMenuOpcFiltro.setText("Aplicar Filtro");
        jMenuOpcFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuOpcFiltroActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuOpcFiltro);

        jMenuBar.add(jMenu2);

        jMenu1.setMnemonic('R');
        jMenu1.setText("Relatórios");
        jMenu1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        jMenuItem1.setText("Doença");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar.add(jMenu1);

        jMenuSair.setText("Sair");
        jMenuSair.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar.add(jMenuSair);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 507, Short.MAX_VALUE)
                        .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHorario)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(611, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //conex.desconecta();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "AVISO!", JOptionPane.YES_NO_OPTION) == 0) {
            //conex.desconecta();
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuCadAmostragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadAmostragemActionPerformed
        TelaAmostragem.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuCadAmostragemActionPerformed

    private void jMenuCadCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadCameraActionPerformed
        TelaCamera.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuCadCameraActionPerformed

    private void jMenuCadClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadClasseActionPerformed
        TelaClasseSeveridade.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuCadClasseActionPerformed

    private void jMenuCadCulturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadCulturaActionPerformed
        TelaCultura.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuCadCulturaActionPerformed

    private void jMenuCadDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadDoencaActionPerformed
        TelaDoenca.getInstance().setVisible(true);
    }//GEN-LAST:event_jMenuCadDoencaActionPerformed

    private void jMenuOpcQuantificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcQuantificarActionPerformed
        new TelaAbrir("Quantificar").setVisible(true);
    }//GEN-LAST:event_jMenuOpcQuantificarActionPerformed

    private void jMenuOpcFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuOpcFiltroActionPerformed
        new TelaAbrir("Corrigir").setVisible(true);
    }//GEN-LAST:event_jMenuOpcFiltroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaRelatorio.getInstace().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuCadAmostragem;
    private javax.swing.JMenuItem jMenuCadCamera;
    private javax.swing.JMenuItem jMenuCadClasse;
    private javax.swing.JMenuItem jMenuCadCultura;
    private javax.swing.JMenuItem jMenuCadDoenca;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuOpcFiltro;
    private javax.swing.JMenuItem jMenuOpcQuantificar;
    private javax.swing.JMenu jMenuSair;
    // End of variables declaration//GEN-END:variables

}
