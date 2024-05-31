import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Set 을 이용해서 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        Set<String> set = new HashSet<>();

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")){
                set.clear();
                continue;
            }
            if(!set.contains(s)){
                answer++;
                set.add(s);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

