import java.io.*;
import java.util.*;

/**
 * BOJ 21937 작업
 * 역방향 BFS 로 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        List<Integer>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 역방향
            adj[v].add(u);
        }

        int K = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(K);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]){
                if(visited[next]) continue;
                visited[next] = true;
                queue.offer(next);
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++){
            if(visited[i]) sum++;
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

