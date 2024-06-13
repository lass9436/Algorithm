import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * BOJ 11559 Puyo Puyo
 * 단순 구현이라 설명할 게 딱히 없습니다.
 * 기본적으로 구현 시뮬레이션은 시간복잡도는 크게 신경쓰지 않고 푸는 편입니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<N; i++) map[i] = br.readLine().toCharArray();

        int temp = answer;
        while(temp != puyo()){
            temp = answer;
            down();
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N = 12, M = 6, answer = 0;
    public static char[][] map = new char[N][M];
    public static int[] dn = {0, 0, 1, -1}, dm = {-1, 1, 0, 0};

    public static void down(){
        // 역방향부터
        for(int i=N-2; i>=0; i--){
            for (int j=0; j<M; j++){
                char c = map[i][j];
                if (c == '.') continue;
                int temp = i+1;
                while(temp < N && map[temp][j] == '.'){
                    temp++;
                }
                temp--;
                if(i == temp) continue;
                map[temp][j] = c;
                map[i][j] = '.';
            }
        }
    }

    public static int puyo(){
        boolean[][] visited = new boolean[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayDeque<int[]> trace = new ArrayDeque<>();
        boolean isPuyo = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == '.') continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                queue.offer(new int[]{i, j});
                trace.offer(new int[]{i, j});
                char color = map[i][j];
                int count = 0;
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    count++;
                    for(int k=0; k<4; k++){
                        int nn = cur[0] + dn[k];
                        int nm = cur[1] + dm[k];
                        if(nn < 0 || nn >= N || nm < 0 || nm >= M) continue;
                        if(color != map[nn][nm] || visited[nn][nm]) continue;
                        visited[nn][nm] = true;
                        queue.offer(new int[]{nn, nm});
                        trace.offer(new int[]{nn, nm});
                    }
                }
                if (count >= 4){
                    isPuyo = true;
                    while(!trace.isEmpty()){
                        int[] cur = trace.poll();
                        map[cur[0]][cur[1]] = '.';
                    }
                }else{
                    trace.clear();
                }
            }
        }

        if(isPuyo) answer++;
        return answer;
    }
}

