import java.util.*;

class Solution {
    
    public Map<String, List<String>> map;
    public List<String> answer_list = new ArrayList<>();
    public String[] answer;
    public boolean isDone = false;
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        for(String[] ticket : tickets){
            String start = ticket[0];
            String end = ticket[1];
            if(!map.containsKey(start)){
                map.put(start, new ArrayList<>());
            }
            List<String> list = map.get(start);
            list.add(end);
        }
        
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            list.sort((a, b) -> {return a.compareTo(b);});
        }
        
        answer_list.add("ICN");
        dfs("ICN");
        
        return answer;
    }
    
    public void dfs(String start){
        if(isDone){
            return;
        }
        if(check()){
            answer = answer_list.toArray(new String[0]);
            isDone = true;
            return;
        }
        if(!map.containsKey(start)){
            return;
        }
        List<String> list = map.get(start);
        int n = list.size();
        for(int i=0; i<n; i++){
            String s = list.get(i);
            list.remove(i);
            answer_list.add(s);
            dfs(s);
            answer_list.remove(answer_list.size()-1);
            list.add(i, s);
        }
    }
    
    public boolean check(){
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            if(!list.isEmpty()){
                return false;
            }
        }
        return true;
    }
}