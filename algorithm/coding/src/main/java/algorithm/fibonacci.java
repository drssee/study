package algorithm;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println(new fibonacci().fibonacci1(5));
        System.out.println(new fibonacci().fibonacci2(5));
    }

    //재귀호출
    public int fibonacci1(int n){
        if(n==0){
            return n;
        }
        if(n==1){
            return n;
        }
        return fibonacci1(n-1)+ fibonacci1(n-2);
    }

    //동적계획법
    public int fibonacci2(int n){
         if(n<=1){
             return n;
         }
         Integer[] cache = new Integer[n+1];
         cache[0]=0;
         cache[1]=1;
         for(int i=2;i<n+1;i++){
             cache[i]=cache[i-1]+cache[i-2];
         }
         return cache[n];
    }
}
