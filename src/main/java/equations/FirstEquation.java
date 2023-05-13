package equations;

public class FirstEquation extends Equation{
    @Override
    public double calculateIntegral(double a, double b) {
        return Math.pow(b,3)/3-Math.pow(a,3)/3;
    }

    @Override
    public double calculateFunction(double x) {
        return Math.pow(x,2);
    }
}
