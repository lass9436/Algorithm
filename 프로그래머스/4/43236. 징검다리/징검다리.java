import java.util.Arrays;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // 바위 정렬

        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int prev = 0;       // 이전 바위 위치
            int removed = 0;    // 제거한 바위 수

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    removed++; // 거리가 짧으면 바위 제거
                } else {
                    prev = rock;
                }
            }

            // 마지막 도착지점까지 거리 확인
            if (distance - prev < mid) {
                removed++;
            }

            if (removed > n) {
                right = mid - 1;
            } else {
                answer = mid;      // 현재 mid로도 가능하면 저장
                left = mid + 1;    // 더 큰 거리도 가능한지 확인
            }
        }

        return answer;
    }
}
