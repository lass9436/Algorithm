import java.io.*;
import java.util.*;

/**
 * String number 를 변환하고 char 반복해서 
 * 새로운 String 을 만들고 원본 숫자를 보관하고
 * 새로운 String 을 사전순으로 정렬하고 숫자로 출력합니다.
 * 
 * map1은 char number -> String number 로 바꿉니다.
 * map2는 String number -> int number 로 바꿉니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = 0;

        StringTokenizer init = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        Map<Character, String> map = new HashMap<>();
        map.put('0', "zero");
        map.put('1', "one");
        map.put('2', "two");
        map.put('3', "three");
        map.put('4', "four");
        map.put('5', "five");
        map.put('6', "six");
        map.put('7', "seven");
        map.put('8', "eight");
        map.put('9', "nine");

        List<String> list = new ArrayList<>();

        Map<String, Integer> map2 = new HashMap<>();

        for(int i=N; i<=M; i++){
            String num = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for(char c : num.toCharArray()){
                String s = map.get(c);
                sb.append(s);
            }
            String result = sb.toString();
            list.add(result);
            map2.put(result, i);
        }

        list.sort(String::compareTo);

        for(int i=0; i<list.size(); i++){
            if(i!=0 && i%10 == 0) bw.newLine();
            bw.write(map2.get(list.get(i)) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

