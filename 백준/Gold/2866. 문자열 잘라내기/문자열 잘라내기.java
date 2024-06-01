import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ2866 문자열 잘라내기
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
        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();

        int start = 0;
        int end = N-2;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(possible(board, mid)){
                start = mid + 1;
                answer = Math.max(answer, mid+1);
            }else{
                end = mid - 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean possible(char[][] board, int mid) {
        int N = board.length;
        int M = board[0].length;
        Set<String> set  = new HashSet<String>();
        for(int j = 0; j < M; j++){
            StringBuilder sb = new StringBuilder();
            for(int i=mid+1; i<N; i++){
                sb.append(board[i][j]);
            }
            set.add(sb.toString());
        }
        return set.size() == M;
    }
}

