import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 1182 부분수열의 합
 * 당연히 연속적인 부분수열인 줄 알고 그렇게 했다가 틀렸다.
 * 연속이라고 안 했으니 비연속적인 부분수열도 생각을 해야한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        dfs(0, 0, true);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, answer;
    public static List<Integer> list;

    public static void dfs(int depth, int sum, boolean isZeroSize) {
        if(depth == N) {
            if(sum == M && !isZeroSize) answer++;
            return;
        }
        dfs(depth + 1, sum + list.get(depth), false);
        dfs(depth + 1, sum, isZeroSize);
    }
}

