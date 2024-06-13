import java.io.*;
import java.util.*;

/**
 * BOJ 21609 상어 중학교
 *
 * 제거할 그룹을 선정하는게 가장 중요한 것 같다.
 * 크기 -> 무지개 블록의 수 -> 기준 블록의 행 -> 기준 블록의 열
 * 의 순으로 우선순위가 있다.
 *
 * 그리고 블록이 없음을 표현하기 위해서 null 을 사용하려고
 * int[][] 가 아닌 Integer[][] 를 사용했다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        N = Integer.parseInt(init.nextToken());
        M = Integer.parseInt(init.nextToken());

        map = new Integer[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findBlockGroup();
        while(list.size() >= 2){
            breakBlockGroup();
            blockDown();
            counterClockwise();
            blockDown();
            findBlockGroup();
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, answer = 0;
    public static Integer[][] map;
    public static boolean[][] visited;
    public static int[] dn = {0, 0, 1, -1}, dm = {1, -1, 0, 0};
    public static List<int[]> list;
    public static int size, rainbow, r, c;
    public static int tempSize, tempRainbow, tempR, tempC;
    public static ArrayDeque<int[]> queue, trace;

    public static void counterClockwise(){
        Integer[][] tempMap = new Integer[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tempMap[N - 1 - j][i] = map[i][j];
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = tempMap[i][j];
            }
        }
    }

    public static void breakBlockGroup(){
        int listSize = list.size();
        answer += listSize * listSize;
        for(int i=0; i<listSize; i++){
            int[] pos = list.get(i);
            map[pos[0]][pos[1]] = null;
        }
    }

    public static void blockDown(){
        for(int i=N-2; i>=0; i--){
            for(int j=0; j<N; j++){
                Integer integer = map[i][j];
                if(integer == null || integer == -1) continue;
                int tempI = i + 1;
                while(tempI < N && map[tempI][j] == null){
                    tempI++;
                }
                tempI--;
                if(tempI != i){
                    map[tempI][j] = integer;
                    map[i][j] = null;
                }
            }
        }
    }

    public static void findBlockGroup(){
        list = new ArrayList<>();
        size = 1;
        rainbow = 0;
        r = 0;
        c = 0;
        visited = new boolean[N][N];
        queue = new ArrayDeque<>();
        trace = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Integer integer = map[i][j];
                if(integer == null) continue;
                if(integer == 0 || integer == -1) continue;
                if(visited[i][j]) continue;
                visited[i][j] = true;
                int color = integer;
                tempR = i;
                tempC = j;
                tempSize = 0;
                tempRainbow = 0;
                trace = new ArrayDeque<>();
                queue.offer(new int[]{i, j});
                trace.offer(new int[]{i, j});
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    if(map[cur[0]][cur[1]] == 0) tempRainbow++;
                    tempSize++;
                    for(int k=0; k<4; k++){
                        int nn = cur[0] + dn[k];
                        int nm = cur[1] + dm[k];
                        if(nn < 0 || nn >= N || nm < 0 || nm >= N) continue;
                        if(map[nn][nm] == null) continue;
                        if(color != map[nn][nm] && 0 != map[nn][nm]) continue;
                        if(visited[nn][nm]) continue;
                        visited[nn][nm] = true;
                        queue.offer(new int[]{nn, nm});
                        trace.offer(new int[]{nn, nm});
                    }
                }
                if(size < tempSize){
                    changeGroup();
                }else if(size == tempSize && rainbow < tempRainbow){
                    changeGroup();
                }else if(size == tempSize && rainbow == tempRainbow && r < tempR){
                    changeGroup();
                }else if(size == tempSize && rainbow == tempRainbow && r == tempR && c < tempC){
                    changeGroup();
                }
                rainbowReset();
            }
        }
    }

    public static void rainbowReset(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == null) continue;
                if(map[i][j] == 0) visited[i][j] = false;
            }
        }
    }

    public static void changeGroup(){
        list.clear();
        while(!trace.isEmpty()){
            list.add(trace.poll());
        }
        size = tempSize;
        rainbow = tempRainbow;
        r = tempR;
        c = tempC;
    }
}

