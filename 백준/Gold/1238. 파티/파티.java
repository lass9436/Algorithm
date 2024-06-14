import java.io.*;
import java.util.*;

/**
 * BOJ 1238 파티
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int M = init[1];
        int K = init[2];
        List<int[]>[] adj = new List[N+1];
        List<int[]>[] adjReverse = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++) adjReverse[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[line[0]].add(new int[]{line[1], line[2]});
            adjReverse[line[1]].add(new int[]{line[0], line[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        int[] visitedReverse = new int[N+1];
        Arrays.fill(visitedReverse, Integer.MAX_VALUE);
        visited[K] = 0;
        visitedReverse[K] = 0;
        pq.offer(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]] < cur[1]) continue;
            for (int[] next : adj[cur[0]]){
                int nextNode = next[0];
                int nextDistance = next[1] + cur[1];
                if (nextDistance >= visited[nextNode]) continue;
                visited[nextNode] = nextDistance;
                pq.offer(new int[]{nextNode, nextDistance});
            }
        }
        pq.offer(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visitedReverse[cur[0]] < cur[1]) continue;
            for (int[] next : adjReverse[cur[0]]){
                int nextNode = next[0];
                int nextDistance = next[1] + cur[1];
                if (nextDistance >= visitedReverse[nextNode]) continue;
                visitedReverse[nextNode] = nextDistance;
                pq.offer(new int[]{nextNode, nextDistance});
            }
        }

        int answer = 0;
        for (int i=1; i<=N; i++){
            answer = Math.max(answer, visited[i] + visitedReverse[i]);
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

