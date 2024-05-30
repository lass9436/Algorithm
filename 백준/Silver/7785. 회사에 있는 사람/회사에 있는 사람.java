import java.io.*;
import java.util.*;

/**
 * 해시맵을 이용하여 출근과 퇴근을 관리하고
 * 리스트를 이용하여 역순 정렬을 했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String u = st.nextToken();
            String v = st.nextToken();
            if(v.equals("enter")){
                map.put(u, 1);
            }else{
                map.remove(u);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());

        for (String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

