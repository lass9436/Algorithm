import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] s = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();

        List<Character> list = new ArrayList<>();
        
        int blen = bomb.length;

        for(char c : s){
            list.add(c);
            if(list.size() >= blen){
                int len = list.size();
                boolean flag = true;
                for(int j = 0; j < blen; j++){
                    char c1 = list.get(len - blen + j);
                    char c2 = bomb[j];
                    if(c1 != c2) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j < blen; j++) list.remove(list.size()-1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        if(sb.length() > 0) bw.write(sb.toString());
        else bw.write("FRULA");

        bw.flush();
        bw.close();
        br.close();
    }
}

