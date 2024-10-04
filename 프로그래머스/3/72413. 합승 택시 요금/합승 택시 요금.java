import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        List<int[]>[] adj = new List[n+1];
        for(int i=0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] node : fares){
            int u = node[0];
            int v = node[1];
            int w = node[2];
            
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        
        for(int i=1; i<=n; i++){
            int[] visited = dijkstra(i, n, adj);
            int s_d = visited[s];
            int a_d = visited[a];
            int b_d = visited[b];
            answer = Math.min(answer, s_d + a_d + b_d);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int start, int size, List<int[]>[] adj){
        int[] visited = new int[size+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]] < cur[1]) continue;
            for(int[] node : adj[cur[0]]){
                int distance = cur[1] + node[1];
                if(visited[node[0]] <= distance) continue;
                visited[node[0]] = distance;
                pq.offer(new int[]{node[0], distance});
            }
        }
        
        return visited;
    }
    
}