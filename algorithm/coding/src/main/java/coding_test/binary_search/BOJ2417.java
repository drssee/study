package coding_test.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ2417 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long n;
    static long left;
    static long right;
    static long q;

    public static void main(String[] args) throws IOException {
        input();
        sol();
        System.out.println(q);
    }

    public static void input() throws IOException {
        n = Long.parseLong(br.readLine());
    }

    public static void sol(){
        left=0;
        right=n-1;
        while(left<=right){
            long mid = (left+right)/2;
            BigInteger bigMid = BigInteger.valueOf(mid);
            //구하려는 '정수' q는
            //n의제곱근과 같거나 가장가까운 큰수
//            if(mid<Math.sqrt(n)){
            if(bigMid.multiply(bigMid).compareTo(BigInteger.valueOf(n))<0){
                //n의제곱근보다 작은값이면
                //m의 왼쪽은 볼 필요도 없음
                left = mid+1;
            } else {
                //n의 제곱근보다 큰값이면
                //m의 오른쪽은 볼 필요도 없음
                right = mid-1;
            }
        }//while
        //반복문을 통과한 left는
        //n의 제곱근에 가장 가까운 수
        q=left;
    }
}
