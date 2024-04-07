import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static int N,M;
    public static int[][] Map;
    public static int ans =0;
    public static int[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        Map = new int[N][M];
        visited = new int[N][M];
        ArrayList<Node> arr = new ArrayList<>();

        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(input[j]);
                Map[i][j]=n;
                if(n==-1) visited[i][j]=1;
                else if(n==1) {
                    Node node = new Node(i,j,0);
                    arr.add(node);
                }
            }
        }

        Queue<Node> que = new LinkedList<>();
        for(int i=0;i<arr.size();i++){
            que.offer(arr.get(i));
        }

        while(!que.isEmpty()){
            Node cur = que.poll();

            if(visited[cur.x][cur.y]==1){
                ans = Math.max(ans, cur.cnt);
                continue;
            }
            
            visited[cur.x][cur.y]=1;
            
            int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir : directions){
                int nx = cur.x+dir[0];
                int ny = cur.y+dir[1];
                
                if(nx<0||nx>=N || ny<0||ny>=M) continue;
                if(visited[nx][ny]==1 || Map[nx][ny]==-1) continue;

                Map[nx][ny]=1;
                Node no = new Node(nx,ny,cur.cnt+1);
                que.offer(no);
            }
        }

        if(check()){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
    public static boolean check(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(Map[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static class Node{
        private int x;
        private int y;
        private int cnt;

        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}