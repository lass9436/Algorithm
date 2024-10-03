import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long answer = 0;
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        boolean[] visited = new boolean[100004];
        
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int left = 0;
        int right = 0;
        while(left <= right && right < N){
            if(!visited[arr[right]]){
                visited[arr[right++]] = true;
            }else{
                answer += right - left;
                visited[arr[left++]] = false;
            }
        }
        
        answer += (long) (right - left) * (right - left + 1) / 2;
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

