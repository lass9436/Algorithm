class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] diff = new int[n+1][m+1];
        
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if(type == 1){
                degree = -degree;
            }
            
            diff[r1][c1] += degree;
            diff[r1][c2+1] -= degree;
            diff[r2+1][c1] -= degree;
            diff[r2+1][c2+1] += degree;
        }
        
        for(int i=1; i<diff.length; i++){
            for(int j=0; j<diff[0].length; j++){
                diff[i][j] += diff[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            int acc = 0;
            for(int j=0; j<board[0].length; j++){
                acc += diff[i][j];
                board[i][j] += acc;
                
                if(board[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}