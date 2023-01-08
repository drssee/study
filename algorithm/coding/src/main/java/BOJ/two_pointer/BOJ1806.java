package BOJ.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BOJ1806 {
    static int N;
    static int S;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        list.add(0,0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> NnS = List.of(br.readLine().split(" "));
        N = Integer.parseInt(NnS.get(0));
        S = Integer.parseInt(NnS.get(1));
        List.of(br.readLine().split(" ")).forEach(i->{
            if(!i.equals(" ")){
                list.add(Integer.parseInt(i));
            }
        });
        sol();
    }

    public static void sol() {
        int right = 0, sum=0, ans = Integer.MAX_VALUE;
        for(int left = 1;left<=N;left++){
            sum -= list.get(left-1);
            while(right+1<=N && sum<S){
                right++;
                sum += list.get(right);
            }
            if(sum>=S){
                ans = Math.min(ans,right-left+1);
            }
        }
        if(ans==Integer.MAX_VALUE){
            ans=0;
        }
        System.out.println(ans);
    }
}
