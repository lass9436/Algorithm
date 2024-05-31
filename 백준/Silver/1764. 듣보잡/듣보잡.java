import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * TreeMap 자료구조로 풀어봤습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        Map<String, Integer> map = new TreeMap<>();

        int count = 0;
        for(int i = 1; i <= N + M; i++) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if(map.get(s) == 2) count++;
        }

        bw.write(count + "\n");

        for(String s : map.keySet()) {
            if(map.get(s) == 2) bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

