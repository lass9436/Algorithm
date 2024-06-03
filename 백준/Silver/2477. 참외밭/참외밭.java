import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2477 참외밭
 * 답지 봤습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[12][2];

        for(int i=0; i<6;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            arr[i] = arr[i+6] = new int[]{di, len};
        }

        for(int i=3; i<10; i++){
            if(arr[i][0] == arr[i-2][0] && arr[i-1][0] == arr[i-3][0]){
                int big = arr[i+1][1] * arr[i+2][1];
                int small = arr[i-1][1] * arr[i-2][1];
                answer = big - small;
            }
        }

        answer = answer * N;

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

