import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] xcount = new int[10];
        int[] ycount = new int[10];
        for(int i=0; i<X.length(); i++) xcount[X.charAt(i)-'0']++;
        for(int i=0; i<Y.length(); i++) ycount[Y.charAt(i)-'0']++;
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=9; i>=0; i--){
            if(Math.min(xcount[i],ycount[i]) > 0){
                for(int j=0; j<Math.min(xcount[i],ycount[i]); j++) ans.add(i);
            }
        }
        
        for(int i =0; i<ans.size();i++) sb.append(ans.get(i));
        if (sb.toString().equals("")) return "-1";
        else if (sb.toString().startsWith("0")) return "0";
        else return sb.toString();
    }
}
