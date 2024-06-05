import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] chars = br.readLine().toCharArray();
            ArrayDeque<Character> deque = new ArrayDeque<>();
            for (char c : chars) {
                if(deque.isEmpty()) deque.addLast(c);
                else {
                    char cc = deque.getLast();
                    if(cc == '(' && c == ')') deque.removeLast();
                    else deque.addLast(c);
                }
            }
            if(deque.isEmpty()) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

