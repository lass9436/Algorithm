import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {return a[1] - b[1];});

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int[] cur = arr[i];
            int money = cur[0];
            int day = cur[1];

            if(pq.size() < day){
                pq.offer(money);
            }else{
                if(pq.peek() < money) {
                    pq.offer(money);
                    pq.poll();
                }
            }
        }

        int answer = pq.stream().reduce(0, Integer::sum);
        System.out.println(answer);
    }
}
