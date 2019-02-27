package lab.integral.methods;

import lab.main.Main;


public class Trapeze implements IMethods {

    public double integrate (double a, double b, double n) {

        double h = (b-a) / n;
        double sum = ( Main.func(a) + Main.func(b) );

        for (int i = 1; i <=  n-1; i++) {
            sum += 2 * Main.func(a + i*h );
        }

        return 0.5 * h * sum;
    }
}
