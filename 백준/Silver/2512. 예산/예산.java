import java.io.*;
import java.util.Arrays;

/**
 * BOJ 2512 예산
 *
 * 그냥 범위만 봐도 대놓고 이분탐색이다.
 * M은 N 이상 1,000,000,000 <- 이런 걸 이분탐색 없이 어떻게 해
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = Integer.parseInt(br.readLine());
        int end = 0;
        for (int cost : arr) end = Math.max(end, cost);
        int start = 0;
        int answer = 0;
        while (start<=end){
            int mid = start + (end - start)/2;
            if (isPossible(mid, total, arr)){
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else end = mid - 1;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPossible(int mid, int total, int[] arr){
        long sum = 0;
        for(int cost : arr){
            int res = Math.min(mid, cost);
            sum += res;
            if(sum < 0) return false;
        }
        return sum <= total;
    }
}

