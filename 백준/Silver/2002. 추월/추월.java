import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * BOJ 2002 추월
 *
 * 들어간 String[], Map 과 나온 String[], Map 을 만들어서
 * 현재 차량을 기준으로 내 앞에 있던 차량이 내 뒤로 가 있다면,
 * 현재 차량은 추월 차량이므로 answer++ 합니다.
 *
 * 1000 * 1000 * 1000 이므로 가능할 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        String[] in = new String[N];
        HashMap<String, Integer> inMap = new HashMap<>();
        for (int i = 0; i < N; i++){
            in[i] = br.readLine();
            inMap.put(in[i], i);
        }

        String[] out = new String[N];
        HashMap<String, Integer> outMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            out[i] = br.readLine();
            outMap.put(out[i], i);
        }

        // 현재 차량을 기준으로 내 앞에 있던 차량이 내 뒤로 가 있다면,
        // 현재 차량은 추월 차량이다.

        for (String key : inMap.keySet()){
            // key 는 현재 차량
            int inRank = inMap.get(key);
            int outRank = outMap.get(key);

            boolean isPassed = false;

            // 내 앞에 있던 차량
            for(int i=0; i<inRank; i++){
                String sin = in[i];
                // 내 뒤에 있던 차량
                for(int j=outRank+1; j<N; j++){
                    String sout = out[j];
                    // 내 앞에 있던 차량이 내 뒤로 갔다면 현재 차량은 추월 차량이다.
                    if(sin.equals(sout)){
                        answer++;
                        isPassed = true;
                        break;
                    }
                }
                if(isPassed){
                    break;
                }
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

