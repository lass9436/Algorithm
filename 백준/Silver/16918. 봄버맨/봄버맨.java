import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 16918 봄버맨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        R = Integer.parseInt(init.nextToken());
        C = Integer.parseInt(init.nextToken());
        int N = Integer.parseInt(init.nextToken());

        char[][] map = new char[R][C];
        Node[][] board = new Node[R][C];
        for (int i = 0; i < R; i++) map[i] = br.readLine().toCharArray();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                char c = map[i][j];
                if(c == 'O') board[i][j] = new Node(0, true);
                else board[i][j] = new Node(0, false);
            }
        }

        for (int i = 1; i <= N; i++){
            if(i == 1) continue;
            else if(i % 2 == 0) setBomb(board, i);
            else explosion(board, i);
        }

        for (int i=0; i < R; i++){
            for (int j=0; j < C; j++){
                if(board[i][j].bomb) map[i][j] = 'O';
                else map[i][j] = '.';
            }
        }

        for (int i = 0; i < R; i++) bw.write(String.valueOf(map[i]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int R, C;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void explosion(Node[][] board, int time){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j].bomb && board[i][j].time == time - 3){
                    queue.offer(new int[]{i, j});
                    for(int k=0; k<4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            board[cur[0]][cur[1]].bomb = false;
        }
    }

    public static void setBomb(Node[][] board, int time){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!board[i][j].bomb){
                    board[i][j].bomb = !board[i][j].bomb;
                    board[i][j].time = time;
                }
            }
        }
    }

    public static class Node {
        public int time;
        public boolean bomb;
        public Node(int time, boolean bomb) {
            this.time = time;
            this.bomb = bomb;
        }
    }
}

