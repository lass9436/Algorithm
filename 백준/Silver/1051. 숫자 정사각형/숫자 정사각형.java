import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1051 숫자 정사각형
 * 정사각형의 길이를 0부터 min(N, M) 까지 늘려가면서
 * 2중 반복문으로 정사각형의 시작점을 모두 찾는 것으로 했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxSize = Math.min(N, M);

        for(int s=0; s<maxSize; s++) {
            for(int i=0; i<N-s; i++) {
                for(int j=0; j<M-s; j++) {
                    char a = board[i][j];
                    char b = board[i+s][j];
                    char c = board[i][j+s];
                    char d = board[i+s][j+s];
                    if(a == b && b == c && c == d) {
                        answer = Math.max(answer, (s+1)*(s+1));
                    }
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

