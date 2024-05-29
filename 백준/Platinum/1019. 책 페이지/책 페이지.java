import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[10];

        int add = 0;
        for(int i=1; N!=0; i*=10){
            int cur = N%10;
            N /= 10;

            count[0] -= i;
            for(int j=0; j<cur; j++) count[j] += (N+1) * i;
            count[cur] += N*i + 1 + add;
            for(int j=cur+1; j<=9; j++) count[j] += N*i;
            add += cur*i;
        }

        for(int i = 0 ; i < 10 ; i++){
            bw.write(count[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

