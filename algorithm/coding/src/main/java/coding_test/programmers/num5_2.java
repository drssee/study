package coding_test.programmers;

public class num5_2 {

    public static void main(String[] args) {
//        int[] ingredient = new int[]{1,2,3,1};
        int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
//        int[] ingredient = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 3, 3, 3, 3, 1, 2, 3, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 2, 3, 3, 3, 1};
//        int[] ingredient = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 2, 2, 3, 3, 3, 1};
        System.out.println("result = "+new num5_2().solution(ingredient));
    }

    public int solution(int[] ingredient) {
        int answer = 0;
        answer = hamburger(ingredient);
        return answer;
    }

    public int hamburger(int[] ingredient){
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ingredient.length;i++){
            sb.append(ingredient[i]);
            if(sb.length()>3&&sb.subSequence(sb.length()-4,sb.length()).equals("1231")){
                System.out.println("dfdfdf");
                sb.delete(sb.length()-4,sb.length());
                result++;
            }
        }
        return result;
    }
}
