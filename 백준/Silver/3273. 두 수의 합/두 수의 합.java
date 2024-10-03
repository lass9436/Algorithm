import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int X = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = N-1;
        
        long answer = 0;
        
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum < X){
                left++;
            }else if(sum == X){
                answer++;
                left++;
                right--;
            }else{
                right--;
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

