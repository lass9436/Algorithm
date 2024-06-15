import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1149 RGB 거리
 *
 * 대표적인 2차원 dp 문제이다.
 * i 를 증가시키면서 현재 집과 겹치지 않는 선에서의 최소 비용을 구하면 된다.
 * dp[i][0] 은 i 번째 집에서 R 로 색칠했을 때의 최소 비용이다.
 * dp[i][1] 은 i 번째 집에서 G 로 색칠했을 때의 최소 비용이다.
 * dp[i][2] 은 i 번째 집에서 B 로 색칠했을 때의 최소 비용이다.
 * R 일 때는 이전 집이 G 또는 B 이면 되고,
 * G 일 때는 이전 집이 B 또는 R 이면 되고,
 * B 일 때는 이전 집이 R 또는 G 이면 되고,
 * 각 이전 집의 후보 중에서 최솟값을 가져오면 된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] dp = new int[N][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) answer = Math.min(answer, dp[N-1][i]);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

