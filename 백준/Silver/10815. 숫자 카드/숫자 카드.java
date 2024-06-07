import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> origin = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> find = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));

        origin.sort(Integer::compareTo);
        for (int f : find){
            int start = 0;
            int end = N-1;
            boolean isFound = false;
            while (start <= end){
                int mid = start + (end - start)/2;
                int o = origin.get(mid);
                if (o == f){isFound = true; break;}
                else if(o < f) start = mid + 1;
                else end = mid - 1;
            }
            if (isFound) bw.write("1 ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

