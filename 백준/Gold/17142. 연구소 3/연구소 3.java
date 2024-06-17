import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BOJ 17142 연구소 3
 * 
 * 너무 스태틱을 많이 쓰다보니 while 문에서 queue 를 전부 소진하지 않고 break 할 때,
 * queue 를 초기화를 해야한다는 것을 까먹었다.
 * 이래서 static 을 남용하면 안 되는 것 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                int m = map[i][j];
                if(m == 2) virusList.add(new int[]{i, j});
            }
        }
        size = virusList.size();

        dfs(0, 0);
        if(answer == Integer.MAX_VALUE) bw.write("-1\n");
        else bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, answer = Integer.MAX_VALUE, size;
    public static int[] dn = {0, 0, -1, 1}, dm = {1, -1, 0, 0};
    public static int[][] map;
    public static boolean[][] visited;
    public static List<int[]> virusList = new ArrayList<>(), selected = new ArrayList<>();
    public static ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void dfs(int depth, int index){
        if(depth==M) {
            bfs();
            return;
        }

        for(int i=index; i<size; i++){
            selected.add(virusList.get(i));
            dfs(depth+1, i+1);
            selected.remove(selected.size()-1);
        }
    }

    public static void bfs(){
        int time = -1;
        queue.clear();
        visited = new boolean[N][N];
        for(int[] virus : selected) {
            queue.offer(virus);
            visited[virus[0]][virus[1]] = true;
        }
        while(!queue.isEmpty()){
            time++;
            if(isCompleted()) break;
            int len = queue.size();
            for(int i=0; i<len; i++){
                int[] cur = queue.poll();
                for(int k=0; k<4; k++){
                    int nn = cur[0] + dn[k];
                    int nm = cur[1] + dm[k];
                    if(nn < 0 || nn >= N || nm < 0 || nm >= N) continue;
                    if(visited[nn][nm]) continue;
                    if(map[nn][nm] == 1) continue;
                    visited[nn][nm] = true;
                    queue.offer(new int[]{nn, nm});
                }
            }
        }

        if(isCompleted()) answer = Math.min(answer, time);
    }

    public static boolean isCompleted(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}

