function Circle(radius){
    //new 연산자로 생성되는 생성자 함수는
    //평가 단계에서 식별자 this 호이스팅후
    //this에 생성자함수 이름의 빈객체를 생성후 바인딩한다
    console.log(this);//Circle {}
    this.radius = radius;
    this.getDiameter = function(){
        return 2* this.radius;
    }
};

const circle1 = new Circle(5);
const circle2 = new Circle(10);
console.log(circle1.getDiameter());
console.log(circle2.getDiameter());

//cf this바인딩
//일반함수 = > 전역객체
//메소드 = > 호출한객체
//생성자함수 = > 미래에 생성할객체

function foo(){
    console.log(this);
}

// foo();//this == window,global

const obj = {foo};

// foo();//될까?OK

obj.foo();//obj

const obj2 = new foo();//obj2

//ex
const circle3 = Circle(15);//일반 함수로써 정의됨
//circle3안의 this.radius는 window.radius가 되어 참조 가능해짐
console.dir(circle3);//Circle(15)의 리턴값은 undefiend, new X
console.dir(global);
console.log(radius===global.radius);//true

