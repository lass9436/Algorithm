import java.io.*;

/**
 * BOJ 9655 돌게임
 *
 * 돌이 1개 있으면 상근이가 이기고
 * 돌이 2개 있으면 창영이가 이기고
 * 돌이 3개 있으면 상근이가 이기고
 * 돌이 4개 있으면 창영이가 이기고
 * 돌이 5개 있으면 상근이가 이기고...
 * 홀수면 상근이가 이기고 짝수면 창영이가 이기는 것 같다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.parseInt(br.readLine())%2==1?"SK":"CY");
        bw.flush();
        bw.close();
        br.close();
    }
}

