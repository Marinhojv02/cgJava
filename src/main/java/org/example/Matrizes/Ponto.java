package org.example.Matrizes;

public class Ponto {
    double[][] coordenada;

    public Ponto(double[][] coordenada){
        this.coordenada = coordenada;
    }
    public double[][] getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(double[][] coordenada){
        this.coordenada = coordenada;
    }
    public double getX(){
        return coordenada[0][0];
    }
    public double getY(){
        return coordenada[1][0];
    }
}
