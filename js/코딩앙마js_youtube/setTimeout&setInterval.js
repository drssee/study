//setTimeout 일정 시간후 실행
//setInterval 일정 시간마다 반복
function fn(){
    console.log(3);
}

let ctl = setTimeout(fn,3000);

//중지
clearTimeout(ctl);

setTimeout(function(n){
    console.log(n);
},3000,'파라미터 위치');

//delay 0 이어도 바로실행 x
//다음줄 실행후 스케줄링

//ex 접속후 1초마다 콘솔창 출력
let n = 1;
function showTime(){
    console.log(`접속한지 ${n++}초가 지났습니다.`);
    if(n>2){
        clearInterval(st);
    }
}

const st = setInterval(showTime,1000);