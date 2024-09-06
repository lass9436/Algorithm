class Solution {
    
    public int answer = -1;
    public int N, M;
    public int[][] current;
    public int[][] destination;
    
    public int solution(int[][] beginning, int[][] target) {
        N = target.length;
        M = target[0].length;
        current = beginning;
        destination = target;
        dfs(0, 0); 
        return answer;
    }
    
    public void dfs(int depth, int count){
        // 같은 지 체크
        if(check()){
            if(answer == -1) {
                answer = count;
            } else {
                answer = Math.min(answer, count);
            }
            return;
        }
        // 범위를 벗어남
        if(depth >= N+M){
            return;
        }
        dfs(depth+1, count);
        flip(depth);
        dfs(depth+1, count+1);
        flip(depth);
    }
    
    public void flip(int depth){
        // 깊이가 행의 길이보다 작으면 행을 뒤집는다.
        if(depth < N){
            for(int i=0; i<M; i++){
                current[depth][i] = 1 - current[depth][i];
            }
        // 깊이가 행의 길이보다 크면 열을 뒤집는다.
        }else{
            int col = depth - N;
            for(int i=0; i<N; i++){
                current[i][col] = 1 - current[i][col];
            }
        }
    }
    
    public boolean check(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(current[i][j] != destination[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}