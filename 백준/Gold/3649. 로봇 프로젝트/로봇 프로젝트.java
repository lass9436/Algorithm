import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 3649 로봇 프로젝트
 * 투 포인터로 풀었습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while((s = br.readLine()) != null && !s.isEmpty()) {
            int nanoTargetWidth = Integer.parseInt(s) * 10000000;

            int N = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<N;i++){
                int nanoWidth = Integer.parseInt(br.readLine());
                list.add(nanoWidth);
            }

            list.sort(Integer::compareTo);

            int left = 0;
            int right = N-1;
            boolean flag = false;

            int leftAnswer = 0;
            int rightAnswer = 0;

            while(left<right){
                int leftWidth = list.get(left);
                int rightWidth = list.get(right);
                int sumWidth = leftWidth + rightWidth;
                if(sumWidth == nanoTargetWidth){
                    flag = true;
                    leftAnswer = leftWidth;
                    rightAnswer = rightWidth;
                    break;
                }else if(sumWidth < nanoTargetWidth) left++;
                else right--;
            }

            if(flag) bw.write("yes " + leftAnswer + " " + rightAnswer +"\n");
            else bw.write("danger\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

