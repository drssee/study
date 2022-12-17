package algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class merge_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach((i)->{
            list.add((int)(Math.random()*100)+1);
        });
        System.out.println(new merge_sort().mergeSort(list));
    }

    public List<Integer> mergeSort(List<Integer> list){

        //split
        if(list.size()<=1){
            return list;
        }
        int splitIdx = list.size()/2;
        List<Integer> left = list.subList(0,splitIdx);
        List<Integer> right = list.subList(splitIdx,list.size());

        //merge&sort
        return mergeSort_ms(mergeSort(left), mergeSort(right));
    }

    public List<Integer> mergeSort_ms(List<Integer> left,List<Integer> right){
        int lp = 0;
        int rp = 0;
        List<Integer> mergedList = new ArrayList<>();
        while(true){
            //포인터가 둘다 살아있을때
            if(lp<left.size()&&rp<right.size()){
                //left==right
                if(left.get(lp).equals(right.get(rp))){
                    mergedList.add(left.get(lp));
                    lp++;
                    mergedList.add(right.get(rp));
                    rp++;
                }
                //left<right
                else if(left.get(lp)<right.get(rp)){
                    mergedList.add(left.get(lp));
                    lp++;
                }
                //right<left
                else if(right.get(rp)<left.get(lp)){
                    mergedList.add(right.get(rp));
                    rp++;
                }
            }
            //한쪽 포인터만 살아있을때
            else if(lp<left.size()){
                mergedList.add(left.get(lp));
                lp++;
            }
            else if(rp<right.size()){
                mergedList.add(right.get(rp));
                rp++;
            }
            //포인터가 다 종료되었을때
            else {
                break;
            }
        }
        return mergedList;
    }
}
