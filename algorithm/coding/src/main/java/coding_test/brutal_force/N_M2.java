package coding_test.brutal_force;

public class N_M2 {
    //15651
    //1-N,M개
    //중복o
    static int N = 3;
    static int M = 3;
    static int[] selected = new int[M+1];
    static int[] used = new int[N+1];

    public static void main(String[] args) {
        new N_M2().rec_func(1);
    }

    public void rec_func(int k){
        if(k==(M+1)){
            for(int i=1;i<selected.length;i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
        } else {
            for(int i=1;i<=N;i++){
                //중복값을 제거하려면
                //별도의 결과저장 배열(자료구조)을 하나 만들어 결과를 저장 후 체크
                if(used[i]==1) continue;
                selected[k] = i;
                used[i] = 1;
                rec_func(k+1);
                used[i] = 0;
            }
        }
    }
}
