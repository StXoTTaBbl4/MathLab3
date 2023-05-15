package equations;

public class SecondEquation extends Equation{
    @Override
    public double calculateIntegral(double a, double b) {

        return (Math.pow(b,4) - Math.pow(a,4))/4 - Math.pow(b,3) + 3*Math.pow(b,2) - 19*b + Math.pow(a,3) - 3*Math.pow(a,2) + 19*a;
    }

    @Override
    public double calculateFunction(double x) {
        return Math.pow(x,3) - 3*Math.pow(x,2) + 6*x - 19;
    }
}
