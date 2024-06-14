import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 1;
        int N = 0;

        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        while((N = Integer.parseInt(br.readLine())) != 0){
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] visited = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
            visited[0][0] = map[0][0];
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            pq.offer(new int[]{0, 0, map[0][0]});
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int y = cur[0];
                int x = cur[1];
                int rupee = cur[2];
                if (visited[y][x] < rupee) continue;
                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    int nRupee = map[ny][nx] + rupee;
                    if (visited[ny][nx] <= nRupee) continue;
                    visited[ny][nx] = nRupee;
                    pq.offer(new int[]{ny, nx, nRupee});
                }
            }
            bw.write("Problem " + T++ + ": " + visited[N - 1][N - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

