import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                char c = s.charAt(j);
                if(c == '.') map[i][j] = -1;
                if(c == 'c') map[i][j] = 0;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int num = map[i][j];
                if(num == -1) continue;
                if(num == 0) {
                    for(int k=j+1; k<M; k++){
                        int next = map[i][k];
                        if(next == 0) break;
                        map[i][k] = map[i][k-1] + 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}