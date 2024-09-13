import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        
        List<Integer>[] adj = new List[n+1];
        for(int i=1; i<n+1; i++){
            adj[i] = new ArrayList<>();
            adj[i].add(i);
        }
        for(int i=0; i<edge_list.length; i++){
            int u = edge_list[i][0];
            int v = edge_list[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[][] dp = new int[k][n+1];
        for(int i=0; i<k; i++){
            for(int j=0; j<n+1; j++){
                dp[i][j] = Integer.MAX_VALUE;    
            }
        }
        dp[0][gps_log[0]] = 0;
        
        for(int i=0; i<k-1; i++){
            for(int j=1; j<n+1; j++){
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                for(int l=0; l<adj[j].size(); l++){
                    int next = adj[j].get(l);
                    int diff = 0;
                    if(gps_log[i+1] != next) diff = 1;
                    dp[i+1][next] = Math.min(dp[i+1][next], dp[i][j] + diff);
                }
            }
        }
        
        return dp[k-1][gps_log[k-1]] == Integer.MAX_VALUE ? -1 : dp[k-1][gps_log[k-1]];
    }
}