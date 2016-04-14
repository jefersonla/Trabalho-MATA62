package jogoxadrez.modelos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Pedro
 */
public class Jogada {

    private Jogador jogador;
    private int jogadaRecente;
    private Collection<Point> posicoes;

    public Jogada() {
        posicoes=new ArrayList<Point>();
        this.jogadaRecente=-1;
    }

    public Jogada(Jogador jogador) {
        posicoes=new ArrayList<Point>();
        this.jogador = jogador;
    }

    public Jogada(Jogador jogador, int jogadaRecente) {
        posicoes=new ArrayList<Point>();
        this.jogador = jogador;
        this.jogadaRecente = jogadaRecente;
    }

    public Jogada(Jogador jogador, int jogadaRecente, Collection<Point> posicoes) {
        posicoes=new ArrayList<Point>();
        this.jogador = jogador;
        this.jogadaRecente = jogadaRecente;
        this.posicoes = posicoes;
    }

    public int getJogadaRecente() {
        return jogadaRecente;
    }

    public void setJogadaRecente(int jogadaRecente) {
        this.jogadaRecente = jogadaRecente;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Collection<Point> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(Point posicao) {
        this.posicoes.add(posicao);
    }
    
    public void removePosicao(Point posicao) {
        this.posicoes.remove(posicao);
    }
    
    
}
