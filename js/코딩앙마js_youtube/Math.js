//소숫점 n번째 자리에서 반올림하기
//30.1234 를 소숫점 5번째 자리에서 반올림
let a = 30.123456;
//1
let result_a1 = (Math.round(a*10000))/10000;
console.log(result_a1);
//2 변수명.toFixed(n) 활용
let result_a2 = a.toFixed(4);
console.log(result_a2+' a.toFixed(n-1)의 결과는 문자열');

//parseInt와 Number의 차이
console.log(Number('12x'));
console.log(parseInt('12x'));

//parseInt 진수변환
console.log(parseInt('f12',16));

//parseFloat과 차이점
let padding = '18.5%';
console.log(parseInt(padding));
console.log(parseFloat(padding));

//random (2~100)
console.log(parseInt((Math.random()*98)+2));
console.log(Math.floor((Math.random()*98)+2));

//Math.max() Math.min Math.abs()

//Math.pow(n,m) 제곱
console.log(Math.pow(2,4));

//Math.sqrt(n) 제곱근
console.log(Math.sqrt(16));



