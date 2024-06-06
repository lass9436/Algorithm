import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        long mod = 1234567891L;
        long sum = 0L;
        long r = 1L;
        for (int i = 0; i < N; i++) {
            long c = (long) (chars[i] - 96);
            sum += (long) (c * r) % mod;
            r *= 31;
            r %= mod;
        }

        sum %= mod;

        bw.write(sum +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

