package coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ5576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> W = new ArrayList<>();
    static List<Integer> K = new ArrayList<>();
    static List<Integer> resultW = new ArrayList<>();
    static List<Integer> resultK = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        input();
        Collections.sort(W);
        Collections.sort(K);
        for(int i=0;i<3;i++){
            resultW.add(W.get(W.size()-i-1));
        }
        for(int i=0;i<3;i++){
            resultK.add(K.get(K.size()-i-1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(resultW.stream().reduce((a,b)->a+b).get()).append(" ").append(resultK.stream().reduce((a,b)->a+b).get());
        System.out.println(sb);
    }

    public static void input() throws IOException {
        for(int i=0;i<20;i++){
            if(i<10){
                W.add(Integer.parseInt(br.readLine()));
            } else {
                K.add(Integer.parseInt(br.readLine()));
            }
        }
    }
}
