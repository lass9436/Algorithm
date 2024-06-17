import java.io.*;

/**
 * BOJ 2156 포도주 시식
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        for(int i=0; i<N; i++) wine[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        dp[0] = wine[0];
        if(1 < N){
            dp[1] = wine[1] + wine[0];
            if(2 < N){
                dp[2] = Math.max(Math.max(wine[0] + wine[1], wine[1] + wine[2]), wine[0] + wine[2]);
                if(3 < N){
                    for(int i=3; i<N; i++){
                        dp[i] = Math.max(Math.max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i]), dp[i-1]);
                    }
                }
            }
        }
        bw.write(dp[N-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

