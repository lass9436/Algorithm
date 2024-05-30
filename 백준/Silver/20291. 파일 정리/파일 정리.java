import java.io.*;
import java.util.*;

/**
 * 해시맵과 리스트를 이용해 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("\\.");
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for(Map.Entry<String, Integer> entry : list) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

