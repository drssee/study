//객체 확장금지(add X)
const person = {name:'Lee'};

//person 객체는 확장이 금지된 객체가 아니다
Object.isExtensible(person);//true

//person 객체의 확장을 금지하여 프로퍼티 추가를 금지한다
Object.preventExtensions(person);

//person 객체는 확장이 금지된 객체다
Object.isExtensible(person);//false

//프로퍼티 추가가 금지된다
person.age = 20;
console.log(person);//age추가 x

//프로퍼티 추가는 금지되지만 삭제는 가능하다
delete person.name;
console.log(person);

//프로퍼티 정의에 의한 프로퍼티 추가도 금지된다
// Object.defineProperty(person,'age',{
//     value:25,
//     enumerable: true,
//     writable: true,
//     configurable: true
// }); //에러발생
