import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1417 국회의원 선거
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Vote> pq = new PriorityQueue<>((a, b) -> b.vote - a.vote);
        Vote me = new Vote(0, Integer.parseInt(br.readLine()));
        for (int i = 1; i < N; i++) {
            int vote = Integer.parseInt(br.readLine());
            pq.offer(new Vote(i, vote));
        }
        int answer = 0;
        while(!pq.isEmpty() && me.vote <= pq.peek().vote){
            Vote other = pq.poll();
            other.vote--;
            me.vote++;
            answer++;
            pq.offer(other);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Vote{
        public int index;
        public int vote;
        public Vote(int index, int vote) {
            this.index = index;
            this.vote = vote;
        }
    }
}

