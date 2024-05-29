import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1193
 *
 * 입력 : 숫자
 * 출력 : 숫자에 해당하는 숫자/숫자 형 출력
 *
 * 지그재그로 한 방향으로 이동하는 length 가 1씩 증가함에 초점을 맞췄습니다.
 * length 를 증가시키면서 boolean up 으로 방향을 관리하고
 * count 를 1부터 증가시키면서 length 에 도달하면 up을 반전해 방향을 전환했습니다.
 *
 * 나머지는 초기값 세팅에만 신경쓰면 될 것 같습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer init = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(init.nextToken());

        int left = 1;
        int right = 1;

        int length = 1;
        int count = 1;

        boolean up = true;

        for(int i=1; i<N; i++){
            if(count == length){
                if(up){
                    right++;
                }else{
                    left++;
                }
                up = !up;
                count = 1;
                length++;
            } else if (up) {
                left--;
                right++;
                count++;
            } else {
                left++;
                right--;
                count++;
            }
        }
        bw.write(left + "/" + right + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

