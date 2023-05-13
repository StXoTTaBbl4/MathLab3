package methods;

import equations.Equation;
import equations.FirstEquation;
import equations.SecondEquation;
import equations.ThirdEquation;

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
}
