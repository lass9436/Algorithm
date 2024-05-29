import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 2641
 *
 * 숫자 순서의 길이 N 이 최대 50이고
 *
 * 비교할 대상 순서들의 갯수 M 이 최대 100 이다.
 * 순서가 동일하다면, 시작하는 타이밍은 상관이 없다.
 * 2중 for 문을 돌면서 한 번이라도 순서가 같았다면 두 순서가 그리는 모양은 같다.
 *
 * 그런데 순서가 역방향으로 같아도 된다. 예를 들어 1<->3 2<->4 로
 * 서로 역방향인데 이것도 체크를 해야되어서 2N이다.
 * 여기서 또 주의해야할 점은, 역방향은 숫자도 반전하고 순서도 반전을 해야한다는 점이다.
 *
 * O(N * 2N * M) -> 50 * 100 * 100 => 500,000 이므로 할 수 있을 것 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        // 숫자 길이
        int N = Integer.parseInt(br.readLine());

        // 원본 순서
        int[] originOrder = new int[N];

        StringTokenizer origin = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originOrder[i] = Integer.parseInt(origin.nextToken());
        }

        // 비교할 숫자들의 갯수
        int M = Integer.parseInt(br.readLine());

        // 방향 반전
        int[] reverse = new int[]{0, 3, 4, 1, 2};

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            // 비교할 순서
            int[] otherOrder = new int[N];
            StringTokenizer other = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                otherOrder[j] = Integer.parseInt(other.nextToken());
            }

            for (int j = 0; j < N; j++) {
                boolean match = true;
                // 정방향
                for(int k = 0; k < N; k++) {
                    if(originOrder[(j + k) % N] != otherOrder[k]){
                        match = false;
                        break;
                    }
                }
                if(match){
                    list.add(otherOrder);
                    break;
                }

                boolean matchReverse = true;
                // 역방향
                for(int k = 0; k < N; k++) {
                    if(reverse[originOrder[(N + j - k) % N]] != otherOrder[k]){
                        matchReverse = false;
                        break;
                    }
                }
                if(matchReverse){
                    list.add(otherOrder);
                    break;
                }
            }
        }
        bw.write(list.size() + "\n");
        for (int[] arr : list) {
            for (int i = 0; i < N; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

