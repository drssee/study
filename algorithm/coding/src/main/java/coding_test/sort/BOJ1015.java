package coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A;
    static Map<Integer, List<Integer>> B_idx = new HashMap<>();
    static int[] B;

    public static void main(String[] args) throws IOException {
        //N개
        //A P B
        //B[P[i]] = A[i] <- B[P[i](순서 인덱스 값)] = A[i]
        //A는 정렬이 안된 배열
        //B는 정렬이 된 배열
        //P는 B에 정렬된 A배열값의 순서인덱스
        input();
        boj1015();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void boj1015(){
        B = Arrays.copyOfRange(A,0,A.length);
        Arrays.sort(B);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<B.length;i++){
            if(B_idx.containsKey(B[i])){
                //중복값 처리
                //중복일시 이미 초기화된 리스트에 인덱스값 추가
                B_idx.get(B[i]).add(i);
            } else {
                List<Integer> idxs = new ArrayList<>();
                idxs.add(i);
                B_idx.put(B[i],idxs);
            }
        }
        for(int i=0;i<N;i++){
            sb.append(B_idx.get(A[i]).remove(0)).append(" ");
        }
        System.out.println(sb);
    }
}
