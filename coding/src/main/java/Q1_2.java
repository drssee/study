import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1_2 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(7);
        nums.add(11);
        nums.add(15);
//        nums.add(3);
//        nums.add(2);
//        nums.add(4);
        System.out.println(new Q1().twoSum(nums,9));
    }

    public List<Integer> twoSum(List<Integer> nums,int target){
        //맵의 키 = 값 , 맵의 value = target-값
        int idx = 0;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            map.put(nums.get(idx),target-nums.get(idx));
            if(nums.get(i).equals(map.get(nums.get(idx)))){
                result.add(i);
                result.add(idx);
                return result;
            }
            idx++;
        }
        return result;
    }
}
