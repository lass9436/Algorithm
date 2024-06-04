import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int N;
    public static int M;

    public static int answer = 987654321;

    public static List<int[]> list = new ArrayList<>();
    public static List<int[]> list_temp = new ArrayList<>();
    public static List<int[]> list_home = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer init = new StringTokenizer(br.readLine());

        N = Integer.parseInt(init.nextToken());
        M = Integer.parseInt(init.nextToken());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 2) list.add(new int[]{i, j});
                if(num == 1) list_home.add(new int[]{i, j});
            }
        }

        dfs(0,0, M);

        System.out.println(answer);
    }

    public static void dfs(int count, int depth, int end){
        if(count == end){
            calculate();
            return;
        }

        for(int i=depth; i<list.size(); i++){
            int[] cur = list.get(i);
            list_temp.add(new int[]{cur[0], cur[1]});
            dfs(count+1, i+1, end);
            list_temp.remove(list_temp.size()-1);
        }
    }

    public static void calculate(){
        int result = 0;
        for(int i=0; i<list_home.size(); i++){
            int dis = 987654321;
            int[] home = list_home.get(i);
            for(int j=0; j<list_temp.size(); j++){
                int[] chicken = list_temp.get(j);
                int temp = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
                dis = Math.min(dis, temp);
            }
            result += dis;
        }
        answer = Math.min(result, answer);
    }
}
