import java.io.*;
import java.util.*;

/**
 * BOJ 21939 문제 추천 시스템 Version 1
 * pq min, pq max, set 을 이용한 풀이 -> 시간초과
 * 시간이 초과가 나서 생각을 해보다가,
 * 어려운 문제 뽑기의 조건과 쉬운 문제 뽑기의 조건이 정확히 반대인 것을 알았습니다.
 * 즉, 같은 조건으로 정렬했을 때
 * 첫 번째 원소가 가장 쉬운 문제이고,
 * 마지막 원소가 가장 어려운 문제라는 것을 알았습니다.
 * 같은 조건으로 TreeSet 에 넣어서 문제를 뽑고 지우면 될 것 같습니다.
 * Tree 구조에서 정렬을 이용하기 위해서 사용자 정의 class Problem 을 정의하고
 * compareTo 를 오버라이드했습니다.
 * solved 메서드에서 찾아서 제거하기 위해서
 * equals 를 오버라이드 했습니다.
 * Hash 도 마찬가지지만, 정렬 조건과 동일성 조건은 일관성이 있어야합니다.
 * 난이도와 이름을 사용해서 compareTo 했으므로, equals 도 난이도와 이름을 가지고 해야합니다.
 * 사실 조금 더 정확히 말하면 index 만 가지고 비교해서 equals 를 해도 되는데
 * 뭐가 어쨌던 비교하는 객체가 난이도를 가지고 있지 않거나 잘못된 난이도를 가지고 있다면
 * Tree 를 Search 할 때 잘못된 트리를 타게 됩니다.
 * 그래서 헷갈리지 않고 잘못된 사용을 피하게 하기 위해서 equals 를 index 와 difficulty 를 둘 다 사용하는 것이 좋을 것 같습니다.
 * 물론 난이도만 제대로 넣어주면 Tree 탐색에 문제가 없으므로 index 만 가지고 비교해도 됩니다.
 * 여기서 중요한 점은, solved 명령어에서 해당 문제의 난이도를 주지 않습니다.
 * 따라서 번호가 있으면 해당 문제의 난이도를 알 수 있어야 하기에 Map 을 사용했습니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeSet<Problem> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Problem problem = new Problem(arr[0], arr[1]);
            set.add(problem);
            map.put(arr[0], arr[1]);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if(method.equals("recommend")) {
                Problem problem;
                if(x == -1) problem = set.first();
                else problem = set.last();
                bw.write( problem.index+ "\n");
            }else if(method.equals("solved")) {
                Problem problem = new Problem(x, map.get(x));
                set.remove(problem);
            }
            else if(method.equals("add")) {
                int y = Integer.parseInt(st.nextToken());
                int[] arr = new int[]{x, y};
                Problem problem = new Problem(arr[0], arr[1]);
                set.add(problem);
                map.put(arr[0], arr[1]);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Problem implements Comparable<Problem> {

        public int index;
        public int difficulty;

        public Problem(int index, int difficulty) {
            this.index = index;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.difficulty == o.difficulty) return this.index - o.index;
            return this.difficulty - o.difficulty;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Problem) {
                Problem other = (Problem) o;
                //return this.index == other.index && this.difficulty == other.difficulty;
                return this.index == other.index;
            }
            return false;
        }
    }
}

