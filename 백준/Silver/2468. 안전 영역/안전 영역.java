import java.io.*;
import java.util.*;

public class Main{
    
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dx = {1, -1, 0, 0};
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static int N;
    public static int[][] map;
    public static int answer;
    
    public static void main(String[] args) throws IOException {    
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        for(int i=0; i<=100; i++){
            test(i);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void test(int height){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] <= height) continue;
                if(visited[i][j]) continue;
                count++;
                visited[i][j] = true;
                queue.offer(new int[]{i, j});
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int y = cur[0];
                    int x = cur[1];
                    
                    for(int k=0; k<4; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        
                        if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                        if(visited[ny][nx]) continue;
                        if(map[ny][nx] <= height) continue;
                        
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        
        answer = Math.max(answer, count);
    }
}

