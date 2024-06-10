import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());
        int K = Integer.parseInt(init.nextToken());
        int S = Integer.parseInt(init.nextToken());

        List<Integer>[] adj = new List[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        int[] visited = new int[N+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{S, 0});
        visited[S] = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int next : adj[cur[0]]){
                if(visited[next] > 0) continue;
                visited[next] = cur[1] + 1;
                queue.offer(new int[]{next, cur[1]+1});
            }
        }

        boolean flag = false;
        for(int i=1; i<=N; i++){
            if(visited[i] == K){
                bw.write(i + "\n");
                flag = true;
            }
        }

        if(!flag) bw.write("-1\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

