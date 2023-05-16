package methods;

import equations.Equation;
import org.sk.PrettyTable;

import java.util.ArrayList;
import java.util.Arrays;

public class RectangleMethod {

    private static PrettyTable table = new PrettyTable();
    private static double h;

    public static void getAnswer(double a, double b,double epsilon, int intervals, int eq){

        System.out.println("Мод: левые");
        double I_0 = calculate_left_I_0(a,b,intervals,eq);
        int intervals_Buf = intervals*2;
        double I_1 = calculate_left_I_1(a,b,intervals_Buf,eq);

        int c = 0;
        while ((Math.abs(I_1-I_0) > epsilon)){
            intervals_Buf *=2;
            I_0 = I_1;
            I_1 = calculate_left_I_1(a,b,intervals_Buf,eq);
            c++;
        }
        Method.printAnswer(table,
                h,
                I_0,
                I_1,
                Math.round(Method.getEquation(String.valueOf(eq)).calculateIntegral(a,b)*(1/epsilon))*epsilon,
                intervals_Buf);


        System.out.println("\nМод: правые");
        I_0 = calculate_right_I_0(a,b,intervals,eq);
        intervals_Buf = intervals*2;
        I_1 = calculate_right_I_1(a,b,intervals_Buf,eq);

        c = 0;
        while ((Math.abs(I_1-I_0) > epsilon)){
            intervals_Buf *=2;
            I_0 = I_1;
            I_1 = calculate_right_I_1(a,b,intervals_Buf,eq);
            c++;
        }

        Method.printAnswer(table,
                h,
                I_0,
                I_1,
                Math.round(Method.getEquation(String.valueOf(eq)).calculateIntegral(a,b)*(1/epsilon))*epsilon,
                intervals_Buf);


        System.out.println("\nМод: средние");
        I_0 = calculate_middle_I_0(a,b,intervals,eq);
        intervals_Buf = intervals*2;
        I_1 = calculate_middle_I_1(a,b,intervals_Buf,eq);

        c = 0;
        while ((Math.abs(I_1-I_0) > epsilon)){
            intervals_Buf *=2;
            I_0 = I_1;
            I_1 = calculate_middle_I_1(a,b,intervals_Buf,eq);
            c++;
        }

        Method.printAnswer(table,
                h,
                I_0,
                I_1,
                Math.round(Method.getEquation(String.valueOf(eq)).calculateIntegral(a,b)*(1/epsilon))*epsilon,
                intervals_Buf);
    }

    private  static double calculate_left_I_0(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));
        h = (b-a)/intervals;
        double x = a, y = 0, sum = 0;

        for (int i = 0; i < intervals; i++) {

            y = equation.calculateFunction(x);

            sum +=y;
            x+=h;
        }
        return sum *=h;
    }
    private  static double calculate_left_I_1(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));


        h = (b-a)/intervals;
        double x = a, y = 0, sum = 0;

        for (int i = 0; i < intervals; i++) {
            I.add(String.valueOf(i));

            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));

            sum +=y;
            x+=h;
        }

//        System.out.println("h: " + h);

        table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i));
        }
//        System.out.println(table);
//
//        System.out.println("Ответ: " + sum*h);
//        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));
        return sum*h;
    }
    private  static double calculate_right_I_0(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));

        h = (b-a)/intervals;
        double  x = a + h, y = 0, sum = 0;

        for (int i = 1; i <= intervals; i++) {

            y = equation.calculateFunction(x);

            sum +=y;
            x+=h;
        }
        return sum*h;
    }
    private  static double calculate_right_I_1(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));

        h = (b-a)/intervals;
        double  x = a + h, y = 0, sum = 0;

        for (int i = 1; i <= intervals; i++) {
            I.add(String.valueOf(i));

            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));

            sum +=y;
            x+=h;
        }

//        System.out.println("h: " + h);

        table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i));
        }
//        System.out.println(table);
//
//        System.out.println("Ответ: " + sum*h);
//        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));
        return sum*h;
    }
    private  static double calculate_middle_I_0(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));


        h = (b-a)/intervals;
        double x_prev = a, x = a + h,x_, y = 0, sum = 0;

        for (int i = 1; i <= intervals; i++) {

            y = equation.calculateFunction(x);

            x_ =  (x_prev + x)/2;

            y = equation.calculateFunction(x_);

            x_prev = x;

            sum +=y;
            x+=h;
        }

        return sum*h;
    }
    private  static double calculate_middle_I_1(double a, double b, int intervals, int eq){
        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>(),
                x_i_05 = new ArrayList<>(),
                y_i_05 = new ArrayList<>();

        Equation equation = Method.getEquation(String.valueOf(eq));


        h = (b-a)/intervals;
        double x_prev = a, x = a + h,x_, y = 0, sum = 0;

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

        table = new PrettyTable("i","x_i","y_i","x_(i-0.5)","y_(i-0.5)");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i), x_i.get(i), y_i.get(i), x_i_05.get(i), y_i_05.get(i));
        }
//        System.out.println(table);
//
//        System.out.println("Ответ: " + sum*h);
//        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));
        return sum*h;

    }


}
