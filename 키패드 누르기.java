class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] right = {4,1}; // 오른손 손가락 위치 # {행,열}
        int[] left = {4,3}; // 왼손 손가락 위치 *
        int[] index = new int[2]; // 숫자의 위치 인덱스 선언.

        for(int i = 0; i < numbers.length; i++) {
            switch(numbers[i]) {
                case 1: case 4: case 7: // 왼손으로 누를 때
                    left[0] = numbers[i] == 1 ? 1 : (numbers[i] == 4 ? 2 : 3);
                    left[1] = 1;
                    answer += 'L';
                    break;
                case 3: case 6: case 9: // 오른손으로 누를 때
                    right[0] = numbers[i] == 3 ? 1 : (numbers[i] == 6 ? 2 : 3);
                    right[1] = 1;
                    answer += 'R';
                    break;
                default: // 가운데 열의 숫자를 누를 때
                    index[0] = numbers[i] == 0 ? 4 : (numbers[i] + 2) / 3;
                    index[1] = 2;
                    double leftlen = Math.abs(index[0] - left[0]) + Math.abs(index[1] - left[1]);
                    double rightlen = Math.abs(index[0] - right[0]) + Math.abs(index[1] - right[1]);
                    if (leftlen < rightlen || (leftlen == rightlen && hand.equals("left"))) {
                        left[0] = index[0];
                        left[1] = index[1];
                        answer += 'L';
                    } else {
                        right[0] = index[0];
                        right[1] = index[1];
                        answer += 'R';
                    }
                    break;
            }
        }
        return answer;
    }
}
