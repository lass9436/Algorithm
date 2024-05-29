import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 8979
 *
 * 입력 :
 * N K
 * 국가번호 금 은 동 ... 이후 N 줄에 걸쳐서 총 N 번 입력
 *
 * 출력 :
 * 국가 K의 등수
 * 
 * 문제에서 나온 바와 같이 금, 은, 동 순서대로 갯수를 비교하고
 * 상위 값이 같으면 하위 값으로 비교하는 식으로 하면 될 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int K = Integer.parseInt(init.nextToken());

        int[][] scores = new int[N+1][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            scores[number][0] = gold;
            scores[number][1] = silver;
            scores[number][2] = bronze;
        }

        int answer = 1;
        int kGold = scores[K][0];
        int kSilver = scores[K][1];
        int kBronze = scores[K][2];

        for(int i = 1; i <= N; i++) {
            if(i == K) continue;
            if(scores[i][0] > kGold){
                answer++;
            }else if(scores[i][0] == kGold && scores[i][1] > kSilver){
                answer++;
            }else if(scores[i][0] == kGold && scores[i][1] == kSilver && scores[i][2] > kBronze){
                answer++;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

