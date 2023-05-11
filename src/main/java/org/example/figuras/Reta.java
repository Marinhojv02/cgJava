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

    public ArrayList<Ponto> retaDDA(){
        ArrayList<Ponto> resultado = new ArrayList<Ponto>();

        int length = (ponto2.getX() - ponto1.getX());

        if( (ponto2.getY() - ponto1.getY()) > length ){
            length = ponto2.getY() - ponto1.getY();
        }

        float xInc = ((float) (ponto2.getX() - ponto1.getX()) / length);
        float yInc = ((float) (ponto2.getY() - ponto1.getY()) / length);

        float x = ponto1.getX();
        float y = ponto1.getY();

        resultado.add(new Ponto(new int[][] {{round(x)},{round(y)}, {1}}));

        while (x < ponto2.getX()){
            x+= xInc;
            y+= yInc;

            resultado.add(new Ponto(new int[][] {{round(x)},{round(y)}, {1}}));
        }

        return resultado;
    }

    public ArrayList<Ponto> retaPontoMedio(){
        ArrayList<Ponto> resultado = new ArrayList<>();

        float xAux1 = ponto1.getX();
        float yAux1 = ponto1.getY();

        float xAux2 = ponto2.getX();
        float yAux2 = ponto2.getY();

        if(ponto1.getX() > ponto2.getX()){
            xAux1 = ponto2.getX();
            xAux2 = ponto1.getX();
        }
        if(ponto1.getY() > ponto2.getY()){
            yAux1 = ponto2.getY();
            yAux2 = ponto1.getY();
        }

        float dx = xAux2 - xAux1;
        float dy = yAux2 - yAux1;

        float m = dy/dx;

        float IncE;
        float IncNE;
        float ds;

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

        float d = ds;

        if(m < 1 && m > 0){
            while(xAux1 < xAux2) {
                if (d >= 0) {
                    xAux1 += 1;
                    yAux1 += 1;
                    d += IncNE;

                    resultado.add(new Ponto(new int[][] {{round(xAux1)},{round(yAux1)}, {1}}));
                } else {
                    xAux1 += 1;

                    d += IncE;
                    resultado.add(new Ponto(new int[][] {{round(xAux1)},{round(yAux1)}, {1}}));
                }
            }
        }else{
            while(yAux1 < yAux2){
                if ( d >= 0 ){
                    xAux1 += 1;
                    yAux1 += 1;
                    d += IncNE;
                    resultado.add(new Ponto(new int[][] {{round(xAux1)},{round(yAux1)}, {1}}));
                }

                else{
                    yAux1+=1;

                    d+=IncE;
                    resultado.add(new Ponto(new int[][] {{round(xAux1)},{round(yAux1)}, {1}}));
                }
            }
        }
        return resultado;
    }
}
