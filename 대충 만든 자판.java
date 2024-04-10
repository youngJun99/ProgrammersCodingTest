import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                if(!dict.containsKey(keymap[i].charAt(j))) dict.put(keymap[i].charAt(j),j+1);
                if(dict.containsKey(keymap[i].charAt(j)) && dict.get(keymap[i].charAt(j))>j+1) dict.put(keymap[i].charAt(j),j+1);
            }
        }
        
        int count=0;
        for(int i=0; i<targets.length;i++){
            count=0;
            for(int j=0; j<targets[i].length();j++){
                if(dict.containsKey(targets[i].charAt(j))) count+=dict.get(targets[i].charAt(j));
                else{
                    answer[i]=-1;
                    break;
                }
                if(j==targets[i].length()-1) answer[i]=count;
            }
        }
        return answer;
    }
}
