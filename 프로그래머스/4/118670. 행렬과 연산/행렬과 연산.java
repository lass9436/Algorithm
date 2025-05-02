import java.util.*;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int n = rc.length;
        int m = rc[0].length;
        int[][] answer = new int[n][m];
        
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Deque<Integer>> center = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            left.addLast(rc[i][0]);
            right.addLast(rc[i][m-1]);
            Deque<Integer> row = new ArrayDeque<>();
            for(int j=1; j<m-1; j++){
                row.addLast(rc[i][j]);
            }
            center.addLast(row);
        }
        
        for(String op : operations){
            if(op.equals("Rotate")){
                rotate(left, center, right);
            }
            if(op.equals("ShiftRow")){
                shift(left, center, right);
            }
        }
        
        for(int i=0; i<n; i++){
            answer[i][0] = left.pollFirst();
            answer[i][m-1] = right.pollFirst();
            Deque<Integer> row = center.pollFirst();
            for(int j=1; j<m-1; j++){
                answer[i][j] = row.pollFirst();
            }
        }
        
        return answer;
    }
    
    public void rotate(Deque<Integer> left, Deque<Deque<Integer>> center, Deque<Integer> right){
        center.peekLast().addLast(right.pollLast());
        left.addLast(center.peekLast().pollFirst());
        center.peekFirst().addFirst(left.pollFirst());
        right.addFirst(center.peekFirst().pollLast());
    }
    
    public void shift(Deque<Integer> left, Deque<Deque<Integer>> center, Deque<Integer> right){
        left.addFirst(left.pollLast());
        center.addFirst(center.pollLast());
        right.addFirst(right.pollLast());
    }
    
}