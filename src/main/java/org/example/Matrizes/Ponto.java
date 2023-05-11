package org.example.Matrizes;

public class Ponto {
    int[][] coordenada;

    public Ponto(int[][] coordenada){
        this.coordenada = coordenada;
    }
    public int[][] getCoordenada() {
        return coordenada;
    }

    public int getX(){
        return coordenada[0][0];
    }
    public int getY(){
        return coordenada[1][0];
    }
}
