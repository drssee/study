//Object 메소드,computed 프로퍼티

//computed 프로퍼티
let n = "name";
let a = "age";
let temp = "temp";

const user = {
    [n]:'mike',
    [a]:30,
    //프로퍼티 값에 computed 프로퍼티 적용x , 배열리터럴로 인식
    test:[temp],
    [1+4]:5
};

console.log(user);

function makeObj(key,val){
    return{
        [key] : val
    }
}

const obj = makeObj('나이',33);

console.log(obj);

//Ojbect 메소드
const user2 = user; //식별자 user의 객체 메모리 주소 참조값 복사후 user2 값에 할당(같은참조값)

//true
console.log(user===user2);

// const user3 = Object.assign({},user,{newProperty: 'new'});
const user3 = Object.assign({},user);

//false
console.log(user===user3);

//그러므로 user3의 프로퍼티 값을 변경해도 user 엔 영향x
user3.name='user3_updated';

const keyResult = Object.keys(user);
console.log(keyResult);

const valueResult = Object.values(user);
console.log(valueResult);

const entryResult = Object.entries(user);
console.log(entryResult);

let arr = [
    ['mon','월'],
    ['tue','화']
]

//arr[i]의 arr
const from = Object.fromEntries(arr);
