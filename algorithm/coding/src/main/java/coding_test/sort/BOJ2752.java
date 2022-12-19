package coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2752 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();
        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
    }
}
