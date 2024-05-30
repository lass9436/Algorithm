import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 과반이 무엇인지에 대한 엣지 케이스에 주의했습니다.
 * 한 줄마다 Map 을 만들어서
 * 해당 군사의 병사가 몇 명인지를 표시했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int len = st.countTokens()/2 + st.countTokens()%2;
            boolean isConquered = false;
            while(st.hasMoreTokens()) {
                String army = st.nextToken();
                map.put(army, map.getOrDefault(army, 0) + 1);
                if(map.get(army) >= len){
                    isConquered = true;
                    bw.write(army + "\n");
                    break;
                }
            }
            if(!isConquered){
                bw.write("SYJKGW\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

