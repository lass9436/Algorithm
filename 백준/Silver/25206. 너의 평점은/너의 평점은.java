import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 25206
 * 20줄을 받아서 계산하면 될 것 같습니다.
 * P일 경우 continue 합니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double sum = 0.0;
        double count = 0;
        for(int i=0; i<20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double time = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            if(score.equals("P")) continue;
            double scoreDouble = map.get(score);
            sum += time * scoreDouble;
            count += time;
        }

        double answer = sum / count;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

