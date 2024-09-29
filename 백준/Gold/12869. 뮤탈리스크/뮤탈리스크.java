import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][][] visited = new int[64][64][64];
    public static int[][] attack = {
            {1, 3, 9},
            {1, 9, 3},
            {3, 1, 9},
            {3, 9, 1},
            {9, 1, 3},
            {9, 3, 1}
    };

    public static void main(String[] args) throws IOException {

        int init = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] scv = new int[3];

        for(int i=0; i<init; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(scv);
        visited[scv[0]][scv[1]][scv[2]] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int scv1 = cur[0];
            int scv2 = cur[1];
            int scv3 = cur[2];

            if(scv1 == 0 && scv2 == 0 && scv3 == 0){
                answer = visited[scv1][scv2][scv3];
                break;
            }

            for(int i=0; i<6; i++){
                int[] atk = attack[i];
                int next_scv1 = Math.max(0, scv1 - atk[0]);
                int next_scv2 = Math.max(0, scv2 - atk[1]);
                int next_scv3 = Math.max(0, scv3 - atk[2]);
                if(visited[next_scv1][next_scv2][next_scv3] > 0) continue;
                queue.offer(new int[]{next_scv1, next_scv2, next_scv3});
                visited[next_scv1][next_scv2][next_scv3] = visited[scv1][scv2][scv3] + 1;
            }
        }

        System.out.println(answer);
    }
}