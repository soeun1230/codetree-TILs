import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b=scanner.nextInt();
        int c =scanner.nextInt();

        int[] arr = {a,b,c};

        Arrays.sort(arr);

        int sum =1;
        if(a%2==1){
            sum*=a;
        }
        if(b%2==1){
            sum*=b;
        }
        if(c%2==1){
            sum*=c;
        }

        if(sum==1){
            sum=a*b*c;
        }

        System.out.println(sum);
    }
}