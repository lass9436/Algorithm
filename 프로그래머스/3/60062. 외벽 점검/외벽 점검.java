class Solution {
    
    public int answer = Integer.MAX_VALUE;
    public int[] weak_flat;
    public int[] distance;
    
    public int solution(int n, int[] weak, int[] dist) {
        distance = dist;
        
        weak_flat = new int[weak.length * 2];
        for(int i=0; i<weak.length; i++){
            weak_flat[i] = weak[i];
            weak_flat[i + weak.length] = weak[i] + n;
        }
        
        boolean[] visited = new boolean[dist.length];
        int[] permuted = new int[dist.length];
        
        dfs(0, visited, permuted);
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    public void dfs(int count, boolean[] visited, int[] permuted){
        if(count == permuted.length){
            check(permuted);
            return;
        }
        
        for(int i=0; i<permuted.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permuted[count] = distance[i];
            dfs(count+1, visited, permuted);
            visited[i] = false;
        }
    }
    
    public void check(int[] permuted){      
        // weak 포인트를 이동하면서 탐색
        for(int i=0; i<weak_flat.length/2; i++){
            
            int count = 0;
            
            // 직원 for 를 돌리는 동안 index를 이동시켜야함.
            int index = i;
            
            // 순열을 전부 돌면서 필요한 직원 수를 체크해야함
            for(int j=0; j<permuted.length; j++){
                // j 번째 직원이 어디까지의 weak 포인트를 커버했는지 알아야하는데
                // 그것을 index 로 나타낼 것임.
                
                // j 번째 직원의 시작 위치 포지션
                int position = weak_flat[index];
                
                // index 가 weak_flat 을 넘어가면 안 됨 (레인지를 넘어가서 의미가 없음)
                // 해당 weak point index 에 해당하는 거리가 j 번째 직원의 시작 포인트에서 distance 를 더한 것보다 같거나 작다면
                // 해당 index weak point 는 커버할 수 있다는 의미이므로,
                // while 문으로 커버할 수 있는 만큼 index 를 늘려서 표시한다.
                while(index < weak_flat.length && weak_flat[index] <= position + permuted[j]){
                    // 다음 index 의 weak point 를 확인해야하므로 index++
                    index++;
                    // 하나의 weak point 를 처리했으므로 count++
                    count++;
                }
                
                // 한 바퀴를 넘을 수 있으므로 count가 weak 의 갯수 보다 많을 수 있음.
                // weak 의 갯수보다 커버한 count 가 같거나 크다면 해당 j 까지의 직원으로 모든 약점 포인트를 커버했다는 뜻임.
                if(count >= weak_flat.length/2){
                    // answer 와 j+1 (0 start index 이므로 1을 추가함) 직원 수 중에 작은 것을 answer 로 함.
                    answer = Math.min(answer, j+1);
                    
                    // 모두 커버하였으므로 이 permuted 를 더 탐색할 필요가 없으므로 break
                    break;
                }
                
            }
            
        }
    }
}