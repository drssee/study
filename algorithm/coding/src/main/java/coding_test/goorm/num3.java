package coding_test.goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class num3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<String> memos = new ArrayList<>();
    static List<ThreeTf> threeTfs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //날짜 패턴별로 날짜를 비교
        //date 변경후 초단위로 바꿀까??
        //1.2018/7/8
        //2.2018-7-8
        //3.2018년7월8일

        //정규식 적용해 날짜를 추출해야함
        //https://blog.naver.com/PostView.naver?blogId=seek316&logNo=222324190550&parentCategoryNo=&categoryNo=42&viewDate=&isShowPopularPosts=true&from=search

        input();
        sol();
        Collections.sort(threeTfs);
        for (ThreeTf threeTf : threeTfs) {
            System.out.println(threeTf.memo);
        }
    }

    static class ThreeTf implements Comparable<ThreeTf>{
        String memo = "";
        Date regDate;

        public ThreeTf(String memo, Date regDate) {
            this.memo = memo;
            this.regDate = regDate;
        }

        @Override
        public int compareTo(ThreeTf o) {
            return (int) (regDate.getTime()-o.regDate.getTime());
        }
    }

    public static void input() throws IOException {
        for(int i=0;i<3;i++){
            memos.add(br.readLine());
        }
        if(br.readLine().equals("END")){
            return;
        }
    }

    public static void sol(){
        //1. /
        //2. 연 월 일
        //3. -
        for(int i=0;i<3;i++){
            String memo = memos.get(i);
            String year,month,day;
            if(memo.contains("/")){
                int start = memo.indexOf("/");
                int end = memo.lastIndexOf("/");
                year = memo.substring(start-2,start);
                year = "20"+year;
                month = memo.substring(start+1,end);
                day = memo.substring(end+1,end+3);
                if(!(48<=day.charAt(1)&&day.charAt(1)<=57)){
                    day = day.substring(0,1);
                }
                threeTfs.add(new ThreeTf(memo,new Date(
                        Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day)
                )));
            } else if(memo.contains("년")&&memo.contains("월")&&memo.contains("일")){
                int start = memo.indexOf("년");
                int medium = memo.indexOf("월");
                int end = memo.indexOf("일");
                year = memo.substring(start-2,start);
                year = "20"+year;
                month = memo.substring(start+1,medium);
                day = memo.substring(medium+1,end);
                if(!(48<=day.charAt(1)&&day.charAt(1)<=57)){
                    day = day.substring(0,1);
                }
                threeTfs.add(new ThreeTf(memo,new Date(
                        Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day)
                )));
            } else if(memo.contains("-")){
                int start = memo.indexOf("-");
                int end = memo.lastIndexOf("-");
                year = memo.substring(start-2,start);
                year = "20"+year;
                month = memo.substring(start+1,end);
                day = memo.substring(end+1,end+3);
                if(!(48<=day.charAt(1)&&day.charAt(1)<=57)){
                    day = day.substring(0,1);
                }
                threeTfs.add(new ThreeTf(memo,new Date(
                        Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day)
                )));
            }
        }
    }
}
