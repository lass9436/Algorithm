import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static int[] dy = new int[]{0, 1, -1, 0};
    public static int[] dx = new int[]{1, 0, 0, -1};

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            test();
        }

    }

    public static void test() throws IOException {
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = init[0];
        int M = init[1];
        int B = init[2];

        int answer = 0;

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<B; i++){
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int y = pos[0];
            int x = pos[1];

            map[y][x] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) continue;
                if(visited[i][j]) continue;

                bfs(i, j, map, visited);
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int y, int x, int[][] map, boolean[][] visited) {
        int N = map.length;
        int M = map[0].length;


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_y = cur[0];
            int cur_x = cur[1];

            for(int k=0; k<4; k++){
                int next_y = cur_y + dy[k];
                int next_x = cur_x + dx[k];

                if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= M) continue;
                if(map[next_y][next_x] == 0) continue;
                if(visited[next_y][next_x]) continue;

                visited[next_y][next_x] = true;
                queue.offer(new int[]{next_y, next_x});
            }
        }

    }
}