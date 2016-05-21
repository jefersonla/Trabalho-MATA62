package br.ufba.dcc.mata62.ufbaboards.old.jogoxadrez;

import br.ufba.dcc.mata62.ufbaboards.gui.EntradaJogo;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.boards.Tabuleiro;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

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
        /* Inicializa os componentes */
        initComponents();
        
        /* Instancia uma nova jogada */
        this.jogada = new Jogada();
        
        /* Adiciona o Painel de Entrada */
        adicionaPanelEntrada();
        
        /* Desabilita a criação de novos jogos enquanto não for especificado os nomes do jogadores */
        this.JMenuXadrez.setEnabled(false);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuJogo = new javax.swing.JMenu();
        JMenuXadrez = new javax.swing.JMenu();
        JMenuXadrezBasico = new javax.swing.JMenuItem();
        JMenuSair = new javax.swing.JMenuItem();
        JMenuSobre = new javax.swing.JMenu();
        JMenuInformacoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 501));
        setResizable(false);

        lblJjogador.setBackground(new java.awt.Color(255, 255, 204));
        lblJjogador.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblJjogador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJjogador.setText("Jogador da vez :");
        lblJjogador.setMaximumSize(new java.awt.Dimension(516, 60));
        lblJjogador.setMinimumSize(new java.awt.Dimension(516, 60));
        lblJjogador.setPreferredSize(new java.awt.Dimension(516, 60));

        jMenuBar1.setEnabled(false);

        JMenuJogo.setText("Jogo");
        JMenuJogo.setToolTipText("Jogo");

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
                .addComponent(lblJjogador, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(lblJjogador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
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
                    .addComponent(  this.tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(0, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                    .addComponent(  this.tabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(  entrada, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(  entrada, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
        this.lblJjogador.setVisible(false);
    }
    
    public void enableXadrexMenu(){
        this.JMenuXadrez.setEnabled(true);
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
