import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String[] arr = br.readLine().split(" ");
                map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            }
            int result = 1;
            for (int value : map.values()) result *= (value+1);
            bw.write((result-1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

