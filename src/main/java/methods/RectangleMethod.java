package methods;

import equations.Equation;
import org.sk.PrettyTable;

import java.util.ArrayList;
import java.util.Arrays;

public class RectangleMethod {

    public static void getAnswer(double leftBorder, double rightBorder, int intervals, int equation){


        System.out.println("Мод: левые");
        left(leftBorder,rightBorder,intervals,equation);
        System.out.println("\nМод: правые");
        right(leftBorder,rightBorder,intervals,equation);
        System.out.println("\nМод: средние");
        middle(leftBorder,rightBorder,intervals,equation);
        System.out.println("====================");
    }

    private static void left(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                        x_i = new ArrayList<>(),
                        y_i = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));


        double h = (b-a)/intervals, x = a, y = 0, sum = 0;

        for (int i = 0; i < intervals; i++) {
            I.add(String.valueOf(i));

            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));

            sum +=y;
            x+=h;
        }

        System.out.println("h: " + h);

        PrettyTable table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i));
        }
        System.out.println(table);

        System.out.println("Ответ: " + sum*h);
        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));

    }
    private static void right(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                        x_i = new ArrayList<>(),
                        y_i = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));

        double h = (b-a)/intervals, x = a + h, y = 0, sum = 0;

        for (int i = 1; i <= intervals; i++) {
            I.add(String.valueOf(i));

            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));

            sum +=y;
            x+=h;
        }

        System.out.println("h: " + h);

        PrettyTable table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i));
        }
        System.out.println(table);

        System.out.println("Ответ: " + sum*h);
        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));

    }
    private static void middle(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>(),
                x_i_05 = new ArrayList<>(),
                y_i_05 = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));


        double h = (b-a)/intervals,x_prev = a, x = a + h,x_, y = 0, sum = 0;

        for (int i = 1; i <= intervals; i++) {
            I.add(String.valueOf(i));

            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));

            x_ =  (x_prev + x)/2;
            x_i_05.add(String.valueOf(x_));

            y = equation.calculateFunction(x_);
            y_i_05.add(String.valueOf(y));

            x_prev = x;

            sum +=y;
            x+=h;
        }
        System.out.println("h: " + h);

        PrettyTable table = new PrettyTable("i","x_i","y_i","x_(i-0.5)","y_(i-0.5)");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i), x_i_05.get(i), y_i_05.get(i));
        }
        System.out.println(table);

        System.out.println("Ответ: " + sum*h);
        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));

    }

}
