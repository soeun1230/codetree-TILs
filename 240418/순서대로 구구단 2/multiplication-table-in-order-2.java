import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(a<b){
            for(int i=a;i<=b;i++){
                for(int j=1;j<=9;j++){
                    System.out.printf("%d * %d = %d  ",i,j,i*j);
                    if(j%3==0) System.out.println();
                }
                System.out.println();
            }
        }
        else{
            for(int i=a;i>=b;i--){
                for(int j=1;j<=9;j++){
                    System.out.printf("%d * %d = %d  ",i,j,i*j);
                    if(j%3==0) System.out.println();
                }
                System.out.println();
            }
        }
    }
}