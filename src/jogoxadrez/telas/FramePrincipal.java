package jogoxadrez.telas;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import jogoxadrez.modelos.Jogada;
import jogoxadrez.modelos.Jogador;

/**
 *
 * @author Jeferson Lima
 */
public class FramePrincipal extends javax.swing.JFrame {

    private Tabuleiro tabuleiro;
    private EntradaJogo entrada;
    private static int jogadorDaVez;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private final Jogada jogada;

    /**
     * Creates new form framePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.jogada = new Jogada();
        adicionaPanelEntrada();
        this.JMenuJogo.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJjogador = new javax.swing.JLabel();
        lbMensagem = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuJogo = new javax.swing.JMenu();
        JMenuXadrez = new javax.swing.JMenu();
        JMenuXadrezBasico = new javax.swing.JMenuItem();
        JMenuSair = new javax.swing.JMenuItem();
        JMenuSobre = new javax.swing.JMenu();
        JMenuInformacoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(540, 480));
        setPreferredSize(new java.awt.Dimension(540, 480));
        setResizable(false);

        lblJjogador.setBackground(new java.awt.Color(255, 255, 204));
        lblJjogador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblJjogador.setText("Jogador da vez :");

        lbMensagem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbMensagem.setForeground(new java.awt.Color(255, 0, 0));
        lbMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenuBar1.setEnabled(false);

        JMenuJogo.setLabel("Jogo");

        JMenuXadrez.setText("Xadrez");

        JMenuXadrezBasico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        JMenuXadrezBasico.setText("Básico");
        JMenuXadrezBasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuXadrezBasicoActionPerformed(evt);
            }
        });
        JMenuXadrez.add(JMenuXadrezBasico);

        JMenuJogo.add(JMenuXadrez);

        JMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        JMenuSair.setText("Sair");
        JMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuSairActionPerformed(evt);
            }
        });
        JMenuJogo.add(JMenuSair);

        jMenuBar1.add(JMenuJogo);

        JMenuSobre.setText("Sobre");

        JMenuInformacoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        JMenuInformacoes.setText("Informações");
        JMenuSobre.add(JMenuInformacoes);

        jMenuBar1.add(JMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJjogador, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(lblJjogador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void JMenuXadrezBasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuXadrezBasicoActionPerformed
    this.tabuleiro = new Tabuleiro(this);
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addComponent(this.tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addComponent(this.tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE))
    );

    pack();
    this.lblJjogador.setVisible(true);
    this.lblJjogador.setLocation(new Point(0, 410));
    this.lblJjogador.setText(this.lblJjogador.getText() + " " + this.getJogadores().get(0).getNome());
    setJogadorDaVez(0);
    this.getJogada().setJogador(getJogadores().get(0));

}//GEN-LAST:event_JMenuXadrezBasicoActionPerformed

private void JMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuSairActionPerformed
    this.dispose();
    System.exit(0);
}//GEN-LAST:event_JMenuSairActionPerformed

    private void adicionaPanelEntrada() {
        entrada = new EntradaJogo(this);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
        this.lblJjogador.setVisible(false);
    }

    public void habilitarMenu() {
        this.JMenuJogo.setEnabled(true);
    }

    public static int getJogadorDaVez() {
        return jogadorDaVez;
    }

    public static void setJogadorDaVez(int aJogadorDaVez) {
        jogadorDaVez = aJogadorDaVez;
    }

    public void setNovoJogador(Jogador jogador) {
        this.getJogadores().add(jogador);
    }

    public Jogador getJogador(int indice) {
        return this.getJogadores().get(indice);
    }

    public Jogada getJogada() {
        return jogada;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuInformacoes;
    private javax.swing.JMenu JMenuJogo;
    private javax.swing.JMenuItem JMenuSair;
    private javax.swing.JMenu JMenuSobre;
    private javax.swing.JMenu JMenuXadrez;
    private javax.swing.JMenuItem JMenuXadrezBasico;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbMensagem;
    private javax.swing.JLabel lblJjogador;
    // End of variables declaration//GEN-END:variables

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void trocaJogador() {
        this.lblJjogador.setText("Jogador da vez: " + this.getJogada().getJogador().getNome());
    }

    public void terminarJogo() {
        this.lblJjogador.setForeground(new Color(255, 255, 255));
        this.lblJjogador.setBackground(new Color(255, 0, 0));
        this.lblJjogador.setOpaque(true);
        if (getJogadorDaVez() == 0) {
            this.lblJjogador.setText("O vencedor é: " + this.getJogadores().get(1).getNome());
        } else {
            this.lblJjogador.setText("O vencedor é: " + this.getJogadores().get(0).getNome());
        }

    }

}
