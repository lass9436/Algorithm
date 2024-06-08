import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ PPAP
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(char c : chars) {
            list.add(c);
            if (4 <= list.size()) {
                StringBuilder sb = new StringBuilder();
                for (int j = list.size() - 4; j < list.size(); j++) {
                    sb.append(list.get(j));
                }
                String str = sb.toString();
                if (str.equals("PPAP")) {
                    for (int j = 0; j < 3; j++) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        String str = sb.toString();

        if (str.equals("P")) bw.write("PPAP");
        else bw.write("NP");
        bw.flush();
        bw.close();
        br.close();
    }
}

