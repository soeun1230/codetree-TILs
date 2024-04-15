import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            for(int j=s;j<=t;j++){
                if(hm.containsKey(j)){
                    hm.put(j,hm.get(j)+b);
                }
                else{
                    hm.put(j,b);
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>(hm.keySet());

        Collections.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return hm.get(o2)-hm.get(o1);
            }
        });

        System.out.print(hm.get(arr.get(0)));
    }
}