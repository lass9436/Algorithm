import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1018 체스판 다시 칠하기
 * 전체 높이 - 8, 전체 너비 - 8 의 범위에서 시작점 l, k를 정하고
 * l + 8, k + 8 범위에서 브루트 포스를 했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.MAX_VALUE;

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] =  br.readLine().toCharArray();
        }

        for (int l = 0; l <= N-8; l++) {
            for (int k = 0; k <= M-8; k++) {
                int w = 0;
                int b = 0;
                for(int i = l; i < l+8; i++){
                    for(int j = k; j < k+8; j++){
                        char c = board[i][j];
                        if(c == 'B' && (i+j)%2 == 0) b++;
                        else if(c == 'W' && (i+j)%2 == 1) b++;
                        if(c == 'W' && (i+j)%2 == 0) w++;
                        else if(c == 'B' && (i+j)%2 == 1) w++;
                    }
                }
                int temp = Math.min(w, b);
                answer = Math.min(answer, temp);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

