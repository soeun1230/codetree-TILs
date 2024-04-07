import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int N;
    public static int[][] Map;
    public static int[][] visited;
    public static ArrayList<Integer> arr;
    public static int sum=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        visited = new int[N][N];
        arr = new ArrayList<>();


        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                int n = Integer.parseInt(input[j]);
                Map[i][j]=n;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==0 && Map[i][j]==1){
                    sum=0;
                    dfs(i,j);
                    arr.add(sum);
                }
            }
        }
        int size = arr.size();
        System.out.println(size);
        
        Collections.sort(arr);

        for(int i=0;i<size;i++){
            System.out.println(arr.get(i));
        }
    }
    public static void dfs(int row, int col){
        if(Map[row][col]==0 || visited[row][col]==1) return;
        
        visited[row][col]=1;
        sum++;

        int[][]direction = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[]dir : direction){
            int nx = row+dir[0];
            int ny = col+dir[1];

            if(nx>=N||nx<0||ny>=N||ny<0) continue;
            if(visited[nx][ny]==1) continue;

            dfs(nx,ny);
        }
    }
}