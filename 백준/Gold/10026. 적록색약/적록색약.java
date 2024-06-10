import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 10026 적록색약
 * 조건에 맞춰서 구역 탐색을 두 번 하면 될 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int normalCount = 0;
        boolean[][] visited = new boolean[N][N];

        int[] dy = {0, -1, 0, 1};
        int[] dx = {1, 0, -1, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                normalCount++;
                queue.offer(new int[]{i, j});
                char color = board[i][j];
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int next_y = cur[0] + dy[k];
                        int next_x = cur[1] + dx[k];
                        if(0 <= next_y && next_y < N && 0 <= next_x && next_x < N && !visited[next_y][next_x]) {
                            char next_color = board[next_y][next_x];
                            if (color != next_color) continue;
                            visited[next_y][next_x] = true;
                            queue.offer(new int[]{next_y, next_x});
                        }
                    }
                }
            }
        }

        queue = new ArrayDeque<>();
        visited = new boolean[N][N];
        int unNormalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                unNormalCount++;
                queue.offer(new int[]{i, j});
                char color = board[i][j];
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int next_y = cur[0] + dy[k];
                        int next_x = cur[1] + dx[k];
                        if(0 <= next_y && next_y < N && 0 <= next_x && next_x < N && !visited[next_y][next_x]) {
                            char next_color = board[next_y][next_x];
                            if ((color == 'R' && next_color == 'G') || (color == 'G' && next_color == 'R') || color == next_color){
                                visited[next_y][next_x] = true;
                                queue.offer(new int[]{next_y, next_x});
                            }
                        }
                    }
                }
            }
        }

        bw.write(normalCount + " " + unNormalCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
}

