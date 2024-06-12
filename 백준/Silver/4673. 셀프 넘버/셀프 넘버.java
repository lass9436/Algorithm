import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 4673 셀프 넘버
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isSelfNumber = new boolean[10001];
        Arrays.fill(isSelfNumber, true);

        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            int number = i;
            while(temp > 0){
                number += temp % 10;
                temp /= 10;
            }
            if(number <= 10000) isSelfNumber[number] = false;
        }

        for (int i = 1; i <= 10000; i++) {
            if(isSelfNumber[i]) bw.write(i +"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

