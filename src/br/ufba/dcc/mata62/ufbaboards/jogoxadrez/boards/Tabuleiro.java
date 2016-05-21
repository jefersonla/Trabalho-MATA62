package br.ufba.dcc.mata62.ufbaboards.jogoxadrez.boards;

import br.ufba.dcc.mata62.ufbaboards.gui.FramePrincipal;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaPeaoPreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaBispoBranco;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaRainhaBranco;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaTorrePreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaBispoPreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaTorreBranco;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaCavaloPreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaReiPreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaRainhaPreto;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaPeaoBranco;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaVazia;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaReiBranco;
import br.ufba.dcc.mata62.ufbaboards.jogoxadrez.old.PecaCavaloBranco;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * @author Pedro Kislansky e Luís Lima
 * @version 1.0
 */
public class Tabuleiro extends javax.swing.JPanel {

    private final FramePrincipal fp;
    private final ArrayList<JButton> pecas;
    private JButton peca = null;
    private int contador;
    private int contadorCorTabuleiro;
    private int x;
    private int y;

    /**
     * Creates new form Tabuleiro
     *
     * @param fp
     */
    public Tabuleiro(FramePrincipal fp) {
        // Inicializa os componentes
        initComponents();

        // Salva a referência para o frame principal
        this.fp = fp;

        // Inicializa outros valores da classe
        this.x = 0;
        this.y = 0;
        this.contador = 1;
        this.contadorCorTabuleiro = 1;
        this.pecas = new ArrayList<>();
        this.construirTabuleiroXadrez();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public void construirTabuleiroXadrez() {

        construirPrimeiraUltimaLinha('p');
        construirLinhaPeos('p');
        construirLinhasEmBranco();
        construirLinhaPeos('b');
        construirPrimeiraUltimaLinha('b');
        this.pintarTabuleiro();

    }

    private void pintarTabuleiro() {
        int i = 0;
        int j = 0;
        int incremento = 0;
        while (i < 8) {
            while (j < 8) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        this.pecas.get(i + (j + incremento)).setBackground(new Color(238, 238, 238));
                    } else {
                        this.pecas.get(i + (j + incremento)).setBackground(new Color(255, 255, 255));
                    }
                } else if (j % 2 == 0) {
                    this.pecas.get(i + (j + incremento)).setBackground(new Color(255, 255, 255));
                } else {
                    this.pecas.get(i + (j + incremento)).setBackground(new Color(238, 238, 238));
                }
                j++;
            }
            j = 0;
            i++;
            incremento += 7;
        }
        this.repaint();
    }

    private void construirPrimeiraUltimaLinha(char cor) {

        if (cor == 'p') {
            adicionarAoTabuleiro(new PecaTorreBranco());
            adicionarAoTabuleiro(new PecaCavaloBranco());
            adicionarAoTabuleiro(new PecaBispoBranco());
            adicionarAoTabuleiro(new PecaReiBranco());
            adicionarAoTabuleiro(new PecaRainhaBranco());
            adicionarAoTabuleiro(new PecaBispoBranco());
            adicionarAoTabuleiro(new PecaCavaloBranco());
            adicionarAoTabuleiro(new PecaTorreBranco());
        } else {
            adicionarAoTabuleiro(new PecaTorrePreto());
            adicionarAoTabuleiro(new PecaCavaloPreto());
            adicionarAoTabuleiro(new PecaBispoPreto());
            adicionarAoTabuleiro(new PecaReiPreto());
            adicionarAoTabuleiro(new PecaRainhaPreto());
            adicionarAoTabuleiro(new PecaBispoPreto());
            adicionarAoTabuleiro(new PecaCavaloPreto());
            adicionarAoTabuleiro(new PecaTorrePreto());
        }

    }

    private void construirLinhaPeos(char cor) {

        for (int i = 0; i < 8; i++) {
            if (cor == 'p') {
                adicionarAoTabuleiro(new PecaPeaoBranco());
            } else {
                adicionarAoTabuleiro(new PecaPeaoPreto());
            }
        }

    }

    private void construirLinhasEmBranco() {
        for (int i = 0; i < 32; i++) {
            adicionarAoTabuleiro(new PecaVazia());
        }
    }

    private void adicionarAoTabuleiro(JButton peca) {
        peca.setLocation(new Point(x, y));
        peca.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        if (contador % 8 != 0) {
            x += 50;
        } else {
            x = 0;
            y += 50;
        }
        contadorCorTabuleiro++;
        this.add(peca);
        pecas.add(peca);
        contador++;
    }

    private void ActionPerformed(java.awt.event.ActionEvent evt) {
        JButton pecaClicada = (JButton) evt.getSource();
        if (fp.getJogada().getJogadaRecente() == -1) {
            if (pecaClicada.getClass().toString().contains(fp.getJogadores().get(FramePrincipal.getJogadorDaVez()).getPeca())) {
                this.iluminaCaminho(pecaClicada);
            }
        } else {
            this.movePeca(pecaClicada);
            fp.getJogada().setJogadaRecente(-1);
            if (this.jogoTerminou(peca)) {
                fp.terminarJogo();
            }
        }

    }

    private void movePeca(JButton posicao) {
        if (posicao.getBackground().equals(new Color(0, 180, 0))) {
            JButton vazio = new PecaVazia();
            vazio.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ActionPerformed(evt);
                }
            });

            if (this.peca instanceof PecaPeaoBranco) {
                ((PecaPeaoBranco) this.peca).setMexeu(true);
            }

            if (this.peca instanceof PecaPeaoPreto) {
                ((PecaPeaoPreto) this.peca).setMexeu(true);
            }

            vazio.setLocation(this.peca.getLocation());
            this.peca.setLocation(posicao.getLocation());

            int i = this.pecas.indexOf(posicao);
            int j = this.pecas.indexOf(this.peca);

            this.pecas.remove(i);
            this.pecas.add(i, this.peca);
            this.pecas.remove(j);
            this.pecas.add(j, vazio);

            this.remove(this.peca);
            this.remove(posicao);

            //this.peca.setLocation(posicao.getLocation());
            this.add(this.peca);
            this.add(vazio);

            this.repaint();

            if (FramePrincipal.getJogadorDaVez() == 0) {
                FramePrincipal.setJogadorDaVez(1);
            } else {
                FramePrincipal.setJogadorDaVez(0);
            }

            fp.getJogada().setJogador(fp.getJogadores().get(FramePrincipal.getJogadorDaVez()));
            fp.trocaJogador();
        }
        this.limparIluminados();
        this.pintarTabuleiro();
    }

    private void iluminaCaminho(JButton pecaEmMovimento) {

        limparIluminados();

        if (pecaEmMovimento instanceof PecaPeaoBranco) {
            this.verificaTrajetóriaPeaoBranco((PecaPeaoBranco) pecaEmMovimento);

        } else if (pecaEmMovimento instanceof PecaPeaoPreto) {
            this.verificaTrajetóriaPeaoPreto((PecaPeaoPreto) pecaEmMovimento);

        } else if (pecaEmMovimento instanceof PecaBispoBranco) {
            this.verificaTrajetoriaBispoBranco(pecaEmMovimento);

        } else if (pecaEmMovimento instanceof PecaBispoPreto) {
            verificaTrajetoriaBispoPreto(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaTorreBranco) {
            verificaTrajetoriaTorreBranco(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaTorrePreto) {
            verificaTrajetoriaTorrePreto(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaCavaloBranco) {
            verificaTrajetoriaCavaloBranco(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaCavaloPreto) {
            verificaTrajetoriaCavaloPreto(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaRainhaBranco) {
            verificaTrajetoriaRainhaBranco(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaRainhaPreto) {
            verificaTrajetoriaRainhaPreto(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaReiBranco) {
            verificaTrajetoriaReiBranco(pecaEmMovimento);
        } else if (pecaEmMovimento instanceof PecaReiPreto) {
            verificaTrajetoriaReiPreto(pecaEmMovimento);
        }
        this.peca = pecaEmMovimento;
        fp.getJogada().setJogadaRecente(0);
        this.repaint();
    }

    private void verificaTrajetóriaPeaoBranco(PecaPeaoBranco peao) {
        int temp_x = peao.getX();
        int temp_y = peao.getY();
        int temp;
        int jogadas = 0;
        boolean flag = true;
        JButton bt;

        int qtdCasas = 2;

        if (peao.isMexeu()) {
            qtdCasas = 1;
        }

        while (flag && jogadas < qtdCasas) {

            temp_y += 50;
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia) {
                    iluminar(temp);
                    jogadas++;
                } else if (bt.getClass().toString().contains("Preto")) {
                    flag = false;
                    //iluminar(temp);
                    //jogadas++;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }

        for (int i = 0; i < 2; i++) {

            temp_x = peao.getX();
            temp_y = peao.getY();

            if (i == 0) {
                temp_y += 50;
                temp_x += 50;
            } else {
                temp_y += 50;
                temp_x -= 50;
            }

            temp = this.getPeca(temp_x, temp_y);

            if (temp != -1) {

                bt = this.pecas.get(temp);

                if (bt.getClass().toString().contains("Preto")) {
                    iluminar(temp);
                }

            }

        }

    }

    private void verificaTrajetóriaPeaoPreto(PecaPeaoPreto peao) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = peao.getX();
        int temp_y = peao.getY();

        int jogadas = 0;
        int qtdCasas = 2;

        if (peao.isMexeu()) {
            qtdCasas = 1;
        }

        while (flag && jogadas < qtdCasas) {
            temp_y -= 50;
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia) {
                    iluminar(temp);
                    jogadas++;
                } else if (bt.getClass().toString().contains("Branco")) {
                    flag = false;
                    //iluminar(temp);
                    //jogadas++;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        for (int i = 0; i < 2; i++) {

            temp_x = peao.getX();
            temp_y = peao.getY();

            if (i == 0) {
                temp_y -= 50;
                temp_x -= 50;
            } else {
                temp_y -= 50;
                temp_x += 50;
            }

            temp = this.getPeca(temp_x, temp_y);

            if (temp != -1) {

                bt = this.pecas.get(temp);

                if (bt.getClass().toString().contains("Branco")) {
                    iluminar(temp);
                }

            }

        }

    }

    private void verificaTrajetoriaBispoBranco(JButton bispo) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = bispo.getX();
        int temp_y = bispo.getY();

        for (int i = 0; i < 4; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        temp_x += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        temp_x -= 50;
                        break;
                    case 2:
                        temp_y -= 50;
                        temp_x += 50;
                        break;
                    default:
                        temp_y += 50;
                        temp_x -= 50;
                        break;
                }
                
                temp = this.getPeca(temp_x, temp_y);
                
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Preto")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = bispo.getX();
            temp_y = bispo.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaBispoPreto(JButton bispo) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = bispo.getX();
        int temp_y = bispo.getY();

        for (int i = 0; i < 4; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        temp_x += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        temp_x -= 50;
                        break;
                    case 2:
                        temp_y -= 50;
                        temp_x += 50;
                        break;
                    default:
                        temp_y += 50;
                        temp_x -= 50;
                        break;
                }
                temp = this.getPeca(temp_x, temp_y);
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Branco")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = bispo.getX();
            temp_y = bispo.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaTorreBranco(JButton torre) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = torre.getX();
        int temp_y = torre.getY();

        for (int i = 0; i < 4; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        break;
                    case 2:
                        temp_x += 50;
                        break;
                    default:
                        temp_x -= 50;
                        break;
                }
                temp = this.getPeca(temp_x, temp_y);
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Preto")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = torre.getX();
            temp_y = torre.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaTorrePreto(JButton torre) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = torre.getX();
        int temp_y = torre.getY();

        for (int i = 0; i < 4; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        break;
                    case 2:
                        temp_x += 50;
                        break;
                    default:
                        temp_x -= 50;
                        break;
                }
                temp = this.getPeca(temp_x, temp_y);
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Branco")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = torre.getX();
            temp_y = torre.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaCavaloBranco(JButton cavalo) {
        int temp;
        JButton bt;
        int temp_x = cavalo.getX();
        int temp_y = cavalo.getY();

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    temp_y += 100;
                    temp_x += 50;
                    break;
                case 1:
                    temp_y -= 100;
                    temp_x -= 50;
                    break;
                case 2:
                    temp_y -= 50;
                    temp_x -= 100;
                    break;
                case 3:
                    temp_y += 50;
                    temp_x += 100;
                    break;
                case 4:
                    temp_y -= 100;
                    temp_x += 50;
                    break;
                case 5:
                    temp_y -= 50;
                    temp_x += 100;
                    break;
                case 6:
                    temp_x -= 50;
                    temp_y += 100;
                    break;
                case 7:
                    temp_x -= 100;
                    temp_y += 50;
                    break;
                default:
                    break;
            }
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia || bt.getClass().toString().contains("Preto")) {
                    iluminar(temp);
                }
            }
            temp_x = cavalo.getX();
            temp_y = cavalo.getY();
        }
    }

    private void verificaTrajetoriaCavaloPreto(JButton cavalo) {
        int temp;
        JButton bt;
        int temp_x = cavalo.getX();
        int temp_y = cavalo.getY();

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    temp_y += 100;
                    temp_x += 50;
                    break;
                case 1:
                    temp_y -= 100;
                    temp_x -= 50;
                    break;
                case 2:
                    temp_y -= 50;
                    temp_x -= 100;
                    break;
                case 3:
                    temp_y += 50;
                    temp_x += 100;
                    break;
                case 4:
                    temp_y -= 100;
                    temp_x += 50;
                    break;
                case 5:
                    temp_y -= 50;
                    temp_x += 100;
                    break;
                case 6:
                    temp_x -= 50;
                    temp_y += 100;
                    break;
                case 7:
                    temp_x -= 100;
                    temp_y += 50;
                    break;
                default:
                    break;
            }
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia || bt.getClass().toString().contains("Branco")) {
                    iluminar(temp);
                }
            }
            temp_x = cavalo.getX();
            temp_y = cavalo.getY();
        }
    }

    private void verificaTrajetoriaRainhaBranco(JButton rainha) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = rainha.getX();
        int temp_y = rainha.getY();

        for (int i = 0; i < 8; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        break;
                    case 2:
                        temp_x += 50;
                        break;
                    case 3:
                        temp_x -= 50;
                        break;
                    case 4:
                        temp_y += 50;
                        temp_x += 50;
                        break;
                    case 5:
                        temp_y -= 50;
                        temp_x -= 50;
                        break;
                    case 6:
                        temp_y -= 50;
                        temp_x += 50;
                        break;
                    default:
                        temp_y += 50;
                        temp_x -= 50;
                        break;
                }
                temp = this.getPeca(temp_x, temp_y);
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Preto")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = rainha.getX();
            temp_y = rainha.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaRainhaPreto(JButton rainha) {
        int temp;
        JButton bt;
        boolean flag = true;
        int temp_x = rainha.getX();
        int temp_y = rainha.getY();

        for (int i = 0; i < 8; i++) {
            while (flag) {
                switch (i) {
                    case 0:
                        temp_y += 50;
                        break;
                    case 1:
                        temp_y -= 50;
                        break;
                    case 2:
                        temp_x += 50;
                        break;
                    case 3:
                        temp_x -= 50;
                        break;
                    case 4:
                        temp_y += 50;
                        temp_x += 50;
                        break;
                    case 5:
                        temp_y -= 50;
                        temp_x -= 50;
                        break;
                    case 6:
                        temp_y -= 50;
                        temp_x += 50;
                        break;
                    default:
                        temp_y += 50;
                        temp_x -= 50;
                        break;
                }
                temp = this.getPeca(temp_x, temp_y);
                if (temp != -1) {
                    bt = this.pecas.get(temp);
                    if (bt instanceof PecaVazia) {
                        iluminar(temp);
                    } else if (bt.getClass().toString().contains("Branco")) {
                        flag = false;
                        iluminar(temp);
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }
            }
            temp_x = rainha.getX();
            temp_y = rainha.getY();
            flag = true;
        }
    }

    private void verificaTrajetoriaReiBranco(JButton rei) {
        int temp;
        JButton bt;
        int temp_x = rei.getX();
        int temp_y = rei.getY();

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    temp_y += 50;
                    break;
                case 1:
                    temp_y -= 50;
                    break;
                case 2:
                    temp_x -= 50;
                    break;
                case 3:
                    temp_x += 50;
                    break;
                case 4:
                    temp_y -= 50;
                    temp_x += 50;
                    break;
                case 5:
                    temp_y += 50;
                    temp_x -= 50;
                    break;
                case 6:
                    temp_x -= 50;
                    temp_y -= 50;
                    break;
                case 7:
                    temp_x += 50;
                    temp_y += 50;
                    break;
                default:
                    break;
            }
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia || bt.getClass().toString().contains("Preto")) {
                    iluminar(temp);
                }
            }
            temp_x = rei.getX();
            temp_y = rei.getY();
        }
    }

    private void verificaTrajetoriaReiPreto(JButton rei) {
        int temp;
        JButton bt;
        
        int temp_x = rei.getX();
        int temp_y = rei.getY();

        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    temp_y += 50;
                    break;
                case 1:
                    temp_y -= 50;
                    break;
                case 2:
                    temp_x -= 50;
                    break;
                case 3:
                    temp_x += 50;
                    break;
                case 4:
                    temp_y -= 50;
                    temp_x += 50;
                    break;
                case 5:
                    temp_y += 50;
                    temp_x -= 50;
                    break;
                case 6:
                    temp_x -= 50;
                    temp_y -= 50;
                    break;
                case 7:
                    temp_x += 50;
                    temp_y += 50;
                    break;
                default:
                    break;
            }
            temp = this.getPeca(temp_x, temp_y);
            if (temp != -1) {
                bt = this.pecas.get(temp);
                if (bt instanceof PecaVazia || bt.getClass().toString().contains("Branco")) {
                    iluminar(temp);
                }
            }
            temp_x = rei.getX();
            temp_y = rei.getY();
        }
    }

    private void iluminar(int indice) {
        this.pecas.get(indice).setBackground(new Color(0, 180, 0));
    }

    private void limparIluminados() {

        for (int i = 0; i < this.pecas.size(); i++) {
            if (this.pecas.get(i).getBackground().equals(new Color(0, 180, 0))) {
                this.pecas.get(i).setBackground(new Color(255, 255, 255));
            }
        }
    }

    private int getPeca(int temp_x, int temp_y) {
        int temp = -1;
        for (int i = 0; i < this.pecas.size(); i++) {
            if (this.pecas.get(i).getX() == temp_x && this.pecas.get(i).getY() == temp_y) {
                temp = i;
            }
        }
        return temp;
    }

    private boolean jogoTerminou(JButton peca) {
        boolean flag = true;
        for (int i = 0; i < this.pecas.size(); i++) {
            if (peca.getClass().toString().contains("Branco")) {
                if (this.pecas.get(i) instanceof PecaReiPreto) {
                    flag = false;
                }
            } else if (this.pecas.get(i) instanceof PecaReiBranco) {
                flag = false;
            }
        }
        if (flag) {
            desabilitaPecas();
        }
        return flag;
    }

    private void desabilitaPecas() {
        for (int i = 0; i < this.pecas.size(); i++) {
            this.pecas.get(i).setEnabled(false);
        }
    }

}
