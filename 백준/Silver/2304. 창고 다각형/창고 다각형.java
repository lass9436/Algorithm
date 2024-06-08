import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 2304 창고 다각형
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        ArrayDeque<Pillar> arrayDeque = new ArrayDeque<>();
        List<Pillar> pillars = new ArrayList<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Pillar pillar = new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pillars.add(pillar);
        }

        pillars.sort((a, b) -> a.index - b.index);

        for(Pillar pillar : pillars) {
            if(arrayDeque.isEmpty()) arrayDeque.push(pillar);
            else{
                while(!arrayDeque.isEmpty() && arrayDeque.peek().height <= pillar.height){
                    if(arrayDeque.size() > 1) arrayDeque.pop();
                    else {
                        Pillar first = arrayDeque.pop();
                        int height = first.height;
                        int width = pillar.index - first.index;
                        int area = height * width;
                        answer += area;
                    }
                }
                arrayDeque.push(pillar);
            }
        }

        while(arrayDeque.size() > 1) {
            Pillar pillar = arrayDeque.pop();
            Pillar first = arrayDeque.peek();
            int height = pillar.height;
            int width = pillar.index - first.index;
            int area = height * width;
            answer += area;
        }

        answer += arrayDeque.pop().height;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Pillar {
        public int index;
        public int height;
        public Pillar(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

