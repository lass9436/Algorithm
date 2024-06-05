import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Map<Integer, Integer> count = new HashMap<>();
            for(int j=1; j <= 9; j++){
                count.put(j, 0);
            }
            Queue<int[]> q = new LinkedList<>();
            for(int j = 0; j < N; j++){
                int importance = Integer.parseInt(st2.nextToken());
                count.put(importance, count.getOrDefault(importance, 0) + 1);
                int[] paper = new int[]{importance, j};
                q.offer(paper);
            }

            int order = 0;
            while(!q.isEmpty()){
                int[] paper = q.poll();
                int importance = paper[0];
                boolean isPossible = true;
                for(int j = importance + 1; j <= 9; j++){
                    if(count.get(j) > 0) isPossible = false;
                }
                if(isPossible){
                    order++;
                    count.put(importance, count.get(importance) - 1);
                    if(paper[1] == M) {
                        bw.write(order + "\n");
                    }
                }else{
                    q.offer(paper);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

