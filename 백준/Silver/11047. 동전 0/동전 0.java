import java.io.*;
import java.util.Arrays;

/**
 * BOJ 11047 동전 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int K = init[1];
        int[] coins = new int[N];
        for (int i=0; i<N; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        int answer = 0;
        for (int i=N-1; i>=0; i--){
            if(K == 0) break;
            int coin = coins[i];
            int quo = K/coin;
            int mod = K%coin;
            answer += quo;
            K = mod;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

