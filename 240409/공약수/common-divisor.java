import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        if(a==2){
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if(b<c){
                for(int i=1;i<=b;i++){
                    if(b%i==0 && c%i==0){
                        System.out.println(i);
                    }
                }
            }
            else{
                for(int i=1;i<=c;i++){
                    if(b%i==0 && c%i==0){
                        System.out.println(i);
                    }
                }
            }
        }
        if(a==3){
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            int k = Math.min(b,c);
            int t = Math.min(k,d);

            for(int i=1;i<=t;i++){
                if(b%i==0 && c%i==0 && d%i==0){
                    System.out.println(i);
                }
            }
        }
    }
}