import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import methods.RectangleMethod;
import methods.SimpsonsMethod;
import methods.TrapezoidMethod;
import org.apache.commons.io.FileUtils;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int equation;
        double leftBorder,rightBorder;
        String method, buffer;

        while(true){
            //уравнение
            printEquations();
            buffer = scanner.nextLine();

            if (buffer.equals("exit")) {
                System.exit(0);
            }

            try{
                equation = Integer.parseInt(buffer);
                if (equation > 3 || equation < 1){
                    System.out.println("Данного уравнения не существует\n");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Номер уравнения - целое число\n");
                continue;
            }
            //

            //пределы интегрирования
            try {
                System.out.println("Введите пределы интегрирования:");
                System.out.println("a:");
                leftBorder = Double.parseDouble(scanner.nextLine());
                System.out.println("b:");
                rightBorder = Double.parseDouble(scanner.nextLine());
                if(!checkBorders(leftBorder,rightBorder)) {
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Пределы должны быть числами\n");
                continue;
            }
            //

            //метод
            printMethods();
            method = scanner.nextLine();
            //

            switch (method){
                //rect
                case "1" ->{
                    printMethodName("Rectangle");
                    RectangleMethod.getAnswer(leftBorder,rightBorder,4, equation);
                }
                //trap
                case "2" ->{
                    printMethodName("Trapezoid");
                    TrapezoidMethod.getAnswer(leftBorder,rightBorder,4, equation);
                }
                //Simpson
                case "3" ->{
                    printMethodName("Simpson");
                    SimpsonsMethod.getAnswer(leftBorder,rightBorder,4, equation);
                }
                default -> System.out.println("Данного метода не существует\n");
            }

        }
    }

    public static void printMethodName(String name) throws IOException {
        System.out.println(FileUtils.readFileToString(new File("MethodNames/" + name + ".txt"), "UTF-8"));
    }

    public static void printEquations(){
        System.out.println("Введите номер уравнения:");
        System.out.println("1: x^2 (1,2)");
        System.out.println("2: x^3 - 3*x^2 + 6*x - 19 (2,4)");
        System.out.println("3: -x^3 -x^2 -2x + 1 (0,2)");
        System.out.println("Выход: exit ");

    }

    public static void printMethods(){
        System.out.println("Выберите метод:");
        System.out.println("1: Метод прямоугольников");
        System.out.println("2: Метод трапеций");
        System.out.println("3: Метод Симпсона");
    }

    public static boolean checkBorders(double left, double right){
        if (left >= 0 && right>=0) {
            if (left >= right) {
                System.out.println("Левая граница не может быть больше\\равна правой\n");
                return false;
            }
        }
        else if (left < 0 && right < 0){
            if(Math.abs(right) >= Math.abs(left)){
                System.out.println("Левая граница не может быть больше\\равна правой\n");
                return false;
            }
        }
        else if(left >= 0 && right < 0){
            System.out.println("Левая граница не может быть больше\\равна правой\n");
            return false;
        }
        return true;
    }
}
