import java.io.*;
import java.util.*;

/**
 * BOJ 1863 스카이라인 쉬운거
 * 문제의 흐름을 보고 stack 문제라고 생각했다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<int[]> skylines = new ArrayList<>();
        for(int i=0; i<N; i++) skylines.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();
        int count = 0;
        for (int i=0; i<N; i++){
            int[] skyline = skylines.get(i);
            if (arrayDeque.isEmpty() || arrayDeque.peek()[1] < skyline[1]) {
                arrayDeque.push(skyline);
                if(skyline[1] > 0) count++;
            } else {
                while(!arrayDeque.isEmpty() && arrayDeque.peek()[1] > skyline[1]){
                    arrayDeque.pop();
                }
                if(arrayDeque.isEmpty() || arrayDeque.peek()[1] < skyline[1]) {
                    arrayDeque.push(skyline);
                    if(skyline[1] > 0) count++;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

