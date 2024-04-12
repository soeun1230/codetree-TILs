import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        String buffer = scanner.nextLine();

        for(int i=0;i<N;i++){
            String input = scanner.nextLine();
            String cur = "";
            for(int j=0;j<M;j++){
                char now = input.charAt(j);
                for(int t=0;t<K;t++){
                    cur+=now;
                }
            }
            for(int t=0;t<K;t++){
                sb.append(cur);
                sb.append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}