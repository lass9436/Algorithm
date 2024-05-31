import java.io.*;
import java.util.*;

/**
 * 조건에서 순환은 반드시 만들어진다고 하였고,
 * 같은 사람이 두 사람에게 선의를 베풀 거나
 * 같은 사람이 두 사람에게 선의를 받는 경우는 없다고 하였습니다.
 * 따라서 서로의 관계를 Map<String, String> 으로 간단하게 설정할 수 있습니다.
 * visited 를 Set 으로 구현하였습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = 1;
        int N;
        while((N = Integer.parseInt(br.readLine())) > 0){
            Map<String, String> map = new HashMap<>();
            Set<String> visited = new HashSet<>();
            for(int i = 0 ; i < N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String u = st.nextToken();
                String v = st.nextToken();
                map.put(u, v);
            }
            int count = 0;
            for(String key : map.keySet()){
                if(!visited.contains(key)){
                    count++;
                    String cur = key;
                    while(true){
                        String next = map.get(cur);
                        if(visited.contains(next)) break;
                        visited.add(next);
                        cur = next;
                    }
                }
            }
            bw.write(number++ + " " + count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

