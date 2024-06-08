import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11561 징검다리
 * 18828 KB 232 ms
 * 1차적으로 밟을 돌 mid 가 있으면 1 + 2 + ... + mid <= N 일 때
 * 가능하고 mid 개를 밟을 수 있다.
 * 2차적으로 mid 를 처음부터 다 더하면 시간이 초과가 난다. (오버플로우 로직을 중간에 넣을 수 있으나 시간초과)
 * 3차적으로 mid * (mid + 1) / 2 를 하여 합을 구하면 sum 값 자체가 오버플로우가 날 수 있다.
 * 그래서 sum 이 음수이면 overflow 나서 false 라고 했다. 근데 이것도 엄밀하진 않은게 10^16 * 10^16 이면,
 * 오버플로우를 그냥 몇바퀴를 돌아버린다. 근데 일단은 통과했다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            long start = 0L;
            long end = (long) Math.sqrt(10*N);
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
        return sum <= N;
    }
}

