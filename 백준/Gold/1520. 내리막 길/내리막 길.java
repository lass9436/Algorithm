import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1520 내리막 길
 *
 * 기본적으로 이런 루트 경우의 수 문제는 waterfall 느낌으로 오른쪽 또는 아래로만 이동하는 문제가 많아서,
 * 2중 for 문 dp += dp ... 같은 식으로 계산할 수 있는데,
 * 방향이 4방향이므로 우하향식으로 계산할 수 없다.
 * dfs 를 활용하여 dp가 이미 계산되어있으면 dp를 리턴하고, 계산이 되어있지 않으면 dfs 를 통해 초기화한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        dn = new int[]{0, 0, -1, 1};
        dm = new int[]{1, -1, 0, 0};
        map = new int[N][M];
        for (int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 1;
        dp[N-1][M-1] = dfs(N-1, M-1);

        bw.write(dp[N - 1][M - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int N, M;
    public static int[] dn, dm;
    public static int[][] dp, map;
    public static int dfs(int i, int j) {
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int height = map[i][j];
        int sum = 0;
        for (int k = 0; k < 4; k++) {
            int nn = i + dn[k];
            int nm = j + dm[k];
            if (nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
            int nh = map[nn][nm];
            if (nh > height){
                sum += dfs(nn, nm);
            }
        }
        dp[i][j] = sum;
        return dp[i][j];
    }
}