//Closure
//함수와 렉시컬 스코프의 조합

//외부함수 호출시(외부함수객체를 생성 후 실행) 외부함수의 매개변수를
//내부리턴함수가 참조(외부함수의 참조값을 사용) 
//외부함수는 리턴후 종료 되어도 
//내부리턴함수가 여전히 (외부함수의 참조값을 사용) 하기 때문에 GC작동 X
//외부코드에선 더이상 참조할 수 없지만,내부 함수에선 private 값처럼 참조 가능 

//전역 렉시컬 스코프 생성
 function makeAdder(x) {
    return function(y){
        return x+y;
    }
 }
//내부 makeAdder(3) 렉시컬 스코프 생성
//내부 makeAdder(3)의 리턴function의 렉시컬 스코프 생성
 const add3 = makeAdder(3);
 console.log(add3(2));
 //내부 makeAdder(10) 렉시컬 스코프 생성
 //내부 makeAdder(10)의 리턴function의 렉시컬 스코프 생성
 const add10 = makeAdder(10);
 console.log(add10(5));
 
//ex
function outer1(){
    let n = 1; //private 처럼 사용 가능
    return function(){
        return ++n;
    }
}

//n을 참조할 방법 없음
const o1 = outer1();
console.log(o1());//2
console.log(o1());//3
console.log(o1());//4
console.log(o1());//5

//새로운 outer1 함수를 만들면 n은 독립적
const o2 = outer1();
console.log(o2());//2
console.log(o2());//3








