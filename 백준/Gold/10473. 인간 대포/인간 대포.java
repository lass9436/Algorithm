import java.io.*;
import java.util.*;

/**
 * BOJ 10473 인간 대포
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double[] start = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] end = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int N = Integer.parseInt(br.readLine());
        double[][] cannons = new double[N][2];
        for (int i = 0; i < N; i++) cannons[i] = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        HashMap<Node, Double> visited = new HashMap<>();
        for (int i = 0; i < N; i++) visited.put(new Node(cannons[i]), Double.MAX_VALUE);
        visited.put(new Node(start), (double) 0);
        visited.put(new Node(end), Double.MAX_VALUE);
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[2]));
        pq.offer(new double[]{start[0], start[1], 0, 1});
        while(!pq.isEmpty()){
            double[] cur = pq.poll();
            double x = cur[0];
            double y = cur[1];
            double t = cur[2];
            if(visited.get(new Node(x, y)) < t) continue;
            for(int i = 0; i < cannons.length; i++){
                double[] cannon = cannons[i];
                if((int)cannon[0] == (int)x && (int)cannon[1] == (int)y) continue;
                double time = calculate(cur, cannon);
                if (visited.get(new Node(cannon)) <= time) continue;
                visited.put(new Node(cannon), time);
                pq.offer(new double[]{cannon[0], cannon[1], time, 0});
            }
            double time = calculate(cur, end);
            if (visited.get(new Node(end)) <= time) continue;
            visited.put(new Node(end), time);
            pq.offer(new double[]{end[0], end[1], time, 0});
        }

        bw.write(visited.get(new Node(end)) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node {
        public double x;
        public double y;

        public Node (double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Node (double[] arr){
            this.x = arr[0];
            this.y = arr[1];
        }

        @Override
        public int hashCode(){
            return Objects.hash((int)x, (int)y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return (int) x == (int) node.x && (int) y == (int) node.y;
        }
    }

    public static double calculate(double[] cur, double[] next){
        double time = cur[2];
        if(cur[3] == 1){
            double distance = Math.sqrt(Math.pow(cur[0] - next[0], 2) + Math.pow(cur[1] - next[1], 2));
            time += distance / (double) 5;
        }else{
            double distance = Math.abs(Math.sqrt(Math.pow(cur[0] - next[0], 2) + Math.pow(cur[1] - next[1], 2)) - 50);
            time += distance / (double) 5 + 2;
        }
        return time;
    }


}

