import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 11663 선분 위의 점
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        list.sort(Integer::compareTo);

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;
            int aIndex = -1;
            while(start<=end){
                int mid = start + (end - start)/2;
                int point = list.get(mid);
                if(point==a){
                    aIndex = mid;
                    break;
                }else if(point<a){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                    aIndex = mid;
                }
            }

            start = 0;
            end = N - 1;
            int bIndex = -1;
            while(start<=end){
                int mid = start + (end - start)/2;
                int point = list.get(mid);
                if(point==b){
                    bIndex = mid;
                    break;
                }else if(point<b){
                    start = mid + 1;
                    bIndex = mid;
                }else{
                    end = mid - 1;
                }
            }

            int answer = aIndex == -1 || bIndex == -1 ? 0 : bIndex - aIndex + 1;

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

