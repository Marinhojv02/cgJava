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
        Reta retaTeste = new Reta(new Ponto(new int[][] {{-11},{20},{1}}), new Ponto(new int[][] {{-10},{40},{1}}));

        ArrayList<Ponto> teste = retaTeste.retaDDA();

    }
}