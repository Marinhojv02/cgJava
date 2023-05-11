package org.example.Matrizes;

import java.util.ArrayList;
import org.netlib.blas.Dgemm;

public class Matrizes {
    ArrayList<int[][]> matrizes;
    ArrayList<Ponto> pontos;

    public Matrizes(){
        matrizes = new ArrayList<int[][]>();
        pontos = new ArrayList<Ponto>();
    }

    public Matrizes(ArrayList<int[][]> listaMatrizes){
        matrizes = new ArrayList<int[][]>(listaMatrizes);
        pontos = new ArrayList<Ponto>();
    }

    public void addMatriz(int[][] newMatriz){
        matrizes.add(0, newMatriz);
    }

    //função para multiplicar matrizes
    public static int[][] multiplicaMatriz(int[][] matriz1, int[][] matriz2) {
        int m1Rows = matriz1.length;
        int m1Cols = matriz1[0].length;
        int m2Rows = matriz2.length;
        int m2Cols = matriz2[0].length;

        //caso as matrizes tenham dimensoes incompativeis, é retornado um erro
        if (m1Cols != m2Rows) {
            throw new IllegalArgumentException("Cannot multiply matrices: incompatible dimensions");
        }

        //estrutura que multiplica as matrizes
        int[][] resultado = new int[m1Rows][m2Cols];
        for (int i = 0; i < m1Rows; i++) {
            for (int j = 0; j < m2Cols; j++) {
                for (int k = 0; k < m1Cols; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }


    //multiplica todas as matrizes (para composição e aplicar transformações em objetos complexos)
    public int[][] multiplicaTudo(){
        //se nao ha matrizes retorna erro
        if(matrizes == null || matrizes.size() == 0){
            throw new IllegalArgumentException("No matrix was provided");
        }
        //se só ha uma matriz retorna ela
        if(matrizes.size() == 1 && pontos.size() == 0){
            return matrizes.get(0);
        }

        //efetua a multiplicação de todas as matrizes e armazena o resultado na variavel "resultado"
        int[][] resultado;
        resultado = multiplicaMatriz(matrizes.get(0), matrizes.get(1));
        for (int i = 2; i < matrizes.size(); i++) {
            resultado = multiplicaMatriz(resultado, matrizes.get(i));
            System.out.println(i);
        }

        //caso haja pontos é calculada a multiplicação da matriz com eles, caso contrario retorna o resultado
        if(pontos != null && pontos.size() > 0){
            for (int i = 0; i < pontos.size()-1; i++) {
                resultado = multiplicaMatriz(resultado, pontos.get(i).getCoordenada());
            }
        }

        return resultado;
    }

    //gets e sets
    public ArrayList<int[][]> getMatrizes() {
        return matrizes;
    }

    public void setMatrizes(ArrayList<int[][]> matrizes) {
        this.matrizes = matrizes;
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }
}
