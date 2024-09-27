import java.io.*;
import java.util.*;

public class Main{
    
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] init = br.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        int M = Integer.parseInt(init[1]);
       
        int[][] map = new int[N][M];
        
        boolean[][] visited = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }
        
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            int y = cur[0];
            int x = cur[1];
            int d = cur[2];
            
            if(y == N-1 && x == M-1){
                answer = d;
                break;
            }
            
            for(int k=0; k<4; k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx, d+1});
            }
        }
        
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}