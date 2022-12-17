package algorithm;

public class n_factorial {
    public static void main(String[] args) {
        System.out.println(new n_factorial().nFactorial(5));
        System.out.println(new n_factorial().nFactorial2(5));
    }
    public int nFactorial(int n){
        if(n==1){
            return n;
        }
        return n*nFactorial(n-1);
    }

    //1,2,3으로 표현할 수 있는 자릿수
    public int nFactorial2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        return nFactorial2(n-1)+nFactorial2(n-2)+nFactorial2(n-3);
    }
}
