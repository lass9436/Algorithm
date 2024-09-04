import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(String c : cmd){
            char cc = c.charAt(0);    
            if(cc == 'U'){
                int x = Integer.parseInt(c.substring(2));
                k-=x;
            }else if(cc == 'D'){
                int x = Integer.parseInt(c.substring(2));
                k+=x;
            }else if(cc == 'C'){
                deque.push(k);
                if(n-1==k) k--;
                n--;
            }else{ // Z
                int x = deque.pop();
                if(x<=k) k++;
                n++;
            }
        }   
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("O");
        }
        while(!deque.isEmpty()){
            int x = deque.pop();
            sb.insert(x, "X");
        }
        return sb.toString();
    }
}