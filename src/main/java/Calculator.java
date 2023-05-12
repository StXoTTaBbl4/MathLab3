import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printMethodName("Trapezoid");
        printMethodName("Rectangle");
        printMethodName("Simpson");
    }

    public static void printMethodName(String name) throws IOException {
        System.out.println(FileUtils.readFileToString(new File("MethodNames/" + name + ".txt"), "UTF-8"));
    }
}
