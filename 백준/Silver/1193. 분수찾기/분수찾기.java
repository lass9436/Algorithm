import java.io.*;
import java.util.StringTokenizer;

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

