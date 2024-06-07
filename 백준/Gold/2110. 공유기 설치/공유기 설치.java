import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 2110 공유기 설치
 *
 * 입국 심사랑 비슷한 문제이다.
 * 공유기를 떨어뜨려 놓는 거리 자체를 이분탐색하면 된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(Integer.parseInt(br.readLine()));
        list.sort(Integer::compareTo);
        int start = 0;
        int end = Integer.MAX_VALUE;
        int answer = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(isPossible(list, mid, M)){
                start = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                end = mid - 1;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPossible (List<Integer> list, int distance, int count){
        int left = list.get(0);
        count--;
        int N = list.size();
        for(int i=1; i<N; i++){
            int right = list.get(i);
            if(right - left >= distance){
                count--;
                left = right;
            }
            if(count == 0) break;
        }
        return count == 0;
    }
}

