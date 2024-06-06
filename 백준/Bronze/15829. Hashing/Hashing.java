import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            long c = (long) (chars[i] - 96);
            sum += (long) (c * Math.pow(31, i));
        }

        sum %= 1234567891L;

        bw.write(sum +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

