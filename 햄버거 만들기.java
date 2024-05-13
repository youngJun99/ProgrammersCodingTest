// (문자열로 풀기 : 시간초과)
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        String storage = "";
        for(int i = 0; i < ingredient.length; i++) {
            storage += Integer.toString(ingredient[i]);
        }//문자열로 바꾸기
        
        while(storage.contains("1231")) {
            answer += storage.split("1231",-1).length - 1;
            storage = storage.replace("1231", "");
            
        }// 문자열에서 1231 개수 세고 replace..
        
        return answer;
    }
}
// Stack으로 풀기
import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : ingredient){
            stack.push(i);
        
            if(stack.size() >= 4                    //4개 기준부터 count
            && stack.get(stack.size() - 1) == 1    
            && stack.get(stack.size() - 2) == 3     
            && stack.get(stack.size() - 3) == 2    
            && stack.get(stack.size() - 4) == 1     
            ){
                answer++;
                stack.pop();    //조합되면 제거..
                stack.pop();    
                stack.pop();    
                stack.pop();    
            }
        }
        
        return answer;
    }
}
