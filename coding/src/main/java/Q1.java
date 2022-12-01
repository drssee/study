import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
//        nums.add(2);
//        nums.add(7);
//        nums.add(11);
//        nums.add(15);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        System.out.println(new Q1().twoSum(nums,6));
    }

    public List<Integer> twoSum(List<Integer> nums,int target){
        List<Integer> result = new ArrayList<>();
        //n2
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i==j){
                    continue;
                }
                if((nums.get(i)+nums.get(j))==target){

                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }
}
