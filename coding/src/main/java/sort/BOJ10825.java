package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Student> students = new ArrayList<>();
    static StringTokenizer st;
    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        public Student(String name,int korean,int english,int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(this.korean!=o.korean) {
                return o.korean - this.korean;
            }
            if(this.english!=o.english) {
                return this.english - o.english;
            }
            if(this.math!=o.math) {
                return o.math - this.math;
            }
            return name.compareTo(o.name);
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            //공백 문자를 기준으로 문자열 분리
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name,korean,english,math));
        }
    }

    public static void main(String[] args) throws IOException {
        //도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
        //
        //국어 점수가 감소하는 순서로 (내림차순)
        //국어 점수가 같으면 영어 점수가 증가하는 순서로 (오름차순)
        //국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 (내림차순)
        //모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (오름차순) (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
        input();
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.name);
        }
        //12
        //Junkyu 50 60 100
        //Sangkeun 80 60 50
        //Sunyoung 80 70 100
        //Soong 50 60 90
        //Haebin 50 60 100
        //Kangsoo 60 80 100
        //Donghyuk 80 60 100
        //Sei 70 70 70
        //Wonseob 70 70 90
        //Sanghyun 70 70 80
        //nsj 80 80 80
        //Taewhan 50 60 90
    }
}