import java.io.*;
import java.util.Arrays;

/**
 * BOJ 동전
 *
 * 대표적인 스냅백 문제인데
 * 이해를 하는게 어려웠다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(br.readLine());
            int[] snapBack = new int[target + 1];
            snapBack[0] = 1;
            for (int i = 0; i < N; i++) {
                int value = init[i];
                if (i == 0) {
                    for (int j=value; j<=target; j+=value) {
                        snapBack[j] = 1;
                    }
                } else{
                    for (int j=value; j<=target; j++) {
                        snapBack[j] += snapBack[j-value];
                    }
                }
            }
            bw.write(snapBack[target] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

