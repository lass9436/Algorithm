import java.io.*;
import java.util.*;

/**
 * boj 2941 크로아티아 알파벳
 * 크로아티아 변경 후의 문자들을 list 에 넣고
 * 문자열의 크기의 역순으로 탐색했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        String s = br.readLine();


        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");
        list.sort((a, b) -> b.length() - a.length());

        for(String key : list){
            s = s.replaceAll(key, "1");
        }

        bw.write(s.length() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

