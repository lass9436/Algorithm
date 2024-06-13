import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 20056 마법사 상어와 파이어볼
 *
 * ...
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        N = Integer.parseInt(init.nextToken());
        M = Integer.parseInt(init.nextToken());
        K = Integer.parseInt(init.nextToken());

        map = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            FireBall fb = new FireBall(n, m, mass, s, d);
            map[n][m].add(fb);
        }

        for(int i=0; i<K; i++){
            move();
            combine();
        }

        bw.write(calculate() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combine(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                List<FireBall> list = map[i][j];
                int size = list.size();
                if(size < 2) continue;
                int mass = 0;
                int s = 0;
                int dO = 0;
                int dE = 0;
                int direction = 0;
                for (int k=0; k<size; k++){
                    FireBall fb = list.get(k);
                    mass += fb.mass;
                    s += fb.s;
                    if(fb.d % 2 == 0) dE++;
                    else dO++;
                }

                mass /= 5;
                s /= size;
                // direction 0 2 4 6
                if(dO == 0 || dE == 0) direction = 0;
                // direction 1 3 5 7
                else direction = 1;
                list.clear();
                if(mass == 0) continue;
                for(int k=0; k<4; k++){
                    FireBall fb = new FireBall(i, j, mass, s, direction + k*2);
                    list.add(fb);
                }
            }
        }
    }

    public static int calculate(){
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                List<FireBall> list = map[i][j];
                int size = list.size();
                for (int k=0; k<size; k++){
                    FireBall fb = list.get(k);
                    answer += fb.mass;
                }
            }
        }
        return answer;
    }

    public static void move(){
        ArrayDeque<FireBall> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                List<FireBall> list = map[i][j];
                int size = list.size();
                for (int k=0; k<size; k++){
                    FireBall fb = list.get(k);
                    fb.n = (fb.n + fb.s * dn[fb.d] + N*300) % N;
                    fb.m = (fb.m + fb.s * dm[fb.d] + N*300) % N;
                    queue.offer(fb);
                }
            }
        }
        mapInit();
        while(!queue.isEmpty()){
            FireBall fb = queue.poll();
            map[fb.n][fb.m].add(fb);
        }
    }

    public static int N, M, K;
    public static List<FireBall>[][] map;
    public static int[] dn = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dm = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void mapInit(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j].clear();
            }
        }
    }

    public static class FireBall{
        public int n;
        public int m;
        public int mass;
        public int s;
        public int d;

        public FireBall(int n, int m, int mass, int s, int d){
            this.n = n;
            this.m = m;
            this.mass = mass;
            this.s = s;
            this.d = d;
        }
    }
}

