package coding_test.programmers;

import java.util.*;

class num4 {
    public static void main(String[] args) {
//        int[] food = new int[]{1,3,4,6};
        int[] food = new int[]{1,7,1,2};
        new num4().solution(food);
    }
    public String solution(int[] food) {
        List<Integer> foodList = new ArrayList<>();
        foodList.add(0);
        for(int i=food.length-1;i>0;i--){
            if(food[i]<2){
                continue;
            }
            else if(food[i]%2!=0){
                food[i]=food[i]-1;
            }
            for(int j=0;j<food[i];j++){
                if(j%2==0){
                    foodList.add(0,i);
                } else{
                    foodList.add(foodList.size(),i);
                }
            }
        }//for
        StringBuilder answer = new StringBuilder();
        for (Integer i : foodList) {
            answer.append(i);
        }
        return answer.toString();
    }
}
