import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * BOJ 1063 킹
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Node king = new Node(st.nextToken());
        Node stone = new Node(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("L", 1);
        map.put("B", 2);
        map.put("T", 3);
        map.put("RT", 4);
        map.put("LT", 5);
        map.put("RB", 6);
        map.put("LB", 7);

        for (int i = 0; i < N; i++) {
            String move = br.readLine();
            move(king, stone, map.get(move));
        }
        
        bw.write(king + "\n");
        bw.write(stone + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static public int[] di = {1, -1, 0, 0, 1, -1, 1, -1};
    static public int[] dh = {0, 0, -1, 1, 1, 1, -1, -1};

    private static void move(Node king, Node stone, int i) {
        int nextIndex = king.index + di[i];
        int nextHeight = king.height + dh[i];
        if(nextIndex < 0 || nextHeight < 0 || nextIndex >= 8 || nextHeight >= 8) return;
        if(stone.index == nextIndex && stone.height == nextHeight) {
            int nextStoneIndex = stone.index + di[i];
            int nextStoneHeight = stone.height + dh[i];
            if(nextStoneIndex < 0 || nextStoneHeight < 0 || nextStoneIndex >= 8 || nextStoneHeight >= 8) return;
            stone.index = nextStoneIndex;
            stone.height = nextStoneHeight;
        }
        king.index = nextIndex;
        king.height = nextHeight;
    }

    public static class Node {
        public int index;
        public int height;

        public Node(String s){
            // 가로
            index = s.charAt(0) - 65;
            // 높이
            height = Integer.parseInt(s.substring(1)) - 1;
        }

        public String toString() {
            char i = (char) (index + 65);
            return String.valueOf(i) + (height+1);
        }
    }
}

