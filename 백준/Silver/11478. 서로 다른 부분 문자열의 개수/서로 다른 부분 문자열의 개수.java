import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 해시맵을 사용하고,
 * length 를 1씩 늘려가면서 부분 문자열을 탐색했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String s = br.readLine();

        Map<String, Integer> map = new HashMap<>();
        for(int len = 1; len <= s.length(); len++){
            for(int i=0; i<s.length() - len + 1; i++){
                String sub = s.substring(i, i+len);
                map.put(sub, 1);
            }
        }

        bw.write(map.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

