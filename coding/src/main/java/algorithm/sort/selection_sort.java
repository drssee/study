package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class selection_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach((i)->{
            list.add((int)(Math.random()*100)+1);
        });
        System.out.println(new selection_sort().selectionSort(list));
    }

    public List<Integer> selectionSort(List<Integer> list){
        for(int i=0;i<list.size();i++){
            int min = i;
            for(int j=i+1;j<list.size();j++){
                if(list.get(j)<list.get(min)){
                    min=j;
                }
            }
            if(min!=i){
                Collections.swap(list,i,min);
            }
        }
        return list;
    }
}
