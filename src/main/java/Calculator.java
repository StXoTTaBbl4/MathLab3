import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        printMethodName("Trapezoid");
//        printMethodName("Rectangle");
//        printMethodName("Simpson");
        int numOfFunc;
        double leftBorder,rightBorder;
        String methodName;
        while(true){
            printMethods();
            methodName = scanner.nextLine();
            if (methodName.equals("exit"))
                System.exit(0);

            try {
                printEquations();
                numOfFunc = scanner.nextInt();
                if (numOfFunc > 3 || numOfFunc < 1){
                    System.out.println("Уравнение под данным номером отсутствует");
                    continue;
                }

                System.out.println("Введите пределы интегрирования a b:");
                leftBorder = scanner.nextDouble();
                rightBorder = scanner.nextDouble();
                if (!checkBorders(leftBorder,rightBorder))
                    continue;

            }catch (InputMismatchException e){
                System.out.println("Границы должны быть числами");
                continue;
            }

            switch (methodName){
                //rect
                case "1" ->{

                }
                //trap
                case "2" ->{

                }
                //Simp
                case "3" ->{

                }
            }

        }
    }

    public static void printMethodName(String name) throws IOException {
        System.out.println(FileUtils.readFileToString(new File("MethodNames/" + name + ".txt"), "UTF-8"));
    }

    public static void printEquations(){
        System.out.println("Введите номер уравнения:");
        System.out.println("1: ");
        System.out.println("2: ");
        System.out.println("3: ");
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
                System.out.println("Левая граница не может быть больше\\равна правой");
                return false;
            }
        }
        else if (left < 0 && right < 0){
            if(Math.abs(right) >= Math.abs(left)){
                System.out.println("Левая граница не может быть больше\\равна правой");
                return false;
            }
        }
        else if(left >= 0 && right < 0){
            System.out.println("Левая граница не может быть больше\\равна правой");
            return false;
        }
        return true;
    }
}
