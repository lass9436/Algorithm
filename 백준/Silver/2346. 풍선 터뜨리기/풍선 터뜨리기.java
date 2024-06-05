import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            deque.add(new int[]{i, number});
        }

        while(!deque.isEmpty()) {
            int[] balloon = deque.pollFirst();
            bw.write(balloon[0] + " ");
            int move = balloon[1];
            if(move > 0) move--;
            while(move != 0 && !deque.isEmpty()){
                if(move > 0) {
                    int[] next = deque.pollFirst();
                    deque.offerLast(next);
                    move--;
                } else {
                    int[] next = deque.pollLast();
                    deque.offerFirst(next);
                    move++;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

