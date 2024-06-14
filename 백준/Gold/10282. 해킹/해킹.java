import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = init[0];
            int d = init[1];
            int c = init[2];

            List<int[]>[] adj = new List[n+1];
            for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
            for (int i=1; i<=d; i++) {
                int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adj[line[1]].add(new int[]{line[0], line[2]});
            }

            int[] visited = new int[n+1];
            Arrays.fill(visited, Integer.MAX_VALUE);
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{c, 0});
            visited[c] = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (visited[cur[0]] < cur[1]) continue;
                for (int[] next : adj[cur[0]]) {
                    int nextNode = next[0];
                    int nextTime = cur[1] + next[1];
                    if (visited[nextNode] <= nextTime) continue;
                    visited[nextNode] = nextTime;
                    queue.offer(new int[]{nextNode, nextTime});
                }
            }
            int lastTime = 0;
            int count = 0;
            for (int time : visited){
                if(time != Integer.MAX_VALUE){
                    count++;
                    lastTime = Math.max(lastTime, time);
                }
            }
            bw.write(count + " " + lastTime + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

