package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1015_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Elem[] B;
    static int[] P;

    public static void main(String[] args) throws IOException {
        //A P B
        input();
        pro();
    }

    static class Elem implements Comparable<Elem> {
        public int idx;
        public int num;

        @Override
        public int compareTo(Elem o) {
            if(num!=o.num) {
                return num - o.num;
            }
            return idx - o.idx;
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        B = new Elem[N];
        P = new int[N];
        for(int i=0;i<N;i++){
            B[i] = new Elem();
            B[i].num = Integer.parseInt(br.readLine());
            B[i].idx = i;
        }
    }

    static void pro() {
        //1. B 배열 정렬
        Arrays.sort(B);
        //2. B 배열 값을 이용해서 P 배열 채우기
        for(int i=0;i<N;i++){
            P[B[i].idx] = i;
        }
        //3. P 배열 출력하기
        System.out.println(Arrays.toString(P));
    }
}
