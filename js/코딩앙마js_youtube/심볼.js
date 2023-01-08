//심볼 유니크값 Symbol('id') , 'id'는 주석같은것
//Symbol.for('id') , 전역심볼

//다른 개발자가 만들어 놓은 객체
 const user = {
    name: 'MIKE',
    age: 30
 };

//다른사람의 코드에 임의의 프로퍼티 추가시 기존 코드와 충돌 문제가 생김
// user.showName = function(){console.log(this.name)};

//심볼을 생성 후 객체의 프로퍼티로 등록
const showName = Symbol('showName');

//심볼을 객체의 프로퍼티 키로 사용
user[showName] = function(){
    console.log(this.name);
};

//심볼 사용 , 심볼을 user.showName으로 접근 불가능
user[showName]();

 //사용자가 접속하면 보는 메시지
 for(let key in user){
    console.log(`His ${key} is ${user[key]}.`);
 }
