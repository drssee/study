import java.util.Arrays;

public class num2 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
}

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int length = score.length;
        //박스 개수
        int boxCnt = length/m;
        Arrays.sort(score);
        for(int i=1;i<=boxCnt;i++){
//            int[] box = Arrays.copyOfRange(score,length-(m*i),length-(m*(i-1)));
//            answer+=box[0]*m;
            answer+=Arrays.copyOfRange(score,length-(m*i),length-(m*(i-1)))[0]*m;
        }
        return answer;
    }
}
