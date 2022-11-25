package algorithm;

import java.util.ArrayList;
import java.util.List;

public class nqueen {
    public static void main(String[] args) {
        new nqueen().nqueen_dfs(4,0,new ArrayList<>());
    }

    public void nqueen_dfs(int n, int current_row, List<Integer> current_queens){
        if(current_row==n){
            System.out.println(current_queens);
            return;
        }

        for(int i=0;i<n;i++){
            if(isAvailable(current_queens, i)){
                current_queens.add(i);
                nqueen_dfs(n,current_row+1,current_queens);
                //여기까지 도달 했다는 의미는 current_row==n에 도달하지 못하고,
                //즉 백트래킹이 필요한 시점이라는 의미
                current_queens.remove(current_queens.size()-1);
            }
        }
        System.out.println(current_queens);
    }
    public boolean isAvailable(List<Integer> current_queens,int current_col){
        int current_row = current_queens.size();
        for(int i=0;i<current_row;i++){
            //위치에 놓여진 퀸들을 순회하며 조건 체크
            //(current_queens.get(i)==current_col) <- 수직체크
            //(Math.abs(current_queens.get(i)-current_col)==(current_row-i)) <- 대각체크
            if((current_queens.get(i)==current_col)||(Math.abs(current_queens.get(i)-current_col)==(current_row-i))){
                return false;
            }
        }
        return true;
    }
}
