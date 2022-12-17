package BOJ.brutal_force;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650_4 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    static int N, M;
    static int[] selected, used;

    static void rec_func(int k) {
        if(k==M+1 ){
            for(int i=1;i<=M;i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else{
            int start = selected[k-1];
            if(start == 0) start=1;
            for(int cand = selected[k-1]+1;cand<=N;cand++){
                selected[k] = cand;
                rec_func(k+1);
                selected[k]=0;
            }
        }
    }

    public static void main(String[] args) {
        //N개의 숫자를 M의 자릿수만큼 표현
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        public int nextInt() {
            try {
                return Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("입력 오류");
            }
        }
    }
}
