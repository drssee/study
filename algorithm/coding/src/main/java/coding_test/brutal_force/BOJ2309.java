package coding_test.brutal_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BOJ2309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> nine = new ArrayList<>();
        //20
        //7
        //23
        //19
        //10
        //15
        //25
        //8
        //13
        for(int i=0;i<9;i++){
            nine.add(input());
        }
        List<Integer> seven = boj2309(nine);
        Collections.sort(seven);
        seven.forEach(s-> System.out.println(s));
    }

    public static int input() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static List<Integer> boj2309(List<Integer> nine){
        //난쟁이 두명을 제외할 모든 경우의 수를 생각
        for(int i=0;i<nine.size();i++){
            for(int j=0;j<nine.size();j++){
                if(nine.get(i).equals(nine.get(j))) continue;
                List<Integer> seven = new ArrayList<>(nine);
                seven.remove(nine.get(i));
                seven.remove(nine.get(j));
                Optional<Integer> result = seven.stream().reduce((a, b) -> a + b);
                if(result.get().equals(100)) return seven;
            }
        }
        return null;
    }
}
