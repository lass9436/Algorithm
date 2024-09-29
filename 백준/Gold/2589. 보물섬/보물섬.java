import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        int answer = 0;
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int M = init[1];
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                char c = map[i][j];
                if(c == 'W') continue;
                queue.offer(new int[]{i, j, 0});
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int y = cur[0];
                    int x = cur[1];
                    int count = cur[2];
                    
                    answer = Math.max(answer, count);
                    
                    for(int k=0; k<4; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                        if(map[ny][nx] == 'W') continue;
                        if(visited[ny][nx]) continue;
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx, count+1});
                    }
                }
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}