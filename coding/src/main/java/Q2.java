public class Q2 {
    public static void main(String[] args) {
        System.out.println(new Q2().checkNumber(1221));
    }
    public boolean checkNumber(int x){
        if(x<10){
            return false;
        }
        String num = String.valueOf(x);
        for(int i=0;i< num.length()/2;i++){
            //맨앞과 맨끝부터 비교
            int start = i;
            int end = num.length()-i-1;
            if(num.charAt(start)!=num.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
