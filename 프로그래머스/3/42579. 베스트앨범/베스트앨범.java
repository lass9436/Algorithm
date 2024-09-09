import java.util.*;

class Solution {
    
    class Genre {
        public String name;
        public int play;
        
        public Genre(String name, int play){
            this.name = name;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map_list = new HashMap<>();
        Map<String, Integer> map_count = new HashMap<>();
        
        int n = genres.length;
        
        for(int i=0; i<n; i++){
            int number = i;
            String genre = genres[i];
            int play = plays[i];
            map_count.put(genre, map_count.getOrDefault(genre, 0) + play);
            if(!map_list.containsKey(genre)){
                map_list.put(genre, new ArrayList<>());
            }
            List<int[]> list = map_list.get(genre);
            list.add(new int[]{i, play});
        }
        
        List<Genre> genre_list = new ArrayList<>();
        
        for(String genre : map_count.keySet()){
            int play = map_count.get(genre);
            Genre g = new Genre(genre, play);
            genre_list.add(g);
        }
        
        genre_list.sort((a, b) -> b.play - a.play);
        
        List<Integer> ans = new ArrayList<>();
        
        for(Genre g : genre_list){
            List<int[]> list = map_list.get(g.name);
            
            list.sort((a, b) -> {
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            
            int l = Math.min(2, list.size());
            for(int i=0; i<l; i++){
                int[] w = list.get(i);
                ans.add(w[0]);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}