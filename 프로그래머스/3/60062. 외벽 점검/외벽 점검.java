import java.util.*;

class Solution {
    
    public int[] weak_flat;
    public boolean[] visited;
    public int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        weak_flat = new int[weak.length * 2];
        
        for(int i=0; i<weak.length; i++){
            weak_flat[i] = weak[i];
            weak_flat[i + weak.length] = weak[i] + n;
        }
        
        visited = new boolean[dist.length];
        
        dfs(0, dist, new int[dist.length]);
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    public void dfs(int count, int[] dist, int[] permuted){
        if(count == dist.length){
            check(permuted);
            return;
        }
        
        for(int i=0; i<dist.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permuted[count] = dist[i];
            dfs(count + 1, dist, permuted);
            visited[i] = false;
        }
    }
    
    public void check(int[] permuted){
        int len = weak_flat.length / 2;
        for(int i=0; i<len; i++){
            int weak_index = i;
            int list_count = 0;
            int weak_count = 0;
            for(int j=0; j<permuted.length; j++){
                list_count++;
                int position = weak_flat[weak_index] + permuted[j];
                while(weak_index < weak_flat.length && weak_flat[weak_index] <= position){
                    weak_count++;
                    weak_index++;
                }
                if(weak_count >= len){
                    answer = Math.min(answer, list_count);
                    break;
                }
                if(weak_index >= weak_flat.length){
                    break;
                }
            }
        }
    }
}