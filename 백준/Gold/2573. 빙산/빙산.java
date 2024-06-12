import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 2573 빙산
 * 
 * 녹는 거하고 체크하는 걸 분리해서 구현했다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int mass = check();
        while(mass == 1){
            answer++;
            melt();
            mass = check();
        }

        if(mass == 0) bw.write("0\n");
        else bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, answer = 0;
    public static int[] dn = {0, 0, 1, -1}, dm = {1, -1, 0, 0};
    public static int[][] map;

    public static int check(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int height = map[i][j];
                if (height == 0) continue;
                if (visited[i][j]) continue;
                count++;
                visited[i][j] = true;
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nn = cur[0] + dn[k];
                        int nm = cur[1] + dm[k];
                        if (nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
                        if (visited[nn][nm]) continue;
                        if (map[nn][nm] == 0) continue;
                        visited[nn][nm] = true;
                        queue.offer(new int[]{nn, nm});
                    }
                }
            }
        }
        return count;
    }

    public static void melt(){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int height = map[i][j];
                if (height == 0) continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nn = i + dn[k];
                    int nm = j + dm[k];
                    if(map[nn][nm] == 0) count++;
                }
                queue.add(new int[]{i, j, count});
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int height = Math.max(map[cur[0]][cur[1]] - cur[2], 0);
            map[cur[0]][cur[1]] = height;
        }
    }
}

