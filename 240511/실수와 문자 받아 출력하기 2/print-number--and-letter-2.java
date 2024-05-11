import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String aa = scanner.next();
        char a = aa.charAt(0);
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("%.2f\n%.2f\n%c",c,b,a);
    }
}