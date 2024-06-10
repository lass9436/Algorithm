import java.io.*;
import java.util.*;

/**
 * BOJ 2606 바이러스
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : adj[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }

        int sum = 0;
        for(boolean b : visited) sum += b ? 1 : 0;

        bw.write(sum-1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

