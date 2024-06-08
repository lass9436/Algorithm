import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11561 징검다리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            long start = 0L;
            long end = N;
            long answer = 0L;
            while (start <= end) {
                long mid = start + (end - start) / 2;
                if (isPossible(mid, N)){
                    answer = Math.max(answer, mid);
                    start = mid + 1;
                }else end = mid - 1;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPossible(long mid, long N) {
        long sum = mid * (mid + 1) / 2;
        if (sum < 0) return false;
        return sum <= N;
    }
}

