import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ5525 IOIOI
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int size = 2 * N + 1;
        int maxIndex = M - size + 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i%2 == 0) {
                sb.append('I');
            }else{
                sb.append('O');
            }
        }
        String ioi = sb.toString();

        for(int i=0;i<maxIndex; i++){
            String sub = s.substring(i, i + size);
            if(sub.equals(ioi)){
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

