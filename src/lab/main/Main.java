package lab.main;


import lab.integral.Integral;

import java.io.FileWriter;
import java.io.IOException;



/*
Функция на отрезке [a,b]:                   Math.sin(x)                                               Math.sqrt(x)
Производная :                    -Math.cos(toPoint) + Math.cos(fromPoint)          1/(2*Math.sqrt(toPoint)) - 1/(2*Math.sqrt(fromPoint))
(2*Math.sqrt(Math.pow(toPoint,3))))/3.0 - (2*Math.sqrt(Math.pow(fromPoint,3))))/3.0
 */

public class Main {

    public static double func (double x) {
        return Math.sqrt(x);
    }

    public static double funcDerivative (double fromPoint, double toPoint) {
        return  (2*Math.sqrt(Math.pow(toPoint,3))) / 3.0 - (2*Math.sqrt(Math.pow(fromPoint,3)))/3.0;
    }

    public static void main(String[] args) throws IOException {

        FileWriter gauss = new FileWriter("/Users/infidelis/IdeaProjects/Integral/src/lab/files/gauss.txt");
        FileWriter square = new FileWriter("/Users/infidelis/IdeaProjects/Integral/src/lab/files/square.txt");
        FileWriter trapeze = new FileWriter("/Users/infidelis/IdeaProjects/Integral/src/lab/files/trapeze.txt");

        Integral integral = new Integral(0,1, 100);

        integral.changeTill(10); // КОЛИЧЕСТВО ЦИКЛОВ ПОГРЕШНОСТИ

        System.out.println( "Прямоугольньники: " + integral.square());
        System.out.println( "Трапеции: " + integral.trapeze());
        System.out.println( "Гаусс: " + integral.gauss());

        integral.errorGauss(gauss);
        integral.errorSquare(square);
        integral.errorTrapeze(trapeze);


    }
}
