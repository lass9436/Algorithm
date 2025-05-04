import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 노드의 번호 기준이므로 n+1, 노드는 1번부터 시작한다.
        List<Integer>[] adj = new List[n+1];
        for(int i=0; i<n+1; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++){
            adj[roads[i][0]].add(roads[i][1]);
            adj[roads[i][1]].add(roads[i][0]);
        }
        
        // 노드의 번호 기준이므로 n+1, 노드는 1번부터 시작한다.
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        
        pq.offer(new int[]{destination, 0});
        //dis[destination] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // 노드 번호
            int cur_node = cur[0];
            // 지금까지의 거리
            int cur_dis = cur[1];
            
            if(dis[cur_node] <= cur_dis) continue;
            dis[cur_node] = cur_dis;
            
            for(int next_node : adj[cur_node]){
                // 이 문제에서는 거리가 없으므로 1로 처리
                // 만약 거리가 있으면 adj 에 Integer 가 아니라 int[] 로 넣어서
                // 0 번째 원소는 노드 번호, 1 번째 원소는 거리로 넣어야함.
                int next_dis = cur_dis + 1;
                
                // 다음 노드를 더 빠르게 간 적이 있으면 스킵
                //if(dis[next_node] <= next_dis) continue;
                //dis[next_node] = next_dis;
                pq.offer(new int[]{next_node, next_dis});
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            int distance = dis[sources[i]];
            if(distance == Integer.MAX_VALUE){
                answer[i] = -1;
            }else{
                answer[i] = distance;
            }
        }
        
        return answer;
    }
}