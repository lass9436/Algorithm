import java.io.*;
import java.util.*;

public class Main{
    
    public static int N, M, answer;
    public static int[][] map;
    public static List<int[]> virus = new ArrayList<>();
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dx = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int num = map[i][j];
                if(num == 2){
                    virus.add(new int[]{i, j});
                }
            }
        }
        
        dfs(0, 0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int ci, int cj, int count) {
        if(count == 3){
            bfs();
            return;
        }
        for(int j=cj; j<M; j++){
            int num = map[ci][j];
            if(num != 0) continue;
            map[ci][j] = 1;
            dfs(ci, j, count+1);
            map[ci][j] = 0;
        }
        for(int i=ci+1; i<N; i++){
            for(int j=0; j<M; j++){
                int num = map[i][j];
                if(num != 0) continue;
                map[i][j] = 1;
                dfs(i, j, count+1);
                map[i][j] = 0;
            }
        }
    }
    
    public static void bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = map[i][j];
            }
        }
        
        for(int[] v : virus){
            queue.offer(v);
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            copy[y][x] = 2;
            
            for(int k=0; k<4; k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(copy[ny][nx] != 0) continue;
                if(visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }
        
        int result = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 0){
                    result++;
                }
            }
        }
        
        answer = Math.max(answer, result);
    }
}