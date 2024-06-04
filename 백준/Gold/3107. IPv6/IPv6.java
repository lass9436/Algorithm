import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Pattern p = Pattern.compile("[0-9a-f]+");
        Matcher m = p.matcher(s);
        int count = 0;
        while (m.find()) count++;

        int colon = 8 - count;

        String answer = "";

        Pattern p1 = Pattern.compile("[0-9a-f]+|:{2}");
        Matcher m1 = p1.matcher(s);
        while (m1.find()) {
            String match = m1.group();
            String temp = "";
            if(!match.equals("::")){
                while(match.length()<4) match = "0" + match;
                match += ":";
            }else{
                while(colon-- > 0){
                    temp += "0000:";
                }
                match = temp;
            }
            answer += match;
        }

        answer = answer.substring(0, answer.length()-1);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

