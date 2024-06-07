import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
        list.sort(Integer::compareTo);
        int left = 0;
        int right = N - 1;
        int resultLeftValue = 0;
        int resultRightValue = 0;
        int resultAbs = Integer.MAX_VALUE;
        while(left<right){
            int leftValue = list.get(left);
            int rightValue = list.get(right);
            int result = leftValue + rightValue;
            if(Math.abs(result) < resultAbs){
                resultLeftValue = leftValue;
                resultRightValue = rightValue;
                resultAbs = Math.abs(result);
            }
            if(result == 0) break;
            else if(result > 0) right--;
            else left++;
        }

        bw.write(resultLeftValue + " " + resultRightValue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

