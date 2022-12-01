package programmers;

import java.util.*;

class num5 {
    static int result = 0;

    public static void main(String[] args) {
//        int[] ingredient = new int[]{1,2,3,1};
        int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 3, 3, 3, 3, 1, 2, 3, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 2, 3, 3, 3, 1};
//        int[] ingredient = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 2, 3, 3, 3, 1};
        System.out.println("result = "+new num5().solution(ingredient));
    }

    public int solution(int[] ingredient) {
        int[] hamburger = new int[]{1,2,3,1};
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.stream(ingredient).forEach(i->{
            linkedList.add(i);
        });
        hamburgerCnt(linkedList,hamburger,0);
        int answer = result;
        return answer;
    }

    public void hamburgerCnt(LinkedList<Integer> ingredient,int[] hamburger,int startIdx){
        if(ingredient.size()<4||startIdx>=ingredient.size()){
            return;
        }
        int hIdx = 0;
        for(int i=startIdx;i<ingredient.size();i++){
            if(ingredient.get(i)==hamburger[hIdx]){
                hIdx++;
                if(hIdx!=4){
                    continue;
                }
            }
            else if (ingredient.get(i)!=hamburger[hIdx]){
                if(ingredient.get(i)==1){
                    hIdx=1;
                } else{
                    hIdx=0;
                }
            }

            if(hIdx==4){
                result++;
                //i-3~i
                //배열을 지울때는 앞에서부터 지울시 인덱스 오류 발생, 뒤에서부터 삭제해야함
                for(int j=i;j>=i-3;j--){
                    ingredient.remove(j);
                }
                hamburgerCnt(ingredient,hamburger,0);
                return;
            }
        }
    }
}
