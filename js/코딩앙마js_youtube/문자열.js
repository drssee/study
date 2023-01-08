//문자열 접근과, 접근후 다른값 할당해도 변경 안되는 이유
// console.log(desc.length); //tdz
let desc = '안녕하세요.'
console.log(desc.length);
//배열처럼 인덱스로 접근 가능
console.log(desc[2]);
//하지만 재할당은 안됨, 문자열은 불변값이기 때문
desc[2]='용';
console.log(desc[2]);

//indexof 사용시 주의사항
//이 코드는 작동 안됨
//desc.indexOf('안')==0
//0은 falsy값 중 하나(0,'',null,undefined,NaN,false)
if(desc.indexOf('안')){
    console.log('"안"이 포함된 문장입니다.');
}
//수정
if(desc.indexOf('안')>-1){
    console.log('"안"이 포함된 문장입니다.');
}

//desc.slice(fron,to) , from ~ to
//slice 활용 (-n) n>=1
//desc 에서 '녕하세' -n 이용해서 slice
console.log(desc.slice(1,-2));

//substring(n,m) , n과 m사이
console.log(desc.substring(1,4));

//substr(n,m) , n부터 m개 ,//deplecated
// console.log(desc.substr(1,3));

//repeate(n) 문자열 n번반복
console.log(desc.repeat(3));

//문자열 비교
console.log('a'>'A');
console.log('aA'.codePointAt(0));
console.log('aA'.codePointAt(1));

//ex , list배열에서 글자만 추출
let list = [
    "01. 들어가며",
    "02. JS의 역사",
    "03. 자료형",
    "04. 함수",
    "05. 배열" 
];

let result = [];

for(let i = 0;i<list.length;i++){
    result.push(list[i].slice(4).trim());
};

console.log(result);

//함수 선언문은 평가 단계에서 호이스팅후 함수객체 생성, 
//그리고 함수 이름으로 임의의 식별자 변수를 만들어 할당
checkKoke('와 사이다!'); //-1
checkKoke('와 콜라!'); //2
checkKoke('콜라'); //0

// 금칙어 : 콜라 메서드1
function checkKoke(str){
    let prohibition = '콜라';
    //첫문자열에 콜라가 있을시 indexof == 0
    //0 == falsy
    if(str.indexOf(prohibition)>-1){
        console.log(prohibition+' 은 금칙어입니다.');
        return;
    }
    console.log(str+'은 통과입니다.');
}

checkKoke_upgraded('와 사이다!');
checkKoke_upgraded('와 콜라!');
checkKoke_upgraded('콜라');

// 금칙어 : 콜라 메서드2
function checkKoke_upgraded(str){
    let prohibition = '콜라';
    if(str.includes(prohibition)){
        console.log(prohibition+' 은 금칙어입니다.');
        return;
    }
    console.log(str+'은 통과입니다.');
}

 