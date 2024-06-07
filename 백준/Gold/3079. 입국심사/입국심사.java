import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 3079 입국심사
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        long N = Long.parseLong(init.nextToken());
        long M = Long.parseLong(init.nextToken());

        List<Long> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(Long.parseLong(br.readLine()));

        long start = 0L;
        long end = Long.MAX_VALUE;
        long answer = Long.MAX_VALUE;
        while(start<=end){
            long mid = start + (end - start)/2;
            long possible = 0;
            for(long time : list){
                possible += mid / time;
                if (possible < 0) {
                    possible = Long.MAX_VALUE;
                    break;
                }
            }
            if(M <= possible){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

