package programmers;

class num1 {
    public void solution(){
        int n = 1000000;
        int count = 0;
        for(int j=1;j<=Math.sqrt(n);j++){
            if(n%j==0){
                if(n/j==j){
                    count++;
                }
                else {
                    count+=2;
                }
            }
        }
    }
}