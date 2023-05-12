package org.example.Matrizes;

import java.util.ArrayList;

public class Matrizes {
    ArrayList<double[][]> matrizes;
    ArrayList<Ponto> pontos;
    double[][] matrizM;

    public Matrizes(){
        matrizes = new ArrayList<>();
        pontos = new ArrayList<>();
    }

    public Matrizes(ArrayList<double[][]> listaMatrizes){
        matrizes = new ArrayList<>(listaMatrizes);
        pontos = new ArrayList<>();
    }

    public void addMatriz(double[][] newMatriz){
        matrizes.add(0, newMatriz);
    }
    public void addPonto(Ponto newPonto){
        pontos.add( newPonto);
    }

    //função para multiplicar matrizes
    public static double[][] multiplicaMatriz(double[][] matriz1, double[][] matriz2) {
        int m1Rows = matriz1.length;
        int m1Cols = matriz1[0].length;
        int m2Rows = matriz2.length;
        int m2Cols = matriz2[0].length;

        //caso as matrizes tenham dimensoes incompativeis, é retornado um erro
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException("Cannot multiply matrices: incompatible dimensions");
        }

        //estrutura que multiplica as matrizes
        double[][] resultado = new double[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }


    //multiplica a sequencia de matrizes a fim de retornar a matriz M
    public double[][] relizaComposicao(){
        //retorna erro caso nenhuma matriz seja fornecida
        if(matrizes == null || matrizes.size() == 0){
            throw new IllegalArgumentException("No matrix was provided");
        }

        //efetua a multiplicação de todas as matrizes e armazena o resultado na variavel "resultado"
        double[][] resultado = matrizes.get(0);

        for (int i = 1; i < matrizes.size(); i++) {
            resultado = multiplicaMatriz(resultado, matrizes.get(i));
            System.out.println(i);
        }

        return resultado;
    }

    //funcao para realizar transformacao nos pontos
    public ArrayList<Ponto> transformaPonto(){
        //retorna erro caso nenhum ponto seja fornecido
        if(pontos == null || pontos.size() == 0){
            throw new IllegalArgumentException("No position was provided");
        }

        for (Ponto ponto:pontos) {
            ponto.setCoordenada(multiplicaMatriz(matrizM, ponto.getCoordenada()));
        }

        return pontos;
    }

    //gets e sets
    public ArrayList<double[][]> getMatrizes() {
        return matrizes;
    }

    public void setMatrizes(ArrayList<double[][]> matrizes) {
        this.matrizes = matrizes;
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }
    public void gerarMatrizM(){
        matrizM = relizaComposicao();
    }

    public double[][] getMatrizM(){
        return matrizM;
    }
}
