import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static int[][]Map;
    public static int[][]visited;
    public static int sum=0;
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

            if(i==0){sr=row; sc=col;}
        }

        for(int i=0;i<100;i++){
            int ch = 0;
            for(int j=0;j<100;j++){
                if(Map[i][j]==1) ch=1;
                if(Map[i][j]==0 && visited[i][j]==0){
                    if(ch==1) break;
                    dfs(i,j);
                }
            }
        }

        System.out.println(sum);

    }
    public static void dfs(int nr, int nc){
        if(nr>=100 || nr<0 || nc>=100 || nc<0) return;
        if(Map[nr][nc]==1 || visited[nr][nc]==1) return;

        visited[nr][nc]=1;

        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : direction) {
            int nx = nr + d[0];
            int ny = nc + d[1];
            if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;

            if(Map[nx][ny] == 1) {
                sum++;
            }
        }

        for(int[] d : direction){
            int nx = nr + d[0];
            int ny = nc + d[1];
            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && Map[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }

    }
}