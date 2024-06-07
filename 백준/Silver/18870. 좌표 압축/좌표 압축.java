import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 18870 좌표 압축
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> origin = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        SortedSet<Integer> sorted = new TreeSet<>(origin);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i : sorted) map.put(i, index++);
        for (int i : origin) bw.write(map.get(i) + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}

