import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * BOJ 1461 도서관
 *
 * 제일 먼 M 개의 책을 마지막에 하는 것이 핵심이다.
 * 그리고 양수와 음수를 분리해서 생각해도 상관없을 듯 하다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = init[0];
        M = init[1];
        int[] books = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Collections.reverseOrder());
        int minus = 0;
        int max = 0;
        for(int book : books){
            max = Math.max(max, book);
            minus = Math.min(minus, book);
            if(book > 0) pqMin.add(book);
            else pqMax.add(book);
        }
        answer = 0;
        if(Math.abs(minus) < max){
            minus();
            plus();
        }else{
            plus();
            minus();
        }

        bw.write(answer - Math.abs(book) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int N, M, book, answer = 0;
    public static PriorityQueue<Integer> pqMin, pqMax;
    public static void plus(){
        while(!pqMin.isEmpty()){
            int count = pqMin.size() % M;
            if (count == 0) count = M;
            book = 0;
            for (int i=0; i<count; i++) book = pqMin.poll();
            answer += book * 2;
        }
    }
    public static void minus(){
        while(!pqMax.isEmpty()){
            int count = pqMax.size() % M;
            if (count == 0) count = M;
            book = 0;
            for (int i=0; i<count; i++) book = pqMax.poll();
            answer += Math.abs(book) * 2;
        }
    }
}

