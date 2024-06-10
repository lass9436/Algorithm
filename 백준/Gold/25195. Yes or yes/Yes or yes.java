import java.io.*;
import java.util.*;

/**
 * BOJ 25195 Yes or yes
 * isLeaf 를 정의하고 마지막 leaf 의 node 번호를 저장했다.
 * bfs 를 하면서 leaf 와 만났을 경우, 여행이 끝나고 곰곰이를 만나지 않은 것으로 간주한다.
 * 왜냐면 bfs 안에서 곰곰이를 만날 경우 해당 루트를 더이상 진행하지 않고 포기하기 때문이다.
 * 따라서 leaf 인 마지막까지 여행을 진행했으면 곰곰이를 만나지 않고 여행을 할 수 있는 루트가 존재한다는 뜻이다.
 * wait 는 곰곰이의 위치를 index 로 true / false 로 나타냈다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[N+1];
        boolean[] isLeaf = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            isLeaf[i] = true;
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(line.nextToken());
            int v = Integer.parseInt(line.nextToken());
            adj[u].add(v);
            isLeaf[u] = false;
        }

        int S = Integer.parseInt(br.readLine());
        StringTokenizer dot = new StringTokenizer(br.readLine());
        boolean[] wait = new boolean[N+1];
        for (int i = 1; i <= S; i++) wait[Integer.parseInt(dot.nextToken())] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);

        boolean flag = false;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (wait[u]) continue;
            if(isLeaf[u]) flag = true;
            for (int next : adj[u]){
                queue.offer(next);
            }
        }

        bw.write(flag ? "yes" : "Yes");
        bw.flush();
        bw.close();
        br.close();
    }
}

