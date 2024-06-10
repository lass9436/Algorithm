import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 3055 탈출
 * 물이 퍼질 예정인 곳에 고슴도치가 갈 수 없다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean[][] visitedHedgehog = new boolean[N][M];
        boolean[][] visitedWater = new boolean[N][M];
        Queue<int[]> queueHedgehog = new ArrayDeque<>();
        Queue<int[]> queueWater = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'S') queueHedgehog.offer(new int[]{i, j});
                if (board[i][j] == '*') queueWater.offer(new int[]{i, j});
            }
        }

        int[] dn = {0, 0, 1, -1};
        int[] dm = {1, -1, 0, 0};

        int count = -1;
        boolean flag = false;

        while (!queueHedgehog.isEmpty()) {
            count++;
            int sizeHedgehog = queueHedgehog.size();
            for (int i = 0; i < sizeHedgehog; i++) {
                int[] curHedgehog = queueHedgehog.poll();
                if (board[curHedgehog[0]][curHedgehog[1]] == '*') continue;
                if (board[curHedgehog[0]][curHedgehog[1]] == 'D') {
                    flag = true;
                    queueHedgehog.clear();
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nextN = curHedgehog[0] + dn[j];
                    int nextM = curHedgehog[1] + dm[j];
                    if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && !visitedHedgehog[nextN][nextM]) {
                        visitedHedgehog[nextN][nextM] = true;
                        char tile = board[nextN][nextM];
                        if(tile == '.' || tile == 'D') {
                            queueHedgehog.offer(new int[]{nextN, nextM});
                        }
                    }
                }
            }

            int sizeWater = queueWater.size();
            for (int i = 0; i < sizeWater; i++) {
                int[] curWater = queueWater.poll();
                for (int j = 0; j < 4; j++) {
                    int nextN = curWater[0] + dn[j];
                    int nextM = curWater[1] + dm[j];
                    if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < M && !visitedWater[nextN][nextM]) {
                        visitedWater[nextN][nextM] = true;
                        char tile = board[nextN][nextM];
                        if(tile == '.' || tile == 'S') {
                            board[nextN][nextM] = '*';
                            queueWater.offer(new int[]{nextN, nextM});
                        }
                    }
                }
            }
        }

        if (flag) bw.write(count + "\n");
        else bw.write("KAKTUS\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

