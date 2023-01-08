function showName(name) { //js의 매개변수와 인자가 일치하지 않아도 오류x
    console.log(name);
}
showName();//undefined
showName('Mike','Tome');//mike

//arguments(인자)
//함수로 넘어 온 모든 인자에 접근
//함수내에서 이용 가능한 지역 변수
//length/index
//array형태의 객체
//배열내장메서드x(forEach,map)
function showName2(name){
    console.log(arguments.length);//2
    console.log(arguments[0]);//mike
    console.log(arguments[1]);//tom
    console.log(arguments[2]);//undefiend
}
showName2('Mike','Tom');

//나머지 매개변수(가변인자)
function showName3(...names){
    console.log(names);
}
showName3();//[]
showName3('Mike');//['mike']
showName3('Mike','Tom');//['tom']

//ex 전달된 인자의 수에 관계없이, 모든 인자를 더한값을 리턴하는 함수
function sum(...nums){
    return nums.reduce((acc,cur)=>{
        return acc+cur;
    })
}
console.log(sum(1,2,3));
console.log(sum(1,2,3,4,5,6,7,8,9,10));

//ex 나머지 매개변수이용 user객체를 만들어 주는 생성자 함수 생성
function User(name,age,...skills){//가변인자는 마지막에
    //this = {};
    this.name=name;
    this.age=age;
    this.skills=skills;
    //return this;
}
const user1 = new User('name1',10,'skill1','skill2');
const user2 = new User('name2',20);
const user3 = new User('name3',30,'skill1','skill2','skill3');
console.log(user1);
console.log(user2);
console.log(user3);

//전개구문:배열
let arr1 = [1,2,3];
let arr2 = [4,5,6];
let result = [...arr1,...arr2];
let result2 = [0,...arr1,...arr2,7];
console.log(result);
console.log(result2);

//전개구문:복제
arr1 = [1,2,3];
arr2 = [...arr1];//[1,2,3]

let user4 = {name:'Mike',age:30};
let user5 = {...user4};
user5.name = 'Tom';
console.log(user4);
console.log(user5);//user4를 복제해 user5로 할당,깊은복사?,Object.assign(초기값{},복사할객체)
console.log(user4===user5);//false

let test = {};
let test2 = test;
let test3 = test;
console.log(test===test2);//true, 객체 참조값만 복사해 할당과 다름

//ex arr1 을 [4,5,6,1,2,3] 으로
arr1 = [1,2,3];
arr2 = [4,5,6];

// arr2.forEach(num=>{
//     //4,5,6순으로 배열의 0번에 들어가기 때문에 x
//     arr1.unshift(num);
// });

//해결법 arr.reverse()이용
arr2.reverse().forEach(num=>{
    arr1.unshift(num);
});

// arr1 = [...arr2,...arr1];

console.log(arr1);

//ex 하나의 객체로 합치기
user = {name:'Mike'};
let info = {age:30};
let fe = ["js","React"];
let lang = ["Korean","English"];

// user = Object.assign({},user,info,{skills:[]});
// fe.forEach(item=>{user.skills.push(item)});
// lang.forEach(item=>{user.skills.push(item)});

// user.skills=[...fe,...lang];

user = {...user,...info,skills:[...fe,...lang]};

console.log(user);


