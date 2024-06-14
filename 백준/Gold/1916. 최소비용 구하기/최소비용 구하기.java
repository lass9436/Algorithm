import java.io.*;
import java.util.*;

/**
 * BOJ 최소비용 구하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[line[0]].add(new int[]{line[1], line[2]});
        }
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = target[0];
        int end = target[1];
        long[] visited = new long[N+1];
        Arrays.fill(visited, Long.MAX_VALUE);
        visited[start] = 0;
        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        queue.offer(new long[]{start, 0});
        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            if (visited[(int) cur[0]] < cur[1]) continue;
            for (int[] next : adj[(int) cur[0]]) {
                long nextNode = next[0];
                long nextDistance = next[1] + cur[1];
                if (visited[(int) nextNode] <= nextDistance) continue;
                visited[(int) nextNode] = nextDistance;
                queue.offer(new long[]{nextNode, nextDistance});
            }
        }

        bw.write(visited[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

