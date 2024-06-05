import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        char[][] board1 = new char[N][M];
        char[][] board2 = new char[N][M];

        for (int i = 0; i < N; i++) {
            board1[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            board2[i] = br.readLine().toCharArray();
        }

        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (board1[i][j] != board2[i][j]) {
                    count++;
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l <j+3; l++) {
                            board1[k][l] = board1[k][l] == '0' ? '1' : '0';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board1[i][j] != board2[i][j]) {
                    count = -1;
                    break;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

