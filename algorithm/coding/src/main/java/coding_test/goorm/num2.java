package coding_test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class num2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static List<Long> X = new ArrayList<>();
    static List<Long> Y = new ArrayList<>();
    static List<Long> N = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        //T번만큼
        //(X,Y)좌표에 N초에 도달할 수 있는지
        input();
        sol();
    }

    public static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            X.add(Long.parseLong(st.nextToken()));
            Y.add(Long.parseLong(st.nextToken()));
            N.add(Long.parseLong(st.nextToken()));
        }
    }

    public static void sol(){
        StringBuilder sb = new StringBuilder();
        //X Y N 을 이용해서 T번 만큼 반복하며 YES or NO 체크
        for(int i=0;i<T;i++){
            //체크로직
            //0,0 -> X,Y N초
            //X,Y까지 N초만에 갈 경우가 없는지 체크?
            long x = Math.abs(X.get(i));
            long y = Math.abs(Y.get(i));
            long xy = x+y;
            if(xy%2==0){
                //x+y가 짝수
                if(N.get(i)%2!=0){ //x+y는 짝수지만 n은 홀수
                    System.out.println("NO");
                } else { //x+y도 짝수 n도 짝수
                    if(xy<=N.get(i)){
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            } else {
                //x+y가 홀수
                if(N.get(i)%2==0){ //x+y는 홀수지만 n은 짝수
                    System.out.println("NO");
                } else { //x+y도 홀수 n도 홀수
                    if(xy<=N.get(i)){
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }
}
