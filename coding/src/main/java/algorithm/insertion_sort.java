package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class insertion_sort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach((i)->{
            list.add((int)(Math.random()*100)+1);
        });
    }

}
