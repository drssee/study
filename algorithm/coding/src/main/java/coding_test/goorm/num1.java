package coding_test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A;
    static int B;
    static int D;

    public static void main(String[] args) throws IOException {
        //A B 번갈아가며 자신의 절반씩
        //단 홀수를 넘겨줄경우 몫+나머지
        //D 번째날의 A B의 식량 갯수
        input();
        sol();
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(br.readLine());
    }

    public static void sol(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<D;i++){
            if(i%2==0){
                //A
                B += A/2 + A%2;
                A = A/2;
            } else {
                //B
                A += B/2 + B%2;
                B = B/2;
            }
        }
        sb.append(A).append(" ").append(B);
        System.out.println(sb);
    }
}
