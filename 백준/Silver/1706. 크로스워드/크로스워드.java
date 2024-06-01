import java.io.*;
import java.util.*;

/**
 * BOJ 1706 크로스워드
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

        List<String> list  = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                char c = board[i][j];
                if (c != '#') sb.append(c);
                else if (sb.length() >= 2){
                    list.add(sb.toString());
                    sb.setLength(0);
                } else{
                    sb.setLength(0);
                }
            }
            if(sb.length() >= 2){
                list.add(sb.toString());
            }
        }

        for (int i = 0; i < M; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                char c = board[j][i];
                if (c != '#') sb.append(c);
                else if (sb.length() >= 2){
                    list.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.setLength(0);
                }
            }
            if(sb.length() >= 2){
                list.add(sb.toString());
            }
        }

        list.sort(String::compareTo);

        bw.write(list.get(0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}