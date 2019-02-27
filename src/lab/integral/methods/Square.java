package lab.integral.methods;

import lab.main.Main;


public class Square implements IMethods {

    public double integrate (double a, double b, double n) {

        double h = (b-a) / n;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Main.func(a + i * h  + h * 0.5);
        }
        return h * sum;
    }
}