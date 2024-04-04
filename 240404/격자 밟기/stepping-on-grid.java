import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int[][] map;
    public static int n;
    public static int[][] visited;
    public static int sum=0;
    public static int[]dr = {0,0,1,-1};
    public static int[]dc = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[5][5];
        visited = new int[5][5];

        for(int i=0;i<n;i++){
            String[]input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0])-1;
            int col = Integer.parseInt(input[1])-1;
            map[row][col]=2;
            visited[row][col]=1;
        }

        visited[0][0]=1;
        visited[4][4]=1;

        int cnt=23-n;
        dfs(0,0,4,4,cnt,true);
        System.out.println(sum);
    }
    public static void dfs(int ar, int ac, int br, int bc, int cnt, boolean flag){
        if(flag){
            for(int i = 0; i < 4; i++){
                int nr = ar + dr[i];
                int nc = ac + dc[i];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]==1) continue;
                visited[nr][nc] = 1;
                dfs(nr, nc, br, bc, cnt - 1, !flag);
                visited[nr][nc] = 0;
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                int nr = br + dr[i];
                int nc = bc + dc[i];

                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if(cnt == 0){
                    if(ar == nr && ac == nc){
                        sum++;
                        return;
                    }
                    else continue;
                }
                if(visited[nr][nc]==1) continue;
                visited[nr][nc] = 1;
                dfs(ar, ac, nr, nc, cnt - 1, !flag);
                visited[nr][nc] = 0;
            }
        }
    }
}