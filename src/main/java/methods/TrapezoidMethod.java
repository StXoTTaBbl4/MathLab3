package methods;

import equations.Equation;
import org.sk.PrettyTable;

import java.util.ArrayList;

public class TrapezoidMethod {
    public static void getAnswer(double a, double b, int intervals, int eq){
        Equation equation = Method.getEquation(String.valueOf(eq));

        ArrayList<String> I = new ArrayList<>(),
                x_i = new ArrayList<>(),
                y_i = new ArrayList<>();

        double y_0 = equation.calculateFunction(a),
                y_n = equation.calculateFunction(b),
                h = (b-a)/intervals,
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
        System.out.println("h: " + h);

        PrettyTable table = new PrettyTable("i","x_i","y_i");
        for (int i = 0; i < I.size(); i++) {
            table.addRow(I.get(i),x_i.get(i),y_i.get(i));
        }
        System.out.println(table);

        System.out.println("Ответ: " + sum*h);
        System.out.println("Точное значение: " + equation.calculateIntegral(a,b));

    }
}
