import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static int N, M, max;
    
    public static int[] arr;
    
    public static int cal(int n){
        int result = 0;
        for(int i=0; i<M; i++){
            int prism = arr[i];
            int quo = prism / n;
            int rem = prism % n;
            result += quo;
            if(rem > 0) result += 1;
        }
        return result;
    }
    
    public static int binary(){
        int answer = max;
        int start = 1;
        int end = max;
        
        while(start <= end){
            int mid = (start + end) / 2;
            int result = cal(mid);
            if(result  > N){
                start = mid + 1;
            }else{
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 123456789;

        String[] st = br.readLine().split(" ");

        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        
        arr = new int[M];

        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        answer = binary();
        
        System.out.println(answer);

        return;
    }
}