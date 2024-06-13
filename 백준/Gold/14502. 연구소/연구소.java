import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static int[] dy = {0, 1, -1, 0};
    public static int[] dx = {1, 0, 0, -1};

    public static int[][] map;
    public static int N;
    public static int M;

    public static int answer;

    public static void main(String[] args) throws Exception {

        StringTokenizer init = new StringTokenizer(br.readLine());
        N = Integer.parseInt(init.nextToken());
        M = Integer.parseInt(init.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        go(0, 3);

        System.out.println(answer);
    }

    public static void go(int depth, int end){

        if(depth == end) {
            int area = check();
            answer = Math.max(area, answer);
            return;
        };

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1) continue;
                if(map[i][j] == 2) continue;
                map[i][j] = 1;
                go(depth+1, end);
                map[i][j] = 0;
            }
        }
    }

    public static int check(){

        int[][] map_copy = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map_copy[i][j] = map[i][j];
            }
        }

        int area = 0;
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map_copy[i][j] == 2) bfs(i, j, map_copy, visited);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map_copy[i][j] == 0) area++;
            }
        }

        return area;
    }

    public static void bfs(int y, int x, int[][] map_copy , boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cur_y = cur[0];
            int cur_x = cur[1];


            for(int k=0; k<4; k++){
               int next_y = cur_y + dy[k];
               int next_x = cur_x + dx[k];

               if(next_y < 0 || next_y >= N || next_x < 0 || next_x >= M) continue;
               if(visited[next_y][next_x]) continue;
               if(map_copy[next_y][next_x] == 1) continue;
               visited[next_y][next_x] = true;
               map_copy[next_y][next_x] = 2;
               queue.offer(new int[]{next_y, next_x});
            }
        }

    }
}