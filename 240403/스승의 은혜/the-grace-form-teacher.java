import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);

        int[][] map = new int[N][2];
        for(int i=0;i<N;i++){
            String[] put = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(put[0]);
            map[i][1] = Integer.parseInt(put[1]);
        }

        Arrays.sort(map, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int a = o1[0]+o1[1];
                int b = o2[0]+o2[1];
                return a-b;
            }
        });

        int sum =0;
        int idx=0;
        int cnt=0;
        while(sum<money){
            if(idx==N) break;
            int now = map[idx][0]+map[idx][1];
            if(sum+now<=money){
                idx++;
                sum+=now;
                cnt++;
            }
            else{
                now = map[idx][0]/2 + map[idx][1];
                if(sum+now<=money){
                    cnt++;
                    break;
                }
                idx++;
            }
        }
        System.out.println(cnt);
    }
}