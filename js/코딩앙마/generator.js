//generator 함수의 실행을 중간에 멈췄다가 재개할 수 있는 기능
// function* name(){
//     yield 'value';
// }

function* fn(){
    try{
        yield 1;
        yield 2;
        yield 3;
        return "finish";
    } catch (e) {
        console.log(e); 
    } 
}

const a = fn();
//next로 통제 가능
// a.next();
// console.log(a);
// a.next();
// console.log(a);
// a.next();
// console.log(a);

// a[Symbol.iterator]() === a;//true
// for(let num of a){
//     console.log(num);
// }

function* fn2(){
    const num1 = yield "첫번째 숫자를 입력해주세요"; //a.next();
    console.log(num1);

    const num2 = yield "두번째 숫자를 입력해주세요"; //a.next();
    console.log(num2);

    return num1 + num2;
}

const a2 = fn2();

//ex 요청할때마다 +1된 값을 리턴하는 함수를 generator를 이용해 만들기
let num = 0;
function* fn3(){
    while(true){
        yield num++;
    }
};

const a3 = fn3();

function* gen1(){
    yield 'W';
    yield 'o';
    yield 'r';
    yield 'l';
    yield 'd';
}

function* gen2(){
    yield 'Hello,';
    yield* gen1();
    yield '!';
}

//done === true가 될때까지 순회
console.log(...gen2());

setTimeout(()=>{
    console.clear();
},1000);
