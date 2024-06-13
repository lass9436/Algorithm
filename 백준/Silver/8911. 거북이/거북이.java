import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 8911 거북이
 */
public class Main {

    public static int maxX, maxY, minX, minY, x, y, di, N=4;
    public static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            char[] chars = br.readLine().toCharArray();
            init();
            for (char c : chars) move(c);
            bw.write((maxX - minX)*(maxY - minY) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void move(char c) {
        if (c == 'F'){
            x += dx[di];
            y += dy[di];
        } else if (c == 'B') {
            x -= dx[di];
            y -= dy[di];
        }
        else if (c == 'R') di = (di + 1)%N;
        else if (c == 'L') di = (N + di - 1)%N;

        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
    }

    public static void init() {
        maxX = 0;
        maxY = 0;
        minX = 0;
        minY = 0;
        di = 0;
        x = 0;
        y = 0;
    }
}

