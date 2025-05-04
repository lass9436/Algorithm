import java.util.*;

class Solution {
    
    public int height = 0;
    public int length = 0;
    
    public int[] dy = {0, 0, 1, -1};
    public int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        
        height = board.length;
        length = board[0].length;
        
        return dfs(board, aloc, bloc, true);
    }
    
    public int dfs(int[][] board, int[] aloc, int[] bloc, boolean turn){
        int cy = turn ? aloc[0] : bloc[0];
        int cx = turn ? aloc[1] : bloc[1];
        
        // 발판이 사라져서 패배했다면 0 을 리턴
        // 이 0은 움직이지 않았다. 턴을 사용하지 못해서 0 턴을 썼다는 수학적 의미가 있음.
        // 따라서 재귀로 타고 올라갈 때, 0턴으로 계산한다는 의미가 있음.
        if(board[cy][cx] == 0){
            return 0;
        }
        
        // 다음으로 갈 수 있는지 체크
        boolean possible = false;
        
        // 결과값
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for(int k=0; k<4; k++){
            int ny = cy + dy[k];
            int nx = cx + dx[k];
            
            if(outOfBound(board, ny, nx)) continue;
            
            possible = true;
            
            board[cy][cx] = 0;
            
            int temp = 0;
            
            if(turn) temp = dfs(board, new int[]{ny, nx}, bloc, !turn) + 1;
            else temp = dfs(board, aloc, new int[]{ny, nx}, !turn) + 1;
            
            // temp 가 홀수면 현재 플레이어의 승리를 의미함.
            // 승리면 최소 턴을 갱신하고
            if(temp % 2 == 1){
                min = Math.min(min, temp);
            // 패배면 최대 턴을 갱신한다.
            }else{
                max = Math.max(max, temp);
            }
            
            board[cy][cx] = 1;
        }
        
        // 아무데도 갈 수 없었다면 0을 반환
        if(!possible){
            return 0;
        }
        
        // 이긴 경우의 수가 있다면 이긴 경우 중에서 최솟값을,
        // 한 번도 이기지 못했다면, 진 경우의 수 중에서 최댓값을 리턴
        return min != Integer.MAX_VALUE ? min : max;
    }
    
    // outOfBound 현재 타일이 비어있거나, board 밖으로 나갈 경우 true 를 리턴하여
    // outOfBound 를 표시
    public boolean outOfBound(int[][] board, int ny, int nx){
        if(ny < 0 || ny >= height || nx < 0 || nx >= length) return true;
        if(board[ny][nx] == 0) return true;
        return false;
    }
}