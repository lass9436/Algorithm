import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1715 카드 정렬하기
 * 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)  pq.offer(Integer.parseInt(br.readLine()));
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += a + b;
            pq.offer(a + b);
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

