import java.io.*;
import java.util.Arrays;

/**
 * BOJ 2212 센서
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sensors);
        int[] distances = new int[N-1];
        for (int i = 0; i < N-1; i++) distances[i] = sensors[i+1] - sensors[i];
        Arrays.sort(distances);
        long answer = 0;
        for (int i=0; i<N-K; i++) answer += distances[i];
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

