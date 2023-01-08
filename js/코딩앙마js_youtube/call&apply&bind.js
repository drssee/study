//call(this값,...call대상함수의 가변인자)
const mike = {
    name: "Mike"
};

const tom = {
    name: "Tom"
};

function showthisName(){
    console.log(this.name);
}

showthisName();//window.name = ''
showthisName.call(mike);//mike.name
showthisName.call(tom);//tom.name

function update(birthYear, occupation){
    this.birthYear = birthYear;
    this.occupation = occupation;
};

update.call(mike,1999,'singer');
console.log(mike);

update.call(tom,2002,'teacher');
console.log(tom);

//apply(this값,배열)
update.apply(mike,[2000,'singer2']);
console.log(mike);
update.apply(tom,[2003,'teacher2']);
console.log(tom);

//ex nums배열을 math.max, math.min 함수에 넣기
//그냥 배열로 넣으면 숫자대신 배열객체가 들어온거라 NaN
let nums = [1,2,3,4,5];
// console.log(Math.max(...nums));
// console.log(Math.min(...nums));

//apply 사용
//this가 필요하지 않으면 null
console.log(Math.max.apply(null,nums));
console.log(Math.min.apply(null,nums));

//bind(this),this값을 영구히 바꿀수 있습니다
const updateMike = update.bind(mike,1999,'singer');
updateMike();
console.log(mike);

//ex
const user = {
    name: "Mike",
    showName: function(){
        console.log(`hello, ${this.name}`);
    }
};

user.showName();
//this가 실행되는 곳이 user객체 밖이라 this를 잃어버림
let fn = user.showName;
fn();
//bind로 this를 고정시키면 해결 가능
fn = user.showName.bind(user);
fn();

//fn에 바인딩을 해도 결과는 같음
let boundFn = fn.bind(user);
boundFn();


