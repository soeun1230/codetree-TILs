import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b=scanner.nextInt();
        int c =scanner.nextInt();

        boolean ch = false;

        int sum =1;
        if(a%2==1){
            sum*=a;
            ch=true;
        }
        if(b%2==1){
            sum*=b;
            ch=true;
        }
        if(c%2==1){
            sum*=c;
            ch=true;
        }

        if(ch==false){
            sum=a*b*c;
        }

        System.out.println(sum);
    }
}