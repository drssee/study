import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3273 {
    public int n;
    public List<Integer> numbers = new ArrayList<>();
    public int x;

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = new String[100];
        for(int i=0;i<3;i++){
            if(i==0) n = Integer.parseInt(br.readLine());
            else if(i==1) {
                tmp = br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    numbers.add(Integer.valueOf(tmp[j]));
                }
            }
            else {
                x = Integer.parseInt(br.readLine());
            }
        }
    }

    public int boj3237(){
        int result = 0;
        int sum = 0;
        Collections.sort(numbers);
        int L = 0;
        int R = numbers.size()-1;
        while(L<R){
            sum = numbers.get(L) + numbers.get(R);
            //가장작은수와 가장큰수를 더했는데 x일경우 결과 갱신
            if(sum == x) {
                result++;
                L++;
            }

            //가장작은수와 가장큰수를 더했는데 x보다 작을경우
            //L++ , 가장작은수 왼쪽은 볼필요도 없다(가장큰수를 더해도 안되는데 가장작은수보다 작은쪽은 의미가 없다)
            else if(sum < x) L++;

            //가장작은수와 가장큰수를 더했는데 x보다 클경우
            //R-- , 가장큰수 오른쪽은 볼필요도 없다(가장작은수를 더해도 넘는데 더큰수를 더해봐야 똑같다)
            else if(sum > x) R--;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BOJ_3273 boj_3273 = new BOJ_3273();
        boj_3273.input();
        int boj_3273_result = boj_3273.boj3237();
        System.out.println(boj_3273_result);
    }
}
