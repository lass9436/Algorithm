import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * BOJ 1213 팰린드롬 만들기
 * 
 * 홀수가 2개 이상이면 팰린드롬이 불가능합니다.
 * 홀수가 1개일 때 중앙에 두고,
 * 나머지를 char 의 역순으로 중앙의 앞 뒤로 넣습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String s = br.readLine();

        Map<Character, Integer> map = new TreeMap<>((a, b) -> b - a);
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        char mid = '0';

        for(char c : map.keySet()) {
            int count = map.get(c);
            if(count % 2 == 1) {
                oddCount++;
                mid = c;
            }
        }

        if(oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();

        if(oddCount == 1) {
            sb.append(mid);
            map.put(mid, map.get(mid) - 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int iter = entry.getValue()/2;
            for(int i=0; i<iter; i++) {
                sb.insert(0, entry.getKey()).append(entry.getKey());
            }
        }

        System.out.println(sb);
        br.close();
    }
}

