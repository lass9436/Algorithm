import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= M; i++) {
            StringTokenizer command = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(command.nextToken());
            int number = Integer.parseInt(command.nextToken());

            if(gender == 1){
                int next = number;
                while(next <= N){
                    arr[next] = (arr[next] + 1)%2;
                    next += number;
                }
            } else if(gender == 2){
                arr[number] = (arr[number] + 1)%2;
                int left = number;
                int right = number;
                while(1<= --left && ++right <= N){
                    if(arr[left] == arr[right]){
                        arr[left] = (arr[left] + 1)%2;
                        arr[right] = (arr[right] + 1)%2;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(i != 0 && i % 20 == 0) bw.write("\n");
            bw.write(arr[i+1] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

