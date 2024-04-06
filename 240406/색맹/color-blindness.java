import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static int[] ans;
    public static int[] green;
    public static int[] dx={0,0,1,-1};
    public static int[] dy={1,-1,0,0};
    public static int N;
    public static int[][] Map;
    public static int[][] Map2;
    public static int[][] visited;
    public static int[][] visited2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        visited = new int[N][N];
        Map2 = new int[N][N];
        visited2 = new int[N][N];
        ans = new int[3];
        green = new int[2];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                if(input.charAt(j)=='R'){
                    Map[i][j]=1;
                    Map2[i][j]=1;
                }
                else if(input.charAt(j)=='B'){
                    Map[i][j]=2;
                    Map2[i][j]=2;
                }
                else{
                    Map[i][j]=3;
                    Map2[i][j]=1;
                }
            }
        }
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<N;j++){
        //         System.out.print(Map[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]!=1){
                    if(Map[i][j]==1){
                        ans[0]+=1;
                        dfs(i,j,1);
                    }
                    else if(Map[i][j]==2){
                        ans[1]+=1;
                        dfs(i,j,2);
                    }
                    else if(Map[i][j]==3){
                        ans[2]+=1;
                        dfs(i,j,3);
                    }
                    else{
                        continue;
                    }
                }
                if(visited2[i][j]!=1){
                    if(Map2[i][j]==1){
                        green[0]+=1;
                        dfs2(i,j,1);
                    }
                    else if(Map2[i][j]==2){
                        green[1]+=1;
                        dfs2(i,j,2);
                    }
                }
            }
        }
        System.out.print(ans[0]+ans[1]+ans[2]+" ");
        System.out.print(green[0]+green[1]);
    }
    public static void dfs(int row, int col,int ch){
        if(Map[row][col]!=ch || visited[row][col]==1) {
            return;
        }

        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int nx = row+dx[i];
            int ny = col+dy[i];

            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(visited[nx][ny]==1) continue;

            dfs(nx,ny,ch);
        }
    }
    public static void dfs2(int row, int col,int ch){
        if(Map2[row][col]!=ch || visited2[row][col]==1) return;

        visited2[row][col]=1;
        for(int i=0;i<4;i++){
            int nx = row+dx[i];
            int ny = col+dy[i];

            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(visited2[nx][ny]==1) continue;

            dfs2(nx,ny,ch);
        }
    }
}