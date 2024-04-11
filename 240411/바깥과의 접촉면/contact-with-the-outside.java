import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static int[][] Map;
    public static int[][] visited;
    public static int cnt =0;
    public static int ch =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        Map = new int[N][M];
        visited = new int[N][M];

        //Map 에 숫자 입력 
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(input[j]);
                Map[i][j]=n;
            }
        }

        //dfs 호출 
        while(isLeft()){
            visited=new int[N][M];
            
            ch=0;

            visited[0][0]=1;
            dfs(0,0);
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(ch);
    }   
    public static boolean isLeft(){
        //Map[i][j]=2 -> 0으로 바꿔주기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Map[i][j]==2) Map[i][j]=0;
            }
        }

        //1 남았나 확인
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Map[i][j]==1) return true;
            }
        }
        
        return false;
    }

    //row, col 부터 테두리에 있는 1 찾기 시작 
    public static void dfs(int row, int col){
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] dir : directions){
            int dx = row+dir[0];
            int dy = col+dir[1];

            if(dx<0||dx>=N || dy<0||dy>=M) continue;
            if(visited[dx][dy]==1) continue;

            visited[dx][dy]=1;
            if(Map[dx][dy]==1){
                Map[dx][dy]=2;
                ch++;
            }
            else{
                dfs(dx,dy);
            }
        }
    }
}