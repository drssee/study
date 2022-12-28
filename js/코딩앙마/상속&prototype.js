//prototype
//__proto__(일반객체), .prototype(생성자함수)

const user = {
    name: 'Mike'
}
console.log(user);
//브라우저 환경에서 구동해야함
//user객체먼저 탐색후 prototype에서 프로퍼티 검색
user.hasOwnProperty('name');//true
user.hasOwnProperty('age');//false

//프로토 타입을 이용한 상속관계 설정
const car = {
    wheels: 4,
    drive(){
        console.log("drive"); 
    }
}

const bmw = {
    color: 'red',
    // wheels: 4,
    navigation: 1,
    // drive(){
    //     console.log("drive..");
    // }
};
bmw.__proto__=car;

const benz = {
    color: 'black',
    // wheels: 4,
    // drive(){
    //     console.log("drive..");
    // }
};
benz.__proto__=car;

const audi = {
    color: 'blue',
    // wheels: 4,
    // drive(){
    //     console.log("drive..");
    // },
};
audi.__proto__=car;

console.log(bmw);//color,navigation
console.log(bmw.wheels);//bmw+wheels,drive()

//상속은 계속 이어질 수 있음
const x5 = {
    color: 'white',
    name: 'x5',
};

x5.__proto__=bmw;
 
//x5->bmw->car (프로퍼티 체인)
x5.drive();

//ex 프로퍼티 체인
for(p in x5){
    console.log(p);
}

for(p in x5){
    let isOwnProperty;
    if(x5.hasOwnProperty(p)){
        isOwnProperty = 'O';
    } else {
        isOwnProperty = 'X';
    }
    console.log(isOwnProperty+' '+p);
}

//.prototype
//ex car를 상속받은 bmw를, x6 생성자 함수로 만들기
const car2 = {
    wheels: 4,
    drive: function(){
        console.log('drive...');
    }
}

const Bmw2 = function(color){
    this.color = color
}

// const x6 = new Bmw2('blue');
// x6.__proto__=car2;
// console.log(x6);

//생성자 함수 사용시 __proto__대신 전용프로퍼티인 Bmw2.prototype 사용가능
Bmw2.prototype.wheels = 4;
Bmw2.prototype.drive = function(){
    console.log('drive...');
}

const x7 = new Bmw2('red');
console.log(x7);

//확인하는법
console.log(x7 instanceof Bmw2);//true
//x7의 생성자가 Bmw2를 가리키고 있다
console.log(x7.constructor === Bmw2);//true



//ex 클로저 이용해 private 하게 만들기
const Bmw3 = function(color){
    //this = {}
    const c = color;
    this.getColor = function(){
        //상위 스코프의 매개변수 참조
        console.log(c);
    };
    //return this;
    //this = {getColor: f()}
};

const x8 = new Bmw3('red');//return this = {getColor: f()}
// x8.c; //참조할 길이 없어진 상위 스코프의 매개변수
x8.getColor();
 

