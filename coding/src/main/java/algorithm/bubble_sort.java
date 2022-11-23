package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bubble_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6);
        System.out.println(new bubble_sort().bubbleSort(list));
    }
    public List<Integer> bubbleSort(List<Integer> list){
        for(int i=0;i<list.size();i++){
            boolean swap = false;
            for(int j=1;j<list.size()-i;j++){
                if(list.get(j-1)>list.get(j)){
                    Collections.swap(list,j-1,j);
                    swap=true;
                }
            }
            if (!swap){
                break;
            }
        }


        return list;
    }
}
