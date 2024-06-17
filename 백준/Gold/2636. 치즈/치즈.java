import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * BOJ 2636 치즈
 *
 * 전형적인 BFS 시뮬레이션 문제인 것 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        map = new int[N][M];
        for (int i=0; i<N; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while(true){
            int temp = 0;
            answer++;
            visited = new boolean[N][M];
            visited[0][0] = true;
            queue.offer(new int[]{0, 0});
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int k=0; k<4; k++){
                    int nn = cur[0] + dn[k];
                    int nm = cur[1] + dm[k];
                    if(nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
                    if(visited[nn][nm]) continue;
                    if(map[nn][nm] == 1) {
                        queue2.offer(new int[]{nn, nm});
                        temp++;
                    }
                    else queue.offer(new int[]{nn, nm});
                    visited[nn][nm] = true;
                }
            }
            
            if(temp > 0) size = temp;
            if(queue2.isEmpty()) break;

            while(!queue2.isEmpty()){
                int[] cur = queue2.poll();
                map[cur[0]][cur[1]] = 0;
            }

        }
        bw.write(answer + "\n" + size + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, answer = -1, size = 0;
    public static int[] dn = {0, 0, -1, 1}, dm = {1, -1, 0, 0};
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayDeque<int[]> queue = new ArrayDeque<>();
    public static ArrayDeque<int[]> queue2 = new ArrayDeque<>();
}

