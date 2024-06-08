import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 19638 센티와 마법의 뿅망치
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int giantCount = Integer.parseInt(init.nextToken());
        int centiHeight = Integer.parseInt(init.nextToken());
        int magicCount = Integer.parseInt(init.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(giantCount-- > 0){
            int giantHeight = Integer.parseInt(br.readLine());
            pq.offer(giantHeight);
        }

        int answer = 0;
        while(!pq.isEmpty() && answer < magicCount && pq.peek() >= centiHeight){
            int giantHeight = pq.poll();
            if (giantHeight == 1) {
                pq.offer(giantHeight);
                break;
            }
            giantHeight /= 2;
            answer++;
            pq.offer(giantHeight);
        }

        if(!pq.isEmpty() && pq.peek() >= centiHeight){
            bw.write("NO\n");
            bw.write(pq.peek()+"\n");
        }else{
            bw.write("YES\n");
            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

