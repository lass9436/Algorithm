import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 17086 아기상어 2
 *
 * 안전거리를 수학으로 구할 수 있을 것 같은데?
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int[][] map = new int[N][M];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) list.add(new int[]{i, j});
            }
        }

        int size = list.size();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int distance = Integer.MAX_VALUE;
                for (int k = 0; k < size; k++) {
                    int[] shark = list.get(k);
                    int disX = Math.abs(i - shark[0]);
                    int disY = Math.abs(j - shark[1]);
                    int dia = Math.min(disX, disY);
                    disX = disX - dia;
                    disY = disY - dia;
                    int temp = disX + disY + dia;
                    distance = Math.min(temp, distance);
                }
                answer = Math.max(answer, distance);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

