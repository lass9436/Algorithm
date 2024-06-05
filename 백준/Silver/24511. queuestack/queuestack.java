import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 0 은 큐 1 은 스택
        int[] qs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 초기값
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (qs[i] == 0) {
                q.offerLast(init[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());

        int[] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < M; i++) {
            q.offerFirst(values[i]);
            bw.write(q.pollLast() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

