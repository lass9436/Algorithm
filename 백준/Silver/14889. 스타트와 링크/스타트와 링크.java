import java.io.*;
import java.util.*;

public class Main{
    
    public static int N;
    public static int[][] status;
    public static boolean[] selected;
    public static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        selected = new boolean[N];
        status = new int[N][N];
        
        for(int i=0; i<N; i++){
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        dfs(0, 0);
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void calculate(){
        List<Integer> A_team = new ArrayList<>();
        List<Integer> B_team = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            if(selected[i]) A_team.add(i);
            else B_team.add(i);
        }
        
        int A_team_sum = 0;
        for(int num : A_team){
            for(int num2 : A_team){
                A_team_sum += status[num][num2];
            }
        }
        
        int B_team_sum = 0;
        for(int num : B_team){
            for(int num2 : B_team){
                B_team_sum += status[num][num2];
            }
        }
        
        int result = Math.abs(A_team_sum - B_team_sum);
        answer = Math.min(result, answer);
    }
    
    public static void dfs(int depth, int count){
        if(count == N/2){
            calculate();
        }
        
        for(int i=depth; i<N; i++){
            selected[i] = true;
            dfs(i+1, count+1);
            selected[i] = false;
        }
    }
}
