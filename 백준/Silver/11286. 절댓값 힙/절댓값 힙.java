import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return (int)(a - b);
            return (int)(Math.abs(a) - Math.abs(b));
        });
        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) {
                if(pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll() + "\n");
            } else{
                pq.offer(n);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

