import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<int[]>[] adj = new List[n+1];
        for(int i=0; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<fares.length; i++){
            adj[fares[i][0]].add(new int[]{fares[i][1], fares[i][2]});
            adj[fares[i][1]].add(new int[]{fares[i][0], fares[i][2]});
        }
        
        int[] fromS = dijkstra(s, n, adj);
        int[] fromA = dijkstra(a, n, adj);
        int[] fromB = dijkstra(b, n, adj);
        
        for(int i=1; i<n+1; i++){
            answer = Math.min(answer, fromS[i] + fromA[i] + fromB[i]);
        }
        
        return answer;
    }
    
    public int[] dijkstra(int i, int n, List<int[]>[] adj){
        int[] dis = new int[n+1];
        Arrays.fill(dis, 200000000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        pq.offer(new int[]{i, 0});
        dis[i] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int cur_dis = cur[1];
            
            for(int[] next : adj[cur_node]){
                int next_node = next[0];
                int next_dis = next[1] + cur_dis;
                if(dis[next_node] <= next_dis) continue;
                dis[next_node] = next_dis;
                pq.offer(new int[]{next_node, next_dis});
            }
        }
        
        return dis;
    }
}