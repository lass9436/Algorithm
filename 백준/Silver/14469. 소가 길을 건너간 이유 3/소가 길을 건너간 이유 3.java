import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int time = 0;
        
        for(int[] a : arr){
            int arrival = a[0];
            int spend = a[1];
            
            if(time < arrival){
                time = arrival + spend;
            }else{
                time += spend;
            }
        }
        
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}