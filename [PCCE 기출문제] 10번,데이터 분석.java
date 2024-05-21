import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        String[] str = new String[]{"code","date","maximum","remain"};
        int extindex = 0;
        int sortindex = 0;
    
        for(int j=0; j<str.length; j++) {
            if(ext.equals(str[j])) extindex = j;
            if(sort_by.equals(str[j])) sortindex= j;
        }
        
        for(int i=0;i<data.length; i++){
            if(data[i][extindex]<=val_ext) list.add(data[i]);
        }
        final int num=sortindex;
        Collections.sort(list,(o1,o2)->o1[num]-o2[num]);
        
        return list;
    }
}
