import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static int[][]Map;
    public static int[][]visited;
    public static int bigRow=0;
    public static int bigCol=0;
    public static int smallRow=100;
    public static int smallCol=100;
    // public static int[] dx = {0,0,-1,-1,-1,1,1,1};
    // public static int[] dy = {1,-1,1,-1,0,1,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[100][100];
        visited = new int[100][100];

        int sr=0;
        int sc=0;
        for(int i=0;i<N;i++){
            String[]input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0])-1;
            int col = Integer.parseInt(input[1])-1;
            Map[row][col]=1;

            if(row<smallRow) smallRow=row;
            if(row+1>bigRow) bigRow=row+1;
            if(col<smallCol) smallCol=col;
            if(col+1>bigCol) bigCol=col+1;
            if(i==0){sr=row; sc=col;}
        }

        int sum = (bigRow-smallRow)*2 + (bigCol-smallCol)*2;
        System.out.println(sum);
        //dfs(0,sr,sc);

    }
    // public static void dfs(int depth, int nr, int nc){
    //     if(depth==N){
            
    //     }
    //     for(int i=0;i<)
    // }
}