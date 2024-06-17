import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BOJ 13305 주유소
 *
 * 실버인데 문제가 왜이리 어려운 것 같지?
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int i=0; i<N-1; i++){
            int[] cost = new int[]{i, costs[i]};
            pq.offer(cost);
        }
        long[] sumDistances = new long[N];
        sumDistances[0] = 0;
        for(int i=1; i<N; i++){
            sumDistances[i] += sumDistances[i-1] + distances[i-1];
        }
        int lastIndex = 0;
        long total = sumDistances[N-1];
        long answer = 0;
        boolean first = true;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int index = cur[0];
            int cost = cur[1];
            if (!first && lastIndex < index) continue;
            long remainLiter = first ? total - sumDistances[index] : sumDistances[lastIndex] - sumDistances[index];
            answer += cost * remainLiter;
            lastIndex = index;
            first = false;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N;
    public static int[] distances, costs;
}

