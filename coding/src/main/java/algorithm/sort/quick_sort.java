package algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class quick_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach((i)->{
            list.add((int)(Math.random()*100)+1);
        });
        System.out.println(new quick_sort().quickSort(list));
    }

    public List<Integer> quickSort(List<Integer> list){
        if(list.size()<=1){
            return list;
        }

        int pivot = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mergedList = new ArrayList<>();

        for(int i=1;i<list.size();i++){
            int data = list.get(i);
            if(data<pivot){
                left.add(data);
            }
            else {
                right.add(data);
            }
        }//for

        mergedList.addAll(quickSort(left));
        mergedList.add(pivot);
        mergedList.addAll(quickSort(right));

        return mergedList;
    }
}
