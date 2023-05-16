package methods;

import equations.Equation;
import org.sk.PrettyTable;

import java.util.ArrayList;

public class TrapezoidMethod {

    private static PrettyTable table = new PrettyTable();
    private static double h;
    public static void getAnswer(double a, double b,double epsilon, int intervals, int eq){
        double I_0 = calculateI_0(a,b,intervals,eq);
        intervals = intervals*2;
        double I_1 = calculateI_1(a,b,intervals,eq);

        int c = 0;
        while ((Math.abs(I_1-I_0) > epsilon) || c == 20){
            System.out.println("I_0 = " + I_0 + "; I_1 = " + I_1);
            intervals *=2;
            I_0 = I_1;
            I_1 = calculateI_1(a,b,intervals,eq);
            c++;
        }

        Method.printAnswer(table,
                h,
                I_0,
                I_1,
                Math.round(Method.getEquation(String.valueOf(eq)).calculateIntegral(a,b)*(1/epsilon))*epsilon,
                intervals);

    }

    private static double calculateI_0(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));

        h = (b-a)/intervals;
        double y_0 = equation.calculateFunction(a),
                y_n = equation.calculateFunction(b),
                x = a + h,
                y,
                sum = 0;

        for (int i = 1; i < intervals; i++) {

            y = equation.calculateFunction(x);
            sum+=y;
            x+=h;
        }

        sum +=(y_0+y_n)/2;
        return  sum*h;
    }
    private static double calculateI_1(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));

        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>();

        h = (b-a)/intervals;
        double y_0 = equation.calculateFunction(a),
                y_n = equation.calculateFunction(b),
                x = a + h,
                y,
                sum = 0;

        for (int i = 1; i < intervals; i++) {
            I.add(String.valueOf(i));
            x_i.add(String.valueOf(x));

            y = equation.calculateFunction(x);
            y_i.add(String.valueOf(y));
            sum+=y;
            x+=h;
        }

        sum +=(y_0+y_n)/2;

        table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i),x_i.get(i),y_i.get(i));
        }

        return sum*h;
    }
}
