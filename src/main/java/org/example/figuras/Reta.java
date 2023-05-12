package org.example.figuras;

import org.example.Matrizes.Ponto;

import java.util.ArrayList;

import static java.lang.Math.round;

public class Reta {
    private ArrayList<Ponto> pontosReta;
    private Ponto ponto1;
    private Ponto ponto2;

    public Reta(Ponto ponto1, Ponto ponto2){
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
        pontosReta = new ArrayList<Ponto>();
    }

    //algoritmo de reta: DDA
    public void retaDDA(){

        //descobre tamanho da reta
        double length = (ponto2.getX() - ponto1.getX());

        //caso a distancia no eixo y seja maior q a distancia no eixo X ela é utilizada
        if( (ponto2.getY() - ponto1.getY()) > length ){
            length = ponto2.getY() - ponto1.getY();
        }

        //calcula o incremento de X e Y
        double xInc = ((double) (ponto2.getX() - ponto1.getX()) / length);
        double yInc = ((double) (ponto2.getY() - ponto1.getY()) / length);

        //define os pontos iniciais e os coloca no ArrayList "pontosReta"
        double x = ponto1.getX();
        double y = ponto1.getY();

        pontosReta.add(new Ponto(new double[][] {{round(x)},{round(y)}, {1}}));

        //enquanto x for menor que y o algoritmo incrementa a posicao do ponto e o coloca no Arraylist "pontosReta"
        while (x < ponto2.getX()){
            x+= xInc;
            y+= yInc;

            pontosReta.add(new Ponto(new double[][] {{round(x)},{round(y)}, {1}}));
        }

    }

//  algoritmo de reta: ponto medio
    public void retaPontoMedio(){

        //defino variaveis para facilitar calculos de posicoes
        double xAux1 = ponto1.getX();
        double yAux1 = ponto1.getY();

        double xAux2 = ponto2.getX();
        double yAux2 = ponto2.getY();

//      caso o ponto 1 seja maior q o ponto 2, fazemos a inversao dos pontos
        if(ponto1.getX() > ponto2.getX()){
            xAux1 = ponto2.getX();
            xAux2 = ponto1.getX();
        }
        if(ponto1.getY() > ponto2.getY()){
            yAux1 = ponto2.getY();
            yAux2 = ponto1.getY();
        }


        double dx = xAux2 - xAux1;
        double dy = yAux2 - yAux1;

        double m = dy/dx;

        double IncE;
        double IncNE;
        double ds;

        if(m < 1 && m > 0){
            IncE = 2 * (dy);
            IncNE = 2 * (dy - dx);
            ds = (2 * dy) - dx;
        }
        else{
            IncE = 2 * (dx);

            IncNE = 2 * (dx - dy);
            ds = (2 * dx) - dy;
        }

        double d = ds;

//      derivacao da funcao para desenhar a reta em qualquer oitante
        if(m < 1 && m > 0){
            while(xAux1 < xAux2) {
                if (d >= 0) {
                    xAux1 += 1;
                    yAux1 += 1;
                    d += IncNE;

                    pontosReta.add(new Ponto(new double[][] {{xAux1},{yAux1}, {1}}));
                } else {
                    xAux1 += 1;

                    d += IncE;
                    pontosReta.add(new Ponto(new double[][] {{xAux1},{yAux1}, {1}}));
                }
            }
        }else{
            while(yAux1 < yAux2){
                if ( d >= 0 ){
                    xAux1 += 1;
                    yAux1 += 1;
                    d += IncNE;
                    pontosReta.add(new Ponto(new double[][] {{xAux1},{yAux1}, {1}}));
                }
                else{
                    yAux1+=1;

                    d+=IncE;
                    pontosReta.add(new Ponto(new double[][] {{xAux1},{yAux1}, {1}}));
                }
            }
        }
    }

//  gets e sets
    public ArrayList<Ponto> getPontosReta() {
        return pontosReta;
    }
    public void setPontosReta(ArrayList<Ponto> pontosReta) {
        this.pontosReta = pontosReta;
    }
    public Ponto getPonto1() {
        return ponto1;
    }
    public void setPonto1(Ponto ponto1) {
        this.ponto1 = ponto1;
    }
    public Ponto getPonto2() {
        return ponto2;
    }
    public void setPonto2(Ponto ponto2) {
        this.ponto2 = ponto2;
    }
}
