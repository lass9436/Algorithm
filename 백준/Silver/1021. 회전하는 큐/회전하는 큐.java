import java.io.*;
import java.util.*;

/**
 * BOJ 1021 회전하는 큐
 * 문제에서 하라는 대로 했습니다.
 * 중요한 점은 if (inOrder <= listSize/2) 일 때 앞에서 부터 찾고,
 * 아니면 뒤에서 부터 찾는 것입니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            int order = Integer.parseInt(st.nextToken());
            q.offer(order);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int order = q.poll();
            int inOrder = list.indexOf(order);
            int listSize = list.size();
            if (inOrder <= listSize/2){
               for(int i=0; i<inOrder; i++){
                   count++;
                   list.add(list.get(0));
                   list.remove(0);
               }
               list.remove(0);
            }else{
                for(int i=inOrder; i<listSize; i++){
                    count++;
                    list.add(0, list.get(listSize-1));
                    list.remove(listSize);
                }
                list.remove(0);
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

