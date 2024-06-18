import java.io.*;
import java.util.Arrays;

/**
 * BOJ 9465 스티커
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            for (int i = 0; i < 2; i++) stickers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] dp = new int[2][N];
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if (1 < N) {
                dp[0][1] = stickers[0][1] + stickers[1][0];
                dp[1][1] = stickers[1][1] + stickers[0][0];
                if (2 < N) {
                    for (int i = 2; i < N; i++) {
                        dp[0][i] = stickers[0][i] + Math.max(dp[1][i - 1], Math.max(dp[0][i - 2], dp[1][i - 2]));
                        dp[1][i] = stickers[1][i] + Math.max(dp[0][i - 1], Math.max(dp[0][i - 2], dp[1][i - 2]));
                    }
                }
            }
            bw.write(Math.max(dp[0][N-1], dp[1][N-1]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

