package org.example.figuras;

import org.example.Matrizes.Ponto;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class elipse {
    private ArrayList<Ponto> pontosElipse;
    private float elipseCenter;
    private float minorRadius;

    public elipse(float elipseCenter, float minorRadius){
        this.elipseCenter = elipseCenter;
        this.minorRadius = minorRadius;

        pontosElipse = pontoMedio();
    }

    public ArrayList<Ponto> pontoMedio()
    {
        ArrayList<Ponto> resultado = new ArrayList<>();

        float dx, dy, d1, d2, x, y;
        x = 0;
        y = minorRadius;

        // Decisao inicial de regiao
        d1 = (minorRadius * minorRadius) - (elipseCenter * elipseCenter * minorRadius) +
                (0.25f * elipseCenter * elipseCenter);
        dx = 2 * minorRadius * minorRadius * x;
        dy = 2 * elipseCenter * elipseCenter * y;
        DecimalFormat df = new DecimalFormat("#,###,##0.00000");


        // Para primeira regiao
        while (dx < dy)
        {

            // adicionando pontos basseado na simetria de 4 lados
            resultado.add(new Ponto(new double[][] {{(int) x},{(int) y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) x},{(int) -y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) -x},{(int) y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) -x},{(int) -y},{1}}));

            // Checking and updating value of
            // decision parameter based on algorithm
            if (d1 < 0)
            {
                x++;
                dx = dx + (2 * minorRadius * minorRadius);
                d1 = d1 + dx + (minorRadius * minorRadius);
            }
            else
            {
                x++;
                y--;
                dx = dx + (2 * minorRadius * minorRadius);
                dy = dy - (2 * elipseCenter * elipseCenter);
                d1 = d1 + dx - dy + (minorRadius * minorRadius);
            }
        }

        // Decision parameter of region 2
        d2 = ((minorRadius * minorRadius) * ((x + 0.5f) * (x + 0.5f)))
                + ((elipseCenter * elipseCenter) * ((y - 1) * (y - 1)))
                - (elipseCenter * elipseCenter * minorRadius * minorRadius);

        // Plotting points of region 2
        while (y >= 0) {

            // adicionando pontos basseado na simetria de 4 lados
            resultado.add(new Ponto(new double[][] {{(int) x},{(int) y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) -x},{(int) y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) x},{(int) -y},{1}}));
            resultado.add(new Ponto(new double[][] {{(int) -x},{(int) -y},{1}}));

            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0) {
                y--;
                dy = dy - (2 * elipseCenter * elipseCenter);
                d2 = d2 + (elipseCenter * elipseCenter) - dy;
            }
            else {
                y--;
                x++;
                dx = dx + (2 * minorRadius * minorRadius);
                dy = dy - (2 * elipseCenter * elipseCenter);
                d2 = d2 + dx - dy + (elipseCenter * elipseCenter);
            }
        }
        return resultado;
    }

    public ArrayList<Ponto> getPontosElipse() {
        return pontosElipse;
    }

    public void setPontosElipse(ArrayList<Ponto> pontosElipse) {
        this.pontosElipse = pontosElipse;
    }
}
