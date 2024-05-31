import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dfs 재귀를 사용하고 list 를 더하고 빼는 방식으로 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        dfs(1, M, N);

        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> list = new ArrayList<>();

    public static void dfs(int depth, int count, int end){
        if(list.size() == count){
            for(int i = 0; i < count; i++){
                System.out.print(list.get(i) + " ");
            }
            return;
        }
        for(int i = depth; i <= end; i++){
            list.add(i);
            dfs(i+1, count, end);
            list.remove(list.size()-1);
        }
    }
}

