import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 중량제한
 * 
 * dfs -> 단순 boolean visited -> 시간초과
 * dfs -> 최대 거리(중량) 갱신 visited -> 시간초과
 * bfs -> 최대 거리(중량) 갱신 visited
 */
public class Main {

    public static List<int[]>[] adj;
    public static int[] visited;
    public static int answer = 0;
    public static int start;
    public static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        adj = new List[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        visited = new int[N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        StringTokenizer pos = new StringTokenizer(br.readLine());
        start = Integer.parseInt(pos.nextToken());
        end = Integer.parseInt(pos.nextToken());


        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, Integer.MAX_VALUE});
        visited[start] = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == end){
                answer = Math.max(cur[1], answer);
                continue;
            }
            if(cur[1] < visited[cur[0]]) continue;
            for(int[] next : adj[cur[0]]){
                int next_node = next[0];
                int next_weight = Math.min(next[1], cur[1]);
                if(next_weight <= visited[next_node]) continue;
                visited[next_node] = next_weight;
                queue.offer(new int[]{next_node, next_weight});
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }



}

