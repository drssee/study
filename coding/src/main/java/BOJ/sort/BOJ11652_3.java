package BOJ.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11652_3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static long[] a;

    public static void main(String[] args) {

    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        a = new long[N+1];
        for(int i=1;i<=N;i++){
            a[i] = Long.parseLong(br.readLine());
        }
    }

    static void pro() {
        //배열 정렬
        Arrays.sort(a,1,N+1);

        //result , resultCnt , curCnt
        long result = a[1];
        int resultCnt = 1;
        int curCnt = 1;

        //2번째 원소부터 차례대로 보면서 , 같은 숫자가 계속 나오고 있는지 , 새로나온 숫자인지 판단
        for(int i=2;i<=N;i++){
            if(a[i-1]==a[i]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if(resultCnt<curCnt) {
                result = a[i];
                resultCnt = curCnt;
            }
        }

        //정답출력
        System.out.println(result);
    }
}
