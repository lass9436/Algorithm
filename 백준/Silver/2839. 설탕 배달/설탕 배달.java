import java.io.*;

/**
 * BOJ 설탕배달
 *
 * 수학적 풀이도 봤는데 이해하기가 어려워서 그냥 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        if (N % 5 == 0) bw.write(N/5+"\n");
        else {
            int five = N / 5;
            int three = 0;
            boolean isPossible = false;
            while (true){
                int size = N;
                size -= five * 5;
                if (five < 0) break;
                if (size % 3 == 0) {
                    three = size / 3;
                    isPossible = true;
                    break;
                }
                five--;
            }
            if (isPossible) bw.write((three + five)+"\n");
            else bw.write("-1\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

