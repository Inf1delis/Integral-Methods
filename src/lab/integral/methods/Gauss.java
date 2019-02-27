package lab.integral.methods;

import lab.main.Main;


public class Gauss implements IMethods {

    public double integrate (double a, double b, double n) {
        double h = (b - a) / n;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += integrateSegment(a + i * h, a + (i + 1) * h);
        }

        return sum;
    }


    public static double integrateSegment (double a, double b) {

        double[] x = { 0,  -Math.sqrt(3/(double)5),  Math.sqrt(3/(double)5) };

        for (int i = 0; i < 3; i++) {
            x[i] = 0.5 * ( (a + b) + (b - a) * x[i] );
        }

        double a0 =  8 / (double) 9;
        double a1 = 5 / (double) 9;

        double[] c = { a0, a1, a1 };

        double tmp = 0;
        for (int i = 0; i < 3; i++) {
            tmp += c[i] * Main.func( x[i] );
        }

        return ((b-a) / (double) 2) * tmp;
    }
}