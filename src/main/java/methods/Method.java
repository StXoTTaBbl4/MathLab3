package methods;

import equations.Equation;
import equations.FirstEquation;
import equations.SecondEquation;
import equations.ThirdEquation;
import org.sk.PrettyTable;

public class Method {

    public static Equation getEquation(String num){
        switch (num){
            case "1" -> {
                return new FirstEquation();
            }
            case "2" -> {
                return new SecondEquation();
            }
            case "3" -> {
                return new ThirdEquation();
            }
        }
        return new Equation();
    }

    public static void printAnswer(PrettyTable table, double h, double I_0, double I_1, double f_val,  int n){
        System.out.println("|I_1-I_0| = " + Math.abs(I_1-I_0));
        System.out.println("h: " + h);
        System.out.println("n: " + n);
        System.out.println(table);
        System.out.println("Ответ: " + I_1);
        System.out.println("Точное значение: " + f_val);
    }
}
