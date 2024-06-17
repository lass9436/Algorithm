import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1713 후보 추천하기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] vote = new int[101];
        int[] time = new int[101];
        int count = 0;
        for (int i=0; i<M; i++){
            int number = numbers[i];
            if (count < N){
                if(vote[number] == 0) count++;
                vote[number]++;
                if (time[number] == 0) time[number] = i;
            } else {
                if(vote[number] > 0) {
                    vote[number]++;
                } else {
                    int min = Integer.MAX_VALUE;
                    int minIndex = 0;
                    int minTime = Integer.MAX_VALUE;
                    for (int j=0; j<101; j++){
                        int v = vote[j];
                        int t = time[j];
                        if (v != 0 && v < min) {
                            minIndex = j;
                            minTime = t;
                            min = v;
                        } else if (v != 0 && v == min &&  t < minTime) {
                            minIndex = j;
                            minTime = t;
                        }
                    }
                    vote[minIndex] = 0;
                    time[minIndex] = 0;
                    vote[number]++;
                    time[number] = i;
                }
            }
        }
        for(int i=0; i<101; i++){
            if(vote[i] > 0) bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

