import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] tops = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            int[] top = new int[]{Integer.parseInt(st.nextToken()), i};
            tops[i] = top;
        }

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int[] top = tops[i];
            if(stack.isEmpty()) {
                stack.push(top);
                bw.write("0 ");
            }
            else{
                while(!stack.isEmpty() && stack.peek()[0] < top[0]) stack.pop();
                if(!stack.isEmpty()) bw.write(stack.peek()[1] + " ");
                else bw.write("0 ");
                stack.push(top);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

