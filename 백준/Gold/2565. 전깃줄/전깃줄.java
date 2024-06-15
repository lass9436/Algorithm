import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * BOJ 2565 전깃줄
 *
 * 대표적인 최장 증가 부분 수열 문제이다.
 * 공식을 보고 이렇게 하면 왜 최장 증가 부분 수열이 되는지 이해하는 게 어려웠다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] lis = new int[N];
        int[][] list = new int[N][2];
        for (int i = 0; i < N; i++) {
            list[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(list, Comparator.comparingInt(a -> a[0]));
        Arrays.fill(lis, 1);
        for (int i = 1; i < N; i++) {
            int last = list[i][1];
            int max = 1;
            for (int j = 0; j < i; j++){
                int cur = list[j][1];
                if (cur < last) {
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[i] = max;
        }
        int answer = 0;
        for (int i = 0; i < N; i++) answer = Math.max(answer, lis[i]);
        bw.write((N - answer) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

