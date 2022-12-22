package coding_test.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ7795 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;
    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();
    static int N;
    static int M;
    static int result=0;
    static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //A>B 경우
        boj7795();
        for (Integer integer : results) {
            System.out.println(integer);
        }
    }

    public static void boj7795() throws IOException {
        //input + logic
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                B.add(Integer.parseInt(st.nextToken()));
            }
            sol();
        }
    }

    public static void sol(){
        //A,B 입력받은 후 B를 정렬
        Collections.sort(B); //nlogn
        //A의 각 요소를 정렬된 B에 이분탐색(?) 뒤
        for(int i=0;i<A.size();i++){
            int elemA = A.get(i);
            binarySearch(elemA);
        }
        //정답 저장
        results.add(result);
        //A,B,result 초기화
        A.clear();
        B.clear();
        result = 0;
    }

    public static void binarySearch(int X){
        int left = 0;
        int right = B.size()-1;
        while(left<=right){
            int M = (left+right)/2;
            if(B.get(M)<X){
                left = M+1;
            } else {
                right = M-1;
            }
        }//while
        result += left;
    }
}
