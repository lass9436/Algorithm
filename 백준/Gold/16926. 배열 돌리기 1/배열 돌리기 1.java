import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 16926 배열 돌리기
 * 바깥쪽부터 반시계 방향으로 돌면서 ArrayDeque 에 삽입
 * R 번 회전
 * 바깥쪽부터 반시계 방향으로 돌면서 ArrayDeque 에서 pollFirst() 하면서 배열에 삽입 
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int R = Integer.parseInt(init.nextToken());

        int[][] board = new int[N][M];

        for(int i = 0; i < N; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             for(int j = 0; j < M; j++) {
                 board[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        int size = Math.min(N, M)/2;

        ArrayDeque<Integer>[] deques = new ArrayDeque[size];


        // i, j는 시작점
        for(int i=0, j=0; i < size && j < size; i++, j++) {
            deques[i] = new ArrayDeque<>();
            // 아래로
            for(int k=i; k < N-i; k++) {
                deques[i].addLast(board[k][j]);
            }
            // 오른쪽으로
            for(int k=j+1; k<M-j; k++){
                deques[i].addLast(board[N-i-1][k]);
            }
            // 위로
            for(int k=N-i-2; k >= i; k--) {
                deques[i].addLast(board[k][M-j-1]);
            }
            // 왼쪽으로
            for(int k=M-j-2; k >= j+1; k--) {
                deques[i].addLast(board[i][k]);
            }
        }

        for(ArrayDeque<Integer> deque: deques) {
            for(int i=0; i<R; i++){
                deque.addFirst(deque.pollLast());
            }
        }

        // i, j는 시작점
        for(int i=0, j=0; i < size && j < size; i++, j++) {
            // 아래로
            for(int k=i; k < N-i; k++) {
                board[k][j] = deques[i].pollFirst();
            }
            // 오른쪽으로
            for(int k=j+1; k<M-j; k++){
                board[N-i-1][k] = deques[i].pollFirst();
            }
            // 위로
            for(int k=N-i-2; k >= i; k--) {
                board[k][M-j-1] = deques[i].pollFirst();
            }
            // 왼쪽으로
            for(int k=M-j-2; k >= j+1; k--) {
                board[i][k] = deques[i].pollFirst();
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bw.write(board[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

