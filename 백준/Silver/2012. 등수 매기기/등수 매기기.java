import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 2012 등수 매기기
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int rank = Integer.parseInt(br.readLine());
            pq.add(rank);
        }
        long answer = 0;
        for (int i = 1; i <= N; i++) {
            int rank = pq.poll();
            int diff = Math.abs(i - rank);
            answer += diff;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

