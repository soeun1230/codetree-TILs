import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static int[][] map;
    public static int[][] visited;
    public static int cnt=0;
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);

        map = new int[N][M];
        visited = new int[N][M];

        //initialize
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                int now = Integer.parseInt(input[j]);
                map[i][j]=now;
            }
        }
        
        //call dfs()
        while(howMany()<2){
            if(noNum()){
                System.out.println(0);
                return;
            }

            visited = new int[N][M];
            visited[0][0]=1;
            cnt++;
            dfs(0,0);
        }
        System.out.println(cnt);
    }
    //-1->0으로 바꿔주고, 집합 몇개인지 count
    public static int howMany(){
        int[][] v = new int[N][M];
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==-1) map[i][j]=0;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0 && v[i][j]!=1){
                    count++;
                    Queue<int[]> que = new LinkedList<>();
                    int[]p= new int[2];
                    p[0]=i;
                    p[1]=j;
                    que.offer(p);
                    v[i][j]=1;
                    while(!que.isEmpty()){
                        int[]cur = que.poll();
                        for(int[]dir : directions){
                            int nx = cur[0]+dir[0];
                            int ny = cur[1]+dir[1];

                            if(nx<0||nx>=N||ny<0||ny>=M) continue;
                            if(v[nx][ny]==1) continue;

                            v[nx][ny]=1;
                            if(map[nx][ny]!=0){
                                int[] put = new int[2];
                                put[0]=nx;
                                put[1]=ny;
                                que.offer(put);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static boolean noNum(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0) return false;
            }
        }
        return true;
    }
    public static void dfs(int x, int y){
        for(int[] dir : directions){
            int nx = x+dir[0];
            int ny = y+dir[1];

            if(nx<0||nx>=N || ny<0||ny>=M) continue;
            if(visited[nx][ny]==1) continue;

            visited[nx][ny]=1;
            if(map[nx][ny]!=0){
                int ch=0;
                for(int[]d : directions){
                    int chx = nx+d[0];
                    int chy = ny+d[1];
                    if(map[chx][chy]==0) ch++;
                }
                if(map[nx][ny]>ch){
                    map[nx][ny]=map[nx][ny]-ch;
                }
                else{
                    map[nx][ny]=-1;
                }
            }
            else{
                visited[nx][ny]=1;
            }
            dfs(nx,ny);
        }
    }
}