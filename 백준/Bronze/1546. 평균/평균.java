import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 스트림을 이용해서 합을 구하고
 * 평균을 구했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;

        for (int i = 0; i < N; i++) max = Math.max(max, arr[i]);

        int sum = Arrays.stream(arr).sum();

        double answer = (double) sum / max / N * 100;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

