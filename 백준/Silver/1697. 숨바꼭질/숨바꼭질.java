import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});
        visited[N] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == M) break;
            int[] nextArr = new int[3];
            nextArr[0] = cur[0] - 1;
            nextArr[1] = cur[0] + 1;
            nextArr[2] = cur[0] * 2;
            int nextTime = cur[1] + 1;
            for(int next : nextArr){
                if(0 <= next && next <= 100000 && nextTime < visited[next]){
                    visited[next] = nextTime;
                    queue.offer(new int[]{next, nextTime});
                }
            }
        }
        bw.write(visited[M] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

