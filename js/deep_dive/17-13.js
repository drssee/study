//함수는 객체다!
function foo() {

}

//그러므로 프로퍼티 추가 가능
foo.a = 1;

//그러므로 메서드 추가 가능
foo.b = function(){
    console.log('foo`s method');
}

console.log(foo.a);
foo.b();

//함수는 객체지만 일반 객체와 다른 객체다
//1.일반객체의 내부슬롯과 내부메서드를 다 가지고 있다.
//2.하지만 일반객체가 가지고 있지 않은 [[call]] [[construct]]등의 내부슬롯,내부메서드를 가지고 있다.
//3.그로 인해 일반객체는 호출이 불가하지만
//4.함수는 일반함수일때 [[call]], 생성자함수일때 [[construct]] 이용해 동작가능

foo();//[[call]]
const a = new foo();//[[construct]]

//new.target 메타 프로퍼티
//생성자함수
function Circle(radius){
    //이 함수가 new 연산자와 함께 호출되지 않았다면 new.target은 undefined이다

    //new.target이 undefined일때
    if(!new.target){//!undefined -> true
        //인위적으로 new 호출
        return new Circle(radius);
    }
    this.radius = radius;
    this.getDiameter = function(){
        return 2 * this.radius;
    };
}
console.log(!undefined);//true

//new 없이 호출해도 new.target을 이용해 생성자 함수로서 호출됨
const circle = Circle(5);
console.log(circle.getDiameter());

//cf new.target 없이 하는법
function Circle2(radius){
    if(!(this instanceof Circle2)){//this가 circle2나 circle2의 자손이 아니면
        return new Circle(radius);
    }
    this.radius = radius;
    this.getDiameter = function(){
        return 2 * this.radius;
    };
}

const circle2 = Circle2(5);
console.log(circle2.getDiameter());

const test = new Number('5');
console.log(typeof test);//Number object

const test2 = Number('5');
console.log(typeof test2);//5 원시값