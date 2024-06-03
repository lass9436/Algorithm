import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] segTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read the number of elements N and number of queries M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        segTree = new int[4 * N];

        // Read the array elements
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // Build the segment tree
        buildSegmentTree(0, N - 1, 1);

        // Process each query
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(rangeMinQuery(0, N - 1, a, b, 1)).append('\n');
        }

        // Output all results
        System.out.print(sb.toString());
    }

    // Build the segment tree
    static void buildSegmentTree(int start, int end, int node) {
        if (start == end) {
            segTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildSegmentTree(start, mid, node * 2);
            buildSegmentTree(mid + 1, end, node * 2 + 1);
            segTree[node] = Math.min(segTree[node * 2], segTree[node * 2 + 1]);
        }
    }

    // Query the minimum value in the range [left, right]
    static int rangeMinQuery(int start, int end, int left, int right, int node) {
        // If the range is completely outside the query range
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        }

        // If the range is completely inside the query range
        if (left <= start && end <= right) {
            return segTree[node];
        }

        // If the range is partially inside and partially outside the query range
        int mid = (start + end) / 2;
        return Math.min(rangeMinQuery(start, mid, left, right, node * 2),
                rangeMinQuery(mid + 1, end, left, right, node * 2 + 1));
    }
}
