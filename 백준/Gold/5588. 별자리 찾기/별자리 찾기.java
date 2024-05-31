import java.io.*;
import java.util.*;

/**
 * 가장 먼저 문제의 범위를 보고 brute-force 로 풀기로 했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 찾고 싶은 별자리 별의 수
        int N = Integer.parseInt(br.readLine());
        // 찾고 싶은 별자리 셋
        Set<Star> starSet = new HashSet<>();
        // 찾고 싶은 별자리 세팅
        StringTokenizer first = new StringTokenizer(br.readLine());
        Star FirstFindStar = new Star(Integer.parseInt(first.nextToken()), Integer.parseInt(first.nextToken()));
        starSet.add(FirstFindStar);
        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Star star = new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            starSet.add(star);
        }

        // 찾은 별자리 별의 수
        int M = Integer.parseInt(br.readLine());
        // 찾은 별자리 리스트
        List<Star> stars = new ArrayList<>();
        // 찾은 별자리 세팅
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Star star = new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            stars.add(star);
        }

        int answer_x = 0;
        int answer_y = 0;

        // 첫 번째 별을 바꾸면서 찾는다.
        for(int i=0; i<M; i++){
            Star firstStar = stars.get(i);
            // 첫 번째 별을 첫 번째 찾는 별로 이동하여 x y 를 구한다.
            int x = firstStar.x - FirstFindStar.x;
            int y = firstStar.y - FirstFindStar.y;
            // 첫 번째 별을 첫 번째 찾는 별로 이동하였으므로 1개를 찾은 걸로 취급한다.
            int count = 1;
            // 첫 번째 별은 찾았으므로, 다음 별부터 찾는다.
            for(int j=1; j<M; j++){
                Star star = stars.get((i+j)%M);
                Star move = new Star(star.x - x, star.y - y);
                // 찾는 별에 이동한 별이 있으면 찾았다고 표시한다.
                if(starSet.contains(move)) count++;
            }
            // 모든 별을 찾았을 때 반복문을 종료하고 answer 를 확정한다.
            if(count == N){
                answer_x = x;
                answer_y = y;
                break;
            }
        }
        bw.write(answer_x + " " + answer_y);
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Star {
        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Star) obj).x && this.y == ((Star) obj).y;
        }
    }
}

