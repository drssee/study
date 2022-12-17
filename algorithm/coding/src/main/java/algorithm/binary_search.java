package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class binary_search {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(list::add);
        System.out.println("list = " + list);
        System.out.println(new binary_search().binarySearch(list,70));
    }

    public boolean binarySearch(List<Integer> list, int search_data){
        //사이즈가1일때
        if(list.size()==1&&list.get(0).equals(search_data)){
            return true;
        }
        if(list.size()==1&&!list.get(0).equals(search_data)){
            return false;
        }

        //사이즈가0일때
        if(list.isEmpty()){
            return false;
        }

        //사이즈가2이상일때
        int medium = list.get(list.size()/2);
        if(medium==search_data){
            return true;
        } else if(search_data<medium){
            return binarySearch(list.subList(0,list.size()/2),search_data);
        } else {
            return binarySearch(list.subList(list.size()/2,list.size()),search_data);
        }
    }
}
