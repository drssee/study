//클래스 사용 하지 않고 생성자 함수 사용한 경우
const User = function(name,age){
    this.name = name;
    this.age = age;
    // this.showName = function(){
    //     console.log(this.name);
    // }
};

User.prototype.showName = function(){
    console.log(this.name);
}

const mike = new User('Mike',30);
mike.showName();
console.log('=======');
for(const p in mike){
    console.log(p);
}
console.log('=======');

//클래스로 만들어보기

class User2 {
    //객체를 만들어주는 생성자 메서드
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    //showName은 user2의 프로토타입에 저장됨
    showName(){
        console.log(this.name);
    }
};

const tom = new User2('Tom',19);
tom.showName();
console.log('=======');
for(const p in tom){
    console.log(p);
}
console.log('=======');

//클래스를 사용하는 이유

//1.생성자 함수 사용시
//new 를 실수로 빠트림 
//생성자 함수가 작동안하지만
//User 함수는 문제없이 실행되어 return undefined;
const user1 = User('user1',10);

//2.클래스 사용시
//new 를 실수로 빠트림
//타입에러 발생
try{
    const user2 = User2('user2',20);
} catch(TypeError){
    console.log('TypeError 발생');
}

//클래스 상속, extends

class Car {
    constructor(color) {
        //this = {}
        this.color = color;
        this.wheels = 4;
        //return this;
    }
    drive() {
        console.log('drive');
    }
    stop() {
        console.log('stop')
    }
};

class Bmw extends Car {
    //생성자 오버라이딩
    constructor(color) {
        //this = {} X <- 상속받은 클래스의 생성자는 이과정을 건너뜀
        super(color); // super() 를 호출해 this 할당 작업을 수행
        this.navigation = 1;
        //return this X <- 상속받은 클래스의 생성자는 이과정을 건너뜀
    }
    park() {
        console.log('park');
    }
    drive() {
        console.log('new bmw drive')
    }
    stop() {
        super.stop();
        console.log('new bmw stop');
    }
};

const z4 = new Bmw('blue');
console.dir(z4);
//메소드 오버라이딩
z4.drive();
//메소드 오버라이딩(super 사용)
z4.stop();


