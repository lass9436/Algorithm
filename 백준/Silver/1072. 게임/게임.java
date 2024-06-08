import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1072 게임
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = Long.parseLong(st.nextToken());
        long win = Long.parseLong(st.nextToken());
        long answer = Long.MAX_VALUE;
        boolean flag = false;
        if (total == win) answer = -1;
        else{
            long rate = win * 100 / total;
            long start = 0L;
            long end = total;
            while (start <= end) {
                long mid = start + (end - start) / 2;
                if(isChanged(mid, win, total, rate)){
                    answer = Math.min(answer, mid);
                    end = mid - 1;
                    flag = true;
                }else start = mid + 1;
            }
        }
        if(!flag) answer = -1;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isChanged(long mid, long win, long total, long rate){
        long sumWin = mid + win;
        long sumTotal = mid + total;
        long newRate = sumWin * 100 / sumTotal;
        return rate < newRate;
    }
}

