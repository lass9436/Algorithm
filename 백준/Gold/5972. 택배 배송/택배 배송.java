import java.io.*;
import java.util.*;

/**
 * BOJ 5972 택배 배송
 * 
 * 순수 다익스트라 문제인 것 같다
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int M = init[1];
        List<int[]>[] adj = new List[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<=M; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adj[line[0]].add(new int[]{line[1], line[2]});
            adj[line[1]].add(new int[]{line[0], line[2]});
        }
        int[] visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        visited[1] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]] < cur[1]) continue;
            for (int[] next : adj[cur[0]]){
                int nextNode = next[0];
                int nextDistance = next[1] + cur[1];
                if(visited[nextNode] <= nextDistance) continue;
                visited[nextNode] = nextDistance;
                pq.offer(new int[]{nextNode, nextDistance});
            }
        }

        bw.write(visited[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

