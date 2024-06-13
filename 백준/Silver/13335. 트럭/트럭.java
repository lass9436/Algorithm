import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 13335 트럭
 * 대표적인 스택(큐)문제인 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());
        int L = Integer.parseInt(init.nextToken());
        int W = Integer.parseInt(init.nextToken());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        int w = 0;
        for (int i = 0; i < L; i++) bridge.offer(0);
        for (int i = 0; i < N; i++) queue.offer(Integer.valueOf(st.nextToken()));

        int time = 0;
        while (!queue.isEmpty() || w != 0) {
            time++;
            w -= bridge.poll();
            int weight = 0;
            if(!queue.isEmpty() && queue.peek() + w <= W) weight = queue.poll();
            w += weight;
            bridge.offer(weight);
        }

        bw.write(time +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

