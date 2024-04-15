class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char word ;
        for(int i=0; i< s.length(); i++){
            word=s.charAt(i);
            for(int j=0; j<index; j++){
                word++;
                if(word > 'z') word -= 26;
                if(skip.contains(String.valueOf(word))) j--;
            }
            answer+=word;
        }
        return answer;
    }
}
