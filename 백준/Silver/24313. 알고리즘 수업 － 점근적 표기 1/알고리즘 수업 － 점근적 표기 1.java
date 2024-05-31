import java.io.*;
import java.util.StringTokenizer;

/**
 * n 값을 대입해서 한 번만 계산하면 될 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        int u = Integer.parseInt(br.readLine());
        int v = Integer.parseInt(br.readLine());

        if(N * v + M <= u * v && u >= N){
            bw.write(1 + "\n");
        }else{
            bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

