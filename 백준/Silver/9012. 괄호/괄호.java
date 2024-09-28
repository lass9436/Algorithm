import java.io.*;
import java.util.*;

public class Main{
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            test();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void test() throws IOException{
        char[] chars = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : chars){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            
            char pre = stack.peek();
            if(pre == '(' && c == ')'){
                stack.pop();
                continue;
            }
            
            stack.push(c);
        }
        
        if(stack.isEmpty()){
            bw.write("YES\n");
        }else{
            bw.write("NO\n");
        }
    }
}
