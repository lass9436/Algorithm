import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String answer = "";

        String s = br.readLine();
        int n = s.length();

        for (int i=1; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                StringBuilder a = new StringBuilder(s.substring(0, i)).reverse();
                StringBuilder b = new StringBuilder(s.substring(i, j)).reverse();
                StringBuilder c = new StringBuilder(s.substring(j)).reverse();
                String temp = a.append(b).append(c).toString();
                if(answer.isEmpty()){
                    answer = temp;
                }else{
                    if(answer.compareTo(temp) > 0){
                        answer = temp;
                    }
                }

            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}

