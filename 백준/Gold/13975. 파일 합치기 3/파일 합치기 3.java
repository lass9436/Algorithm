import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 13975 파일합치기
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            long[] cards = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(long card : cards) pq.offer(card);
            long sum = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                sum += a + b;
                pq.offer(a + b);
            }
            bw.write(sum+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

