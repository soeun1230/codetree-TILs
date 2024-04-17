import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(((n%4==0)&&(n%100!=0))||(n%400==0)){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }

    }
}