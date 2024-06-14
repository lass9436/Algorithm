import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * BOJ 1261 알고스팟
 * 
 * 다익스트라 + 상하좌우 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = init[0];
        int N = init[1];
        char[][] chars = new char[N][M];
        for (int i = 0; i < N; i++) chars[i] = br.readLine().toCharArray();
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(chars[i][j] + "");
            }
        }
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
        visited[0][0] = map[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, map[0][0]});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int y = cur[0];
            int x = cur[1];
            int c = cur[2];
            if(visited[y][x] < c) continue;
            for(int k=0; k<4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                int nc = map[ny][nx] + c;
                if (visited[ny][nx] <= nc) continue;
                visited[ny][nx] = nc;
                pq.offer(new int[]{ny, nx, nc});
            }
        }
        bw.write(visited[N-1][M-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

