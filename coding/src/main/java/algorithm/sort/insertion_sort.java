package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class insertion_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach((i)->{
            list.add((int)(Math.random()*100)+1);
        });
        System.out.println(new insertion_sort().insertionSort(list));
    }
    public List<Integer> insertionSort(List<Integer> list){
        for(int i=1;i<list.size();i++){
            for(int j=i;j>0;j--){
                if(list.get(j-1)>list.get(j)){
                    Collections.swap(list,j-1,j);
                } else{
                    break;
                }
            }
        }
        return list;
    }
}
