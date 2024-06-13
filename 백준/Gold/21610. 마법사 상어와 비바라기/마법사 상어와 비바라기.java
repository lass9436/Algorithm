import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 21610 마법사 상어와 비바라기
 * 
 * 이건 너무 빡구현인데
 */
public class Main {

    public static int[] dn = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    public static int[] dm = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int N, M;
    public static int[][] map;
    public static ArrayDeque<int[]> cloud;
    public static ArrayDeque<int[]> water;
    public static boolean[][] isCloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        N = Integer.parseInt(init.nextToken());
        M = Integer.parseInt(init.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        water = new ArrayDeque<>();
        cloud = new ArrayDeque<>();
        cloud.offer(new int[]{N-1, 0});
        cloud.offer(new int[]{N-1, 1});
        cloud.offer(new int[]{N-2, 0});
        cloud.offer(new int[]{N-2, 1});
        for(int i=0; i<M; i++){
            isCloud = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            move(di, si);
            rain();
            waterBug();
            createCloud();
        }

        bw.write(calculate()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calculate(){
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                answer += map[i][j];
            }
        }
        return answer;
    }

    public static void createCloud(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] >= 2 && !isCloud[i][j]){
                    cloud.offer(new int[]{i, j});
                    map[i][j] -= 2;
                }
            }
        }
    }

    public static int[] dy = {1, 1, -1, -1}, dx = {1, -1, 1, -1};

    public static void waterBug(){
        while(!cloud.isEmpty()){
            int[] pos = cloud.poll();
            int count = 0;
            for(int k=0; k<4; k++){
                int nextY = pos[0] + dy[k];
                int nextX = pos[1] + dx[k];
                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;
                if(map[nextY][nextX] > 0) count++;
            }
            water.offer(new int[]{pos[0], pos[1], count});
            isCloud[pos[0]][pos[1]] = true;
        }

        while(!water.isEmpty()){
            int[] pos = water.poll();
            map[pos[0]][pos[1]] += pos[2];
        }
    }

    public static void rain(){
        int len = cloud.size();
        for(int i=0; i<len; i++) {
            int[] pos = cloud.poll();
            map[pos[0]][pos[1]]++;
            cloud.offer(pos);
        }
    }

    public static void move(int di, int si) {
        int len = cloud.size();
        for(int i=0; i<len; i++){
            int[] pos = cloud.poll();
            pos[0] = (N*50 + pos[0] + dn[di] * si) % N;
            pos[1] = (N*50 + pos[1] + dm[di] * si) % N;
            cloud.offer(pos);
        }
    }
}

