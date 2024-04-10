import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int small = Integer.MAX_VALUE;
        int big = 0;

        int n = scanner.nextInt();

        for(int i=0;i<n;i++){
            int now = scanner.nextInt();
            small = Math.min(small,now);
            big = Math.max(big,now);
        }
        System.out.printf("%d %d",small,big);
    }
}