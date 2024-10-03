import java.io.*;
import java.util.*;

public class Main{
    
    public static int N;
    public static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        int[][][] dp = new int[N][N][3];
        
        dp[0][1][0] = 1;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(check(i, j+1, 0)) dp[i][j+1][0] += dp[i][j][0];
                if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][0];
                
                if(check(i, j+1, 0)) dp[i][j+1][0] += dp[i][j][1];
                if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][1];
                if(check(i+1, j, 2)) dp[i+1][j][2] += dp[i][j][1];
                
                if(check(i+1, j+1, 1)) dp[i+1][j+1][1] += dp[i][j][2];
                if(check(i+1, j, 2)) dp[i+1][j][2] += dp[i][j][2];
            }
        }

        long answer = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean check(int i, int j, int di){
        if(i < 0 || i >= N || j < 0 || j >= N) return false;
        if(di == 0) return map[i][j] == 0;
        if (di == 1) return map[i][j] == 0 && map[i-1][j] == 0 && map[i][j-1] == 0;
        else return map[i][j] == 0;
    }
}
