class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] words = new char[]{'R','T','C','F','J','M','A','N'}; //MBTI 알파벳들
        int[] points= new int[8]; // count
        char currentword = 'A';
        
        for(int i=0; i<survey.length; i++){
            if(choices[i]>=5) currentword=survey[i].charAt(1);
            else currentword=survey[i].charAt(0);
            
            for(int j=0; j<words.length; j++){
                if(words[j]==currentword) points[j]+=Math.abs(choices[i]-4);
            }
        }
        
        if(points[0]>=points[1]) answer+='R';
        else answer +='T';
        
        if(points[2]>=points[3]) answer+='C';
        else answer += 'F';
        
        if(points[4]>=points[5]) answer+='J';
        else answer += 'M';
        
        if(points[6]>=points[7]) answer+='A';
        else answer += 'N';
        
        return answer;
    }
}
