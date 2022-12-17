package coding_test.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Long> cards = new ArrayList<>();
    //결과
    static long result;
    //결과의 갯수
    static long resultCnt;
    //탐색중인 card 숫자의 갯수
    static long curCnt;

    public static void main(String[] args) throws IOException {
        //N개의 카드 중에 가장 많은 갯수의 카드를 구하라(갯수가 같을시 더 작은값을 출력)
        //1.입력받은 카드를 정렬
        //2.인접한 값을 확인
        //3.결과저장 배열 초기화
        input();
        boj11652();
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            cards.add(Long.parseLong(br.readLine()));
        }
    }

    public static void boj11652(){
        Collections.sort(cards);
        result = cards.get(0);
        resultCnt = 1;
        curCnt = 1;
        for(int i=1;i<N;i++){ //1 2 3 4
            long prev = cards.get(i-1);
            long cur = cards.get(i);
            if(prev==cur){
                curCnt++;
            } else {
                curCnt = 1;
            }
            //같을 경우는 정렬된 cards라 더 작은값이 우선순위가 있으니 체크 안해줘도 됨
            if(curCnt>resultCnt) {
                result = cards.get(i);
                resultCnt = curCnt;
            }
        }//for
        System.out.println(result);
    }
}
