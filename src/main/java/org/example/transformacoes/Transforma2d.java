package org.example.transformacoes;

import org.example.Matrizes.Matrizes;
import org.example.Matrizes.Ponto;

import java.util.ArrayList;

public class Transforma2d {
    private ArrayList<Ponto> posicaoOriginal;
    private ArrayList<Ponto> posicaoPosTransformacao;
    private Matrizes matrizesDeTransformacao;

    public Transforma2d(ArrayList<Ponto> posicaoOriginal){
        this.posicaoOriginal = posicaoOriginal;
        posicaoPosTransformacao = new ArrayList<Ponto>();
    }

    public void realizaTransformacao(){
        matrizesDeTransformacao.setPontos(posicaoOriginal);
        matrizesDeTransformacao.gerarMatrizM();
        posicaoPosTransformacao = matrizesDeTransformacao.transformaPonto();
    }

    public void translacao(int transX, int transY){
        matrizesDeTransformacao.addMatriz(new double[][] {{1,0,transX},{0,1,transY},{0,0,1}});
    }
    public void rotacao(double angulo){
        //conseguindo seno e cosseno do angulo para efetuar a rotacao
        double radians = Math.toRadians(angulo);

        double cosO = Math.cos(radians);
        double senO = Math.sin(radians);

        matrizesDeTransformacao.addMatriz(new double[][] {{cosO,-senO,0},{senO,cosO,0},{0,0,1}});
    }
    public void escala(int Sx, int Sy){
        matrizesDeTransformacao.addMatriz(new double[][] {{Sx,0,0},{0,Sy,0},{0,0,1}});
    }
    public void cisalhamento(double fatorCisalhamento, String direcao){
//      cisalhamento em x
        if (direcao.equals("X")){
            matrizesDeTransformacao.addMatriz(new double[][] {{1,fatorCisalhamento,0},{0,1,0},{0,0,1}});
            return;
        }
//      cisalhamento em y
        matrizesDeTransformacao.addMatriz(new double[][] {{1,0,0},{fatorCisalhamento,1,0},{0,0,1}});
    }
    public void reflexao(String eixo){
//      reflexao em x
        if(eixo.equals("X")){
            matrizesDeTransformacao.addMatriz(new double[][] {{1,0,0},{0,-1,0},{0,0,1}});
            return;
        }
//      reflexao em y
        matrizesDeTransformacao.addMatriz(new double[][] {{-1,0,0},{0,1,0},{0,0,1}});
    }

//  gets e sets
    public ArrayList<Ponto> getPosicaoOriginal() {
        return posicaoOriginal;
    }

    public void setPosicaoOriginal(ArrayList<Ponto> posicaoOriginal) {
        this.posicaoOriginal = posicaoOriginal;
    }

    public ArrayList<Ponto> getPosicaoPosTransformacao() {
        return posicaoPosTransformacao;
    }

    public Matrizes getMatrizesDeTransformacao() {
        return matrizesDeTransformacao;
    }

    public void setMatrizesDeTransformacao(Matrizes matrizesDeTransformacao) {
        this.matrizesDeTransformacao = matrizesDeTransformacao;
    }
}
