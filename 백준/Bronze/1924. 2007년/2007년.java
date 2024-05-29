import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 1924 문제
 *
 * 입력 : M월 N일
 * 출력 : 요일
 *
 * 풀이 :
 * 각 달의 해당하는 마지막 날을 하드코딩하고,
 * M의 입력이 들어오면 1 부터 M-1 까지 순회하여 지나온 달의 일수를 더하고
 * N을 더해서 최종 일수를 구하여 7로 나눈 나머지에 각 요일을 매칭시키면 될 것 같습니다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1월부터 12월까지 마지막 날짜
        int[] monthLastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysOfTheWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        StringTokenizer init = new StringTokenizer(br.readLine());

        // 달
        int month = Integer.parseInt(init.nextToken());
        // 일
        int day = Integer.parseInt(init.nextToken());

        int sumDay = 0;

        for(int i=0; i<month; i++){
            sumDay += monthLastDay[i];
        }

        sumDay += day;
        String answer = daysOfTheWeek[sumDay % 7];

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}