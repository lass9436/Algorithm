import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        Map<Integer, Integer> order = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i=0; i<list.size(); i++){
            int n = list.get(i);
            final int o = i;
            order.computeIfAbsent(n, k -> o);
            count.compute(n, (k, v) -> (v == null) ? 1 : v + 1);
        }
        
        list.sort((a, b) -> {
            if(count.get(a) == count.get(b)){
                return order.get(a) - order.get(b);
            }
            return count.get(b) - count.get(a);
        });
        
        for(int i : list){
            sb.append(i + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
