package brutal_force;

public class N_M {
    //15651
    //1-N,M개
    //중복o
    static int N = 3;
    static int M = 3;
    static int[] selected = new int[M+1];

    public static void main(String[] args) {
        new N_M().rec_func(1);
    }

    public void rec_func(int k){
        if(k==(M+1)){
            for(int i=1;i<selected.length;i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
        } else {
            for(int i=1;i<=N;i++){
                selected[k] = i;
                rec_func(k+1);
            }
        }
    }
}
