import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] board = new int[25][25];

        for(int i=1; i<=19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int win_i = 0;
        int win_j = 0;
        for(int j=1; j<=19; j++){
            if(winner > 0) break;
            for(int i=1; i<=19; i++){
                if(winner > 0) break;
                if(board[i][j] > 0){
                    for(int k=0; k<4; k++){
                        boolean reverse = reverseCheck(i, j, k, board[i][j], board);
                        if(reverse) continue;
                        int result = check(i, j, k, board[i][j], board);
                        if(result == 5) {
                            winner = board[i][j];
                            win_i = i;
                            win_j = j;
                            break;
                        }
                    }
                }
            }
        }

        bw.write(winner +"\n");

        if(winner > 0){
            bw.write((win_i) + " " + (win_j) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 아래, 대각 아래, 오른쪽, 대각위
    public static int[] dx = new int[]{1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1};

    public static int check(int i, int j, int dir, int candi, int[][] board){
        if(board[i][j] == candi){
            int next_i = i + dx[dir];
            int next_j = j + dy[dir];
            return check(next_i, next_j, dir, candi, board) + 1;
        }
        return 0;
    }

    public static boolean reverseCheck(int i, int j, int dir, int candi, int[][] board){
        i = i - dx[dir];
        j = j - dy[dir];
        return board[i][j] == candi;
    }
}

