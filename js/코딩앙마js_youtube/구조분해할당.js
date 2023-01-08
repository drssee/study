//배열 구조분해

let [x,y] = [1,2];
console.log(x);
console.log(y);

let users = ['Mike','Tom','Jane'];
let [user1,user2,user3] = users;
console.log(user1);
console.log(user2);
console.log(user3);

let users_str = 'Mike,Tome,Jane';
let [users_str1,users_str2,users_str3] = users_str.split(',');
console.log(users_str1);
console.log(users_str2);
console.log(users_str3);

//값의 숫자가 다를때
let [a,b,c] = [1,2];
//a==1,b==2,c==undefined

//undefined 대신 기본값을 넣을 수 있음
[a=3,b=4,c=5] = [1,2];
console.log(a);//1
console.log(b);//2
console.log(c);//5

//필요하지 않은 요소 무시하기
[user1, ,user3] = ['Mike','Tom','Jane','Tony'];
console.log(user1);//Mike
console.log(user3);//Jane

//tmp변수 만들지 않고 두 변수값 교체하기
a=1,b=2;
[a,b]=[b,a];
console.log(a);//2
console.log(b);//1

//객체 구조분해

let user = {name:'Mike',age:30};
console.dir(user);
var {name,age} = user;
console.log(name);//mike
console.log(age);//30
//순서를 바꾼다면?ok
//이름을 바꾼다면?no
var {age,name} = user;
console.log(age);//30
console.log(name);//mike
var {e,f} = user;
console.log(e);//undefined
console.log(f);//undefined
//이름을 바꾸고 싶다면?
var {name: e,age: f} = user;
console.log(e);//mike
console.log(f);//30

//객체 구조분해도 기본값 할당 가능
var {name,age,gender='정의하지 않음'} = user;
console.log(name);
console.log(age);
console.log(gender);