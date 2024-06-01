import java.io.*;

/**
 * BOJ 5525
 * 답지 봤습니다.
 * String 이나 char 를 이용해 비교했지만, O(N^2)으로 실패해서
 * O(N)의 방법을 찾아야 했습니다.
 * 최소 IOI 를 찾고 찾는 N 의 IOI...I 가 되면 result++ 하고 
 * 카운트를 한 개 내리고, i++를 합니다.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char s[] = br.readLine().toCharArray();

        int result = 0;
        int count = 0;

        for(int i=1; i < M - 1; i++) {
            if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                count++;

                if(count == N) {
                    count--;
                    result++;
                }
                i++;
            }
            else {
                count = 0;
            }
        }

        System.out.println(result);

    } // End of main
} // End of class