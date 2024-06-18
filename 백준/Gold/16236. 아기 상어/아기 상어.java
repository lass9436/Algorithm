import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BOJ 16236 아기상어
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int[] start = new int[3];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 9) {
                    start = new int[]{i, j, 0};
                    map[i][j] = 0;
                }
            }
        }

        int[] dn = {0, 0, -1, 1};
        int[] dm = {1, -1, 0, 0};

        int answer = 0;

        while(true){
            answer = start[2];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            List<int[]> foodList = new ArrayList<>();
            boolean[][] visited = new boolean[N][N];
            visited[start[0]][start[1]] = true;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for(int k=0; k<4; k++){
                    int nn = cur[0] + dn[k];
                    int nm = cur[1] + dm[k];
                    int nt = cur[2] + 1;
                    if(nn < 0 || nm < 0 || nn >= N || nm >= N || visited[nn][nm]) continue;
                    visited[nn][nm] = true;
                    if(map[nn][nm] > sharkSize) continue;
                    queue.offer(new int[]{nn, nm, nt});
                    if(map[nn][nm] > 0 && map[nn][nm] < sharkSize) foodList.add(new int[]{nn, nm, nt});
                }
            }

            if(foodList.isEmpty()) break;

            foodList.sort((a, b) -> {
                if(a[2] == b[2]){
                    if(a[0] == b[0]) return a[1] - b[1];
                    else return a[0] - b[0];
                } else return a[2] - b[2];
            });

            start[0] = foodList.get(0)[0];
            start[1] = foodList.get(0)[1];
            start[2] = foodList.get(0)[2];
            map[start[0]][start[1]] = 0;
            count++;
            if(sharkSize == count){
                sharkSize++;
                count = 0;
            }
            foodList.clear();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[][] map;
    public static int sharkSize = 2, count = 0;
}

