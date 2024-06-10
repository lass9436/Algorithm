import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        List<int[]>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            int[] visited = new int[N+1];

            queue.offer(new int[]{start, 0});
            visited[start] = -1;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for(int[] next : adj[cur[0]]) {
                    if (visited[next[0]] != 0) continue;
                    visited[next[0]] = cur[1] + next[1];
                    queue.offer(new int[]{next[0], cur[1] + next[1]});
                }
            }
            bw.write(visited[end] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

