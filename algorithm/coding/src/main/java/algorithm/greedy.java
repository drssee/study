package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class greedy {
    public static void main(String[] args) {

        //코인
        new greedy().coin(4720, Arrays.asList(500,100,50,1));

        //배낭
        Integer objectList[][] = {{10,10},{15,12},{20,10},{25,8},{30,5}};
        new greedy().knapsack(objectList,30.0);
    }
    public void coin(int n, List<Integer> coinList){
        int total=0;
        int coinCnt=0;
        for(int i=0;i<coinList.size();i++){
            int coin = coinList.get(i);
            coinCnt=n/coin;
            System.out.println(coin+"원 "+coinCnt+"개");
            total += coinCnt;
            n%=coin;
        }
        System.out.println("총 "+total+"개");
    }

    public void knapsack(Integer objectList[][],double capacity){
        double totalValue= 0.0;
        double franction = 0.0;

        Arrays.sort(objectList,new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return ((o1[1]/o1[0])-(o2[1]/o2[0]))*-1;
            }
        });

        for(int i=0;i<objectList.length;i++){
            if((capacity-(double)objectList[i][0])>0){
                capacity -= (double)objectList[i][0];
                totalValue += objectList[i][1];
                System.out.println("무게:"+objectList[i][0]+", 가치:"+objectList[i][1]);
            } else {
                //남아있는 capacity는 최대가치무게의 몇퍼센트인지 계산
                franction = capacity/(double)objectList[i][0];
                //잘라낸 무게만큼 가치도 잘라냄
                totalValue += franction*(double)objectList[i][1];
                System.out.println("무게:"+capacity+", 가치:"+franction*(double)objectList[i][1]);
                break;
            }
        }
        System.out.println("총 가치:"+totalValue);
    }
}
