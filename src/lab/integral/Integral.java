package lab.integral;

import lab.integral.methods.Gauss;
import lab.integral.methods.IMethods;
import lab.integral.methods.Square;
import lab.integral.methods.Trapeze;
import lab.main.Main;

import java.io.FileWriter;
import java.io.IOException;

public class Integral {
    private Gauss methodGauss = new Gauss();
    private Trapeze methodTrapeze = new Trapeze();
    private Square methodSquare = new Square();
    private double fromPoint;
    private double toPoint;
    private int n;
    private int till = 20;

    public Integral(double fromPoint, double toPoint, int n) {
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.n = n;
    }

    public void changeTill(int till) {
        this.till = till;
    }

    public double square() {

        return methodSquare.integrate(fromPoint, toPoint, n);
    }

    public double trapeze() {

        return methodTrapeze.integrate(fromPoint, toPoint, n);
    }

    public double gauss() {
        return methodGauss.integrate(fromPoint, toPoint, n);
    }

    public void errorGauss(FileWriter gauss) throws IOException {
        error(methodGauss, gauss);
    }

    public void errorTrapeze(FileWriter trapeze) throws IOException {
        error(methodTrapeze, trapeze);
    }

    public void errorSquare(FileWriter square) throws IOException {
        error(methodSquare, square);
    }

    private void error(IMethods method, FileWriter file) throws IOException {

        double prevTmp = 0;
        double prevPrevTmp = 0;
        double constRunge = 1 / (double) (3);
        double runge = 0;
        double func = Main.funcDerivative(fromPoint, toPoint);
        double log = 0;

        for (int i = 0; i < till; i++) {
            double tmp = method.integrate(fromPoint, toPoint, Math.pow(2, i));

            if (i > 0) {
                runge = constRunge * Math.abs(tmp - prevTmp);

            }

            if (i > 1) {
                double TMP = (prevPrevTmp - prevTmp) / (prevTmp - tmp);
                log = Math.log10(Math.abs(TMP)) / Math.log10(2);
            }

            prevPrevTmp = prevTmp;
            prevTmp = tmp;
            tmp = Math.abs(func - tmp);

            file.write(i + "     " + tmp + "     " + runge + "     " + log + "\n");
            file.flush();
        }

    }


}
