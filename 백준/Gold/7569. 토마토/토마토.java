import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 7569 토마토
 * 3 차원 토마토이다.
 * while 한 번에 count 로 day 를 표시하면 될 것 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int H = Integer.parseInt(init.nextToken());

        int[][][] box = new int[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        int[] dh = {1, -1, 0, 0, 0, 0};
        int[] dm = {0, 0, 1, -1, 0, 0};
        int[] dn = {0, 0, 0, 0, 1, -1};

        Queue<int[]> queue = new ArrayDeque<>();

        boolean alreadyRipe = true;
        for (int i=0; i<H; i++){
            for (int j=0; j<M; j++){
                for (int k=0; k<N; k++){
                    if (box[i][j][k] == 1) queue.offer(new int[]{i, j, k});
                    if (box[i][j][k] == 0) alreadyRipe = false;
                }
            }
        }

        int count = -1;
        if (alreadyRipe) {bw.write("0\n");}
        else {
            boolean[][][] visited = new boolean[H][M][N];
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    for (int k=0; k<6; k++){
                        int next_h = cur[0] + dh[k];
                        int next_m = cur[1] + dm[k];
                        int next_n = cur[2] + dn[k];
                        if (0 <= next_h && next_h < H && 0 <= next_m && next_m < M && 0 <= next_n && next_n < N && !visited[next_h][next_m][next_n]) {
                            visited[next_h][next_m][next_n] = true;
                            int tomato = box[next_h][next_m][next_n];
                            if (tomato == 0) {
                                box[next_h][next_m][next_n] = 1;
                                queue.offer(new int[]{next_h, next_m, next_n});
                            }
                        }
                    }
                }
            }

            boolean isAllRipe = true;
            for (int i=0; i<H; i++){
                for (int j=0; j<M; j++){
                    for (int k=0; k<N; k++){
                        if (box[i][j][k] == 0) isAllRipe = false;
                    }
                }
            }

            if (isAllRipe) bw.write(count + "\n");
            else bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

