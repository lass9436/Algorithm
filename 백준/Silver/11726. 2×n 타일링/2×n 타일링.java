import java.io.*;

/**
 * BOJ 11726 2*N 타일링
 *
 * n = 1 -> 1
 * n = 2 -> 2
 * n = 3 -> 3
 * n = 4 -> 5
 * n = 5 -> 8 ?
 * 이유는 잘 모르겠는데
 * dp(n) = dp(n-1) + dp(n-2) 인 것 같다.
 * dp(n-2) 의 경우의 수와 dp(n-1) 의 경우의 수가 하나가 겹치고,
 * dp(n-2) 의 경우의 수 * 2 를 해야하니
 * dp(n) = dp(n-1) * 1 + dp(n-2) * (2 - 1) 이므로
 * 결국 정리하면
 * dp(n) = dp(n-1) + dp(n-2) 이다.
 * 그리고 출력에서 10007 로 나눈 나머지로 출력해야하는데 못보고 틀렸다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        bw.write(dp[N]%10007 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

