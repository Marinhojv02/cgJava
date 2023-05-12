package org.example;

import org.example.Matrizes.Matrizes;
import org.example.Matrizes.Ponto;
import org.example.figuras.Reta;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Matrizes teste = new Matrizes();

        double[][] matriz1 = {{2,0,0},{0,1,0},{0,0,1}};
        Ponto testePonto = new Ponto(new double[][]{{5},{1},{1}});

        teste.addMatriz(matriz1);
        teste.addPonto(testePonto);

        System.out.println(Arrays.deepToString(teste.relizaComposicao()));
    }
}