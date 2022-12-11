package brutal_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = input();
        boj2231(N,1);
    }

    public static int input() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void boj2231(int N, int K) {
        boolean hasM = false;
        //K부터 완전탐색을 시작한다
        for(int i=K;i<=N;i++){
            String temp = String.valueOf(i);
            int result = i;
            for(int j=0;j<temp.length();j++){
                result+=Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
            if(N==result){
                System.out.println(i);
                hasM=true;
                break;
            }
        }
        if(!hasM) {
            System.out.println(0);
        }
    }
}
