import java.io.*;
import java.util.Arrays;

/**
 * BOJ 2293 동전1
 *
 * 대표적인 스냅백 문제이다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int K = init[1];
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
        int[] snapBack = new int[K+1];
        snapBack[0] = 0;
        int coin = coins[0];
        for (int i = 0; i <= K; i+= coin) {
            snapBack[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            coin = coins[i];
            for (int j = coin; j <= K; j++) {
                snapBack[j] += snapBack[j-coin];
            }
        }

        bw.write(snapBack[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

