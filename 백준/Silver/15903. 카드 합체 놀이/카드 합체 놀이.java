import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pq.offer(Long.parseLong(st.nextToken()));
        for (int i = 0; i < M; i++) {
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);
        }
        long sum = 0L;
        while (!pq.isEmpty()) sum += pq.poll();
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

