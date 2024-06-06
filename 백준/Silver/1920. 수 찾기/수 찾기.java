import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Boolean> map = new HashMap<>();
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (long l : arr) map.put(l, true);
        int M = Integer.parseInt(br.readLine());
        long[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (long l : arr2) {
            if(map.getOrDefault(l, false)) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

